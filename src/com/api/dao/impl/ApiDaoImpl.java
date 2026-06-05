package com.api.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.api.dao.ApiDao;
import com.api.model.football.PlayersTable;
import com.api.model.football.TeamsTable;
import com.api.model.kadamba.Player;
import com.api.model.kadamba.Statistics;
import com.api.model.kadamba.Team;
import com.api.util.ApiUtil;

@Transactional
@Repository("apiDao")
public class ApiDaoImpl implements ApiDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Player getPlayer(String whatToProcess, String valueToProcess) {

        switch (whatToProcess) {

        case ApiUtil.PLAYER:

            return sessionFactory.getCurrentSession()
                    .createQuery(
                            "from Player where PlayerId = :playerId",
                            Player.class)
                    .setParameter("playerId", Integer.parseInt(valueToProcess))
                    .uniqueResult();

        default:
            return null;
        }
    }

    @Override
    public Team getTeam(String whatToProcess, String valueToProcess) {

        switch (whatToProcess) {

        case ApiUtil.TEAM:

            return sessionFactory.getCurrentSession()
                    .createQuery(
                            "from Team where TeamId = :teamId",
                            Team.class)
                    .setParameter("teamId", Integer.parseInt(valueToProcess))
                    .uniqueResult();

        default:
            return null;
        }
    }

    @Override
    public List<Team> getTeams() {

        return sessionFactory.getCurrentSession()
                .createQuery("from Team", Team.class)
                .getResultList();
    }

    @Override
    public List<Player> getPlayers(String whatToProcess, String valueToProcess) {

        switch (whatToProcess) {

        case ApiUtil.TEAM:

            return sessionFactory.getCurrentSession()
                    .createQuery(
                            "from Player where TeamId = :teamId",
                            Player.class)
                    .setParameter("teamId", Integer.parseInt(valueToProcess))
                    .getResultList();

        default:
            return null;
        }
    }

    @Override
    public List<Statistics> getAllStats() {

        return sessionFactory.getCurrentSession()
                .createQuery("from Statistics", Statistics.class)
                .getResultList();
    }

    @Override
    public List<Player> getAllPlayer() {

        return sessionFactory.getCurrentSession()
                .createQuery("from Player", Player.class)
                .getResultList();
    }

    @Override
    public PlayersTable getPlayerFromTable(String whatToProcess, String valueToProcess) {

        switch (whatToProcess) {

        case ApiUtil.PLAYER:

            return sessionFactory.getCurrentSession()
                    .createQuery(
                            "from PlayersTable where PlayerId = :playerId",
                            PlayersTable.class)
                    .setParameter("playerId", Integer.parseInt(valueToProcess))
                    .uniqueResult();

        default:
            return null;
        }
    }

    @Override
    public TeamsTable getTeamFromtable(String whatToProcess, String valueToProcess) {

        switch (whatToProcess) {

        case ApiUtil.TEAM:

            return sessionFactory.getCurrentSession()
                    .createQuery(
                            "from TeamsTable where TeamId = :teamId",
                            TeamsTable.class)
                    .setParameter("teamId", Integer.parseInt(valueToProcess))
                    .uniqueResult();

        default:
            return null;
        }
    }

    @Override
    public List<TeamsTable> getTeamsFromTable() {

        return sessionFactory.getCurrentSession()
                .createQuery("from TeamsTable", TeamsTable.class)
                .getResultList();
    }

    @Override
    public List<PlayersTable> getPlayersFromTable(String whatToProcess, String valueToProcess) {

        switch (whatToProcess) {

        case ApiUtil.TEAM:

            return sessionFactory.getCurrentSession()
                    .createQuery(
                            "from PlayersTable where TeamId = :teamId",
                            PlayersTable.class)
                    .setParameter("teamId", Integer.parseInt(valueToProcess))
                    .getResultList();

        default:
            return null;
        }
    }

    @Override
    public List<PlayersTable> getAllPlayers() {

        return sessionFactory.getCurrentSession()
                .createQuery("from PlayersTable", PlayersTable.class)
                .getResultList();
    }
}