(function(){
	var app = angular.module("codeEditor", ["codeTimer", "problemForm", "solutions", "ui.ace"]);
	app.config(function($sceProvider) {
		$sceProvider.enabled(false);
	});
	app.controller("TextController", ["$log", "$rootScope", "$http", "$filter", "$interval", "$timeout", function($log, $rootScope, $http, $filter, $interval, $timeout){
		this.codeSent = false;
		this.consoleOutput = "";
		this.problemParam= undefined;
		var textController = this;
		$rootScope.codeResponse = function(data){
			textController.consoleOutput = data.data;
			$log.info(textController.consoleOutput);
			textController.codeSent = true;
			if(textController.consoleOutput.finish) {
				$interval.cancel($rootScope.intervalPromise);
				$timeout.cancel($rootScope.timeoutCounter);
			}
		}
		this.submitCode = function() {
			var request = ({
				method: "POST",
				url: "compile",
				data: {problemId: $rootScope.problemId, answer: $rootScope.editor.getValue(), time: $filter('clock')($rootScope.counter)}
			});
			$http(request).then($rootScope.codeResponse, function(data){
				$log.info("error");
				textController.consoleOutput = data.data;
				textController.codeSent = true;
			});
		}
		this.loadProblem = function() {
			$http.get("problem/random").then(function success(response) {
				textController.problemParam = response.data;
				$rootScope.problemId = response.data.problem.problemId;
				$rootScope.editor.$blockScrolling = "Infinity";
				$rootScope.editor.insert("public ");
				$rootScope.editor.insert(textController.problemParam.outputParams);
				$rootScope.editor.insert(" solution(");
				$rootScope.editor.insert(textController.problemParam.inputParams);
				$rootScope.editor.insert("){\n\treturn args;\n}");
			}, function error(response){
				$log.info("Error" + response.data);
			});
		}
		$rootScope.aceLoaded = function(_editor) {
			$rootScope.editor = _editor;
		}
		this.isCodeSent = function() {
			return this.codeSent;
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