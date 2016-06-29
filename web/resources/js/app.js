(function(){
	var app = angular.module("codeEditor", ["codeTimer"]);
	app.config(function($sceProvider) {
		$sceProvider.enabled(false);
	});
	app.controller("TextController", ["$log", "$scope", "$http", function($log, $scope, $http){
		this.codeSent = false;
		this.consoleOutput = "";
		this.problemParam= undefined;
		var textController = this;
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
		this.loadProblem = function() {
			$http.get("problem/random").then(function success(response) {
				textController.problemParam = response.data;
				$scope.editor = ace.edit("editor");
	    		$scope.editor.setTheme("ace/theme/eclipse");
	    		$scope.editor.$blockScrolling = "Infinity";
	    		$scope.editor.getSession().setMode("ace/mode/java");
	    		$scope.editor.insert("public ");
				$scope.editor.insert(textController.problemParam.outputParams);
				$scope.editor.insert(" solution(");
				$scope.editor.insert(textController.problemParam.inputParams);
				$scope.editor.insert("){\n\treturn\n}");
			}, function error(response){
				$log.info("Error" + response.data);
			});
		}
		this.startTimer = function() {
			
		}
		this.isCodeSent = function() {
			return this.codeSent;
		}
	}]);
	app.controller("FormController", ["$http", function($http){
		this.tab = 1;
		this.inputs = 1;
		this.setTab = function(value) {
			this.tab = value;
		};
		this.isSelected = function(value) {
			return this.tab === value;
		}
		this.setInputs = function(value) {
			this.inputs = value;
		};
		this.isInputSelected = function(value) {
			return this.inputs === value;
		}
	}]);
	var inputAtStart = {
		problemId: 23,
		title: "Sorting numbers",
		description: "<strong>Bubble sort</strong>, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the list to be sorted, compares each pair of adjacent items and swaps them if they are in the wrong order.<br><br> The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted.<br> The algorithm, which is a comparison sort, is named for the way smaller elements 'bubble' to the top of the list.<br> Although the algorithm is simple, it is too slow and impractical for most problems even when compared to insertion sort.[1] It can be practical if the input is usually in sorted order but may occasionally have some out-of-order elements nearly in position.",
		inputDescription: "An array of integers in an unsorted way",
		outputDescription: "An array of integers in a sorted way",
		problemInputOutputs: [
			{	problemInputOutputId: 1,
				inputData: "[56, 34, 23, 18, 5, 1, 67, 90]",
				outputData: "[1, 5, 18, 23, 34, 56, 67, 90]",}
		]
	}
})();