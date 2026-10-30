package com.api.model.auction;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerMasterResponse {

    private boolean success;
    private String message;
    private Object header;
    private List<Player> data;

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Object getHeader() { return header; }
    public void setHeader(Object header) { this.header = header; }

    public List<Player> getData() { return data; }
    public void setData(List<Player> data) { this.data = data; }

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
        private Integer roundNo;

        @JsonProperty("RoundNumber")
        private Integer roundNumber;

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
        private Integer draftedTeamId;

        @JsonProperty("DraftedTeam")
        private String draftedTeam;

        @JsonProperty("stats")
        private List<PlayerStat> stats;

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

        public Integer getRoundNo() { return roundNo; }
        public void setRoundNo(Integer roundNo) { this.roundNo = roundNo; }

        public Integer getRoundNumber() { return roundNumber; }
        public void setRoundNumber(Integer roundNumber) { this.roundNumber = roundNumber; }

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

        public Integer getDraftedTeamId() { return draftedTeamId; }
        public void setDraftedTeamId(Integer draftedTeamId) { this.draftedTeamId = draftedTeamId; }

        public String getDraftedTeam() { return draftedTeam; }
        public void setDraftedTeam(String draftedTeam) { this.draftedTeam = draftedTeam; }

        public List<PlayerStat> getStats() { return stats; }
        public void setStats(List<PlayerStat> stats) { this.stats = stats; }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PlayerStat {
        @JsonProperty("Format")
        private String format;

        @JsonProperty("Matches")
        private String matches;

        @JsonProperty("Runs")
        private String runs;

        @JsonProperty("BatAvg")
        private String batAvg;

        @JsonProperty("BatSR")
        private String batSR;

        @JsonProperty("HighestScore")
        private String highestScore;

        @JsonProperty("Wickets")
        private String wickets;

        @JsonProperty("BowlAvg")
        private String bowlAvg;

        @JsonProperty("EconomyRate")
        private String economyRate;

        @JsonProperty("BestBowling")
        private String bestBowling;

        @JsonProperty("BowlSR")
        private String bowlSR;

        @JsonProperty("BattingInnings")
        private String battingInnings;

        @JsonProperty("BowlingInnings")
        private String bowlingInnings;

        @JsonProperty("BowlingBalls")
        private String bowlingBalls;

        @JsonProperty("BowlingRuns")
        private String bowlingRuns;

        @JsonProperty("ScoresAbove30")
        private String scoresAbove30;

        @JsonProperty("ThreePlusWicketHauls")
        private String threePlusWicketHauls;

        @JsonProperty("BallsPerWicket")
        private String ballsPerWicket;

        @JsonProperty("BowlingOvers")
        private String bowlingOvers;

        @JsonProperty("FiveWicketHauls")
        private String fiveWicketHauls;

        @JsonProperty("Catches")
        private String catches;

        @JsonProperty("Stumpings")
        private String stumpings;

        @JsonProperty("Fifties")
        private String fifties;

        @JsonProperty("Centuries")
        private String centuries;

        public String getFormat() { return format; }
        public void setFormat(String format) { this.format = format; }

        public String getMatches() { return matches; }
        public void setMatches(String matches) { this.matches = matches; }

        public String getRuns() { return runs; }
        public void setRuns(String runs) { this.runs = runs; }

        public String getBatAvg() { return batAvg; }
        public void setBatAvg(String batAvg) { this.batAvg = batAvg; }

        public String getBatSR() { return batSR; }
        public void setBatSR(String batSR) { this.batSR = batSR; }

        public String getHighestScore() { return highestScore; }
        public void setHighestScore(String highestScore) { this.highestScore = highestScore; }

        public String getWickets() { return wickets; }
        public void setWickets(String wickets) { this.wickets = wickets; }

        public String getBowlAvg() { return bowlAvg; }
        public void setBowlAvg(String bowlAvg) { this.bowlAvg = bowlAvg; }

        public String getEconomyRate() { return economyRate; }
        public void setEconomyRate(String economyRate) { this.economyRate = economyRate; }

        public String getBestBowling() { return bestBowling; }
        public void setBestBowling(String bestBowling) { this.bestBowling = bestBowling; }

        public String getBowlSR() { return bowlSR; }
        public void setBowlSR(String bowlSR) { this.bowlSR = bowlSR; }

        public String getBattingInnings() { return battingInnings; }
        public void setBattingInnings(String battingInnings) { this.battingInnings = battingInnings; }

        public String getBowlingInnings() { return bowlingInnings; }
        public void setBowlingInnings(String bowlingInnings) { this.bowlingInnings = bowlingInnings; }

        public String getBowlingBalls() { return bowlingBalls; }
        public void setBowlingBalls(String bowlingBalls) { this.bowlingBalls = bowlingBalls; }

        public String getBowlingRuns() { return bowlingRuns; }
        public void setBowlingRuns(String bowlingRuns) { this.bowlingRuns = bowlingRuns; }

        public String getScoresAbove30() { return scoresAbove30; }
        public void setScoresAbove30(String scoresAbove30) { this.scoresAbove30 = scoresAbove30; }

        public String getThreePlusWicketHauls() { return threePlusWicketHauls; }
        public void setThreePlusWicketHauls(String threePlusWicketHauls) { this.threePlusWicketHauls = threePlusWicketHauls; }

        public String getBallsPerWicket() { return ballsPerWicket; }
        public void setBallsPerWicket(String ballsPerWicket) { this.ballsPerWicket = ballsPerWicket; }

        public String getBowlingOvers() { return bowlingOvers; }
        public void setBowlingOvers(String bowlingOvers) { this.bowlingOvers = bowlingOvers; }

        public String getFiveWicketHauls() { return fiveWicketHauls; }
        public void setFiveWicketHauls(String fiveWicketHauls) { this.fiveWicketHauls = fiveWicketHauls; }

        public String getCatches() { return catches; }
        public void setCatches(String catches) { this.catches = catches; }

        public String getStumpings() { return stumpings; }
        public void setStumpings(String stumpings) { this.stumpings = stumpings; }

        public String getFifties() { return fifties; }
        public void setFifties(String fifties) { this.fifties = fifties; }

        public String getCenturies() { return centuries; }
        public void setCenturies(String centuries) { this.centuries = centuries; }
    }
}
