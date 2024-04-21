package src.main.java.ma.emsi.dashboardfitness.entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nutrition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNutrition;
    private String nomNutrition;
    private float calorie;
    private float proteine;
    private float graisse;
    private String type;
}
