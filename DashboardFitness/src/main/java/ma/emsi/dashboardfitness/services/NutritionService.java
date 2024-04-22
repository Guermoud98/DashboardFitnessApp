package ma.emsi.dashboardfitness.services;

import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.repositories.INutritionRepository;

public class NutritionService {
    private INutritionRepository nutritionRepository;
    // couplage faible
    public NutritionService(INutritionRepository nutritionRepository) {
        this.nutritionRepository = nutritionRepository;
    }

    //ajouter une nutrition par l'admin a la base de donnee
    public void ajouterNutrition(Nutrition nutrition) {
        nutritionRepository.save(nutrition);
    }

}
