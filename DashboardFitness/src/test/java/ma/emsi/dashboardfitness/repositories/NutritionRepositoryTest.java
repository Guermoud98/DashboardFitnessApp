package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.Nutrition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class NutritionRepositoryTest {
    @Autowired
    private INutritionRepository nutritionRepository;

    @Test
    public void INutritionRepository_SaveAll_ReturnSavedNutrition() {
        Nutrition nutrition = Nutrition.builder()
                .idNutrition(null).nomNutrition("test")
                .type("test").graisse(12).calorie(11).proteine(5).build();
        Nutrition savedNutrition= nutritionRepository.save(nutrition);
        assertNotNull(savedNutrition);
        assertNotNull(savedNutrition.getIdNutrition());

    }

}
