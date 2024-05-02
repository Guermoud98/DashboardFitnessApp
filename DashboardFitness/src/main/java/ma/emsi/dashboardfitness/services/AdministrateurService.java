package ma.emsi.dashboardfitness.services;


import ma.emsi.dashboardfitness.entities.Administrateur;
import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.repositories.IAdministrateurRepository;
import ma.emsi.dashboardfitness.repositories.INutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurService {
    private IAdministrateurRepository administrateurRepository;
    private NutritionService nutritionService;
    //couplage faible
    public AdministrateurService(IAdministrateurRepository administrateurRepository,NutritionService nutritionService) {
        this.administrateurRepository = administrateurRepository;
        this.nutritionService = nutritionService;
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
    public Nutrition createNutrition(Nutrition nutrition) {
        return nutritionService.ajouterNutrition(nutrition);
    }
    public List<Nutrition> afficherNutritions() {
        return nutritionService.afficherNutritions();
    }
    public void deleteNutritionById(Long id) {
        nutritionService.supprimerNutritionById(id);
    }
    public Nutrition afficherNutritionById(Long id) {
        return nutritionService.getNutritionById(id);
    }
    public void updateNutrition(Long id , Nutrition updatedNutrition) {
        nutritionService.modifierNutrition(id, updatedNutrition);
    }


}
