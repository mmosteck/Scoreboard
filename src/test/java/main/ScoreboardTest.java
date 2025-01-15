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
        var scoreboard = new Scoreboard();
        scoreboard.startGame(team1, team2);

        scoreboard.finishGame(team1);

        assertEquals(0, scoreboard.getNumberOfRunningGames());
    }

    @Test
    void shouldFinishGame_EitherTeam() {
        var scoreboard = new Scoreboard();
        scoreboard.startGame(team1, team2);

        scoreboard.finishGame(team2);

        assertEquals(0, scoreboard.getNumberOfRunningGames());
    }

    @Test
    void shouldNotFinishFinishedGame() {
        var scoreboard = new Scoreboard();
        scoreboard.startGame(team1, team2);

        scoreboard.finishGame(team2);
        scoreboard.finishGame(team1);

        assertEquals(0, scoreboard.getNumberOfRunningGames());
    }

    @Test
    void shouldUpdateScore_HomeTeam() {
        var scoreboard = new Scoreboard();
        scoreboard.startGame(team1, team2);

        scoreboard.updateScore(team1);

        assertEquals("Germany - Brazil: 1 - 0", scoreboard.getGameScore(team1));
    }

    @Test
    void shouldUpdateScore_AwayTeam() {
        var scoreboard = new Scoreboard();
        scoreboard.startGame(team1, team2);

        scoreboard.updateScore(team2);

        assertEquals("Germany - Brazil: 0 - 1", scoreboard.getGameScore(team1));
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
