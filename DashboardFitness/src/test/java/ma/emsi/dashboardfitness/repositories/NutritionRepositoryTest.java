package ma.emsi.dashboardfitness.repositories;

import ma.emsi.dashboardfitness.entities.Nutrition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class NutritionRepositoryTest {

    @Autowired
    private INutritionRepository nutritionRepository;

    @BeforeEach
    public void setUp() {
        nutritionRepository.save(Nutrition.builder()
                .nomNutrition("Glute-Building Meal")
                .proteine(200)
                .calorie(100)
                .graisse(40)
                .type("workout")
                .build());
        nutritionRepository.save(Nutrition.builder()
                .nomNutrition("Glute-Strengthening Meal")
                .proteine(50)
                .calorie(200)
                .graisse(110)
                .type("Post-workout")
                .build());
        nutritionRepository.save(Nutrition.builder()
                .nomNutrition("Workout-For-Weak-")
                .proteine(50)
                .calorie(200)
                .graisse(110)
                .type("Post-workout")
                .build());
    }

    @Test
    void INutritionRepository_findByNomNutrition_ReturnNutritions() {
        String keyword = "glute";
        List<Nutrition> expectedNutrition = List.of(
                Nutrition.builder()
                        .nomNutrition("Glute-Building Meal")
                        .proteine(200)
                        .calorie(100)
                        .graisse(40)
                        .type("workout")
                        .build()
                ,
                Nutrition.builder()
                        .nomNutrition("Glute-Strengthening Meal")
                        .proteine(50)
                        .calorie(200)
                        .graisse(110)
                        .type("Post-workout")
                        .build()

        );
        List<Nutrition> result = nutritionRepository.findByNomNutritionContainingIgnoreCase(keyword);
        Assertions.assertThat(result).usingRecursiveFieldByFieldElementComparatorIgnoringFields("idNutrition").isEqualTo(expectedNutrition);
        Assertions.assertThat(result.size()).isEqualTo(expectedNutrition.size());
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).isNotNull();


    }


}
