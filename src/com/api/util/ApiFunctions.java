package com.api.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.api.model.auction.DraftPlayersResponse;
import com.api.model.auction.PlayerMasterResponse;
import com.api.model.basketball.INCP_PreMatch;
import com.api.model.basketball.INCP_SportEvent;
import com.api.model.boxing.Boxing;
import com.api.model.football.CurrentMatchLineup;
import com.api.model.football.Fixtures_and_Results;
import com.api.model.football.LiveMatch;
import com.api.model.football.MatchPreview;
import com.api.model.football.PassMatrix;
import com.api.model.football.PenaltyPreview;
import com.api.model.football.PlayerCareer;
import com.api.model.football.PossesionEvent;
import com.api.model.football.Possession;
import com.api.model.football.SeasonalPlayerStats;
import com.api.model.football.SeasonalStats;
import com.api.model.football.SeasonalTeams;
import com.api.model.football.Squad;
import com.api.model.football.Stat;
import com.api.model.football.TeamPlayerRanking;
import com.api.model.football.TeamsStanding;
import com.api.model.football.TopPerformers;
import com.api.model.football.TournamentSchedule;
import com.api.model.football.TournamentSimulation;
import com.api.model.football.rankings;
import com.api.model.football.teamData;
import com.api.model.golf.GolfCourseResponse;
import com.api.model.golf.GolfDrawsResponse;
import com.api.model.golf.GolfEntryListResponse;
import com.api.model.golf.GolfScoresResponse;
import com.api.model.golf.GolfTourResponse;
import com.api.model.ispl.mvp_leaderBoard;
import com.api.model.ispl.player_Info;
import com.api.model.kadamba.Api_In_match;
import com.api.model.kadamba.Api_pre_match;
import com.api.model.kadamba.Do_Or_Die;
import com.api.model.kadamba.Football;
import com.api.model.kadamba.Football_PointsTable;
import com.api.model.kadamba.Phase;
import com.api.model.kadamba.Phase_of_play;
import com.api.model.kadamba.PlayByRaids;
import com.api.model.kadamba.PlayByTeams;
import com.api.model.kadamba.PlayerStats;
import com.api.model.kadamba.Points;
import com.api.model.kadamba.PointsNminutes;
import com.api.model.kadamba.RaidPoints;
import com.api.model.kadamba.Raids;
import com.api.model.kadamba.TacklePoints;
import com.api.model.kadamba.Tackles;
import com.api.model.kadamba.TeamPlayerStats;
import com.api.model.kadamba.play_by_play;
import com.api.model.kadamba.points_last_n_minutes;
import com.api.model.khelo_india.KheloIndia;
import com.api.model.stupa.Matches;
import com.api.model.stupa.Team;
import com.api.model.stupa.Tie;
import com.api.model.stupa.User;
import com.api.model.tennis.Api_tennis;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.file.Files;
import java.nio.file.Path;

public class ApiFunctions {
	
	public static PassMatrix PassMatrix;
	public static Fixtures_and_Results Fixtures_and_Results;
	public static rankings rankings;
	public static TournamentSchedule TournamentSchedule;
	public static LiveMatch LiveMatch;
	public static Possession Possession;
	public static TournamentSimulation TournamentSimulation;
	public static SeasonalStats SeasonalStats;
	public static PlayerCareer PlayerCareer;
	public static Squad Squad;
	public static SeasonalTeams SeasonalTeams;
	public static TopPerformers TopPerformers;
	public static TeamsStanding TeamsStanding;
	public static CurrentMatchLineup CurrentMatchLineup;
	public static PossesionEvent PossesionEvent;
	public static PenaltyPreview PenaltyPreview;
	public static MatchPreview matchPreview;
	
	public static mvp_leaderBoard readIsplMvpLeaderBoardUrl(String urlString) throws IOException {

	    HttpURLConnection conn = null;
	    try {
	        URL url = new URL(urlString);
	        conn = (HttpURLConnection) url.openConnection();

	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setConnectTimeout(10_000);
	        conn.setReadTimeout(10_000);

	        int responseCode = conn.getResponseCode();

	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            ObjectMapper mapper = new ObjectMapper();
	            return mapper.readValue(conn.getInputStream(), mvp_leaderBoard.class);
	        } else {
	        	return null;
	        }
	    } finally {
	        if (conn != null) {
	            conn.disconnect();
	        }
	    }
	}
	public static GolfTourResponse readGolfTour(String urlString) throws IOException {

	    HttpURLConnection conn = null;
	    try {
	        URL url = new URL(urlString);
	        conn = (HttpURLConnection) url.openConnection();

	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setConnectTimeout(10_000);
	        conn.setReadTimeout(10_000);

	        int responseCode = conn.getResponseCode();

	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            ObjectMapper mapper = new ObjectMapper();
	            return mapper.readValue(conn.getInputStream(), GolfTourResponse.class);
	        } else {
	        	return null;
	        }
	    } finally {
	        if (conn != null) {
	            conn.disconnect();
	        }
	    }
	}
	public static GolfCourseResponse readGolfCourse(String urlString) throws IOException {

	    HttpURLConnection conn = null;
	    try {
	        URL url = new URL(urlString);
	        conn = (HttpURLConnection) url.openConnection();

	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setConnectTimeout(10_000);
	        conn.setReadTimeout(10_000);

	        int responseCode = conn.getResponseCode();

	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            ObjectMapper mapperr = new ObjectMapper();
	            return mapperr.readValue(conn.getInputStream(), GolfCourseResponse.class);
	        } else {
	        	return null;
	        }
	    } finally {
	        if (conn != null) {
	            conn.disconnect();
	        }
	    }
	}
	public static GolfEntryListResponse readGolfEntry(String urlString) throws IOException {

	    HttpURLConnection conn = null;
	    try {
	        URL url = new URL(urlString);
	        conn = (HttpURLConnection) url.openConnection();

	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setConnectTimeout(10_000);
	        conn.setReadTimeout(10_000);

	        int responseCode = conn.getResponseCode();

	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            ObjectMapper mapperr = new ObjectMapper();
	            return mapperr.readValue(conn.getInputStream(), GolfEntryListResponse.class);
	        } else {
	        	return null;
	        }
	    } finally {
	        if (conn != null) {
	            conn.disconnect();
	        }
	    }
	}
	public static DraftPlayersResponse readDraftedPlayer(String urlString) throws IOException {
	    DraftPlayersResponse result = null;
	    try {
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(urlString))
	                .GET()
	                .build();
	        java.net.http.HttpResponse<String> response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
	        if (response.statusCode() != 200) {
	            throw new IOException("HTTP " + response.statusCode());
	        }
	        Files.writeString(Path.of("C:\\Sports\\Auction\\drafted_players_summary.json"), response.body());

	        ObjectMapper mapper = new ObjectMapper();
	        result = mapper.readValue(response.body(), DraftPlayersResponse.class);
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	        e.printStackTrace();
	    }
	    return result;
	}
	public static PlayerMasterResponse readMasterPlayer(String urlString) throws IOException {
		PlayerMasterResponse results = null;
	    try {
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(urlString))
	                .GET()
	                .build();
	        java.net.http.HttpResponse<String> response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
	        if (response.statusCode() != 200) {
	            throw new IOException("HTTP " + response.statusCode());
	        }
	        Files.writeString(Path.of("C:\\Sports\\Auction\\draft_playermaster.json"), response.body());

	        ObjectMapper mapper = new ObjectMapper();
	        results = mapper.readValue(response.body(), PlayerMasterResponse.class);
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	        e.printStackTrace();
	    }
	    return results;
	}
	public static GolfScoresResponse readGolfScore(String urlString) throws IOException {

	    HttpURLConnection conn = null;
	    try {
	        URL url = new URL(urlString);
	        conn = (HttpURLConnection) url.openConnection();

	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setConnectTimeout(10_000);
	        conn.setReadTimeout(10_000);

	        int responseCode = conn.getResponseCode();

	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            ObjectMapper mapper = new ObjectMapper();
	            return mapper.readValue(conn.getInputStream(), GolfScoresResponse.class);
	        } else {
	        	return null;
	        }
	    } finally {
	        if (conn != null) {
	            conn.disconnect();
	        }
	    }
	}
	public static GolfDrawsResponse readDraws(String urlString) throws IOException {

	    HttpURLConnection conn = null;

	    try {

	        URL url = new URL(urlString);
	        conn = (HttpURLConnection) url.openConnection();

	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setConnectTimeout(10000);
	        conn.setReadTimeout(10000);

	        int responseCode = conn.getResponseCode();

	        System.out.println("Response Code: " + responseCode);

	        if (responseCode == HttpURLConnection.HTTP_OK) {

	            ObjectMapper mapper = new ObjectMapper();

	            GolfDrawsResponse response =
	                    mapper.readValue(conn.getInputStream(), GolfDrawsResponse.class);

	            return response;

	        } else {

	            System.out.println("API FAILED");
	            return null;
	        }

	    } finally {

	        if (conn != null) {
	            conn.disconnect();
	        }
	    }
	}
	
	public static player_Info readIsplPlayerInfoUrl(String urlString) throws IOException {

	    HttpURLConnection conn = null;
	    try {
	        URL url = new URL(urlString);
	        conn = (HttpURLConnection) url.openConnection();

	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setConnectTimeout(10_000);
	        conn.setReadTimeout(10_000);

	        int responseCode = conn.getResponseCode();

	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            ObjectMapper mapper = new ObjectMapper();
	            return mapper.readValue(conn.getInputStream(), player_Info.class);
	        } else {
	        	return null;
	        }
	    } finally {
	        if (conn != null) {
	            conn.disconnect();
	        }
	    }
	}
	
	public static Boxing readFromUrl(String urlString) throws IOException 
    {
        HttpURLConnection conn = null;
        URL url = new URL(urlString);
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setConnectTimeout(10_000);
        conn.setReadTimeout(10_000);
        try {
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return new ObjectMapper().readValue(conn.getInputStream(), Boxing.class);
            }
        }
        finally {
            if (conn != null) conn.disconnect();
        }
    	return null;
    }
	
	public static org.json.JSONObject getJsonObjectFromUrl(URL url) throws IOException {
	    String json = IOUtils.toString(url, StandardCharsets.UTF_8);
	    return new org.json.JSONObject(json);
	}
	public static void cricketJsonToFile(String urlStr, String outputPath) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (InputStream in = conn.getInputStream()) {
                    new ObjectMapper()
                        .writerWithDefaultPrettyPrinter()
                        .writeValue(new File(outputPath), new ObjectMapper().readTree(in));
                }
                System.out.println("Saved JSON to: " + outputPath);
            } else {
                System.err.println("Error: HTTP " + conn.getResponseCode());
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public static String golfscoreJsonToFile(String urlStr, String outputPath) {

	    HttpURLConnection conn = null;

	    try {

	        conn = (HttpURLConnection) new URL(urlStr).openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setConnectTimeout(10000);
	        conn.setReadTimeout(10000);

	        int responseCode = conn.getResponseCode();

	        if (responseCode == HttpURLConnection.HTTP_OK) {

	            try (InputStream in = conn.getInputStream()) {

	                ObjectMapper mapper = new ObjectMapper();
	                Object jsonData = mapper.readTree(in);

	                mapper.writerWithDefaultPrettyPrinter()
	                      .writeValue(new File(outputPath), jsonData);
	            }

	            return "connected";

	        } else {

	            return "HTTP Error : " + responseCode;
	        }

	    } catch (Exception e) {

	        return "Exception : " + e.getMessage();

	    } finally {

	        if (conn != null) {
	            conn.disconnect();
	        }
	    }
	}
	public static void getUTT() throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
		//Tie
				URL url = new URL("http://20.235.240.3:8008/get_ties?tenant=utt&tie_id=24");
		        URLConnection connection = url.openConnection();
		        connection.connect();
		        
	            Tie ties = new ObjectMapper().readValue(new URL("http://20.235.240.3:8008/get_ties?tenant=utt&tie_id=24"), Tie[].class)[0];
		        System.out.println(ties.toString());
		        
		      //Matches
		        URL matches_url = new URL("http://20.235.240.3:8008/get_matches?tenant=utt&type=all");
		        URLConnection matches_connection = matches_url.openConnection();
		        matches_connection.connect();
		        
		        Matches utt_matches_Array = new ObjectMapper().readValue(matches_url, Matches[].class)[0];
		        System.out.println(utt_matches_Array.toString());
		      //Player
		        URL players_url = new URL("http://20.235.240.3:8008/get_players?tenant=utt&gender=both");
		        URLConnection players_connection = players_url.openConnection();
		        players_connection.connect();
		        
		        User utt_players_Array = new ObjectMapper().readValue(players_url, User[].class)[0];
		        System.out.println(utt_players_Array.toString());
		      //Squad
		        URL squads_url = new URL("http://20.235.240.3:8008/get_squads?tenant=utt");
		        URLConnection squads_connection = squads_url.openConnection();
		        squads_connection.connect();
		        
		        Team utt_squads_Array = new ObjectMapper().readValue(squads_url, Team[].class)[0];
		        System.out.println(utt_squads_Array.toString());
		        
	}
	public static void getUTTData(String destination,String match_name) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
		//Tie
		Tie[] utt_tie_Array = new ObjectMapper().readValue(new URL("http://20.235.240.3:8008/get_ties?tenant=utt&tie_id=24"), Tie[].class);
		
		Matches[] utt_Matches_Array = new ObjectMapper().readValue(new URL("http://20.235.240.3:8008/get_matches?tenant=utt&type=all"), Matches[].class);
		
		for(Tie tie : utt_tie_Array) {
			for(Matches full_match : utt_Matches_Array) {
				for(Matches tie_match : tie.getMatches()) {
					if(tie_match.getMatch_id() == full_match.getMatch_id()) {
						new ObjectMapper().writeValue(new File("C:/Sports/TableTennis/UTT/Matches/" + "TIE_" + tie.getTie_number() + 
								"_MATCH_" + tie_match.getMatch_number() + ".json"), full_match);
					}
				}
			}
		}
		
		//Squad
		//Team[] utt_squads_Array = new ObjectMapper().readValue(new URL("http://20.235.240.3:8008/get_squads?tenant=utt"), Team[].class);
//		for(Team team : utt_squads_Array) {
//			System.out.println(team.toString());
//		}
		
	}
	
	public static String hashString(String input) {
        try {
            // Create a MessageDigest instance for SHA-512
            MessageDigest digest = MessageDigest.getInstance("SHA-512");

            // Convert the input string to a byte array
            byte[] hash = digest.digest(input.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                // Convert each byte to a 2-digit hexadecimal representation
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString(); // Return the SHA-512 hash as a hexadecimal string
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error creating SHA-512 hash", e);
        }
    }
	
	public static String getAccessToken() throws IOException {
        
		String token_access = "";
		String tokenEndpointUrl = "https://oauth.performgroup.com/oauth/token/26kfa29kdpyu170bzsv5cbuw0?_fmt=json&_rt=b";
	    String OutletKey = "26kfa29kdpyu170bzsv5cbuw0";//"{{OutletApiKey}}";
	    String SecretKey = ApiUtil.FOOTBALL_Secret_key;//"{{SecretKey}}";
	    
        String currentMillis = Long.toString(System.currentTimeMillis());
        String sigString = OutletKey + currentMillis + SecretKey;
        
        String hashedOutput = null;
		try {
			hashedOutput = hashString(sigString);
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
        
        HttpResponse<String> userResp;
		try {
			userResp = Unirest.post(tokenEndpointUrl)
					.header("Content-Type", "application/x-www-form-urlencoded")
					.header("Authorization", "Basic " + hashedOutput)
					.header("Timestamp", currentMillis)
					.field("grant_type", "client_credentials")
					.field("scope", "b2b-feeds-auth")
					.asString();
			
			String json_data = userResp.getBody().toString();
			
			JSONObject jsonObject = new JSONObject(json_data);

	        // Get the "access_token" value
			System.out.println(jsonObject.toString());
			if (!jsonObject.has("access_token")) {
			    System.out.println("Token Request Failed: " + jsonObject.toString());
			    return null;
			}			
	        String accessToken = jsonObject.getString("access_token");

	        token_access = accessToken;
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
        return token_access;
    }

	public static List<KheloIndia> getMedalTallyDatafromAPI(String sport_type) 
			throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
		List<KheloIndia> khelo_india = new ArrayList<KheloIndia>();
		JSONObject j_obj = null, json_array_element = null;
		String url_path = "https://tsr.kheloindia.gov.in/api/medaltally?token=1|LzJr085oY2H4oCim6b5c0JfAwTbMDpnZmdCQpWzh";
		
		switch (sport_type) {
		case "archery": case "athletics": case "badminton": case "basketball": case "boxing": case "fencing":
		case "football": case "hockey": case "judo": case "kabaddi": case "mallakhamb": case "rowing":
		case "rugby": case "shooting": case "swimming": case "table_tennis": case "tennis": case "volleyball":
		case "weightlifting": case "wrestling": case "yogasana": 
			url_path = url_path + "&sport=" + sport_type;
			break;
		}

		j_obj = getJsonObjectFromUrl(new URL(url_path));
		
		if(j_obj == null) {
			return null;
		} else {
			org.json.JSONArray jArrayResults = j_obj.getJSONArray("Ki_medaltally");
			if(jArrayResults.length() > 0) {
		        for (int i = 0; i < jArrayResults.length(); i++) {  
		            json_array_element = jArrayResults.getJSONObject(i); 
		            khelo_india.add(new KheloIndia(json_array_element.get("state_id").toString(), 
		            	json_array_element.get("state_name").toString(),Integer.valueOf(json_array_element.get("gold").toString()),
		            	Integer.valueOf(json_array_element.get("silver").toString()), 
		            	Integer.valueOf(json_array_element.get("bronze").toString()), 
		            	Integer.valueOf(json_array_element.get("total").toString()), 
		            	Integer.valueOf(json_array_element.get("rank").toString())));
		        }      
			} else {
				return null;
			}
	    }
		return khelo_india;
	}

	public static String WriteDataOfTeamsJsontofile(String filename) {

	    ObjectMapper mapper = new ObjectMapper();

	    ArrayNode team = mapper.createArrayNode();

	    ObjectNode teamObj = mapper.createObjectNode();

	    teamObj.put("nation", "IND");
	    teamObj.put("shortname", "Adamas University");
	    teamObj.put("region", "");
	    teamObj.put("longcode", "");
	    teamObj.put("id", "1899");
	    teamObj.put("name", "Adamas University");
	    teamObj.put("code", "");

	    team.add(teamObj);

	    System.out.println(team.get(0));

	    return "";
	}	
	
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public static String WriteDataOfTeamsJsontofile(String filename) {
//		JSONArray team = new JSONArray();
//		Map m = new LinkedHashMap(7);
//		m.put("nation", "IND");
//        m.put("shortname", "Adamas University");
//        m.put("region", "");
//        m.put("longcode", "");
//        m.put("id", "1899");
//        m.put("name", "Adamas University");
//        m.put("code", "");
//        
//        team.add(m);
//        System.out.println(team.get(0));
//        
//		return "";
//	}
	
	public static String getOnlineCurrentDate() throws IOException
	{
		HttpURLConnection httpCon = (HttpURLConnection) new URL("https://mail.google.com/").openConnection();
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date(httpCon.getDate()));
	}
	
	public static Phase_of_play getPhaseOfPlayDataFromXML(String filePath) throws Exception {
	    Phase_of_play phasePlay = new Phase_of_play();
	    List<Phase> phases = new ArrayList<>();

	    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(filePath));
	    doc.getDocumentElement().normalize();

	    NodeList phaseOfPlayList = doc.getElementsByTagName("phase");
	    for (int i = 0; i < phaseOfPlayList.getLength(); i++) {
	        Element phaseElement = (Element) phaseOfPlayList.item(i);
	        Phase phase = new Phase();
	        phase.setPhase_name(phaseElement.getAttribute("phase-name"));

	        NodeList teamList = phaseElement.getElementsByTagName("team");
	        for (int j = 0; j < teamList.getLength(); j++) {
	            Element teamElement = (Element) teamList.item(j);
	            PlayByTeams team = new PlayByTeams();
	            team.setTeam_name(teamElement.getAttribute("team-name"));
	            team.setTeam_id(Integer.parseInt(teamElement.getAttribute("team-id")));

	            Element pointsElement = (Element) teamElement.getElementsByTagName("points").item(0);
	            Points points = new Points();
	            points.setTotalPoints(Integer.parseInt(pointsElement.getAttribute("total-points")));

	            Element tacklePointsElement = (Element) pointsElement.getElementsByTagName("tackle-points").item(0);
	            TacklePoints tacklePoints = new TacklePoints();
	            tacklePoints.setTotalTacklePoints(Integer.parseInt(tacklePointsElement.getAttribute("total-tackle-points")));
	            tacklePoints.setCapturePoints(Integer.parseInt(tacklePointsElement.getElementsByTagName("capture-points").item(0).getFirstChild().getNodeValue().trim()));
	            tacklePoints.setTackleBounsPoints(Integer.parseInt(tacklePointsElement.getElementsByTagName("tackle-bonus-points").item(0).getFirstChild().getNodeValue().trim()));
	            points.getTackle_points().add(tacklePoints);

	            Element raidPointsElement = (Element) pointsElement.getElementsByTagName("raid-points").item(0);
	            RaidPoints raidPoints = new RaidPoints();
	            raidPoints.setTotalRaidPoints(Integer.parseInt(raidPointsElement.getAttribute("total-raid-points")));
	            raidPoints.setTouchPoints(Integer.parseInt(raidPointsElement.getElementsByTagName("touch-points").item(0).getFirstChild().getNodeValue().trim()));
	            raidPoints.setRaidBounsPoints(Integer.parseInt(raidPointsElement.getElementsByTagName("raid-bonus-points").item(0).getFirstChild().getNodeValue().trim()));
	            points.getRaid_points().add(raidPoints);

	            points.setAll_out_points(Integer.parseInt(pointsElement.getElementsByTagName("all-out-points").item(0).getFirstChild().getNodeValue().trim()));
	            points.setExtra_points(Integer.parseInt(pointsElement.getElementsByTagName("extra-points").item(0).getFirstChild().getNodeValue().trim()));

	            team.setPoints(points);

	            Element pointsLastNMinutesElement = (Element) teamElement.getElementsByTagName("points-last-n-minutes").item(0);
	            points_last_n_minutes pointsLastNMinutes = new points_last_n_minutes();
	            pointsLastNMinutes.setFive(Integer.parseInt(pointsLastNMinutesElement.getElementsByTagName("five").item(0).getFirstChild().getNodeValue().trim()));
	            pointsLastNMinutes.setTen(Integer.parseInt(pointsLastNMinutesElement.getElementsByTagName("ten").item(0).getFirstChild().getNodeValue().trim()));
	            team.setPoints_last_n_minutes(pointsLastNMinutes);

	            Element raidsElement = (Element) teamElement.getElementsByTagName("raids").item(0);
	            Raids raids = new Raids();
	            raids.setTotalRaids(Integer.parseInt(raidsElement.getAttribute("total-raids")));
	            raids.setSuperRaids(Integer.parseInt(raidsElement.getAttribute("super-raids")));
	            raids.setSuccessfulRaids(Integer.parseInt(raidsElement.getElementsByTagName("successful-raids").item(0).getFirstChild().getNodeValue().trim()));
	            raids.setUnsuccessfulRaids(Integer.parseInt(raidsElement.getElementsByTagName("unsuccessful-raids").item(0).getFirstChild().getNodeValue().trim()));
	            raids.setEmptyRaids(Integer.parseInt(raidsElement.getElementsByTagName("empty-raids").item(0).getFirstChild().getNodeValue().trim()));
	            team.setRaids(raids);

	            Element tacklesElement = (Element) teamElement.getElementsByTagName("tackles").item(0);
	            Tackles tackles = new Tackles();
	            tackles.setTotalTackles(Integer.parseInt(tacklesElement.getAttribute("total-tackles")));
	            tackles.setSuccessfulTackles(Integer.parseInt(tacklesElement.getElementsByTagName("successful-tackles").item(0).getFirstChild().getNodeValue().trim()));
	            tackles.setUnsuccessfulTackles(Integer.parseInt(tacklesElement.getElementsByTagName("unsuccessful-tackles").item(0).getFirstChild().getNodeValue().trim()));
	            team.setTackles(tackles);
	            
	            Element DoDie = (Element) teamElement.getElementsByTagName("do-or-die").item(0);
	            Do_Or_Die Do_Or_Die = new Do_Or_Die();
	            Do_Or_Die.setTotalRaids(Integer.parseInt(DoDie.getAttribute("total-raids")));
	            Do_Or_Die.setSuccessfullRaids(Integer.parseInt(DoDie.getElementsByTagName("successfull-raids").item(0).getFirstChild().getNodeValue().trim()));
	            Do_Or_Die.setFailedRaids(Integer.parseInt(DoDie.getElementsByTagName("failed-raids").item(0).getFirstChild().getNodeValue().trim()));
	            Do_Or_Die.setSuperRaids(Integer.parseInt(DoDie.getElementsByTagName("super-raids").item(0).getFirstChild().getNodeValue().trim()));
	            Do_Or_Die.setRaidPoints(Integer.parseInt(DoDie.getElementsByTagName("raid-points").item(0).getFirstChild().getNodeValue().trim()));
	            Do_Or_Die.setTouchPoints(Integer.parseInt(DoDie.getElementsByTagName("touch-points").item(0).getFirstChild().getNodeValue().trim()));
	            Do_Or_Die.setBonusPoints(Integer.parseInt(DoDie.getElementsByTagName("bonus-points").item(0).getFirstChild().getNodeValue().trim()));

	            team.setDo_or_die(Do_Or_Die);
	            
	            phase.getTeam().add(team);
	        }

	        phases.add(phase);
	    }

	    phasePlay.setPhase(phases);
	    return phasePlay;
	}

	public static play_by_play getPlayByPlays(String fileName) throws Exception {
		play_by_play play  = new play_by_play();
		List<PlayByRaids> playByPlaysList = new ArrayList<>();

    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(fileName));
    doc.getDocumentElement().normalize();

    NodeList playByPlayList = doc.getElementsByTagName("play-by-play");
    for (int i = 0; i < playByPlayList.getLength(); i++) {
        Node playByPlayNode = playByPlayList.item(i);
        if (playByPlayNode.getNodeType() == Node.ELEMENT_NODE) {
            Element playByPlayElement = (Element) playByPlayNode;

            NodeList raidList = playByPlayElement.getElementsByTagName("raid");
            for (int j = 0; j < raidList.getLength(); j++) {
                Element raidElement = (Element) raidList.item(j);
                PlayByRaids raid = new PlayByRaids();
                raid.setTeam(new ArrayList<>()); 

                raid.setRaid_number(Integer.parseInt(raidElement.getAttribute("raid-number")));
                raid.setRaiding_team_id(Integer.parseInt(raidElement.getAttribute("raiding-team-id")));
                raid.setRaiding_player_id(Integer.parseInt(raidElement.getAttribute("raiding-player-id")));
                raid.setRaid_outcome_id(Integer.parseInt(raidElement.getAttribute("raid-outcome-id")));
                raid.setRaid_half(Integer.parseInt(raidElement.getAttribute("raid-half")));

                NodeList teamList = raidElement.getElementsByTagName("team");
                for (int k = 0; k < teamList.getLength(); k++) {
                    Element teamElement = (Element) teamList.item(k);
                    PlayByTeams team = new PlayByTeams();

                    team.setTeam_id(Integer.parseInt(teamElement.getAttribute("team-id")));
                    team.setTotal_points(Integer.parseInt(teamElement.getAttribute("total-points")));

                    NodeList pointsList = teamElement.getElementsByTagName("points");
                    for (int l = 0; l < pointsList.getLength(); l++) {
                        Element pointsElement = (Element) pointsList.item(l);
                        Points points = new Points();

                        points.setTotalPoints(Integer.parseInt(pointsElement.getAttribute("total-points")));

                        Element raidPointsElement = (Element) pointsElement.getElementsByTagName("raid-points").item(0);
                        if (raidPointsElement != null) {
                            RaidPoints raidPoints = new RaidPoints();
                            raidPoints.setTotalRaidPoints(Integer.parseInt(raidPointsElement.getAttribute("total-raid-points")));

                            Element touchPointsElement = (Element) raidPointsElement.getElementsByTagName("touch-points").item(0);
                            if (touchPointsElement != null && touchPointsElement.getFirstChild() != null) {
                                raidPoints.setTouchPoints(Integer.parseInt(touchPointsElement.getFirstChild().getNodeValue().trim()));
                            }

                            Element raidBonusPointsElement = (Element) raidPointsElement.getElementsByTagName("raid-bonus-points").item(0);
                            if (raidBonusPointsElement != null && raidBonusPointsElement.getFirstChild() != null) {
                                raidPoints.setRaidBounsPoints(Integer.parseInt(raidBonusPointsElement.getFirstChild().getNodeValue().trim()));
                            }

                            points.getRaid_points().add(raidPoints);
                        }

                        Element tacklePointsElement = (Element) pointsElement.getElementsByTagName("tackle-points").item(0);
                        if (tacklePointsElement != null) {
                            TacklePoints tacklePoints = new TacklePoints();
                            tacklePoints.setTotalTacklePoints(Integer.parseInt(tacklePointsElement.getAttribute("total-tackle-points")));

                            Element capturePointsElement = (Element) tacklePointsElement.getElementsByTagName("capture-points").item(0);
                            if (capturePointsElement != null && capturePointsElement.getFirstChild() != null) {
                                tacklePoints.setCapturePoints(Integer.parseInt(capturePointsElement.getFirstChild().getNodeValue().trim()));
                            }

                            Element tackleBonusPointsElement = (Element) tacklePointsElement.getElementsByTagName("tackle-bonus-points").item(0);
                            if (tackleBonusPointsElement != null && tackleBonusPointsElement.getFirstChild() != null) {
                                tacklePoints.setTackleBounsPoints(Integer.parseInt(tackleBonusPointsElement.getFirstChild().getNodeValue().trim()));
                            }

                            points.getTackle_points().add(tacklePoints);
                        }

                        Element allOutPointsElement = (Element) pointsElement.getElementsByTagName("all-out-points").item(0);
                        if (allOutPointsElement != null && allOutPointsElement.getFirstChild() != null) {
                            points.setAll_out_points(Integer.parseInt(allOutPointsElement.getFirstChild().getNodeValue().trim()));
                        }

                        Element extraPointsElement = (Element) pointsElement.getElementsByTagName("extra-points").item(0);
                        if (extraPointsElement != null && extraPointsElement.getFirstChild() != null) {
                            points.setExtra_points(Integer.parseInt(extraPointsElement.getFirstChild().getNodeValue().trim()));
                        }

                        team.setPoints(points);
                    }

                    raid.getTeam().add(team);
                }

                playByPlaysList.add(raid);
            }
        }
    }
    play.setPlayByRaids(playByPlaysList);
    return play;
}

	public static List<Api_pre_match> getPreMatchDatafromXML(String file_path,String file_name) 
			throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError{
		
		List<Api_pre_match> api_pre_match = new ArrayList<Api_pre_match>();
		
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(file_path + file_name));
        doc.getDocumentElement().normalize();
        NodeList childNodes = doc.getDocumentElement().getChildNodes();
        for(int i = 0; i < childNodes.getLength(); i++) {
        	if(childNodes.item(i).getNodeType() == Node.ELEMENT_NODE && childNodes.item(i).getNodeName().equals("team-players-statistics")) {
        		
        		api_pre_match.add(new Api_pre_match(new ArrayList<TeamPlayerStats>()));
        		
        		for(int j=0;j<childNodes.item(i).getChildNodes().getLength();j++) {
        			if(childNodes.item(i).getChildNodes().item(j).getNodeType() == Node.ELEMENT_NODE 
            				&& childNodes.item(i).getChildNodes().item(j).getNodeName().equalsIgnoreCase("team")) {
        				
        				api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().add(new TeamPlayerStats(childNodes.item(i).getChildNodes().item(j).getAttributes().
	        					getNamedItem("team-name").getNodeValue(), Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getAttributes().getNamedItem("team-id")
	    	        			.getNodeValue()), 0, 0, 0, 0, new ArrayList<Points>(),new ArrayList<Raids>(),new ArrayList<Tackles>(),new ArrayList<Do_Or_Die>(),
	        					new ArrayList<PlayerStats>()));
        				
        				for(int k = 0; k < childNodes.item(i).getChildNodes().item(j).getChildNodes().getLength();k++) {
        					if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("matches")) {
        						
        						api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).
        							setMatches(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getFirstChild().getNodeValue()));
        						
        					}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("won")) {
        						
        						api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).
        							setWon(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getFirstChild().getNodeValue()));
        						
        					}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("lost")) {
        						
        						api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).
        							setLost(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getFirstChild().getNodeValue()));
        						
        					}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("tied")) {
        						
        						api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).
        							setTied(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getFirstChild().getNodeValue()));
        						
        					}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("points")) {
        						
        						api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).
        						getPoints().add(new Points(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getAttributes().
	        							getNamedItem("total-points").getNodeValue()), new ArrayList<TacklePoints>(), new ArrayList<RaidPoints>()));
        						
        						for(int l = 0; l < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();l++) {
        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("all-out-points")) {

        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
        									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1)
        									.getPoints().size()-1).setAll_out_points(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k)
        									.getChildNodes().item(l).getFirstChild().getNodeValue()));
        								
        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("extra-points")) {
        					
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
    									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1)
    									.getPoints().size()-1).setExtra_points(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k)
    									.getChildNodes().item(l).getFirstChild().getNodeValue()));
        								
        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("tackle-points")) {
        								
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
        									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
        									getTackle_points().add(new TacklePoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).
        									getAttributes().getNamedItem("total-tackle-points").getNodeValue())));
        								
        								for(int m = 0; m < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().getLength();m++) {
        									if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
        											childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().
        											equalsIgnoreCase("capture-points")) {
        									
        										api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
	        									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
	        									getTackle_points().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
	        									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
	        									getTackle_points().size()-1).setCapturePoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k)
	        									.getChildNodes().item(l).getChildNodes().item(m).getFirstChild().getNodeValue()));
        										
        									}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
        											childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().
        											equalsIgnoreCase("tackle-bonus-points")) {
        										
        										api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
	        									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
	        									getTackle_points().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
	        									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
	        									getTackle_points().size()-1).setTackleBounsPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k)
	        									.getChildNodes().item(l).getChildNodes().item(m).getFirstChild().getNodeValue()));
        									}
        								}
        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("raid-points")) {
        								
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
    									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
    									getRaid_points().add(new RaidPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).
    									getAttributes().getNamedItem("total-raid-points").getNodeValue())));
        								
	    								for(int m = 0; m < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().getLength();m++) {
	    									if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	    											childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().
	    											equalsIgnoreCase("touch-points")) {
	    										
	    										api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
	        									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
	        									getRaid_points().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
	        									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
	        									getRaid_points().size()-1).setTouchPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k)
	        									.getChildNodes().item(l).getChildNodes().item(m).getFirstChild().getNodeValue()));
	    										
	    									}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	    											childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().
	    											equalsIgnoreCase("raid-bonus-points")) {
	    										
	    										api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
	        									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
	        									getRaid_points().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
	        									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
	        									getRaid_points().size()-1).setRaidBounsPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k)
	        									.getChildNodes().item(l).getChildNodes().item(m).getFirstChild().getNodeValue()));
	    									}
	    								}	
        							}
        						}
        					}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("raids")) {
        						
        						api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getRaids().add(new Raids(
        						Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getAttributes().getNamedItem("total-raids").getNodeValue()),
        						Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getAttributes().getNamedItem("super-raids").getNodeValue())));
        						
        						for(int l = 0; l < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();l++) {
        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("successful-raids")) {
        								
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getRaids().
    									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getRaids().size()-1)
    									.setSuccessfulRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
        								
        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("unsuccessful-raids")) {
        								
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getRaids().
    									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getRaids().size()-1)
    									.setUnsuccessfulRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
        								
        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("empty-raids")) {
        								
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getRaids().
    									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getRaids().size()-1)
    									.setEmptyRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
        								
        								
        							}
        						}
        						
        					}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("tackles")) {
        						
        						api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getTackles().add(new Tackles(
        						Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getAttributes().getNamedItem("total-tackles").getNodeValue()),
        						Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getAttributes().getNamedItem("super-tackles").getNodeValue())));
        						
        						for(int l = 0; l < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();l++) {
        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("successful-tackles")) {
        								
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getTackles().
    									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getTackles().size()-1)
    									.setSuccessfulTackles(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
        								
        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("unsuccessful-tackles")) {
        								
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getTackles().
    									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getTackles().size()-1)
    									.setUnsuccessfulTackles(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
        								
        							}
        						}
        						
        					}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("do-or-die")) {
        						
        						api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().
        						add(new Do_Or_Die(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getAttributes().getNamedItem("total-raids")
        						.getNodeValue())));
        						
        						for(int l = 0; l < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();l++) {
        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("successfull-raids")) {
        								
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().
    									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().size()-1)
    									.setSuccessfullRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
        								
        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("failed-raids")) {
        								
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().
    									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().size()-1)
    									.setFailedRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
        								
        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("super-raids")) {
        								
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().
    									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().size()-1)
    									.setSuperRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
        								
        								
        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("raid-points")) {
        								
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().
    									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().size()-1)
    									.setRaidPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
        								
        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("touch-points")) {
        								
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().
    									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().size()-1)
    									.setTouchPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
        								
        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("bonus-points")) {
        								
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().
    									get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().size()-1)
    									.setBonusPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
        								
        							}
        						}
        					}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("players")) {
        						for(int l = 0; l < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();l++) {
        							//System.out.println(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName());
        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("player")){
        								
        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
    	        						add(new PlayerStats(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getAttributes().getNamedItem("player-name").getNodeValue(), 
    	        							Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getAttributes().getNamedItem("player-id").getNodeValue()),  
    	        							new ArrayList<Points>(),new ArrayList<Raids>(),new ArrayList<Tackles>(),new ArrayList<Do_Or_Die>()));
        								
        								for(int m = 0; m < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().getLength();m++) {
        									if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
    	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().equalsIgnoreCase("high_five")) {
        										
        										api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        										get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        										setHigh_five(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getFirstChild().getNodeValue()));
        										
        									}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
    	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().equalsIgnoreCase("super_ten")) {
        										
        										api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        										get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        										setSuper_ten(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getFirstChild().getNodeValue()));
        										
        									}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
    	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().equalsIgnoreCase("matches")) {
        										
        										api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        										get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        										setMatches(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getFirstChild().getNodeValue()));
        										
        									}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
    	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().equalsIgnoreCase("matches_raided")) {
        										
        										api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        										get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        										setMatches_raided(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getFirstChild().getNodeValue()));
        										
        									}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
    	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().equalsIgnoreCase("points")) {
        										
        										api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
    	        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
    	        								getPoints().add(new Points(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).
    	        								getAttributes().getNamedItem("total-points").getNodeValue()), new ArrayList<TacklePoints>(), new ArrayList<RaidPoints>()));
        										
        										for(int n = 0; n < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().getLength();n++) {
        											if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("raid-points")) {
        												
        												api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
            	        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
            	        								getPoints().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
            	        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
            	        								getPoints().size()-1).getRaid_points().add(new RaidPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).
            	        								getChildNodes().item(m).getChildNodes().item(n).getAttributes().getNamedItem("total-raid-points").getNodeValue())));
        												
        												for(int o = 0; o < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getChildNodes().getLength();o++) {
        													if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getChildNodes().item(o).
        														getNodeType() == Node.ELEMENT_NODE && childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).
        														getChildNodes().item(o).getNodeName().equalsIgnoreCase("touch-points")) {
        														
        														api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        														get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        														getPoints().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        														get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        														getPoints().size()-1).getRaid_points().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
                												get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
                												getPoints().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
                												get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
                												getPoints().size()-1).getRaid_points().size()-1).setTouchPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).
                												getChildNodes().item(n).getChildNodes().item(o).getAttributes().getNamedItem("total-touch-points").getNodeValue()));
        			    										
        			    									}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getChildNodes().item(o).
            														getNodeType() == Node.ELEMENT_NODE && childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).
            														getChildNodes().item(o).getNodeName().equalsIgnoreCase("raid-bonus-points")) {
        			    										
        			    										api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        														get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        														getPoints().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        														get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        														getPoints().size()-1).getRaid_points().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
                												get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
                												getPoints().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
                												get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
                												getPoints().size()-1).getRaid_points().size()-1).setRaidBounsPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).
        														getChildNodes().item(n).getChildNodes().item(o).getFirstChild().getNodeValue()));
        			    										
        			    									}
        												}
        												
        											}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("tackle-points")) {
        												
        												api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
            	        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
            	        								getPoints().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
            	        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
            	        								getPoints().size()-1).getTackle_points().add(new TacklePoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).
            	        								getChildNodes().item(m).getChildNodes().item(n).getAttributes().getNamedItem("total-tackle-points").getNodeValue())));
        												
        												for(int o = 0; o < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getChildNodes().getLength();o++) {
        													if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getChildNodes().item(o).
        														getNodeType() == Node.ELEMENT_NODE && childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).
        														getChildNodes().item(o).getNodeName().equalsIgnoreCase("capture-points")) {
        														
        														api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        														get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        														getPoints().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        														get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        														getPoints().size()-1).getTackle_points().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
                												get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
                												getPoints().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
                												get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
                												getPoints().size()-1).getTackle_points().size()-1).setCapturePoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).
                												getChildNodes().item(n).getChildNodes().item(o).getAttributes().getNamedItem("total-capture-points").getNodeValue()));
        			    										
        			    									}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getChildNodes().item(o).
            														getNodeType() == Node.ELEMENT_NODE && childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).
            														getChildNodes().item(o).getNodeName().equalsIgnoreCase("tackle-bonus-points")) {
        			    										
        			    										api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        														get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        														getPoints().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        														get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        														getPoints().size()-1).getTackle_points().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
                												get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
                												getPoints().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
                												get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
                												getPoints().size()-1).getTackle_points().size()-1).setTackleBounsPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).
        														getChildNodes().item(n).getChildNodes().item(o).getFirstChild().getNodeValue()));
        			    										
        			    									}
        												}
        											}
        										}
        										
        									}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
    	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().equalsIgnoreCase("raids")) {
    	        								
    	        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
    	        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
    	        								getRaids().add(new Raids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).
    	        								getAttributes().getNamedItem("total-raids").getNodeValue()),Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().
    	        								item(l).getChildNodes().item(m).getAttributes().getNamedItem("super-raids").getNodeValue())));
    	        		        						
        		        						for(int n = 0; n < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().getLength();n++) {
        		        							
        		        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("successful-raids")) {
        		        								
        		        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getRaids().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getRaids().size() -1).setSuccessfulRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
        		        								
        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("unsuccessful-raids")) {
        		        								
        		        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getRaids().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getRaids().size() -1).setUnsuccessfulRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
        		        								
        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("empty-raids")) {
        		        								
        		        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getRaids().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getRaids().size() -1).setEmptyRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
        		        							}
        		        						}
    	        								
    	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
    	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().equalsIgnoreCase("tackles")) {
    	        								
    	        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
    	        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
    	        								getTackles().add(new Tackles(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().
    	        								item(m).getAttributes().getNamedItem("total-tackles").getNodeValue()),Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).
    	        								getChildNodes().item(l).getChildNodes().item(m).getAttributes().getNamedItem("super-tackles").getNodeValue())));
    	        		        						
        		        						for(int n = 0; n < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().getLength();n++) {
        		        							
        		        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("successful-tackles")) {
        		        								
        		        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getTackles().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getTackles().size() -1).setSuccessfulTackles(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
        		        								
        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("unsuccessful-tackles")) {
        		        								
        		        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getTackles().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getTackles().size() -1).setUnsuccessfulTackles(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
        		        								
        		        							}
        		        						}
    	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
    	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().equalsIgnoreCase("do-or-die")) {
    	        								
    	        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
    	        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
    	        								getDo_or_die().add(new Do_Or_Die(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().
    	        								item(m).getAttributes().getNamedItem("total-raids").getNodeValue())));
    	        		        						
        		        						for(int n = 0; n < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().getLength();n++) {
        		        							
        		        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("successful-raids")) {
        		        								
        		        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getDo_or_die().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getDo_or_die().size() -1).setSuccessfullRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
        		        								
        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("failed-raids")) {
        		        								
        		        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getDo_or_die().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getDo_or_die().size() -1).setFailedRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
        		        								
        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("super-raids")) {
        		        								
        		        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getDo_or_die().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getDo_or_die().size() -1).setSuperRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
        		        								
        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("raid-points")) {
        		        								
        		        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getDo_or_die().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getDo_or_die().size() -1).setRaidPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
        		        								
        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("touch-points")) {
        		        								
        		        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getDo_or_die().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getDo_or_die().size() -1).setTouchPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
        		        								
        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("bonus-points")) {
        		        								
        		        								api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getDo_or_die().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
        		        								get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().get(api_pre_match.get(api_pre_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
        		        								getDo_or_die().size() -1).setBonusPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
        		        							}
        		        						}
    	        							}
        								}
        							}
        						}
        					}
        				}
        			}
        		}
        	}
        }
        
		return api_pre_match;
	}
	
	public static List<Api_In_match> getTopStatsDatafromXML(String source_path,String source_name) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError{
		
		List<Api_In_match> api_match = new ArrayList<Api_In_match>();
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(source_path + source_name));
	        doc.getDocumentElement().normalize();
	        
	        NodeList childNodes = doc.getDocumentElement().getChildNodes();
	        for(int i = 0; i < childNodes.getLength(); i++) {
	        	if(childNodes.item(i).getNodeType() == Node.ELEMENT_NODE && childNodes.item(i).getNodeName().equals("team-players-statistics")) {
	        		api_match.add(new Api_In_match(new ArrayList<TeamPlayerStats>()));
	        		for(int j=0;j<childNodes.item(i).getChildNodes().getLength();j++) {
	        			if(childNodes.item(i).getChildNodes().item(j).getNodeType() == Node.ELEMENT_NODE 
	            				&& childNodes.item(i).getChildNodes().item(j).getNodeName().equalsIgnoreCase("team")) {
	        				
	        				api_match.get(api_match.size()-1).getTeamPlayerStats().add(new TeamPlayerStats(childNodes.item(i).getChildNodes().item(j).getAttributes().
	        					getNamedItem("team-name").getNodeValue(), Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getAttributes().getNamedItem("team-id")
	        					.getNodeValue()) , Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getAttributes().getNamedItem("no-of-players-on-court").getNodeValue()), 
	        					new ArrayList<Points>(), new PointsNminutes(),new ArrayList<Raids>(),new ArrayList<Tackles>(),new ArrayList<Do_Or_Die>(),new ArrayList<PlayerStats>()));
	        				
	        				for(int k = 0; k < childNodes.item(i).getChildNodes().item(j).getChildNodes().getLength();k++) {
	        					if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
	        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("points")) {
	        						
	        						api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
	        							add(new Points(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getAttributes().
	        							getNamedItem("total-points").getNodeValue()), new ArrayList<TacklePoints>(), new ArrayList<RaidPoints>()));
        						
	        						for(int l = 0; l < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();l++) {
	        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("all-out-points")) {

	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
	        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1)
	        									.getPoints().size()-1).setAll_out_points(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k)
	        									.getChildNodes().item(l).getFirstChild().getNodeValue()));
	        								
	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("extra-points")) {
	        					
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1)
        									.getPoints().size()-1).setExtra_points(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k)
        									.getChildNodes().item(l).getFirstChild().getNodeValue()));
	        								
	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("tackle-points")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
	        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
	        									getTackle_points().add(new TacklePoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).
	        									getAttributes().getNamedItem("total-tackle-points").getNodeValue())));
	        								
	        								for(int m = 0; m < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().getLength();m++) {
	        									if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
	        											childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().
	        											equalsIgnoreCase("capture-points")) {
	        									
	        										api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
		        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
		        									getTackle_points().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
		        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
		        									getTackle_points().size()-1).setCapturePoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k)
		        									.getChildNodes().item(l).getChildNodes().item(m).getFirstChild().getNodeValue()));
	        										
	        									}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
	        											childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().
	        											equalsIgnoreCase("tackle-bonus-points")) {
	        										
	        										api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
		        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
		        									getTackle_points().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
		        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
		        									getTackle_points().size()-1).setTackleBounsPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k)
		        									.getChildNodes().item(l).getChildNodes().item(m).getFirstChild().getNodeValue()));
	        									}
	        								}
	        								
	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("raid-points")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
        									getRaid_points().add(new RaidPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).
        									getAttributes().getNamedItem("total-raid-points").getNodeValue())));
	        								
		    								for(int m = 0; m < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().getLength();m++) {
		    									if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
		    											childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().
		    											equalsIgnoreCase("touch-points")) {
		    										
		    										api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
		        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
		        									getRaid_points().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
		        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
		        									getRaid_points().size()-1).setTouchPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k)
		        									.getChildNodes().item(l).getChildNodes().item(m).getFirstChild().getNodeValue()));
		    										
		    									}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
		    											childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().
		    											equalsIgnoreCase("raid-bonus-points")) {
		    										
		    										api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
		        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
		        									getRaid_points().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().
		        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPoints().size()-1).
		        									getRaid_points().size()-1).setRaidBounsPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k)
		        									.getChildNodes().item(l).getChildNodes().item(m).getFirstChild().getNodeValue()));
		    									}
		    								}	
	        							}
	        						}
	        					}
	        					else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
	        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("points-last-n-minutes")) {
	        						
	        						for(int l = 0; l < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();l++) {
	        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("five")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPointsNminutes().
	        									setFive(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
	        								
	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("ten")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPointsNminutes().
        										setTen(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
        								
	        							}
	        						}
	        					}
	        					else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
	        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("raids")) {
	        						
	        						api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getRaids().add(new Raids(
	        						Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getAttributes().getNamedItem("total-raids").getNodeValue()),
	        						Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getAttributes().getNamedItem("super-raids").getNodeValue())));
	        						
	        						for(int l = 0; l < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();l++) {
	        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("successful-raids")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getRaids().
        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getRaids().size()-1)
        									.setSuccessfulRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
	        								
	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("unsuccessful-raids")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getRaids().
        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getRaids().size()-1)
        									.setUnsuccessfulRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
	        								
	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("empty-raids")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getRaids().
        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getRaids().size()-1)
        									.setEmptyRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
	        								
	        								
	        							}
	        						}
	        					}
	        					else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
	        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("tackles")) {
	        						
	        						api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getTackles().add(new Tackles(
	        						Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getAttributes().getNamedItem("total-tackles").getNodeValue()),
	        						Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getAttributes().getNamedItem("super-tackles").getNodeValue())));
	        						
	        						for(int l = 0; l < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();l++) {
	        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("successful-tackles")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getTackles().
        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getTackles().size()-1)
        									.setSuccessfulTackles(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
	        								
	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("unsuccessful-tackles")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getTackles().
        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getTackles().size()-1)
        									.setUnsuccessfulTackles(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
	        								
	        							}
	        						}
	        					}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
	        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("do-or-die")) {
	        						
	        						api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().
	        						add(new Do_Or_Die(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getAttributes().getNamedItem("total-raids")
	        						.getNodeValue())));
	        						
	        						for(int l = 0; l < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();l++) {
	        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("successfull-raids")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().
        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().size()-1)
        									.setSuccessfullRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
	        								
	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("failed-raids")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().
        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().size()-1)
        									.setFailedRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
	        								
	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("super-raids")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().
        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().size()-1)
        									.setSuperRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
	        								
	        								
	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("raid-points")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().
        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().size()-1)
        									.setRaidPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
	        								
	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("touch-points")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().
        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().size()-1)
        									.setTouchPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
	        								
	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("bonus-points")) {
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().
        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getDo_or_die().size()-1)
        									.setBonusPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getFirstChild().getNodeValue()));
	        								
	        							}
	        						}
	        					}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE &&
	        							childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getNodeName().equalsIgnoreCase("players")) {
	        						for(int l = 0; l < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().getLength();l++) {
	        							//System.out.println(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName());
	        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE &&
	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getNodeName().equalsIgnoreCase("player")){
	        								
	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	    	        						add(new PlayerStats(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getAttributes().getNamedItem("player-name").getNodeValue(), 
	    	        							Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getAttributes().getNamedItem("player-id").getNodeValue()),  
	    	        							new ArrayList<Points>(),new ArrayList<Raids>(),new ArrayList<Tackles>(),new ArrayList<Do_Or_Die>()));
	        								
	        								if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getAttributes().getNamedItem("player-raiding-now") == null) {
	        								}else {
	        									api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size() -1).
	        									setPlayer_raiding_now(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getAttributes().getNamedItem("player-raiding-now").getNodeValue());
	        								}
	        								
	        								if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getAttributes().getNamedItem("player-on-court") == null) {
	        								}else {
	        									api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size() -1).
	        									setPlayer_on_court(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getAttributes().getNamedItem("player-on-court").getNodeValue());
	        								}
	        								
	        								if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getAttributes().getNamedItem("player-revival-order") == null) {
	        								}else {
	        									api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        									get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size() -1).
	        									setPlayer_revival_order(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getAttributes().getNamedItem("player-revival-order").getNodeValue());
	        								}
	        								
	        								for(int m = 0; m < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().getLength();m++) {
	        									if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
	    	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().equalsIgnoreCase("points")) {
	        										
	        										api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	    	        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	    	        								getPoints().add(new Points(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).
	    	        								getAttributes().getNamedItem("total-points").getNodeValue()), new ArrayList<TacklePoints>(), new ArrayList<RaidPoints>()));
	        										
	        										for(int n = 0; n < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().getLength();n++) {
	        											if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
	        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("raid-points")) {
	        												
	        												api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	            	        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	            	        								getPoints().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	            	        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	            	        								getPoints().size()-1).getRaid_points().add(new RaidPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).
	            	        								getChildNodes().item(m).getChildNodes().item(n).getAttributes().getNamedItem("total-raid-points").getNodeValue())));
	        												
	        												for(int o = 0; o < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getChildNodes().getLength();o++) {
	        													if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getChildNodes().item(o).
	        														getNodeType() == Node.ELEMENT_NODE && childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).
	        														getChildNodes().item(o).getNodeName().equalsIgnoreCase("touch-points")) {
	        														
	        														api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        														get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        														getPoints().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        														get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        														getPoints().size()-1).getRaid_points().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	                												get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	                												getPoints().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	                												get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	                												getPoints().size()-1).getRaid_points().size()-1).setTouchPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).
	                												getChildNodes().item(n).getChildNodes().item(o).getAttributes().getNamedItem("total-touch-points").getNodeValue()));
	        			    										
	        			    									}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getChildNodes().item(o).
	            														getNodeType() == Node.ELEMENT_NODE && childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).
	            														getChildNodes().item(o).getNodeName().equalsIgnoreCase("raid-bonus-points")) {
	        			    										
	        			    										api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        														get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        														getPoints().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        														get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        														getPoints().size()-1).getRaid_points().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	                												get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	                												getPoints().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	                												get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	                												getPoints().size()-1).getRaid_points().size()-1).setRaidBounsPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).
	        														getChildNodes().item(n).getChildNodes().item(o).getFirstChild().getNodeValue()));
	        			    										
	        			    									}
	        												}
	        												
	        											}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
	        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("tackle-points")) {
	        												
	        												api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	            	        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	            	        								getPoints().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	            	        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	            	        								getPoints().size()-1).getTackle_points().add(new TacklePoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).
	            	        								getChildNodes().item(m).getChildNodes().item(n).getAttributes().getNamedItem("total-tackle-points").getNodeValue())));
	        												
	        												for(int o = 0; o < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getChildNodes().getLength();o++) {
	        													if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getChildNodes().item(o).
	        														getNodeType() == Node.ELEMENT_NODE && childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).
	        														getChildNodes().item(o).getNodeName().equalsIgnoreCase("capture-points")) {
	        														
	        														api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        														get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        														getPoints().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        														get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        														getPoints().size()-1).getTackle_points().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	                												get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	                												getPoints().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	                												get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	                												getPoints().size()-1).getTackle_points().size()-1).setCapturePoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).
	                												getChildNodes().item(n).getChildNodes().item(o).getAttributes().getNamedItem("total-capture-points").getNodeValue()));
	        			    										
	        			    									}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getChildNodes().item(o).
	            														getNodeType() == Node.ELEMENT_NODE && childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).
	            														getChildNodes().item(o).getNodeName().equalsIgnoreCase("tackle-bonus-points")) {
	        			    										
	        			    										api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        														get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        														getPoints().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        														get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        														getPoints().size()-1).getTackle_points().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	                												get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	                												getPoints().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	                												get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	                												getPoints().size()-1).getTackle_points().size()-1).setTackleBounsPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).
	        														getChildNodes().item(n).getChildNodes().item(o).getFirstChild().getNodeValue()));
	        			    										
	        			    									}
	        												}
	        											}
	        										}
	        									}
	        									else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
	    	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().equalsIgnoreCase("raids")) {
	    	        								
	    	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	    	        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	    	        								getRaids().add(new Raids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).
	    	        								getAttributes().getNamedItem("total-raids").getNodeValue()),Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().
	    	        								item(l).getChildNodes().item(m).getAttributes().getNamedItem("super-raids").getNodeValue())));
	    	        		        						
	        		        						for(int n = 0; n < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().getLength();n++) {
	        		        							
	        		        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
	        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("successful-raids")) {
	        		        								
	        		        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getRaids().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getRaids().size() -1).setSuccessfulRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
	        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
	        		        								
	        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
	        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("unsuccessful-raids")) {
	        		        								
	        		        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getRaids().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getRaids().size() -1).setUnsuccessfulRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
	        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
	        		        								
	        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
	        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("empty-raids")) {
	        		        								
	        		        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getRaids().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getRaids().size() -1).setEmptyRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
	        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
	        		        							}
	        		        						}
	    	        								
	    	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
	    	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().equalsIgnoreCase("tackles")) {
	    	        								
	    	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	    	        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	    	        								getTackles().add(new Tackles(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().
	    	        								item(m).getAttributes().getNamedItem("total-tackles").getNodeValue()),Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).
	    	        								getChildNodes().item(l).getChildNodes().item(m).getAttributes().getNamedItem("super-tackles").getNodeValue())));
	    	        		        						
	        		        						for(int n = 0; n < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().getLength();n++) {
	        		        							
	        		        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
	        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("successful-tackles")) {
	        		        								
	        		        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getTackles().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getTackles().size() -1).setSuccessfulTackles(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
	        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
	        		        								
	        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
	        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("unsuccessful-tackles")) {
	        		        								
	        		        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getTackles().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getTackles().size() -1).setUnsuccessfulTackles(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
	        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
	        		        								
	        		        							}
	        		        						}
	    	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
	    	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().equalsIgnoreCase("do-or-die")) {
	    	        								
	    	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	    	        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	    	        								getDo_or_die().add(new Do_Or_Die(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().
	    	        								item(m).getAttributes().getNamedItem("total-raids").getNodeValue())));
	    	        		        						
	        		        						for(int n = 0; n < childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().getLength();n++) {
	        		        							
	        		        							if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
	        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("successful-raids")) {
	        		        								
	        		        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getDo_or_die().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getDo_or_die().size() -1).setSuccessfullRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
	        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
	        		        								
	        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
	        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("failed-raids")) {
	        		        								
	        		        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getDo_or_die().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getDo_or_die().size() -1).setFailedRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
	        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
	        		        								
	        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
	        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("super-raids")) {
	        		        								
	        		        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getDo_or_die().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getDo_or_die().size() -1).setSuperRaids(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
	        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
	        		        								
	        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
	        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("raid-points")) {
	        		        								
	        		        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getDo_or_die().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getDo_or_die().size() -1).setRaidPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
	        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
	        		        								
	        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
	        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("touch-points")) {
	        		        								
	        		        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getDo_or_die().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getDo_or_die().size() -1).setTouchPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
	        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
	        		        								
	        		        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeType() == Node.ELEMENT_NODE &&
	        		        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getChildNodes().item(n).getNodeName().equalsIgnoreCase("bonus-points")) {
	        		        								
	        		        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getDo_or_die().get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	        		        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	        		        								getDo_or_die().size() -1).setBonusPoints(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes()
	        		        								.item(m).getChildNodes().item(n).getFirstChild().getNodeValue()));
	        		        							}
	        		        						}
	    	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
	    	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().equalsIgnoreCase("time-off-court")) {
	    	        								
	    	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	    	        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	    	        								setTime_off_court(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).
	    	        								getFirstChild().getNodeValue()));
	    	        								
	    	        							}else if(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeType() == Node.ELEMENT_NODE &&
	    	        									childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).getNodeName().equalsIgnoreCase("avg-raid-time")) {
	    	        								
	    	        								api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().
	    	        								get(api_match.get(api_match.size()-1).getTeamPlayerStats().get(api_match.get(api_match.size()-1).getTeamPlayerStats().size()-1).getPlayerStats().size()-1).
	    	        								setAvg_raid_time(Integer.valueOf(childNodes.item(i).getChildNodes().item(j).getChildNodes().item(k).getChildNodes().item(l).getChildNodes().item(m).
	    	        								getFirstChild().getNodeValue()));
	    	        							}
	        								}
	        							}
	        						}
	        					}
	        				}
	        			}
	        			
	        		}
	        	}
	        }
		return api_match;
	}
	public static List<Api_tennis> getTopStatsDatafromAPI(String destination,String match_name) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
		List<Api_tennis> api_match = new ArrayList<Api_tennis>();
		
		URL url = new URL("http://localhost:54321/GetJson/" + match_name);
        URLConnection connection = url.openConnection();
        connection.connect();
        
        Api_tennis my_data = new ObjectMapper().readValue(url, Api_tennis.class);
        new ObjectMapper().writeValue(new File(destination), my_data);
        api_match.add(my_data);
        
		return api_match;
	}
	public static Football getFootballData(String match_name) throws Exception {
		Football api_match = null;
        String apiUrl = "https://cloud.cricket-21.com/cricketapi/api/FootBall/GetInMatchStat?Matchid="+match_name+"&type=json";

        HttpURLConnection connection = null;
        try {
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("HTTP error code: " + responseCode);
            }

            try (InputStream inputStream = connection.getInputStream()) {
                ObjectMapper objectMapper = new ObjectMapper();
                api_match = objectMapper.readValue(inputStream, Football.class);

                File outputFile = new File(ApiUtil.FOOTBALL_API_DIRECTORY  + "\\InMatch.json");
                objectMapper.writeValue(outputFile, api_match);
            }
        } catch (IOException e) {
            System.err.println("Error fetching Football Data: " + e.getMessage());
            throw e; // Re-throw the exception if necessary
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return api_match;
    }

    public static Football getFootballPreData(String match_name) throws Exception {
    	Football api_match = null;
        String apiUrl = "https://cloud.cricket-21.com/cricketapi/api/FootBall/GetPreMatchStat?compid=7&type=json";

        HttpURLConnection connection = null;
        try {
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("HTTP error code: " + responseCode);
            }

            try (InputStream inputStream = connection.getInputStream()) {
                ObjectMapper objectMapper = new ObjectMapper();
                api_match = objectMapper.readValue(inputStream, Football.class);

                File outputFile = new File(ApiUtil.FOOTBALL_API_DIRECTORY  + "\\PreMatch.json");
                objectMapper.writeValue(outputFile, api_match);
            }
        } catch (IOException e) {
            System.err.println("Error fetching Pre-Match Data: " + e.getMessage());
            throw e; // Re-throw the exception if necessary
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return api_match;
    }
    
    public static Football_PointsTable getFootballPointsTable() throws Exception {
    	Football_PointsTable api_match = null;
        String apiUrl = "https://cloud.cricket-21.com/cricketapi/api/FootBall/PointsTable?CompId=5&type=json";

        HttpURLConnection connection = null;
        try {
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("HTTP error code: " + responseCode);
            }

            try (InputStream inputStream = connection.getInputStream()) {
                ObjectMapper objectMapper = new ObjectMapper();
                api_match = objectMapper.readValue(inputStream, Football_PointsTable.class);

                File outputFile = new File(ApiUtil.FOOTBALL_API_DIRECTORY  + "\\PointsTable.json");
                objectMapper.writeValue(outputFile, api_match);
            }
        } catch (IOException e) {
            System.err.println("Error fetching Pre-Match Data: " + e.getMessage());
            throw e; // Re-throw the exception if necessary
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return api_match;
    }
    
    public static INCP_PreMatch getBasketBallData(String destination, String match_name) throws Exception {
		 INCP_PreMatch api_match = null;
	        URL url = new URL("https://cloud.cricket-21.com/cricketapi/api/Dream11/BasketBall/GetPreMatchStat?matchid="+match_name+"&type=json");
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");
	        connection.setConnectTimeout(5000);  
	        connection.setReadTimeout(5000);    

	        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
	            throw new IOException("HTTP error code: " + connection.getResponseCode());
	        }
	        InputStream inputStream = connection.getInputStream();
	        ObjectMapper objectMapper = new ObjectMapper();
	        api_match = objectMapper.readValue(inputStream, INCP_PreMatch.class);

	        objectMapper.writeValue(new File("C:\\Sports\\Basketball\\InMatch.json"), api_match);
	        inputStream.close();
	        //getBasketBallDatas(destination, match_name);
	        return api_match;
	    }
	 
	 public static INCP_SportEvent getBasketBallDatas(String destination, String match_name) throws Exception {
	        INCP_SportEvent api_match = null;
	        HttpURLConnection connection = null;
	        InputStream inputStream = null;
	        
	        try {
	            URL url = new URL("https://cloud.cricket-21.com/cricketapi/api/Dream11/Basketball/Scorecard?Matchid=" + match_name + "&type=json");
	            connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");
	            connection.setConnectTimeout(5000);  
	            connection.setReadTimeout(5000);    
	            // Check if response is OK
	            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
	                throw new IOException("HTTP error code: " + connection.getResponseCode());
	            }

	            inputStream = connection.getInputStream();
	            ObjectMapper objectMapper = new ObjectMapper();	            
	            api_match = objectMapper.readValue(inputStream, INCP_SportEvent.class);
	            objectMapper.writeValue(new File("C:\\Sports\\Basketball\\InMatch.json"), api_match);
	        } catch (IOException e) {
	            System.err.println("Error during the API call or file writing: " + e.getMessage());
	            e.printStackTrace();
	            throw e; 
	        } finally {
	            if (inputStream != null) {
	                try {
	                    inputStream.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (connection != null) {
	                connection.disconnect();
	            }
	        }

	        return api_match;
	    }
	
	 public static INCP_PreMatch getBasketBallPreMatch() throws Exception {
	        HttpURLConnection connection = null;
	        InputStream inputStream = null;
	        try {
	            URL url = new URL("https://cloud.cricket-21.com/cricketapi/api/Dream11/BasketBall/GetPreMatchStat?compid=286&type=json");
	            connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");
	            connection.setConnectTimeout(5000);
	            connection.setReadTimeout(5000);

	            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
	                throw new IOException("HTTP error code: " + connection.getResponseCode());
	            }

	            inputStream = connection.getInputStream();
	            ObjectMapper objectMapper = new ObjectMapper();
	            INCP_PreMatch api_match = objectMapper.readValue(inputStream, INCP_PreMatch.class);
	            objectMapper.writeValue(new File("C:\\Sports\\Basketball\\PreMatch.json"), api_match);

	            return api_match;
	        } catch (IOException e) {
	            System.err.println("Error during the API call or file writing: " + e.getMessage());
	            throw e; // Rethrow exception to allow higher-level handling if needed
	        } finally {
	            if (inputStream != null) {
	                try {
	                    inputStream.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (connection != null) {
	                connection.disconnect();
	            }
	        }
	    }
	 public static TournamentSchedule getTournamentSchedulefromAPI(String destination,String match_name) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
		URL url = new URL(ApiUtil.FOOTBALL_API_PATH + "tournamentschedule" + ApiUtil.FOOTBALL_TOKEN + "/emq4j56v2j9tf3jgzfksznms4?" + 
				ApiUtil.FOOTBALL_API_JSON + "&" + ApiUtil.FOOTBALL_API_MODE);
        URLConnection connection = url.openConnection();
        connection.connect();
        
        TournamentSchedule = new ObjectMapper().readValue(url, TournamentSchedule.class);
        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "TournamentSchedule.json"), TournamentSchedule);
        
		return TournamentSchedule;
	}
	
	public static LiveMatch getFootballLiveDatafromAPI(String url,String token) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
		HttpResponse<String> userResp;
		//LIVE MATCH
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			LiveMatch = new ObjectMapper().readValue(userResp.getBody().toString(), LiveMatch.class);
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "LiveData.json"), LiveMatch);
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		// MATCH EVENTS
		try {
			userResp = Unirest.get(ApiUtil.FOOTBALL_API_PATH + "matchevent" + ApiUtil.FOOTBALL_TOKEN + "/?"+ ApiUtil.FOOTBALL_API_JSON +"&" 
					+ ApiUtil.FOOTBALL_API_MODE + "&fx=" + ApiUtil.FOOTBALL_FIXTURE_ID)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "MatchEvent.json"), new ObjectMapper().readValue(userResp.getBody().toString(), LiveMatch.class));
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		// MATCH PREVIEW
		try {
			userResp = Unirest.get(ApiUtil.FOOTBALL_API_PATH + "matchpreview" + ApiUtil.FOOTBALL_TOKEN + "/?" + 
					ApiUtil.FOOTBALL_API_MODE +"&" + ApiUtil.FOOTBALL_API_JSON + "&fx=" + ApiUtil.FOOTBALL_FIXTURE_ID)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
		    new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "MatchPreview.json"), new ObjectMapper().readValue(userResp.getBody().toString(), MatchPreview.class));
		    
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		// PASS MATRIX
		try {
			userResp = Unirest.get(ApiUtil.FOOTBALL_API_PATH + "passmatrix" + ApiUtil.FOOTBALL_TOKEN + "/?"+ ApiUtil.FOOTBALL_API_JSON +"&"+
					 ApiUtil.FOOTBALL_API_MODE +"&fx="+ApiUtil.FOOTBALL_FIXTURE_ID)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
		       new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "PassMatrix.json"), new ObjectMapper().readValue(userResp.getBody().toString(), PassMatrix.class));
		       
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
	//Possession
		try {
			userResp = Unirest.get(ApiUtil.FOOTBALL_API_PATH + "possession" + ApiUtil.FOOTBALL_TOKEN + "/?"+ApiUtil.FOOTBALL_API_JSON +"&"+ApiUtil.FOOTBALL_API_MODE+
					"&fx="+ApiUtil.FOOTBALL_FIXTURE_ID )
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "Possession.json"),  new ObjectMapper().readValue(userResp.getBody().toString(), Possession.class));
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		return LiveMatch;
	}
	public static Possession getPossessionfromAPI(String url,String token) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{	
		url= ApiUtil.FOOTBALL_API_PATH + "possession" + ApiUtil.FOOTBALL_TOKEN + "/?"+ApiUtil.FOOTBALL_API_JSON +"&"+ApiUtil.FOOTBALL_API_MODE+
				"&fx="+ApiUtil.FOOTBALL_FIXTURE_ID ;
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			Possession = new ObjectMapper().readValue(userResp.getBody().toString(), Possession.class);
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "Possession.json"), Possession);
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		return Possession;
		
	}
	public static LiveMatch getFootballSeasonalStatsfromAPI(String token) throws JsonMappingException, StreamWriteException, DatabindException, JsonProcessingException, IOException {
	    LiveMatch livematch = new ObjectMapper().readValue(new File("C:\\Sports\\Football\\Statistic\\Match_Data\\LiveData.json"), LiveMatch.class);
	    rankings = getTeamRankingfromAPI("",token);	 
	  
		 // TOP PERFORMER
		try {
			HttpResponse<String> userResp = Unirest.get(ApiUtil.FOOTBALL_API_PATH + "topperformers" + ApiUtil.FOOTBALL_TOKEN + "?tmcl="+ApiUtil.FOOTBALL_TOURNAMENT_CALENDER_ID+"&" + 
					ApiUtil.FOOTBALL_API_JSON +"&" + ApiUtil.FOOTBALL_API_MODE)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "TopPerformers.json"), new ObjectMapper().readValue(userResp.getBody().toString(), TopPerformers.class));
		       
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode jsonArray = objectMapper.createArrayNode();

		for (teamData tm : rankings.getTeam()) {
		    for (TeamPlayerRanking plyr : tm.getPlayer()) {
		        if (plyr.getPosition() != null && plyr.getPosition().equalsIgnoreCase("Goalkeeper")) {
		            if (plyr.getStat() != null) {
		                ObjectNode jsonObject = objectMapper.createObjectNode(); 
		                jsonObject.put("matchName", plyr.getName());
		                jsonObject.put("position", plyr.getPosition());
		                jsonObject.put("id", plyr.getId());
		                jsonObject.put("teamid", tm.getId());

		                for (Stat st : plyr.getStat()) {
		                    if (st.getType() != null) {
		                        if (st.getType().equalsIgnoreCase("total clean sheet ranking")) {
		                            jsonObject.put("Stat", "total clean sheet ranking");
		                            jsonObject.put("rank", st.getValue());
		                        } else if (st.getType().equalsIgnoreCase("total clean sheet")) {
		                            jsonObject.put("value", st.getValue());
		                        }
		                    }
		                }
		                if (jsonObject.has("value") && (jsonObject.get("value").asInt() == 0 || !jsonObject.get("value").isNull())) {
		                    jsonArray.add(jsonObject);
		                }

		            }
		        }
		    }
		}

		jsonArray = JsonNodeFactory.instance.arrayNode().addAll(StreamSupport.stream(jsonArray.spliterator(), false)
			    .sorted(Comparator.comparingInt(node -> ((ObjectNode) node).get("rank").asInt()))
			    .collect(Collectors.toList()));

		try {
            objectMapper.writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "TeamStats.json"), jsonArray);

        } catch (IOException e) {
            e.printStackTrace();
        }
		return livematch;
	}
	public static Object getFootballSeasonalDatafromAPI(String token) throws JsonMappingException, StreamWriteException, DatabindException, JsonProcessingException, IOException {
		String url = "";
	    LiveMatch livematch = new ObjectMapper().readValue(new File("C:\\Sports\\Football\\Statistic\\Match_Data\\LiveData.json"), LiveMatch.class);
        SeasonalTeams Squad  = getTournamentTeamsSquadfromAPI(token);
		List<SeasonalStats> seasonalStatsList = new ArrayList<>();

		for (int i = 0; i < Squad.getContestant().size(); i++) {
		    url = ApiUtil.FOOTBALL_API_PATH + "seasonstats" + ApiUtil.FOOTBALL_TOKEN
		        + "?&tmcl=" + ApiUtil.FOOTBALL_TOURNAMENT_CALENDER_ID + "&ctst=" + Squad.getContestant().get(i).getId()
		        + "&" + ApiUtil.FOOTBALL_API_MODE + "&" + ApiUtil.FOOTBALL_API_JSON + "&detailed=yes";
		    
		    try {
		        HttpResponse<String> userRespS = Unirest.get(url)
		            .header("Content-Type", "application/json;charset=utf-8")
		            .header("Authorization", "Bearer " + token)
		            .asString();
		        seasonalStatsList.add(new ObjectMapper().readValue(userRespS.getBody(), SeasonalStats.class));
		        if(livematch.getMatchInfo().getContestant().get(0).getId().trim().equalsIgnoreCase(Squad.getContestant().get(i).getId())) {
		            new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "SeasonalStats1.json"), new ObjectMapper().readValue(userRespS.getBody().toString(), SeasonalStats.class));
		        }else if(livematch.getMatchInfo().getContestant().get(1).getId().trim().equalsIgnoreCase(Squad.getContestant().get(i).getId())) {
		            new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "SeasonalStats2.json"), new ObjectMapper().readValue(userRespS.getBody().toString(), SeasonalStats.class));
		        }

		        
		    } catch (UnirestException e) {
		        System.out.println("Error fetching data for contestant ID: " +  Squad.getContestant().get(i).getId());
		        e.printStackTrace();
		    } catch (JsonProcessingException e) {
		        System.out.println("Error parsing JSON response for contestant ID: " +  Squad.getContestant().get(i).getId());
		        e.printStackTrace();
		    }
		}

		// TOP PERFORMER
				try {
					HttpResponse<String> userResp = Unirest.get(ApiUtil.FOOTBALL_API_PATH + "topperformers" + ApiUtil.FOOTBALL_TOKEN + "?tmcl="+ApiUtil.FOOTBALL_TOURNAMENT_CALENDER_ID+"&" + 
							ApiUtil.FOOTBALL_API_JSON +"&" + ApiUtil.FOOTBALL_API_MODE)
							.header("Content-Type", "application/json;charset=utf-8")
							.header("Authorization", "Bearer " + token)
							.asString();
					
			        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "TopPerformers.json"), new ObjectMapper().readValue(userResp.getBody().toString(), TopPerformers.class));
				       
				} catch (UnirestException e) {
					System.out.println("Error...");
				}
				ObjectMapper objectMapper = new ObjectMapper();
		        ArrayNode jsonArray = objectMapper.createArrayNode();

		        for (SeasonalStats st : seasonalStatsList) {
		            for (SeasonalPlayerStats ply : st.getPlayer()) {
		                if (ply.getStat() != null) {
		                    for (Stat stats : ply.getStat()) {
		                        if (stats.getName().equalsIgnoreCase("Goals Conceded")) {
		                            ObjectNode jsonObject = objectMapper.createObjectNode();
		                            jsonObject.put("matchName", ply.getMatchName());
		                            jsonObject.put("Stat", "Goals Conceded");
		                            jsonObject.put("id", ply.getId());
		                            jsonObject.put("value", stats.getValue());
		                            jsonObject.put("teamid", st.getContestant().getId());
		                            jsonArray.add(jsonObject);
		                        }
		                    }
		                }
		            }
		        }
		        try {
		            objectMapper.writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "TeamStats.json"), jsonArray);

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		return null;
	}
	public static LiveMatch getFootballPlayerEventfromAPI(String url,String token) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			LiveMatch = new ObjectMapper().readValue(userResp.getBody().toString(), LiveMatch.class);
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "PlayerEvent.json"), LiveMatch);
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
		return LiveMatch;
	}
	
	public static LiveMatch getFootballMatchEventfromAPI(String url,String token) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
		
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			LiveMatch = new ObjectMapper().readValue(userResp.getBody().toString(), LiveMatch.class);
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "MatchEvent.json"), LiveMatch);
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
		return LiveMatch;
	}
	
	public static LiveMatch getFootballWinProbabilityfromAPI(String url,String token) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
	    LiveMatch liveData = new ObjectMapper().readValue(new File("C:\\Sports\\Football\\Statistic\\Match_Data\\LiveData.json"), LiveMatch.class);
	    
	    url = ApiUtil.FOOTBALL_API_PATH  + "matchlivewinprobability" + ApiUtil.FOOTBALL_TOKEN + "/"+liveData.getMatchInfo().getId()+"?" + 
		ApiUtil.FOOTBALL_API_MODE + "&" + ApiUtil.FOOTBALL_API_JSON;
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			LiveMatch = new ObjectMapper().readValue(userResp.getBody().toString(), LiveMatch.class);
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "WinProbability.json"), LiveMatch);
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
		return LiveMatch;
	}
	
	public static TournamentSimulation getFootballTournamentSimulationfromAPI(String url,String token) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			TournamentSimulation = new ObjectMapper().readValue(userResp.getBody().toString(), TournamentSimulation.class);
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "TournamentSimulation.json"), TournamentSimulation);
	        
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
		return TournamentSimulation;
	}
	public static SeasonalStats getSeasonalStatsfromAPI(String url, String token) throws IOException {
	    LiveMatch liveData = new ObjectMapper().readValue(new File("C:\\Sports\\Football\\Statistic\\Match_Data\\LiveData.json"), LiveMatch.class);
	    for (int i = 0; i < 2; i++) {
	        String teamId = liveData.getMatchInfo().getContestant().get(i).getId();

	        url = ApiUtil.FOOTBALL_API_PATH + "seasonstats" + ApiUtil.FOOTBALL_TOKEN 
	            + "?&tmcl=" + ApiUtil.FOOTBALL_TOURNAMENT_CALENDER_ID + "&ctst=" + teamId 
	            + "&" + ApiUtil.FOOTBALL_API_MODE + "&" + ApiUtil.FOOTBALL_API_JSON +"&detailed=yes";
	        try {
	            HttpResponse<String> userResp = Unirest.get(url)
	                .header("Content-Type", "application/json;charset=utf-8")
	                .header("Authorization", "Bearer " + token)
	                .asString();

	            SeasonalStats seasonalStats = new ObjectMapper().readValue(userResp.getBody().toString(), SeasonalStats.class);
	            new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "SeasonalStats" + (i + 1) + ".json"), seasonalStats);
	        } catch (UnirestException e) {
	            System.out.println("Error...");
	        }
	    }

	    return SeasonalStats;
	}

	public static PlayerCareer getPlayerStatsfromAPI(String url,String token) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			PlayerCareer = new ObjectMapper().readValue(userResp.getBody().toString(), PlayerCareer.class);
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "PlayerStats.json"), PlayerCareer);
	        
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
		return PlayerCareer;
	}
	
	public static  LiveMatch getPlayerTrackingDatafromAPI(String destination_path, String match_name) throws IOException {
		
		URL url = new URL("https://api.performfeeds.com/soccerdata/matchtracking/1vmmaetzoxkgg1qf6pkpfmku0k/68yjh2787ow2da11tsd4u3k0k?_rt=b&_fmt=json");
		URLConnection connection = url.openConnection();
        connection.connect();
        
        LiveMatch = new ObjectMapper().readValue(url, LiveMatch.class);
        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "LiveTracking.json"), LiveMatch);
        
		return LiveMatch;
	}
	public static  SeasonalTeams getTournamentTeamsSquadfromAPI(String token) throws IOException {
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(ApiUtil.FOOTBALL_API_PATH + "team" + ApiUtil.FOOTBALL_TOKEN + "?tmcl="+ApiUtil.FOOTBALL_TOURNAMENT_CALENDER_ID+"&"+ApiUtil.FOOTBALL_API_MODE  + 
					"&"+ApiUtil.FOOTBALL_API_JSON  + "&detailed=yes")
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			SeasonalTeams = new ObjectMapper().readValue(userResp.getBody().toString(), SeasonalTeams.class);
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "TournamentTeamsSquad.json"), SeasonalTeams);
	        
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
        
        
		return SeasonalTeams;
	}
	public static  Squad getTeamsfromAPI(String url, String token) throws IOException {
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			System.out.println(userResp.getBody().toString());
			Squad = new ObjectMapper().readValue(userResp.getBody().toString(), Squad.class);
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "Squad.json"), Squad);
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
       return Squad;
	}
	
	public static  rankings getTeamRankingfromAPI(String url, String token) throws IOException {
	
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get( ApiUtil.FOOTBALL_API_PATH + "rankings" + ApiUtil.FOOTBALL_TOKEN + "/?" +ApiUtil.FOOTBALL_API_MODE +"&" + ApiUtil.FOOTBALL_API_JSON+
					  "&tmcl="+ApiUtil.FOOTBALL_TOURNAMENT_CALENDER_ID )
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			System.out.println(userResp.getBody().toString());
			rankings = new ObjectMapper().readValue(userResp.getBody().toString(), rankings.class);
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "SeasonalRanking.json"), rankings);
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
       return rankings;
	}
	
	public static TopPerformers getTopPerformers(String url,String token) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			TopPerformers = new ObjectMapper().readValue(userResp.getBody().toString(), TopPerformers.class);
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "TopPerformers.json"), TopPerformers);
	        
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
		return TopPerformers;
	}
	public static TeamsStanding getPointsTable(String url, String token) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError {
	    HttpResponse<String> userResp;
	    TeamsStanding tm = new TeamsStanding(); 

	    try {
	        userResp = Unirest.get(url)
	                .header("Content-Type", "application/json;charset=utf-8")
	                .header("Authorization", "Bearer " + token)
	                .asString();
	        
	        TeamsStanding  = new ObjectMapper().readValue(userResp.getBody(), TeamsStanding.class);

//	        if (TeamsStanding != null && TeamsStanding.getStage() != null && !TeamsStanding.getStage().isEmpty()) {
//	            if (tm.getStage() == null) {
//	                tm.setStage(new ArrayList<>()); 
//	            }
//	            tm.getStage().add(new Stage( TeamsStanding.getStage().get(0).getId(),  TeamsStanding.getStage().get(0).getFormatId(),  TeamsStanding.getStage().get(0).getName()));
//
//	            if (tm.getStage().get(0).getDivision() == null) {TeamsStanding
//	            	tm.getStage().get(0).setDivision(new ArrayList<>()); 
//	            }
//
//	            if (!TeamsStanding.getStage().get(0).getDivision().isEmpty()) {
//	                tm.getStage().get(0).getDivision().add(TeamsStanding.getStage().get(0).getDivision().get(0));
//	            }
//	        }
	        
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "PointsTable.json"), TeamsStanding);
	        
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	    
	    return TeamsStanding; 
	}

	public static CurrentMatchLineup getFootballLineup(String url,String token) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			CurrentMatchLineup = new ObjectMapper().readValue(userResp.getBody().toString(), CurrentMatchLineup.class);
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "Lineup.json"), CurrentMatchLineup);
	        
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
		return CurrentMatchLineup;
	}
	
	public static PossesionEvent getPossesionEvent(String url,String token) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			PossesionEvent = new ObjectMapper().readValue(userResp.getBody().toString(), PossesionEvent.class);
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "PossesionEvent.json"), PossesionEvent);
	        
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
		return PossesionEvent;
	}
	public static PenaltyPreview getPenaltyPreview(String url,String token) throws SAXException, IOException, ParserConfigurationException, FactoryConfigurationError
	{
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			PenaltyPreview = new ObjectMapper().readValue(userResp.getBody().toString(), PenaltyPreview.class);
	        new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "Penalty.json"), PenaltyPreview);
	        
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
		return PenaltyPreview;
	}

	public static Fixtures_and_Results getFixturesAndResultsfromAPI(String url, String token) throws IOException {
	   
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			Fixtures_and_Results = new ObjectMapper().readValue(userResp.getBody().toString(), Fixtures_and_Results.class);
		       new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "Fixtures_and_Results.json"), Fixtures_and_Results);
		       
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
       return Fixtures_and_Results;
	}
	public static PassMatrix getPassMatrixfromAPI(String url, String token) throws IOException {
		
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			PassMatrix my_data = new ObjectMapper().readValue(userResp.getBody().toString(), PassMatrix.class);
		       new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "PassMatrix.json"), my_data);
		       PassMatrix = my_data;
		       
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
	       return PassMatrix;
		}
	
	public static PassMatrix getMatchMomentumfromAPI(String url, String token) throws IOException {
		   
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			PassMatrix my_data = new ObjectMapper().readValue(userResp.getBody().toString(), PassMatrix.class);
		       new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "MatchMomentum.json"), my_data);
		       PassMatrix = my_data;
		       
		       
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
	       return PassMatrix;
	}
	public static void fetchTwitterData(String consumerKey, String consumerSecretKey, String accessToken, String accessTokenSecret) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true)
        .setOAuthConsumerKey(consumerKey)
        .setOAuthConsumerSecret(consumerSecretKey)
        .setOAuthAccessToken(accessToken)
        .setOAuthAccessTokenSecret(accessTokenSecret);
		
		 TwitterFactory tf = new TwitterFactory(cb.build());
	     Twitter twitter = tf.getInstance();
	        
//	        try {
//	        	User user = twitter.showUser("TimesAlgebraIND");
//	        	 System.out.println("User: " + user.getScreenName());
//	        } catch (TwitterException te) {
//	            te.printStackTrace();
//	            System.out.println("Failed to search tweets: " + te.getMessage());
//	        }
	}

	public static PassMatrix getMatchPossessionValuesfromAPI(String url, String token)throws IOException  {
		
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			PassMatrix my_data = new ObjectMapper().readValue(userResp.getBody().toString(), PassMatrix.class);
		       new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "PossessionValues.json"), my_data);
		       PassMatrix = my_data;
		       
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
       return PassMatrix;
	}
	
	public static PassMatrix getMatchPlayerRatingsfromAPI(String url, String token)throws IOException  {
		   
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			PassMatrix = new ObjectMapper().readValue(userResp.getBody().toString(), PassMatrix.class);
		       new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "MatchPlayerRatings.json"), PassMatrix);
		       
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
       return PassMatrix;
	}
	
	public static LiveMatch getExpectedGoals(String url, String token)throws IOException  {
		   
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			LiveMatch = new ObjectMapper().readValue(userResp.getBody().toString(), LiveMatch.class);
		    new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "ExpectedGoals.json"), LiveMatch);
			//liveMatchStatsAPI = new ObjectMapper().readValue(userResp.getBody().toString(), LiveMatchStatsAPI.class);
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
	       return LiveMatch;
		}
	public static MatchPreview getMatchPreview(String url, String token)throws IOException  {
		   
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			matchPreview = new ObjectMapper().readValue(userResp.getBody().toString(), MatchPreview.class);
		    new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "MatchPreview.json"), matchPreview);
			//liveMatchStatsAPI = new ObjectMapper().readValue(userResp.getBody().toString(), LiveMatchStatsAPI.class);
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
	       return matchPreview;
		}
	public static PassMatrix getMatchInsightsfromAPI(String url, String token) throws IOException {
		
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			PassMatrix = new ObjectMapper().readValue(userResp.getBody().toString(), PassMatrix.class);
		       new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "MatchInsights.json"), PassMatrix);
		       
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
	       return PassMatrix;
	}
	
	public static PassMatrix getMatchInsights2fromAPI(String url, String token) throws IOException {
		
		HttpResponse<String> userResp;
		try {
			userResp = Unirest.get(url)
					.header("Content-Type", "application/json;charset=utf-8")
					.header("Authorization", "Bearer " + token)
					.asString();
			
			PassMatrix = new ObjectMapper().readValue(userResp.getBody().toString(), PassMatrix.class);
		       new ObjectMapper().writeValue(new File(ApiUtil.FOOTBALL_API_DIRECTORY + "MatchFactAll.json"), PassMatrix);
		       
		} catch (UnirestException e) {
			System.out.println("Error...");
		}
		
	       return PassMatrix;
	}
	
	
}
