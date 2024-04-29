package ma.emsi.dashboardfitness.services;

import ma.emsi.dashboardfitness.repositories.IUtilisateurRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UtilisateurServiceTest {

    @Mock
    private IUtilisateurRepository utilisateurRepository;
    @InjectMocks
    private UtilisateurService utilisateurService;
    @Test
    public void Should_Return_True_For_Valid_Email() {
        // Given
        String validEmail = "utilisateur@example.com";

        // When
        boolean result = utilisateurService.isValidEmail(validEmail);

        // Then
        AssertionsForClassTypes.assertThat(result).isTrue();
    }
    @Test
    public void Should_Return_True_For_Wrong_Email() {
        // Given
        String wrongEmail = "invalid.email"; // This email does not contain '@'
        // When
        boolean result = utilisateurService.isValidEmail(wrongEmail);
        // Then
        AssertionsForClassTypes.assertThat(result).isFalse();
    }




}
