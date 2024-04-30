package ma.emsi.dashboardfitness.services;


import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.repositories.INutritionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class NutritionServiceTest {

    @Mock
    private INutritionRepository nutritionRepository;

    @InjectMocks
    private NutritionService nutritionService;

    @Test
    public void ajouterNutritionTest() {
        //given
        Nutrition nutrition = Nutrition.builder()
                .nomNutrition("test")
                .type("test")
                .graisse(12)
                .calorie(11)
                .proteine(5)
                .build();
        // Cette ligne définit un comportement simulé pour la méthode save du repository
        given(nutritionRepository.save(nutrition)).willReturn(nutrition);
        // La méthode qu'on veut tester
        Nutrition savedNutrition = nutritionService.ajouterNutrition(nutrition);
        assertEquals(nutrition,savedNutrition);
        /*La ligne verify vérifie si le comportement simulé qu'on a défini avec given
         correspond à ce qui se passe réellement lorsqu'on appelle la méthode ajouterNutrition
         du service*/
        verify(nutritionRepository, times(1)).save(nutrition);






    }




}
