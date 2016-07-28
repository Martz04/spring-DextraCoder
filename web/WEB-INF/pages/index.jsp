<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
 <body ng-controller="TextController as textCtrl" ng-init="textCtrl.loadProblem()">
 	<jsp:include page="menu.jsp"></jsp:include>
    <div class="wrapper">
     	<h1>Instructions</h1>
     	<h3>About Menu Links</h3>
     	<p>
     		<strong>Home</strong> link will take you to this page.<br>
     		<strong>Solve Problem</strong> link will present you a new problem to solve. <br>
     		<strong>See your solutions</strong> link will show you the solutions you made
     		to the problems at Dextra Coder.<br>
     		<sec:authorize access="hasAuthority('Admin')">
     			<strong>Admin</strong> You have the option to add a new problem and to map a 
     			problem to a set of users.<br>	
     		</sec:authorize>
     	</p>
     	<h3>Solve Problem</h3>
     	<p>
     		You will be presented with a screen similar to this one: <br>
     		<figure>
     			<img alt="solved Problem" src="<c:url value='/resources/img/sample1.png' />">
     		</figure>
     		<h3>The left panel</h3> It contains instructions of the problem you need to solve.<br>
     		The panel have the following components: <br>
     		<ul class="list-group">
     			<li class="list-group-item"><strong>Title & Description</strong>: The description of the problem to solve.</li>
     			<li class="list-group-item"><strong>Input Description</strong>: Every problem gets an input paramter, this part explains what that paramater is.</li>
     			<li class="list-group-item"><strong>Output Description</strong>: Every problem returns an output parameter it can be a single number, a string or even an array, this part explains what to return.</li>
     			<li class="list-group-item"><strong>Input Data</strong>: A sample test of the input data.</li>
     			<li class="list-group-item"><strong>Output Data</strong>: A sample test of the output data. **The problem sometimes is validated against different test cases.</li>
     		</ul>
     		<h3>The right Panel</h3> It's the code panel, where you should implement your solution.<br>
     		The method signature changes depending on the problem you are solving. What should <strong>never</strong> change is the method name.
     		<p>
     			When you send your code for validation to the server, this method is appended to a master file, which then is compiled and all test cases run against it.
     			The master file contains the following package imports for your convenience:
     			<ul class="list-group">
     				<li class="list-group-item">import java.util.*;</li>
     				<li class="list-group-item">import java.util.regex.*;</li>
     				<li class="list-group-item">import java.math.*;</li>
     				<li class="list-group-item">import java.time.*;</li>
     			</ul>
     			So you can use them without worrying to import those classes.
     		</p>
     		<h3>The Bottom Panel</h3> It's the console you can see errors while compiling your code or how your code fares with the hidden test cases.
     	</p>
    </div>
  </body>
</html>