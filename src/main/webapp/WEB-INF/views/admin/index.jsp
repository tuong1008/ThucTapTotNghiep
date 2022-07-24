<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container overflow-hidden">
        <div class="fs-2 text-dark fw-bold">
            <h1>Administrator Page</h1>
        </div>
        <div class="row">
            <div class="col-md-3 card w-25">
                <div class="card-body text-center">
                    <div class="text-center">
                        <a class="link-primary h4" href="admin/productManagement/1.htm">Product Management</a>
                    </div>
                    <p class="text-dark">View, check and modify the product inventory</p>
                </div>
            </div>
            <div class="col-md-1"></div>

            <div class="col-md-3 card w-25">
                <div class="card-body text-center">
                    <div class="text-center">
                        <a class="link-primary h4" href="admin/customerManagement/1.htm">Customer Management</a>
                    </div>
                    <p class="text-dark">View customers information</p>
                </div>
            </div>
        </div>

        <div class="row mt-5">
            <div class="col-md-3 card w-25">
                <div class="card-body text-center">
                    <div class="text-center">
                        <a class="link-primary h4" href="admin/customerOrder/1.htm">Customer Order</a>
                    </div>
                    <p class="text-dark">View all orders</p>
                </div>
            </div>
            <div class="col-md-1"></div>

            <div class="col-md-3 card w-25">
                <div class="card-body text-center">
                    <div class="text-center">
                        <a class="link-primary h4 text-center" href="admin/messages/1.htm">Customer Messages</a>
                    </div>
                    <p class="text-dark">View all customer message</p>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>