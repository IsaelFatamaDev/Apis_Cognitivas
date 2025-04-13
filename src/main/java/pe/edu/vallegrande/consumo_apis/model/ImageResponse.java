package pe.edu.vallegrande.consumo_apis.model;

import lombok.Data;
import java.util.List;

@Data
public class ImageResponse {
    private List<ImageResult> final_result;

    @Data
    public static class ImageResult {
        private int index;
        private boolean nsfw;
        private String origin;
        private String thumb;
    }
}