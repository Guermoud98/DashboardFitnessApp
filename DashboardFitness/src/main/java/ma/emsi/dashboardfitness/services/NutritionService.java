package ma.emsi.dashboardfitness.services;

import ma.emsi.dashboardfitness.repositories.INutritionRepository;

public class NutritionService {
    private INutritionRepository nutritionRepository;
    // couplage faible
    public NutritionService(INutritionRepository nutritionRepository) {
        this.nutritionRepository = nutritionRepository;
    }
}
