package com.gdg;

import com.appspot.dcifuen_shouter.shouter.Shouter;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

public class ShouterClient {

    private Shouter service;


    public ShouterClient() throws Exception {
        HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        HttpRequestInitializer initializer = httpRequest -> {
        };
        Shouter.Builder builder =
            new Shouter.Builder(transport, jsonFactory, initializer).setApplicationName("Shouter");
        service = builder.build();
    }

    public String getMessage() throws Exception {
        return service.greeting().get().execute().getMessage();
    }

    public static void main(String[] args) throws Exception {
        ShouterClient myMain = new ShouterClient();
        System.out.println(myMain.getMessage());

    }
}
