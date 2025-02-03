package com.sandbox.reactiveweb;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RestService {
    private final static WebClient webClient = WebClient.create("http://localhost:8100");

    private static void println(String message) {
        System.out.println("INFO $ " + message);
    }

    public void getCars() {
        JsonNode response = webClient.get()
                .uri("/toyotas")
                .retrieve()
                .bodyToMono(ObjectNode.class).block();

        assert response != null;

        JsonNode models = response.get("models");
        for (JsonNode model : models) {
            println("model = " + model);
        }
    }
}
