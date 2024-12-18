import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;
    private final List<Player> players;
    private int totalScore;
    private int totalWickets;
    private int extras;
    private int ballsBowled;
    private Player striker;
    private Player nonStriker;

    public Team(String name, List<String> battingOrder) {
        this.name = name;
        this.players = new ArrayList<>();
        for (String playerName : battingOrder) {
            players.add(new Player(playerName));
        }
        this.totalScore = 0;
        this.totalWickets = 0;
        this.extras = 0;
        this.ballsBowled = 0;
        this.striker = players.get(0);
        this.nonStriker = players.get(1);
    }

    public void processBall(String input) {
        switch (input) {
            case "W":
                striker.setOut();
                totalWickets++;
                striker = getNextPlayer();
                break;
            case "Wd":
            case "Nb":
                extras++;
                totalScore++;
                break;
            default:
                int runs = Integer.parseInt(input);
                striker.addRuns(runs);
                striker.incrementBalls();
                totalScore += runs;

                // Strike change on odd runs
                if (runs % 2 != 0) {
                    swapStrikers();
                }
                break;
        }
        if (!input.equals("Wd") && !input.equals("Nb")) {
            ballsBowled++;
        }

        // Strike change at the end of over
        if (ballsBowled % 6 == 0) {
            swapStrikers();
        }
    }

    private void swapStrikers() {
        Player temp = striker;
        striker = nonStriker;
        nonStriker = temp;
    }

    private Player getNextPlayer() {
        for (Player player : players) {
            if (!player.isOut() && player != striker && player != nonStriker) {
                return player;
            }
        }
        return null;
    }

    public void printScorecard() {
        System.out.println("Scorecard for " + name + ":");
        System.out.printf("%-10s %-5s %-5s %-5s %-5s\n", "Player", "Score", "4s", "6s", "Balls");
        for (Player player : players) {
            System.out.println(player.getStats());
        }
        System.out.println("Total: " + totalScore + "/" + totalWickets);
        System.out.printf("Overs: %d.%d\n\n", ballsBowled / 6, ballsBowled % 6);
    }

    public int getTotalScore() {
        return totalScore;
    }

    public String getName(){
        return name;
    }
    public int getTotalWickets() {
        return totalWickets;
    }
}
