<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header title">
            <h1>Order</h1>
            <p class="lead">Order, customer and product list</p>
        </div>
        <div class="container">
            <div class="row">
                <form:form modelAttribute="order" class="form-horizontal">
                    <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
                        <div class="text-center">
                            <h1>Receipt</h1>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 text-end">
                                <strong>Time Order</strong><br/>
                                <fmt:formatDate pattern="HH:mm:ss dd/MM/yyyy" value="${order.timeOrder}"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <div class="fs-3">Shipping Address</div><br>
                                        ${order.shippingAddress.address}<br>
                                        ${order.shippingAddress.city}, ${order.shippingAddress.country}<br>
                                        ${order.shippingAddress.zipCode}
                                </address>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Billing Address</strong><br>
                                        ${order.billingAddress.city},${order.billingAddress.country}<br/>
                                        ${order.billingAddress.zipCode}
                                </address>
                            </div>
                        </div>
                        <div class="row">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th class="text-center">Product</th>
                                    <th class="text-center">Quantity</th>
                                    <th class="text-center">Price</th>
                                    <th class="text-center">Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cartItem" items="${order.cart.cartItem}">
                                    <tr>
                                        <td class="col-md-9"><em>${cartItem.product.productName}</em></td>
                                        <td class="col-md-1" style="text-align:center"> ${cartItem.quantity} </td>
                                        <td class="col-md-1"
                                            style="text-align:center"> ${cartItem.product.productPrice} </td>
                                        <td class="col-md-1" style="text-align:center"> ${cartItem.totalPrice} </td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td class="text-right">
                                        <h4>
                                            <strong> Grand Total:</strong>
                                        </h4>
                                    </td>
                                    <td class="text-center text-danger">
                                        <h4><strong>${order.cart.grandTotal}</strong></h4>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>