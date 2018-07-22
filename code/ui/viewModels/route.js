myApp.config(['$routeProvider', '$qProvider', '$locationProvider', '$httpProvider',

		function($routeProvider, $qProvider, $locationProvider, $httpProvider) {

	$locationProvider.hashPrefix('');

	$routeProvider.when("/", {
		templateUrl : "views/home.html",
		controller : "homeController"
	}).when("/menu", {
		templateUrl : "views/menu.html"
	}).when("/order", {
		templateUrl : "views/order.html"
	}).when("/reviewOrder", {
		templateUrl : "views/reviewOrder.html"
	}).when("/myCards", {
		templateUrl : "views/myCards.html"
	}).when("/login", {
		templateUrl : "views/login.html"
	}).when("/addCard", {
		templateUrl : "views/addCard.html"
	})
	
	
	.otherwise({redirectTo: "/"});;

	$qProvider.errorOnUnhandledRejections(false);

}]);
