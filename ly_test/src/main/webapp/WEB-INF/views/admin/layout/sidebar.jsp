<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tilesx:useAttribute id="menus" name="menus" classname="java.util.List" />

<div class="page-sidebar-wrapper">
    <!-- END SIDEBAR -->
    <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
    <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
    <div class="page-sidebar navbar-collapse collapse">
        <!-- BEGIN SIDEBAR MENU -->
        <!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
        <!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
        <!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
        <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
        <!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
        <!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
        <ul class="page-sidebar-menu  page-header-fixed page-sidebar-menu-hover-submenu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
	        <c:forEach items="${menus}" var="entity">
				
				<li id="menu_li_${entity.menuId }" class="nav-item">
	                <a href="javascript:;" class="nav-link nav-toggle">
	                    <i class="${entity.icon }"></i>
	                    <span class="title">${entity.name }</span>
	                    <span class="selected"></span>
	                    <span class="arrow open"></span>
	                </a>
	                <ul class="sub-menu">
	                	<c:forEach items="${entity.list}" var="sub">
	                    <li class="nav-item" id="sub_li_${sub.menuId}">
	                        <a href="<c:url value="${sub.url }" />" class="nav-link ">
	                            <i class="${sub.icon }"></i>
	                            <span class="title">${sub.name}</span>
	                            <span class="selected"></span>
	                        </a>
	                    </li>
	                    </c:forEach>
	                </ul>
	            </li>
	
			</c:forEach>
		
		</ul>
        <!-- END SIDEBAR MENU -->
    </div>
    <!-- END SIDEBAR -->
</div>
<!-- END SIDEBAR -->