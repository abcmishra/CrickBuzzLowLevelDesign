import java.util.List;

public class Match {
    private final Team team1;
    private final Team team2;
    private final int overs;

    public Match(Team team1, Team team2, int overs) {
        this.team1 = team1;
        this.team2 = team2;
        this.overs = overs;
    }

    public void playInnings(Team battingTeam) {
        for (int i = 0; i < overs; i++) {
            System.out.print("Over " + (i + 1) + ": ");
            String[] balls = System.console().readLine().split(" ");
            for (String ball : balls) {
                battingTeam.processBall(ball);
            }
            battingTeam.printScorecard();
        }
    }

    public void determineWinner() {
        int team1Score = team1.getTotalScore();
        int team2Score = team2.getTotalScore();

        System.out.println("Result:");
        if (team1Score > team2Score) {
            System.out.println(team1.getName() + " won by " + (team1Score - team2Score) + " runs.");
        } else if (team2Score > team1Score) {
            System.out.println(team2.getName() + " won by " + (11 - team2.getTotalWickets()) + " wickets.");
        } else {
            System.out.println("The match is a tie!");
        }
    }
}
