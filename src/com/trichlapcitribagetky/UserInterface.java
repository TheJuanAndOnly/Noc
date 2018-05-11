package com.trichlapcitribagetky;

import java.util.Scanner;

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

                    break;

                case "E":

                    break;

                case "K":
                    break Loop;
            }
        }

        input.close();
    }
}
