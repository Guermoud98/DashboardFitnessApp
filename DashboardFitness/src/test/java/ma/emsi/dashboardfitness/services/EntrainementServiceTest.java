package ma.emsi.dashboardfitness.services;

import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Utilisateur;
import ma.emsi.dashboardfitness.repositories.IEntrainementRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EntrainementServiceTest {
    @Mock
    IEntrainementRepository entrainementRepository;
    @InjectMocks
    EntrainementService entrainementService;

    @Test
   public void Should_FindEntrainement_By_Name() {
        // Given
        String name = "Glutes";
        Entrainement e = Entrainement.builder()
                .nom("WorkoutForStrongGlutes")
                .duree(40)
                .imcMax(60)
                .imcMin(20)
                .description("for get a strong glutes ")
                .build();

        List<Entrainement> entrainements = new ArrayList<>();
        entrainements.add(e);

        // Mock behavior
        when(entrainementRepository.findByNomContainingIgnoreCase(name)).thenReturn(entrainements);

        // When
        List<Entrainement> savedEntrainements = entrainementService.getEntrainementByNom(name);

        // Then
        assertNotNull(savedEntrainements);
        assertEquals(1, savedEntrainements.size());
        assertEquals("WorkoutForStrongGlutes", savedEntrainements.get(0).getNom());

        // Verify interactions
        verify(entrainementRepository, times(1)).findByNomContainingIgnoreCase(name);
    }
    @Test
    public void Should_FindEntrainement_By_Duree() {
        // Given
        int duree = 30;
        Entrainement e1 = Entrainement.builder()
                .nom("Workout1")
                .duree(30)
                .imcMax(60)
                .imcMin(20)
                .description("Workout for 30 minutes")
                .build();
        Entrainement e2 = Entrainement.builder()
                .nom("Workout2")
                .duree(30)
                .imcMax(70)
                .imcMin(25)
                .description("Another workout for 30 minutes")
                .build();

        List<Entrainement> entrainements = new ArrayList<>();
        entrainements.add(e1);
        entrainements.add(e2);

        // Mock behavior
        when(entrainementRepository.findByDuree(duree)).thenReturn(entrainements);

        // When
        List<Entrainement> savedEntrainements = entrainementService.getEntrainementByDuree(duree);

        // Then
        assertNotNull(savedEntrainements);
        assertEquals(2, savedEntrainements.size());
        assertEquals("Workout1", savedEntrainements.get(0).getNom());
        assertEquals("Workout2", savedEntrainements.get(1).getNom());

        // Verify interactions
        verify(entrainementRepository, times(1)).findByDuree(duree);

    }
    @Test
    public void Should_Suggest_Entrainement_By_IMC() {
        // Given
        Utilisateur utilisateur = Utilisateur.builder()
                .poids(70)
                .taille(1.75)
                .build();

        double imc =utilisateur.getPoids() / (utilisateur.getTaille() * utilisateur.getTaille());

        Entrainement e1 = Entrainement.builder()
                .nom("Workout1")
                .duree(30)
                .imcMax(25)  // Suitable for IMC <= 25
                .imcMin(18.5)
                .description("Workout for IMC <= 25")
                .build();
        Entrainement e2 = Entrainement.builder()
                .nom("Workout2")
                .duree(45)
                .imcMax(30)  // Suitable for IMC <= 30
                .imcMin(25)
                .description("Workout for IMC <= 30")
                .build();

        List<Entrainement> entrainements = new ArrayList<>();
        entrainements.add(e1);
        entrainements.add(e2);

        // Mock behavior
        when(entrainementRepository.findByIMCRange(imc)).thenReturn(entrainements);

        // When
        List<Entrainement> suggestedEntrainements = entrainementService.suggestEntrainementToUserByIMC(utilisateur.getPoids(),utilisateur.getTaille());

        // Then
        assertNotNull(suggestedEntrainements);
        assertEquals(2, suggestedEntrainements.size());
        assertEquals("Workout1", suggestedEntrainements.get(0).getNom());
        assertEquals("Workout2", suggestedEntrainements.get(1).getNom());

        // Verify interactions
        verify(entrainementRepository, times(1)).findByIMCRange(imc);
    }
}
