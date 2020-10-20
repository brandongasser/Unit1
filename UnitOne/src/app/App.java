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

        String colors[] = {green, red, black, red, black, red, black, red, black, red, black, black, red, black, red, black, red, black, red, red, black, red, black, red, black, red, black, red, black, black, red, black, red, black, red, black, red};
        String betLocations[] = new String[10];
        int betAmounts[] = new int[10];

        for (int i = 0; i < 10; i++) {
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
            betAmounts[i] = sc.nextInt();
        }

    }

}