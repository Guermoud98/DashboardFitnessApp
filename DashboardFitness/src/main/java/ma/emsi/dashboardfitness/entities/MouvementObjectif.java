package ma.emsi.dashboardfitness.entities;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MouvementObjectif { //Objectif : perte ou gain d poids
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMouvementObjectif;
    private int nombreStep;
    private int nombreCalorie;
    private int nombreKm;
    private Date date;
}
