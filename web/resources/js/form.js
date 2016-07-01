(function(){
	var app = angular.module("problemForm", []);
	app.controller("FormController", ["$http", "$log", function($http, $log){
		this.tab = 1;
		this.inputs = 1;
		var formController = this;
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
		};
		this.problem = {
				title: "",
				description: "",
				inputDescription: "",
				outputDescription: "",
				problemInputOutputs: []
		};
		this.saveData = function() {
			$log.info(formController.problem);
			var request = ({
				method: "POST",
				url: "problemForm/save",
				data: formController.problem
			});
			$http(request).then(function(data){
				formController.problem = {
						title: "",
						description: "",
						inputDescription: "",
						outputDescription: "",
						problemInputOutputs: []
				};
				$log.info(data);
			}, function(data){
				$log.info("error");
			});
		}
	}]);
})();