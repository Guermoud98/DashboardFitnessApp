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

    /*//cette methode est utilisé pour resoudre le probleme de la methode
    // par defaut save car cette derniere elle sauvegarde le mot de passe sans  l'encoder
    default Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        // Create BCryptPasswordEncoder instance locally
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));

        return save(utilisateur);
    }*/

}
