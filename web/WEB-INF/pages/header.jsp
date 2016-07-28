<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html lang="en" ng-app="codeEditor">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dextra Coder</title>
    <link href="<c:url value='/resources/css/styles.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    <script   src="https://code.jquery.com/jquery-2.2.4.min.js"   integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="   crossorigin="anonymous"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/ace-builds/src-min-noconflict/ace.js" />" type="text/javascript" charset="utf-8"></script>
    <script src="<c:url value="/resources/ace-builds/src-min-noconflict/ext-language_tools.js" />"></script>
    <script src="<c:url value="/resources/js/ui-ace.js" />"></script>
    <script src="<c:url value="/resources/js/timer.js" />"></script>
    <script src="<c:url value="/resources/js/solution.js" />"></script>
    <script src="<c:url value="/resources/js/form.js" />"></script>
    <script src="<c:url value="/resources/js/menu.js" />"></script>
    <script src="<c:url value="/resources/js/app.js" />"></script>
  </head>