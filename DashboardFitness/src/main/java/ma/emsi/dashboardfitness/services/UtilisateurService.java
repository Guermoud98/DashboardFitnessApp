package ma.emsi.dashboardfitness.services;

import ma.emsi.dashboardfitness.entities.Utilisateur;
import ma.emsi.dashboardfitness.repositories.IUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UtilisateurService {
    @Autowired
    private IUtilisateurRepository utilisateurRepository;


    public UtilisateurService(IUtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    /*Les methodes de validité d'email et  password */

    public boolean isValidEmail(String email) {

        //exemple d'email valide : utilisateur@example.com
        String regex = "^(.+)@(.+)$";
        return email.matches(regex);
    }

    public boolean isValidPassword(String password) {

        //exemple de password valide : Password123!
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password.matches(regex);
    }


    public Utilisateur Login(String email, String password) {
        // Create BCryptPasswordEncoder instance locally
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur != null && passwordEncoder.matches(password, utilisateur.getPassword())) {
            return utilisateur;
        }
        return null;
    }

    public Utilisateur Register(Utilisateur utilisateur) {

        if (!isValidEmail(utilisateur.getEmail())) {
            throw new IllegalArgumentException("Email invalid");
        }
        if (!isValidPassword(utilisateur.getPassword())) {
            throw new IllegalArgumentException("Password invalid");
        }
        // Create BCryptPasswordEncoder instance locally
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Encode the password
        String encodedPassword = passwordEncoder.encode(utilisateur.getPassword());

        // Set the encoded password back to the utilisateur object
        utilisateur.setPassword(encodedPassword);

        return utilisateurRepository.save(utilisateur);
    }


}
