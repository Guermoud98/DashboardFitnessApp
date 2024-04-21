package ma.emsi.dashboardfitness.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur ;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private int poids;
    private int taille;
    @ManyToOne
    @JoinColumn(name = "idEntrainement")
    private Entrainement entrainement;

    @ManyToOne
    @JoinColumn(name = "idMouvementObjectif")
    private MouvementObjectif mouvementObjectif;



}
