package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);
 //les autres methodes du CRUD existent par défaut  dans JpaRepository
}
