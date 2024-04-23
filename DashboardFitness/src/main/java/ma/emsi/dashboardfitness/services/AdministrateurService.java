package ma.emsi.dashboardfitness.services;


import ma.emsi.dashboardfitness.repositories.IAdministrateurRepository;
import org.springframework.stereotype.Service;

@Service
public class AdministrateurService {
    private IAdministrateurRepository administrateurRepository;
    //couplage faible
    public AdministrateurService(IAdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }
    public boolean AdminLogin(String username, String password) {
        if(administrateurRepository.findLoginAndPassword(username,password)) {
            System.out.println("Welcome " + username);
        }
        else {
            System.out.println("Invalid username or password");
            return false;
        }
        return true;
    }

}
