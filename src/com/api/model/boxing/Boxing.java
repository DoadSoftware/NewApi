package com.api.model.boxing;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Boxing
{
    @JsonProperty("match_name")
    private String matchName;

    @JsonProperty("match_code")
    private String matchCode;

    @JsonProperty("bout_num")
    private int boutNum;

    @JsonProperty("ring_name")
    private String ringName;

    @JsonProperty("session_name")
    private String sessionName;

    @JsonProperty("red_boxer_name")
    private String redBoxerName;

    @JsonProperty("red_boxer_code")
    private String redBoxerCode;

    @JsonProperty("red_club")
    private String redClub;

    @JsonProperty("red_coach")
    private String redCoach;

    @JsonProperty("blue_boxer_name")
    private String blueBoxerName;

    @JsonProperty("blue_boxer_code")
    private String blueBoxerCode;

    @JsonProperty("blue_club")
    private String blueClub;

    @JsonProperty("blue_coach")
    private String blueCoach;

    @JsonProperty("division")
    private String division;

    @JsonProperty("referee_judge_name")
    private String refereeJudgeName;

    @JsonProperty("referee_judge_code")
    private String refereeJudgeCode;

    @JsonProperty("bout_status")
    private int boutStatus;

    @JsonProperty("win_reason")
    private String winReason;

    @JsonProperty("red_score")
    private int redScore;

    @JsonProperty("blue_score")
    private int blueScore;

    @JsonProperty("winner")
    private String winner;

    @JsonProperty("round_list")
    private List<Round> roundList;
    
    public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public String getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}

	public int getBoutNum() {
		return boutNum;
	}

	public void setBoutNum(int boutNum) {
		this.boutNum = boutNum;
	}

	public String getRingName() {
		return ringName;
	}

	public void setRingName(String ringName) {
		this.ringName = ringName;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public String getRedBoxerName() {
		return redBoxerName;
	}

	public void setRedBoxerName(String redBoxerName) {
		this.redBoxerName = redBoxerName;
	}

	public String getRedBoxerCode() {
		return redBoxerCode;
	}

	public void setRedBoxerCode(String redBoxerCode) {
		this.redBoxerCode = redBoxerCode;
	}

	public String getRedClub() {
		return redClub;
	}

	public void setRedClub(String redClub) {
		this.redClub = redClub;
	}

	public String getRedCoach() {
		return redCoach;
	}

	public void setRedCoach(String redCoach) {
		this.redCoach = redCoach;
	}

	public String getBlueBoxerName() {
		return blueBoxerName;
	}

	public void setBlueBoxerName(String blueBoxerName) {
		this.blueBoxerName = blueBoxerName;
	}

	public String getBlueBoxerCode() {
		return blueBoxerCode;
	}

	public void setBlueBoxerCode(String blueBoxerCode) {
		this.blueBoxerCode = blueBoxerCode;
	}

	public String getBlueClub() {
		return blueClub;
	}

	public void setBlueClub(String blueClub) {
		this.blueClub = blueClub;
	}

	public String getBlueCoach() {
		return blueCoach;
	}

	public void setBlueCoach(String blueCoach) {
		this.blueCoach = blueCoach;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getRefereeJudgeName() {
		return refereeJudgeName;
	}

	public void setRefereeJudgeName(String refereeJudgeName) {
		this.refereeJudgeName = refereeJudgeName;
	}

	public String getRefereeJudgeCode() {
		return refereeJudgeCode;
	}

	public void setRefereeJudgeCode(String refereeJudgeCode) {
		this.refereeJudgeCode = refereeJudgeCode;
	}

	public int getBoutStatus() {
		return boutStatus;
	}

	public void setBoutStatus(int boutStatus) {
		this.boutStatus = boutStatus;
	}

	public String getWinReason() {
		return winReason;
	}

	public void setWinReason(String winReason) {
		this.winReason = winReason;
	}

	public int getRedScore() {
		return redScore;
	}

	public void setRedScore(int redScore) {
		this.redScore = redScore;
	}

	public int getBlueScore() {
		return blueScore;
	}

	public void setBlueScore(int blueScore) {
		this.blueScore = blueScore;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public List<Round> getRoundList() {
		return roundList;
	}

	public void setRoundList(List<Round> roundList) {
		this.roundList = roundList;
	}

	public static class Round 
    {
        @JsonProperty("round_num")
        private int roundNum;

        @JsonProperty("tie_status")
        private int tieStatus;

        @JsonProperty("red_kd")
        private int redKd;

        @JsonProperty("blue_kd")
        private int blueKd;

        @JsonProperty("red_warn")
        private int redWarn;

        @JsonProperty("blue_warn")
        private int blueWarn;

        @JsonProperty("round_status")
        private int roundStatus;

        @JsonProperty("score_list")
        private List<Score> scoreList;

		public int getRoundNum() {
			return roundNum;
		}

		public void setRoundNum(int roundNum) {
			this.roundNum = roundNum;
		}

		public int getTieStatus() {
			return tieStatus;
		}

		public void setTieStatus(int tieStatus) {
			this.tieStatus = tieStatus;
		}

		public int getRedKd() {
			return redKd;
		}

		public void setRedKd(int redKd) {
			this.redKd = redKd;
		}

		public int getBlueKd() {
			return blueKd;
		}

		public void setBlueKd(int blueKd) {
			this.blueKd = blueKd;
		}

		public int getRedWarn() {
			return redWarn;
		}

		public void setRedWarn(int redWarn) {
			this.redWarn = redWarn;
		}

		public int getBlueWarn() {
			return blueWarn;
		}

		public void setBlueWarn(int blueWarn) {
			this.blueWarn = blueWarn;
		}

		public int getRoundStatus() {
			return roundStatus;
		}

		public void setRoundStatus(int roundStatus) {
			this.roundStatus = roundStatus;
		}

		public List<Score> getScoreList() {
			return scoreList;
		}

		public void setScoreList(List<Score> scoreList) {
			this.scoreList = scoreList;
		}

		@Override
		public String toString() {
			return "Round [roundNum=" + roundNum + ", tieStatus=" + tieStatus + ", redKd=" + redKd + ", blueKd="
					+ blueKd + ", redWarn=" + redWarn + ", blueWarn=" + blueWarn + ", roundStatus=" + roundStatus
					+ ", scoreList=" + scoreList + "]";
		}
        
    }
	
    public static class Score 
    {
        @JsonProperty("judge_name")
        private String judgeName;

        @JsonProperty("judge_num")
        private int judgeNum;

        @JsonProperty("judge_code")
        private String judgeCode;

        @JsonProperty("red_round_score")
        private int redRoundScore;

        @JsonProperty("blue_round_score")
        private int blueRoundScore;

		public String getJudgeName() {
			return judgeName;
		}

		public void setJudgeName(String judgeName) {
			this.judgeName = judgeName;
		}

		public int getJudgeNum() {
			return judgeNum;
		}

		public void setJudgeNum(int judgeNum) {
			this.judgeNum = judgeNum;
		}

		public String getJudgeCode() {
			return judgeCode;
		}

		public void setJudgeCode(String judgeCode) {
			this.judgeCode = judgeCode;
		}

		public int getRedRoundScore() {
			return redRoundScore;
		}

		public void setRedRoundScore(int redRoundScore) {
			this.redRoundScore = redRoundScore;
		}

		public int getBlueRoundScore() {
			return blueRoundScore;
		}

		public void setBlueRoundScore(int blueRoundScore) {
			this.blueRoundScore = blueRoundScore;
		}

		@Override
		public String toString() {
			return "Score [judgeName=" + judgeName + ", judgeNum=" + judgeNum + ", judgeCode=" + judgeCode
					+ ", redRoundScore=" + redRoundScore + ", blueRoundScore=" + blueRoundScore + "]";
		}
    }

	@Override
	public String toString() {
		return "Boxing [matchName=" + matchName + ", matchCode=" + matchCode + ", boutNum=" + boutNum + ", ringName="
				+ ringName + ", sessionName=" + sessionName + ", redBoxerName=" + redBoxerName + ", redBoxerCode="
				+ redBoxerCode + ", redClub=" + redClub + ", redCoach=" + redCoach + ", blueBoxerName=" + blueBoxerName
				+ ", blueBoxerCode=" + blueBoxerCode + ", blueClub=" + blueClub + ", blueCoach=" + blueCoach
				+ ", division=" + division + ", refereeJudgeName=" + refereeJudgeName + ", refereeJudgeCode="
				+ refereeJudgeCode + ", boutStatus=" + boutStatus + ", winReason=" + winReason + ", redScore="
				+ redScore + ", blueScore=" + blueScore + ", winner=" + winner + ", roundList=" + roundList + "]";
	}
    
}