public class Player {
    private final String name;
    private int runs;
    private int ballsFaced;
    private int fours;
    private int sixes;
    private boolean isOut;

    public Player(String name) {
        this.name = name;
        this.runs = 0;
        this.ballsFaced = 0;
        this.fours = 0;
        this.sixes = 0;
        this.isOut = false;
    }

    public String getName() {
        return name;
    }

    public void addRuns(int runs) {
        this.runs += runs;
        if (runs == 4) {
            this.fours++;
        } else if (runs == 6) {
            this.sixes++;
        }
    }

    public void incrementBalls() {
        this.ballsFaced++;
    }

    public void setOut() {
        this.isOut = true;
    }

    public boolean isOut() {
        return isOut;
    }

    public String getStats() {
        return String.format("%-10s %-5d %-5d %-5d %-5d %s",
                name, runs, fours, sixes, ballsFaced, isOut ? "" : "*");
    }
}
