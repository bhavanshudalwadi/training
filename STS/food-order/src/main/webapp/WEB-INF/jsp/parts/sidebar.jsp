<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
      <div class="nano">
        <div class="nano-content">
          <div class="logo text-white my-3">FOOD ORDER</div>
          <ul>
            <li><a href="/"><i class="ti-home"></i>Dashboard</a>
            </li>
            
			<c:if test="${userRole != null && userRole.equals('ADMIN')}">
	            <li class="label">Admin Features</li>
	            <li>
	            	<a href="#">
	            		<i class="ti-location-arrow"></i>
	            		<span onClick="window.location.href='/city/list'">Manage City</span>
	           			<span class="sidebar-collapse-icon ti-plus" onClick="window.location.href='/city/add'"></span>
	        		</a>
	       		</li>
	       		<li>
	            	<a href="#">
	            		<i class="ti-pin"></i>
	            		<span onClick="window.location.href='/area/list'">Manage Area</span>
	           			<span class="sidebar-collapse-icon ti-plus" onClick="window.location.href='/area/add'"></span>
	        		</a>
	       		</li>
	       		<li>
	            	<a href="#">
	            		<i class="ti-view-list"></i>
	            		<span onClick="window.location.href='/category/list'">Manage Category</span>
	           			<span class="sidebar-collapse-icon ti-plus" onClick="window.location.href='/category/add'"></span>
	        		</a>
	       		</li>
	       		<li>
	            	<a href="#">
	            		<i class="ti-view-list-alt"></i>
	            		<span onClick="window.location.href='/sub-category/list'">Manage Sub Category</span>
	           			<span class="sidebar-collapse-icon ti-plus" onClick="window.location.href='/sub-category/add'"></span>
	        		</a>
	       		</li>
	       		<li><a href="/restaurant-list"><i class="ti-layers"></i>Manage Restaurant</a></li>
	       		<li><a href="/complaint/admin-list"><i class="ti-view-list"></i>Manage Complaint</a></li>
			</c:if>
			<c:if test="${userRole != null && userRole.equals('RESTAURANT')}">
	            <li class="label">Restaurant Features</li>
	            <li>
	            	<a href="#">
	            		<i class="ti-view-list"></i>
	            		<span onClick="window.location.href='/product/list'">Manage Products</span>
	           			<span class="sidebar-collapse-icon ti-plus" onClick="window.location.href='/product/add'"></span>
	        		</a>
	       		</li>
	       		<li>
	            	<a href="#">
	            		<i class="ti-view-list-alt"></i>
	            		<span onClick="window.location.href='/offer/list'">Manage Offers</span>
	           			<span class="sidebar-collapse-icon ti-plus" onClick="window.location.href='/offer/add'"></span>
	        		</a>
	       		</li>
	       		<li>
	            	<a href="#">
	            		<i class="ti-layers"></i>
	            		<span onClick="window.location.href='/complaint/list'">Manage Complaint</span>
	           			<span class="sidebar-collapse-icon ti-plus" onClick="window.location.href='/complaint/add'"></span>
	        		</a>
	       		</li>
	            <li><a href="/feedback/list"><i class="ti-thumb-up"></i>Manage Feedback</a></li>
			</c:if>
            <li class="label">Other</li>
            <li><a href="/logout"><i class="ti-close"></i> Logout</a></li>
          </ul>
        </div>
      </div>
    </div>