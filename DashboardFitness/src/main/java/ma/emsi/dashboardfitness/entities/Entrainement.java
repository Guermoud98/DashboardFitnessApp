package ma.emsi.dashboardfitness.entities;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrainement { //workout : si l'objectif d'utilisateur  est perte/gain  du poids
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrainement;
    private String nom;
    private long duree;
    private String description;
    @ManyToOne
    @JoinColumn(name="idNutrition")
    private Nutrition nutrition;


}
