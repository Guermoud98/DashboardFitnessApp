package ma.emsi.dashboardfitness.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Entrainement { //workout : si l'objectif d'utilisateur  est perte/gain  du poids
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrainement;
    private String nom;
    private long duree;
    private String description;
    private double imcMin;
    private double imcMax;
    @ManyToOne
    @JoinColumn(name="idNutrition")
    private ma.emsi.dashboardfitness.entities.Nutrition nutrition;



}