<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
      <div class="nano">
        <div class="nano-content">
          <div class="logo my-3">
          	<a href="/"><img class="icon" src="/assets/images/sttl-icon.png" alt=""/></a>
          </div>
          <ul>
            <li>
            	<a href="#">
            		<i class="ti-user"></i>
            		<span onClick="window.location.href='/emp/list'">Employee Information</span>
           			<span class="sidebar-collapse-icon ti-plus" onClick="window.location.href='/emp/addEmployee'"></span>
        		</a>
       		</li>
            <li class="label">Other</li>
            <li><a href="/logout"><i class="ti-close"></i> Logout</a></li>
          </ul>
        </div>
      </div>
    </div>