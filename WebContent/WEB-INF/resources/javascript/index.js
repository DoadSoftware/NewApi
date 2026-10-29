var session_auction, session_sports,live_match;
var graphics,preGraphic='';
var homeColour='blue',awayColour='#FF7F7F';awayTextColour='white',homeTextColour='white';
var matchTimeInterval = null;
const teams = {
        team1: {
            cornerTaken: 0,foulsWon: 0,shotOnTarget: 0,shots: 0,saves: 0,crosses: 0,passes: 0,accuratePass: 0,touches: 0,
            tackles: 0,dribbles: 0,interceptions: 0,possession: 0, chancesCreated: 0,offside: 0, goals: 0,yellowCards:0,passingAccuracy :0
        },
        team2: {
           cornerTaken: 0,foulsWon: 0,shotOnTarget: 0,shots: 0,saves: 0,crosses: 0,passes: 0,accuratePass: 0,touches: 0,
            tackles: 0,dribbles: 0,interceptions: 0,possession: 0, chancesCreated: 0, offside: 0,goals: 0,yellowCards:0,passingAccuracy :0
        }
    };

function processWaitingButtonSpinner(whatToProcess) 
{
	switch (whatToProcess) {
	case 'START_WAIT_TIMER': 
		$('.spinner-border').show();
		$(':button').prop('disabled', true);
		break;	case 'END_WAIT_TIMER': 
		$('.spinner-border').hide();
		$(':button').prop('disabled', false);
		break;
	}
}
function updateConnectionSignal(status) {

    if (status === "connected") {

        $("#CheckConnection_div").html(
            '<span style="color:green; font-weight:bold;">● CONNECTED</span>'
        );

    } else {

        $("#CheckConnection_div").html(
            '<span style="color:red; font-weight:bold;">● ERROR</span>'
        );

        console.log("API Error:", status);
    }
}
function displayMatchTime() {
    processApiProcedures('READ-APIMATCH-AND-POPULATE', graphics);
}

function startMatchTimeUpdate() {
    clearInterval(matchTimeInterval);
    var refreshSeconds = parseInt($('#update_time').val(), 10);
    if (isNaN(refreshSeconds) || refreshSeconds < 1) refreshSeconds = 15;
    console.log('Starting Asian Hockey refresh timer:', refreshSeconds, 'seconds');
    matchTimeInterval = setInterval(function() {
        console.log('Asian Hockey timer tick:', new Date().toLocaleTimeString());
        displayMatchTime();
    }, refreshSeconds * 1000);
}

function initialiseForm(whatToProcess,dataToProcess)
{
	switch (whatToProcess){
	case 'UPDATE-CONFIG':
		document.getElementById('configuration_file_name').value = $('#select_configuration_file option:selected').val();
		document.getElementById('selectedBroadcaster').value = dataToProcess.broadcaster;
		document.getElementById('api_match_name').value = dataToProcess.apiMatchName;
		document.getElementById('pre_match_name').value = dataToProcess.preMatchName;
		document.getElementById('source_file_path').value = dataToProcess.source;
		document.getElementById('destination_file_path').value = dataToProcess.destination;
		document.getElementById('update_time').value = dataToProcess.updateTime;
		document.getElementById('vizPortNumber').value = dataToProcess.portNumber;
		document.getElementById('vizIPAddress').value = dataToProcess.ipAddress;
		document.getElementById('fixture_id').value = dataToProcess.fixture_id;
		break;
	}
	if ($('#selectedBroadcaster').val().toUpperCase() === 'ASIAN_HOCKEY_CHAMPIONS') {
	    $('#api_match_name').hide();
	    $('#source_file_path').hide();
	    $('#destination_file_path').hide();
	    $('#update_time').show();
		$('#pre_match_name').hide();
	    $('#vizPortNumber_div').hide();
	    $('#vizIPAddress_div').hide();
	    $('#fixture_id').hide();
	    $('#hockey_source_url_div').show();
	    $('#hockey_json_folder_div').show();
	} else if ($('#selectedBroadcaster').val().toUpperCase() === 'FOOTBALL') {
        $('#api_match_name').hide();
        $('#source_file_path').hide();
        $('#destination_file_path').hide();
        $('#update_time').show();
        $('#vizPortNumber_div').hide();
        $('#vizIPAddress_div').hide();
        $('#fixture_id').show();
    }else if ($('#selectedBroadcaster').val().toUpperCase() === 'KABADDI' ||
    	 $('#selectedBroadcaster').val().toUpperCase()  === 'KABADDI_GIPKL') {
        $('#api_match_name').show();
		$('#pre_match_name').show();	
        $('#source_file_path').show();
        $('#destination_file_path').show();
        $('#update_time').hide();
        $('#vizPortNumber_div').show();
        $('#vizIPAddress_div').show();
        $('#fixture_id').hide();
    }else if ($('#selectedBroadcaster').val().toUpperCase() === 'BASKETBALL'||
    		$('#selectedBroadcaster').val().toUpperCase() === 'AFC_FOOTBALL'||
    	$('#selectedBroadcaster').val().toUpperCase() === 'CRICKET') {
        $('#api_match_name').show();
        $('#source_file_path').hide();
        $('#destination_file_path').hide();
        $('#update_time').hide();
        $('#vizPortNumber_div').hide();
        $('#vizIPAddress_div').hide();
        $('#fixture_id').hide();
    } else if($('#selectedBroadcaster').val().toUpperCase() === 'BOXING'){
		$('#api_match_name').hide();
        $('#source_file_path').show();
        $('#destination_file_path').show();
        $('#update_time').hide();
        $('#vizPortNumber_div').hide();
        $('#vizIPAddress_div').hide();
        $('#fixture_id').hide();
	}else if($('#selectedBroadcaster').val().toUpperCase() === 'ISPL'){
		$('#api_match_name').hide();
        $('#source_file_path').show();
        $('#destination_file_path').show();
        $('#update_time').hide();
        $('#vizPortNumber_div').hide();
        $('#vizIPAddress_div').hide();
        $('#fixture_id').hide();
	}else if($('#selectedBroadcaster').val().toUpperCase() === 'GOLF'){
		$('#api_match_name').show();
        $('#source_file_path').hide();
        $('#destination_file_path').hide();
        $('#update_time').hide();
        $('#vizPortNumber_div').hide();
        $('#vizIPAddress_div').hide();
        $('#fixture_id').hide();
	} else {
        $('#api_match_name').show();
        $('#source_file_path').show();
        $('#destination_file_path').show();
        $('#update_time').hide();
        $('#vizPortNumber_div').show();
        $('#vizIPAddress_div').show();
        $('#fixture_id').hide();
    }
	
}
function processUserSelectionData(whatToProcess,dataToProcess){
	switch(whatToProcess){
	case 'LOGGER_FORM_KEYPRESS':
		switch($('#selectedBroadcaster').val().toUpperCase()){
		case "GOLF":
			switch(dataToProcess){
			case 112:
				processApiProcedures('GOLFTOURRESPONSE');
				break;
			case 113:
				processApiProcedures('GOLFSCORESRESPONSE');
				break;
			case 114:
				processApiProcedures('GOLFDRAWSRESPONSE');
				break;	
			}
			break;	
		case "ISPL":
			switch(dataToProcess){
			case 112:
				processApiProcedures('ISPL_MVP_LEADERBOARD_DATA');
				break;
			case 113:
				processApiProcedures('ISPL_PLAYERINFO_DATA');
				break;	
			}
			break;
		case "BOXING":
			switch(dataToProcess){
			case 112:
				processApiProcedures('BOXING_MATCH_DATA');
				break;
			}
			break;
		case "KHELO_INDIA":
			switch(dataToProcess){
			case 112: // F1 key
				addItemsToList('KHELO',null);
				break;
			case 189:
				if(confirm('It will Also Delete Your Preview from Directory...\r\n\r\n Are You Sure To Animate Out?') == true){
					processApiProcedures('ANIMATE-OUT');
				}
				break;	
			}
			break;

		case "KABADDI_KADAMBA": case "KABADDI":case "KABADDI_GIPKL":
			switch(dataToProcess){
				case 112:
					processApiProcedures('KABADDI_STATS');
					break;
				case 113:
					processApiProcedures('KABADDI_PRE_MATCH_DATA');
					break;
			}
			break;
			
		case "TENNIS":
			switch(dataToProcess){
				case 112:
					processApiProcedures('TENNIS_STATS');
					break;
				case 113:
					processApiProcedures('KABADDI_PRE_MATCH_DATA');
					break;
			}
			break;
		case "FOOTBALL":
			switch(dataToProcess){
				case 89:
					processApiProcedures('FOOTBALL_MATCH_PREVIEW');
					graphics = 'FOOTBALL_MATCH_PREVIEW';
					break;
				case 84:
					processApiProcedures('TWITTER');
					break;
				case 112://F1
					graphics = 'FOOTBALL_SCHEDULE';
					processApiProcedures('FOOTBALL_SCHEDULE');
					break;
				case 113://F2
					addItemsToList('PLAYER_CAREER-OPTIONS',null);
					addItemsToList('POPULATE-PLAYER_CAREER',live_match);
					break;
				case 114://F3
					processApiProcedures('FOOTBALL_TOURNAMENT_TEAMS_SQUAD');
					graphics = 'FOOTBALL_TOURNAMENT_TEAMS_SQUAD';
					break;
				/*case 115:
					addItemsToList('SEASONAL_STATS-OPTIONS',null);
					break;	*/
				case 115://F4
					processApiProcedures('POPULATE-SEASONAL');
					graphics = 'POPULATE-SEASONAL';
					break;	
				case 116://F5
					processApiProcedures('POINTS_TABLE');
					graphics = 'LIVE_DATA';
					
					break;
				case 117://F6
					processApiProcedures('TOP_PERFORMER');
					graphics = 'TOP_PERFORMER';
					break;
				case 118://F7
					processApiProcedures('LINEUPS');
					graphics = 'LINEUPS';
					break;
				case 119://F8
					processApiProcedures('POSSESION_EVENTS');
					graphics = 'POSSESION_EVENTS';
					break;
				case 120: //F9
					processApiProcedures('PENALTY_PREVIEW');
					graphics = 'LIVE_DATA';
					break;
				case 121: //F10
					addItemsToList('PLAYER_STATS-OPTIONS',null);
					addItemsToList('POPULATE-PLAYER_CAREER',live_match);
					break;
				case 122: //F11
					addItemsToList('MATCH_EVENT-OPTIONS',null);
					addItemsToList('POPULATE-PLAYER_CAREER',live_match);
					break;
				case 123: //F12
					processApiProcedures('POPULATE-MATCH_EVENT');
					graphics = 'POPULATE-MATCH_EVENT';
					break;	
				case 81: //Q
					processApiProcedures('FOOTBALL_WIN_PROBABILITY');
					graphics = 'FOOTBALL_WIN_PROBABILITY';
					break;
				case 87: //W
					processApiProcedures('FOOTBALL_TOURNAMENT_SIMULATION');
					graphics = 'FOOTBALL_TOURNAMENT_SIMULATION';
					break;				
				case 82://R
					processApiProcedures('FOOTBALL_TEAMS_RANKING');
					graphics = 'FOOTBALL_TEAMS_RANKING';
					break;
				case 70://F
					processApiProcedures('FOOTBALL_FIXTURES_AND_RESULTS');
					graphics = 'FOOTBALL_FIXTURES_AND_RESULTS';
					break;
				case 77://M
					processApiProcedures('FOOTBALL_PASS_MATRIX');
					graphics = 'FOOTBALL_PASS_MATRIX';
					break;
				case 78://N
					processApiProcedures('FOOTBALL_MATCH_MOMENTUM');
					graphics = 'FOOTBALL_MATCH_MOMENTUM';
					break;
				case 79://O
					 processApiProcedures('FOOTBALL_MATCH_POSSESSION_VALUES');
					 graphics = 'FOOTBALL_MATCH_POSSESSION_VALUES';
					break;
				case 80://P
					 processApiProcedures('FOOTBALL_MATCH_PLAYER_RATINGS');
					 graphics = 'FOOTBALL_MATCH_PLAYER_RATINGS';
					break;
				case 65://A
					 processApiProcedures('FOOTBALL_LIVE_TRACKING');
					 graphics = 'FOOTBALL_LIVE_TRACKING';
					break;	
				case 66://B
					 processApiProcedures('FOOTBALL_GOALS_EXPECTED');
					 graphics = 'FOOTBALL_GOALS_EXPECTED';
					 break;
				case 67://C
					 processApiProcedures('FOOTBALL_MATCH_INSIGHTS');
					 graphics = 'FOOTBALL_MATCH_INSIGHTS';
					 break;
				case 68://D
					 processApiProcedures('FOOTBALL_MATCH_INSIGHTS2');
					 graphics = 'FOOTBALL_MATCH_INSIGHTS2';
					 break;	 
				case 69://E
					 processApiProcedures('FOOTBALL_MATCH_POSSESSION');
					 graphics = 'FOOTBALL_MATCH_POSSESSION';
					 break;	 
				case 76://L
					processApiProcedures('LIVE_DATA');
					graphics = 'LIVE_DATA';
					break;
				case 83://S
					processApiProcedures('SEASONAL_DATA');
					graphics = 'LIVE_DATA';
					break;
			}
			break;	
		case 'CRICKET':
		switch(dataToProcess){
				case 112:
					processApiProcedures('CRICKET_BATTING_BUZZER');
					graphics = 'CRICKET_BATTING_BUZZER';
					break;
				case 113:
					processApiProcedures('CRICKET_BOWLING_BUZZER');
					graphics = 'CRICKET_BOWLING_BUZZER';
					break;
				case 114:
					processApiProcedures('CRICKET_BATTERSTATS');
					graphics = 'CRICKET_BATTERSTATS';
					break;
				case 115:
					processApiProcedures('CRICKET_BOWLERSTATS');
					graphics = 'CRICKET_BOWLERSTATS';
					break;
				case 116://F5
					processApiProcedures('POINTS_TABLE');					
					break;
				}
		break;
		case "AFC_FOOTBALL":
			switch(dataToProcess){
				case 112:
					processApiProcedures('FOOTBALL_STATS');
					break;
				case 113:
					processApiProcedures('FOOTBALL_PRE_MATCH');
					break;
				case 116://F5
					processApiProcedures('POINTS_TABLE');					
					break;
				}
			break;
		case "BASKETBALL":
			switch(dataToProcess){
				case 112:
					processApiProcedures('BASKETBALL_STATS');
					break;
				case 113:
					processApiProcedures('BASKETBALL_PRE_MATCH');
					break;
				case 83:
					processApiProcedures('BASKETBALL_MATCH_START');
					break;
				case 65:
					processApiProcedures('BASKETBALL_MATCH_STOP');
					break;
			}
			break;
		}
		break;
	}
}
function afterPageLoad(whichPageHasLoaded)
{
	switch (whichPageHasLoaded) {
	case 'API':
	    if ($('#selectedBroadcaster').val().toUpperCase() === 'ASIAN_HOCKEY_CHAMPIONS') {
	        graphics = 'ASIAN_HOCKEY_GOAL_SCORERS';
	        processApiProcedures('READ-APIMATCH-AND-POPULATE');
	        startMatchTimeUpdate();
	    } else {
	        processApiProcedures('LOAD_MATCH');
	    }
	    break;
	}
	switch ($('#selectedBroadcaster').val().toUpperCase()) {
	case 'KHELO_INDIA':
		session_sports = [];
		session_sports.push('');
		session_sports.push('archery');
		session_sports.push('athletics');
		session_sports.push('badminton');
		session_sports.push('basketball');
		session_sports.push('boxing');
		session_sports.push('fencing');
		session_sports.push('football');
		session_sports.push('hockey');
		session_sports.push('judo');
		session_sports.push('kabaddi');
		session_sports.push('mallakhamb');
		session_sports.push('rowing');
		session_sports.push('rugby');
		session_sports.push('shooting');
		session_sports.push('swimming');
		session_sports.push('table_tennis');
		session_sports.push('tennis');
		session_sports.push('volleyball');
		session_sports.push('weightlifting');
		session_sports.push('wrestling');
		session_sports.push('yogasana');
		break;
	}
}
function uploadFormDataToSessionObjects(whatToProcess)
{
	var formData = new FormData();
	var url_path;

	$('input, select, textarea').each(
		function(index){  
			if($(this).is("select")) {
				formData.append($(this).attr('id'),$('#' + $(this).attr('id') + ' option:selected').val());  
			} else {
				formData.append($(this).attr('id'),$(this).val());  
			}	
		}
	);
	
	url_path = 'upload_match_setup_data';
	
	$.ajax({    
		headers: {'X-CSRF-TOKEN': $('meta[name="_csrf"]').attr('content')},
        url : url_path,     
        data : formData,
        cache: false,
        contentType: false,
        processData: false,
        type: 'POST',     
        success : function(data) {

        },    
        error : function(e) {    
       	 	console.log('Error occured in uploadFormDataToSessionObjects with error description = ' + e);     
        }    
    });		
	
}
function processUserSelection(whichInput)
{	
	  $(document).ready(function() {
            $('#selectedBroadcaster').change(function() {
				if ($(this).val().toUpperCase() === 'ASIAN_HOCKEY_CHAMPIONS') {
				    $('#api_match_name').hide();
				    $('#source_file_path').hide();
				    $('#destination_file_path').hide();
				    $('#update_time').show();
				    $('#vizPortNumber_div').hide();
				    $('#vizIPAddress_div').hide();
				    $('#fixture_id').hide();
				    $('#hockey_source_url_div').show();
				    $('#hockey_json_folder_div').show();
				} else if ($(this).val() === 'Football') {
                    $('#api_match_name').hide();
                    $('#source_file_path').hide();
                    $('#destination_file_path').hide();
                    $('#update_time').show();
                    $('#vizPortNumber_div').hide();
                    $('#vizIPAddress_div').hide();
                    $('#fixture_id').show();
                }else if ($(this).val() === 'KABADDI' || $(this).val() === 'KABADDI_GIPKL') {
                    $('#api_match_name').show();
					$('#pre_match_name').show();
                    $('#source_file_path').show();
                    $('#destination_file_path').show();
                    $('#update_time').hide();
                    $('#vizPortNumber_div').show();
                    $('#vizIPAddress_div').show();
                    $('#fixture_id').hide();
                } else if ($(this).val()=== 'Basketball'|| $(this).val()=== 'Cricket'
                	||$(this).val().toUpperCase() === 'AFC_FOOTBALL') {
			        $('#api_match_name').show();
			        $('#source_file_path').hide();
			        $('#destination_file_path').hide();
			        $('#update_time').hide();
			        $('#vizPortNumber_div').hide();
			        $('#vizIPAddress_div').hide();
			        $('#fixture_id').hide();
			    }else if($('#selectedBroadcaster').val().toUpperCase() === 'BOXING'){
					$('#api_match_name').hide();
			        $('#source_file_path').show();
			        $('#destination_file_path').show();
			        $('#update_time').hide();
			        $('#vizPortNumber_div').hide();
			        $('#vizIPAddress_div').hide();
			        $('#fixture_id').hide();
				}else if($('#selectedBroadcaster').val().toUpperCase() === 'ISPL'){
					$('#api_match_name').hide();
			        $('#source_file_path').show();
			        $('#destination_file_path').show();
			        $('#update_time').hide();
			        $('#vizPortNumber_div').hide();
			        $('#vizIPAddress_div').hide();
			        $('#fixture_id').hide();
				}else if($('#selectedBroadcaster').val().toUpperCase() === 'GOLF'){
					$('#api_match_name').show();
			        $('#source_file_path').hide();
			        $('#destination_file_path').hide();
			        $('#update_time').hide();
			        $('#vizPortNumber_div').hide();
			        $('#vizIPAddress_div').hide();
			        $('#fixture_id').hide();
				}else {
                    $('#api_match_name').show();
                    $('#source_file_path').show();
                    $('#destination_file_path').show();
                    $('#update_time').hide();
                    $('#vizPortNumber_div').show();
                    $('#vizIPAddress_div').show();
                    $('#fixture_id').hide();
                }
                $('#load_scene_btn').show(); // Ensure the button is always shown
            });
        });
	switch ($(whichInput).attr('name')) {
	case 'populate_data_to_gfx_btn':
		processApiProcedures('GET_MEDAL_TALLY_STATS');
		break;
	case 'select_configuration_file':
		processApiProcedures('GET-CONFIG-DATA');
		break;
	case 'load_scene_btn':
		/*if(checkEmpty($('#vizIPAddress'),'IP Address Blank') == false
			|| checkEmpty($('#vizPortNumber'),'Port Number Blank') == false) {
			return false;
		}*/
	    document.initialise_form.submit();
		break;
	case 'cancel_graphics_btn':
		switch ($('#selectedBroadcaster').val().toUpperCase()) {
		case 'FOOTBALL':
				//addItemsToList('FOOTBALL_CAPTION',null);
				$('#match_configuration').hide();
			break;
		}
		processWaitingButtonSpinner('END_WAIT_TIMER');
		break;
	case 'selectTeams':
		addItemsToList('POPULATE-PLAYER_CAREER',live_match);
		break;
	case 'populate_seasonal_btn':
		processApiProcedures('POPULATE-SEASONAL');
		break;
	case 'populate_playerstats_btn':
		processApiProcedures('POPULATE-PLAYER_STATS');
		break;
	case 'populate_matchevent_btn':
		processApiProcedures('POPULATE-PLAYER_MATCH_EVENT');
		break;	
	default:
		switch ($(whichInput).attr('id')) {
		case 'player_auction': 
			addItemsToList('LOAD_' + $(whichInput).attr('id').toUpperCase(),session_auction);
			document.getElementById('select_event_div').style.display = '';
		}
		break;
	}
	
}
function processApiProcedures(whatToProcess)
{
	var value_to_process ; 
	
	switch(whatToProcess) {
	case 'GET_MEDAL_TALLY_STATS':
		value_to_process = 'D:/DOAD_In_House_Everest/Everest_Sports/Everest_Khelo_India_2023/Scenes/FF_MedalTally.sum' + ',' +
			$('#selectSports option:selected').val();
		break;
	case 'GET-CONFIG-DATA':
		value_to_process = $('#select_configuration_file option:selected').val();
		break;
	case 'POPULATE-SEASONAL':
		value_to_process = $('#selectTeam option:selected').val();
		graphics = whatToProcess;
		break;
	case 'POPULATE-PLAYER_STATS': case 'POPULATE-PLAYER_MATCH_EVENT':
		value_to_process = $('#selectPlayerName option:selected').val();
		graphics = whatToProcess;
		break;	
	case 'READ-APIMATCH-AND-POPULATE':
	    value_to_process = graphics;
	    if (graphics !== preGraphic) {
	        preGraphic = graphics;
	    }
	    if (graphics != undefined && preGraphic != '') {
	        blink();
	    }
	    break;
	}

	$.ajax({    
        type: 'GET', // Correct case for the HTTP method    
        url : 'processApiProcedures.html',     
        data : 'whatToProcess=' + whatToProcess + '&valueToProcess=' + value_to_process, 
        dataType : 'json',
        success : function(data) {
			console.log(whatToProcess);
        	switch(whatToProcess) {
			case 'GET-CONFIG-DATA':
				initialiseForm('UPDATE-CONFIG',data);
				$(document).ready(function() {
				    $('#selectedBroadcaster').change(function() {
						if ($(this).val().toUpperCase() === 'ASIAN_HOCKEY_CHAMPIONS') {
						    $('#api_match_name').hide();
						    $('#source_file_path').hide();
						    $('#destination_file_path').hide();
						    $('#update_time').show();
						    $('#vizPortNumber_div').hide();
						    $('#vizIPAddress_div').hide();
						    $('#fixture_id').hide();
						    $('#hockey_source_url_div').show();
						    $('#hockey_json_folder_div').show();
						} else if ($(this).val() === 'Football') {
				            $('#api_match_name').hide();
				            $('#source_file_path').hide();
				            $('#destination_file_path').hide();
				            $('#update_time').show();
				            $('#vizPortNumber_div').hide();
				            $('#vizIPAddress_div').hide();
				        }else if ( $(this).val() === 'KABADDI' || $(this).val() === 'KABADDI_GIPKL') {
				            $('#api_match_name').show();
							$('#pre_match_name').show();	
				            $('#source_file_path').show();
				            $('#destination_file_path').show();
				            $('#update_time').hide();
				            $('#vizPortNumber_div').show();
				            $('#vizIPAddress_div').show();
				        } else if ($(this).val()=== 'Basketball'|| $(this).val()=== 'Cricket'||$(this).val().toUpperCase() === 'AFC_FOOTBALL') {
					        $('#api_match_name').show();
					        $('#source_file_path').hide();
				            $('#destination_file_path').hide();
					        $('#update_time').hide();
					        $('#vizPortNumber_div').hide();
				            $('#vizIPAddress_div').hide();
					        $('#fixture_id').hide();
					    }else if($('#selectedBroadcaster').val().toUpperCase() === 'BOXING'){
							$('#api_match_name').hide();
					        $('#source_file_path').show();
					        $('#destination_file_path').show();
					        $('#update_time').hide();
					        $('#vizPortNumber_div').hide();
					        $('#vizIPAddress_div').hide();
					        $('#fixture_id').hide();
						}else if($('#selectedBroadcaster').val().toUpperCase() === 'ISPL'){
							$('#api_match_name').hide();
					        $('#source_file_path').show();
					        $('#destination_file_path').show();
					        $('#update_time').hide();
					        $('#vizPortNumber_div').hide();
					        $('#vizIPAddress_div').hide();
					        $('#fixture_id').hide();
						}else if($('#selectedBroadcaster').val().toUpperCase() === 'GOLF'){
							$('#api_match_name').show();
					        $('#source_file_path').hide();
					        $('#destination_file_path').hide();
					        $('#update_time').hide();
					        $('#vizPortNumber_div').hide();
					        $('#vizIPAddress_div').hide();
					        $('#fixture_id').hide();
						}else {
				            $('#api_match_name').show();
				            $('#source_file_path').show();
				            $('#destination_file_path').show();
				            $('#update_time').show();
				            $('#vizPortNumber_div').show();
				            $('#vizIPAddress_div').show();
				        }
				    }).change();
				});
				break;
			case 'LOAD_MATCH':
				session_auction = data;
				live_match = data;
				addItemsToList('LOAD_MATCH',data);
				switch ($('#selectedBroadcaster').val().toUpperCase()) {
				case 'FOOTBALL':
					//addItemsToList('FOOTBALL_CAPTION',data);
					$('#match_configuration').hide();
					break;
				}
				document.getElementById('api_div').style.display = '';
				document.getElementById('select_event_div').style.display = 'none';
				
				//setInterval(displayMatchTime, parseInt($('#update_time').val())*1000);
				 startMatchTimeUpdate();
				break;
			case 'ISPL_MVP_LEADERBOARD_DATA':
				alert(data.status);
				break;
			case 'GOLFTOURRESPONSE':
			    alert(data.status);
			    break;
			case "GOLFSCORESRESPONSE":
				 alert(data.status);
			    break; 
			 case "GOLFDRAWSRESPONSE": 
				 alert(data.status);
			    break;     
			case 'ISPL_PLAYERINFO_DATA':
				alert(data.status);
				break;		
			case 'BOXING_MATCH_DATA':
				alert('Match file is created');
				break;
			case 'KABADDI_PRE_MATCH_DATA':
				alert('Pre-Match file is created');
				break;
			case 'READ-APIMATCH-AND-POPULATE':
			    if ($('#selectedBroadcaster').val().toUpperCase() === 'ASIAN_HOCKEY_CHAMPIONS') {
			        if (data && data.status === 'success') {
			            console.log('Asian Hockey goal scorers refreshed:', data.records, data.file);
			        } else {
			            console.error('Asian Hockey refresh failed:', data ? data.error || data.status : 'Empty response');
			        }
			        break;
			    }
			    if (data && $('#selectedBroadcaster').val() !== 'Football' && $('#selectedBroadcaster').val() !== 'GOLF' && $('#selectedBroadcaster').val() !== 'Basketball' && $('#selectedBroadcaster').val() !== 'AFC_Football') {
			        addItemsToList('LOAD_API', data);
			    } else if ($('#selectedBroadcaster').val() === 'Football') {
			        setdata(data);
			    } else if ($('#selectedBroadcaster').val() === 'GOLF') {
			        updateConnectionSignal(data.status);
			    } else if ($('#selectedBroadcaster').val() === 'Basketball') {
			        if (data !== null && data !== undefined) {
			            let INCP_SportEvent = data.INCP_SportEvent || null;
			            if (INCP_SportEvent) {
			                dataFunction(INCP_SportEvent);
			            } else {
			                console.error("INCP_SportEvent is missing");
			            }
			        }
			        if (data && data.status) {
			            document.getElementById('update').innerText = 'File Update: ' + data.status;
			        }
			    }
			    match_data = data;
			    break;
			case 'GET_MEDAL_TALLY_STATS':
        		if(confirm('Animate In?') == true){
					switch(whatToProcess){
					case 'GET_MEDAL_TALLY_STATS':
						processApiProcedures('ANIMATE-IN-MEDALS_TALLY');		
						break;
					}
				}
				break;
			case 'POPULATE-PLAYER_STATS': case 'POPULATE-SEASONAL': case 'FOOTBALL_SCHEDULE': case 'FOOTBALL_TOURNAMENT_TEAMS_SQUAD':
			case 'POINTS_TABLE': case 'TOP_PERFORMER': case 'LINEUPS': case 'POSSESION_EVENTS': case 'PENALTY_PREVIEW':
			case 'FOOTBALL_TEAMS_RANKING': case 'FOOTBALL_FIXTURES_AND_RESULTS': case 'FOOTBALL_PASS_MATRIX': case 'POPULATE-MATCH_EVENT':
			case 'FOOTBALL_WIN_PROBABILITY': case 'FOOTBALL_TOURNAMENT_SIMULATION': case 'FOOTBALL_MATCH_PLAYER_RATINGS':case "FOOTBALL_MATCH_POSSESSION":
			case 'FOOTBALL_MATCH_POSSESSION_VALUES': case 'FOOTBALL_MATCH_MOMENTUM': case 'POPULATE-PLAYER_MATCH_EVENT': case 'FOOTBALL_LIVE_TRACKING':
			case 'FOOTBALL_GOALS_EXPECTED': case'FOOTBALL_MATCH_INSIGHTS': case'LIVE_DATA':case'SEASONAL_DATA': case 'CRICKET_BOWLERSTATS':case 'CRICKET_BATTERSTATS':
			case 'FOOTBALL_MATCH_PREVIEW': case 'FOOTBALL_MATCH_INSIGHTS2':case 'BASKETBALL_PRE_MATCH': case 'BASKETBALL_STATS':case 'FOOTBALL_STATS':case 'FOOTBALL_PRE_MATCH':
			case 'CRICKET_BATTING_BUZZER': case 'CRICKET_BOWLING_BUZZER':
				alert('File created Successfully')
				
				break;		
        	}
    		processWaitingButtonSpinner('END_WAIT_TIMER');
	    },    
	    error : function(e) {    
	  	 	console.log('Error occured in ' + whatToProcess + ' with error description = ' + e);     
	    }    
	});
}
function addItemsToList(whatToProcess, dataToProcess)
{
	var select,option,header_text,div,table,tbody,row,max_cols,cell,header_text1;
	var cellCount = 0;

	switch (whatToProcess) {
	case 'POPULATE-PLAYER_CAREER' :
	
		$('#selectPlayerName').empty();
		if(live_match.liveData.lineUp[0].contestantId == $('#selectTeams option:selected').val()){
			live_match.liveData.lineUp.forEach(function(lu,index,arr){
				if(lu.contestantId == $('#selectTeams option:selected').val()){
					lu.player.forEach(function(pl,index,arr){
						$('#selectPlayerName').append(
							$(document.createElement('option')).prop({
							value: pl.playerId,
							text: pl.firstName
						}))
					});
				}
			});
		}
		else if(live_match.liveData.lineUp[1].contestantId == $('#selectTeams option:selected').val()){
			live_match.liveData.lineUp.forEach(function(lu,index,arr){
				if(lu.contestantId == $('#selectTeams option:selected').val()){
					lu.player.forEach(function(pl,index,arr){
						$('#selectPlayerName').append(
							$(document.createElement('option')).prop({
							value: pl.playerId,
							text: pl.firstName
						}))
					});
				}
			});
		}
		break;
	case 'SEASONAL_STATS-OPTIONS':
		switch ($('#selectedBroadcaster').val().toUpperCase()) {
		case 'FOOTBALL':

			$('#api_div').empty();
	
			header_text = document.createElement('h6');
			header_text.innerHTML = 'Select Graphic Options';
			document.getElementById('api_div').appendChild(header_text);
			
			table = document.createElement('table');
			table.setAttribute('class', 'table table-bordered');
					
			tbody = document.createElement('tbody');
	
			table.appendChild(tbody);
			document.getElementById('api_div').appendChild(table);
			
			row = tbody.insertRow(tbody.rows.length);
			
			select = document.createElement('select');
			select.id = 'selectTeam';
			select.name = select.id;
			option = document.createElement('option');
			option.value = live_match.matchInfo.contestant[0].id;
			option.text = live_match.matchInfo.contestant[0].name;
			select.appendChild(option);
			
			option = document.createElement('option');
			option.value = live_match.matchInfo.contestant[1].id;
			option.text = live_match.matchInfo.contestant[1].name;
			select.appendChild(option);
			
			select.setAttribute('onchange',"processUserSelection(this)");
			row.insertCell(cellCount).appendChild(select);
			cellCount = cellCount + 1;
			
			option = document.createElement('input');
		    option.type = 'button';
		    
		    switch (whatToProcess) {
			case 'SEASONAL_STATS-OPTIONS':
				option.name = 'populate_seasonal_btn';
				option.value = 'Populate';
				break;
			}
		    
			option.id = option.name;
		    option.setAttribute('onclick',"processUserSelection(this)");
		    
		    div = document.createElement('div');
		    div.append(option);

			option = document.createElement('input');
			option.type = 'button';
			option.name = 'cancel_graphics_btn';
			option.id = option.name;
			option.value = 'Cancel';
			option.setAttribute('onclick','processUserSelection(this)');
	
		    div.append(option);
		    
		    row.insertCell(cellCount).appendChild(div);
		    cellCount = cellCount + 1;
		    
			document.getElementById('api_div').style.display = '';
			break;
		}
		break;		
	case 'PLAYER_CAREER-OPTIONS': case 'PLAYER_STATS-OPTIONS': case 'MATCH_EVENT-OPTIONS':
		switch ($('#selectedBroadcaster').val().toUpperCase()) {
		case 'FOOTBALL':
			$('#api_div').empty();
	
			header_text = document.createElement('h6');
			header_text.innerHTML = 'Select Graphic Options';
			document.getElementById('api_div').appendChild(header_text);
			
			table = document.createElement('table');
			table.setAttribute('class', 'table table-bordered');
					
			tbody = document.createElement('tbody');
	
			table.appendChild(tbody);
			document.getElementById('api_div').appendChild(table);
			
			row = tbody.insertRow(tbody.rows.length);
			
			select = document.createElement('select');
			select.id = 'selectTeams';
			select.name = select.id;
			option = document.createElement('option');
			option.value = live_match.matchInfo.contestant[0].id;
			option.text = live_match.matchInfo.contestant[0].name;
			select.appendChild(option);
			
			option = document.createElement('option');
			option.value = live_match.matchInfo.contestant[1].id;
			option.text = live_match.matchInfo.contestant[1].name;
			select.appendChild(option);
			
			select.setAttribute('onchange',"processUserSelection(this)");
			row.insertCell(cellCount).appendChild(select);
			cellCount = cellCount + 1;
			
			select = document.createElement('select');
			select.id = 'selectPlayerName';
			select.name = select.id;
			
			select.setAttribute('onchange',"processUserSelection(this)");
			row.insertCell(cellCount).appendChild(select);
			cellCount = cellCount + 1;
			
			option = document.createElement('input');
		    option.type = 'button';
		    
		    switch (whatToProcess) {
			case 'PLAYER_CAREER-OPTIONS':
				option.name = 'populate_playerCareer_btn';
				option.value = 'Populate';
				break;
			case 'PLAYER_STATS-OPTIONS':
				option.name = 'populate_playerstats_btn';
				option.value = 'Populate';
				break;
			case 'MATCH_EVENT-OPTIONS':
				option.name = 'populate_matchevent_btn';
				option.value = 'Populate';
				break;	
			}
		    
			option.id = option.name;
		    option.setAttribute('onclick',"processUserSelection(this)");
		    
		    div = document.createElement('div');
		    div.append(option);

			option = document.createElement('input');
			option.type = 'button';
			option.name = 'cancel_graphics_btn';
			option.id = option.name;
			option.value = 'Cancel';
			option.setAttribute('onclick','processUserSelection(this)');
	
		    div.append(option);
		    
		    row.insertCell(cellCount).appendChild(div);
		    cellCount = cellCount + 1;
		    
			document.getElementById('api_div').style.display = '';
			break;
		}
		break;	
	case 'FOOTBALL_CAPTION':
		switch ($('#selectedBroadcaster').val().toUpperCase()) {
		case 'FOOTBALL':
		
		table = document.createElement('table');
        table.setAttribute('class', 'table table-bordered');
                
         tbody = document.createElement('tbody');
    
        table.appendChild(tbody);
        $("#api_div").append(table);
        $("#api_div").append("<br>");
        $("#api_div").append("<br>");
        $("#api_div").append("<br>");
       
        // Header row
        headerRow = document.createElement('tr');
        headerText = document.createElement('th');
        headerText.setAttribute('class', 'table thead-dark');
        headerText.innerHTML = 'Captions';
        headerText.colSpan = 2;
        headerText.style.textAlign = 'center';
	    headerRow.style.fontSize = "2.1vh";  
	    headerRow.style.fontWeight = 'bold';
        headerRow.appendChild(headerText);
        tbody.appendChild(headerRow);
      captions = [
			/*['Tournament Schedule', 'F1'],
			['Player Career', 'F2'],
            ['Squad', 'F3'],
            ['Seasonal Stats', 'F4'],
            ['Top Performer', 'F6'],
           /* ['Points Table', 'F5'],
            
            ['LineUp', 'F7'],
            ['Posession', 'F8'],
            ['Penalty', 'F9'],
            ['Player Stats', 'F10'],
            ['Match Event', 'F12'],
           /*  ['Live Tracking', 'A'],
            ['Match Insights', 'C']
            ['Win Probability', 'Q'],
            ['Tournament Simulation', 'W'],
            ['Team Ranking', 'R'],
            ['Pass Matrix', 'M'],
            ['Match Momentum', 'N'],
            ['Match Possession Value', 'O'],
            ['Match Player Rating', 'P'],
            ['Pass Matrix', 'M'],
            ['Match Preview', 'Y'],
           ,*/
           	['SEASONAL STATS', 'S'],
            ['Live Match', 'L'],
            
        ];

        captions.forEach(function(caption) {
        	row = document.createElement('tr');
            cell1 = document.createElement('td');
            cell2 = document.createElement('td');
            row.style.textAlign = 'center';
	    	row.style.fontSize = "2.1vh";  
	    	row.style.fontWeight = 'bold';
	    	cell1.style.backgroundColor = "#f5e71b";
	    	cell2.style.backgroundColor = "#f5e71b";
            cell1.innerHTML = caption[0];
            cell2.innerHTML = caption[1];
            row.appendChild(cell1);
            row.appendChild(cell2);
            tbody.appendChild(row);
        });
         $("#api_div").show();
			break;	
		}
		break;
	case 'LOAD_API':
		
		$('#api_div').empty();
	
		header_text = document.createElement('h6');
		header_text.innerHTML = 'Select Graphic Options';
		document.getElementById('api_div').appendChild(header_text);
		
		table = document.createElement('table');
		table.setAttribute('class', 'table table-bordered');
				
		tbody = document.createElement('tbody');

		for(var i = 0; i < 1; i++){
			row = tbody.insertRow(tbody.rows.length);
			for (var j = 0; j <= 1; j++) {
			    Select = document.createElement('label');
			    switch (j) {
				case 0:
				    Select.name = 'apihomeTeam';
				    Select.id = 'apihomeTeam';
					Select.value = dataToProcess.homeTeam.teamId;
					Select.innerHTML = dataToProcess.homeTeam.teamName1 + ': ' + dataToProcess.homeTeamScore;
					Select.style.fontSize = '30px';
					break;
				case 1:
					Select.name = 'apiawayTeam';
					Select.id = 'apiawayTeam';
					Select.value = dataToProcess.awayTeam.teamId;
					Select.innerHTML = dataToProcess.awayTeam.teamName1 + ': ' + dataToProcess.awayTeamScore;
					Select.style.fontSize = '30px';
					break;	
				}
				Select.setAttribute('onclick','processUserSelection(this);');
			    row.insertCell(j).appendChild(Select);
			}
		}
		
		table.appendChild(tbody);
		document.getElementById('api_div').appendChild(table);
		break;	
	case 'KHELO':
		switch ($('#selectedBroadcaster').val().toUpperCase()) {
		case 'KHELO_INDIA':
		
			$('#select_event_div').empty();
	
			header_text = document.createElement('h6');
			header_text.innerHTML = 'Select Sports';
			document.getElementById('select_event_div').appendChild(header_text);
			
			table = document.createElement('table');
			table.setAttribute('class', '');
					
			tbody = document.createElement('tbody');
	
			table.appendChild(tbody);
			document.getElementById('select_event_div').appendChild(table);
			
			row = tbody.insertRow(tbody.rows.length);
			
			select = document.createElement('select');
			select.id = 'selectSports';
			select.name = select.id;
	
			row.insertCell(0).appendChild(select);
			
			for(var i=0; i< session_sports.length; i++) {
				option = document.createElement('option');
				option.value = session_sports[i];
				option.text = session_sports[i] ;
				select.appendChild(option);
			}
	
			option = document.createElement('input');
			option.type = 'button';
			option.name = 'populate_data_to_gfx_btn';
			option.id = option.name;
			option.value = 'Populate Data To Graphics';
			option.setAttribute('onclick','processUserSelection(this)');
	
			row.insertCell(1).appendChild(option);
			
			option = document.createElement('input');
			option.type = 'button';
			option.name = 'cancel_btn';
			option.id = option.name;
			option.value = 'Cancel';
			option.setAttribute('onclick','processUserSelection(this)');
	
			row.insertCell(2).appendChild(option);
			
			document.getElementById('select_event_div').style.display = '';
	
			break;	
		}
		break;	
	}
}
function removeSelectDuplicates(select_id)
{
	var this_list = {};
	$("select[id='" + select_id + "'] > option").each(function () {
	    if(this_list[this.text]) {
	        $(this).remove();
	    } else {
	        this_list[this.text] = this.value;
	    }
	});
}
function checkEmpty(inputBox,textToShow) {

	var name = $(inputBox).attr('id');
	
	document.getElementById(name + '-validation').innerHTML = '';
	document.getElementById(name + '-validation').style.display = 'none';
	$(inputBox).css('border','');
	if(document.getElementById(name).value.trim() == '') {
		$(inputBox).css('border','#E11E26 2px solid');
		document.getElementById(name + '-validation').innerHTML = textToShow + ' required';
		document.getElementById(name + '-validation').style.display = '';
		document.getElementById(name).focus({preventScroll:false});
		return false;
	}
	return true;	
}
function blink() {
    $('#CheckConnection_div').empty();
    let div = document.getElementById('CheckConnection_div');
    div.style.display = 'flex';
    div.style.alignItems = 'center'; 
    div.style.justifyContent = 'flex-end'; 

    let keyframes = `
         @keyframes blink {
            0% { opacity: 1; }
            50% { opacity: 0; }
            100% { opacity: 0; }
        }
        .blink {
            animation: blink 1s 1 forwards; 
        }
    `;
    let styleSheet = document.createElement("style");
    styleSheet.type = "text/css";
    styleSheet.innerText = keyframes;
    document.head.appendChild(styleSheet);

    let option = document.createElement('div');
    option.style.width = '40px';
    option.style.height = '40px';
    option.style.borderRadius = '50%';
    option.style.marginRight = '10px';
    option.style.backgroundColor = '#006600';
    option.style.animation = 'blink 1s 1 forwards'; 

    option.style.boxShadow = '0 4px 8px rgba(0, 0, 0, 0.3)'; 
    div.appendChild(option);
}
    function createTable2() {
    const table = document.createElement('table');
    table.id = 'table2';
    table.className = '';

    const thead = document.createElement('thead');
    
    const statsHeaderRow = document.createElement('tr');
    statsHeaderRow.style.fontSize = "2.1vh"; 
    statsHeaderRow.style.height = "5vh";   
    statsHeaderRow.style.color = 'black';
    statsHeaderRow.style.lineHeight = '1.1';
    
    const statsCell = document.createElement('th');
    statsCell.colSpan = 3; 
    statsCell.setAttribute('class', 'table thead-dark');
    statsCell.innerHTML = '<center><b>MATCH STATS</b></center>';
    statsCell.style.textAlign = 'center'; 
    statsHeaderRow.style.fontWeight = 'bold';
	statsHeaderRow.style.textShadow = `
	    1px 1px 2px white, 
	    1px 1px 2px white, 
	    1px 1px 5px white,
	    1px 1px 10px rgba(0, 0, 0, 0.5)
	`;
    statsCell.style.cssText = "border: 3px solid white;word-wrap: break-word; white-space: normal; overflow: hidden;";
    statsHeaderRow.appendChild(statsCell);
    thead.appendChild(statsHeaderRow);

    const headerRow = document.createElement('tr');
    headerRow.style.cssText = "border: 3px solid white;word-wrap: break-word; white-space: normal; overflow: hidden;";
    
    const thLeft = document.createElement('th');
    thLeft.id = 'team1';
    thLeft.innerHTML = '';
    headerRow.style.textAlign = 'center'; 
    thLeft.style.cssText = "border: 3px solid white;word-wrap: break-word; white-space: normal; overflow: hidden;"; 
    thLeft.style.backgroundColor = homeColour;
    thLeft.style.color = homeTextColour;
    thLeft.style.fontSize = '2.1vh'; 
    headerRow.appendChild(thLeft);

    const thMiddle = document.createElement('th');
    thMiddle.style.backgroundColor = "#33ffc7";
    thMiddle.style.color = 'black'; 
    thMiddle.style.width = '10%';
    thMiddle.style.whiteSpace = 'nowrap';
    thMiddle.style.fontSize = '2.1vh'; 
    headerRow.appendChild(thMiddle);

    const thRight = document.createElement('th');
    thRight.id = 'team2';
    thRight.style.textAlign = 'center'; 
    thRight.innerHTML = '';
    thRight.style.cssText = "border: 3px solid white;word-wrap: break-word; white-space: normal; overflow: hidden;"; 
    thRight.style.backgroundColor = awayColour;
    thRight.style.color = awayTextColour;
    thRight.style.fontSize = '2.1vh'; 
    headerRow.appendChild(thRight);

    thead.appendChild(headerRow);

    table.appendChild(thead);

    const tbody = document.createElement('tbody');
	[
	    'Possession',
	    'Shots',
	    'On Target',
	    'Corners',
	    'Yellow Cards',
	    'Saves',
	    'Crosses',
	    'Passes',
	    'Passing Accuracy',
	    'Touches',
	    'Tackles',
	    'OffSides',
	    'Chance Created',
	    'Fouls Won',
	    'Dribbles',
	    'Interceptions'
	].forEach(stat => {
        const row = document.createElement('tr');
        row.style.cssText = "border: 3px solid white;word-wrap: break-word; white-space: normal; overflow: hidden;"; 
        
        const tdLeft = document.createElement('th');
        tdLeft.id = "team1_" + stat.toLowerCase().replace(/ /g, '-');
        tdLeft.className = 'team-cell'; 
        tdLeft.style.cssText = "border: 3px solid white;word-wrap: break-word; white-space: normal; overflow: hidden;"; 
        tdLeft.innerHTML = '0';
        tdLeft.style.backgroundColor = homeColour;
		tdLeft.style.color = homeTextColour;
        tdLeft.style.fontSize = '2.1vh'; 
        row.appendChild(tdLeft);
        
        const tdStat = document.createElement('th');
        tdStat.innerHTML = stat;
        tdStat.className = 'stat-cell'; 
        tdStat.style.cssText = "border: 3px solid white;word-wrap: break-word; white-space: normal; overflow: hidden;"; 
        tdStat.style.backgroundColor = "#33ffc7";
        tdStat.style.whiteSpace = 'nowrap';
        tdStat.style.textAlign = 'center';
        tdStat.style.fontSize = '2.1vh';  
        row.appendChild(tdStat);
        
        const tdRight = document.createElement('th');
        tdRight.id = "team2_" + stat.toLowerCase().replace(/ /g, '-');
        tdRight.className = 'team-cell'; 
        tdRight.style.cssText = "border: 3px solid white;word-wrap: break-word; white-space: normal; overflow: hidden;"; 
        tdRight.innerHTML = '0';
        tdRight.style.backgroundColor = awayColour;
        tdRight.style.color = awayTextColour;
        tdRight.style.fontSize = '2.1vh'; 
        row.appendChild(tdRight);

        tbody.appendChild(row);
    });

    table.appendChild(tbody);

    return table;
}
function dataFunction(data) {
	console.log(data.sportEventStatus);
    if (data && data.sportEventStatus) {  // Check if data and sportEventStatus are not null/undefined
        document.getElementById("homeQ_1").innerHTML = data.sportEventStatus.homeScoring[0].points;
        document.getElementById("homeQ_2").innerHTML = data.sportEventStatus.homeScoring[1].points;
        document.getElementById("homeQ_3").innerHTML = data.sportEventStatus.homeScoring[2].points;
        document.getElementById("homeQ_4").innerHTML = data.sportEventStatus.homeScoring[3].points;

        document.getElementById("awayQ_1").innerHTML = data.sportEventStatus.awayScoring[0].points;
        document.getElementById("awayQ_2").innerHTML = data.sportEventStatus.awayScoring[1].points;
        document.getElementById("awayQ_3").innerHTML = data.sportEventStatus.awayScoring[2].points;
        document.getElementById("awayQ_4").innerHTML = data.sportEventStatus.awayScoring[3].points;
    } else {
        console.log("Invalid data or sportEventStatus is missing.");
    }
}

function data(liveMatch) {
	for (var teamIndex = 0; teamIndex <= 1; teamIndex++) {
    var team = teamIndex === 0 ? teams.team1 : teams.team2;
    var accuratePass = 0;
    if (liveMatch && liveMatch.liveData && liveMatch.liveData.lineUp &&
        liveMatch.liveData.lineUp[teamIndex] && liveMatch.liveData.lineUp[teamIndex].stat) {

        for (var j = 0; j < liveMatch.liveData.lineUp[teamIndex].stat.length; j++) {
            var stat = liveMatch.liveData.lineUp[teamIndex].stat[j];
            var value = stat.value.trim() || "0";

            switch (stat.type) {
                case "cornerTaken":
                    team.cornerTaken = parseInt(value, 10);
                    break;
                case "fkFoulWon":
                    team.foulsWon = parseInt(value, 10);
                    break;
                case "ontargetScoringAtt":
                    team.shotOnTarget = parseInt(value, 10);
                    break;
                case "totalScoringAtt":
                    team.shots = parseInt(value, 10);
                    break;
                case "saves":
                    team.saves = parseInt(value, 10);
                    break;
                case "totalCross":
                    team.crosses = parseInt(value, 10);
                    break;
                case "totalPass":
                    team.passes = parseInt(value, 10);
                    break;
                case "accuratePass":
                    accuratePass = parseInt(value, 10);
                    break;
                case "touches":
                    team.touches = parseInt(value, 10);
                    break;
                case "totalTackle":
                    team.tackles = parseInt(value, 10);
                    break;
                case "totalContest":
                    team.dribbles = parseInt(value, 10);
                    break;
                case "interception":
                    team.interceptions = parseInt(value, 10);
                    break;
                case "possessionPercentage":
                    team.possession = Math.round(parseFloat(value));
                    break;
                case "totalOffside":
                    team.offside = parseInt(value, 10);
                    break;
                 case "bigChanceCreated":
                    team.chancesCreated = parseInt(value, 10);
                    break;
                case "goals":
                    team.goals = parseInt(value, 10);
                    break;
            }
        }
        const passingAccuracy = AccuracyPercentage(team.passes, accuratePass);
		team.passingAccuracy = Math.round(passingAccuracy);

    	}
	}
	teams.team1.yellowCards=0;teams.team2.yellowCards=0;
	 if (liveMatch && liveMatch.liveData && liveMatch.liveData.card) {
	    for (var j = 0; j < liveMatch.liveData.card.length; j++) {
	        var card = liveMatch.liveData.card[j];        
	        if (card.contestantId.toLowerCase() === liveMatch.matchInfo.contestant[0].id.toLowerCase() && !card.teamOfficialId) {
	            if (card.type.toLowerCase() === "yc") {
	                teams.team1.yellowCards += 1;
	            } else if (card.type.toLowerCase() === "y2c") {
	                teams.team1.yellowCards -= 1;
	            }
	        }
	        else if (card.contestantId.toLowerCase() === liveMatch.matchInfo.contestant[1].id.toLowerCase()&& !card.teamOfficialId) {
	            if (card.type.toLowerCase() === "yc") {
	                teams.team2.yellowCards += 1;
	            }else if (card.type.toLowerCase() === "y2c") {
	                teams.team2.yellowCards -= 1;
	            }
	        }
	    }
	}
	
	if(teams.team1.yellowCards < 0){
		teams.team1.yellowCards = 0;
	}else if(teams.team2.yellowCards < 0){
		teams.team2.yellowCards = 0;
	}
}
function setdata(dataToProcess) {
	data(dataToProcess) ;
	 document.getElementById("team1").innerHTML = dataToProcess.matchInfo.contestant[0].code.trim();
	 document.getElementById("team2").innerHTML = dataToProcess.matchInfo.contestant[1].code.trim();
	 		  const stats = [
		    'Possession',
		    'Shots',
		    'On Target',
		    'Corners',
		    'Yellow Cards',
		    'Saves',
		    'Crosses',
		    'Passes',
		    'Passing Accuracy',
		    'Distance Covered',
		    'Touches',
		    'Tackles',
		    'OffSides',
		    'Chance Created',
		    'Fouls Won',
		    'Dribbles',
		    'Interceptions'
		];
		
		stats.forEach(stat => {
		    const statId = stat.toLowerCase().replace(/ /g, '-');
		    const homeElement = document.getElementById("team1_" + statId);
		    const awayElement = document.getElementById("team2_" + statId);
		
		    switch (stat) {
		        case "Shots":
		            if (homeElement) homeElement.innerHTML = teams.team1.shots;
		            if (awayElement) awayElement.innerHTML = teams.team2.shots;
		            break;
		        case "On Target":
		            if (homeElement) homeElement.innerHTML = teams.team1.shotOnTarget;
		            if (awayElement) awayElement.innerHTML = teams.team2.shotOnTarget;
		            break;
		        case "Corners":
		            if (homeElement) homeElement.innerHTML = teams.team1.cornerTaken;
		            if (awayElement) awayElement.innerHTML = teams.team2.cornerTaken;
		            break;
		        case "Yellow Cards":
		            if (homeElement) homeElement.innerHTML = teams.team1.yellowCards;
		            if (awayElement) awayElement.innerHTML = teams.team2.yellowCards;
		            break;
		        case "Saves":
		            if (homeElement) homeElement.innerHTML = teams.team1.saves;
		            if (awayElement) awayElement.innerHTML = teams.team2.saves;
		            break;
		        case "Crosses":
		            if (homeElement) homeElement.innerHTML = teams.team1.crosses;
		            if (awayElement) awayElement.innerHTML = teams.team2.crosses;
		            break;
		        case "Passes":
		            if (homeElement) homeElement.innerHTML = teams.team1.passes;
		            if (awayElement) awayElement.innerHTML = teams.team2.passes;
		            break;
		        case "Passing Accuracy":
		            /*if (homeElement) homeElement.innerHTML = teams.team1.passingAccuracy;
		            if (awayElement) awayElement.innerHTML = teams.team2.passingAccuracy;*/
		            if (homeElement && awayElement) [homeElement.innerHTML, awayElement.innerHTML] = RoundValues( teams.team1.passingAccuracy + "," +  teams.team2.passingAccuracy).split(",");

		            break;
		        case "Touches":
		            if (homeElement) homeElement.innerHTML = teams.team1.touches;
		            if (awayElement) awayElement.innerHTML = teams.team2.touches;
		            break;
		        case "Tackles":
		            if (homeElement) homeElement.innerHTML = teams.team1.tackles;
		            if (awayElement) awayElement.innerHTML = teams.team2.tackles;
		            break;
		        case "OffSides":
		            if (homeElement) homeElement.innerHTML = teams.team1.offside;
		            if (awayElement) awayElement.innerHTML = teams.team2.offside;
		            break;
		        case "Chance Created":
		        	if (homeElement) homeElement.innerHTML = teams.team1.chancesCreated;
		            if (awayElement) awayElement.innerHTML = teams.team2.chancesCreated;
		            break;
		        case "Fouls Won":
		            if (homeElement) homeElement.innerHTML = teams.team1.foulsWon;
		            if (awayElement) awayElement.innerHTML = teams.team2.foulsWon;
		            break;
		        case "Dribbles":
		            if (homeElement) homeElement.innerHTML = teams.team1.dribbles;
		            if (awayElement) awayElement.innerHTML = teams.team2.dribbles;
		            break;
		        case "Interceptions":
		            if (homeElement) homeElement.innerHTML = teams.team1.interceptions;
		            if (awayElement) awayElement.innerHTML = teams.team2.interceptions;
		            break;
		        case "Possession":
		           /* if (homeElement) homeElement.innerHTML = teams.team1.possession;
		            if (awayElement) awayElement.innerHTML = teams.team2.possession;*/
		           if (homeElement && awayElement) [homeElement.innerHTML, awayElement.innerHTML] = RoundValues( teams.team1.possession + "," +  teams.team2.possession).split(",");

		            break;
		    }
		});
}

	function insertTables() {
		if ($('#selectedBroadcaster').val().toUpperCase() === 'FOOTBALL') {
			const tables2Div = document.getElementById('select_div');
			const table2 = createTable2();
			 tables2Div.appendChild(table2);
			 document.getElementById("team1").style.background=homeColour;
		     document.getElementById("team1").style.color=homeTextColour;
			 $("#select_div").show();
			 
		} else if ($('#selectedBroadcaster').val().toUpperCase() === 'BASKETBALL') {
			const tables2Div = document.getElementById('select_div');;
			 // Create a label for "File Update"
			const label = document.createElement('label');
			label.id = 'update';
			label.innerHTML = 'File Update';
			 const table = document.createElement('table');
				table.id = 'table'; table.className = '';
				table.innerHTML = '<thead><tr><th>Key</th><th>File</th></tr></thead>' + 
				                  '<tbody><tr><td>F1</td><td>InMatch</td></tr>' + 
				                  '<tr><td>F2</td><td>PreMatch</td></tr>' + 
				                  '</tbody>';
				tables2Div.appendChild(label);
				tables2Div.appendChild(table);
			const table2 = createTable();
			 //console.log(table2);
			 tables2Div.appendChild(table2);
			 document.getElementById("team1").style.background=homeColour;
		     document.getElementById("team1").style.color=homeTextColour;
			$("#select_div").show();

		}else if ($('#selectedBroadcaster').val().toUpperCase() === 'AFC_FOOTBALL') {
			 const tables2Div = document.getElementById('select_div');;
			 // Create a label for "File Update"
			const label = document.createElement('label');
			label.id = 'update';
			label.innerHTML = 'File Update';
			 const table = document.createElement('table');
				table.id = 'table'; table.className = '';
				table.innerHTML = '<thead><tr><th>Key</th><th>File</th></tr></thead>' + 
				                  '<tbody><tr><td>F1</td><td>InMatch</td></tr>' + 
				                  '<tr><td>F2</td><td>PreMatch</td></tr>' + 
				                 /* '<tr><td>F5</td><td>PointsTable</td></tr>' + */
				                  '</tbody>';
				tables2Div.appendChild(label);
				tables2Div.appendChild(table);
				$("#select_div").show();
		}else if ($('#selectedBroadcaster').val().toUpperCase() === 'BOXING') {
			 const tables2Div = document.getElementById('select_div');;
			 // Create a label for "File Update"
			const label = document.createElement('label');
			label.id = 'update';
			//label.innerHTML = 'File Update';
			 const table = document.createElement('table');
				table.id = 'table'; table.className = '';
				table.innerHTML = '<thead><tr><th>Key</th><th>FileName</th></tr></thead>' + 
				                  '<tbody><tr><td>F1</td><td> data.json </td></tr>' + 
				                  '<tr></tr>' + 
				                 /* '<tr><td>F5</td><td>PointsTable</td></tr>' + */
				                  '</tbody>';
				tables2Div.appendChild(label);
				tables2Div.appendChild(table);
				$("#select_div").show();
		}
		else if ($('#selectedBroadcaster').val().toUpperCase() === 'GOLF'){
			const tables2Div = document.getElementById('select_div');;
			 // Create a label for "File Update"
			const label = document.createElement('label');
			label.id = 'update';
			//label.innerHTML = 'File Update';
			 const table = document.createElement('table');
				table.id = 'table'; table.className = '';
				table.innerHTML = '<thead><tr><th>Key</th><th>FileName</th></tr></thead>' + 
				                  '<tbody><tr><td>F1</td><td>  TOURDATA / COURSEDATA / ENTRYDATA  </td></tr>' + 
				                  '<tr><td>F2</td><td> SCOREDATA </td></tr>' + 
				                  '<tr><td>F3</td><td> DRAWSDATA </td></tr>' + 
				                  '</tbody>';
				tables2Div.appendChild(label);
				tables2Div.appendChild(table);
				$("#select_div").show();
		}else if ($('#selectedBroadcaster').val().toUpperCase() === 'ISPL'){
			const tables2Div = document.getElementById('select_div');;
			 // Create a label for "File Update"
			const label = document.createElement('label');
			label.id = 'update';
			//label.innerHTML = 'File Update';
			 const table = document.createElement('table');
				table.id = 'table'; table.className = '';
				table.innerHTML = '<thead><tr><th>Key</th><th>FileName</th></tr></thead>' + 
				                  '<tbody><tr><td>F1</td><td> MVP_LEADERBOARD.json </td></tr>' + 
				                  '<tr></tr>' + 
				                  '</tbody>';
				tables2Div.appendChild(label);
				tables2Div.appendChild(table);
				$("#select_div").show();
		}
}
function AccuracyPercentage(totalPassesAttempted, accuratePasses) {
    if (totalPassesAttempted <= 0) {
        return 0.00;
    }
    accuratePasses = Math.max(0, accuratePasses);
    const percentage = (accuratePasses / totalPassesAttempted) * 100;
    return parseFloat(percentage.toFixed(2));
}
function RoundValues(values) {
    let parts = values.split(",");
    if (parts[0].endsWith(".5") && parts[1].endsWith(".5")) {
        return (parseInt(parts[0].split(".")[0]) + 1) + "," + parseInt(parts[1].split(".")[0]);
    } else {
        return Math.round(parseFloat(parts[0])) + "," + Math.round(parseFloat(parts[1]));
    }
  
}
function createTable() {
    const table = document.createElement('table');
    table.id = 'table2';
    table.className = '';

    // Create the table head
    const thead = document.createElement('thead');
    
    // Create the stats header row
    const statsHeaderRow = document.createElement('tr');
    statsHeaderRow.style.fontSize = "2.1vh"; 
    statsHeaderRow.style.height = "5vh";   
    statsHeaderRow.style.color = 'black';
    statsHeaderRow.style.lineHeight = '1.1';
    
    const statsCell = document.createElement('th');
    statsCell.colSpan = 3; 
    statsCell.setAttribute('class', 'thead-dark');
    statsCell.innerHTML = '<center><b>MATCH STATS</b></center>';
    statsCell.style.textAlign = 'center'; 
    statsHeaderRow.style.fontWeight = 'bold';
    statsHeaderRow.style.textShadow = `
        1px 1px 2px white, 
        1px 1px 2px white, 
        1px 1px 5px white,
        1px 1px 10px rgba(0, 0, 0, 0.5)
    `;
    statsCell.style.cssText = "border: 3px solid white;word-wrap: break-word; white-space: normal; overflow: hidden;";
    statsHeaderRow.appendChild(statsCell);
    thead.appendChild(statsHeaderRow);

    // Create the second header row for team names
    const headerRow = document.createElement('tr');
    headerRow.style.cssText = "border: 3px solid white;word-wrap: break-word; white-space: normal; overflow: hidden;";
    
    const thMiddle = document.createElement('th');
    thMiddle.innerHTML = 'Quarters';  // Placeholder for column header
    thMiddle.style.cssText = "border: 3px solid white;word-wrap: break-word; white-space: normal; overflow: hidden;";
    thMiddle.style.backgroundColor = "#f8f9fa"; // Light background color
    thMiddle.style.fontSize = '2.1vh';
    headerRow.appendChild(thMiddle);

    const thLeft = document.createElement('th');
    thLeft.id = 'team1';
    thLeft.innerHTML = 'Home Team';  // Placeholder, you can replace this dynamically
    thLeft.style.cssText = "border: 3px solid white;word-wrap: break-word; white-space: normal; overflow: hidden;"; 
    thLeft.style.backgroundColor = homeColour;
    thLeft.style.color = homeTextColour;
    thLeft.style.fontSize = '2.1vh'; 
    headerRow.appendChild(thLeft);

    
    const thRight = document.createElement('th');
    thRight.id = 'team2';
    thRight.innerHTML = 'Away Team';  // Placeholder, you can replace this dynamically
    thRight.style.cssText = "border: 3px solid white;word-wrap: break-word; white-space: normal; overflow: hidden;";
    thRight.style.backgroundColor = awayColour;
    thRight.style.color = awayTextColour;
    thRight.style.fontSize = '2.1vh';
    headerRow.appendChild(thRight);

    thead.appendChild(headerRow);
    table.appendChild(thead);

    // Create the table body
    const tbody = document.createElement('tbody');
    
    // Example dynamic data - You should replace this with actual data
    const quarters = [1, 2, 3, 4];
    const homeScores = [0, 0, 0, 0];  // Example: home team scores per quarter
    const awayScores = [0, 0, 0, 0];  // Example: away team scores per quarter

    for (let i = 0; i < quarters.length; i++) {
        const row = document.createElement('tr');
        
       const quarterCell = document.createElement('td');
        quarterCell.innerHTML = 'Q' + quarters[i];  // Quarter label
        quarterCell.style.fontWeight = 'bold';
        quarterCell.style.backgroundColor = "#f8f9fa";
        row.appendChild(quarterCell);
        
        const homeCell = document.createElement('td');
        homeCell.innerHTML = homeScores[i];  // Home team score for the quarter
        homeCell.id = 'homeQ_'+quarters[i];
        homeCell.style.backgroundColor = homeColour;
        homeCell.style.color = homeTextColour;
        row.appendChild(homeCell);

        const awayCell = document.createElement('td');
        awayCell.innerHTML = awayScores[i];  // Away team score for the quarter
        awayCell.id = 'awayQ_'+quarters[i];
        awayCell.style.backgroundColor = awayColour;
        awayCell.style.color = awayTextColour;
        row.appendChild(awayCell);

        tbody.appendChild(row);
    }
    table.appendChild(tbody);

    return table;
}