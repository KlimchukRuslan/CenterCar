package com.centercity.server.gsheet;

import com.centercity.server.entity.STOWork;
import com.centercity.server.entity.TransferCar;
import com.centercity.server.tempobj.Employee;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SheetsGoogle {

    private static final String APPLICATION_NAME = "Center City";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "/opt/tomcat/tokens";

    private static final int CONNECTION_TIMEOUT = 5000;

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
    private static final String CREDENTIALS_FILE_PATH = "/opt/tomcat/webapps/ROOT/WEB-INF/classes/*****ceb.p12";
    private static Sheets service;
    private static String spreadsheetId;


    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException, GeneralSecurityException {
        Credential credential = new GoogleCredential.Builder()
                .setTransport(HTTP_TRANSPORT)
                .setJsonFactory(JSON_FACTORY)
                .setServiceAccountId("*****.iam.gserviceaccount.com")
                .setServiceAccountPrivateKeyFromP12File(new File(CREDENTIALS_FILE_PATH))
                .setServiceAccountScopes(SCOPES)
                .build();
        credential.refreshToken();
        return credential;
    }

    /**
     * Prints the names and majors of students in a sample spreadsheet:
     * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
     */
    public static void updateSheet(ArrayList arrayList) throws IOException, GeneralSecurityException {
        System.out.println("sheet start");
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        String spreadsheetId = "******";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        System.out.println("service =  "+ service);

        ValueRange body = new ValueRange().setValues(Arrays.asList(arrayList));

        UpdateValuesResponse result = service.spreadsheets().values()
                .update(spreadsheetId, "ПЛАНОВЫЕ ТО!G30", body.setMajorDimension("COLUMNS"))
                .setValueInputOption("RAW")
                .execute();

    }

    public static void saveWork (STOWork data) throws IOException, GeneralSecurityException {

        String pattern = "dd.MM.yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(data.getWorkDate());

        String car_probeg = String.valueOf(data.getProbeg());

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        String spreadsheetId = "******";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        ValueRange addBody = new ValueRange().setValues(Arrays.asList(Arrays.asList("."
        )));

        AppendValuesResponse addString = service.spreadsheets().values().append(spreadsheetId, data.getCar_number()+"!A1", addBody)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();

        ValueRange appendBody = new ValueRange().setValues(Arrays.asList(Arrays.asList(date,
                car_probeg,
                data.getWorker(),
                data.getWorks())));

        AppendValuesResponse appendResult = service.spreadsheets().values().append(spreadsheetId, data.getCar_number()+"!A1", appendBody)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();
    }

    //Пересменка
    public static void saveTranferCar (Employee employee, String probeg, String newUser, String prob_treker) throws IOException, GeneralSecurityException {

        String pattern = "dd.MM.yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date().getTime());

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        String spreadsheetId = "*****";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        ValueRange appendBody = new ValueRange().setValues(Arrays.asList(Arrays.asList(
                date,
                employee.getCar_number(),
                employee.getOld_name_worker(),
                newUser,
                probeg,
                prob_treker,
                employee.getKurator())));


        AppendValuesResponse appendResult = service.spreadsheets().values().append(spreadsheetId, "CenterCity!A1", appendBody)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();
    }

    public static void saveComplectCar (Employee employee,  String newUser) throws IOException, GeneralSecurityException {
        String t_zapaska;
        String t_domkrat;
        String balonik;
        String tros;
        String ognetushitel;
        String aptechka;
        String zhiletka;
        String kruk;
        String potkat;
        String znak;

        String pattern = "dd.MM.yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date().getTime());

        if (employee.isZapaska()){
            t_zapaska = "Есть";
        }else {
            t_zapaska = "Нет";
        }

        if (employee.isDomkrat()){
            t_domkrat = "Есть";
        }else {
            t_domkrat = "Нет";
        }

        if (employee.isOgnetushitel()){
            ognetushitel = "Есть";
        }else {
            ognetushitel = "Нет";
        }

        if (employee.isBalonik()){
            balonik = "Есть";
        }else {
            balonik = "Нет";
        }

        if (employee.isTros()){
            tros = "Есть";
        }else {
            tros = "Нет";
        }

        if (employee.isZeletka()){
            zhiletka = "Есть";
        }else {
            zhiletka = "Нет";
        }

        if (employee.isAptechka()){
            aptechka = "Есть";
        }else {
            aptechka = "Нет";
        }

        if (employee.isKruck()){
            kruk = "Есть";
        }else {
            kruk = "Нет";
        }

        if (employee.isProtiviotkat()){
            potkat = "Есть";
        }else {
            potkat = "Нет";
        }

        if (employee.isZnak_avar()){
            znak = "Есть";
        }else {
            znak = "Нет";
        }

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        String spreadsheetId = "******";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        ValueRange appendBody = new ValueRange().setValues(Arrays.asList(Arrays.asList(
                date,
                employee.getCar_number(),
                employee.getOld_name_worker(),
                newUser,
                t_zapaska,
                t_domkrat,
                balonik,
                kruk,
                tros,
                ognetushitel,
                zhiletka,
                aptechka,
                znak,
                potkat

        )));


        AppendValuesResponse appendResult = service.spreadsheets().values().append(spreadsheetId, "Комплектация!A1", appendBody)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();
    }

    public void saveProbegDrivers(List<TransferCar> arrayList, HashMap<String, String> user_data) throws IOException, GeneralSecurityException {

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        String spreadsheetId = "******";

        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        List <List<Object>> value = new ArrayList<>();
        for (TransferCar tc : arrayList) {
            List <Object> list = new ArrayList<>();
            for (Map.Entry mp : user_data.entrySet()) {
                if (mp.getKey().equals(tc.getDriver_code())){
                    list.add((Object)mp.getValue());
                    list.add((Object)tc.getDriver_code());
                    list.add((Object)tc.getProbeg());
                }
            }
            value.add(list);
        }

        ValueRange body = new ValueRange().setValues(value);

        UpdateValuesResponse result = service.spreadsheets().values()
                .update(spreadsheetId, "Пробеги!A2", body.setMajorDimension("ROWS"))
                .setValueInputOption("RAW")
                .execute();
    }

    public void addPassenger(String car_number, String data, String date) throws IOException, GeneralSecurityException {

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        String spreadsheetId = "*******";

        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        ValueRange body = new ValueRange().setValues(Arrays.asList(Arrays.asList(car_number, data, date)));

        AppendValuesResponse appendResult = service.spreadsheets().values().append(spreadsheetId, car_number+"!A1", body)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();

    }
}
