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

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(result.size()).isEqualTo(expectedExercices.size());
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).isNotNull();
        for (int i = 0; i < result.size(); i++) {
            Exercice expectedResult = expectedExercices.get(i);
            Exercice actualResult = result.get(i);

            // Verify the 'nom' field
            assertThat(actualResult.getNom()).isEqualTo(expectedResult.getNom());

            // Verify the 'duree' field
            assertThat(actualResult.getDuree()).isEqualTo(expectedResult.getDuree());

            // Verify the 'nombreDeRep' field
            assertThat(actualResult.getNombreDeRep()).isEqualTo(expectedResult.getNombreDeRep());

            // Verify the 'image' field
            assertThat(actualResult.getImage()).isEqualTo(expectedResult.getImage());

            // Verify the 'description' field
            assertThat(actualResult.getDescription()).isEqualTo(expectedResult.getDescription());

            // Verify the 'entrainement' field
            Entrainement expectedEntrainement = expectedResult.getEntrainement();
            Entrainement actualEntrainement = actualResult.getEntrainement();

            assertThat(actualEntrainement.getNom()).isEqualTo(expectedEntrainement.getNom());
            assertThat(actualEntrainement.getDuree()).isEqualTo(expectedEntrainement.getDuree());
            assertThat(actualEntrainement.getImcMax()).isEqualTo(expectedEntrainement.getImcMax());
            assertThat(actualEntrainement.getImcMin()).isEqualTo(expectedEntrainement.getImcMin());
            assertThat(actualEntrainement.getDescription()).isEqualTo(expectedEntrainement.getDescription());

            // Verify the 'nutrition' field within 'entrainement'
            Nutrition expectedNutrition = expectedEntrainement.getNutrition();
            Nutrition actualNutrition = actualEntrainement.getNutrition();

            assertThat(actualNutrition.getNomNutrition()).isEqualTo(expectedNutrition.getNomNutrition());
            assertThat(actualNutrition.getType()).isEqualTo(expectedNutrition.getType());
            assertThat(actualNutrition.getGraisse()).isEqualTo(expectedNutrition.getGraisse());
            assertThat(actualNutrition.getCalorie()).isEqualTo(expectedNutrition.getCalorie());
            assertThat(actualNutrition.getProteine()).isEqualTo(expectedNutrition.getProteine());
        }

    }

}
