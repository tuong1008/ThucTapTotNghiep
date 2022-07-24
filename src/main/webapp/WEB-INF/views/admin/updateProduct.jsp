<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header title">
            <h1>Update Product</h1>
            <p class="lead">Fill the below information to update a product</p>
        </div>
        <div class="form-layout">
            <form:form action="${pageContext.request.contextPath}/admin/product/updateProduct.htm" method="post"
                       modelAttribute="product" enctype="multipart/form-data" class="form-horizontal">
                <form:hidden path="productId" value="${product.productId}"/>
                <div class="row">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <form:errors path="productName" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="productName">Product Name:</label>
                    <div class="col-xs-9">
                        <form:input path="productName" class="form-control" placeholder="Enter Product Name"
                                    id="productName"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <form:errors path="productPrice" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="productPrice">Product Price:</label>
                    <div class="col-xs-9">
                        <form:input path="productPrice" class="form-control" placeholder="Enter Product Price"
                                    id="productPrice"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <form:errors path="unitInStock" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="unitInStock">Product Stock:</label>
                    <div class="col-xs-9">
                        <form:input path="unitInStock" class="form-control" placeholder="Enter Product Unit in Stock"
                                    id="unitInStock"/>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <form:errors path="productCategory" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="productCategory">Product Category:</label>
                    <div class="col-xs-9">
                        <form:select path="productCategory">
                            <form:option value="NONE" label="--- Select ---"/>
                            <form:options items="${categoryList}"/>
                        </form:select>
                    </div>
                </div>
                <div class="row">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <form:errors path="productDescription" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="productDescription">Product Description:</label>
                    <div class="col-xs-9">
                        <form:input path="productDescription" class="form-control"
                                    placeholder="Enter Product Description" id="productDescription"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label" for="productImage">Upload Picture:</label>
                    <div class="col-xs-9">
                        <form:input path="productImage" id="productImage" type="file" class="form:input-large"/>
                    </div>
                </div>
                <div class="form-group has-success">
                    <label class="col-xs-3 control-label"></label>
                    <div class="col-xs-9">
                        <input type="submit" value="Submit" class="btn btn-default">
                        <a href="<c:url value="/admin/productManagement/1.htm" />" class="btn btn-default">Cancel</a>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>