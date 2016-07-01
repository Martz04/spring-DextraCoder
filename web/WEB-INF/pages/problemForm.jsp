<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en" ng-app="codeEditor">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Problem</title>
    <link href="<c:url value='/resources/css/styles.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-3.0.0.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/js/timer.js" />"></script>
    <script src="<c:url value="/resources/js/form.js" />"></script>
    <script src="<c:url value="/resources/js/app.js" />"></script>
  </head>
  <body ng-controller="FormController as formCtrl">
	<div class="wrapper grouping">
		<section class="column float-left panel panel-default">
			<h3>Add a new problem</h3>
			<ul class="nav nav-pills">
			  <li role="presentation" ng-class="{active:formCtrl.isSelected(1)}">
			  	<a href="#" ng-click="formCtrl.setTab(1)">Problem Description</a>
			  </li>
			  <li role="presentation" ng-class="{active:formCtrl.isSelected(2)}">
			  	<a href="#" ng-click="formCtrl.setTab(2)">Problem Inputs and Outputs</a>
			  </li>
			</ul>
			<form name="problemForm" class="panel-body" novalidate>
				<div ng-show="formCtrl.isSelected(1)">
					<div class="form-group">
						<label for="problemTitle">Problem Title</label>
						<input type="text" required 
						class="form-control" placeholder="Title" ng-model="formCtrl.problem.title">
					</div>
					<div class="form-group">
						<label for="problemDescription">Problem Description</label>
						<textarea rows="5" class="form-control" required
						placeholder="Description" ng-model="formCtrl.problem.description"></textarea>
					</div>
					<div class="form-group">
						<label for="inputDescription">Input Description</label>
						<textarea rows="3" class="form-control" required 
						placeholder="Description" ng-model="formCtrl.problem.inputDescription"></textarea>
					</div>
					<div class="form-group">
						<label for="problemTitle">Output Description</label>
						<textarea rows="3" class="form-control" required
						placeholder="Description" ng-model="formCtrl.problem.outputDescription"></textarea>
					</div>
				</div>
				<div ng-show="formCtrl.isSelected(2)">
					<label>Select The # of Inputs&Outputs one is mandatory</label>
					<div class="btn-group">
					  <button type="button" class="btn btn-default" 
					  ng-class="{active:formCtrl.isInputSelected(1)}" ng-click="formCtrl.setInputs(1)">1</button>
					  <button type="button" class="btn btn-default" 
					  ng-class="{active:formCtrl.isInputSelected(2)}" ng-click="formCtrl.setInputs(2)">2</button>
					  <button type="button" class="btn btn-default" 
					  ng-class="{active:formCtrl.isInputSelected(3)}" ng-click="formCtrl.setInputs(3)">3</button>
					</div>
					<div class="form-group">
						<label for="problemInput">Problem Input #1</label>
						<input type="text" required 
						class="form-control" placeholder="[1,5,6,3,7]"
						ng-model="formCtrl.problem.problemInputOutputs[0].input">
					</div>
					<div class="form-group">
						<label for="problemInput">Problem Output #1</label>
						<input type="text" required
						class="form-control" placeholder="[1,3,5,6,7]"
						ng-model="formCtrl.problem.problemInputOutputs[0].output">
					</div>
					<div ng-show="formCtrl.inputs > 1">
						<div class="form-group">
							<label for="problemInput">Problem Input #2</label>
							<input type="text" class="form-control" placeholder="[1,5,6,3,7]"
							ng-model="formCtrl.problem.problemInputOutputs[1].input">
						</div>
						<div class="form-group">
							<label for="problemInput">Problem Output #2</label>
							<input type="text" class="form-control" placeholder="[1,3,5,6,7]"
							ng-model="formCtrl.problem.problemInputOutputs[1].output">
						</div>
					</div>
					<div ng-show="formCtrl.inputs === 3">
						<div class="form-group">
							<label for="problemInput">Problem Input #3</label>
							<input type="text" class="form-control" placeholder="[1,5,6,3,7]"
							ng-model="formCtrl.problem.problemInputOutputs[2].input">
						</div>
						<div class="form-group">
							<label for="problemInput">Problem Output #3</label>
							<input type="text" class="form-control" placeholder="[1,3,5,6,7]"
							ng-model="formCtrl.problem.problemInputOutputs[2].output">
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-default float-right" 
					ng-click="formCtrl.saveData()">Save Problem</button>
					<div>{{problemForm.$valid}}</div>
			</form>	
		</section>
		<section class="column float-left">
			<div class="panel-body">
				<h3>Live Preview</h3>
				<strong>Title:</strong><br>
				<h4>{{formCtrl.problem.title}}</h4>
				<strong>Description:</strong><br>
				<p ng-bind-html="formCtrl.problem.description"></p>
				<strong>Input Description:</strong><br>
				<p ng-bind-html="formCtrl.problem.inputDescription"></p>
				<strong>Input Data:</strong><br>
				<p>{{formCtrl.problem.problemInputOutputs[0].input}}</p>
				<strong>Output Description:</strong><br>
				<p ng-bind-html="formCtrl.problem.outputDescription"></p>
				<strong>Output Data:</strong><br>
				<p>{{formCtrl.problem.problemInputOutputs[0].output}}</p>
			</div>
		</section>
	</div>
</body>
</html>