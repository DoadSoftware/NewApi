package com.api.controller;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;
import com.api.broadcaster.KABADDI;
import com.api.broadcaster.KABADDI_KADAMBA;
import com.api.broadcaster.Tennis;
import com.api.containers.Scene;
import com.api.model.kadamba.Api_In_match;
import com.api.model.kadamba.Api_pre_match;
import com.api.model.kadamba.Configurations;
import com.api.model.kadamba.Match;
import com.api.model.kadamba.Team;
import com.api.model.khelo_india.KheloIndia;
import com.api.model.tennis.Api_tennis;
import com.api.model.boxing.Boxing;
import com.api.model.football.CurrentMatchLineup;
import com.api.model.football.LiveMatch;
import com.api.model.football.PenaltyPreview;
import com.api.model.football.PlayerCareer;
import com.api.model.football.PossesionEvent;
import com.api.model.football.SeasonalStats;
import com.api.model.football.Squad;
import com.api.model.football.TeamsStanding;
import com.api.model.football.TopPerformers;
import com.api.model.football.TournamentSchedule;
import com.api.model.football.TournamentSimulation;
import com.api.model.golf.GolfCourseResponse;
import com.api.model.golf.GolfDrawsResponse;
import com.api.model.golf.GolfEntryListResponse;
import com.api.model.golf.GolfScoresResponse;
import com.api.model.golf.GolfTourResponse;
import com.api.model.ispl.mvp_leaderBoard;
import com.api.model.ispl.player_Info;
import com.api.service.ApiService;
import com.api.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
public class IndexController 
{
	@Autowired
	ApiService apiService;

	public static String expiry_date = "2026-12-31";
	public static String current_date = "";
	public static String error_message = "";
	public static Api_In_match kabaddi_match;
	public static Api_tennis tennis_match;
	public static TournamentSchedule football_match;
	public static LiveMatch live_match;
	public static SeasonalStats seasonal_stats;
	public static PlayerCareer person_stats;
	public static Match session_match;
	public static com.api.model.football.Match session_matches;
	public static KABADDI_KADAMBA this_kabaddi_kadamba;
	public static KABADDI this_kabaddi;
	public static Tennis this_tennis;
	public static String session_selected_broadcaster;
	public static String source_path;
	public static String source_path1;
	public static String source_path2;
	public static String source_path3;
	public static String match_name;
	public static String destination_path;
	public static String destination_path1;
	public static String destination_path2;
	public static String destination_path3;
	public static String session_update_time;
	public static boolean is_this_updating = false;
	public static Configurations session_configuration;
	public static List<Api_pre_match> api_pre_match_team_stats;
	public static List<Api_In_match> api_in_match_team_stats;
	public static List<Api_tennis> api_tennis_team_stats;
	public static TournamentSimulation api_tournament_simulation;
	public static Squad api_football_teams;
	public static LiveMatch api_live_data;
	public static SeasonalStats api_seasonal_data;
	public static PlayerCareer api_player_data;
	public static TeamsStanding api_football_teams_standing;
	public static TopPerformers api_football_topPerformers;
	public static CurrentMatchLineup api_football_lineup;
	public static PossesionEvent api_football_possesion_events;
	public static PenaltyPreview api_football_penalty;
	public static com.api.model.basketball.INCP_SportEvent INCP_SportEvent;
	public static Boxing this_api_boxing;
	public static Socket session_socket;
	public static PrintWriter print_writer;
	List<Scene> session_selected_scenes = new ArrayList<Scene>();
	private String status = "";
	public ObjectMapper objectMapper = new ObjectMapper();
	
	public static String stats_url = "",access_token = "";
	@RequestMapping(value = {"/","/initialise"}, method={RequestMethod.GET,RequestMethod.POST}) 
	public String initialisePage(ModelMap model,
			@ModelAttribute("session_selected_broadcaster") String session_selected_broadcaster,
			@ModelAttribute("session_api_match_name") String session_api_match_name,
			@ModelAttribute("session_source_path") String session_source_path,
			@ModelAttribute("session_destination_path") String session_destination_path,
			@ModelAttribute("session_update_time") String session_update_time,
			@ModelAttribute("session_configuration") Configurations session_configuration) throws JAXBException, IOException, ParseException, SAXException, ParserConfigurationException, FactoryConfigurationError 
	{
		if(current_date == null || current_date.isEmpty()) {
			current_date = ApiFunctions.getOnlineCurrentDate();
		}
		
		model.addAttribute("configuration_files", new File(ApiUtil.SPORTS_DIRECTORY +
				ApiUtil.API_CONFIGURATIONS_DIRECTORY).listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				String name = pathname.getName().toLowerCase();
		        return name.endsWith(".xml") && pathname.isFile();
			}
		}));
		
		if(new File(ApiUtil.SPORTS_DIRECTORY + ApiUtil.API_CONFIGURATIONS_DIRECTORY + "output.xml").exists()) {
			session_configuration = (Configurations)JAXBContext.newInstance(
					Configurations.class).createUnmarshaller().unmarshal(
					new File(ApiUtil.SPORTS_DIRECTORY + ApiUtil.API_CONFIGURATIONS_DIRECTORY + "output.xml"));
		} else {
			session_configuration = new Configurations();
			JAXBContext.newInstance(Configurations.class).createMarshaller().marshal(session_configuration, 
					new File(ApiUtil.SPORTS_DIRECTORY + ApiUtil.API_CONFIGURATIONS_DIRECTORY + "output.xml"));
		}
		
		session_selected_broadcaster = "";
		session_update_time = "";
		model.addAttribute("session_configuration",session_configuration);
		return "initialise";
	}
	@RequestMapping(value = {"/api"}, method={RequestMethod.GET,RequestMethod.POST}) 
	public String apiPage(ModelMap model,
			@ModelAttribute("session_configuration") Configurations session_configuration,
			@RequestParam(value = "configuration_file_name", required = false, defaultValue = "") String configuration_file_name,
			@RequestParam(value = "api_match_name", required = false, defaultValue = "") String api_match_name,
			@RequestParam(value = "source_file_path", required = false, defaultValue = "") String source_file_path,
			@RequestParam(value = "destination_file_path", required = false, defaultValue = "") String destination_file_path,
			@RequestParam(value = "vizPortNumber", required = false, defaultValue = "") String vizPortNumber,
			@RequestParam(value = "vizIPAddress", required = false, defaultValue = "") String vizIPAddress,
			@RequestParam(value = "update_time", required = false, defaultValue = "") String update_time,
			@RequestParam(value = "fixture_id", required = false, defaultValue = "") String fixture_id,
			@RequestParam(value = "selectedBroadcaster", required = false, defaultValue = "") String selectedBroadcaster) 
					throws Exception 
	{
		if(current_date == null || current_date.isEmpty()) {
			current_date = ApiFunctions.getOnlineCurrentDate();
		}
		if(current_date == null || current_date.isEmpty()) {
			model.addAttribute("error_message","You must be connected to the internet online");
			return "error";
		} else if(new SimpleDateFormat("yyyy-MM-dd").parse(expiry_date).before(new SimpleDateFormat("yyyy-MM-dd").parse(current_date))) {
			model.addAttribute("error_message","This software has expired");
			return "error";
		}else {
			session_selected_broadcaster = selectedBroadcaster;
			source_path = source_file_path;
			match_name =  api_match_name;
			destination_path = destination_file_path;
			session_update_time = update_time;
			api_pre_match_team_stats = new ArrayList<Api_pre_match>();
			api_in_match_team_stats = new ArrayList<Api_In_match>();
			api_tennis_team_stats = new ArrayList<Api_tennis>();
			ApiUtil.FOOTBALL_FIXTURE_ID = fixture_id;
			switch (session_selected_broadcaster) {
			case ApiUtil.ISPL:
				session_configuration = new Configurations(selectedBroadcaster,"",source_file_path,destination_file_path,"","",0);
				break;
			case ApiUtil.GOLF:
				session_configuration = new Configurations(selectedBroadcaster,match_name,"","","","",0);
				break;
			case ApiUtil.KHELO_INDIA: case ApiUtil.SWIMMING_TSR:  case ApiUtil.TENNIS: case ApiUtil.KABADDI_KADAMBA:
			case ApiUtil.KABADDI:
				session_configuration = new Configurations(selectedBroadcaster,match_name,source_file_path,destination_file_path,update_time,
						vizIPAddress,Integer.valueOf(vizPortNumber));
				if(vizPortNumber != null) {
					session_socket = new Socket(vizIPAddress, Integer.valueOf(vizPortNumber));
					print_writer = new PrintWriter(session_socket.getOutputStream(), true);
				}
				break;
			case ApiUtil.FOOTBALL: case ApiUtil.BASKETBALL: case ApiUtil.AFC_Football: case ApiUtil.KABADDI_GIPKL: case ApiUtil.Cricket: 
				case ApiUtil.BOXING:	
				session_configuration = new Configurations(selectedBroadcaster,match_name,source_file_path,destination_file_path,update_time,fixture_id);
				break;
			}
//			if(vizPortNumber != null) {
//				session_socket = new Socket(vizIPAddress, Integer.valueOf(vizPortNumber));
//				print_writer = new PrintWriter(session_socket.getOutputStream(), true);
//			}
			//System.out.println("session_selected_broadcaster = " + session_selected_broadcaster);
			switch (session_selected_broadcaster) {
			case ApiUtil.KHELO_INDIA:
				JAXBContext.newInstance(Configurations.class).createMarshaller().marshal(session_configuration, 
						new File(ApiUtil.KHELO_INDIA_DIRECTORY + ApiUtil.CONFIGURATIONS_DIRECTORY + configuration_file_name));
			case ApiUtil.SWIMMING_TSR:
				JAXBContext.newInstance(Configurations.class).createMarshaller().marshal(session_configuration, 
						new File(ApiUtil.KHELO_INDIA_DIRECTORY + ApiUtil.CONFIGURATIONS_DIRECTORY + configuration_file_name));
			case ApiUtil.TENNIS: case ApiUtil.Cricket:
				JAXBContext.newInstance(Configurations.class).createMarshaller().marshal(session_configuration, 
						new File(ApiUtil.KHELO_INDIA_DIRECTORY + ApiUtil.CONFIGURATIONS_DIRECTORY + configuration_file_name));
				break;
			case ApiUtil.FOOTBALL:
				access_token = ApiFunctions.getAccessToken();
				JAXBContext.newInstance(Configurations.class).createMarshaller().marshal(session_configuration, 
						new File(ApiUtil.SPORTS_DIRECTORY + ApiUtil.API_CONFIGURATIONS_DIRECTORY + configuration_file_name));
				break;	
			case ApiUtil.BASKETBALL: case ApiUtil.AFC_Football: case ApiUtil.BOXING: case ApiUtil.ISPL: case ApiUtil.GOLF:
				JAXBContext.newInstance(Configurations.class).createMarshaller().marshal(session_configuration, 
						new File(ApiUtil.SPORTS_DIRECTORY + ApiUtil.API_CONFIGURATIONS_DIRECTORY + configuration_file_name));
				break;
			case ApiUtil.KABADDI_KADAMBA:
				JAXBContext.newInstance(Configurations.class).createMarshaller().marshal(session_configuration, 
						new File(ApiUtil.KHELO_INDIA_DIRECTORY + ApiUtil.CONFIGURATIONS_DIRECTORY + configuration_file_name));
				
				if(new File(destination_path + match_name.replace(".xml", ".json")).exists()) {
					session_match = new ObjectMapper().readValue(new File(destination_path + match_name.replace(".xml", ".json")), Match.class);
				}else {
					session_match = new Match();
					session_match.setMatchFileName(match_name.replace(".xml", ".json"));
					new ObjectMapper().writeValue(new File(destination_path + match_name.replace(".xml", ".json")), session_match);
				}
				break;
			case ApiUtil.KABADDI:
				JAXBContext.newInstance(Configurations.class).createMarshaller().marshal(session_configuration, 
						new File(ApiUtil.SPORTS_DIRECTORY + ApiUtil.API_CONFIGURATIONS_DIRECTORY + configuration_file_name));
				
				if(new File(destination_path + match_name.replace(".xml", ".json")).exists()) {
					session_match = new ObjectMapper().readValue(new File(destination_path + match_name.replace(".xml", ".json")), Match.class);
				}else {
					session_match = new Match();
					session_match.setMatchFileName(match_name.replace(".xml", ".json"));
					new ObjectMapper().writeValue(new File(destination_path + match_name.replace(".xml", ".json")), session_match);
				}
				break;
			case ApiUtil.KABADDI_GIPKL:
				JAXBContext.newInstance(Configurations.class).createMarshaller().marshal(session_configuration, 
						new File(ApiUtil.SPORTS_DIRECTORY + ApiUtil.API_CONFIGURATIONS_DIRECTORY + configuration_file_name));
				
				Files.list(Paths.get(source_path.trim())).filter(Files::isRegularFile)
			     .forEach(src -> {
			         try {
			             Path dest = Paths.get(destination_path.trim()).resolve(src.getFileName());
			             Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
			         } catch (Exception e) {
			             e.printStackTrace();
			         }
			     });

				break;	
			}
			model.addAttribute("session_match",session_match);
			model.addAttribute("live_match",live_match);
			model.addAttribute("session_configuration",session_configuration);
			model.addAttribute("session_selected_broadcaster", session_selected_broadcaster);
			model.addAttribute("session_update_time", session_update_time);
			model.addAttribute("expiry_message",new SimpleDateFormat("E, dd MMM yyyy").format(
					new SimpleDateFormat("yyyy-MM-dd").parse(expiry_date)));

			return "api";
		}
	}
	
	@RequestMapping(value = {"/processApiProcedures"}, method={RequestMethod.GET,RequestMethod.POST})    
	public @ResponseBody String processApiProcedures(
			@ModelAttribute("session_configuration") Configurations session_configuration,
			@ModelAttribute("session_api_match_name") String session_api_match_name,
			@ModelAttribute("session_source_path") String session_source_path,
			@ModelAttribute("session_destination_path") String session_destination_path,
			@ModelAttribute("session_update_time") String session_update_time,
			@RequestParam(value = "whatToProcess", required = false, defaultValue = "") String whatToProcess,
			@RequestParam(value = "valueToProcess", required = false, defaultValue = "") String valueToProcess)
					throws FactoryConfigurationError, Exception
	{
		switch(whatToProcess.toUpperCase()) {
		case "GET-CONFIG-DATA":
			session_configuration = (Configurations)JAXBContext.newInstance(Configurations.class).createUnmarshaller().unmarshal(
					new File(ApiUtil.SPORTS_DIRECTORY + ApiUtil.API_CONFIGURATIONS_DIRECTORY + valueToProcess));			
			return objectMapper.writeValueAsString(session_configuration).toString();
		case "ANIMATE-OUT":
			print_writer.println("LAYER2*EVEREST*STAGE*DIRECTOR*" + "In" + " " + "CONTINUE" + ";");
			return objectMapper.writeValueAsString(null).toString();
		case "ANIMATE-IN-MEDALS_TALLY":
			print_writer.println("LAYER2*EVEREST*STAGE*DIRECTOR*" + "In" + " " + "START" + ";");
			return objectMapper.writeValueAsString(null).toString();
		case "GET_MEDAL_TALLY_STATS":
			switch (session_selected_broadcaster) {
			case ApiUtil.KHELO_INDIA:
				session_selected_scenes.add(new Scene(valueToProcess.split(",")[0],ApiUtil.TWO)); // Second layer
				session_selected_scenes.get(0).scene_load(print_writer, session_selected_broadcaster);
				
				for(int j=1;j<=10;j++) {
					print_writer.println("LAYER2*EVEREST*TREEVIEW*Main*FUNCTION*TAG_CONTROL SET tPos0" + j + " " + " " + ";");
					print_writer.println("LAYER2*EVEREST*TREEVIEW*Main*FUNCTION*TAG_CONTROL SET tTeam0" + j + " " + " " + ";");
					print_writer.println("LAYER2*EVEREST*TREEVIEW*Main*FUNCTION*TAG_CONTROL SET tGold0" + j + " "  + " " + ";");
					print_writer.println("LAYER2*EVEREST*TREEVIEW*Main*FUNCTION*TAG_CONTROL SET tSilver0" + j + " "  + " " + ";");
					print_writer.println("LAYER2*EVEREST*TREEVIEW*Main*FUNCTION*TAG_CONTROL SET tBronze0" + j + " "  + " " + ";");
					print_writer.println("LAYER2*EVEREST*TREEVIEW*Main*FUNCTION*TAG_CONTROL SET tTotal0" + j + " "  + " " + ";");
				}
				
				List<KheloIndia> kheloIndia = ApiFunctions.getMedalTallyDatafromAPI(valueToProcess.split(",")[1]);
				if(kheloIndia != null) {
					print_writer.println("LAYER2*EVEREST*TREEVIEW*Main*FUNCTION*TAG_CONTROL SET tHeader " + valueToProcess.split(",")[1].toUpperCase() 
							+ " - MEDAL TALLY" + ";");
					for (int i=0;i<=kheloIndia.size()-1;i++) {
						print_writer.println("LAYER2*EVEREST*TREEVIEW*Main*FUNCTION*TAG_CONTROL SET tPos0" + (i+1) + " " + kheloIndia.get(i).getRank() + ";");
						print_writer.println("LAYER2*EVEREST*TREEVIEW*Main*FUNCTION*TAG_CONTROL SET tTeam0" + (i+1) + " " + kheloIndia.get(i).getState_name() + ";");
						print_writer.println("LAYER2*EVEREST*TREEVIEW*Main*FUNCTION*TAG_CONTROL SET tGold0" + (i+1) + " "  + kheloIndia.get(i).getGold() + ";");
						print_writer.println("LAYER2*EVEREST*TREEVIEW*Main*FUNCTION*TAG_CONTROL SET tSilver0" + (i+1) + " "  + kheloIndia.get(i).getSilver()+ ";");
						print_writer.println("LAYER2*EVEREST*TREEVIEW*Main*FUNCTION*TAG_CONTROL SET tBronze0" + (i+1) + " "  + kheloIndia.get(i).getBronze() + ";");
						print_writer.println("LAYER2*EVEREST*TREEVIEW*Main*FUNCTION*TAG_CONTROL SET tTotal0" + (i+1) + " "  + kheloIndia.get(i).getTotal()+ ";");
						
						print_writer.println("LAYER1*EVEREST*GLOBAL PREVIEW ON;");
						print_writer.println("LAYER2*EVEREST*STAGE*DIRECTOR*In STOP;");
						print_writer.println("LAYER2*EVEREST*STAGE*DIRECTOR*Out STOP;");
						print_writer.println("LAYER2*EVEREST*STAGE*DIRECTOR*In SHOW 110.0;");
						print_writer.println("LAYER2*EVEREST*STAGE*DIRECTOR*Out SHOW 0.0;");
						print_writer.println("LAYER1*EVEREST*GLOBAL SNAPSHOT_PATH C:/Temp/Preview.png;");
						print_writer.println("LAYER1*EVEREST*GLOBAL SNAPSHOT 1920 1080;");
						TimeUnit.SECONDS.sleep(1);
						print_writer.println("LAYER2*EVEREST*STAGE*DIRECTOR*Out SHOW 0.0;");
						print_writer.println("LAYER2*EVEREST*STAGE*DIRECTOR*In SHOW 0.0;");
						print_writer.println("LAYER1*EVEREST*GLOBAL PREVIEW OFF;");
					}
				} else {
					System.out.println("kheloIndia size is NULL");
				}
			}
			return objectMapper.writeValueAsString(null).toString();
		case "BOXING_MATCH_DATA":
			this_api_boxing = ApiFunctions.readFromUrl(source_path);
			new ObjectMapper().writeValue(new File(destination_path + "data.json"), this_api_boxing);
			return objectMapper.writeValueAsString(null).toString();
		case "ISPL_PLAYERINFO_DATA":

		    ObjectNode response1 = objectMapper.createObjectNode();
		    source_path1 = "https://dz8zbd8amw7pd.cloudfront.net/Kabaddi_champions_league/feeds/comp/87/playerinfo.json";
		    destination_path1 = "C:\\Sports\\Cricket\\PLAYERINFO.json";

		    try {
		        System.out.println("Calling API: " + source_path);

		        ObjectMapper mapper = new ObjectMapper();
		        mapper.configure(
		            com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
		            false
		        );

		        player_Info playerInfo = mapper.readValue(
		                new java.net.URL(source_path1),
		                player_Info.class
		        );

		        if (playerInfo == null) {
		            response1.put("status", "failed : playerInfo is NULL");
		            return response1.toString();
		        }

		        System.out.println("API Success. Writing file...");

		        // 🔹 ENSURE DESTINATION FOLDER EXISTS
		        File destinationFile = new File(destination_path1);
		        if (destinationFile.getParentFile() != null) {
		            destinationFile.getParentFile().mkdirs();
		        }

		        // 🔹 WRITE JSON TO FILE
		        mapper.writerWithDefaultPrettyPrinter()
		              .writeValue(destinationFile, playerInfo);

		        response1.put("status", "success");
		        response1.put("file", destinationFile.getAbsolutePath());
		        return response1.toString();

		    } catch (Exception e) {

		        e.printStackTrace(); // 🔥 KEEP THIS

		        response1.put("status", "failed : exception");
		        response1.put("error", e.getMessage());
		        return response1.toString();
		    }
		case "GOLFSCORESRESPONSE":
			ObjectNode responsess = objectMapper.createObjectNode();
			System.out.println(session_api_match_name);
			source_path1 = "https://pgtofindia.net/data/index.php?export=score&tour_day=" + match_name;
			destination_path1 = "C:\\Sports\\Golf\\SCOREDATA" + match_name + ".json";
			try {

		        System.out.println("Calling API: " + source_path1);

		        GolfScoresResponse scoreresponse = ApiFunctions.readGolfScore(source_path1);

		        if (scoreresponse == null) {
		        	responsess.put("status", "failed : leaderboard is NULL");
		            return responsess.toString();
		        }

		        System.out.println("API Success. Writing file...");

		        ObjectMapper mapper = new ObjectMapper();
		        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(destination_path1), scoreresponse);

		        responsess.put("status", "success");
		        return responsess.toString();

		    } catch (Exception e) {

		        e.printStackTrace();   // <-- MOST IMPORTANT

		        responsess.put("status", "failed : exception");
		        responsess.put("error", e.getMessage());
		        return responsess.toString();
		    }
		case "GOLFDRAWSRESPONSE":

			ObjectNode responsesdraw = objectMapper.createObjectNode();

		    source_path1 = "https://pgtofindia.net/data/index.php?export=draw&tour_day=" + match_name;
		    destination_path1 = "C:\\Sports\\Golf\\DRAWSDATA" + match_name + ".json";

		    try {

		        System.out.println("Calling API: " + source_path1);

		        GolfDrawsResponse drawsresponse = ApiFunctions.readDraws(source_path1);

		        if (drawsresponse == null || drawsresponse.getData() == null || drawsresponse.getData().isEmpty()) {
		        	responsesdraw.put("status", "failed : draws data is NULL");
		            return responsesdraw.toString();
		        }

		        System.out.println("API Success. Writing file...");

		        ObjectMapper mapper = new ObjectMapper();

		        mapper.writerWithDefaultPrettyPrinter()
		                .writeValue(new File(destination_path1), drawsresponse);

		        responsesdraw.put("status", "success");
		        return responsesdraw.toString();

		    } catch (Exception e) {

		        e.printStackTrace();

		        responsesdraw.put("status", "failed");
		        responsesdraw.put("error", e.getMessage());

		        return responsesdraw.toString();
		    }
		case "GOLFTOURRESPONSE":

			ObjectNode responses = objectMapper.createObjectNode();
			
			try {
				source_path1 = "https://pgtofindia.net/data/index.php?export=tour";
				destination_path1 = "C:\\Sports\\Golf\\TOURDATA.json";
				
		        System.out.println("Calling API: " + source_path1);

		        GolfTourResponse tourresponse = ApiFunctions.readGolfTour(source_path1);

		        if (tourresponse == null) {
		        	responses.put("status", "failed : tourresponse is NULL");
		            return responses.toString();
		        }

		        System.out.println("API Success. Writing file...1");

		        ObjectMapper mapper1 = new ObjectMapper();
		        mapper1.writerWithDefaultPrettyPrinter().writeValue(new File(destination_path1), tourresponse);

		        source_path2 = "https://pgtofindia.net/data/index.php?export=course";
				destination_path2 = "C:\\Sports\\Golf\\COURSEDATA.json";
				

		        GolfCourseResponse courseresponse = ApiFunctions.readGolfCourse(source_path2);

		        if (courseresponse == null) {
		        	responses.put("status", "failed : courseresponse is NULL");
		            return responses.toString();
		        }

		        System.out.println("API Success. Writing file...2");

		        ObjectMapper mapperr = new ObjectMapper();
		        mapperr.writerWithDefaultPrettyPrinter().writeValue(new File(destination_path2), courseresponse);
		        
		        source_path3 = "https://pgtofindia.net/data/index.php?export=entry";
				destination_path3 = "C:\\Sports\\Golf\\ENTRYDATA.json";
				

		        GolfEntryListResponse entryresponse = ApiFunctions.readGolfEntry(source_path3);

		        if (entryresponse == null) {
		        	responses.put("status", "failed : courseresponse is NULL");
		            return responses.toString();
		        }

		        System.out.println("API Success. Writing file...2");

		        ObjectMapper mapper3 = new ObjectMapper();
		        mapper3.writerWithDefaultPrettyPrinter().writeValue(new File(destination_path3), entryresponse);
		        
		        responses.put("status", "success");
		        return responses.toString();

		    } catch (Exception e) {

		        e.printStackTrace();   // <-- MOST IMPORTANT

		        responses.put("status", "failed : exception");
		        responses.put("error", e.getMessage());
		        return responses.toString();
		    }
		case "ISPL_MVP_LEADERBOARD_DATA":
			
			ObjectNode response = objectMapper.createObjectNode();
			
			try {

		        System.out.println("Calling API: " + source_path);

		        mvp_leaderBoard leaderboard = ApiFunctions.readIsplMvpLeaderBoardUrl(source_path);

		        if (leaderboard == null) {
		            response.put("status", "failed : leaderboard is NULL");
		            return response.toString();
		        }

		        System.out.println("API Success. Writing file...");

		        ObjectMapper mapper = new ObjectMapper();
		        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(destination_path), leaderboard);

		        response.put("status", "success");
		        return response.toString();

		    } catch (Exception e) {

		        e.printStackTrace();   // <-- MOST IMPORTANT

		        response.put("status", "failed : exception");
		        response.put("error", e.getMessage());
		        return response.toString();
		    }
		default:
			if(session_selected_broadcaster != null) {
				switch (session_selected_broadcaster) {
				case ApiUtil.GOLF:
					switch(whatToProcess.toUpperCase()) {
					case "READ-APIMATCH-AND-POPULATE":
						 source_path = "https://pgtofindia.net/data/index.php?export=score&tour_day=" + match_name;
				            destination_path = "C:/Sports/Golf/SCOREDATA" + match_name + ".json";

				           String status = ApiFunctions.golfscoreJsonToFile(source_path, destination_path);
							ObjectNode responseObj = objectMapper.createObjectNode();
				            responseObj.put("status", status);

				            return responseObj.toString();
					}
					break;
				case ApiUtil.SWIMMING_TSR:
					switch(whatToProcess.toUpperCase()) {
					case "READ-APIMATCH-AND-POPULATE":
						 source_path = "https://cloud.cricket-21.com/cricketapi/api/master/CricketStatsAPI?ReportID=201&Competition=2725&type=json";
				            destination_path = "C:/Sports/Cricket/BOWLER_STATS.json";
				            ApiFunctions.cricketJsonToFile(source_path, destination_path);
				            return objectMapper.writeValueAsString(null).toString();
					}
					break;
				case ApiUtil.Cricket:
				    switch (whatToProcess.toUpperCase()) {

				        case "CRICKET_BOWLERSTATS":
				            source_path = "https://cloud.cricket-21.com/cricketapi/api/master/CricketStatsAPI?ReportID=201&Competition=2725&type=json";
				            destination_path = "C:/Sports/Cricket/BOWLER_STATS.json";
				            ApiFunctions.cricketJsonToFile(source_path, destination_path);
				            return objectMapper.writeValueAsString(null).toString();

				        case "CRICKET_BATTERSTATS":
				            source_path = "https://cloud.cricket-21.com/cricketapi/api/master/CricketStatsAPI?ReportID=101&Competition=2725&type=json";
				            destination_path = "C:/Sports/Cricket/BATTER_STATS.json";
				            ApiFunctions.cricketJsonToFile(source_path, destination_path);
				            return objectMapper.writeValueAsString(null).toString();

				        case "READ-APIMATCH-AND-POPULATE":
				            switch (valueToProcess.toUpperCase()) {

				                case "CRICKET_BOWLERSTATS":
				                    source_path = "https://cloud.cricket-21.com/cricketapi/api/master/CricketStatsAPI?ReportID=201&Competition=2725&type=json";
				                    destination_path = "C:/Sports/Cricket/BOWLER_STATS.json";
				                    ApiFunctions.cricketJsonToFile(source_path, destination_path);
				                    return objectMapper.writeValueAsString(null).toString();

				                case "CRICKET_BATTERSTATS":
				                    source_path = "https://cloud.cricket-21.com/cricketapi/api/master/CricketStatsAPI?ReportID=101&Competition=2725&type=json";
				                    destination_path = "C:/Sports/Cricket/BATTER_STATS.json";
				                    ApiFunctions.cricketJsonToFile(source_path, destination_path);
				                    return objectMapper.writeValueAsString(null).toString();
				            }
				            break; 

				    }
				    return null;
				case ApiUtil.AFC_Football:
					switch(whatToProcess.toUpperCase()) {
					case "FOOTBALL_PRE_MATCH":
						 ApiFunctions.getFootballPreData(match_name);
						 break;
					case "POINTS_TABLE":
						ApiFunctions.getFootballPointsTable();
						break;
					case "FOOTBALL_STATS": case "READ-APIMATCH-AND-POPULATE":
						ApiFunctions.getFootballData(match_name);
			            return objectMapper.writeValueAsString(null).toString();
					}
		            return objectMapper.writeValueAsString(ApiFunctions.getFootballData(match_name)).toString();
				case ApiUtil.BASKETBALL:
					 Map<String, Object> responseMap = new HashMap<>();
					switch(whatToProcess.toUpperCase()) {
					case "BASKETBALL_MATCH_START":
						status ="START";
						 responseMap.put("status", status);
				      return objectMapper.writeValueAsString(responseMap).toString();
					case "BASKETBALL_MATCH_STOP":
						status ="STOP";
						responseMap.put("status", status);
			            return objectMapper.writeValueAsString(responseMap).toString();
					case "BASKETBALL_PRE_MATCH":
						 ApiFunctions.getBasketBallPreMatch();
						 break;
					case "BASKETBALL_STATS": 
						INCP_SportEvent = ApiFunctions.getBasketBallDatas(destination_path,match_name);
						responseMap.put("INCP_SportEvent", INCP_SportEvent);
			            responseMap.put("status", status);
			            return objectMapper.writeValueAsString(responseMap).toString();
					case "READ-APIMATCH-AND-POPULATE":
						if(status.equalsIgnoreCase("START")) {
							INCP_SportEvent = ApiFunctions.getBasketBallDatas(destination_path,match_name);
							 responseMap.put("status", status);
				         return objectMapper.writeValueAsString(responseMap).toString();
						}else{
							responseMap.put("INCP_SportEvent", INCP_SportEvent);
			                responseMap.put("status", status);
			                return objectMapper.writeValueAsString(responseMap).toString();
						}
					}
					responseMap.put("INCP_SportEvent", INCP_SportEvent);
				    responseMap.put("status", status);
				    return objectMapper.writeValueAsString(responseMap).toString();
				case ApiUtil.TENNIS:
					switch(whatToProcess.toUpperCase()) {
					 case "TENNIS_STATS": case "READ-APIMATCH-AND-POPULATE":
						 api_tennis_team_stats =  ApiFunctions.getTopStatsDatafromAPI(destination_path, match_name);
						 
						 return objectMapper.writeValueAsString(session_match).toString();
					
					 }
					return objectMapper.writeValueAsString(tennis_match).toString();
					
				case ApiUtil.FOOTBALL:
					
					switch(whatToProcess.toUpperCase()) {
					case "FOOTBALL_GOALS_EXPECTED":
						stats_url = ApiUtil.FOOTBALL_API_PATH + "matchexpectedgoals" + ApiUtil.FOOTBALL_TOKEN + "?" + ApiUtil.FOOTBALL_API_MODE+ "&" +
								 ApiUtil.FOOTBALL_API_JSON +"&fx="+ ApiUtil.FOOTBALL_FIXTURE_ID ;
						 System.out.println(stats_url);
						 return objectMapper.writeValueAsString(ApiFunctions.getExpectedGoals(stats_url, access_token)).toString();
					case "FOOTBALL_MATCH_PREVIEW":
						ApiFunctions.getAccessToken();
						stats_url = ApiUtil.FOOTBALL_API_PATH + "matchpreview" + ApiUtil.FOOTBALL_TOKEN + "/?" + 
								ApiUtil.FOOTBALL_API_MODE +"&" + ApiUtil.FOOTBALL_API_JSON + "&fx=" + ApiUtil.FOOTBALL_FIXTURE_ID;
						 return objectMapper.writeValueAsString(ApiFunctions.getMatchPreview(stats_url, access_token)).toString();	 
					case "FOOTBALL_TOURNAMENT_SIMULATION":
						stats_url = ApiUtil.FOOTBALL_API_PATH + "predictions/tournamentsimulations" + ApiUtil.FOOTBALL_TOKEN + "/8t8ofk94zy6ksx1spnfecvpck?" + 
								ApiUtil.FOOTBALL_API_MODE + "&" + ApiUtil.FOOTBALL_API_JSON;
						api_tournament_simulation =  ApiFunctions.getFootballTournamentSimulationfromAPI(stats_url, access_token);
						 return objectMapper.writeValueAsString(live_match).toString();
					case "FOOTBALL_WIN_PROBABILITY":
						api_live_data =  ApiFunctions.getFootballWinProbabilityfromAPI(stats_url, access_token);
						 return objectMapper.writeValueAsString(live_match).toString();
					case "POPULATE-PLAYER_MATCH_EVENT":
						stats_url = ApiUtil.FOOTBALL_API_PATH + "matchevent" + ApiUtil.FOOTBALL_TOKEN + "/" + ApiUtil.FOOTBALL_FIXTURE_ID + "?" + 
								ApiUtil.FOOTBALL_API_JSON + "&" + ApiUtil.FOOTBALL_API_MODE + "?prsn=" + "" + "&type=52" + 
								"&prsn=apdrig6xt1hxub1986s3uh1x";
						 api_live_data =  ApiFunctions.getFootballPlayerEventfromAPI(stats_url, access_token);
						 return objectMapper.writeValueAsString(live_match).toString();
					case "POPULATE-MATCH_EVENT":
						stats_url = ApiUtil.FOOTBALL_API_PATH + "matchevent" + ApiUtil.FOOTBALL_TOKEN + "/?"+ ApiUtil.FOOTBALL_API_JSON + 
								"&" + ApiUtil.FOOTBALL_API_MODE + "&fx=" + ApiUtil.FOOTBALL_FIXTURE_ID;
						System.out.println(stats_url);
						 api_live_data =  ApiFunctions.getFootballMatchEventfromAPI(stats_url, access_token);
						 return objectMapper.writeValueAsString(live_match).toString();	 
					case "POPULATE-SEASONAL":
						api_seasonal_data = ApiFunctions.getSeasonalStatsfromAPI(stats_url, access_token);
						return objectMapper.writeValueAsString(live_match).toString();
					case "POPULATE-PLAYER_STATS":
						stats_url = ApiUtil.FOOTBALL_API_PATH + "playercareer" + ApiUtil.FOOTBALL_TOKEN + "?prsn=" + match_name + "&" + 
								ApiUtil.FOOTBALL_API_JSON + "&" + ApiUtil.FOOTBALL_API_MODE;
						api_player_data = ApiFunctions.getPlayerStatsfromAPI(stats_url, access_token);
						return objectMapper.writeValueAsString(live_match).toString();
					case "PENALTY_PREVIEW":
						stats_url = ApiUtil.FOOTBALL_API_PATH + "matchpenaltiespreview" + ApiUtil.FOOTBALL_TOKEN + "/?" + 
								ApiUtil.FOOTBALL_API_MODE +"&" + ApiUtil.FOOTBALL_API_JSON+"&fx="+ApiUtil.FOOTBALL_FIXTURE_ID ;
						//https://api.performfeeds.com/soccerdata/matchpenaltiespreview/26kfa29kdpyu170bzsv5cbuw0/?_rt=b&_fmt=json&fx=2a6k8cu19p7xmmcspojqwgkyc
						api_football_penalty = ApiFunctions.getPenaltyPreview(stats_url, access_token);
						 return objectMapper.writeValueAsString(live_match).toString();
					case "POSSESION_EVENTS":
						stats_url = ApiUtil.FOOTBALL_API_PATH + "possessionevent" + ApiUtil.FOOTBALL_TOKEN + "/7sasdn9v78std9dm86ajvnuok?" + 
								ApiUtil.FOOTBALL_API_MODE + "&" + ApiUtil.FOOTBALL_API_JSON;
						api_football_possesion_events = ApiFunctions.getPossesionEvent(stats_url, access_token);
						 return objectMapper.writeValueAsString(live_match).toString();
					case "LINEUPS":
						stats_url = ApiUtil.FOOTBALL_API_PATH + "matchprovisionallineups" + ApiUtil.FOOTBALL_TOKEN + "?fx=f261n53t0bbc6vslpiodd4lck&" + 
								ApiUtil.FOOTBALL_API_MODE +"&" + ApiUtil.FOOTBALL_API_JSON;
						api_football_lineup = ApiFunctions.getFootballLineup(stats_url, access_token);
						 return objectMapper.writeValueAsString(live_match).toString();
					case "POINTS_TABLE":
						stats_url = ApiUtil.FOOTBALL_API_PATH + "standings" + ApiUtil.FOOTBALL_TOKEN + "?tmcl="+ApiUtil.FOOTBALL_TOURNAMENT_CALENDER_ID + 
								"&" +ApiUtil.FOOTBALL_API_JSON +"&" + ApiUtil.FOOTBALL_API_MODE ;
						api_football_teams_standing = ApiFunctions.getPointsTable(stats_url, access_token);
						 return objectMapper.writeValueAsString(live_match).toString();
					case "TOP_PERFORMER":
						stats_url = ApiUtil.FOOTBALL_API_PATH + "topperformers" + ApiUtil.FOOTBALL_TOKEN + "?tmcl="+ApiUtil.FOOTBALL_TOURNAMENT_CALENDER_ID+"&" + 
								ApiUtil.FOOTBALL_API_JSON +"&" + ApiUtil.FOOTBALL_API_MODE;
						api_football_topPerformers = ApiFunctions.getTopPerformers(stats_url, access_token);
						 return objectMapper.writeValueAsString(live_match).toString();
					 case "FOOTBALL_SCHEDULE":
//					        String destinationFilePath = "C:\\Temp\\copied_file.txt"; // Change this to your desired destination file path					        
//					        String sourceUrl = "http://api.performfeeds.com/soccerdata/matchtracking/download/soccer_10fps_68yjh2787ow2da11tsd4u3k0k.txt?token=st=1713249808~exp=1713250408~acl=/*~hmac=855f20788ba2c52b7e4042df99ef88259d9fa18bc875ce84aa2f4ed6b0b2f517";
//
//					        try {
//					            URL url = new URL(sourceUrl);
//					            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//					            connection.setRequestMethod("GET");
//
//					            // Open input stream from the connection
//					            InputStream inputStream = connection.getInputStream();
//
//					            // Open output stream to write data to the local file
//					            FileOutputStream outputStream = new FileOutputStream(destinationFilePath);
//
//					            // Buffer for reading data from input stream
//					            byte[] buffer = new byte[4096];
//					            int bytesRead;
//
//					            // Read data from input stream and write to output stream
//					            while ((bytesRead = inputStream.read(buffer)) != -1) {
//					                outputStream.write(buffer, 0, bytesRead);
//					            }
//
//					            // Close streams
//					            inputStream.close();
//					            outputStream.close();
//
////					            System.out.println("Data copied successfully from " + sourceUrl + " to " + destinationFilePath);
//					        } catch (IOException e) {
//					            e.printStackTrace();
//					        }
						 ////--------------------------------------------------------////
//						 String filePath = "C:\\Temp\\copied_file.txt"; // Replace this with the path to your text file
//					        
//					        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
//					            long filePointer = file.length() - 1; // Start at the end of the file
//
//					            StringBuilder lastLine = new StringBuilder();
//
//					            // Loop backward from the end of the file until a new line character is found
//					            while (filePointer >= 0) {
//					                file.seek(filePointer); // Move the file pointer to the current position
//					                char c = (char) file.read(); // Read a character
//
//					                if (c == '\n') {
//					                    // If a newline character is found, we've reached the end of the last line
//					                    break;
//					                }
//
//					                // Prepend the current character to the lastLine string
//					                lastLine.insert(0, c);
//
//					                // Move the file pointer backward
//					                filePointer--;
//					            }
//
//					            // Print or use the last line
//					            System.out.println("Last line of the file: " + lastLine.toString());
//					        } catch (IOException e) {
//					            e.printStackTrace();
//					        }
						 //https://api.performfeeds.com/soccerdata/tournamentschedule/1vmmaetzoxkgg1qf6pkpfmku0k/emq4j56v2j9tf3jgzfksznms4?_fmt=json&_rt=b
						 stats_url = ApiUtil.FOOTBALL_API_PATH + "tournamentschedule" + ApiUtil.FOOTBALL_TOKEN + "/"+ApiUtil.FOOTBALL_TOURNAMENT_CALENDER_ID +"?" + 
									ApiUtil.FOOTBALL_API_JSON + "&" + ApiUtil.FOOTBALL_API_MODE;
						 football_match =  ApiFunctions.getTournamentSchedulefromAPI(stats_url, access_token);
						 return objectMapper.writeValueAsString(live_match).toString();
					 case "FOOTBALL_LIVE_TRACKING":
						 api_live_data =  ApiFunctions.getPlayerTrackingDatafromAPI(stats_url, access_token);
						 return objectMapper.writeValueAsString(live_match).toString();	 
					 case "FOOTBALL_TOURNAMENT_TEAMS_SQUAD":
						 //ApiFunctions.getTournamentTeamsSquadfromAPI(access_token);
						 stats_url = ApiUtil.FOOTBALL_API_PATH + "squads" + ApiUtil.FOOTBALL_TOKEN + "?"+ApiUtil.FOOTBALL_API_JSON
								 +"&" +ApiUtil.FOOTBALL_API_MODE +"&detailed=yes&tmcl="+ApiUtil.FOOTBALL_TOURNAMENT_CALENDER_ID  ;
						 ApiFunctions.getTeamsfromAPI(stats_url,access_token);
						 return objectMapper.writeValueAsString(live_match).toString();
					 case "FOOTBALL_TEAMS_RANKING":
						 stats_url = ApiUtil.FOOTBALL_API_PATH + "rankings" + ApiUtil.FOOTBALL_TOKEN + "/?" +ApiUtil.FOOTBALL_API_MODE +"&" + ApiUtil.FOOTBALL_API_JSON+
								  "&tmcl="+ApiUtil.FOOTBALL_TOURNAMENT_CALENDER_ID  ;
						 return objectMapper.writeValueAsString(ApiFunctions.getTeamRankingfromAPI(stats_url, access_token)).toString();
					 case"FOOTBALL_FIXTURES_AND_RESULTS":
						 stats_url = ApiUtil.FOOTBALL_API_PATH + "matchdetailed" + ApiUtil.FOOTBALL_TOKEN + "?" + 
								   ApiUtil.FOOTBALL_API_MODE + "&" + ApiUtil.FOOTBALL_API_JSON + "&live=yes&tmcl=93wcwtf25153hracvqva88aac&lineups=yes";
						 return objectMapper.writeValueAsString(ApiFunctions.getFixturesAndResultsfromAPI(stats_url, access_token)).toString();
					 case"FOOTBALL_MATCH_INSIGHTS":
						 stats_url = ApiUtil.FOOTBALL_API_PATH + "matchinsights" + ApiUtil.FOOTBALL_TOKEN + "/" + ApiUtil.FOOTBALL_FIXTURE_ID + "?" + 
								 "&" + ApiUtil.FOOTBALL_API_MODE + "&" + ApiUtil.FOOTBALL_API_JSON;
						 return objectMapper.writeValueAsString(ApiFunctions.getMatchInsightsfromAPI(stats_url, access_token)).toString();
					 case"FOOTBALL_MATCH_INSIGHTS2":
						 stats_url = ApiUtil.FOOTBALL_API_PATH + "matchfactsall" + ApiUtil.FOOTBALL_TOKEN + "?fx=" + ApiUtil.FOOTBALL_FIXTURE_ID + 
								 "&" + ApiUtil.FOOTBALL_API_MODE + "&" + ApiUtil.FOOTBALL_API_JSON + "&_lcl=en-gb";
						 return objectMapper.writeValueAsString(ApiFunctions.getMatchInsights2fromAPI(stats_url, access_token)).toString();	 
					 case"FOOTBALL_PASS_MATRIX":
						 stats_url = ApiUtil.FOOTBALL_API_PATH + "passmatrix" + ApiUtil.FOOTBALL_TOKEN + "/?"+ ApiUtil.FOOTBALL_API_JSON +"&"+
								 ApiUtil.FOOTBALL_API_MODE +"&fx="+ApiUtil.FOOTBALL_FIXTURE_ID ;
						 System.out.println(stats_url);
						 return objectMapper.writeValueAsString(ApiFunctions.getPassMatrixfromAPI(stats_url, access_token)).toString();
					 case"FOOTBALL_MATCH_MOMENTUM":
						 stats_url = ApiUtil.FOOTBALL_API_PATH + "predictions/momentum" + ApiUtil.FOOTBALL_TOKEN + "/" + ApiUtil.FOOTBALL_FIXTURE_ID + "?" + 
								   ApiUtil.FOOTBALL_API_MODE +"&" + ApiUtil.FOOTBALL_API_JSON;
						 return objectMapper.writeValueAsString(ApiFunctions.getMatchMomentumfromAPI(stats_url, access_token)).toString();
					 case"FOOTBALL_MATCH_POSSESSION_VALUES":
						 stats_url = ApiUtil.FOOTBALL_API_PATH + "matchpossessionvalues" + ApiUtil.FOOTBALL_TOKEN + "/7sasdn9v78std9dm86ajvnuok?" + 
								   ApiUtil.FOOTBALL_API_JSON +"&" + ApiUtil.FOOTBALL_API_MODE;
						 return objectMapper.writeValueAsString(ApiFunctions.getMatchPossessionValuesfromAPI(stats_url, access_token)).toString();
					 case "FOOTBALL_MATCH_PLAYER_RATINGS":
						 stats_url = ApiUtil.FOOTBALL_API_PATH + "matchplayerratings" + ApiUtil.FOOTBALL_TOKEN + "?fx=" + ApiUtil.FOOTBALL_FIXTURE_ID + "&" + 
								   ApiUtil.FOOTBALL_API_JSON +"&" + ApiUtil.FOOTBALL_API_MODE;
						 return objectMapper.writeValueAsString(ApiFunctions.getMatchPlayerRatingsfromAPI(stats_url, access_token)).toString();
					 case "LIVE_DATA":
						 stats_url =  ApiUtil.FOOTBALL_API_PATH + "matchstats" + ApiUtil.FOOTBALL_TOKEN + "/?" + ApiUtil.FOOTBALL_API_MODE + "&" + 
									ApiUtil.FOOTBALL_API_JSON + "&detailed=yes&fx=" + ApiUtil.FOOTBALL_FIXTURE_ID;
							return objectMapper.writeValueAsString(ApiFunctions.getFootballLiveDatafromAPI(stats_url, access_token)).toString();
					 
					 case "FOOTBALL_MATCH_POSSESSION":
						 return objectMapper.writeValueAsString(ApiFunctions.getPossessionfromAPI(stats_url, access_token)).toString();	 
					
					 case "SEASONAL_DATA":
							ApiFunctions.getTeamRankingfromAPI("",access_token);
							return objectMapper.writeValueAsString(live_match).toString();
					 
					 case "READ-APIMATCH-AND-POPULATE":
						 switch(valueToProcess.toUpperCase()) {
						 case "FOOTBALL_SCHEDULE":
							 stats_url = ApiUtil.FOOTBALL_API_PATH + "tournamentschedule" + ApiUtil.FOOTBALL_TOKEN + "/emq4j56v2j9tf3jgzfksznms4?" + 
										ApiUtil.FOOTBALL_API_JSON + "&" + ApiUtil.FOOTBALL_API_MODE;
							 football_match =  ApiFunctions.getTournamentSchedulefromAPI(stats_url, access_token);
							 return objectMapper.writeValueAsString(live_match).toString();
						 case "FOOTBALL_MATCH_PREVIEW":
								stats_url = ApiUtil.FOOTBALL_API_PATH + "matchpreview" + ApiUtil.FOOTBALL_TOKEN + "/?" + 
										ApiUtil.FOOTBALL_API_MODE +"&" + ApiUtil.FOOTBALL_API_JSON + "&fx=" + ApiUtil.FOOTBALL_FIXTURE_ID;
								 return objectMapper.writeValueAsString(ApiFunctions.getMatchPreview(stats_url, access_token)).toString();
						 case "FOOTBALL_TOURNAMENT_SIMULATION":
								stats_url = ApiUtil.FOOTBALL_API_PATH + "predictions/tournamentsimulations" + ApiUtil.FOOTBALL_TOKEN + "/8t8ofk94zy6ksx1spnfecvpck?" + 
										ApiUtil.FOOTBALL_API_MODE + "&" + ApiUtil.FOOTBALL_API_JSON;
								api_tournament_simulation =  ApiFunctions.getFootballTournamentSimulationfromAPI(stats_url, access_token);
								 return objectMapper.writeValueAsString(live_match).toString();
						case "FOOTBALL_WIN_PROBABILITY":
							stats_url = ApiUtil.FOOTBALL_API_PATH  + "matchlivewinprobability" + ApiUtil.FOOTBALL_TOKEN + "/68yjh2787ow2da11tsd4u3k0k?" + 
									ApiUtil.FOOTBALL_API_MODE + "&" + ApiUtil.FOOTBALL_API_JSON;
							api_live_data =  ApiFunctions.getFootballWinProbabilityfromAPI(stats_url, access_token);
							 return objectMapper.writeValueAsString(live_match).toString();
						case "POPULATE-PLAYER_MATCH_EVENT":
							stats_url = ApiUtil.FOOTBALL_API_PATH + "matchevent" + ApiUtil.FOOTBALL_TOKEN + "/bsu6pjne1eqz2hs8r3685vbhl?" + 
									ApiUtil.FOOTBALL_API_JSON + "&" + ApiUtil.FOOTBALL_API_MODE + 
									"&prsn=apdrig6xt1hxub1986s3uh1x";
							 api_live_data =  ApiFunctions.getFootballPlayerEventfromAPI(stats_url, access_token);
							 return objectMapper.writeValueAsString(live_match).toString();
						case "POPULATE-MATCH_EVENT":
							stats_url = ApiUtil.FOOTBALL_API_PATH + "matchevent" + ApiUtil.FOOTBALL_TOKEN + "/?"+ ApiUtil.FOOTBALL_API_JSON + 
							"&" + ApiUtil.FOOTBALL_API_MODE + "&fx=" + ApiUtil.FOOTBALL_FIXTURE_ID;
							 api_live_data =  ApiFunctions.getFootballMatchEventfromAPI(stats_url, access_token);
							 return objectMapper.writeValueAsString(live_match).toString();	 
						case "POPULATE-SEASONAL":
							api_seasonal_data = ApiFunctions.getSeasonalStatsfromAPI(stats_url, access_token);
							return objectMapper.writeValueAsString(live_match).toString();
						case "POPULATE-PLAYER_STATS":
							stats_url = ApiUtil.FOOTBALL_API_PATH + "playercareer" + ApiUtil.FOOTBALL_TOKEN + "?prsn=" + match_name + "&" + 
									ApiUtil.FOOTBALL_API_JSON + "&" + ApiUtil.FOOTBALL_API_MODE;
							api_player_data = ApiFunctions.getPlayerStatsfromAPI(stats_url, access_token);
							return objectMapper.writeValueAsString(live_match).toString();
						case "PENALTY_PREVIEW":
							stats_url = ApiUtil.FOOTBALL_API_PATH + "matchpenaltiespreview" + ApiUtil.FOOTBALL_TOKEN + "/?" + 
									ApiUtil.FOOTBALL_API_MODE +"&" + ApiUtil.FOOTBALL_API_JSON+"&fx="+ApiUtil.FOOTBALL_FIXTURE_ID ;
							api_football_penalty = ApiFunctions.getPenaltyPreview(stats_url, access_token);
							 return objectMapper.writeValueAsString(live_match).toString();
						case "POSSESION_EVENTS":
							stats_url = ApiUtil.FOOTBALL_API_PATH + "possessionevent" + ApiUtil.FOOTBALL_TOKEN + "/7sasdn9v78std9dm86ajvnuok?" + 
									ApiUtil.FOOTBALL_API_MODE + "&" + ApiUtil.FOOTBALL_API_JSON;
							api_football_possesion_events = ApiFunctions.getPossesionEvent(stats_url, access_token);
							 return objectMapper.writeValueAsString(live_match).toString();
						case "LINEUPS":
							stats_url = ApiUtil.FOOTBALL_API_PATH + "matchprovisionallineups" + ApiUtil.FOOTBALL_TOKEN + "?fx=f261n53t0bbc6vslpiodd4lck&" + 
									ApiUtil.FOOTBALL_API_MODE +"&" + ApiUtil.FOOTBALL_API_JSON;
							api_football_lineup = ApiFunctions.getFootballLineup(stats_url, access_token);
							 return objectMapper.writeValueAsString(live_match).toString();
						case "POINTS_TABLE":
							stats_url = ApiUtil.FOOTBALL_API_PATH + "standings" + ApiUtil.FOOTBALL_TOKEN + "?tmcl="+ApiUtil.FOOTBALL_TOURNAMENT_CALENDER_ID + 
							"&" +ApiUtil.FOOTBALL_API_JSON +"&" + ApiUtil.FOOTBALL_API_MODE ;
							api_football_teams_standing = ApiFunctions.getPointsTable(stats_url, access_token);
							 return objectMapper.writeValueAsString(live_match).toString();
						case "TOP_PERFORMER":
							stats_url = ApiUtil.FOOTBALL_API_PATH + "topperformers" + ApiUtil.FOOTBALL_TOKEN + "?tmcl="+ApiUtil.FOOTBALL_TOURNAMENT_CALENDER_ID+"&" + 
									ApiUtil.FOOTBALL_API_JSON +"&" + ApiUtil.FOOTBALL_API_MODE;
							api_football_topPerformers = ApiFunctions.getTopPerformers(stats_url, access_token);
							 return objectMapper.writeValueAsString(live_match).toString();
						 case "FOOTBALL_LIVE_TRACKING":
							 api_live_data =  ApiFunctions.getPlayerTrackingDatafromAPI(destination_path, access_token);
							 return objectMapper.writeValueAsString(live_match).toString();	 
						 case "FOOTBALL_TEAMS_RANKING":
							 stats_url = ApiUtil.FOOTBALL_API_PATH + "rankings" + ApiUtil.FOOTBALL_TOKEN + "?tmcl=" + ApiUtil.FOOTBALL_TOURNAMENT_CALENDER_ID + "&" + 
									   ApiUtil.FOOTBALL_API_MODE +"&" + ApiUtil.FOOTBALL_API_JSON;
							 return objectMapper.writeValueAsString(ApiFunctions.getTeamRankingfromAPI(stats_url, access_token)).toString();
						 case"FOOTBALL_FIXTURES_AND_RESULTS":
							 stats_url = ApiUtil.FOOTBALL_API_PATH + "matchdetailed" + ApiUtil.FOOTBALL_TOKEN + "?" + 
									   ApiUtil.FOOTBALL_API_MODE + "&" + ApiUtil.FOOTBALL_API_JSON + "&live=yes&tmcl=93wcwtf25153hracvqva88aac&lineups=yes";
							 return objectMapper.writeValueAsString(ApiFunctions.getFixturesAndResultsfromAPI(stats_url, access_token)).toString();
						 case"FOOTBALL_MATCH_INSIGHTS":
							 stats_url = ApiUtil.FOOTBALL_API_PATH + "matchinsights" + ApiUtil.FOOTBALL_TOKEN + "/" + ApiUtil.FOOTBALL_FIXTURE_ID + "?" + 
									 "&" + ApiUtil.FOOTBALL_API_MODE + "&" + ApiUtil.FOOTBALL_API_JSON;
							 return objectMapper.writeValueAsString(ApiFunctions.getMatchInsightsfromAPI(stats_url, access_token)).toString();
						 case"FOOTBALL_MATCH_INSIGHTS2":
							 stats_url = ApiUtil.FOOTBALL_API_PATH + "matchfactsall" + ApiUtil.FOOTBALL_TOKEN + "?fx=" + ApiUtil.FOOTBALL_FIXTURE_ID + 
									 "&" + ApiUtil.FOOTBALL_API_MODE + "&" + ApiUtil.FOOTBALL_API_JSON + "&_lcl=en-gb";
							 return objectMapper.writeValueAsString(ApiFunctions.getMatchInsights2fromAPI(stats_url, access_token)).toString();
						 case"FOOTBALL_PASS_MATRIX":
							 stats_url = ApiUtil.FOOTBALL_API_PATH + "passmatrix" + ApiUtil.FOOTBALL_TOKEN + "/?"+ ApiUtil.FOOTBALL_API_JSON +"&"+
									 ApiUtil.FOOTBALL_API_MODE +"&fx="+ApiUtil.FOOTBALL_FIXTURE_ID ;
							 return objectMapper.writeValueAsString(ApiFunctions.getPassMatrixfromAPI(stats_url, access_token)).toString();
						 case"FOOTBALL_MATCH_MOMENTUM":
							 stats_url = ApiUtil.FOOTBALL_API_PATH + "predictions/momentum" + ApiUtil.FOOTBALL_TOKEN + "/68yjh2787ow2da11tsd4u3k0k?" + 
									   ApiUtil.FOOTBALL_API_MODE +"&" + ApiUtil.FOOTBALL_API_JSON;
							 return objectMapper.writeValueAsString(ApiFunctions.getMatchMomentumfromAPI(stats_url, access_token)).toString();
						 case "FOOTBALL_GOALS_EXPECTED":
							 stats_url = ApiUtil.FOOTBALL_API_PATH + "matchexpectedgoals" + ApiUtil.FOOTBALL_TOKEN + "?" + ApiUtil.FOOTBALL_API_MODE+ "&" +
									 ApiUtil.FOOTBALL_API_JSON +"&fx="+ ApiUtil.FOOTBALL_FIXTURE_ID ;
							 
							 return objectMapper.writeValueAsString(ApiFunctions.getExpectedGoals(stats_url, access_token)).toString();	 
						 case"FOOTBALL_MATCH_POSSESSION_VALUES":
							 stats_url = ApiUtil.FOOTBALL_API_PATH + "matchpossessionvalues" + ApiUtil.FOOTBALL_TOKEN + "/7sasdn9v78std9dm86ajvnuok?" + 
									   ApiUtil.FOOTBALL_API_JSON +"&" + ApiUtil.FOOTBALL_API_MODE;
							 return objectMapper.writeValueAsString(ApiFunctions.getMatchPossessionValuesfromAPI(stats_url, access_token)).toString();
						 case "FOOTBALL_MATCH_PLAYER_RATINGS":
							 stats_url = ApiUtil.FOOTBALL_API_PATH + "matchplayerratings" + ApiUtil.FOOTBALL_TOKEN + "?fx=7s7gy9k869cs4i6ghhfgyfdw4&" + 
									   ApiUtil.FOOTBALL_API_JSON +"&" + ApiUtil.FOOTBALL_API_MODE;
							 return objectMapper.writeValueAsString(ApiFunctions.getMatchPlayerRatingsfromAPI(stats_url, access_token)).toString();
						 case "FOOTBALL_MATCH_POSSESSION":
							 return objectMapper.writeValueAsString(ApiFunctions.getPossessionfromAPI(stats_url, access_token)).toString();	 
	
						 case "LIVE_DATA":
							 stats_url =  ApiUtil.FOOTBALL_API_PATH + "matchstats" + ApiUtil.FOOTBALL_TOKEN + "/?" + ApiUtil.FOOTBALL_API_MODE + "&" + 
										ApiUtil.FOOTBALL_API_JSON + "&detailed=yes&fx=" + ApiUtil.FOOTBALL_FIXTURE_ID;
								return objectMapper.writeValueAsString(ApiFunctions.getFootballLiveDatafromAPI(stats_url, access_token)).toString();
						default:
							 stats_url =  ApiUtil.FOOTBALL_API_PATH + "matchstats" + ApiUtil.FOOTBALL_TOKEN + "/?" + ApiUtil.FOOTBALL_API_MODE + "&" + 
										ApiUtil.FOOTBALL_API_JSON + "&detailed=yes&fx=" + ApiUtil.FOOTBALL_FIXTURE_ID;
							return objectMapper.writeValueAsString(ApiFunctions.getFootballLiveDatafromAPI(stats_url, access_token)).toString();
						 }
					 }
					return objectMapper.writeValueAsString(null).toString();	
					
				case ApiUtil.KABADDI_KADAMBA:
					switch(whatToProcess.toUpperCase()) {
					 case "KABADDI_PRE_MATCH_DATA":
						 api_pre_match_team_stats = ApiFunctions.getPreMatchDatafromXML(source_path,"pre-match_2m.xml");
						 new ObjectMapper().writeValue(new File(destination_path + "pre-match_2m.json"), api_pre_match_team_stats);
						 return objectMapper.writeValueAsString(session_match).toString();
					 case "KABADDI_STATS": case "READ-APIMATCH-AND-POPULATE":
						 api_in_match_team_stats = ApiFunctions.getTopStatsDatafromXML(source_path,match_name);
						 
						 for(int i=0;i<=api_in_match_team_stats.size()-1;i++) {
							 session_match.setHomeTeamScore(api_in_match_team_stats.get(i).
									 getTeamPlayerStats().get(0).getPoints().get(0).getTotalPoints());
							 session_match.setAwayTeamScore(api_in_match_team_stats.get(i).
									 getTeamPlayerStats().get(1).getPoints().get(0).getTotalPoints());
							 for(Team team : apiService.getTeams()) {
								 if(team.getTeamApiId() == api_in_match_team_stats.get(i).getTeamPlayerStats().get(0).getTeamId()) {
									 session_match.setHomeTeam(apiService.getTeam(ApiUtil.TEAM, String.valueOf(team.getTeamId())));
								 }else if(team.getTeamApiId() == api_in_match_team_stats.get(i).getTeamPlayerStats().get(1).getTeamId()) {
									 session_match.setAwayTeam(apiService.getTeam(ApiUtil.TEAM, String.valueOf(team.getTeamId())));
								 }
							 }					            
							 session_match.setHomeTeamStats(api_in_match_team_stats.get(i).getTeamPlayerStats().get(0));
							 session_match.setAwayTeamStats(api_in_match_team_stats.get(i).getTeamPlayerStats().get(1));
						 	}
				            session_match.setPhase_of_play(ApiFunctions.getPhaseOfPlayDataFromXML(source_path + match_name));
							 session_match.setPlay_by_play( ApiFunctions.getPlayByPlays(source_path + match_name));
						 new ObjectMapper().writeValue(new File(destination_path + match_name.replace(".xml", ".json")), session_match);
						 
						 return objectMapper.writeValueAsString(session_match).toString();
					 }
					return objectMapper.writeValueAsString(kabaddi_match).toString();
				
				case ApiUtil.KABADDI:
					switch(whatToProcess.toUpperCase()) {
					 case "KABADDI_PRE_MATCH_DATA":
						 api_pre_match_team_stats = ApiFunctions.getPreMatchDatafromXML(source_path,"pre-match_2m.xml");
						 new ObjectMapper().writeValue(new File(destination_path + "pre-match_2m.json"), api_pre_match_team_stats);
						 return objectMapper.writeValueAsString(session_match).toString();
					 case "KABADDI_STATS": case "READ-APIMATCH-AND-POPULATE":
						 try {
							 api_in_match_team_stats = ApiFunctions.getTopStatsDatafromXML(source_path,match_name);
							 
							 for(int i=0;i<=api_in_match_team_stats.size()-1;i++) {
								 session_match.setHomeTeamScore(api_in_match_team_stats.get(i).
										 getTeamPlayerStats().get(0).getPoints().get(0).getTotalPoints());
								 session_match.setAwayTeamScore(api_in_match_team_stats.get(i).
										 getTeamPlayerStats().get(1).getPoints().get(0).getTotalPoints());
								 
								 for(Team team : apiService.getTeams()) {
									 if(team.getTeamApiId() == api_in_match_team_stats.get(i).getTeamPlayerStats().get(0).getTeamId()) {
										 session_match.setHomeTeam(apiService.getTeam(ApiUtil.TEAM, String.valueOf(team.getTeamId())));
									 }else if(team.getTeamApiId() == api_in_match_team_stats.get(i).getTeamPlayerStats().get(1).getTeamId()) {
										 session_match.setAwayTeam(apiService.getTeam(ApiUtil.TEAM, String.valueOf(team.getTeamId())));
									 }
								 }
								 
								 session_match.setHomeTeamStats(api_in_match_team_stats.get(i).getTeamPlayerStats().get(0));
								 session_match.setAwayTeamStats(api_in_match_team_stats.get(i).getTeamPlayerStats().get(1));
								 
							 }
							 session_match.setPhase_of_play(ApiFunctions.getPhaseOfPlayDataFromXML(source_path + match_name));
							 session_match.setPlay_by_play( ApiFunctions.getPlayByPlays(source_path + match_name));
							 
							 TimeUnit.MILLISECONDS.sleep(500);
							 new ObjectMapper().writeValue(new File(destination_path + match_name.replace(".xml", ".json")), session_match);
						 }catch(Exception e) {
							 e.printStackTrace();
						 }
						  
						 return objectMapper.writeValueAsString(session_match).toString();
					 }
					return objectMapper.writeValueAsString(kabaddi_match).toString();
				case ApiUtil.KABADDI_GIPKL:
					Files.list(Paths.get(source_path.trim())).filter(Files::isRegularFile)
				     .forEach(src -> {
				         try {
				             Path dest = Paths.get(destination_path.trim()).resolve(src.getFileName());
				             Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
				         } catch (Exception e) {
				             e.printStackTrace();
				         }
				     });

					return objectMapper.writeValueAsString(kabaddi_match).toString();	
				}
			}
		}
		return objectMapper.writeValueAsString(null).toString();
	}
}