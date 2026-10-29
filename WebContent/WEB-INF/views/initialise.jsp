<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
  <title>Initialise Screen</title>
  <script type="text/javascript" src="<c:url value="/webjars/jquery/3.7.1/jquery.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/javascript/index.js"/>"></script>
  <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/5.3.3/css/bootstrap.min.css"/>"/>
  <style>
 
  body {
    background-color: #EAE8FF; 
    color: #2E008B;  
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-size: 20px;
    background: url('<c:url value="/resources/Images/API.jpg"/>') no-repeat center center fixed;
  	background-size: cover;
  }

  .card.card-outline-secondary {
    border: 1px solid #ccc;
    border-radius: 10px;
    background-color: #ffffff;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    padding: 25px;
  }

  .card-header {
    background-color: #2E008B;
    color: white;
    padding: 15px 20px;
    border-radius: 10px 10px 0 0;
    text-align: center;
  }

  .card-body {
    padding: 20px 15px;
  }

  .form-group label {
    font-weight: 500;
    color: #2E008B;
    font-size: 20px;
  }

  select,
  input[type="text"] {
    border-radius: 5px !important;
    border: 1px solid #ccc;
    height: 35px;
    font-size: 20px;
    font-weight: 500;
  }

  .form-group {
    margin-bottom: 15px !important;
  }

  .btn-sm {
    padding: 8px 16px;
    font-weight: 600;
    font-size: 20px;
    border-radius: 5px;
  }

  .btn-sm i {
    margin-right: 5px;
  }

  .offset-md-2 {
    margin-left: auto;
    margin-right: auto;
  }

  @media (max-width: 768px) {
    .col-sm-4 {
      text-align: left !important;
      margin-bottom: 5px;
    }

    .col-sm-6,
    .col-md-6 {
      width: 100%;
    }

    .form-group.row {
      flex-direction: column;
    }
  }
  h1.mb-0 {
    font-size: 48px; /* Increase size */
    font-weight: bold;
    color: white;
    text-align: center;
    text-shadow: 
      2px 2px 0 #BBB,
      4px 4px 0 #999,
      6px 6px 0 #777;
    letter-spacing: 2px;
    margin-bottom: 20px;
    text-transform: uppercase;
  }
  .header-container {
    background-color: #0080FE;
    color: white;
    padding: 3px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    position: fixed;
    top: 10px;
    left: 0;
    width: calc(100% - 72px);
    z-index: 1000; /* Ensure header is above other content */
    margin-left: 34px;
    box-shadow: 10px 4px 4px #9AA2A2;
  }

  .header-container img {
    max-width: 140px;
    max-height: 97px;
    width: calc(100% - 40px);
    margin-right: 10px;
    top: 0;
    bottom: 0;
    left: 0;
    
  }

  .header-container h2 {
  	margin: 0;
    font-family: 'Arial Black', sans-serif;
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
    font-size: 3em;
    text-transform: uppercase;
    letter-spacing: 3px;
    white-space: nowrap;
    margin-left: auto;
    margin-right: 515px;
  }
</style>
  
</head>
<body>
<div class="header-container">
    <img src="<c:url value='/resources/Images/Design.jpg'/>" alt="Logo">
    <h2>DESIGN ON A DIME</h2>
</div>
<form:form name="initialise_form" autocomplete="off" action="api" method="POST">
<div class="content py-5" style="padding-top: 120px;">
  <div class="container">
	<div class="row">
	 <div class="col-12">
       <span class="anchor"></span>
         <div class="card card-outline-secondary">
           <div class="card-header">
             <h1 class="mb-0">Initialise</h1>
           </div>
          <div class="card-body">
          <div id="initialise_div" style="display:none;">
		   </div>
		   	<div class="form-group row row-bottom-margin ml-2" style="margin-bottom:5px;">
			    <label for="select_configuration_file" class="col-sm-4 col-form-label text-left">Select Configuration </label>
			    <div class="col-sm-6 col-md-6">
			      <select id="select_configuration_file" name="select_configuration_file" 
			      		class="brower-default custom-select custom-select-sm" onchange="processUserSelection(this)">
			          	<option value=""></option>
						<c:forEach items = "${configuration_files}" var = "config">
				          	<option value="${config.name}">${config.name}</option>
						</c:forEach>
			      </select>
			    </div>
			  </div>
			  <div class="form-group row row-bottom-margin ml-2" style="margin-bottom:5px;">
			    <label for="configuration_file_name" class="col-sm-4 col-form-label text-left">Configuration File Name </label>
			    <div class="col-sm-6 col-md-6">
		             <input type="text" id="configuration_file_name" name="configuration_file_name"
		             	class="form-control form-control-sm floatlabel"></input>
			    </div>
			  </div>
			  <div class="form-group row row-bottom-margin ml-2" style="margin-bottom:5px;">
			    <label for="selectedBroadcaster" class="col-sm-4 col-form-label text-left">Select Broadcaster </label>
			    <div class="col-sm-6 col-md-6">
			      <select id="selectedBroadcaster" name="selectedBroadcaster" class="browser-default custom-select custom-select-sm" 
			      		onchange="processUserSelection(this)">
					  <option value="ASIAN_HOCKEY_CHAMPIONS">Asian Hockey Champions</option>
			      	  <option value="Football">Football</option>
			      	  <option value="Cricket">Cricket</option>
			      	  <option value="AFC_Football">AFC Football</option>
			      	  <option value="KABADDI">KABADDI</option>
			      	  <option value="KABADDI_GIPKL">KABADDI GIPKL</option>
			          <option value="KABADDI_KADAMBA">KHELO INDIA KABADDI KADAMBA</option>
			          <option value="Tennis">Tennis</option>
			          <option value="Basketball">Basketball</option>
			          <option value="SWIMMING_TSR">SWIMMING TSR</option>
			          <option value="KHELO_INDIA">Khelo India</option>
			          <option value="BOXING">Boxing</option>
			          <option value="ISPL">ISPL</option>
			          <option value="GOLF">GOLF</option>
			      </select>
			    </div>
			  </div>
			<div id="hockey_source_url_div" class="form-group row row-bottom-margin ml-2" style="margin-bottom:5px; display:none;">
			    <label for="hockey_source_url" class="col-sm-4 col-form-label text-left">Individual Goal Scorer URL</label>
			    <div class="col-sm-6 col-md-6">
			        <input type="text" id="hockey_source_url" name="hockey_source_url" value="${session_configuration.competitionUrl}" class="form-control form-control-sm floatlabel" placeholder="https://tms.fih.ch/competitions/1942">
			    </div>
			</div>
			<div id="hockey_json_folder_div" class="form-group row row-bottom-margin ml-2" style="margin-bottom:5px; display:none;">
			    <label for="hockey_json_folder" class="col-sm-4 col-form-label text-left">JSON Folder</label>
			    <div class="col-sm-6 col-md-6">
			        <input type="text" id="hockey_json_folder" name="hockey_json_folder" value="${empty session_configuration.jsonOutputFolder ? 'C:\\Sports\\Hockey\\' : session_configuration.jsonOutputFolder}" class="form-control form-control-sm floatlabel" placeholder="C:\Sports\Hockey\">
			    </div>
			</div>
			  <div id="api_match_name" class="form-group row row-bottom-margin ml-2" style="margin-bottom:5px;">
			    <label for="api_match_name" class="col-sm-4 col-form-label text-left">Api Match Name </label>
			    <div class="col-sm-6 col-md-6">
		             <input type="text" id="api_match_name" name="api_match_name" value="${session_configuration.apiMatchName}"
		             	class="form-control form-control-sm floatlabel"></input>
			    </div>
			  </div>
			 <div id="pre_match_name" class="form-group row row-bottom-margin ml-2" style="margin-bottom:5px;">
			    <label for="pre_match_name" class="col-sm-4 col-form-label text-left">Pre Match Name </label>
			    <div class="col-sm-6 col-md-6">
		             <input type="text" id="pre_match_name" name="pre_match_name" value="${session_configuration.preMatchName}"
		             	class="form-control form-control-sm floatlabel"></input>
			    </div>
			  </div>	
			  <div id="source_file_path" class="form-group row row-bottom-margin ml-2" style="margin-bottom:5px;">
			    <label for="source_file_path" class="col-sm-4 col-form-label text-left">Source Path </label>
			    <div class="col-sm-6 col-md-6">
		             <input type="text" id="source_file_path" name="source_file_path" value="${session_configuration.source}"
		             	class="form-control form-control-sm floatlabel"></input>
			    </div>
			  </div>
			<div id="destination_file_path" class="form-group row row-bottom-margin ml-2" style="margin-bottom:5px;">
			    <label for="destination_file_path" class="col-sm-4 col-form-label text-left">Destination Path </label>
			    <div class="col-sm-6 col-md-6">
		             <input type="text" id="destination_file_path" name="destination_file_path" value="${session_configuration.destination}"
		             	class="form-control form-control-sm floatlabel"></input>
			    </div>
			  </div>
			<div id="update_time" class="form-group row row-bottom-margin ml-2" style="margin-bottom:5px;">
			    <label for="update_time" class="col-sm-4 col-form-label text-left">Time Interval(Match) </label>
			    <div class="col-sm-6 col-md-6">
		             <input type="text" id="update_time" name="update_time" value="1"
		             	class="form-control form-control-sm floatlabel"></input>
			    </div>
		   </div>
		   <div id="fixture_id" class="form-group row row-bottom-margin ml-2" style="margin-bottom:5px; display: none;">
			    <label for="fixture_id" class="col-sm-4 col-form-label text-left">Fixture ID </label>
			    <div class="col-sm-6 col-md-6">
		             <input type="text" id="fixture_id" name="fixture_id" value="${session_configuration.fixture_id}"
		             	class="form-control form-control-sm floatlabel"></input>
			    </div>
			 </div>
			  <div id="vizPortNumber_div" class="form-group row row-bottom-margin ml-2" style="margin-bottom:5px;">
			    <label for="vizPortNumber" class="col-sm-4 col-form-label text-left">Port Number 
			    	<i class="fas fa-asterisk fa-sm text-danger" style="font-size: 7px;"></i></label>
			    <div class="col-sm-6 col-md-6">
		             <input type="text" id="vizPortNumber" name="vizPortNumber" value="${session_configuration.portNumber}"
		             	class="form-control form-control-sm floatlabel"></input>
			    </div>
			  </div>
			  <div id="vizIPAddress_div" class="form-group row row-bottom-margin ml-2" style="margin-bottom:5px;">
			    <label for="vizIPAddress" class="col-sm-4 col-form-label text-left">IP Address 
			    	<i class="fas fa-asterisk fa-sm text-danger" style="font-size: 7px;"></i></label>
			    <div class="col-sm-6 col-md-6"> 
		             <input type="text" id="vizIPAddress" name="vizIPAddress" value="${session_configuration.ipAddress}"
		             		class="form-control form-control-sm floatlabel" ></input>
			    </div>
			  </div>
			
			  &nbsp;
		    <button style="background-color:#2E008B;color:#FEFEFE;" class="btn btn-sm" type="button"
		  		name="load_scene_btn" id="load_scene_btn" onclick="processUserSelection(this)">
		  		<i class="fas fa-film"></i> Load Scene</button>
	       </div>
	    </div>
       </div>
    </div>
  </div>
</div>
</form:form>
</body>
</html>