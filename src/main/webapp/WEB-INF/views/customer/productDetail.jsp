<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>
        </div>
        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5 image">
                    <img src="<c:url value="/resources/images/${product.productId}.png" />" alt="image"
                         style="width:100%"/>
                </div>
                <div class="col-md-5 product-details">
                    <p><strong class="text-dark col-md-4">Name:</strong>
                        ${product.productName}</p>
                    <p><strong class="text-dark col-md-4">Description:</strong>
                        ${product.productDescription}</p>
                    <p><strong class="text-dark col-md-4">Unit in Stock:</strong>
                        ${product.unitInStock}</p>
                    <p><strong class="text-dark col-md-4">Category:</strong>
                        ${product.productCategory}</p>
                    <p><strong class="text-dark col-md-4">Price:</strong>
                        ${product.productPrice}VND</p>
                    <br/>
                    <c:set var="url" scope="page" value="/product/productList/${product.productCategory}/1.htm"/>
                    <c:if test="${sessionScope.username=='admin'}">
                        <c:set var="url" scope="page" value="/admin/productManagement/1.htm"/>
                    </c:if>
                    <p ng-controller="cartCtrl">
                        <a href="<c:url value = "${url}" />" class="btn btn-primary btn-md">Back</a>
                        <c:if test="${sessionScope.username!=null}">
                            <c:if test="${sessionScope.username!='admin'}">
                                <a href="" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')"><span class="glyphicon glyphicon-shopping-cart"></span>
                                    Order Now</a>
                                <a href="<spring:url value="/customer/cart.htm" />" class="btn btn-success btn-md"><span class="glyphicon glyphicon-hand-right"></span>
                                    View Cart</a>
                            </c:if>
                        </c:if>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>
