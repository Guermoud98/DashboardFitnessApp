package src.main.java.ma.emsi.dashboardfitness.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import src.main.java.ma.emsi.dashboardfitness.entities.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
