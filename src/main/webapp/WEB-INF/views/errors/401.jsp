<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include flush="true" page="/WEB-INF/views/template/header.jsp">
    <jsp:param name="title" value="404 ERROR"/>
</jsp:include>
<div class="display-1 lead text-center">
    <h1 class="fs-2">Unauthorized</h1>
</div>
<img src="resources/images/error.gif" alt="error.gif">

<%@include file="/WEB-INF/views/template/footer.jsp" %>
