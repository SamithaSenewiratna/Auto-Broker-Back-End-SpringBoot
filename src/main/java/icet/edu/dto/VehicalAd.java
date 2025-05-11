package icet.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicalAd {

    private Long id;
    private String brand;
    private String model;
    private String title;
    private String description;
    private double price;
    private String location;
    private String year;
    private String fuelType;
    private String transmission;
    private String engineCapacity;
    private String itemCondition;
    private String mileage;
    private String contact;
    private String createdAt;

    private List<String> images;
    private Long userId;
}
