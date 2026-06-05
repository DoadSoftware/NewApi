package com.api.model.tennis;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.List;

 public class API_Tournament {

    @JsonProperty("tournament")
    private String tournament;

    @JsonProperty("venue")
    private String venue;

    @JsonProperty("day")
    private int day;

    @JsonProperty("match_no")
    private int match_no;

    @JsonProperty("match_id")
    private int match_id;

    @JsonProperty("team_a")
    private String team_a;

    @JsonProperty("team_b")
    private String team_b;

    @JsonProperty("match_status")
    private String match_status;

    @JsonProperty("score")
    private Score score;

    @JsonProperty("winner")
    private List<Winner> winner;

    @JsonProperty("squad")
    private Squad squad;

    @JsonProperty("playerwise_stat")
    private PlayerwiseStat playerwise_stat;

    @JsonProperty("teamwise_stat")
    private TeamwiseStat teamwise_stat;

    @JsonProperty("leader_board")
    private LeaderBoard leader_board;


    public String getTournament() {
		return tournament;
	}

	public void setTournament(String tournament) {
		this.tournament = tournament;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMatch_no() {
		return match_no;
	}

	public void setMatch_no(int match_no) {
		this.match_no = match_no;
	}

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public String getTeam_a() {
		return team_a;
	}

	public void setTeam_a(String team_a) {
		this.team_a = team_a;
	}

	public String getTeam_b() {
		return team_b;
	}

	public void setTeam_b(String team_b) {
		this.team_b = team_b;
	}

	public String getMatch_status() {
		return match_status;
	}

	public void setMatch_status(String match_status) {
		this.match_status = match_status;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public List<Winner> getWinner() {
		return winner;
	}

	public void setWinner(List<Winner> winner) {
		this.winner = winner;
	}

	public Squad getSquad() {
		return squad;
	}

	public void setSquad(Squad squad) {
		this.squad = squad;
	}

	public PlayerwiseStat getPlayerwise_stat() {
		return playerwise_stat;
	}

	public void setPlayerwise_stat(PlayerwiseStat playerwise_stat) {
		this.playerwise_stat = playerwise_stat;
	}

	public TeamwiseStat getTeamwise_stat() {
		return teamwise_stat;
	}

	public void setTeamwise_stat(TeamwiseStat teamwise_stat) {
		this.teamwise_stat = teamwise_stat;
	}

	public LeaderBoard getLeader_board() {
		return leader_board;
	}

	public void setLeader_board(LeaderBoard leader_board) {
		this.leader_board = leader_board;
	}
	
	public API_Tournament() {
		super();
	}

	@Override
	public String toString() {
		return "API_Tournament [tournament=" + tournament + ", venue=" + venue + ", day=" + day + ", match_no="
				+ match_no + ", match_id=" + match_id + ", team_a=" + team_a + ", team_b=" + team_b + ", match_status="
				+ match_status + ", score=" + score + ", winner=" + winner + ", squad=" + squad + ", playerwise_stat="
				+ playerwise_stat + ", teamwise_stat=" + teamwise_stat + ", leader_board=" + leader_board + "]";
	}


	public static class Score {

        @JsonProperty("team_a")
        private List<ScoreItem> team_a;

        @JsonProperty("team_b")
        private List<ScoreItem> team_b;

		public List<ScoreItem> getTeam_a() {
			return team_a;
		}

		public void setTeam_a(List<ScoreItem> team_a) {
			this.team_a = team_a;
		}

		public List<ScoreItem> getTeam_b() {
			return team_b;
		}

		public void setTeam_b(List<ScoreItem> team_b) {
			this.team_b = team_b;
		}

		public Score() {
			super();
			
		}

		@Override
		public String toString() {
			return "Score [team_a=" + team_a + ", team_b=" + team_b + "]";
		}

       
    }

    public static class ScoreItem {

        @JsonProperty("name")
        private String name;

        @JsonProperty("value")
        private int value;

        @JsonCreator
        public ScoreItem(@JsonProperty("name") String name, @JsonProperty("value") int value) {
            this.name = name;
            this.value = value;
        }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public ScoreItem() {
			super();
			
		}

		@Override
		public String toString() {
			return "ScoreItem [name=" + name + ", value=" + value + "]";
		}

    }

    public static class Winner {

        @JsonProperty("name")
        private String name;

        @JsonProperty("value")
        private String value;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Winner() {
			super();
			
		}

		@Override
		public String toString() {
			return "Winner [name=" + name + ", value=" + value + "]";
		}
        
    }

    public static class Squad {

        @JsonProperty("team_a")
        private List<Player> team_a;

        @JsonProperty("team_b")
        private List<Player> team_b;

		public List<Player> getTeam_a() {
			return team_a;
		}

		public void setTeam_a(List<Player> team_a) {
			this.team_a = team_a;
		}

		public List<Player> getTeam_b() {
			return team_b;
		}

		public void setTeam_b(List<Player> team_b) {
			this.team_b = team_b;
		}

		public Squad() {
			super();
			
		}

		@Override
		public String toString() {
			return "Squad [team_a=" + team_a + ", team_b=" + team_b + "]";
		}

        
    }

    public static class Player {

        @JsonProperty("player_id")
        private String player_id;

        @JsonProperty("player_name")
        private String player_name;

        @JsonProperty("gender")
        private String gender;

        @JsonProperty("age")
        private int age;

        @JsonProperty("nationality")
        private String nationality;

		public String getPlayer_id() {
			return player_id;
		}

		public void setPlayer_id(String player_id) {
			this.player_id = player_id;
		}

		public String getPlayer_name() {
			return player_name;
		}

		public void setPlayer_name(String player_name) {
			this.player_name = player_name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getNationality() {
			return nationality;
		}

		public void setNationality(String nationality) {
			this.nationality = nationality;
		}

		@Override
		public String toString() {
			return "Player [player_id=" + player_id + ", player_name=" + player_name + ", gender=" + gender + ", age="
					+ age + ", nationality=" + nationality + "]";
		}

		public Player() {
			super();
			
		}
    }

    public static class PlayerwiseStat {

        @JsonProperty("team_a")
        private List<PlayerStat> team_a;

        @JsonProperty("team_b")
        private List<PlayerStat> team_b;

		public List<PlayerStat> getTeam_a() {
			return team_a;
		}

		public void setTeam_a(List<PlayerStat> team_a) {
			this.team_a = team_a;
		}

		public List<PlayerStat> getTeam_b() {
			return team_b;
		}

		public void setTeam_b(List<PlayerStat> team_b) {
			this.team_b = team_b;
		}

		@Override
		public String toString() {
			return "PlayerwiseStat [team_a=" + team_a + ", team_b=" + team_b + "]";
		}

		public PlayerwiseStat() {
			super();
			
		}

    }

    public static class PlayerStat {

        @JsonProperty("player_name")
        private String player_name;

        @JsonProperty("player_id")
        private String player_id;

        @JsonProperty("mens_singles_points")
        private int mens_singles_points;

        @JsonProperty("mens_doubles_points")
        private int mens_doubles_points;

        @JsonProperty("womens_singles_points")
        private int womens_singles_points;

        @JsonProperty("womens_doubles_points")
        private int womens_doubles_points;

        @JsonProperty("total_points")
        private int total_points;

        @JsonProperty("aces")
        private int aces;

        @JsonProperty("winners")
        private int winners;

        @JsonProperty("unforced_errors")
        private int unforced_errors;

        @JsonProperty("double_faults")
        private int double_faults;

		public String getPlayer_name() {
			return player_name;
		}

		public void setPlayer_name(String player_name) {
			this.player_name = player_name;
		}

		public String getPlayer_id() {
			return player_id;
		}

		public void setPlayer_id(String player_id) {
			this.player_id = player_id;
		}

		public int getMens_singles_points() {
			return mens_singles_points;
		}

		public void setMens_singles_points(int mens_singles_points) {
			this.mens_singles_points = mens_singles_points;
		}

		public int getMens_doubles_points() {
			return mens_doubles_points;
		}

		public void setMens_doubles_points(int mens_doubles_points) {
			this.mens_doubles_points = mens_doubles_points;
		}

		public int getWomens_singles_points() {
			return womens_singles_points;
		}

		public void setWomens_singles_points(int womens_singles_points) {
			this.womens_singles_points = womens_singles_points;
		}

		public int getWomens_doubles_points() {
			return womens_doubles_points;
		}

		public void setWomens_doubles_points(int womens_doubles_points) {
			this.womens_doubles_points = womens_doubles_points;
		}

		public int getTotal_points() {
			return total_points;
		}

		public void setTotal_points(int total_points) {
			this.total_points = total_points;
		}

		public int getAces() {
			return aces;
		}

		public void setAces(int aces) {
			this.aces = aces;
		}

		public int getWinners() {
			return winners;
		}

		public void setWinners(int winners) {
			this.winners = winners;
		}

		public int getUnforced_errors() {
			return unforced_errors;
		}

		public void setUnforced_errors(int unforced_errors) {
			this.unforced_errors = unforced_errors;
		}

		public int getDouble_faults() {
			return double_faults;
		}

		public void setDouble_faults(int double_faults) {
			this.double_faults = double_faults;
		}

		@Override
		public String toString() {
			return "PlayerStat [player_name=" + player_name + ", player_id=" + player_id + ", mens_singles_points="
					+ mens_singles_points + ", mens_doubles_points=" + mens_doubles_points + ", womens_singles_points="
					+ womens_singles_points + ", womens_doubles_points=" + womens_doubles_points + ", total_points="
					+ total_points + ", aces=" + aces + ", winners=" + winners + ", unforced_errors=" + unforced_errors
					+ ", double_faults=" + double_faults + "]";
		}

		public PlayerStat() {
			super();
			
		}


    }

    public static class TeamwiseStat {

        @JsonProperty("team_a")
        private List<TeamStat> team_a;

        @JsonProperty("team_b")
        private List<TeamStat> team_b;

		public List<TeamStat> getTeam_a() {
			return team_a;
		}

		public void setTeam_a(List<TeamStat> team_a) {
			this.team_a = team_a;
		}

		public List<TeamStat> getTeam_b() {
			return team_b;
		}

		public void setTeam_b(List<TeamStat> team_b) {
			this.team_b = team_b;
		}

		@Override
		public String toString() {
			return "TeamwiseStat [team_a=" + team_a + ", team_b=" + team_b + "]";
		}

		public TeamwiseStat() {
			super();
			
		}


    }

    public static class TeamStat {

        @JsonProperty("team_name")
        private String team_name;

        @JsonProperty("team_id")
        private int team_id;

        @JsonProperty("total_points")
        private int total_points;

        @JsonProperty("aces")
        private int aces;

        @JsonProperty("winners")
        private int winners;

        @JsonProperty("unforced_errors")
        private int unforced_errors;

        @JsonProperty("double_faults")
        private int double_faults;

		public String getTeam_name() {
			return team_name;
		}

		public void setTeam_name(String team_name) {
			this.team_name = team_name;
		}

		public int getTeam_id() {
			return team_id;
		}

		public void setTeam_id(int team_id) {
			this.team_id = team_id;
		}

		public int getTotal_points() {
			return total_points;
		}

		public void setTotal_points(int total_points) {
			this.total_points = total_points;
		}

		public int getAces() {
			return aces;
		}

		public void setAces(int aces) {
			this.aces = aces;
		}

		public int getWinners() {
			return winners;
		}

		public void setWinners(int winners) {
			this.winners = winners;
		}

		public int getUnforced_errors() {
			return unforced_errors;
		}

		public void setUnforced_errors(int unforced_errors) {
			this.unforced_errors = unforced_errors;
		}

		public int getDouble_faults() {
			return double_faults;
		}

		public void setDouble_faults(int double_faults) {
			this.double_faults = double_faults;
		}

		@Override
		public String toString() {
			return "TeamStat [team_name=" + team_name + ", team_id=" + team_id + ", total_points=" + total_points
					+ ", aces=" + aces + ", winners=" + winners + ", unforced_errors=" + unforced_errors
					+ ", double_faults=" + double_faults + "]";
		}

		public TeamStat() {
			super();
			
		}

        
    }

    public static class LeaderBoard {

        @JsonProperty("leader_board")
        private List<TeamLeaderboard> leader_board;

		public List<TeamLeaderboard> getLeader_board() {
			return leader_board;
		}

		public void setLeader_board(List<TeamLeaderboard> leader_board) {
			this.leader_board = leader_board;
		}

		@Override
		public String toString() {
			return "LeaderBoard [leader_board=" + leader_board + "]";
		}

		public LeaderBoard() {
			super();
			
		}

        
    }

    public static class TeamLeaderboard {

        @JsonProperty("matches")
        private int matches;

        @JsonProperty("points")
        private int points;

        @JsonProperty("position")
        private int position;

        @JsonProperty("team")
        private String team;

        @JsonProperty("team_id")
        private int team_id;

		public int getMatches() {
			return matches;
		}

		public void setMatches(int matches) {
			this.matches = matches;
		}

		public int getPoints() {
			return points;
		}

		public void setPoints(int points) {
			this.points = points;
		}

		public int getPosition() {
			return position;
		}

		public void setPosition(int position) {
			this.position = position;
		}

		public String getTeam() {
			return team;
		}

		public void setTeam(String team) {
			this.team = team;
		}

		public int getTeam_id() {
			return team_id;
		}

		public void setTeam_id(int team_id) {
			this.team_id = team_id;
		}

		@Override
		public String toString() {
			return "TeamLeaderboard [matches=" + matches + ", points=" + points + ", position=" + position + ", team="
					+ team + ", team_id=" + team_id + "]";
		}

		public TeamLeaderboard() {
			super();
		}

        
    }
}
