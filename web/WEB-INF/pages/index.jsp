<jsp:include page="header.jsp"></jsp:include>
 <body ng-controller="TextController as textCtrl" ng-init="textCtrl.loadProblem()">
 	<jsp:include page="menu.jsp"></jsp:include>
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
          
          <button ng-hide="textCtrl.consoleOutput.finish" 
          	type="button" 
          	id="myButton" 
          	data-loading-text="Loading..." 
          	class="btn btn-default float-right block" 
          	ng-click="textCtrl.submitCode()"> Send Answer </button>
        
        	<a ng-show="textCtrl.consoleOutput.finish" href="${pageContext.request.contextPath}/index">Return</a>
        </div>
      </section>   
    </div>
  </body>
</html>