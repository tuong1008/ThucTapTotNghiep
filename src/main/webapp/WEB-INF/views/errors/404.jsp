<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include flush="true" page="/WEB-INF/views/template/header.jsp">
    <jsp:param name="title" value="404 ERROR"/>
</jsp:include>
<div style="position: absolute; top:10%; left: 30px">
    <c:choose>
        <c:when test="${not empty message}">
            <h1 class="fs-2">${message}</h1>
        </c:when>
        <c:otherwise>
            <h1 class="fs-2">404 NOT FOUND</h1>
        </c:otherwise>
    </c:choose>
</div>
<img src="resources/images/error.gif" alt="404 not found">

<%@include file="/WEB-INF/views/template/footer.jsp" %>
