package pe.edu.vallegrande.consumo_apis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScraperResponse {
    private String status;
    private String message;
    private Result result;


    @Data
    public static class Result {
        private String title;
        private String description;
        private int character_count;
        private List<String> urls;
        private String content;
        private String summary;
    }
}
