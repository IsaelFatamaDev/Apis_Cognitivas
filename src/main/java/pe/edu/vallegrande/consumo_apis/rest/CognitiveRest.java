package pe.edu.vallegrande.consumo_apis.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.vallegrande.consumo_apis.model.ImageRequest;
import pe.edu.vallegrande.consumo_apis.model.ImageResponse;
import pe.edu.vallegrande.consumo_apis.service.CognitiveService;
import pe.edu.vallegrande.consumo_apis.service.ImageGenerationService;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api/cognitive")
@AllArgsConstructor
public class CognitiveRest {
    private final CognitiveService cognitiveService;
    private final ImageGenerationService imageGenerationService;

    @PostMapping("/summary")
    public Mono<ResponseEntity<Object>> getSummary(@RequestParam String url) {
        return cognitiveService.getSummaryFromUrl(url)
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                                .body(Map.of(
                                        "error", "Service unavailable",
                                        "message", e.getMessage(),
                                        "timestamp", Instant.now()
                                ))
                ));
    }

    @PostMapping("/generate-image")
    public Mono<ResponseEntity<?>> generateImage(
            @RequestParam String prompt,
            @RequestParam(defaultValue = "2") int styleId,
            @RequestParam(defaultValue = "1-1") String size) {

        ImageRequest request = new ImageRequest();
        request.setPrompt(prompt);
        request.setStyle_id(styleId);
        request.setSize(size);

        return imageGenerationService.generateImages(request)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .onErrorResume(e -> Mono.just(
                        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(Map.of(
                                        "error", "Image generation failed",
                                        "message", e.getMessage(),
                                        "timestamp", Instant.now()
                                ))
                ));
    }
}