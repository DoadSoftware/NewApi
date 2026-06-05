package com.api.model.golf;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GolfCourseResponse {

    @JsonIgnore
    private boolean status;

    @JsonIgnore
    private String message;

    @JsonProperty("data")
    private List<Course> data;

    // ✅ Handles ROOT JSON ARRAY
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public GolfCourseResponse(List<Course> data) {
        this.data = data;
    }

    public GolfCourseResponse() {
    }

    // ================= GETTERS & SETTERS =================

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Course> getData() {
        return data;
    }

    public void setData(List<Course> data) {
        this.data = data;
    }

    // ================= INNER CLASS =================

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Course {

        @JsonProperty("course_id")
        private String courseId;

        @JsonProperty("course_name")
        private String courseName;

        // ================= Par (P1 - P18) =================
        @JsonProperty("p1") private String p1;
        @JsonProperty("p2") private String p2;
        @JsonProperty("p3") private String p3;
        @JsonProperty("p4") private String p4;
        @JsonProperty("p5") private String p5;
        @JsonProperty("p6") private String p6;
        @JsonProperty("p7") private String p7;
        @JsonProperty("p8") private String p8;
        @JsonProperty("p9") private String p9;
        @JsonProperty("p10") private String p10;
        @JsonProperty("p11") private String p11;
        @JsonProperty("p12") private String p12;
        @JsonProperty("p13") private String p13;
        @JsonProperty("p14") private String p14;
        @JsonProperty("p15") private String p15;
        @JsonProperty("p16") private String p16;
        @JsonProperty("p17") private String p17;
        @JsonProperty("p18") private String p18;

        @JsonProperty("pin") private String pin;
        @JsonProperty("pout") private String pout;
        @JsonProperty("ptot") private String ptot;
        @JsonProperty("phole") private String phole;

        // ================= Yellow Tees =================
        @JsonProperty("y1") private String y1;
        @JsonProperty("y2") private String y2;
        @JsonProperty("y3") private String y3;
        @JsonProperty("y4") private String y4;
        @JsonProperty("y5") private String y5;
        @JsonProperty("y6") private String y6;
        @JsonProperty("y7") private String y7;
        @JsonProperty("y8") private String y8;
        @JsonProperty("y9") private String y9;
        @JsonProperty("y10") private String y10;
        @JsonProperty("y11") private String y11;
        @JsonProperty("y12") private String y12;
        @JsonProperty("y13") private String y13;
        @JsonProperty("y14") private String y14;
        @JsonProperty("y15") private String y15;
        @JsonProperty("y16") private String y16;
        @JsonProperty("y17") private String y17;
        @JsonProperty("y18") private String y18;

        @JsonProperty("yin") private String yin;
        @JsonProperty("yout") private String yout;
        @JsonProperty("ytot") private String ytot;

        // ================= Silver Tees =================
        @JsonProperty("s1") private String s1;
        @JsonProperty("s2") private String s2;
        @JsonProperty("s3") private String s3;
        @JsonProperty("s4") private String s4;
        @JsonProperty("s5") private String s5;
        @JsonProperty("s6") private String s6;
        @JsonProperty("s7") private String s7;
        @JsonProperty("s8") private String s8;
        @JsonProperty("s9") private String s9;
        @JsonProperty("s10") private String s10;
        @JsonProperty("s11") private String s11;
        @JsonProperty("s12") private String s12;
        @JsonProperty("s13") private String s13;
        @JsonProperty("s14") private String s14;
        @JsonProperty("s15") private String s15;
        @JsonProperty("s16") private String s16;
        @JsonProperty("s17") private String s17;
        @JsonProperty("s18") private String s18;

        @JsonProperty("sin") private String sin;
        @JsonProperty("sout") private String sout;
        @JsonProperty("stot") private String stot;

        @JsonProperty("t1") private String t1;
        @JsonProperty("t2") private String t2;
        @JsonProperty("t3") private String t3;
        @JsonProperty("t4") private String t4;
        @JsonProperty("t5") private String t5;
        @JsonProperty("t6") private String t6;
        @JsonProperty("t7") private String t7;
        @JsonProperty("t8") private String t8;
        @JsonProperty("t9") private String t9;
        @JsonProperty("t10") private String t10;
        @JsonProperty("t11") private String t11;
        @JsonProperty("t12") private String t12;
        @JsonProperty("t13") private String t13;
        @JsonProperty("t14") private String t14;
        @JsonProperty("t15") private String t15;
        @JsonProperty("t16") private String t16;
        @JsonProperty("t17") private String t17;
        @JsonProperty("t18") private String t18;

        @JsonProperty("tin") private String tin;
        @JsonProperty("tout") private String tout;
        @JsonProperty("ttot") private String ttot;


        public String getCourseId() { return courseId; }
        public void setCourseId(String courseId) { this.courseId = courseId; }

        public String getCourseName() { return courseName; }
        public void setCourseName(String courseName) { this.courseName = courseName; }

        // (Other getters & setters remain same as your original — no change needed)
    }
}