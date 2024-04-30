package ma.emsi.dashboardfitness.services;


import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.repositories.INutritionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Optional;

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
    @Test
    public void supprimerNutritionTest() {
        //given
        Nutrition nutrition = Nutrition.builder()
                .nomNutrition("test")
                .type("test")
                .graisse(12)
                .calorie(11)
                .proteine(5)
                .build();
        // Définir le comportement simulé pour la méthode save du nutritionRepository
        when(nutritionRepository.save(nutrition)).thenReturn(nutrition);

        Nutrition savedNutrition = nutritionRepository.save(nutrition);
        //la nutrition qu'on veut supprimer
        nutritionService.supprimerNutrition(savedNutrition);
        //assertEquals(nutritionToDelete,expectednutrition);
        // Vérifier que la méthode delete a été appelée avec la nutrition à supprimer
        verify(nutritionRepository, times(1)).delete(savedNutrition);
    }
    @Test
    public void modifierNutritionTest() {
        // Given
        Long id = 1L;
        Nutrition existingNutrition = Nutrition.builder()
                .idNutrition(id)
                .nomNutrition("existing nutrition")
                .type("existing type")
                .calorie(100)
                .proteine(50)
                .graisse(20)
                .build();
        Nutrition updatedNutrition = Nutrition.builder()
                .nomNutrition("updated nutrition")
                .type("updated type")
                .calorie(200)
                .proteine(100)
                .graisse(40)
                .build();

        // Définir le comportement simulé pour la méthode findById du nutritionRepository
        when(nutritionRepository.findById(id)).thenReturn(Optional.of(existingNutrition));

        // When
        nutritionService.modifierNutrition(id, updatedNutrition);

        // Then
        // Vérifier que la méthode findById a été appelée avec l'ID spécifié
        verify(nutritionRepository, times(1)).findById(id);

        // Vérifier que les champs de la nutrition existante ont été mis à jour avec les valeurs de la nutrition mise à jour
        assertEquals(updatedNutrition.getNomNutrition(), existingNutrition.getNomNutrition());
        assertEquals(updatedNutrition.getType(), existingNutrition.getType());
        assertEquals(updatedNutrition.getCalorie(), existingNutrition.getCalorie());
        assertEquals(updatedNutrition.getProteine(), existingNutrition.getProteine());
        assertEquals(updatedNutrition.getGraisse(), existingNutrition.getGraisse());

        // Vérifier que la méthode save a été appelée avec la nutrition existante mise à jour
        verify(nutritionRepository, times(1)).save(existingNutrition);
    }




}
