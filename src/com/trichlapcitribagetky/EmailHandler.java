package com.trichlapcitribagetky;

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
        return RESULT_ERROR;
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
