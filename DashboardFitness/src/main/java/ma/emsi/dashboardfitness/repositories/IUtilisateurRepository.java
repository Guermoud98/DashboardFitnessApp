package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String email);

    Optional<Utilisateur> findByIdUtilisateur(Long idUtilisateur);

    List<Utilisateur> findByNomContainingIgnoreCase(String nom);

    List<Utilisateur> findByPrenomContainingIgnoreCase(String prenom);

    List<Utilisateur> findByPoids(int poids);

    List<Utilisateur> findByTaille(long taille);

    Optional<Utilisateur> deleteByIdUtilisateur(Long idUtilisateur);


}
