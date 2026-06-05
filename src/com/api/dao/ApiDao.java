package com.api.dao;

import java.util.List;

import com.api.model.football.PlayersTable;
import com.api.model.football.TeamsTable;
import com.api.model.kadamba.*;

public interface ApiDao {
  Player getPlayer(String whatToProcess, String valueToProcess);
  Team getTeam(String whatToProcess, String valueToProcess);
  List<Player> getPlayers(String whatToProcess, String valueToProcess);
  List<Team> getTeams();
  List<Statistics> getAllStats();
  List<Player> getAllPlayer();
  PlayersTable getPlayerFromTable(String whatToProcess, String valueToProcess);
  TeamsTable getTeamFromtable(String whatToProcess, String valueToProcess);
  List<PlayersTable> getPlayersFromTable(String whatToProcess, String valueToProcess);
  List<TeamsTable> getTeamsFromTable();
  List<PlayersTable> getAllPlayers();
}