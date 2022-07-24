<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include flush="true" page="/WEB-INF/views/template/header.jsp">
    <jsp:param name="title" value="SERVER ERROR"/>
</jsp:include>

<h1>SERVER ERROR</h1>
<img src="resources/images/error.gif" alt="404 not found">

<%@include file="/WEB-INF/views/template/footer.jsp" %>
