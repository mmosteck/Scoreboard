package main;

import model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreboardTest {

    Team team1;
    Team team2;
    Scoreboard scoreboard;

    @BeforeEach
    void setUpData() {
       team1 = new Team("Germany");
       team2 = new Team("Brazil");
       scoreboard = new Scoreboard();
    }

    @Test
    void shouldStartGame() {
        scoreboard.startGame(team1, team2);

        assertEquals(1, scoreboard.getNumberOfRunningGames());
    }

    @Test
    void shouldNotStartAlreadyStartedGame() {
        scoreboard.startGame(team1, team2);
        scoreboard.startGame(team1, team2);

        assertEquals(1, scoreboard.getNumberOfRunningGames());
    }

    @Test
    void shouldFinishGame() {
        scoreboard.startGame(team1, team2);

        scoreboard.finishGame(team1);

        assertEquals(0, scoreboard.getNumberOfRunningGames());
    }

    @Test
    void shouldFinishGame_EitherTeam() {
        scoreboard.startGame(team1, team2);

        scoreboard.finishGame(team2);

        assertEquals(0, scoreboard.getNumberOfRunningGames());
    }

    @Test
    void shouldNotFinishFinishedGame() {
        scoreboard.startGame(team1, team2);

        scoreboard.finishGame(team2);
        scoreboard.finishGame(team1);

        assertEquals(0, scoreboard.getNumberOfRunningGames());
    }

    @Test
    void shouldUpdateScore_HomeTeam() {
        scoreboard.startGame(team1, team2);

        scoreboard.updateScore(team1);

        assertEquals("Germany - Brazil: 1 - 0", scoreboard.getGameScore(team1));
    }

    @Test
    void shouldUpdateScore_AwayTeam() {
        scoreboard.startGame(team1, team2);

        scoreboard.updateScore(team2);

        assertEquals("Germany - Brazil: 0 - 1", scoreboard.getGameScore(team1));
    }

    @Test
    void shouldUpdateScore_AwayTeamTwice() {
        scoreboard.startGame(team1, team2);

        scoreboard.updateScore(team2);
        scoreboard.updateScore(team2);

        assertEquals("Germany - Brazil: 0 - 2", scoreboard.getGameScore(team1));
    }

    @Test
    void shouldDisplaySummary() {
        var team3 = new Team("Argentina");
        var team4 = new Team("Uruguay");
        var team5 = new Team("England");
        var team6 = new Team("Scotland");

        scoreboard.startGame(team1, team2);
        scoreboard.startGame(team3, team4);
        scoreboard.startGame(team5, team6);

        scoreboard.updateScore(team1);
        scoreboard.updateScore(team2);
        scoreboard.updateScore(team3);
        scoreboard.updateScore(team5);
        scoreboard.updateScore(team5);
        scoreboard.updateScore(team5);

        assertEquals("""
                England - Scotland: 3 - 0
                Germany - Brazil: 1 - 1
                Argentina - Uruguay: 1 - 0
                """, scoreboard.getSummary());

    }

    @Test
    void shouldDisplaySummary_ProperSorting() {
        var team3 = new Team("Argentina");
        var team4 = new Team("Uruguay");
        var team5 = new Team("England");
        var team6 = new Team("Scotland");

        scoreboard.startGame(team1, team2);
        scoreboard.startGame(team3, team4);
        scoreboard.startGame(team5, team6);

        scoreboard.updateScore(team1);
        scoreboard.updateScore(team2);
        scoreboard.updateScore(team3);
        scoreboard.updateScore(team4);
        scoreboard.updateScore(team5);
        scoreboard.updateScore(team5);

        assertEquals("""
                England - Scotland: 2 - 0
                Argentina - Uruguay: 1 - 1
                Germany - Brazil: 1 - 1
                """, scoreboard.getSummary());
    }

    @Test
    void shouldDisplaySummary_EmptyScoreboard() {
        assertEquals("", scoreboard.getSummary());
    }
}
