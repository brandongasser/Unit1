package app;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int chips = 100;

        String betOneLocation;
        int betOneAmount;
        String betTwoLocation;
        int betTwoAmount;
        String betThreeLocation;
        int betThreeAmount;
        String betFourLocation;
        int betFourAmount;
        String betFiveLocation;
        int betFiveAmount;
        String betSixLocation;
        int betSixAmount;
        String betSevenLocation;
        int betSevenAmount;
        String betEightLocation;
        int betEightAmount;
        String betNineLocation;
        int betNineAmount;
        String betTenLocation;
        int betTenAmount;

        for (int i = 10; i > 0; i--) {

            int betAmount;
            String betLocation;

            System.out.print("inside or outside?: ");
            String inOut = sc.nextLine();
            switch (inOut) {
                case "inside":
                    System.out.print("what number?: ");
                    betLocation = sc.nextLine();
                    System.out.println("how much would you like to bet?: ");
                    betAmount = sc.nextInt();
                    switch (i) {
                        case 10:

                        case 9:

                        case 8:

                        case 7:

                        case 6:

                        case 5:
                    }
                    break;
                case "outside":
                    System.out.print("even, odd, black, or red?: ");
                    betLocation = sc.nextLine();
                    System.out.print("how much would you like to bet?: ");
                    betAmount = sc.nextInt();
                    break;
                default:
                    break;
            }

        }

    }

}