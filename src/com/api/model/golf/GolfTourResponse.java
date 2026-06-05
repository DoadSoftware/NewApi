package com.api.model.golf;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GolfTourResponse {

    @JsonIgnore
    private boolean status;

    @JsonIgnore
    private String message;

    @JsonProperty("data")
    private List<Tour> data;

    // ✅ THIS CONSTRUCTOR HANDLES ROOT ARRAY
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public GolfTourResponse(List<Tour> data) {
        this.data = data;
    }

    // Default constructor (important)
    public GolfTourResponse() {
    }

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

    public List<Tour> getData() {
        return data;
    }

    public void setData(List<Tour> data) {
        this.data = data;
    }

    // ================= INNER CLASS =================

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Tour {

        @JsonProperty("tour_name")
        private String tourName;

        @JsonProperty("course_name")
        private String courseName;

        @JsonProperty("course_venue")
        private String courseVenue;

        @JsonProperty("tour_money")
        private String tourMoney;

        @JsonProperty("tour_sdt")
        private String tourStartDate;

        @JsonProperty("tour_edt")
        private String tourEndDate;

        @JsonProperty("tour_format")
        private String tourFormat;

        @JsonProperty("tour_pic")
        private String tourPic;

        public Tour() {
        }

        public String getTourName() {
            return tourName;
        }

        public void setTourName(String tourName) {
            this.tourName = tourName;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getCourseVenue() {
            return courseVenue;
        }

        public void setCourseVenue(String courseVenue) {
            this.courseVenue = courseVenue;
        }

        public String getTourMoney() {
            return tourMoney;
        }

        public void setTourMoney(String tourMoney) {
            this.tourMoney = tourMoney;
        }

        public String getTourStartDate() {
            return tourStartDate;
        }

        public void setTourStartDate(String tourStartDate) {
            this.tourStartDate = tourStartDate;
        }

        public String getTourEndDate() {
            return tourEndDate;
        }

        public void setTourEndDate(String tourEndDate) {
            this.tourEndDate = tourEndDate;
        }

        public String getTourFormat() {
            return tourFormat;
        }

        public void setTourFormat(String tourFormat) {
            this.tourFormat = tourFormat;
        }

        public String getTourPic() {
            return tourPic;
        }

        public void setTourPic(String tourPic) {
            this.tourPic = tourPic;
        }
    }
}
