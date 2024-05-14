package ma.emsi.dashboardfitness.entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@Builder
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
   //private String ingredient;
    //private String recipe;
}
