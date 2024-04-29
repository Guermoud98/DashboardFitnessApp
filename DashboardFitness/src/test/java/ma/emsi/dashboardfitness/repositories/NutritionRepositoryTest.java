package ma.emsi.dashboardfitness.repositories;

import ma.emsi.dashboardfitness.entities.Nutrition;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)

public class NutritionRepositoryTest {

    @Autowired
    private INutritionRepository nutritionRepository;

    @BeforeEach
    public void setUp() {
        Nutrition nutrition = Nutrition.builder()
                .idNutrition(null)
                .nomNutrition("Glute-Building Meal")
                .proteine(200)
                .calorie(100)
                .graisse(40)
                .type("workout")
                .build();
        Nutrition nutrition2 = Nutrition.builder()
                .idNutrition(null)
                .nomNutrition("Glute-Strengthening Meal")
                .proteine(50)
                .calorie(200)
                .graisse(110)
                .type("Post-workout")
                .build();
        Nutrition nutrition3 = Nutrition.builder()
                .idNutrition(null)
                .nomNutrition("Workout-For-Weak-")
                .proteine(50)
                .calorie(200)
                .graisse(110)
                .type("Post-workout")
                .build();
        nutritionRepository.save(nutrition);
        nutritionRepository.save(nutrition2);
        nutritionRepository.save(nutrition3);
    }

    @Test
    public void INutritionRepository_findByNomNutrition_ReturnNutritions() {
        String keyword = "Glute";
        List<Nutrition> expectedNutrition = List.of(
                Nutrition.builder()
                        .idNutrition(null)
                        .nomNutrition("Glute-Building Meal")
                        .proteine(200)
                        .calorie(100)
                        .graisse(40)
                        .type("workout")
                        .build()
                ,
                Nutrition.builder()
                .idNutrition(null)
                        .nomNutrition("Glute-Strengthening Meal")
                        .proteine(50)
                        .calorie(200)
                        .graisse(110)
                        .type("Post-workout")
                        .build()

        );
        List<Nutrition> result = nutritionRepository.findByNomNutritionContaining(keyword);
        Assertions.assertThat(result).isEqualTo(expectedNutrition);
        Assertions.assertThat(result.size()).isEqualTo(expectedNutrition.size());
        Assertions.assertThat(result.size()).isEqualTo(2);
    }


}
