package ma.emsi.dashboardfitness.services;


import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.repositories.INutritionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
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
                .idNutrition(null).nomNutrition("test")
                .type("test").graisse(12).calorie(11).proteine(5).build();
        // Cette ligne définit un comportement simulé pour la méthode save du repository
        given(nutritionRepository.save(nutrition)).willReturn(nutrition);
        // La méthode qu'on veut tester
        Nutrition savedNutrition = nutritionService.ajouterNutrition(nutrition);
        assertNotNull(savedNutrition);
        /*La ligne verify vérifie si le comportement simulé qu'on a défini avec given
         correspond à ce qui se passe réellement lorsqu'on appelle la méthode ajouterNutrition
         du service*/
        verify(nutritionRepository, times(1)).save(nutrition);






    }

    /*
    @Autowired
    private INutritionRepository nutritionRepository;

    @Test
    public void INutritionRepository_AjouterNutrition_ReturnSavedNutrition() {
        Nutrition nutrition = Nutrition.builder()
                .idNutrition(null).nomNutrition("test")
                .type("test").graisse(12).calorie(11).proteine(5).build();
        //on cherche le nom de la nutrition
        Nutrition existingNutrition = nutritionRepository.findByNomNutrition(nutrition.getNomNutrition());
        //s'il n'existe pas dans la bd
        if (existingNutrition == null) {
            Nutrition savedNutrition= nutritionRepository.save(nutrition);
            assertNotNull(savedNutrition);
            assertNotNull(savedNutrition.getIdNutrition());
        }
        //s'il existe
        else {
            assertNull(existingNutrition.getIdNutrition());

        }
    }
    */


}
