package ma.emsi.dashboardfitness.services;


import ma.emsi.dashboardfitness.entities.Administrateur;
import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.repositories.IAdministrateurRepository;
import ma.emsi.dashboardfitness.repositories.INutritionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurService {
    private IAdministrateurRepository administrateurRepository;
    private INutritionRepository nutritionRepository;
    //couplage faible
    public AdministrateurService(IAdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }
    /******************************Admin login*************************************/
    public Administrateur AdminLogin(String username, String password) {
        Administrateur administrateur = administrateurRepository.findByLoginAndPassword(username,password);
        if(administrateur != null) {
            System.out.println("Welcome " + username);
            return administrateur;
        }
        return null;
    }
    /******************************Nutrition*************************************/
    public List<Nutrition> afficherNutritions() {
        return nutritionRepository.findAll();
    }

}
