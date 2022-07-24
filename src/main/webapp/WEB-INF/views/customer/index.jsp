<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="introCarousel" class="carousel slide carousel-dark" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#introCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#introCarousel" data-bs-slide-to="1"
                aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#introCarousel" data-bs-slide-to="2"
                aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="2000">
            <img class="d-block w-100" style="width: 1500px; height: 1000px" src="resources/images/banner3.jpg" alt="1st slide">
            <div class="carousel-caption d-none d-md-block">
                <h5>Nike Online Shop</h5>
                <p style="font-family: 'Segoe UI Semibold', serif">Buy Latest Products</p>
                <p style="font-family: 'Segoe UI Semibold', serif"><a class="btn btn-lg btn-dark" href="register" role="link">Sign up
                    now!</a>
                </p>
            </div>
        </div>
        <div class="carousel-item" data-bs-interval="2000">
            <img class="d-block w-100" style="width: 1500px; height: 1000px" src="resources/images/banner1.jpg" alt="2nd slide">
            <div class="carousel-caption d-none d-md-block">
                <h5 style="font-family: 'Segoe UI Semibold', serif">Find all your favorite products here!</h5>
                <p style="font-family: 'Segoe UI Semibold', serif">Top tier quality</p>
            </div>
        </div>
        <div class="carousel-item" data-bs-interval="2000">
            <img class="d-block w-100" style="width: 1500px; height: 1000px" src="resources/images/banner4.jpg" alt="3rd slide">
            <div class="carousel-caption d-none d-md-block">
                <h5 style="font-family: 'Segoe UI Semibold', serif">Chosen by the best athletes around the world</h5>
                <p style="font-family: 'Segoe UI Semibold', serif">Shop with us!</p>
            </div>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#introCarousel"
            data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Prev</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#introCarousel"
            data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<div class="container mt-4">
    <div class="row align-items-center">
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple align-items-center" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/athletics.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/Athletics/1.htm" class="btn btn-dark">Athletic shoes</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/bags.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/Bags/1.htm" class="btn btn-dark">Bags</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/football.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/Football/1.htm" class="btn btn-dark">Football Boots</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row align-items-center">
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/lifestyle.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/Lifestyle/1.htm" class="btn btn-dark">Lifestyle shoes</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/running.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/Running/1.htm" class="btn btn-dark">Running shoes</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/socks.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/Socks/1.htm" class="btn btn-dark">Socks</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row align-items-center">
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/hats.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/Hats/1.htm" class="btn btn-dark">Caps</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/trousers.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/Trousers/1.htm" class="btn btn-dark">Trousers</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/long.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/LongSleeve/1.htm" class="btn btn-dark">Long sleeve shirts</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row align-items-center">
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/polos.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/Polos/1.htm" class="btn btn-dark">Polos</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/shorts.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/Shorts/1.htm" class="btn btn-dark">Shorts</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/sleeveless.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/Sleeveless/1.htm" class="btn btn-dark">Sleeveless & Tank tops</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row align-items-center">
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/jogger.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/Jogger/1.htm" class="btn btn-dark">Jogger pants</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/training.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/Training/1.htm" class="btn btn-dark">Training shoes</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center h-100">
                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                    <img class="rounded-circle" src="resources/images/tshirts.jpg"
                         alt="image" width="140" height="140">
                    <a href="#">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                    </a>
                </div>
                <div class="card-body">
                    <a href="product/productList/TShirts/1.htm" class="btn btn-dark">T-Shirts</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <section class="testimonial">
        <div class="container">
            <div class="text-center">
                <h2 class="display-3 fst-italic lh-1 mb-4">Our reviews</h2>
            </div>
            <div class="row mt-4">
                <div class="col-md-2">
                    <img class="rounded-circle" src="resources/images/user4.jpg"
                         alt="image" width="90" height="90">
                </div>
                <div class="col-md-10">
                    <blockquote class="blockquote">
                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                        <p class="text-dark">Lorem ipsum dolor atque culpa deserunt fuga magni molestias nostrum obcaecati possimus!</p>
                    </blockquote>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-md-2">
                    <div>
                        <img class="rounded-circle" src="resources/images/user3.jpg"
                             alt="image" width="90" height="90">
                    </div>
                </div>
                <div class="col-md-10">
                    <blockquote class="blockquote">
                        <i class="fa fa-quote-left" aria-hidden="true"></i>
                        <p class="text-dark">Alias aspernatur, atque culpa deserunt fuga magni molestias nostrum obcaecati possimus,
                            quaerat quasi quo repellat saepe ut voluptatem? Deleniti explicabo quae quisquam!</p>
                    </blockquote>
                </div>
            </div>
        </div>
    </section>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>