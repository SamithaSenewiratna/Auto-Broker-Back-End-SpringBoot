package icet.edu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="spare_parts")
public class SparePartAdEntity {

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
    @Column(name = "condition_type")
    private String conditionType;

    private String contact;
    private String createdAt;

    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "LONGTEXT")
    private List<String> images;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
