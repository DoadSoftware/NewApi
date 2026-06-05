package com.api.model.golf;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GolfEntryListResponse {

    @JsonIgnore
    private boolean status;

    @JsonIgnore
    private String message;

    @JsonProperty("data")
    private List<Entry> data;

    // ✅ Handlesa ROOT JSON ARRAY
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public GolfEntryListResponse(List<Entry> data) {
        this.data = data;
    }

    // Default constructor (important)
    public GolfEntryListResponse() {
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

    public List<Entry> getData() {
        return data;
    }

    public void setData(List<Entry> data) {
        this.data = data;
    }

    // ================= INNER CLASS =================

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Entry {

        @JsonProperty("mem_code")
        private String memCode;

        @JsonProperty("tour_rank")
        private String tourRank;

        @JsonProperty("mem_scode")
        private String memScode;

        @JsonProperty("mem_name")
        private String memName;

        @JsonProperty("mem_nation")
        private String memNation;

        @JsonProperty("mem_country")
        private String memCountry;

        @JsonProperty("mem_catdesc")
        private String memCatdesc;

        @JsonProperty("tour_cut")
        private String tourCut;

        public Entry() {
        }

        public String getMemCode() {
            return memCode;
        }

        public void setMemCode(String memCode) {
            this.memCode = memCode;
        }

        public String getTourRank() {
            return tourRank;
        }

        public void setTourRank(String tourRank) {
            this.tourRank = tourRank;
        }

        public String getMemScode() {
            return memScode;
        }

        public void setMemScode(String memScode) {
            this.memScode = memScode;
        }

        public String getMemName() {
            return memName;
        }

        public void setMemName(String memName) {
            this.memName = memName;
        }

        public String getMemNation() {
            return memNation;
        }

        public void setMemNation(String memNation) {
            this.memNation = memNation;
        }

        public String getMemCountry() {
            return memCountry;
        }

        public void setMemCountry(String memCountry) {
            this.memCountry = memCountry;
        }

        public String getMemCatdesc() {
            return memCatdesc;
        }

        public void setMemCatdesc(String memCatdesc) {
            this.memCatdesc = memCatdesc;
        }

        public String getTourCut() {
            return tourCut;
        }

        public void setTourCut(String tourCut) {
            this.tourCut = tourCut;
        }
    }
}