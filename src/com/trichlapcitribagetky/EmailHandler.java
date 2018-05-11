package com.trichlapcitribagetky;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        } catch (FileNotFoundException e) {
            return RESULT_ERROR;
        }

        emails = new ArrayList<>();

        while (scanner.hasNext()) {
            String odosielatel;
            if (scanner.hasNextLine()) {
                odosielatel = scanner.nextLine();
            } else return RESULT_ERROR;

            String prijimatel;
            if (scanner.hasNextLine()) {
                prijimatel = scanner.nextLine();
            } else return RESULT_ERROR;

            int priorita;
            if (scanner.hasNextInt()) {
                priorita = scanner.nextInt();
            } else return RESULT_ERROR;

            float velkost;
            if (scanner.hasNextFloat()) {
                velkost = scanner.nextFloat();
            } else return RESULT_ERROR;

            int datum;
            if (scanner.hasNextInt()) {
                datum = scanner.nextInt();
            } else return RESULT_ERROR;


            float cas;
            if (scanner.hasNextFloat()) {
                cas = scanner.nextFloat();
            } else return RESULT_ERROR;

            emails.add(
                    new Email(
                            odosielatel,
                            prijimatel,
                            priorita,
                            velkost,
                            datum,
                            cas
                    ));
        }

        return RESULT_OK;
    }

    public float najvacsiCas() {

        String najstarsiDatum;

        float cas = 0f;
        for (Email email : emails) {

            DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
            String novyDatumS = email.getDatum().substring(0,2) + "/" + email.getDatum().substring(2,4) + "/" + email.getDatum().substring(4, email.getDatum().length());
            String najstarsiDatumS = email.getDatum().substring(0,2) + "/" + email.getDatum().substring(2,4) + "/" + email.getDatum().substring(4, email.getDatum().length());

            Date staryDatum = (sourceFormat.parse(najstarsiDatumS)
            Date novyDatum = sourceFormat.parse(novyDatumS);



            if (date1.compareTo(date2) > 0) {
                System.out.println("Date1 is after Date2");
            } else if (date1.compareTo(date2) < 0) {
                System.out.println("Date1 is before Date2");
            } else if (date1.compareTo(date2) == 0) {
                System.out.println("Date1 is equal to Date2");
            } else {
                System.out.println("How to get here?");
            }

        }

        return cas;
    }



}

