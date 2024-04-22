package ma.emsi.dashboardfitness.services;


import ma.emsi.dashboardfitness.entities.Utilisateur;
import ma.emsi.dashboardfitness.repositories.IUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UtilisateurService {

    private IUtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(IUtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }


    ///Les methodes de validité d'email et  password/////////////////////////////////////////////

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

    ////////////////////////////////////////////////////////////////////////////////////

    public Utilisateur Login (String email, String password) {
    Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
    if(utilisateur != null && utilisateur.getPassword().equals(password)) {
       return utilisateur;
    }
    return null;
    }
    public Utilisateur Register(Utilisateur utilisateur) {
        if (!isValidEmail(utilisateur.getEmail()))
        {
            throw new IllegalArgumentException("Email invalid");
        }
        if(!isValidPassword(utilisateur.getPassword()))
        {
            throw new IllegalArgumentException("Password invalid");
        }
       return  utilisateurRepository.save(utilisateur);
    }
}
