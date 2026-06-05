package com.api.model.basketball;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class INCP_SportEvent {
    @JsonProperty("sport_event")
    private SportEventDetails sportEvent;

    @JsonProperty("sport_event_status")
    private SportEventStatus sportEventStatus;

    @JsonProperty("statistics")
    private Statistics statistics;
    
    public INCP_SportEvent() {
		super();
		
	}

	public SportEventDetails getSportEvent() {
		return sportEvent;
	}

	public void setSportEvent(SportEventDetails sportEvent) {
		this.sportEvent = sportEvent;
	}

	public SportEventStatus getSportEventStatus() {
		return sportEventStatus;
	}

	public void setSportEventStatus(SportEventStatus sportEventStatus) {
		this.sportEventStatus = sportEventStatus;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	
	public static class SportEventDetails {
        @JsonProperty("id")
        private String id;
        
        @JsonProperty("matchdate_ist")
        private String matchdateIst;
        
        @JsonProperty("matchdate_local")
        private String matchdateLocal;
        
        @JsonProperty("matchdate_gmt")
        private String matchdateGmt;
        
        @JsonProperty("end_matchdate_ist")
        private String endMatchdateIst;
        
        @JsonProperty("end_matchdate_local")
        private String endMatchdateLocal;
        
        @JsonProperty("end_matchdate_gmt")
        private String endMatchdateGmt;
        
        @JsonProperty("start_time_ist")
        private String startTimeIst;
        
        @JsonProperty("start_time_local")
        private String startTimeLocal;
        
        @JsonProperty("start_time_gmt")
        private String startTimeGmt;
        
        @JsonProperty("end_matchtime_ist")
        private String endMatchtimeIst;
        
        @JsonProperty("end_matchtime_local")
        private String endMatchtimeLocal;
        
        @JsonProperty("end_matchtime_gmt")
        private String endMatchtimeGmt;
        
        @JsonProperty("gmt_offset")
        private String gmtOffset;

        @JsonProperty("venue")
        private Venue venue;

        @JsonProperty("competitors")
        private List<Competitor> competitors;

        public SportEventDetails() {
			super();
			
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getMatchdateIst() {
			return matchdateIst;
		}

		public void setMatchdateIst(String matchdateIst) {
			this.matchdateIst = matchdateIst;
		}

		public String getMatchdateLocal() {
			return matchdateLocal;
		}

		public void setMatchdateLocal(String matchdateLocal) {
			this.matchdateLocal = matchdateLocal;
		}

		public String getMatchdateGmt() {
			return matchdateGmt;
		}

		public void setMatchdateGmt(String matchdateGmt) {
			this.matchdateGmt = matchdateGmt;
		}

		public String getEndMatchdateIst() {
			return endMatchdateIst;
		}

		public void setEndMatchdateIst(String endMatchdateIst) {
			this.endMatchdateIst = endMatchdateIst;
		}

		public String getEndMatchdateLocal() {
			return endMatchdateLocal;
		}

		public void setEndMatchdateLocal(String endMatchdateLocal) {
			this.endMatchdateLocal = endMatchdateLocal;
		}

		public String getEndMatchdateGmt() {
			return endMatchdateGmt;
		}

		public void setEndMatchdateGmt(String endMatchdateGmt) {
			this.endMatchdateGmt = endMatchdateGmt;
		}

		public String getStartTimeIst() {
			return startTimeIst;
		}

		public void setStartTimeIst(String startTimeIst) {
			this.startTimeIst = startTimeIst;
		}

		public String getStartTimeLocal() {
			return startTimeLocal;
		}

		public void setStartTimeLocal(String startTimeLocal) {
			this.startTimeLocal = startTimeLocal;
		}

		public String getStartTimeGmt() {
			return startTimeGmt;
		}

		public void setStartTimeGmt(String startTimeGmt) {
			this.startTimeGmt = startTimeGmt;
		}

		public String getEndMatchtimeIst() {
			return endMatchtimeIst;
		}

		public void setEndMatchtimeIst(String endMatchtimeIst) {
			this.endMatchtimeIst = endMatchtimeIst;
		}

		public String getEndMatchtimeLocal() {
			return endMatchtimeLocal;
		}

		public void setEndMatchtimeLocal(String endMatchtimeLocal) {
			this.endMatchtimeLocal = endMatchtimeLocal;
		}

		public String getEndMatchtimeGmt() {
			return endMatchtimeGmt;
		}

		public void setEndMatchtimeGmt(String endMatchtimeGmt) {
			this.endMatchtimeGmt = endMatchtimeGmt;
		}

		public String getGmtOffset() {
			return gmtOffset;
		}

		public void setGmtOffset(String gmtOffset) {
			this.gmtOffset = gmtOffset;
		}

		public Venue getVenue() {
			return venue;
		}

		public void setVenue(Venue venue) {
			this.venue = venue;
		}

		public List<Competitor> getCompetitors() {
			return competitors;
		}

		public void setCompetitors(List<Competitor> competitors) {
			this.competitors = competitors;
		}
      
        
		public static class Venue {
            @JsonProperty("id")
            private String id;
            
            @JsonProperty("name")
            private String name;

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public Venue() {
				super();
				
			}
            
        }

        public static class Competitor {
            @JsonProperty("id")
            private String id;
            
            @JsonProperty("name")
            private String name;
            
            @JsonProperty("abbreviation")
            private String abbreviation;
            
            @JsonProperty("qualifier")
            private String qualifier;

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getAbbreviation() {
				return abbreviation;
			}

			public void setAbbreviation(String abbreviation) {
				this.abbreviation = abbreviation;
			}

			public String getQualifier() {
				return qualifier;
			}

			public void setQualifier(String qualifier) {
				this.qualifier = qualifier;
			}

			public Competitor() {
				super();
				
			}
            
        }
    }

    public static class SportEventStatus {
        @JsonProperty("status")
        private String status;
        
        @JsonProperty("home_score")
        private String homeScore;
        
        @JsonProperty("away_score")
        private String awayScore;
        
        @JsonProperty("clock")
        private String clock;
        
        @JsonProperty("quarter")
        private String quarter;
        
        @JsonProperty("home_scoring")
        private List<Scoring> homeScoring;
        
        @JsonProperty("away_scoring")
        private List<Scoring> awayScoring;
        
        public static class Scoring {
            @JsonProperty("type")
            private String type;
            
            @JsonProperty("number")
            private String number;
            
            @JsonProperty("sequence")
            private String sequence;
            
            @JsonProperty("points")
            private String points;

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getNumber() {
				return number;
			}

			public void setNumber(String number) {
				this.number = number;
			}

			public String getSequence() {
				return sequence;
			}

			public void setSequence(String sequence) {
				this.sequence = sequence;
			}

			public String getPoints() {
				return points;
			}

			public void setPoints(String points) {
				this.points = points;
			}

			public Scoring() {
				super();
				
			}
            
        }

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getHomeScore() {
			return homeScore;
		}

		public void setHomeScore(String homeScore) {
			this.homeScore = homeScore;
		}

		public String getAwayScore() {
			return awayScore;
		}

		public void setAwayScore(String awayScore) {
			this.awayScore = awayScore;
		}

		public String getClock() {
			return clock;
		}

		public void setClock(String clock) {
			this.clock = clock;
		}

		public String getQuarter() {
			return quarter;
		}

		public void setQuarter(String quarter) {
			this.quarter = quarter;
		}

		public List<Scoring> getHomeScoring() {
			return homeScoring;
		}

		public void setHomeScoring(List<Scoring> homeScoring) {
			this.homeScoring = homeScoring;
		}

		public List<Scoring> getAwayScoring() {
			return awayScoring;
		}

		public void setAwayScoring(List<Scoring> awayScoring) {
			this.awayScoring = awayScoring;
		}

		public SportEventStatus() {
			super();
			
		}
        
    }

    public static class Statistics {
        @JsonProperty("totals")
        private Totals totals;
        
        public Statistics() {
			super();
			
		}

		public Totals getTotals() {
			return totals;
		}

		public void setTotals(Totals totals) {
			this.totals = totals;
		}

		public static class Totals {
            @JsonProperty("competitors")
            private List<PlayerStatistics> competitors;
            
            @Override
			public String toString() {
				return "Totals [competitors=" + competitors + "]";
			}

			public List<PlayerStatistics> getCompetitors() {
				return competitors;
			}

			public void setCompetitors(List<PlayerStatistics> competitors) {
				this.competitors = competitors;
			}

			public static class PlayerStatistics {
                @JsonProperty("players")
                private List<Player> players;

                	
                public PlayerStatistics() {
					super();
					
				}
				public List<Player> getPlayers() {
					return players;
				}
				public void setPlayers(List<Player> players) {
					this.players = players;
				}
				public static class Player {
                    @JsonProperty("id")
                    private String id;
                    
                    @JsonProperty("Name")
                    private String name;
                    
                    @JsonProperty("jerseyNo")
                    private String jerseyNo;
                    
                    @JsonProperty("starter")
                    private int starter;
                    
                    @JsonProperty("is_substitute")
                    private int isSubstitute;
                    
                    @JsonProperty("position")
                    private String position;
                    
                    @JsonProperty("teamId")
                    private String teamId;
                    
                    @JsonProperty("teamName")
                    private String teamName;
                    
                    @JsonProperty("statistics")
                    private PlayerStats statistics;
                    
                    public Player() {
						super();
						
					}

					public String getId() {
						return id;
					}

					public void setId(String id) {
						this.id = id;
					}

					public String getName() {
						return name;
					}

					public void setName(String name) {
						this.name = name;
					}

					public String getJerseyNo() {
						return jerseyNo;
					}

					public void setJerseyNo(String jerseyNo) {
						this.jerseyNo = jerseyNo;
					}

					public int getStarter() {
						return starter;
					}

					public void setStarter(int starter) {
						this.starter = starter;
					}

					public int getIsSubstitute() {
						return isSubstitute;
					}

					public void setIsSubstitute(int isSubstitute) {
						this.isSubstitute = isSubstitute;
					}

					public String getPosition() {
						return position;
					}

					public void setPosition(String position) {
						this.position = position;
					}

					public String getTeamId() {
						return teamId;
					}

					public void setTeamId(String teamId) {
						this.teamId = teamId;
					}

					public String getTeamName() {
						return teamName;
					}

					public void setTeamName(String teamName) {
						this.teamName = teamName;
					}

					public PlayerStats getStatistics() {
						return statistics;
					}

					public void setStatistics(PlayerStats statistics) {
						this.statistics = statistics;
					}

					public static class PlayerStats {
                        @JsonProperty("minutes")
                        private String minutes;
                        
                        @JsonProperty("total_rebounds")
                        private int totalRebounds;
                        
                        @JsonProperty("assists")
                        private int assists;
                        
                        @JsonProperty("turnovers")
                        private int turnovers;
                        
                        @JsonProperty("steals")
                        private int steals;
                        
                        @JsonProperty("blocks")
                        private int blocks;
                        
                        @JsonProperty("personal_fouls")
                        private int personalFouls;
                        
                        @JsonProperty("two_points_made")
                        private int twoPointsMade;
                        
                        @JsonProperty("two_points_attempt")
                        private int twoPointsAttempt;
                        
                        @JsonProperty("two_points_percentage")
                        private double twoPointsPercentage;
                        
                        @JsonProperty("three_points_made")
                        private int threePointsMade;
                        
                        @JsonProperty("three_points_attempted")
                        private int threePointsAttempted;
                        
                        @JsonProperty("AveragePoints")
                        private double AveragePoints;
                        
                        @JsonProperty("three_points_percentage")
                        private double threePointsPercentage;
                        
                        @JsonProperty("points")
                        private int points;

						public PlayerStats() {
							super();
							
						}

						public String getMinutes() {
							return minutes;
						}

						public void setMinutes(String minutes) {
							this.minutes = minutes;
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

						public double getTwoPointsPercentage() {
							return twoPointsPercentage;
						}

						public void setTwoPointsPercentage(double twoPointsPercentage) {
							this.twoPointsPercentage = twoPointsPercentage;
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

						public double getThreePointsPercentage() {
							return threePointsPercentage;
						}

						public void setThreePointsPercentage(double threePointsPercentage) {
							this.threePointsPercentage = threePointsPercentage;
						}

						public int getPoints() {
							return points;
						}

						public void setPoints(int points) {
							this.points = points;
						}

						public double getAveragePoints() {
							return AveragePoints;
						}

						public void setAveragePoints(double averagePoints) {
							AveragePoints = averagePoints;
						}
                        
                    }
                }
            }
        }
    }
}
