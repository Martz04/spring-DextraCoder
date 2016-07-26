<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en" ng-app="codeEditor">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Solutions</title>
    <link href="<c:url value='/resources/css/styles.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    <script   src="https://code.jquery.com/jquery-2.2.4.min.js"   integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="   crossorigin="anonymous"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/ace-builds/src-min-noconflict/ace.js" />" type="text/javascript" charset="utf-8"></script>
    <script src="<c:url value="/resources/js/ui-ace.js" />"></script>
    <script src="<c:url value="/resources/js/timer.js" />"></script>
    <script src="<c:url value="/resources/js/solution.js" />"></script>
    <script src="<c:url value="/resources/js/form.js" />"></script>
    <script src="<c:url value="/resources/js/app.js" />"></script>
  </head>
 <body ng-controller="SolutionController as solutionCtrl" ng-init="solutionCtrl.loadData()">
 	<section class="wrapper">
		<div class="page-header">
	  		<h1>Solved Problems</h1>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Elapsed Time</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="solution in solutionCtrl.tableData track by $index" ng-click="solutionCtrl.selectRow($index)">
					<td>{{solution.problemId}}</td>
					<td>{{solution.title}}</td>
					<td>{{solution.elapsedTime}}</td>
				</tr>
			</tbody>
		</table>
	</section> 
	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">{{solutionCtrl.selected.title}}</h4>
	      </div>
	      <div class="modal-body grouping">
	        <div class="column-alt float-left panel panel-default">
	          <div class="panel-body">
				<p ng-bind-html="solutionCtrl.selected.description"></p>
	            <strong>Input Description:</strong><br>
	            <p ng-bind-html="solutionCtrl.selected.inputDescription"></p>
	            <strong>Output Description:</strong><br>
	            <p ng-bind-html="solutionCtrl.selected.outputDescription"></p>
<!-- 	            <strong>Input Data:</strong><br> -->
<!-- 	            <p>{{textCtrl.problemParam.problem.problemInputOutputs[0].input}}</p> -->
<!-- 	            <strong>Output Data:</strong><br> -->
<!-- 	            <p>{{textCtrl.problemParam.problem.problemInputOutputs[0].output}}</p> -->
	          </div>
	        </div><!-- colum -->
	        <div class="column-alt float-left">
	        	<div ui-ace="{
		          	useWrapMode : false,
		  			showGutter: true,
		  			theme:'eclipse',
		  			mode: 'java',
		  			onLoad: aceSolutionLoaded
		          }"></div>
	    	</div>    
	      </div><!-- modal-body -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div><!-- modal-content -->
	  </div><!-- modal-dialog -->
	</div><!-- #myModal -->
 </body>
</html>