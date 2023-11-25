package com.example.lab02.frontend.api;

import com.example.lab02.frontend.model.ProductModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProductAPI {

    private static final String API_URL = "http://localhost:8080/api/products";

    public List<ProductModel> getProducts()
    {
        List<ProductModel> productsList = new ArrayList<>();
        try {
            String apiResponse = sendGetRequest(API_URL);

            if (apiResponse != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                ProductModel[] products = objectMapper.readValue(apiResponse, ProductModel[].class);
                productsList = List.of(products);
                return productsList;

            }

        } catch (IOException e) {
            e.printStackTrace();
            return productsList;
        }
        return productsList;
    }

    private static String sendGetRequest(String apiUrl) throws IOException {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                return response.toString();
            }
        } finally {
            // Make sure to disconnect the connection even if an exception occurs
            connection.disconnect();
        }
    }
}
