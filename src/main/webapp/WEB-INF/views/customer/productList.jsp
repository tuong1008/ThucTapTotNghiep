<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<c:url var="firstUrl" value="/product/productList/${productCategory}/1.htm"/>
<c:url var="lastUrl" value="/product/productList/${productCategory}/${totalPages}.htm"/>
<c:url var="prevUrl" value="/product/productList/${productCategory}/${currentPageNumber - 1}.htm"/>
<c:url var="nextUrl" value="/product/productList/${productCategory}/${currentPageNumber + 1}.htm"/>
<div class="container-wrapper">
    <div class="container">
        <div class=row>
            <div class="col-md-3">
                <h1 class="fs-2 fw-bold">Product Category</h1>
                <div class="list-group popular-product">
                    <a href="<c:url value="/product/productList/Lifestyle/1.htm"/>" class="list-group-item">Lifestyle Shoes</a>
                    <a href="<c:url value="/product/productList/Running/1.htm"/>" class="list-group-item">Running Shoes</a>
                    <a href="<c:url value="/product/productList/Football/1.htm"/>" class="list-group-item">Football Boots</a>
                    <a href="<c:url value="/product/productList/TShirts/1.htm"/>" class="list-group-item">T-Shirts</a>
                    <a href="<c:url value="/product/productList/LongSleeve/1.htm"/>" class="list-group-item">Long Sleeve Shirts</a>
                    <a href="<c:url value="/product/productList/Sleeveless/1.htm"/>" class="list-group-item">Sleeveless & Tank Tops</a>
                    <a href="<c:url value="/product/productList/Polos/1.htm"/>" class="list-group-item">Polos</a>
                    <a href="<c:url value="/product/productList/Shorts/1.htm"/>" class="list-group-item">Shorts</a>
                </div>
            </div>
            <div class="jumbotron col-md-6">
                <p>Select your favourite products</p>
            </div>
            <div class="col-md-3">
                <h1 class="fs-2 fw-bold">Product Category</h1>
                <div class="list-group popular-product">
                    <a href="<c:url value="/product/productList/Jogger/1.htm"/>" class="list-group-item">Jogger Pants</a>
                    <a href="<c:url value="/product/productList/Bags/1.htm"/>" class="list-group-item">Bags</a>
                    <a href="<c:url value="/product/productList/Hats/1.htm"/>" class="list-group-item ">Hats</a>
                    <a href="<c:url value="/product/productList/Socks/1.htm"/>" class="list-group-item">Socks</a>
                    <a href="<c:url value="/product/productList/Trousers/1.htm"/>" class="list-group-item">Trousers</a>
                    <a href="<c:url value="/product/productList/Training/1.htm"/>" class="list-group-item">Training & Gym Shoes</a>
                    <a href="<c:url value="/product/productList/Athletics/1.htm"/>" class="list-group-item">Athletics Shoes</a>
                    <a href="<c:url value="/product/productList/Sandals/1.htm"/>" class="list-group-item">Sandals & Slides</a>
                </div>
            </div>
        </div>
        <div class="page-header">
            <c:if test="${not empty search}">
                <a class="btn btn-primary" href="<c:url value="/product/productList.htm"/>">See All Products</a>
            </c:if>
        </div>
        <div class="container">
            <div class=row>
                <form class="form-inline" action="<c:url value="/product/search/1.htm"/>"
                      method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="d-flex justify-content-center align-items-center">
                        <input type="text" name="searchTerm" class="form-control" style="width:300px"
                               id="inputEmail" placeholder="Enter Product Name">
                        <input type="hidden" value="category" name="search">
                        <button type="submit" class="btn btn-primary">Search Product</button>
                    </div>
                </form>
            </div>
        </div>
        <br>
        <section class="productsection">
            <div class="container">
                <c:if test="${not empty msg}">
                    <div class="no-product">${msg}</div>
                </c:if>
                <div class="row">
                    <c:forEach var="product" items="${products}">
                        <div class="col-md-4">
                            <div class="product-single">
                                <div class=" text-center productColumn">
                                    <div class=" img-responsive productImage">
                                        <img style="width:50%;height: 50%   " alt="image"
                                             src="<c:url value="/resources/images/${product.productId}.png"/>"/>
                                    </div>
                                </div>
                                <div class="product-desc">
                                    <h2>${product.productName}</h2>
                                    <h3>${product.productPrice}VND</h3>
                                    <a href=" <c:url value="/product/viewProduct/${product.productId}.htm"/>"
                                       class="btn btn-info btn-lg">View Detail</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
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
                    <c:url var="pageUrl" value="/product/productList/${productCategory}/${i}.htm"/>
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