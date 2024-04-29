package ma.emsi.dashboardfitness.repositories;

import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Exercice;
import ma.emsi.dashboardfitness.entities.Nutrition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ExerciceRepositoryTest {
    @Autowired
    private IExerciceRepository exerciceRepository;
    @Autowired
    private IEntrainementRepository entrainementRepository;
    @Autowired
    private INutritionRepository nutritionRepository;
    @BeforeEach
    public void setUp() {

        Nutrition n1 = Nutrition.builder()
                .nomNutrition("Glute-Building Meal")
                .type("Pre-workout")
                .graisse(10) // in grams
                .calorie(400) // in calories
                .proteine(25) // in grams
                .build();
        nutritionRepository.save(n1);
        Entrainement entrainement = Entrainement.builder()
                .nom("WorkoutForWeakGlutes")
                .duree(30)
                .imcMax(120)
                .imcMin(70)
                .description("for get a weak  glutes ")
                .nutrition(n1)
                .build();
        entrainementRepository.save(entrainement);
        exerciceRepository.save(Exercice.builder()
                .nom("description de l'exercice")
                .duree("20")
                .nombreDeRep(10)
                .image(new byte[]{9, 10, 11, 12})
                .description("Description de l'exercice")
                .entrainement(entrainement)
                .build()
        );
        exerciceRepository.save(Exercice.builder()
                .nom("Exercice de test")
                .duree("20")
                .nombreDeRep(10)
                .image(new byte[]{9, 10, 11, 12})
                .description("Nom de l'exercice")
                .entrainement(entrainement)
                .build()
        );
        exerciceRepository.save(Exercice.builder()
                .nom("test")
                .duree("10")
                .nombreDeRep(4)
                .image(new byte[]{9, 10, 11, 12})
                .description("test")
                .entrainement(entrainement)
                .build()
        );


    }
    @Test
    public void IExerciceRepository_findByNomExercice_ReturnExercices() {
        String keyword = "exercice";
        List<Exercice> expectedExercices = List.of(
                Exercice.builder()
                        .nom("description de l'exercice")
                        .duree("20")
                        .nombreDeRep(10)
                        .image(new byte[]{9, 10, 11, 12})
                        .description("Description de l'exercice")
                        .entrainement(Entrainement.builder()
                                .nom("WorkoutForWeakGlutes")
                                .duree(30)
                                .imcMax(120)
                                .imcMin(70)
                                .description("for get a weak  glutes ")
                                .nutrition(Nutrition.builder()
                                        .nomNutrition("Glute-Building Meal")
                                        .type("Pre-workout")
                                        .graisse(10) // in grams
                                        .calorie(400) // in calories
                                        .proteine(25)
                                        .build())
                                .build())
                        .build()
                ,
                Exercice.builder()
                        .nom("Exercice de test")
                        .duree("20")
                        .nombreDeRep(10)
                        .image(new byte[]{9, 10, 11, 12})
                        .description("Nom de l'exercice")
                        .entrainement(Entrainement.builder()
                                .nom("WorkoutForWeakGlutes")
                                .duree(30)
                                .imcMax(120)
                                .imcMin(70)
                                .description("for get a weak  glutes ")
                                .nutrition(Nutrition.builder()
                                        .nomNutrition("Glute-Building Meal")
                                        .type("Pre-workout")
                                        .graisse(10) // in grams
                                        .calorie(400) // in calories
                                        .proteine(25)
                                        .build())
                                .build())
                        .build()

        );
        List<Exercice> result = exerciceRepository.findByNomContainingIgnoreCase(keyword);
        //Assertions.assertThat(result).usingElementComparatorIgnoringFields ("idExercice", "idEntrainement", "idNutrition").isEqualTo(expectedExercices);
        Assertions.assertThat(result.size()).isEqualTo(expectedExercices.size());
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).isNotNull();

    }

}
