myApp.config(['$routeProvider', '$qProvider', '$locationProvider', '$httpProvider',

		function($routeProvider, $qProvider, $locationProvider, $httpProvider) {

	$locationProvider.hashPrefix('');

	$routeProvider.when("/", {
		templateUrl : "views/home.html",
		controller : "homeController"
	}).when("/menu", {
		templateUrl : "views/menu.html"
	}).when("/order", {
		templateUrl : "views/order.html",
		controller : "orderController"
	}).when("/reviewOrder", {
		templateUrl : "views/reviewOrder.html",
		controller: "payController"
	}).when("/myCards", {
		templateUrl : "views/myCards.html",
		controller: "cardController"
	}).when("/login", {
		templateUrl : "views/login.html",
		controller : "userController"
	}).when("/addCard", {
		templateUrl : "views/addCard.html",
		controller: "addCardController"
	})


	.otherwise({redirectTo: "/"});;

	$qProvider.errorOnUnhandledRejections(false);

}]);
