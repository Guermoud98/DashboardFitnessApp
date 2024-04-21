package ma.emsi.dashboardfitness.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercice {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idExercice;
        private String nom;
        private String duree;//duree d'un seul exercice
        private int nombreDeRep;//combien cet exercice doit etre  repeté
        @Lob
        private byte[] image;
        private String description;// l'objectif de cet exercice
        @ManyToOne
        @JoinColumn(name = "idEntrainement")
        private Entrainement entrainement;

}
