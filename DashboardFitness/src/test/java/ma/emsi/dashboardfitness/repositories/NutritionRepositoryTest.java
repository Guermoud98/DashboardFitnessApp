package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.Nutrition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
//@ContextConfiguration("/pom.xml")
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
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

    }




}
