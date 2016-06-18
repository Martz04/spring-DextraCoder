(function(){
	var app = angular.module("codeEditor", []);
	
	app.controller("TextController", ["$log", "$scope", "$http", function($log, $scope, $http){
		this.codeSent = false;
		this.consoleOutput = "wawa";
		var textController = this;
		angular.element(document).ready(function () {
			$scope.editor = ace.edit("editor");
    		$scope.editor.setTheme("ace/theme/eclipse");
    		$scope.editor.getSession().setMode("ace/mode/java");
		});
		this.submitCode = function() {
			var request = ({
				method: "POST",
				url: "compile",
				data: {problemId: 1, answer: $scope.editor.getValue()}
			});
			$http(request).then(function(data){
				textController.consoleOutput = data.data;
				$log.info(textController.consoleOutput);
				textController.codeSent = true;
			}, function(data){
				$log.info("error");
				textController.consoleOutput = data.data;
				textController.codeSent = true;
			});
		}
		this.isCodeSent = function() {
			return this.codeSent;
		}
	}]);
})();