<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<c:url var="firstUrl" value="/admin/productManagement/1.htm"/>
<c:url var="lastUrl" value="/admin/productManagement/${totalPages}.htm"/>
<c:url var="prevUrl" value="/admin/productManagement/${currentPageNumber - 1}.htm"/>
<c:url var="nextUrl" value="/admin/productManagement/${currentPageNumber + 1}.htm"/>
<div class="container-wrapper">
    <div class="container">
        <c:if test="${not empty message}">
            <script>
                alert("${message}");
            </script>
        </c:if>
        <div class="page-header">
            <h1>Product Inventory Page: ${pageContext.request.userPrincipal.name}</h1>
            <a class="btn btn-primary" href="<c:url value="/admin/product/addProduct.htm"/>">Add Product</a>
            <c:if test="${not empty search}">
                <a class="btn btn-primary" href="<c:url value="/admin/productManagement/1.htm"/>">See All Product</a>
            </c:if>
        </div>
        <div class="container">
            <div class=row>
                <form class="form-inline" action="<c:url value="/admin/productManagement/search/1.htm"/>"
                      method="post">
                    <div class="d-flex justify-content-center align-items-center">
                        <input type="text" name="searchTerm" class="form-control" style="width:300px"
                               id="inputEmail" placeholder="Enter Name or Category name">
                        <input type="hidden" value="category" name="search">
                        <button type="submit" class="btn btn-primary">Search Product</button>
                    </div>
                </form>
            </div>
        </div>
        <br>
        <table class="table table-striped table-hover table-bordered" data-sortable>
            <thead class="table-dark">
            <tr class="bg-success">
                <th data-sortable="false">Thumbnail</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Unit in Stock</th>
                <th>Price</th>
                <th data-sortable="false">Action</th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img style="width:50%" alt="image"
                             src="<c:url value="/resources/images/${product.productId}.png"/>"/></td>
                    <td class="success">${product.productName}</td>
                    <td class="info">${product.productCategory}</td>
                    <td class="warning">${product.unitInStock}</td>
                    <td class="success">${product.productPrice}VND</td>
                    <td class="info">
                        <a href="<c:url value="/product/viewProduct/${product.productId}.htm"/>"
                           data-bs-toggle="tooltip" title="View">
                            <i class="fa fa-info-circle fs-5 text-info" aria-hidden="true"></i>
                        </a>
                        <a href="<c:url value="/admin/product/updateProduct/${product.productId}.htm"/>"
                           data-bs-toggle="tooltip" title="Edit">
                            <i class="fa fa-pencil-square-o fs-5 text-success" aria-hidden="true"></i>
                        </a>
                        <a href="<c:url value="/admin/product/deleteProduct/${product.productId}.htm"/>"
                           data-bs-toggle="tooltip" title="Delete">
                            <i class="fa fa-trash fs-5 text-danger" aria-hidden="true"></i>
                        </a>
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
                    <c:url var="pageUrl" value="/admin/productManagement/${i}.htm"/>
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
<%@include file="/WEB-INF/views/template/footer.jsp" %>