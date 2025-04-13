package pe.edu.vallegrande.consumo_apis.model;

import lombok.Data;

@Data
public class ImageRequest {
    private String prompt;
    private int style_id;
    private String size;
}