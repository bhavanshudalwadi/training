package com.securitymeasures;

import java.io.IOException;
import java.text.Normalizer;
import java.util.*;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@WebFilter("/CrossSiteScripting")
public class CrossSiteScripting implements Filter {
	class CssRequestWrapper extends HttpServletRequestWrapper {
		private Map<String, String[]> sanitizedQueryString;
		
		public CssRequestWrapper(HttpServletRequest request) {
			super(request);
		}
		
		//QueryString overrides
		
		@Override
		public String getParameter(String name) {
			String parameter = null;
			String[] vals = getParameterMap().get(name); 
			
			if (vals != null && vals.length > 0) {
				parameter = vals[0];
			}
			
			return parameter;
		}

		@Override
		public String[] getParameterValues(String name) {
			return getParameterMap().get(name);
		}
		
		@Override
		public Enumeration<String> getParameterNames() {
			return Collections.enumeration(getParameterMap().keySet());
		}

		@SuppressWarnings("unchecked")
		@Override
		public Map<String,String[]> getParameterMap() {
			if(sanitizedQueryString == null) {
				Map<String, String[]> res = new HashMap<String, String[]>();
				Map<String, String[]> originalQueryString = super.getParameterMap();
				if(originalQueryString!=null) {
					for (String key : (Set<String>) originalQueryString.keySet()) {
						String[] rawVals = originalQueryString.get(key);
						String[] snzVals = new String[rawVals.length];
						for (int i=0; i < rawVals.length; i++) {
							snzVals[i] = stripXSS(rawVals[i]);
							System.out.println("Sanitized: " + rawVals[i] + " to " + snzVals[i]);
						}
						res.put(stripXSS(key), snzVals);
					}
				}
				sanitizedQueryString = res;
			}
			return sanitizedQueryString;
		}

		private String stripXSS(String value) {
			String cleanValue = null;
			if (value != null) {
				cleanValue = Normalizer.normalize(value, Normalizer.Form.NFD);

				// Avoid null characters
				cleanValue = cleanValue.replaceAll("\0", "");
				
				// Avoid anything between script tags
				Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
				cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");
		 
				// Avoid anything in a src='...' type of expression
				scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

				scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");
				
				// Remove any lonesome </script> tag
				scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
				cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

				// Remove any lonesome <script ...> tag
				scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");

				// Avoid eval(...) expressions
				scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");
				
				// Avoid expression(...) expressions
				scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");
				
				// Avoid javascript:... expressions
				scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
				cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");
				
				// Avoid vbscript:... expressions
				scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
				cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");
				
				// Avoid onload= expressions
				scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				cleanValue = scriptPattern.matcher(cleanValue).replaceAll("");
			}
			return cleanValue;
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("CrossSiteScripting Is Applied");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
