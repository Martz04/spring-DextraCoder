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
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-3.0.0.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/ace-builds/src-min-noconflict/ace.js" />" type="text/javascript" charset="utf-8"></script>
    <script src="<c:url value="/resources/js/app.js" />"></script>
  </head>
 <body ng-controller="TextController as textCtrl" ng-init="textCtrl.loadProblem()">
    <div class="wrapper">
      <h1>Dextra Coder</h1>
      <section class="section grouping">
        <div class="column float-left panel panel-default">
          <div class="panel-body">
            <h4>{{problem.title}}</h4>
            <p ng-bind-html="problem.description"></p>
            <strong>Input Description:</strong><br>
            <p ng-bind-html="problem.inputDescription"></p>
            <strong>Output Description:</strong><br>
            <p ng-bind-html="problem.outputDescription"></p>
            <strong>Input Data:</strong><br>
            <p>{{problem.problemInputOutputs[0].inputData}}</p>
            <strong>Output Data:</strong><br>
            <p>{{problem.problemInputOutputs[0].outputData}}</p>
          </div>
        </div>
        <div class="column column-alt float-left grouping">
          <div id="editor" class="panel panel-default">
	public int solution(String[] args) {
	
	}
      </div>
          <div  id="console" class="console block clear" ng-show="textCtrl.isCodeSent()">
            Console output
            {{textCtrl.consoleOutput.output}}
          </div> 
          <button type="button" id="myButton" data-loading-text="Loading..." class="btn btn-default float-right block" ng-click="textCtrl.submitCode()"> Enviar codigo </button>
        </div>
      </section>   
    </div>
  </body>
</html>