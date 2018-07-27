/*controller : "homeController"*/
myApp.controller('homeController',function($scope, httpService, $location, $http, $rootScope) {
	console.log("homeController initialized");

	$scope.gotoLogin = function() {
			console.log("gotoLogin : start");
			$location.path("/login");
		}

});
/*controller : "homeController"*/

/*controller : "userController"*/
myApp.controller('userController',function($scope, httpService, $location, $http, $rootScope) {
	console.log("userController initialized");

	$scope.doLogin = function() {
			console.log("doLogin : start");
			var config= {
								transformRequest: angular.identity,
								headers: {'Content-Type': 'application/json'}
						};
			console.log("doLogin" + JSON.stringify($scope.user));

			httpService.post($rootScope.userURL+"authenticate",JSON.stringify($scope.user),config).then(function(response) {
				if(response.data){
					console.log("response.data" + JSON.stringify(response.data));
					if(response.data.message == "Failure") {
						alert("Login Failed!!! Invalid user name or password");
					}else {
						console.log("doLogin : successful");
						$rootScope.userName = $scope.user.userName;
						$location.path("/myCards");
					}
				}
			});
		}

});
/*controller : "userController"*/

/*controller : "cardController"*/
myApp.controller('cardController',function($scope, httpService, $location, $http, $rootScope) {
	console.log("cardController initialized");

	httpService.get($rootScope.cardURL+"user/"+$rootScope.userId).then(function(data){
		console.log("card data");
		console.log(data.data[0]);
		if(data.data[0] == undefined ) {
			$scope.card ={};
			$scope.card.cardBalance = 0.0;
		}else {
			$scope.card = data.data[0];
		}
	});

	$scope.addCard = function() {
			console.log("addCard1 : start");
			$location.path("/addCard");
		}

});
/*controller : "cardController"*/

/*controller : "addCardController"*/
myApp.controller('addCardController',function($scope, httpService, $location, $http, $rootScope) {
	console.log("addCardController initialized");

	$scope.addCard = function() {
			console.log("addCard2 : start" + $scope.cardNumber);
			if($scope.cardNumber.length > 9 ) {
				alert("Card Number cannot be more than 9 digits");
				return;

			}

			if($scope.cardCode.length > 3 ) {
				alert("Card Number cannot be more than 3 digits");
				return;

			}

			$scope.card = {};
			$scope.card.userId = $rootScope.userId;
			$scope.card.cardNumber = $scope.cardNumber;
			$scope.card.cardHolderName ="jadoe"; //$rootScope.userName;
			$scope.card.cardType ="CC";
			$scope.card.defaultCard = "Y";
			$scope.card.status = "A";
			$scope.card.cardBalance = 20;

			var config= {
								transformRequest: angular.identity,
								headers: {'Content-Type': 'application/json'}
						};
			console.log("add card" + JSON.stringify($scope.card));

			httpService.post($rootScope.cardURL,JSON.stringify($scope.card),config).then(function(response) {
				if(response.data){
					console.log("response.data" + JSON.stringify(response.data));
					$rootScope.cardId = response.data.id;
					$location.path("/myCards");
				}
			});
		}

});
/*controller : "addCardController"*/

/*orderController*/
myApp.controller('orderController',function($scope, httpService, $location, $http, $rootScope) {
	console.log("orderController initialized");
	$scope.order={};

	//TODO : REMOVE Hardcoded values, once user and other services are in place
	$scope.order.customerId=$rootScope.userId;
	$scope.order.orderDate=new Date();
	$scope.order.productId="P1";
	$scope.order.productName="Caffè Americano";
	$scope.order.amount=3.25;

	$scope.doSave = function() {
			console.log("doSave : start");
			var config= {
								transformRequest: angular.identity,
								headers: {'Content-Type': 'application/json'}
						};
			console.log("saveFormData" + JSON.stringify($scope.order));

			httpService.post($rootScope.orderURL,JSON.stringify($scope.order),config).then(function(response) {
				if(response.data){
					console.log("response.data" + JSON.stringify(response.data));
					$rootScope.orderId = response.data.orderId;
					$location.path("/reviewOrder");
				}
			});
		}

});
/*orderController*/
