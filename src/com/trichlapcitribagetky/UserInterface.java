package com.trichlapcitribagetky;

import java.util.Scanner;
import java.util.logging.Handler;

/**
 * Created by Robert Gers on 11.05.2018.
 */
public class UserInterface {

    public UserInterface() {
        Scanner input = new Scanner(System.in);

        EmailHandler handler = new EmailHandler();

        Loop:
        while (input.hasNext()){
            String s = input.next();

            switch (s){
                case "V":
                    handler.vypisInfo("data/EMAIL.txt");
                    break;

                case "C":
                    if (handler.najvacsiCas() == -1) {
                    System.out.println("Error, najskor treba vyvolat " + "V");
                    }
                    break;

                case "E":
                    System.out.println("Neimplementovane");
                    break;

                case "K":
                    break Loop;

                default:
                    System.out.println("Nespravny znak");
            }
        }

        input.close();
    }
}
