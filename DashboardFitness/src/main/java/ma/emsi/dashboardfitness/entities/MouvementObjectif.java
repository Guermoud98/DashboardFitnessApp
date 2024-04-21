package src.main.java.ma.emsi.dashboardfitness.entities;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MouvementObjectif { // par exemple l'utilisateur veut atteindre 10000 pas  par jour
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMouvementObjectif;
    private int nombreStep;
    private int nombreCalorie;
    private int nombreKm;
    private Date date;
}
