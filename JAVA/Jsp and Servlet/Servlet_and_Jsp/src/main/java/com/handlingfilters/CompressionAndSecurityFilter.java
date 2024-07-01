package com.handlingfilters;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Servlet Filter implementation class CompressionAndSecurityFilter
 */
@WebFilter("/Pr2")
public class CompressionAndSecurityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CompressionAndSecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Add security headers
        httpResponse.setHeader("X-Frame-Options", "DENY");
        httpResponse.setHeader("X-Content-Type-Options", "nosniff");
        httpResponse.setHeader("X-XSS-Protection", "1; mode=block");
        httpResponse.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");

        // Check if the client accepts GZIP encoding
        String acceptEncoding = httpRequest.getHeader("Accept-Encoding");
        if (acceptEncoding != null && acceptEncoding.contains("gzip")) {
            // Wrap the response to compress the content
            GZIPResponseWrapper wrappedResponse = new GZIPResponseWrapper(httpResponse);
            chain.doFilter(request, (ServletResponse) wrappedResponse);
            wrappedResponse.finishResponse();
        } else {
            // Proceed without compression
            chain.doFilter(request, response);
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	
	private static class GZIPResponseWrapper extends HttpServletResponseWrapper {
        private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        private GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        private ServletOutputStream servletOutputStream;
        private PrintWriter printWriter;

        public GZIPResponseWrapper(HttpServletResponse response) throws IOException {
            super(response);
            response.setHeader("Content-Encoding", "gzip");
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            if (printWriter != null) {
                throw new IllegalStateException("PrintWriter obtained already - cannot get OutputStream");
            }
            if (servletOutputStream == null) {
                servletOutputStream = new ServletOutputStream() {
                    @Override
                    public void write(int b) throws IOException {
                        gzipOutputStream.write(b);
                    }

                    @Override
                    public void flush() throws IOException {
                        gzipOutputStream.flush();
                    }

                    @Override
                    public void close() throws IOException {
                        gzipOutputStream.close();
                    }

					@Override
					public boolean isReady() {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public void setWriteListener(WriteListener arg0) {
						// TODO Auto-generated method stub
						
					}
                };
            }
            return servletOutputStream;
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            if (servletOutputStream != null) {
                throw new IllegalStateException("OutputStream obtained already - cannot get PrintWriter");
            }
            if (printWriter == null) {
                printWriter = new PrintWriter(gzipOutputStream, true);
            }
            return printWriter;
        }

        public void finishResponse() throws IOException {
            if (printWriter != null) {
                printWriter.close();
            } else if (servletOutputStream != null) {
                servletOutputStream.close();
            }

            byte[] bytes = byteArrayOutputStream.toByteArray();

            // Write the compressed response
            HttpServletResponse response = (HttpServletResponse) getResponse();
            response.addHeader("Content-Length", String.valueOf(bytes.length));
            response.getOutputStream().write(bytes);
        }
	}

}
