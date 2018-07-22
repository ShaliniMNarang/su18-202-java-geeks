myApp.service('httpService',['$http','$location',function($http,$location){
		var serverHost="http://localhost:5051"
		console.log("ServerHost " + serverHost);
		this.get=function(url){
			console.log("httpService get " + url);
			return $http.get(serverHost+url);
		};
		this.post = function(postUrl, fd, config) {
			return $http.post(serverHost+postUrl, fd, config);
		}
}]);

myApp.service('httpPost', [ '$http', function($http) {
	this.postCall = function(fd, postUrl) {
		console.log("postCall");
		$http.post(postUrl, fd, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}
		}).then(function(response) {
			console.log("response")
		})
	}
} ]);

myApp.service('operation', function() {
	var type = "Add";
	var id = null;

	return {
		getType : function() {
			return type;
		},
		setType : function(value) {
			type = value;
		},
		getId : function() {
			return type;
		},
		setId : function(value) {
			type = value;
		}
	}
});