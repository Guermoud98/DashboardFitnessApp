package ma.emsi.dashboardfitness.entities;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.util.Objects;

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
    private Nutrition nutrition;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrainement that = (Entrainement) o;
        return Objects.equals(nom, that.nom) &&
                Objects.equals(duree, that.duree) &&
                Objects.equals(description, that.description) &&
                Objects.equals(imcMin, that.imcMin) &&
                Objects.equals(imcMax, that.imcMax) &&
                Objects.equals(nutrition, that.nutrition);
    }

}
