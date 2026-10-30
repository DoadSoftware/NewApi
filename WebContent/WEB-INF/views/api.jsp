<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
  <title>API</title>
  <script type="text/javascript" src="<c:url value="/webjars/jquery/3.7.1/jquery.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/javascript/index.js"/>"></script>
  <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/5.3.3/css/bootstrap.min.css"/>"/>
  
  <script type="text/javascript">
  document.addEventListener('DOMContentLoaded', insertTables); 
  $(document).on("keydown", function(e){
	  
	//if(session_selected_broadcaster != ' '){
		if(e.key === "F1" || e.key === "F3" || e.key === "F5" || e.key === "F6" || e.key === "F7" || e.key === "F11" || e.key === "F12" 
			  || e.key === "ArrowDown" || e.key === "ArrowUp" || e.key === " ") {
	      // Suppress default behaviour 
	      // e.g. F1 in Chrome on Windows usually opens Windows help
	      e.preventDefault();
	      processUserSelectionData('LOGGER_FORM_KEYPRESS',e.which);
	  }else if(e.altKey && e.key === 's'){
		  e.preventDefault()
		  processUserSelectionData('LOGGER_FORM_KEYPRESS','SPEED');
	  }else if(e.altKey && e.key === 'r'){
		  e.preventDefault()
		  processUserSelectionData('LOGGER_FORM_KEYPRESS','RE_READ');
	  }else{
		  //alert(live_match.matchInfo.contestant[0].name)
		  processUserSelectionData('LOGGER_FORM_KEYPRESS',e.which);
	  }
  });
  function updateConnectionSignal(status) {

	    if (!status) return;
	    if (status === "connected") {

	        $("#CheckConnection_div").html(
	            '<div class="connection-wrapper">' +
	            '<div class="led green blink"></div>' +
	            '<span style="color:#00aa00;">API CONNECTED</span>' +
	            '</div>'
	        );

	    } else {

	        $("#CheckConnection_div").html(
	            '<div class="connection-wrapper">' +
	            '<div class="led red blink"></div>' +
	            '<span style="color:#cc0000;">API ERROR</span>' +
	            '</div>'
	        );

	        console.log("API Error:", status);
	    }
	}
  </script>  
<style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            font-family: Arial, sans-serif;
        }
        th, td {
            border: 3px solid white;
            padding: 8px;
            text-align: center;
            color: black;
        }
        .thead-dark { background-color: #343a40; color: white; }
        th { background-color: #f2f2f2; }
        .table { width: 100%; }
        .table-bordered { border: 3px solid black; }
    </style>
<style>
.flex-container {
    display: flex;
    flex-wrap: wrap; 
    gap: 0px; 
    justify-content: center;
    align-items: center; 
}

.flex-item {
    /* flex-grow: 1; 
    flex-shrink: 1;  */
    flex-shrink: 1;
    flex-basis: auto; 
    padding: 0px; 
    box-sizing: border-box;
}

</style>
</head>
<body onload="afterPageLoad('API');">
<form:form name="api_form" autocomplete="off" action="api" method="POST" enctype="multipart/form-data">
<div class="content py-5" style="background-color: #EAE8FF; color: #2E008B">
  <div class="container">
	<div class="row">
	 <div class="col-md-8 offset-md-2">
       <span class="anchor"></span>
         <div class="card card-outline-secondary">
           <div class="card-header">
           </div>
            <label id ="expiry_date"><h5><b>EXPIRY DATE : ${expiry_message} </b></h5></label>
          <div class="card-body">
			  <div class="panel-group" id="match_configuration">
			    <div class="panel panel-default">
			      <div class="panel-heading">
			        <h4 class="panel-title">
			          <a data-bs-toggle="collapse" href="#load_setup_match">Configuration</a>
			        </h4>
			      </div>
			      <div id="load_setup_match" class="panel-collapse collapse">
					<div class="panel-body">
 					  <div id="start_pause_match_time_div" style="margin-bottom:5px;">
						<div class="row">
						</div>
					  </div> 
				    </div>
			      </div>
			    </div>
			  </div> 
			<div id="CheckConnection_div"></div> 
		    <div class="form-group row row-bottom-margin ml-2 flex-container" style="margin-bottom:5px;">
						<!-- <p class="custom-paragraph">
						   <b> | SEASONAL STATS | S | &emsp;&emsp; | Live Match | | L |</b>
						</p> -->
			    <div id="select_event_div" class="flex-item" style="display:none;"></div>
			    <div id="api_div" class="flex-item" style="display:none;"></div>
			    <div id="select_div" class="flex-item" style="display:none;"></div>
			</div>
          </div>
         </div>
       </div>
    </div>
  </div>
 </div>
 	<!-- <table class="table table-bordered table-striped text-center" style="width:350px; margin:10px auto;">
    <thead class="table-dark">
        <tr>
            <th>Key Press</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><b>F1</b></td>
            <td>Current Match</td>
        </tr>
        <tr>
            <td><b>F2</b></td>
            <td>Pre Match</td>
        </tr>
    </tbody>
</table> -->		
 <input type="hidden" name="selectedBroadcaster" id="selectedBroadcaster" value="${session_selected_broadcaster}"/>
 <input type="hidden" name="api_match_name" id="api_match_name" value="${session_api_match_name}"/>
 <input type="hidden" name="source_file_path" id="source_file_path" value="${session_source_path}"/>
 <input type="hidden" name="destination_file_path" id="destination_file_path" value="${session_destination_path}"/>
 <input type="hidden" name="update_time" id="update_time" value="${session_update_time}"/>
  <input type="hidden" name="fixture_id" id="fixture_id" value="${session_fixture_id}"/>
 
</form:form>
</body>
</html>