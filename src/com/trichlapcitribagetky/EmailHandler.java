package com.trichlapcitribagetky;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Robert Gers on 11.05.2018.
 */
public class EmailHandler {
    public static final int RESULT_OK = 1;
    public static final int RESULT_ERROR = -1;

    private List<Email> emails;

    public int vypisInfo(String pathName){
        Scanner scanner;
        try {
            scanner = new Scanner(new FileReader(new File(pathName)));
            scanner.useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            return RESULT_ERROR;
        }

        emails = new ArrayList<>();

        while (scanner.hasNextLine()) {

            String odosielatel;
            if (scanner.hasNextLine()) {
                odosielatel = scanner.nextLine();
            } else {
                return RESULT_ERROR;
            }

            String prijimatel;
            if (scanner.hasNextLine()) {
                prijimatel = scanner.nextLine();
            } else {
                return RESULT_ERROR;
            }

            int priorita;
            if (scanner.hasNextLine()) {
                try {
                    String s = scanner.nextLine();
                    priorita = Integer.parseInt(s);
                } catch (NumberFormatException e){
                    return RESULT_ERROR;
                }
            } else {
                return RESULT_ERROR;
            }

            float velkost;
            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                velkost = Float.parseFloat(s);
            } else {
                return RESULT_ERROR;
            }

            String datum;
            if (scanner.hasNextLine()) {
                datum = scanner.nextLine();
            } else {
                return RESULT_ERROR;
            }


            float cas;
            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                cas = Float.parseFloat(s);
            } else {
                return RESULT_ERROR;
            }

            emails.add(
                    new Email(
                            odosielatel,
                            prijimatel,
                            priorita,
                            velkost,
                            datum,
                            cas
                    ));

            if (scanner.hasNextLine()){
                scanner.nextLine();
            } else break;
        }

        for (Email e : emails){
            System.out.println(e);
        }

        return RESULT_OK;
    }

    public float najvacsiCas() {
        String najstarsiDatum = "";
        float cas = 0f;
        for (Email email : emails) {
            if (email.getPriorita() == 1) {

            }
        }

        return cas;
    }
}
