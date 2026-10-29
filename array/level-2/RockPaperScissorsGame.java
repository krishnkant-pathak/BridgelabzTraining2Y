import java.util.Scanner;

public class RockPaperScissorsGame {

    private static final String[] CHOICES = {"rock", "paper", "scissors"};

    public static String getComputerChoice() {
        int index = (int) (Math.random() * 3);
        return CHOICES[index];
    }

    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) {
            return "Tie";
        }

        if (userChoice.equalsIgnoreCase("rock")) {
            return computerChoice.equalsIgnoreCase("scissors") ? "User" : "Computer";
        } else if (userChoice.equalsIgnoreCase("paper")) {
            return computerChoice.equalsIgnoreCase("rock") ? "User" : "Computer";
        } else if (userChoice.equalsIgnoreCase("scissors")) {
            return computerChoice.equalsIgnoreCase("paper") ? "User" : "Computer";
        }

        return "Invalid";
    }

    public static String[][] calculateStats(int totalGames, int userWins, int computerWins, int ties) {
        double userWinPercentage = totalGames > 0 ? ((double) userWins / totalGames) * 100 : 0;
        double computerWinPercentage = totalGames > 0 ? ((double) computerWins / totalGames) * 100 : 0;
        double tiePercentage = totalGames > 0 ? ((double) ties / totalGames) * 100 : 0;

        return new String[][]{
                {"Total Games", String.valueOf(totalGames), "100.00%"},
                {"User Wins", String.valueOf(userWins), String.format("%.2f%%", userWinPercentage)},
                {"Computer Wins", String.valueOf(computerWins), String.format("%.2f%%", computerWinPercentage)},
                {"Ties", String.valueOf(ties), String.format("%.2f%%", tiePercentage)}
        };
    }

    public static void displayResults(String[][] gameHistory, String[][] stats) {
        System.out.println("\n================ Game History ================");
        System.out.printf("%-8s | %-12s | %-15s | %-10s%n", "Game #", "User Choice", "Computer Choice", "Winner");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < gameHistory.length; i++) {
            System.out.printf("Game %-3d | %-12s | %-15s | %-10s%n",
                    (i + 1), gameHistory[i][0], gameHistory[i][1], gameHistory[i][2]);
        }
        System.out.println("----------------------------------------------");

        System.out.println("\n================ Overall Stats ================");
        System.out.printf("%-18s | %-8s | %-12s%n", "Metric", "Count", "Percentage");
        System.out.println("-----------------------------------------------");
        for (String[] stat : stats) {
            System.out.printf("%-18s | %-8s | %-12s%n", stat[0], stat[1], stat[2]);
        }
        System.out.println("===============================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number of games you want to play: ");
            int totalGames = scanner.nextInt();

            if (totalGames <= 0) {
                System.err.println("Invalid number of games!");
                return;
            }

            String[][] gameHistory = new String[totalGames][3];
            int userWins = 0;
            int computerWins = 0;
            int ties = 0;

            for (int i = 0; i < totalGames; i++) {
                System.out.println("\nGame " + (i + 1) + " of " + totalGames + ":");
                System.out.print("Enter choice (rock, paper, or scissors): ");
                String userChoice = scanner.next().toLowerCase();

                while (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                    System.out.print("Invalid choice! Enter rock, paper, or scissors: ");
                    userChoice = scanner.next().toLowerCase();
                }

                String computerChoice = getComputerChoice();
                String winner = determineWinner(userChoice, computerChoice);

                System.out.println("Computer chose: " + computerChoice);
                System.out.println("Winner: " + winner);

                gameHistory[i][0] = userChoice;
                gameHistory[i][1] = computerChoice;
                gameHistory[i][2] = winner;

                if (winner.equals("User")) {
                    userWins++;
                } else if (winner.equals("Computer")) {
                    computerWins++;
                } else {
                    ties++;
                }
            }

            String[][] stats = calculateStats(totalGames, userWins, computerWins, ties);
            displayResults(gameHistory, stats);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
