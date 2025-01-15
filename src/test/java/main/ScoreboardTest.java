package main;

import model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreboardTest {

    Team team1;
    Team team2;

    @BeforeEach
    void setUpData() {
       team1 = new Team("Germany");
       team2 = new Team("Brazil");
    }

    @Test
    void shouldStartGame() {
        var scoreboard = new Scoreboard();

        scoreboard.startGame(team1, team2);

        assertEquals(1, scoreboard.getNumberOfRunningGames());
    }

    @Test
    void shouldNotStartAlreadyStartedGame() {
        var scoreboard = new Scoreboard();

        scoreboard.startGame(team1, team2);
        scoreboard.startGame(team1, team2);

        assertEquals(1, scoreboard.getNumberOfRunningGames());
    }

    @Test
    void shouldFinishGame() {

    }

    @Test
    void shouldNotFinishFinishedGame() {

    }

    @Test
    void shouldUpdateScore_HomeTeam() {

    }

    @Test
    void shouldUpdateScore_AwayTeam() {

    }

    @Test
    void shouldDisplaySummary() {

    }

    @Test
    void shouldDisplaySummary_ProperSorting() {

    }

    @Test
    void shouldDisplaySummary_EmptyScoreboard() {

    }
}
