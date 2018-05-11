package com.trichlapcitribagetky;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

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

    public int vypisInfo(String pathName) {
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
                System.out.println(odosielatel);
            } else {
                return RESULT_ERROR;
            }

            String prijimatel;
            if (scanner.hasNextLine()) {
                prijimatel = scanner.nextLine();
                System.out.println(prijimatel);
            } else {
                return RESULT_ERROR;
            }

            int priorita;
            if (scanner.hasNextLine()) {
                try {
                    String s = scanner.nextLine();
                    System.out.println(s);
                    priorita = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    return RESULT_ERROR;
                }
            } else {
                return RESULT_ERROR;
            }

            float velkost;
            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                velkost = Float.parseFloat(s);
                System.out.println(velkost);
            } else {
                return RESULT_ERROR;
            }

            String datum;
            if (scanner.hasNextLine()) {
                datum = scanner.nextLine();
                System.out.println(datum);
            } else {
                return RESULT_ERROR;
            }


            float cas;
            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                cas = Float.parseFloat(s);
                System.out.println(cas);
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

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            } else break;
        }

        for (Email e : emails) {
            System.out.println(e);
        }

        return RESULT_OK;
    }

    public int najvacsiCas() {

        if (emails == null) {
            return RESULT_ERROR;
        }

        Date najstarsiDatum = Date.from(Instant.now());
        DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");

        float cas = 0f;

        for (Email email : emails) {

            if (email.getPriorita() == 0) {
                continue;
            }

            String novyDatumS = email.getDatum().substring(0, 2) + "/"
                    + email.getDatum().substring(2, 4) + "/"
                    + email.getDatum().substring(4, email.getDatum().length());
            Date novyDatum = null;
            try {
                novyDatum = sourceFormat.parse(novyDatumS);
            } catch (ParseException e) {
                System.out.println("Datum nebol spravne zadany");
                break;
            }


            if (najstarsiDatum.compareTo(novyDatum) > 0) {

                najstarsiDatum = novyDatum;
                cas = email.getCas();

            } else if (najstarsiDatum.compareTo(novyDatum) < 0) {

            } else if (najstarsiDatum.compareTo(novyDatum) == 0) {

                if (cas > email.getCas()) {
                    cas = email.getCas();
                }

            }
        }

        System.out.println(cas);
        return RESULT_OK;

    }


}

