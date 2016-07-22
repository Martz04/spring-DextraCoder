(function(){
	var app = angular.module("solutions", []);
	app.controller("SolutionController", ["$http", "$log", function($http, $log){
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
			$log.info(controller.tableData);
			controller.selected = controller.tableData[0];
			$log.info(controller.selected);
		}
	}]);
})();