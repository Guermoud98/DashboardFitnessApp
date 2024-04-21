package src.main.java.ma.emsi.dashboardfitness.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import src.main.java.ma.emsi.dashboardfitness.entities.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);
 //les autres methodes du CRUD existent par défaut  dans JpaRepository
}
