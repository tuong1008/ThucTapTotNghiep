<%--@elvariable id="customer" type="ptithcm.entity.Customer"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Shipping Address & Billing Address Page</h1>
            <p class="lead">Here is address of ${customer.customerName}</p>
        </div>
        <h1>Shipping Address</h1>
        <table class="table table-striped table-hover table-borderless">
            <thead class="table-dark">
            <tr class="bg-success">
                <th>Address</th>
                <th>City</th>
                <th>Country</th>
                <th>Zip Code</th>
            </tr>
            </thead>
            <tr>
                <td>${customer.shippingAddress.address}</td>
                <td>${customer.shippingAddress.city}</td>
                <td>${customer.shippingAddress.country}</td>
                <td>${customer.shippingAddress.zipCode}</td>
            </tr>
        </table>
        <h1>Billing Address</h1>
        <table class="table table-striped table-hover table-borderless">
            <thead class="table-dark">>
            <tr class="bg-success">
                <th>City</th>
                <th>Country</th>
                <th>Zip Code</th>
            </tr>
            </thead>
            <tr>
                <td>${customer.billingAddress.city}</td>
                <td>${customer.billingAddress.country}</td>
                <td>${customer.billingAddress.zipCode}</td>
            </tr>
        </table>
    </div>
</div>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>