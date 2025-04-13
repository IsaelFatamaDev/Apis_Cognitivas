package pe.edu.vallegrande.consumo_apis.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pe.edu.vallegrande.consumo_apis.model.ScraperResponse;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class CognitiveService {

    private final WebClient webClient;
    private final String API_URL = "https://ai-web-scraper1.p.rapidapi.com/";
    private final String API_HOST = "ai-web-scraper1.p.rapidapi.com";
    private final String API_KEY = "17906f1926msh6733267906d9683p1a66acjsncb025bee43ca";

    public Mono<ScraperResponse> getSummaryFromUrl(String targetUrl) {
        String requestBody = String.format("{\"url\": \"%s\", \"summary\": true}", targetUrl);

        return webClient.post()
                .uri(API_URL)
                .header("X-Rapidapi-Host", API_HOST)
                .header("X-Rapidapi-Key", API_KEY)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(rawResponse -> System.out.println("Respuesta cruda: " + rawResponse))
                .flatMap(rawResponse -> {
                    try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                        ScraperResponse response = objectMapper.readValue(rawResponse, ScraperResponse.class);
                        System.out.println("Respuesta mapeada: " + objectMapper.writeValueAsString(response));
                        return Mono.just(response);
                    } catch (Exception e) {
                        System.err.println("Error al mapear respuesta: " + e.getMessage());
                        return Mono.error(new RuntimeException("Error al procesar la respuesta", e));
                    }
                });
    }



}
