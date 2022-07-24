<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<div>
    <a href="<c:url value="validation/form1.htm"/>">validation/form1.htm</a>
</div>
<div>
    <a href="<c:url value="validation/form2.htm"/>">validation/form2.htm</a>
</div>
<div>
    <a href="<c:url value="home/index.htm"/>">home/index.htm</a>
</div>
<div>
    <a href="<c:url value="home/contact.htm"/>">home/contact.htm</a>
</div>
<br>
<div>Một số trang yêu cầuđăng nhập</div>
<div>
    <a href="<c:url value="user/logoff.htm"/>">user/logoff.htm</a>
</div>
<div>
    <a href="<c:url value="user/change-password.htm"/>">user/change-password.htm</a>
</div>
<div>
    <a href="<c:url value="order/checkout.htm"/>">order/checkout.htm</a>
</div>
<div>
    <a href="<c:url value="order/list.htm"/>">order/list.htm</a>
</div>
<br>
<div>Sau khiđăng nhập thành công, trở về những url trên, nó sẽ load DS Major bằng Interceptor</div>
</body>
</html>
