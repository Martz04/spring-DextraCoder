(function(){
	var app = angular.module("solutions", []);
	app.controller("SolutionController", ["$http", "$log", "$scope", function($http, $log, $scope){
		this.selected = {};
		this.tableData = [];
		var controller = this;
		this.loadData = function() {
			var request = ({
				method: "GET",
				url: "solutions/data"
			});
			$http(request).then(function(data){
				$log.info(data);
				controller.tableData = data.data;
			}, function(data){
				$log.info("error");
			});
		}
		this.selectRow = function(row) {
			$("#myModal").modal();
			$scope.editor.insert("");
			$log.info(controller.tableData);
			controller.selected = controller.tableData[row];
			$log.info(controller.selected);
			$scope.editor.insert("\t");
			$scope.editor.insert(controller.selected.solution);
		}
		$scope.aceSolutionLoaded = function(_editor) {
			_editor.setReadOnly(true);
			$scope.editor = _editor;
		}
	}]);
})();