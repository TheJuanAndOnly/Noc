package com.trichlapcitribagetky;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
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

        System.out.println(emails.toString());

        return RESULT_OK;
    }
}
