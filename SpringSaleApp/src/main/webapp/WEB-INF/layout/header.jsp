<%-- 
    Document   : header
    Created on : Jul 21, 2024, 11:18:24 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">e-Commerce Admin</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Trang chủ</a>
                </li>
                <c:forEach items="${cates}" var="c">
                    <c:url value="/" var="cateUrl">
                        <c:param name="cateId" value="${c.id}"/>
                    </c:url>
                    <li class="nav-item">
                        <a class="nav-link" href="${cateUrl}">${c.name}</a>
                    </li>
                </c:forEach>
                <li class="nav-item">
                    <a class="nav-link text-danger" href="<c:url value="/stats"/>">Thống kê</a>
                </li>
                <s:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/login"/>">Đăng nhập</a>
                    </li>
                </s:authorize>
                <s:authorize access="isAuthenticated()">
                    <a class="nav-link" href="<c:url value="/"/>">
                        Welcome <s:authentication property="principal.username"/>!
                    </a>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/logout"/>">Đăng xuất</a>
                    </li>
                </s:authorize>
            </ul>
        </div>
    </div>
</nav>