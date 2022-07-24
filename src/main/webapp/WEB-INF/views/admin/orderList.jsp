<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<c:url var="firstUrl" value="/admin/customerOrder/1.htm"/>
<c:url var="lastUrl" value="/admin/customerOrder/${totalPages}.htm"/>
<c:url var="prevUrl" value="/admin/customerOrder/${currentPageNumber - 1}.htm"/>
<c:url var="nextUrl" value="/admin/customerOrder/${currentPageNumber + 1}.htm"/>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Order Page</h1>
            <p class="lead">Here is all Customer order list!</p>
            <c:if test="${not empty search}">
                <a class="btn btn-dark" href="<c:url value="/admin/customerOrder/1.htm"/>">See All Orders</a>
            </c:if>
            <a class="btn btn-primary pull-right" href="<c:url value="/order/excel.htm"/>">Export Excel</a>
        </div>
        <div class="container">
            <div class=row>

                <form class="form-inline" action="<c:url value="/admin/customerOrder/search/1.htm"/>"
                      method="post">
<%--                    <!--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->--%>
                    <div class="d-flex justify-content-center align-items-center">
                        <input type="text" name="searchTerm" class="form-control" style="width:300px"
                               id="inputEmail" placeholder="Enter email or username">
                        <input type="hidden" value="category" name="search">
                        <button type="submit" class="btn btn-success">Search Product</button>
                    </div>
                </form>

            </div>
        </div>
        <br>
        <c:set var="sl" value="1"/>
        <table class="table table-striped table-hover" data-sortable>
            <thead class="table-dark">
            <tr class="bg-success">
                <th style="width: 7%">SL No.</th>
                <th style="width: 12.5%">Name</th>
                <th style="width: 12.5%">Email</th>
                <th style="width: 12.5%">Phone</th>
                <th style="width: 12.5%">Username</th>
                <th style="width: 18%">Time Order</th>
                <th style="width: 12.5%" data-sortable="false">Order Details</th>
                <th style="width: 12.5%" data-sortable="false">Action</th>
            </tr>
            </thead>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${sl}</td>
                    <td>${order.customer.customerName}</td>
                    <td>${order.customer.customerEmailAddress}</td>
                    <td>${order.customer.customerPhoneNumber}</td>
                    <td>${order.customer.username}</td>
                    <td><fmt:formatDate pattern="HH:mm:ss dd/MM/yyyy"
                                        value="${order.timeOrder}"/></td>
                    <td><a class="btn btn-info"
                           href=" <spring:url value="/admin/customerOrder/productList/${order.customerOrderId}.htm"/>">See
                        Receipt</a></td>
                    <td><a class="btn btn-danger"
                           href=" <spring:url value="/admin/customerOrder/deleteOrder/${order.customerOrderId}.htm"/>">Clear
                        Order</a></td>
                    <c:set var="sl" value="${sl+1}"/>
                </tr>
            </c:forEach>
        </table>
        <div class="d-flex justify-content-center">
            <ul class="pagination">
                <c:choose>
                    <c:when test="${currentPageNumber == 1}">
                        <li class="page-item disabled">
                            <a class="page-link" href=""><i class="fa fa-fast-backward" aria-hidden="true"></i></a></li>
                        <li class="page-item disabled">
                            <a class="page-link" href=""><i class="fa fa-step-backward" aria-hidden="true"></i></a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link" href="${firstUrl}"><i class="fa fa-fast-backward" aria-hidden="true"></i></a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="${prevUrl}"><i class="fa fa-step-backward" aria-hidden="true"></i></a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                    <c:url var="pageUrl" value="/admin/customerOrder/${i}.htm"/>
                    <c:choose>
                        <c:when test="${i == currentPageNumber}">
                            <li class="page-item active">
                                <a class="page-link" href="${pageUrl}"><c:out value="${i}"/></a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link" href="${pageUrl}"><c:out value="${i}"/></a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:choose>
                    <c:when test="${currentPageNumber == totalPages}">
                        <li class="page-item disabled">
                            <a class="page-link" href=""><i class="fa fa-step-forward" aria-hidden="true"></i></a></li>
                        <li class="page-item disabled">
                            <a class="page-link" href=""><i class="fa fa-fast-forward" aria-hidden="true"></i></a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link" href="${nextUrl}"><i class="fa fa-step-forward" aria-hidden="true"></i></a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="${lastUrl}"><i class="fa fa-fast-forward" aria-hidden="true"></i></a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>