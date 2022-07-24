<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <base href="${pageContext.servletContext.contextPath}/">
    <link rel="icon" href="resources/images/favicon.ico">
    <c:choose>
        <c:when test="${not empty param.title}">
            <title>${param.title}</title>
        </c:when>
        <c:otherwise>
            <title>Nike Online Shop</title>
        </c:otherwise>
    </c:choose>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="resources/css/main.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
    <link href="resources/css/sortable-theme-minimal.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
</head>
<body>
<div class="main">
    <nav class="px-3 navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="">
            <img src="resources/images/nike-logo.svg" alt="logo" class="logo">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-lg-0">
                <li class="nav-item active">
                    <c:if test="${sessionScope.username =='admin'}">
                        <a class="nav-link" href="admin/home.htm">Home</a>
                    </c:if>
                    <c:if test="${sessionScope.username !='admin'}">
                        <a class="nav-link" href="trang-chu.htm">Home</a>
                    </c:if>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="product/productList.htm">Products</a>
                </li>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="#">About</a>--%>
<%--                </li>--%>
                <c:if test="${sessionScope.username!='admin'}">
                    <li class="nav-item">
                        <a class="nav-link" href="contact.htm">Contact</a>
                    </li>
                </c:if>

            </ul>
            <ul class="navbar-nav ms-auto mb-lg-0">
                <c:choose>
                    <c:when test="${sessionScope.username!=null}">
                        <li class="nav-item dropdown d-flex align-items-center">
                            <a class="nav-link" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    ${sessionScope.username}
                            </a>
                            <ul class="dropdown-menu bg-light" aria-labelledby="navbarDropdownMenuLink">
                                <li><a class="dropdown-item" href="customer/update.htm">Update info</a></li>
                            </ul>
                        </li>
                        <c:if test="${sessionScope.username!='admin'}">
                            <li class="nav-item">
                                <a class="nav-link" href="customer/cart.htm">
                                    <button class="btn bg-dark border-0" data-bs-toggle="tooltip" data-bs-placement="top" title="View your cart">
                                        <i class="text-warning fs-3 fa fa-shopping-cart"></i>
                                    </button>
                                </a>
                            </li>
                        </c:if>
                        <li class="nav-item">
                            <button class="btn bg-dark border-0" data-bs-toggle="tooltip" data-bs-placement="top" title="Sign out">
                                <a class="nav-link" href="logout.htm"><i class="text-warning fs-3 fa fa-sign-out"></i></a>
                            </button>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item"><a class="nav-link" href="login.htm">Login</a></li>
                        <li class="nav-item"><a class="nav-link" href="register.htm">Register</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </nav>
