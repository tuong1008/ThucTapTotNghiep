<jsp:include flush="true" page="/WEB-INF/views/template/header.jsp">
    <jsp:param name="title" value="Update customer info"/>
</jsp:include>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100 mt-4">
            <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                <div class="card">
                    <div class="card-body p-5">
                        <h2 class="text-uppercase text-center mb-3">Edit customer info</h2>
                        <%--@elvariable id="customer" type="ptithcm.entity.Customer"--%>
                        <form:form action="admin/customerManagement/update/${customer.customerId}.htm"
                                   method="post" modelAttribute="customer" class="form-horizontal">
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <c:if test="${not empty error}">
                                        <label class="label-danger">${error}</label>
                                    </c:if>

                                    <c:if test="${not empty update}">
                                        <input name="update" type="hidden" value="update">
                                        <input name="oldUserId" type="hidden" value="${customer.customerId}">
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <h1 class="fs-4">Basic Info</h1>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <form:errors path="customerName" cssClass="text-danger"/>
                                </div>
                                <div class="col-xs-9">
                                    <form:input path="customerName" class="form-control" placeholder="${customer.customerName}"
                                                id="customerName"/>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <form:errors path="customerEmailAddress" cssClass="text-danger"/>
                                </div>
                                <div class="col-xs-9">
                                    <form:input path="customerEmailAddress" class="form-control" placeholder="${customer.customerEmailAddress}"
                                                id="customerEmailAddress"/>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <form:errors path="customerPhoneNumber" cssClass="text-danger"/>
                                </div>
                                <div class="col-xs-9">
                                    <form:input path="customerPhoneNumber" class="form-control" placeholder="${customer.customerPhoneNumber}"/>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <form:errors path="username" cssClass="text-danger"/>
                                </div>
                                <div class="col-xs-9">
                                    <form:input path="username" class="form-control" placeholder="${customer.username}"/>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <form:errors path="password" cssClass="text-danger"/>
                                </div>
                                <div class="col-xs-9">
                                    <form:password showPassword="true" path="password" class="form-control"
                                                   placeholder="${customer.password}"/>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    Enabled
                                </div>
                                <div class="col-xs-9">
                                    <form:checkbox path="enabled" cssClass="form-check-input"/>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <h1 class="fs-4">Billing Address</h1>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <form:errors path="billingAddress.city" cssClass="text-danger"/>
                                </div>
                                <div class="col-xs-9">
                                    <form:input path="billingAddress.city" class="form-control" placeholder="${customer.billingAddress.city}"/>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <form:errors path="billingAddress.country" cssClass="text-danger"/>
                                </div>
                                <div class="col-xs-9">
                                    <form:input path="billingAddress.country" class="form-control" placeholder="${customer.billingAddress.country}"/>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <form:errors path="billingAddress.zipCode" cssClass="text-danger"/>
                                </div>
                                <div class="col-xs-9">
                                    <form:input path="billingAddress.zipCode" class="form-control" placeholder="${customer.billingAddress.zipCode}"/>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <h1 class="fs-4">Shipping Address</h1>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <form:errors path="shippingAddress.address" cssClass="text-danger"/>
                                </div>
                                <div class="col-xs-9">
                                    <form:input path="shippingAddress.address" class="form-control"
                                                placeholder="${customer.shippingAddress.address}"/>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <form:errors path="shippingAddress.city" cssClass="text-danger"/>
                                </div>
                                <div class="col-xs-9">
                                    <form:input path="shippingAddress.city" class="form-control" placeholder="${customer.shippingAddress.city}"/>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <form:errors path="shippingAddress.country" cssClass="text-danger"/>
                                </div>
                                <div class="col-xs-9">
                                    <form:input path="shippingAddress.country" class="form-control" placeholder="${customer.shippingAddress.country}"/>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-xs-9">
                                    <form:errors path="shippingAddress.zipCode" cssClass="text-danger"/>
                                </div>
                                <div class="col-xs-9">
                                    <form:input path="shippingAddress.zipCode" class="form-control" placeholder="${customer.shippingAddress.zipCode}"/>
                                </div>
                            </div>
                            <div class="d-flex justify-content-center mt-4">
                                <input type="submit" value="Update info" class="fs-5 text-uppercase btn btn-outline-dark btn-light">
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>