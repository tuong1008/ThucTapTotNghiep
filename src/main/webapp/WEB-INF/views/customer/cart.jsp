<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>
                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
        </section>
        <section class="container" ng-app="cartApp">
            <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
                <div>
                    <a class="btn btn-danger pull-left" ng-click="clearCart()"><span
                            class="glyphicon glyphicon-remove-sign"></span> Clear Cart</a>
                    <!--                    <a ng-if="cart.cartItem.length==0" style="opacity: 0.5" class="btn btn-danger pull-left"><span
                                                class="glyphicon glyphicon-remove-sign"></span> Clear Cartt</a>-->
                    <a id="btnCheckOut" href="<spring:url value="/order/${cartId}.htm" />" class="btn btn-success pull-right"><span
                            class="glyphicon glyphicon-shopping-cart"></span> Check out</a>
                </div>
                <br/><br/><br/>
                <div class="col-xs-12">
                    <c:if test="${not empty error}">
                        <div class="text-danger">${error}</div>
                    </c:if>
                </div>
                <table class="table table-hover">
                    <tr>
                        <th>Product</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <tr ng-repeat="item in cart.cartItem">
                        <td>{{item.product.productName}}</td>
                        <td>{{item.product.productPrice}}</td>
                        <td>{{item.quantity}}</td>
                        <td>{{item.totalPrice}}</td>
                        <td><a href="" class="label label-danger" ng-click="removeFromCart(item.cartItemId)"><span
                                class="glyphicon glyphicon-remove"></span>remove</a></td>
                    </tr>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Grand Total</th>
                        <th>{{cart.grandTotal}}</th>
                        <th></th>
                    </tr>
                </table>
            </div>
        </section>
    </div>
</div>
<script src="resources/js/controller.js"></script>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>