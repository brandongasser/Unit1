package app;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String black = "black";
        String red = "red";
        String green = "green";

        int chips = 100;

        String colors[] = { green, red, black, red, black, red, black, red, black, red, black, black, red, black, red,
                black, red, black, red, red, black, red, black, red, black, red, black, red, black, black, red, black,
                red, black, red, black, red };
        String betLocations[] = new String[10];
        int betAmounts[] = new int[10];
        int betTotal = 0;
        int numBets = 0;

        boolean cashedOut = false;

        System.out.println("you have 100 chips");

        do {
            for (int i = 0; i < 10; i++) {
                numBets++;
                System.out.print("inside or outside?: ");
                String inOut = sc.nextLine();
                switch (inOut) {
                    case "inside":
                        System.out.print("what number?: ");
                        betLocations[i] = sc.nextLine();
                        break;
                    case "outside":
                        System.out.print("even, odd, black, or red?: ");
                        betLocations[i] = sc.nextLine();
                        break;
                    default:
                        break;
                }
                System.out.print("how much would you like to bet?: ");
                int betAmount = sc.nextInt();
                sc.nextLine();
                betTotal += betAmount;
                if (betTotal > chips) {
                    System.out.println("exceeded balance and forced to cash out with " + chips + " chips");
                    cashedOut = true;
                    break;
                } else {
                    betAmounts[i] = betAmount;
                }
                if (i != 9) {
                    System.out.print(
                            "would you like to place another bet? you have " + (10 - numBets) + " bets remaining: ");
                    String betAgain = sc.nextLine();
                    if (betAgain.equals("no")) {
                        break;
                    }
                }
            }
            if (!cashedOut) {
                System.out.println("spinning...");
                int rolledNumber = random.nextInt(37);
                String rolledColor = colors[rolledNumber];
                boolean rolledEven = rolledNumber % 2 == 0;
                System.out.println(rolledColor + " " + rolledNumber);
                if (rolledNumber == 0) {
                    System.out.println("rolled zero. all bets lose");
                    for (int i = 0; i < numBets; i++) {
                        chips -= betAmounts[i];
                    }
                } else {
                    for (int i = 0; i < numBets; i++) {
                        if (betLocations[i].equals("even")) {
                            if (rolledEven) {
                                System.out.println(
                                        "your bet of $" + betAmounts[i] + " on even was won (+$" + betAmounts[i] + ")");
                                chips += betAmounts[i];
                            } else {
                                System.out.println("your bet of $" + betAmounts[i] + " on even was lost (-$"
                                        + betAmounts[i] + ")");
                                chips -= betAmounts[i];
                            }
                        } else if (betLocations[i].equals("odd")) {
                            if (!rolledEven) {
                                System.out.println(
                                        "your bet of $" + betAmounts[i] + " on odd was won (+$" + betAmounts[i] + ")");
                                chips += betAmounts[i];
                            } else {
                                System.out.println(
                                        "your bet of $" + betAmounts[i] + " on odd was lost (-$" + betAmounts[i] + ")");
                                chips -= betAmounts[i];
                            }
                        } else if (betLocations[i].equals("red") || betLocations[i].equals("black")) {
                            if (betLocations[i].equals(rolledColor)) {
                                System.out.println("your bet of $" + betAmounts[i] + " on " + betLocations[i]
                                        + " was won (+$" + betAmounts[i] + ")");
                                chips += betAmounts[i];
                            } else {
                                System.out.println("your bet of $" + betAmounts[i] + " on " + betLocations[i]
                                        + " was lost (-$" + betAmounts[i] + ")");
                                chips -= betAmounts[i];
                            }
                        } else if (Integer.toString(rolledNumber).equals(betLocations[i])) {
                            System.out.println("your bet of $" + betAmounts[i] + " on " + betLocations[i]
                                    + " was won (+$" + (betAmounts[i] * 34) + ")");
                            chips += betAmounts[i] * 34;
                        } else {
                            System.out.println("your bet of $" + betAmounts[i] + " on " + betLocations[i]
                                    + " was lost (-$" + betAmounts[i] + ")");
                            chips -= betAmounts[i];
                        }
                    }
                }
                System.out.println("you have " + chips + " chips");
                System.out.print("would you like to play another round?: ");
                String playAgain = sc.nextLine();
                switch (playAgain) {
                    case "no":
                        cashedOut = true;
                        break;
                    default:
                        numBets = 0;
                        betTotal = 0;
                        break;
                }
            }
        } while (!cashedOut);
        System.out.println("you cashed out with " + chips + " chips");

    }

}
