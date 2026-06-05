
package com.api.model.ispl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class player_Info {

    @JsonProperty("RaiderStat")
    private List<Raider> raiderStat;

    @JsonProperty("DefenderStat")
    private List<Defender> defenderStat;

    // =========================
    // GETTERS & SETTERS
    // =========================

    public List<Raider> getRaiderStat() {
        return raiderStat;
    }

    public void setRaiderStat(List<Raider> raiderStat) {
        this.raiderStat = raiderStat;
    }

    public List<Defender> getDefenderStat() {
        return defenderStat;
    }

    public void setDefenderStat(List<Defender> defenderStat) {
        this.defenderStat = defenderStat;
    }

    // =========================
    // INNER CLASS : RAIDER
    // =========================
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Raider {

        @JsonProperty("RaiderId")
        private Integer raiderId;

        @JsonProperty("RaiderName")
        private String raiderName;

        @JsonProperty("TeamId")
        private Integer teamId;

        @JsonProperty("TeamName")
        private String teamName;

        @JsonProperty("RaidPoints")
        private Integer raidPoints;

        @JsonProperty("RaidSR")
        private Integer raidSR;

        public Integer getRaiderId() {
            return raiderId;
        }

        public void setRaiderId(Integer raiderId) {
            this.raiderId = raiderId;
        }

        public String getRaiderName() {
            return raiderName;
        }

        public void setRaiderName(String raiderName) {
            this.raiderName = raiderName;
        }

        public Integer getTeamId() {
            return teamId;
        }

        public void setTeamId(Integer teamId) {
            this.teamId = teamId;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public Integer getRaidPoints() {
            return raidPoints;
        }

        public void setRaidPoints(Integer raidPoints) {
            this.raidPoints = raidPoints;
        }

        public Integer getRaidSR() {
            return raidSR;
        }

        public void setRaidSR(Integer raidSR) {
            this.raidSR = raidSR;
        }
    }

    // =========================
    // INNER CLASS : DEFENDER
    // =========================
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Defender {

        @JsonProperty("DefenderId")
        private Integer defenderId;

        @JsonProperty("DefenderName")
        private String defenderName;

        @JsonProperty("TeamId")
        private Integer teamId;

        @JsonProperty("TeamName")
        private String teamName;

        @JsonProperty("TacklePoints")
        private Integer tacklePoints;

        @JsonProperty("TackleSR")
        private Integer tackleSR;

        public Integer getDefenderId() {
            return defenderId;
        }

        public void setDefenderId(Integer defenderId) {
            this.defenderId = defenderId;
        }

        public String getDefenderName() {
            return defenderName;
        }

        public void setDefenderName(String defenderName) {
            this.defenderName = defenderName;
        }

        public Integer getTeamId() {
            return teamId;
        }

        public void setTeamId(Integer teamId) {
            this.teamId = teamId;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public Integer getTacklePoints() {
            return tacklePoints;
        }

        public void setTacklePoints(Integer tacklePoints) {
            this.tacklePoints = tacklePoints;
        }

        public Integer getTackleSR() {
            return tackleSR;
        }

        public void setTackleSR(Integer tackleSR) {
            this.tackleSR = tackleSR;
        }
    }
}
