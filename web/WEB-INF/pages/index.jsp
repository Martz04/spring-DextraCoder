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
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-3.0.0.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/ace-builds/src-min-noconflict/ace.js" />" type="text/javascript" charset="utf-8"></script>
    <script src="<c:url value="/resources/js/app.js" />"></script>
  </head>
  <body ng-controller="TextController as textCtrl">
    <style type="text/css">
    #editor { 
        width: 500px;
        height: 500px;
        border: solid 1px silver;
        
    }
    </style>
    <div>
      <h2>Codigo:</h2>
      <div id="editor">
	public int solution(String[] args) {
	
	}
      </div>
      <button type="button" id="myButton" data-loading-text="Loading..." class="btn btn-primary" ng-click="textCtrl.submitCode()">
        Enviar codigo
      </button>
      <div  id="console" class="well well-lg" ng-show="textCtrl.isCodeSent()">
        Console output: <br>
        {{ textCtrl.consoleOutput.output }}
      </div>
    </div>
  </body>
</html>