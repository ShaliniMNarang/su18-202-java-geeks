'use strict';

var myApp = angular.module('myApp', [ 'ngRoute']);

 myApp.run(['$rootScope', function($rootScope) {

	$rootScope.orderURL = "http://104.197.190.88/api/orders/";
	$rootScope.userURL = "http://35.232.73.39/api/v1/users/";
	$rootScope.cardURL = "http://34.219.215.244:5000/api/card/";
  $rootScope.userId = "1";
}]);
