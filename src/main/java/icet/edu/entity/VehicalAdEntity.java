package icet.edu.entity;



import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class VehicalAdEntity {

    private Long id;
    private String brand;
    private String model;
    private String title;
    private String description;
    private double price;
    private String imageUrl; // optional main image
    private String location;
    private String year;
    private String fualType; // typo preserved to match frontend, consider correcting to 'fuelType'
    private String transmission;
    private String engineCapacity;
    private String condition;
    private String mileage;
    private String contact;
    private String createdAt; // or LocalDateTime createdAt;
    private List<String> images;


}
