package pe.edu.vallegrande.consumo_apis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pe.edu.vallegrande.consumo_apis.model.ImageRequest;
import pe.edu.vallegrande.consumo_apis.model.ImageResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageGenerationService {

    private final WebClient webClient;

    private static final String API_URL = "https://ai-text-to-image-generator-flux-free-api.p.rapidapi.com/aaaaaaaaaaaaaaaaaiimagegenerator/quick.php";
    private static final String API_HOST = "ai-text-to-image-generator-flux-free-api.p.rapidapi.com";
    private static final String API_KEY = "c453f9e9f8msh898cf86228670acp191a9cjsn056489e81f02";

    public Mono<ImageResponse> generateImages(ImageRequest request) {
        log.info("Sending image generation request: {}", request);

        return webClient.post()
                .uri(API_URL)
                .header("X-RapidAPI-Key", API_KEY)
                .header("X-RapidAPI-Host", API_HOST)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ImageResponse.class)
                .doOnNext(response -> log.info("Received image generation response: {}", response))
                .doOnError(error -> log.error("Error during image generation: {}", error.getMessage()))
                .onErrorResume(e -> {
                    log.error("Image generation failed", e);
                    return Mono.error(new RuntimeException("Error generating images: " + e.getMessage()));
                });
    }
}
