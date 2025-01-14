package com.pucp;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner=new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/9ff084e3571d324cfff38109/latest/USD"))
                .GET() // Cambiar a POST, PUT, DELETE, etc.
                .build();
        HttpResponse<String>response=client
                .send(request,HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        String json=response.body() ;
        Gson gson  = new Gson();
        Money money=gson.fromJson(json,Money.class);
        System.out.println(money);



    }

}