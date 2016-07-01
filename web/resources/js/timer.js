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
	app.controller("TimerController", ["$rootScope", "$log", "$http", "$timeout", "$interval", function($rootScope, $log, $http, $timeout, $interval){
		$rootScope.counter = 0;
		this.onTimeout = function() {
			var request = ({
				method: "POST",
				url: "timeout",
				data: {problemId: $rootScope.problemId, answer: $rootScope.editor.getValue()}
			});
			$http(request).then(function(data){
				$log.info(data);
			}, function(data){
				$log.info("error");
			});
		}
		this.repeatTime = function() {
			$rootScope.counter++;
		}
		var timeoutCounter = $timeout(this.onTimeout, 10000);
		
		$interval(this.repeatTime, 1000);	
				
	}]);
})();