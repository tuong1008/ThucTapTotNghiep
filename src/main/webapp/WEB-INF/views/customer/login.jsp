<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
            <div class="card bg-dark text-white" style="border-radius: 1rem;">
                <div class="card-body p-5 text-center">
                    <div class="mb-md-5 mt-md-4 pb-5">
                        <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                        <p class="text-white-50 mb-5">Please enter your username and password!</p>
                        <div class="form-outline form-white mb-4">
                            <form:form action="${pageContext.servletContext.contextPath}/login.htm" method="post"
                                       class="form-horizontal" modelAttribute="customer" id="form">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <div class="mb-md-5 mt-md-4 pb-5">
                                    <div class="form-group has-success">
                                        <label class="col-xs-3 control-label"></label>
                                        <div class="col-xs-9">
                                            <c:if test="${not empty error}">
                                                <div class="text-danger">${error}</div>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="form-group has-success">
                                        <label class="col-xs-3 control-label"></label>
                                        <div class="col-xs-9">
                                            <c:if test="${not empty msg}">
                                                <div class="text-warning">${msg}</div>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="form-outline form-white mb-4">
                                        <form:input cssClass="form-control form-control-lg" type="text" class="form-control" path="username" placeholder="Username"
                                                    autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false"/>
                                    </div>
                                    <div class="form-outline form-white mb-4">
                                        <form:input cssClass="form-control form-control-lg" type="password" class="form-control" path="password" placeholder="Password"
                                                    autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false"/>
                                    </div>
                                    <div class="d-flex justify-content-between">
                                        <label class="form-check-label">Remember Me:
                                            <input type="checkbox" name="remember-me"/></label>
                                        <a href="resetpassword.htm" class="text-white-50">Forgot password?</a>
                                    </div>
                                </div>
                                <input type="submit" value="Login" class="btn btn-outline-light btn-lg px-5">
                            </form:form>
                        </div>
                    </div>
                    <div>
                        <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account?
                            <a href="register.htm" class="text-white-50 fw-bold">Register</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>