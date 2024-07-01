<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<style>
	.employee-sidebar {
       	position: absolute;
	    top: 23px;
	    /* left: 0; */
	    bottom: 0;
	    width: 100%;
	    background: #343957;
	    /* font-size: 14px; */
	    z-index: 100;
	    overflow: auto;
	    -webkit-transform: translateZ(0);
	    transform: translateZ(0);
	    -webkit-transition: width 300ms ease-in-out;
	    transition: width 300ms ease-in-out;
        box-shadow: none;
        border-radius: 40px;
	}
	.sidebar-sub-toggle {
		border-radius: 15px;
	}
	.inner-list li a {
		border-radius: 15px;
	}
</style>
<div class="sidebar employee-sidebar p-4">
      <div class="nano">
        <div class="nano-content">
          <ul>
            <li class="open">
            	<a class="sidebar-sub-toggle">
            		<i class="ti-user"></i><span>Employee Information<span class="sidebar-collapse-icon ti-angle-down"></span>
           		</a>
          		<ul class="inner-list">
             		<li><a href="/emp/addEmployee"><i class="ti-user"></i>Employee</a></li>
             		<li><a href="/emp/addPersonalInfo/${emp != null?emp.id:''}"><i class="ti-view-list"></i>Personal</a></li>
             		<li><a href="/emp/addContactDetails/${emp != null?emp.id:''}"><i class="ti-email"></i>Contact</a></li>
             		<li><a href="/emp/addFamilyDetails/${emp != null?emp.id:''}"><i class="ti-face-smile"></i>Family</a></li>
           		</ul>
       		</li>
       		<li class="">
            	<a class="sidebar-sub-toggle">
            		<i class="ti-user"></i><span>Employment <span class="sidebar-collapse-icon ti-angle-down"></span>
           		</a>
          		<ul class="inner-list">
             		<li><a href="/emp/addEmployee">Allowance Declaration</a></li>
             		<li><a href="/emp/addPersonalInfo">Job</a></li>
             		<li><a href="/emp/addContactInfo">Reporting Officer</a></li>
             		<li><a href="/emp/addFamilyInfo">Previous Employment</a></li>
           		</ul>
       		</li>
       		<li class="">
            	<a class="sidebar-sub-toggle">
            		<i class="ti-user"></i><span>Qualification <span class="sidebar-collapse-icon ti-angle-down"></span>
           		</a>
          		<ul class="inner-list">
             		<li><a href="/emp/addEmployee">Education Qualification</a></li>
           		</ul>
       		</li>
          </ul>
        </div>
      </div>
    </div>