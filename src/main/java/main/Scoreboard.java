package main;

import model.Game;
import model.Team;

import java.util.HashSet;
import java.util.Set;

public class Scoreboard {

    private final Set<Game> gameList = new HashSet<>();

    public void startGame(Team homeTeam, Team awayTeam) {
        var newGame = new Game(homeTeam, awayTeam);
        gameList.add(newGame);
    }

    public int getNumberOfRunningGames() {
        return gameList.size();
    }
}
