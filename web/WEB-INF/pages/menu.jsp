<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="principal" property="principal" />
<nav class="navbar navbar-default navbar-fixed-top" ng-controller="MenuController as menuCtrl">
  <div class="container">
  	<div class="nav navbar-nav navbar-left">
  		<h4>Logged as ${principal}</h4>
  	</div>
    <ul class="nav navbar-nav navbar-right">
    	<li ng-class="{active:menuCtrl.isSelected(1)}">
    		<a ng-click="menuCtrl.setSelected(1)" 
    		href="${pageContext.request.contextPath}/">Home</a>
    	<li ng-class="{active:menuCtrl.isSelected(2)}">
    		<a ng-click="menuCtrl.setSelected(2)" 
    		href="${pageContext.request.contextPath}/solve">Solve Problem</a>
    	<li ng-class="{active:menuCtrl.isSelected(4)}">
    		<a ng-click="menuCtrl.setSelected(4)" 
    		href="${pageContext.request.contextPath}/solutions">See your solutions</a>
    	<sec:authorize access="hasAuthority('Admin')">	
	    	<li ng-class="dropdown">
	    		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
	    		aria-haspopup="true" aria-expanded="false">Admin<span class="caret"></span></a>
	    		<ul class="dropdown-menu">
	    			<li><a href="${pageContext.request.contextPath}/admin/problemForm">Add Problem</a></li>
	    			<li><a href="${pageContext.request.contextPath}/admin/problemUsers">Map Problems</a></li>
	    		</ul> 
	    	</li>	
	    </sec:authorize>	
    </ul>
  </div>
</nav>