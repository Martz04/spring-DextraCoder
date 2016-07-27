<nav class="navbar navbar-default navbar-fixed-top" ng-controller="MenuController as menuCtrl">
  <div class="container">
    <ul class="nav navbar-nav navbar-right">
    	<li ng-class="{active:menuCtrl.isSelected(1)}">
    		<a ng-click="menuCtrl.setSelected(1)" 
    		href="${pageContext.request.contextPath}/index">Home</a>
    	<li ng-class="{active:menuCtrl.isSelected(2)}">
    		<a ng-click="menuCtrl.setSelected(2)" 
    		href="${pageContext.request.contextPath}/index">Solve Problem</a>
    	<li ng-class="{active:menuCtrl.isSelected(3)}">
    		<a ng-click="menuCtrl.setSelected(3)" 
    		href="${pageContext.request.contextPath}/admin/problemForm">Add Problem</a>
    	<li ng-class="{active:menuCtrl.isSelected(4)}">
    		<a ng-click="menuCtrl.setSelected(4)" 
    		href="${pageContext.request.contextPath}/solutions">See your solutions</a>
    </ul>
  </div>
</nav>