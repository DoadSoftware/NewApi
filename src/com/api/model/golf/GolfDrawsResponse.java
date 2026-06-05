package com.api.model.golf;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GolfDrawsResponse {

    @JsonProperty("data")
    private List<DrawPlayer> data;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public GolfDrawsResponse(List<DrawPlayer> data) {
        this.data = data;
    }

    public GolfDrawsResponse() {
    }

    public List<DrawPlayer> getData() {
        return data;
    }

    public void setData(List<DrawPlayer> data) {
        this.data = data;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DrawPlayer {

        @JsonProperty("tour_day")
        private String tourDay;

        @JsonProperty("tour_srno")
        private String tourSrno;

        @JsonProperty("tour_player")
        private String tourPlayer;

        @JsonProperty("course_id")
        private String courseId;

        @JsonProperty("tee_no")
        private String teeNo;

        @JsonProperty("tee_time")
        private String teeTime;

        @JsonProperty("mem_code")
        private String memCode;

        @JsonProperty("mem_scode")
        private String memScode;

        @JsonProperty("mem_name")
        private String memName;

        @JsonProperty("mem_nation")
        private String memNation;

        @JsonProperty("mem_country")
        private String memCountry;

        public String getTourDay() { return tourDay; }
        public void setTourDay(String tourDay) { this.tourDay = tourDay; }

        public String getTourSrno() { return tourSrno; }
        public void setTourSrno(String tourSrno) { this.tourSrno = tourSrno; }

        public String getTourPlayer() { return tourPlayer; }
        public void setTourPlayer(String tourPlayer) { this.tourPlayer = tourPlayer; }

        public String getCourseId() { return courseId; }
        public void setCourseId(String courseId) { this.courseId = courseId; }

        public String getTeeNo() { return teeNo; }
        public void setTeeNo(String teeNo) { this.teeNo = teeNo; }

        public String getTeeTime() { return teeTime; }
        public void setTeeTime(String teeTime) { this.teeTime = teeTime; }

        public String getMemCode() { return memCode; }
        public void setMemCode(String memCode) { this.memCode = memCode; }

        public String getMemScode() { return memScode; }
        public void setMemScode(String memScode) { this.memScode = memScode; }

        public String getMemName() { return memName; }
        public void setMemName(String memName) { this.memName = memName; }

        public String getMemNation() { return memNation; }
        public void setMemNation(String memNation) { this.memNation = memNation; }

        public String getMemCountry() { return memCountry; }
        public void setMemCountry(String memCountry) { this.memCountry = memCountry; }

        @Override
        public String toString() {
            return "DrawPlayer [tourDay=" + tourDay + ", tourSrno=" + tourSrno + ", tourPlayer=" + tourPlayer
                    + ", courseId=" + courseId + ", teeNo=" + teeNo + ", teeTime=" + teeTime
                    + ", memCode=" + memCode + ", memScode=" + memScode + ", memName=" + memName
                    + ", memNation=" + memNation + ", memCountry=" + memCountry + "]";
        }
    }
}