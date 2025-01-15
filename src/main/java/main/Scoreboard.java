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

    public void finishGame(Team participant) {
        gameList.removeIf(game -> game.isParticipant(participant));
    }

    public int getNumberOfRunningGames() {
        return gameList.size();
    }

    public String getGameScore(Team participant) {
        return gameList.stream()
                .filter(game -> game.isParticipant(participant))
                .map(Game::toString)
                .findFirst()
                .orElse("Scoreboard empty!");
    }

    public void updateScore(Team team1) {

    }
}
