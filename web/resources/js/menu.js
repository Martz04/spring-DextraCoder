/**
 * Functionality of the top menu bar
 */
(function() {
	var app = angular.module("menubar", []);
	app.controller("MenuController", function() {
		this.selected = 1;
		this.setSelected = function(index) {
			this.selected = index;
		}
		this.isSelected = function(index) {
			return this.selected === index;
		}
	});
})();