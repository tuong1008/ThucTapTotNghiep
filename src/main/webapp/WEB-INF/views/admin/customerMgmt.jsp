<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include flush="true" page="/WEB-INF/views/template/header.jsp">
    <jsp:param name="title" value="Customer Management"/>
</jsp:include>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <c:if test="${not empty search}">
                <a class="btn btn-primary" href="<c:url value="/admin/customerManagement/1.htm"/>">See All Customers</a>
                
                <c:url var="firstUrl" value="/admin/customerManagement/search/1.htm?searchTerm=${search}"/>
                <c:url var="lastUrl" value="/admin/customerManagement/search/${totalPages}.htm?searchTerm=${search}"/>
                <c:url var="prevUrl" value="/admin/customerManagement/search/${currentPageNumber - 1}.htm?searchTerm=${search}"/>
                <c:url var="nextUrl" value="/admin/customerManagement/search/${currentPageNumber + 1}.htm?searchTerm=${search}"/>
            </c:if>
            <c:if test="${empty search}">
                
                <c:url var="firstUrl" value="/admin/customerManagement/1.htm"/>
                <c:url var="lastUrl" value="/admin/customerManagement/${totalPages}.htm"/>
                <c:url var="prevUrl" value="/admin/customerManagement/${currentPageNumber - 1}.htm"/>
                <c:url var="nextUrl" value="/admin/customerManagement/${currentPageNumber + 1}.htm"/>
            </c:if>
        </div>
        <div class="container">
            <div class=row>
                <form class="form-inline" action="<c:url value="/admin/customerManagement/search/1.htm"/>">
                    <%--                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
                    <div class="d-flex justify-content-center align-items-center mb-4">
                        <input type="text" name="searchTerm" class="form-control" style="width:300px"
                               id="inputEmail" placeholder="Search Username or Email" value="${search}">
                        <button type="submit" class="btn btn-primary btn-dark">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <table class="table table-striped table-hover table-borderless" data-sortable>
            <thead class="table-dark">
            <tr class="bg-success">
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Username</th>
                <th data-sortable="false">Enabled</th>
                <th data-sortable="false">Action</th>
            </tr>
            </thead>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.customerName}</td>
                    <td>${customer.customerEmailAddress}</td>
                    <td>${customer.customerPhoneNumber}</td>
                    <td>${customer.username}</td>
                    <td>
                        <c:choose>
                            <c:when test="${customer.enabled==true}">
                                <span class="status-true">
                                    <i class="fa fa-circle"></i>
                                </span>${customer.enabled}
                            </c:when>
                            <c:otherwise>
                                <span class="status-false">
                                    <i class="fa fa-circle"></i>
                                </span>${customer.enabled}
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="<spring:url value="/admin/customerManagement/update/${customer.customerId}.htm"/>"
                           class="setting-icon" title="Edit" data-toggle="tooltip" data-placement="top"><i class="fa fa-gear fs-5"></i></a>
                        <a href="<spring:url value="/admin/customerManagement/delete/${customer.customerId}.htm"/>"
                           class="delete-icon" data-toggle="tooltip" data-placement="top" title="Delete"><i class="fa fa-times-circle fs-5"></i></a>
                    </td>
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
                    <c:if test="${not empty search}">
                        <c:url var="pageUrl" value="/admin/customerManagement/search/${i}.htm?searchTerm=${search}"/>

                        <c:url var="firstUrl" value="/admin/customerManagement/search/1.htm?searchTerm=${search}"/>
                        <c:url var="lastUrl" value="/admin/customerManagement/search/${totalPages}.htm?searchTerm=${search}"/>
                        <c:url var="prevUrl" value="/admin/customerManagement/search/${currentPageNumber - 1}.htm?searchTerm=${search}"/>
                        <c:url var="nextUrl" value="/admin/customerManagement/search/${currentPageNumber + 1}.htm?searchTerm=${search}"/>
                    </c:if>
                    <c:if test="${empty search}">
                        <c:url var="pageUrl" value="/admin/customerManagement/${i}.htm"/>
                    </c:if>
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