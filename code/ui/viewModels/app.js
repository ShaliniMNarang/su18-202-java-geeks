'use strict';

var myApp = angular.module('myApp', [ 'ngRoute']);

 myApp.run(['$rootScope', function($rootScope) {

	$rootScope.orderURL = "http://104.197.190.88/api/orders/";
	$rootScope.userURL = "http://35.232.73.39/api/v1/users/";
	$rootScope.cardURL = "http://ec2co-ecsel-1m2a435d30sfq-1565654261.us-west-2.elb.amazonaws.com:5000/api/card/";
  $rootScope.paymentURL = "http://34.239.173.190:8080/api/payment/";
  $rootScope.userId = "1";
  $rootScope.minus = 0;
}]);
