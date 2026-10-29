import java.util.Scanner;

public class CardDeckDistribution {

    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
    };

    public static String[] initializeDeck() {
        int numOfCards = SUITS.length * RANKS.length;
        String[] deck = new String[numOfCards];
        int index = 0;

        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));

            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    public static String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        int totalCardsToDistribute = numPlayers * cardsPerPlayer;
        if (totalCardsToDistribute > deck.length) {
            System.err.println("Cannot distribute " + totalCardsToDistribute + " cards from a deck of " + deck.length + " cards!");
            return null;
        }

        String[][] players = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;

        for (int c = 0; c < cardsPerPlayer; c++) {
            for (int p = 0; p < numPlayers; p++) {
                players[p][c] = deck[cardIndex++];
            }
        }

        return players;
    }

    public static void printPlayerCards(String[][] players) {
        System.out.println("\n================ Distributed Cards ================");
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + "'s Hand (" + players[i].length + " cards):");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("   " + (j + 1) + ". " + players[i][j]);
            }
            System.out.println();
        }
        System.out.println("===================================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String[] deck = initializeDeck();
            System.out.println("Initialized a standard deck of " + deck.length + " cards.");

            shuffleDeck(deck);
            System.out.println("Deck shuffled successfully.");

            System.out.print("\nEnter number of players: ");
            int numPlayers = scanner.nextInt();

            System.out.print("Enter number of cards per player: ");
            int cardsPerPlayer = scanner.nextInt();

            if (numPlayers <= 0 || cardsPerPlayer <= 0) {
                System.err.println("Players and cards per player must be greater than 0.");
                return;
            }

            String[][] distributedHands = distributeCards(deck, numPlayers, cardsPerPlayer);
            if (distributedHands != null) {
                printPlayerCards(distributedHands);
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
