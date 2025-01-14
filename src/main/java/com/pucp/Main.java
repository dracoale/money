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

        while(true){
            System.out.println("####################################");
            System.out.println("conversor money - enter number");
            System.out.println("1) Dollar >>> Argentine Peso");
            System.out.println("2) Argentine Peso >>> Dollar");
            System.out.println("3) Dollar >>> Colombian Peso");
            System.out.println("7) Exit");

            int option = scanner.nextInt();

            if (option == 7) {
                break;
            }

            System.out.println("Enter amount:");
            double amount = scanner.nextDouble();

            if (option == 1) {
                System.out.printf("The conversion of %.2f Dollars is %.2f Argentine Pesos\n"
                        , amount, money.conversion.get("ARS")*amount);
            } else if (option == 2) {
                System.out.printf("The conversion of %.2f Argentine Pesos is %.2f Dollars\n"
                        , amount, amount/money.conversion.get("USD"));
            } else if (option == 3) {
                System.out.printf("The conversion of %.2f Dollars is %.2f Colombian Pesos\n"
                        , amount, money.conversion.get("COP")*amount);
            } else {
                System.out.println("Invalid option, please enter a valid option.");
            }
        }

        scanner.close();
        }


    }

