<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>${message}</h1>
                </div>
            </div>
        </section>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>