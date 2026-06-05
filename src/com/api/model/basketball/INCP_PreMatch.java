package com.api.model.basketball;
import com.api.model.kadamba.Football_PointsTable.PointsTable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class INCP_PreMatch {

    @JsonProperty("Teams")
    private List<Team> teams;
    
    @JsonProperty("PointsTable")
    private List<PointsTable> pointsTable;
    // Getter and Setter for Teams
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    // Team class
    public static class Team {

        @JsonProperty("TeamID")
        private int teamId;

        @JsonProperty("TeamName")
        private String teamName;

        @JsonProperty("Players")
        private List<Player> players;

        // Constructor
        public Team(int teamId, String teamName, List<Player> players) {
            this.teamId = teamId;
            this.teamName = teamName;
            this.players = players;
        }

        // Getters and Setters for Team
        public int getTeamId() {
            return teamId;
        }

        public void setTeamId(int teamId) {
            this.teamId = teamId;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public void setPlayers(List<Player> players) {
            this.players = players;
        }

        public Team() {
			super();
			// TODO Auto-generated constructor stub
		}

		// Static Player class (Inner class)
        public static class Player {

            @JsonProperty("PlayerID")
            private int playerId;

            @JsonProperty("PlayerName")
            private String playerName;

            @JsonProperty("TeamID")
            private int teamId;

            @JsonProperty("TeamName")
            private String teamName;

            @JsonProperty("Total_Rebounds")
            private int totalRebounds;

            @JsonProperty("Assists")
            private int assists;

            @JsonProperty("Turnovers")
            private int turnovers;

            @JsonProperty("Steals")
            private int steals;

            @JsonProperty("Blocks")
            private int blocks;

            @JsonProperty("Personal_fouls")
            private int personalFouls;

            @JsonProperty("Points")
            private int points;

            @JsonProperty("Two_points_made")
            private int twoPointsMade;

            @JsonProperty("Two_points_attempt")
            private int twoPointsAttempt;

            @JsonProperty("Three_points_made")
            private int threePointsMade;

            @JsonProperty("Three_points_attempted")
            private int threePointsAttempted;
            
            @JsonProperty("AveragePoints")
            private double AveragePoints;
            
            // Constructor for Player
            public Player(int playerId, String playerName, int teamId, String teamName, int totalRebounds, int assists, int turnovers,
                          int steals, int blocks, int personalFouls, int points, int twoPointsMade, int twoPointsAttempt,
                          int threePointsMade, int threePointsAttempted) {
                this.playerId = playerId;
                this.playerName = playerName;
                this.teamId = teamId;
                this.teamName = teamName;
                this.totalRebounds = totalRebounds;
                this.assists = assists;
                this.turnovers = turnovers;
                this.steals = steals;
                this.blocks = blocks;
                this.personalFouls = personalFouls;
                this.points = points;
                this.twoPointsMade = twoPointsMade;
                this.twoPointsAttempt = twoPointsAttempt;
                this.threePointsMade = threePointsMade;
                this.threePointsAttempted = threePointsAttempted;
            }

            // Getters and Setters for Player
            public int getPlayerId() {
                return playerId;
            }

            public void setPlayerId(int playerId) {
                this.playerId = playerId;
            }

            public String getPlayerName() {
                return playerName;
            }

            public void setPlayerName(String playerName) {
                this.playerName = playerName;
            }

            public int getTeamId() {
                return teamId;
            }

            public void setTeamId(int teamId) {
                this.teamId = teamId;
            }

            public String getTeamName() {
                return teamName;
            }

            public void setTeamName(String teamName) {
                this.teamName = teamName;
            }

            public int getTotalRebounds() {
                return totalRebounds;
            }

            public void setTotalRebounds(int totalRebounds) {
                this.totalRebounds = totalRebounds;
            }

            public int getAssists() {
                return assists;
            }

            public void setAssists(int assists) {
                this.assists = assists;
            }

            public int getTurnovers() {
                return turnovers;
            }

            public void setTurnovers(int turnovers) {
                this.turnovers = turnovers;
            }

            public int getSteals() {
                return steals;
            }

            public void setSteals(int steals) {
                this.steals = steals;
            }

            public int getBlocks() {
                return blocks;
            }

            public void setBlocks(int blocks) {
                this.blocks = blocks;
            }

            public int getPersonalFouls() {
                return personalFouls;
            }

            public void setPersonalFouls(int personalFouls) {
                this.personalFouls = personalFouls;
            }

            public int getPoints() {
                return points;
            }

            public void setPoints(int points) {
                this.points = points;
            }

            public int getTwoPointsMade() {
                return twoPointsMade;
            }

            public void setTwoPointsMade(int twoPointsMade) {
                this.twoPointsMade = twoPointsMade;
            }

            public int getTwoPointsAttempt() {
                return twoPointsAttempt;
            }

            public void setTwoPointsAttempt(int twoPointsAttempt) {
                this.twoPointsAttempt = twoPointsAttempt;
            }

            public int getThreePointsMade() {
                return threePointsMade;
            }

            public void setThreePointsMade(int threePointsMade) {
                this.threePointsMade = threePointsMade;
            }

            public int getThreePointsAttempted() {
                return threePointsAttempted;
            }

            public void setThreePointsAttempted(int threePointsAttempted) {
                this.threePointsAttempted = threePointsAttempted;
            }

			public double getAveragePoints() {
				return AveragePoints;
			}

			public void setAveragePoints(double averagePoints) {
				AveragePoints = averagePoints;
			}

			public Player() {
				super();
				// TODO Auto-generated constructor stub
			}
            
        }
    }
}
