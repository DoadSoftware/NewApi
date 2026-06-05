package com.api.model.golf;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GolfScoresResponse {

    @JsonProperty("data")
    private List<PlayerScore> data;

    // ✅ Handles root JSON array
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public GolfScoresResponse(List<PlayerScore> data) {
        this.data = data;
    }

    public GolfScoresResponse() {
    }

    public List<PlayerScore> getData() {
        return data;
    }

    public void setData(List<PlayerScore> data) {
        this.data = data;
    }

    // ================= INNER CLASS =================

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PlayerScore {

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

        // Hole scores
        private String s1;
        private String s2;
        private String s3;
        private String s4;
        private String s5;
        private String s6;
        private String s7;
        private String s8;
        private String s9;
        private String s10;
        private String s11;
        private String s12;
        private String s13;
        private String s14;
        private String s15;
        private String s16;
        private String s17;
        private String s18;

        private String sin;
        private String sout;

        private String sd1;
        private String sd2;
        private String sd3;
        private String sd4;

        private String pd1;
        private String pd2;
        private String pd3;
        private String pd4;

        private String score;
        private String score_stat;
        private String score_sr;
        private String hole;
        private String prt_flag;
        private String score_tm;

        // ======== GETTERS & SETTERS ========

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

        public String getS1() { return s1; }
        public void setS1(String s1) { this.s1 = s1; }

        public String getS2() { return s2; }
        public void setS2(String s2) { this.s2 = s2; }

        public String getS3() { return s3; }
        public void setS3(String s3) { this.s3 = s3; }

        public String getS4() { return s4; }
        public void setS4(String s4) { this.s4 = s4; }

        public String getS5() { return s5; }
        public void setS5(String s5) { this.s5 = s5; }

        public String getS6() { return s6; }
        public void setS6(String s6) { this.s6 = s6; }

        public String getS7() { return s7; }
        public void setS7(String s7) { this.s7 = s7; }

        public String getS8() { return s8; }
        public void setS8(String s8) { this.s8 = s8; }

        public String getS9() { return s9; }
        public void setS9(String s9) { this.s9 = s9; }

        public String getS10() { return s10; }
        public void setS10(String s10) { this.s10 = s10; }

        public String getS11() { return s11; }
        public void setS11(String s11) { this.s11 = s11; }

        public String getS12() { return s12; }
        public void setS12(String s12) { this.s12 = s12; }

        public String getS13() { return s13; }
        public void setS13(String s13) { this.s13 = s13; }

        public String getS14() { return s14; }
        public void setS14(String s14) { this.s14 = s14; }

        public String getS15() { return s15; }
        public void setS15(String s15) { this.s15 = s15; }

        public String getS16() { return s16; }
        public void setS16(String s16) { this.s16 = s16; }

        public String getS17() { return s17; }
        public void setS17(String s17) { this.s17 = s17; }

        public String getS18() { return s18; }
        public void setS18(String s18) { this.s18 = s18; }

        public String getSin() { return sin; }
        public void setSin(String sin) { this.sin = sin; }

        public String getSout() { return sout; }
        public void setSout(String sout) { this.sout = sout; }

        public String getSd1() { return sd1; }
        public void setSd1(String sd1) { this.sd1 = sd1; }

        public String getSd2() { return sd2; }
        public void setSd2(String sd2) { this.sd2 = sd2; }

        public String getSd3() { return sd3; }
        public void setSd3(String sd3) { this.sd3 = sd3; }

        public String getSd4() { return sd4; }
        public void setSd4(String sd4) { this.sd4 = sd4; }

        public String getPd1() { return pd1; }
        public void setPd1(String pd1) { this.pd1 = pd1; }

        public String getPd2() { return pd2; }
        public void setPd2(String pd2) { this.pd2 = pd2; }

        public String getPd3() { return pd3; }
        public void setPd3(String pd3) { this.pd3 = pd3; }

        public String getPd4() { return pd4; }
        public void setPd4(String pd4) { this.pd4 = pd4; }

        public String getScore() { return score; }
        public void setScore(String score) { this.score = score; }

        public String getScore_stat() { return score_stat; }
        public void setScore_stat(String score_stat) { this.score_stat = score_stat; }

        public String getScore_sr() { return score_sr; }
        public void setScore_sr(String score_sr) { this.score_sr = score_sr; }

        public String getHole() { return hole; }
        public void setHole(String hole) { this.hole = hole; }

        public String getPrt_flag() { return prt_flag; }
        public void setPrt_flag(String prt_flag) { this.prt_flag = prt_flag; }

        public String getScore_tm() { return score_tm; }
        public void setScore_tm(String score_tm) { this.score_tm = score_tm; }
    }
}

