package ma.emsi.dashboardfitness.services;

import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Utilisateur;
import ma.emsi.dashboardfitness.repositories.IUtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    private IUtilisateurRepository utilisateurRepository;
    private EntrainementService entrainementService;
    public UtilisateurService(IUtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    /************* Les methodes de validité d'email et  password*********/
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
   /** For user **/
    /***********************   Login ************************************/
    public Utilisateur Login(String email, String password) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email).orElse(null);

        if (utilisateur != null && password.equals(utilisateur.getPassword()) ) {
            return utilisateur;
        }

        return null;
    }

    /************************* Inscription *************************************/
    public Utilisateur Register(Utilisateur utilisateur) {

        if (!isValidEmail(utilisateur.getEmail())) {
            throw new IllegalArgumentException("Email invalid");
        }
        if (!isValidPassword(utilisateur.getPassword())) {
            throw new IllegalArgumentException("Password invalid");
        }
        return utilisateurRepository.save(utilisateur);
    }

    /******************************  Update  ********************************/
    // this method update just the fields which the user choose  to update
    //here I used utilisateur as param because the method login returns user connected
    //Recommended to use this method in UserController not admin
    public Utilisateur UpdateUtilisateur(Utilisateur utilisateur) {
        Utilisateur existingUser = utilisateurRepository.findByEmail(utilisateur.getEmail()).orElse(null);
        if (existingUser != null) {
            existingUser.setNom(utilisateur.getNom() != null ? utilisateur.getNom() : existingUser.getNom());
            existingUser.setPrenom(utilisateur.getPrenom() != null ? utilisateur.getPrenom() : existingUser.getPrenom());
            existingUser.setPoids(utilisateur.getPoids() != 0 ? utilisateur.getPoids() : existingUser.getPoids());
            existingUser.setTaille(utilisateur.getTaille() != 0 ? utilisateur.getTaille() : existingUser.getTaille());
            existingUser.setEmail(utilisateur.getEmail() != null && !utilisateur.getEmail().equals(existingUser.getEmail()) ? utilisateur.getEmail() : existingUser.getEmail());
            existingUser.setPassword(utilisateur.getPassword() != null ? utilisateur.getPassword() : existingUser.getPassword());

        }
        return utilisateurRepository.save(existingUser);
    }
    /*******Affichage d'entrainement *******/
    public List<Entrainement> getRecommendedEntrainementsForUser(Utilisateur utilisateur)
    {
        return entrainementService.suggestEntrainementToUserByIMC(utilisateur.getPoids(),utilisateur.getTaille());
    }
    public List<Entrainement> getAllEntrainementsForUser(Utilisateur utilisateur)
    {
        return entrainementService.getAllEntrainements();
    }




    /******* For admin **********/
    //Recommended to use this method in AdminController
    public Utilisateur UpdateUtilisateurById(long id) {
        Utilisateur exist = utilisateurRepository.findByIdUtilisateur(id).orElse(null);
        if (exist != null) {
            return UpdateUtilisateur(exist);
        }
        return null;
    }


    /************************** Delete ***************************************/
    public void DeleteUtilisateur(Utilisateur utilisateur) {
        if (utilisateurRepository.findByIdUtilisateur(utilisateur.getIdUtilisateur()).isPresent()) {
        }
        utilisateurRepository.delete(utilisateur);
    }

    public void DeleteUtilisateurById(long idUtilisateur) {
        if (utilisateurRepository.findByIdUtilisateur(idUtilisateur).isPresent()) {
        }
        utilisateurRepository.deleteByIdUtilisateur(idUtilisateur);

    }

    /***************************** Affichage **********************************/
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(long idUtilisateur) {
        return utilisateurRepository.findByIdUtilisateur(idUtilisateur).orElse(null);
    }

    public List<Utilisateur> getUtilisateursByNom(String nom) {
        return utilisateurRepository.findByNomContainingIgnoreCase(nom);
    }

    public List<Utilisateur> getUtilisateursByPrenom(String prenom) {
        return utilisateurRepository.findByPrenomContainingIgnoreCase(prenom);
    }

    public List<Utilisateur> getUtilisateursByTaille(long taille) {
        return utilisateurRepository.findByTaille(taille);
    }

    public List<Utilisateur> getUtilisateursByPoids(int poids) {
        return utilisateurRepository.findByPoids(poids);
    }

}
