package ma.emsi.dashboardfitness.services;


import ma.emsi.dashboardfitness.entities.Administrateur;
import ma.emsi.dashboardfitness.repositories.IAdministrateurRepository;
import org.springframework.stereotype.Service;

@Service
public class AdministrateurService {
    private IAdministrateurRepository administrateurRepository;
    //couplage faible
    public AdministrateurService(IAdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }
    public Administrateur AdminLogin(String username, String password) {
        Administrateur administrateur = administrateurRepository.findByLoginAndPassword(username,password);
        if(administrateur != null) {
            System.out.println("Welcome " + username);
            return administrateur;
        }
        return null;
    }

}
