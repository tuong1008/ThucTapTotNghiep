<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include flush="true" page="/WEB-INF/views/template/header.jsp">
    <jsp:param name="title" value="Contact us"/>
</jsp:include>
<div class="wrapper">
    <div class="overlay">
        <div class="row d-flex justify-content-center align-items-center">
            <div class="col-md-9">
                <div class="contact-us text-center"><h3>Contact Us</h3>
                    <p class="mb-5">Hey. How can we help you? Send us a message!</p>
                    <div class="d-flex flex-row justify-content-start">
                        <div class="col-md-6">
                            <div class="mt-5 text-center px-3">
                                <div class="d-flex flex-row align-items-center">
                                    <span class="icons"><i class="fa fa-map-marker"></i></span>
                                    <div class="address text-start"><span>Address</span>
                                        <p>23 Quang Trung, Hồ Chí Minh City</p>
                                    </div>
                                </div>
                                <div class="d-flex flex-row align-items-center mt-3">
                                    <span class="icons"><i class="fa fa-phone"></i></span>
                                    <div class="address text-start"><span>Phone</span>
                                        <p>+84 9977553311</p>
                                    </div>
                                </div>
                                <div class="d-flex flex-row align-items-center mt-3">
                                    <span class="icons"><i class="fa fa-envelope-o"></i></span>
                                    <div class="address text-start"><span>Email</span>
                                        <p>admin@nikeshop.com</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%--@elvariable id="userMessage" type="ptithcm.entity.Message"--%>
                        <form:form action="${pageContext.request.contextPath}/contact.htm"  cssStyle="width: 100%" method="post" modelAttribute="userMessage">
                            <div class="col-md-6">
                                <div class="text-center px-1">
                                    <c:choose>
                                        <c:when test="${sessionScope.user!=null}">
                                            <div class="forms p-4 py-5 bg-white"><h5>Send Message</h5>
                                                <div class="mt-4 inputs">
                                                    <div class="form-outline mb-4">
                                                        <div class="col-xs-9">
                                                            <form:errors path="name" cssClass="text-danger"/>
                                                        </div>
                                                        <div class="col-xs-9">
                                                            <form:input type="text" class="form-control" placeholder="Name" value="${sessionScope.user.customerName}" path="name"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-outline mb-4">
                                                        <div class="col-xs-9">
                                                            <form:errors path="email" cssClass="text-danger"/>
                                                        </div>
                                                        <div>
                                                            <form:input type="text" class="form-control" placeholder="Email Address" value="${sessionScope.user.customerEmailAddress}" path="email"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-outline mb-4">
                                                        <div class="col-xs-9">
                                                            <form:errors path="message" cssClass="text-danger"/>
                                                        </div>
                                                        <div class="col-xs-9">
                                                            <form:textarea class="form-control" placeholder="Your message" path="message"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="button mt-4 text-left">
                                                    <button type="submit" class="btn btn-dark">Send</button>
                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="forms p-4 py-5 bg-white"><h5>Send Message</h5>
                                                <div class="mt-4 inputs">
                                                    <div class="form-outline mb-4">
                                                        <div class="col-xs-9">
                                                            <form:errors path="name" cssClass="text-danger"/>
                                                        </div>
                                                        <div class="col-xs-9">
                                                            <form:input type="text" class="form-control" placeholder="Name" path="name"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-outline mb-4">
                                                        <div class="col-xs-9">
                                                            <form:errors path="email" cssClass="text-danger"/>
                                                        </div>
                                                        <div>
                                                            <form:input type="text" class="form-control" placeholder="Email Address" path="email"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-outline mb-4">
                                                        <div class="col-xs-9">
                                                            <form:errors path="message" cssClass="text-danger"/>
                                                        </div>
                                                        <div class="col-xs-9">
                                                            <form:textarea class="form-control" placeholder="Your message" path="message"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="button mt-4 text-left">
                                                    <button type="submit" class="btn btn-dark">Send</button>
                                                </div>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>