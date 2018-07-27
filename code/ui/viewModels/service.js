myApp.service('httpService',['$http','$location',function($http,$location){
		this.get=function(url){
			console.log("httpService get " + url);
			return $http.get(url);
		};
		this.post = function(postUrl, fd, config) {
			console.log("httpService post " + postUrl);
			return $http.post(postUrl, fd, config);
		}
}]);

myApp.service('card', function() {
	function Card(){
		this.setId=function(id){
			this.id=id;
		};

		this.getId=function(){
			return this.id;
		};

		this.setUserId=function(userId){
			this.userId=userId;
		};

		this.getUserId=function(){
			return this.userId;
		};

		this.setCardNumber=function(cardNumber){
			this.cardNumber=cardNumber;
		};

		this.getCardNumber=function(){
			return this.cardNumber;
		};

		this.setCardHolderName=function(cardHolderName){
			this.cardHolderName=cardHolderName;
		};

		this.getCardHolderName=function(){
			return this.cardHolderName;
		};

		this.setCardExpirationDate=function(cardExpirationDate){
			this.cardExpirationDate=cardExpirationDate;
		};

		this.getCardExpirationDate=function(){
			return this.cardExpirationDate;
		};

		this.setCardType=function(cardType){
			this.cardType=cardType;
		};

		this.getCardType=function(){
			return this.cardType;
		};

		this.setCardBalance=function(cardBalance){
			this.cardBalance=cardBalance;
		};

		this.getCardBalance=function(){
			return this.cardBalance;
		};

		this.setDefaultCard=function(defaultCard){
			this.defaultCard=defaultCard;
		};

		this.getDefaultCard=function(){
			return this.defaultCard;
		};

		this.setStatus=function(status){
			this.status=status;
		};

		this.getStatus=function(){
			return this.status;
		};

	}
	return new Card();
});


myApp.service('user', function() {
	function User(){
		this.setUserName=function(userName){
			this.userName=userName;
		};

		this.getUserName=function(){
			return this.userName;
		};

		this.setPassword=function(password){
			this.password=password;
		};

		this.getPassword=function(){
			return this.setPassword;
		};
	}
	return new User();
});

myApp.service('payment', function() {
	function Payment(){
		this.setCardId=function(cardId){
			this.cardId=cardId;
		};

		this.getCardId=function(){
			return this.cardId;
		};

		this.setOrderid=function(orderid){
			this.orderid=orderid;
		};

		this.getOrderid=function(){
			return this.orderid;
		};

		this.setAmount=function(amount){
			this.amount=amount;
		};

		this.getAmount=function(){
			return this.amount;
		};

		this.setUserid=function(userid){
			this.userid=userid;
		};

		this.getUserid=function(){
			return this.userid;
		};
	}
	return new Payment();
});
