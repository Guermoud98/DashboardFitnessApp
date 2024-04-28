package ma.emsi.dashboardfitness.entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur ;

    private String nom;
    private String prenom;

    @Column(unique = true)
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
