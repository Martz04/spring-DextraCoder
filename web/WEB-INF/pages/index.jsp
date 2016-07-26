<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en" ng-app="codeEditor">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Text Code Editor</title>
    <link href="<c:url value='/resources/css/styles.css' />" rel="stylesheet">
    <script   src="https://code.jquery.com/jquery-2.2.4.min.js"   integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="   crossorigin="anonymous"></script>
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    <script src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/ace-builds/src-min-noconflict/ace.js" />" type="text/javascript" charset="utf-8"></script>
    <script src="<c:url value="/resources/js/ui-ace.js" />"></script>
    <script src="<c:url value="/resources/ace-builds/src-min-noconflict/ext-language_tools.js" />"></script>
    <script src="<c:url value="/resources/js/timer.js" />"></script>
    <script src="<c:url value="/resources/js/solution.js" />"></script>
    <script src="<c:url value="/resources/js/form.js" />"></script>
    <script src="<c:url value="/resources/js/app.js" />"></script>
  </head>
 <body ng-controller="TextController as textCtrl" ng-init="textCtrl.loadProblem()">
    <div class="wrapper">
      <div class="clear">
      	<h1 class="inline">Dextra Code Skills</h1>
      	<span ng-controller="TimerController as timerCtrl"
      		class="timer">{{counter | clock}}</span>
      </div>
      <section class="section grouping">
        <div class="column float-left panel panel-default">
          <div class="panel-body">
            <h4>{{textCtrl.problemParam.problem.title}}</h4>
			<p ng-bind-html="textCtrl.problemParam.problem.description"></p>
            <strong>Input Description:</strong><br>
            <p ng-bind-html="textCtrl.problemParam.problem.inputDescription"></p>
            <strong>Output Description:</strong><br>
            <p ng-bind-html="textCtrl.problemParam.problem.outputDescription"></p>
            <strong>Input Data:</strong><br>
            <p>{{textCtrl.problemParam.problem.problemInputOutputs[0].input}}</p>
            <strong>Output Data:</strong><br>
            <p>{{textCtrl.problemParam.problem.problemInputOutputs[0].output}}</p>
          </div>
        </div>
        <div class="column column-alt float-left grouping">
          <div ui-ace="{
          	require: ['ace/ext/language_tools'],
          	advanced: {
          		enableSnippets: true,
      			enableBasicAutocompletion: true,
      			enableLiveAutocompletion: true
          	},
          	useWrapMode : false,
  			showGutter: true,
  			theme:'eclipse',
  			mode: 'java',
  			onLoad: aceLoaded
          }"> </div>
          <div  id="console" class="panel panel-default console block clear">
          	Console output: <br> 
          	{{textCtrl.consoleOutput.output}} <br>
          	<div ng-repeat="solution in textCtrl.consoleOutput.solutions">
          		<h5> {{solution.detail}}<span class="label" 
          		ng-class="solution.passed ? 'label-success' : 'label-danger'">{{$index + 1}}</span></h5>
          		
          	</div>
          </div> 
          <button ng-hide="textCtrl.consoleOutput.finish" type="button" id="myButton" data-loading-text="Loading..." class="btn btn-default float-right block" ng-click="textCtrl.submitCode()"> Enviar codigo </button>
        <a ng-show="textCtrl.consoleOutput.finish" href="${pageContext.request.contextPath}/index">Return</a>
        </div>
      </section>   
    </div>
  </body>
</html>