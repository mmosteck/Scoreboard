package model;

import java.util.Objects;

public class Game {

    Team homeTeam;
    Team awayTeam;

    int homeTeamScore;
    int awayTeamScore;

    public Game(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
    }

    public boolean isParticipant(Team participant) {
        return homeTeam.equals(participant) || awayTeam.equals(participant);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(homeTeam, game.homeTeam) && Objects.equals(awayTeam, game.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam);
    }

    @Override
    public String toString() {
        return homeTeam + " - " + awayTeam + ": " + homeTeamScore + " - " + awayTeamScore;
    }
}
