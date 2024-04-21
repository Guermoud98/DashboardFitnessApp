package src.main.java.ma.emsi.dashboardfitness.services;

import src.main.java.ma.emsi.dashboardfitness.repositories.IAdministrateurRepository;

public class AdministrateurService {
    private IAdministrateurRepository administrateurRepository;

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
