var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http) {

    $scope.refreshCart = function () {
        $http.get('/NikeShop/rest/cart/' + $scope.cartId + '.htm').success(function (data) {
            $scope.cart = data;
            if (data.grandTotal===0){
                let element = document.getElementById("btnCheckOut");
                element.classList.add("disabled");
            }
        });
    };

    $scope.clearCart = function () {
        $http.delete('/NikeShop/rest/cart/' + $scope.cartId + '.htm').success(function () {

            $scope.refreshCart();
        });
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart();
    };

    $scope.addToCart = function (productId) {

        $http.put('/NikeShop/rest/cart/add/' + productId + '.htm').success(function () {
            alert('Product successfully added to the cart!');
        });
    };

    $scope.removeFromCart = function (productId) {

        $http.put('/NikeShop/rest/cart/remove/' + productId + '.htm').success(function () {

            $scope.refreshCart();

        });
    };
});
