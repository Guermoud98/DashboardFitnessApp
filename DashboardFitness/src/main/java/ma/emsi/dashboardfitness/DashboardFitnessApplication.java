
package ma.emsi.dashboardfitness;

import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.entities.Utilisateur;
import ma.emsi.dashboardfitness.repositories.INutritionRepository;
import ma.emsi.dashboardfitness.repositories.IUtilisateurRepository;
import ma.emsi.dashboardfitness.services.AdministrateurService;
import ma.emsi.dashboardfitness.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DashboardFitnessApplication implements CommandLineRunner {


 @Autowired
 UtilisateurService utilisateurService;
 @Autowired
 AdministrateurService administrateurService;

    public static void main(String[] args) {

        SpringApplication.run(DashboardFitnessApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        administrateurService.createNutrition(Nutrition.builder()
                .nomNutrition("Glute-Building Meal")
                .proteine(200)
                .calorie(100)
                .graisse(40)
                .type("workout")
                .build());
        administrateurService.createNutrition(Nutrition.builder()
                .nomNutrition("Glute-Strengthening Meal")
                .proteine(50)
                .calorie(200)
                .graisse(110)
                .type("Post-workout")
                .build());
        administrateurService.createNutrition(Nutrition.builder()
                .nomNutrition("Workout-For-Weak-")
                .proteine(50)
                .calorie(200)
                .graisse(110)
                .type("Post-workout")
                .build());


    }
}
