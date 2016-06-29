(function(){
	var app = angular.module("codeTimer", []);
	app.filter("clock", function(){
		return function(input){
			var seconds = input % 60;
			var totalMinutes = Math.floor(input / 60);
			var minutes = totalMinutes % 60;
			var minutesText = "";
			var secondsText = "";
			if(minutes < 10) {
				minutesText = "0".concat(minutes.toString()); 
			}else {
				minutesText = minutes.toString();
			}
			if(seconds < 10){
				secondsText = "0".concat(seconds.toString()); 
			}else{
				secondsText = seconds.toString();
			}
			return minutesText.concat(":").concat(secondsText);
		}
	});
	app.controller("TimerController", ["$rootScope", "$timeout", "$interval", function($rootScope, $timeout, $interval){
		$rootScope.counter = 0;
		$rootScope.onTimeout = function() {
			//TODO
		}
		this.repeatTime = function() {
			$rootScope.counter++;
		}
		var timeoutCounter = $timeout($rootScope.onTimeout, 10000);
		
		$interval(this.repeatTime, 1000);	
				
	}]);
})();