
package ma.emsi.dashboardfitness;

import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.entities.Utilisateur;
import ma.emsi.dashboardfitness.repositories.INutritionRepository;
import ma.emsi.dashboardfitness.repositories.IUtilisateurRepository;
import ma.emsi.dashboardfitness.services.AdministrateurService;
import ma.emsi.dashboardfitness.services.EntrainementService;
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
    @Autowired
    EntrainementService entrainementService;

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
        /*********** Users ********/
        utilisateurService.Register(Utilisateur.builder()
                .prenom("ettaleby")
                .nom("neha")
                .email("neha@example.com")
                .password("Neha123!")
                .poids(63)
                .taille(1.62)
                .build());
        utilisateurService.Register(Utilisateur.builder()
                .prenom("ettaleby")
                .nom("yousra")
                .email("yousra@example.com")
                .password("Yousra123!")
                .poids(63)
                .taille(1.62)
                .build());
      Nutrition n1= Nutrition.builder()
                .nomNutrition("Glute-Building Meal")
                .proteine(200)
                .calorie(100)
                .graisse(40)
                .type("workout")
                .build();
        Nutrition n2= Nutrition.builder()
                .nomNutrition("Glute-Building Meal")
                .proteine(200)
                .calorie(100)
                .graisse(40)
                .type("workout")
                .build();
        administrateurService.createNutrition(n1);
        administrateurService.createNutrition(n2);
        entrainementService.createEntrainement(Entrainement.builder()
                .nom("Workout1")
                .duree(30)
                .imcMax(60)
                .imcMin(20)
                .description("Workout for 30 minutes")
                .nutrition(n1)
                .build());
        entrainementService.createEntrainement(Entrainement.builder()
                .nom("Workout2")
                .duree(30)
                .imcMax(60)
                .imcMin(20)
                .description("Workout for 15 minutes")
                .nutrition(n2)
                .build());




    }
}
