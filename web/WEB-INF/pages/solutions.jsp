<jsp:include page="header.jsp"></jsp:include>
 <body ng-controller="SolutionController as solutionCtrl" ng-init="solutionCtrl.loadData()">
 	<jsp:include page="menu.jsp"></jsp:include>
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