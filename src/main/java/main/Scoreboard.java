package main;

import model.Game;
import model.Team;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Scoreboard {

    private final Set<Game> gameList = new LinkedHashSet<>();

    public void startGame(Team homeTeam, Team awayTeam) {
        var newGame = new Game(homeTeam, awayTeam);
        gameList.add(newGame);
    }

    public void finishGame(Team participant) {
        gameList.removeIf(game -> game.isParticipant(participant));
    }

    public void updateScore(Team participant) {
        gameList.stream()
                .filter(game -> game.isParticipant(participant))
                .findFirst()
                .ifPresent(game -> game.score(participant));
    }

    public String getSummary() {
        var summary = new StringBuilder();
        var sortedGameList = gameList.stream().sorted(Comparator.comparing(Game::getTotalScore, Comparator.reverseOrder()));
        sortedGameList.forEach(game -> summary.append(game).append("\n"));
        return summary.toString();
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
}
