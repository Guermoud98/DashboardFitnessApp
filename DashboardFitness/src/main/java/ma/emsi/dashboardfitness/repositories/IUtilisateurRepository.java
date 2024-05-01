package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.Utilisateur;
import ma.emsi.dashboardfitness.services.UtilisateurService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);

    //cette methode est utilisé pour resoudre le probleme de la methode par defaut save car cette derniere elle sauvegarde le mot de passe sans  l'encoder
    default   Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        // Create BCryptPasswordEncoder instance locally
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));

        return save(utilisateur);
    }
}
