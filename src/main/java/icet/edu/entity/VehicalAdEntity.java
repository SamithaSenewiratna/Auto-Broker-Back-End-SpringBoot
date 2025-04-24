package icet.edu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vehicle_ad")
public class VehicalAdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String itemCondition; // or vehicleCondition, partCondition, etc.

    private String mileage;
    private String contact;
    private String createdAt;

    @ElementCollection
    @CollectionTable(name = "vehicle_ad_images", joinColumns = @JoinColumn(name = "vehicle_ad_id"))
    @Column(name = "image_url")
    private List<String> images;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
