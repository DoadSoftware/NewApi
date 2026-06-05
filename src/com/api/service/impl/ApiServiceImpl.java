package com.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.dao.ApiDao;
import com.api.model.football.PlayersTable;
import com.api.model.football.TeamsTable;
import com.api.model.kadamba.*;
import com.api.service.ApiService;

@Service("auctionService")
@Transactional
public class ApiServiceImpl implements ApiService {

 @Autowired
 private ApiDao auctionDao;
 
@Override
public Player getPlayer(String whatToProcess, String valueToProcess) {
	return auctionDao.getPlayer(whatToProcess, valueToProcess);
}

@Override
public Team getTeam(String whatToProcess, String valueToProcess) {
	return auctionDao.getTeam(whatToProcess, valueToProcess);
}

@Override
public List<Team> getTeams() {
	return auctionDao.getTeams();
}

@Override
public List<Player> getPlayers(String whatToProcess, String valueToProcess) {
	return auctionDao.getPlayers(whatToProcess, valueToProcess);
}

@Override
public List<Statistics> getAllStats() {
	return auctionDao.getAllStats();
}

@Override
public List<Player> getAllPlayer() {
	return auctionDao.getAllPlayer();
}

@Override
public PlayersTable getPlayerFromTable(String whatToProcess, String valueToProcess) {
	return auctionDao.getPlayerFromTable(whatToProcess, valueToProcess);
}

@Override
public TeamsTable getTeamFromtable(String whatToProcess, String valueToProcess) {
	return auctionDao.getTeamFromtable(whatToProcess, valueToProcess);
}

@Override
public List<TeamsTable> getTeamsFromTable() {
	return auctionDao.getTeamsFromTable();
}

@Override
public List<PlayersTable> getPlayersFromTable(String whatToProcess, String valueToProcess) {
	return auctionDao.getPlayersFromTable(whatToProcess, valueToProcess);
}

@Override
public List<PlayersTable> getAllPlayers() {
	return auctionDao.getAllPlayers();
}
}