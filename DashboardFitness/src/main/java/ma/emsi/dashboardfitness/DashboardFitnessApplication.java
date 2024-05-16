
package ma.emsi.dashboardfitness;

import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.entities.Utilisateur;
import ma.emsi.dashboardfitness.repositories.INutritionRepository;
import ma.emsi.dashboardfitness.repositories.IUtilisateurRepository;
import ma.emsi.dashboardfitness.services.AdministrateurService;
import ma.emsi.dashboardfitness.services.EntrainementService;
import ma.emsi.dashboardfitness.services.NutritionService;
import ma.emsi.dashboardfitness.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class DashboardFitnessApplication implements CommandLineRunner {


    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    AdministrateurService administrateurService;
    @Autowired
    EntrainementService entrainementService;


    public static void main(String[] args)  {

        SpringApplication.run(DashboardFitnessApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        /*
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

    } */
    administrateurService.createNutrition(Nutrition.builder()
             .nomNutrition("Carrot Pilaf")
                .proteine(12)
                .calorie(100)
                .graisse(16)
                .type("workout")
                .build());
        administrateurService.createNutrition(Nutrition.builder()
                .nomNutrition("Cropped Miguel")
                .proteine(50)
                .calorie(200)
                .graisse(110)
                .type("Post-workout")
                .build());
        administrateurService.createNutrition(Nutrition.builder()
                .nomNutrition("Curied Kale")
                .proteine(50)
                .calorie(200)
                .graisse(110)
               // .type("Post-workout")
                       /* .ingredient("1 tsp rapeseed or coconut oil\n" +
                                "1 onion, chopped\n" +
                                "1 tbsp grated ginger\n" +
                                "2 garlic cloves, crushed\n" +
                                "1 sweet potato (about 200g), peeled and cut into 2cm cubes\n" +
                                "1 tsp turmeric\n" +
                                "2 tsp ground cumin\n" +
                                "2 tbsp medium or hot curry powder\n" +
                                "400g can chickpeas, rinsed\n" +
                                "150ml low-fat coconut milk\n" +
                                "500ml vegetable stock (see tip, below)\n" +
                                "160g kale, chopped\n" +
                                "1 lime, juiced\n" +
                                "1 red chilli, finely chopped (optional)")
                .recipe("Heat the oil in a large pan and fry the onion for 5 mins. Add the ginger and garlic, fry for 1 min more, then stir in the sweet potato, spices and chickpeas. Cook for another 5 mins, adding a little water if the spices stick to the pan.\n" +
                        "Pour in the coconut milk and 400ml of the stock, then bring to a simmer and cook for 8 mins. Season, then transfer a quarter of the soup to a blender and whizz until smooth. Pour in the reserved stock to loosen, if needed, then add back to the pan with the remaining soup. Stir in the kale and cook for 5 mins. Add the lime juice, then ladle into bowls and scatter over the chilli, if you like.")*/
                .build());
        administrateurService.createNutrition(Nutrition.builder()
                .nomNutrition("Tuna Pasta")
                .proteine(150)
                .calorie(300)
                .graisse(50)
                .type("Petit-déjeuner")
                .build());

        administrateurService.createNutrition(Nutrition.builder()
                .nomNutrition("Moroccan Burger")
                .proteine(100)
                .calorie(250)
                .graisse(80)
                .type("Collation")
                .build());

        administrateurService.createNutrition(Nutrition.builder()
                .nomNutrition("Roasted Teriyaki")
                .proteine(120)
                .calorie(280)
                .graisse(60)
                .type("Déjeuner")
                .build());

        administrateurService.createNutrition(Nutrition.builder()
                .nomNutrition("Sausage Lenstil")
                .proteine(130)
                .calorie(320)
                .graisse(70)
                .type("Collation")
                .build());

        administrateurService.createNutrition(Nutrition.builder()
                .nomNutrition("Scotch Broth")
                .proteine(110)
                .calorie(270)
                .graisse(90)
                .type("Dîner")
                .build());

        administrateurService.createNutrition(Nutrition.builder()
                .nomNutrition("Smoothie bowl")
                .proteine(33)
                .calorie(50)
                .graisse(4)
                .type("Collation")
                .build());
        utilisateurService.Register(Utilisateur.builder()
                .prenom("ettaleby")
                .nom("neha")
                .email("neha@example.com")
                .password("Neha123!")
                .poids(63)
                .taille(1.62)
                .build());


}
}
