package com.api.model.auction;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DraftPlayersResponse {

    private boolean success;
    private String message;
    private Object header;
    private DraftData data;

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Object getHeader() { return header; }
    public void setHeader(Object header) { this.header = header; }

    public DraftData getData() { return data; }
    public void setData(DraftData data) { this.data = data; }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DraftData {
        @JsonProperty("teamWise")
        private List<TeamGroup> teamWise;

        @JsonProperty("roundWise")
        private List<RoundGroup> roundWise;

        public List<TeamGroup> getTeamWise() { return teamWise; }
        public void setTeamWise(List<TeamGroup> teamWise) { this.teamWise = teamWise; }

        public List<RoundGroup> getRoundWise() { return roundWise; }
        public void setRoundWise(List<RoundGroup> roundWise) { this.roundWise = roundWise; }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TeamGroup {
        private int teamId;
        private String teamName;
        private List<Player> players;

        public int getTeamId() { return teamId; }
        public void setTeamId(int teamId) { this.teamId = teamId; }

        public String getTeamName() { return teamName; }
        public void setTeamName(String teamName) { this.teamName = teamName; }

        public List<Player> getPlayers() { return players; }
        public void setPlayers(List<Player> players) { this.players = players; }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RoundGroup {
        private int roundNo;
        private String roundName;
        private List<Player> players;

        public int getRoundNo() { return roundNo; }
        public void setRoundNo(int roundNo) { this.roundNo = roundNo; }

        public String getRoundName() { return roundName; }
        public void setRoundName(String roundName) { this.roundName = roundName; }

        public List<Player> getPlayers() { return players; }
        public void setPlayers(List<Player> players) { this.players = players; }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Player {
        @JsonProperty("RefPlayerId")
        private String refPlayerId;

        @JsonProperty("FSAId")
        private long fsaId;

        @JsonProperty("PlayerName")
        private String playerName;

        @JsonProperty("FirstName")
        private String firstName;

        @JsonProperty("ShortName")
        private String shortName;

        @JsonProperty("LastName")
        private String lastName;

        @JsonProperty("Age")
        private Integer age;

        @JsonProperty("Role")
        private String role;

        @JsonProperty("Category")
        private String category;

        @JsonProperty("Country")
        private String country;

        @JsonProperty("RoundNo")
        private int roundNo;

        @JsonProperty("RoundNumber")
        private int roundNumber;

        @JsonProperty("RoundName")
        private String roundName;

        @JsonProperty("Batting")
        private String batting;

        @JsonProperty("Bowling")
        private String bowling;

        @JsonProperty("BattingPrefix")
        private String battingPrefix;

        @JsonProperty("BowlingPrefix")
        private String bowlingPrefix;

        @JsonProperty("Achievements")
        private String achievements;

        @JsonProperty("Height")
        private String height;

        @JsonProperty("Weight")
        private String weight;

        @JsonProperty("Drafted")
        private int drafted;

        @JsonProperty("Status")
        private String status;

        @JsonProperty("DraftedTeamId")
        private int draftedTeamId;

        @JsonProperty("DraftedTeam")
        private String draftedTeam;

        public String getRefPlayerId() { return refPlayerId; }
        public void setRefPlayerId(String refPlayerId) { this.refPlayerId = refPlayerId; }

        public long getFsaId() { return fsaId; }
        public void setFsaId(long fsaId) { this.fsaId = fsaId; }

        public String getPlayerName() { return playerName; }
        public void setPlayerName(String playerName) { this.playerName = playerName; }

        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getShortName() { return shortName; }
        public void setShortName(String shortName) { this.shortName = shortName; }

        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }

        public Integer getAge() { return age; }
        public void setAge(Integer age) { this.age = age; }

        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }

        public String getCategory() { return category; }
        public void setCategory(String category) { this.category = category; }

        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }

        public int getRoundNo() { return roundNo; }
        public void setRoundNo(int roundNo) { this.roundNo = roundNo; }

        public int getRoundNumber() { return roundNumber; }
        public void setRoundNumber(int roundNumber) { this.roundNumber = roundNumber; }

        public String getRoundName() { return roundName; }
        public void setRoundName(String roundName) { this.roundName = roundName; }

        public String getBatting() { return batting; }
        public void setBatting(String batting) { this.batting = batting; }

        public String getBowling() { return bowling; }
        public void setBowling(String bowling) { this.bowling = bowling; }

        public String getBattingPrefix() { return battingPrefix; }
        public void setBattingPrefix(String battingPrefix) { this.battingPrefix = battingPrefix; }

        public String getBowlingPrefix() { return bowlingPrefix; }
        public void setBowlingPrefix(String bowlingPrefix) { this.bowlingPrefix = bowlingPrefix; }

        public String getAchievements() { return achievements; }
        public void setAchievements(String achievements) { this.achievements = achievements; }

        public String getHeight() { return height; }
        public void setHeight(String height) { this.height = height; }

        public String getWeight() { return weight; }
        public void setWeight(String weight) { this.weight = weight; }

        public int getDrafted() { return drafted; }
        public void setDrafted(int drafted) { this.drafted = drafted; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public int getDraftedTeamId() { return draftedTeamId; }
        public void setDraftedTeamId(int draftedTeamId) { this.draftedTeamId = draftedTeamId; }

        public String getDraftedTeam() { return draftedTeam; }
        public void setDraftedTeam(String draftedTeam) { this.draftedTeam = draftedTeam; }
    }
}
