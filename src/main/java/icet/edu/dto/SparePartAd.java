package icet.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SparePartAd {

    private Long id;
    private String brand;
    private String model;
    private String title;
    private String description;
    private double price;
    private String imageUrl; // optional main image
    private String location;
    private String year;
    private String condition;
    private String contact;
    private String createdAt; // or LocalDateTime createdAt;
    private List<String> images;

    private Long userId;

}
