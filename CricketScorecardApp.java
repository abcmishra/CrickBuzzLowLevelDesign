import java.util.List;
import java.util.Scanner;

public class CricketScorecardApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Team 1
        System.out.print("Enter team name for Team 1: ");
        String team1Name = scanner.nextLine();
        System.out.print("Enter number of players in Team 1: ");
        int team1Players = scanner.nextInt();
        System.out.print("Enter number of overs: ");
        int overs = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter batting order for Team 1 (space-separated): ");
        List<String> team1BattingOrder = List.of(scanner.nextLine().split(" "));
        Team team1 = new Team(team1Name, team1BattingOrder);

        // Input for Team 2
        System.out.print("Enter team name for Team 2: ");
        String team2Name = scanner.nextLine();
        System.out.print("Enter batting order for Team 2 (space-separated): ");
        List<String> team2BattingOrder = List.of(scanner.nextLine().split(" "));
        Team team2 = new Team(team2Name, team2BattingOrder);

        // Play Match
        Match match = new Match(team1, team2, overs);
        System.out.println("Team 1 Innings:");
        match.playInnings(team1);
        System.out.println("Team 2 Innings:");
        match.playInnings(team2);

        // Determine Winner
        match.determineWinner();

        scanner.close();
    }
}
