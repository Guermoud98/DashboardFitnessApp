package ma.emsi.dashboardfitness.services;

import ma.emsi.dashboardfitness.entities.Utilisateur;
import ma.emsi.dashboardfitness.repositories.IUtilisateurRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UtilisateurServiceTest {

    @Mock
    private IUtilisateurRepository utilisateurRepository;
    @InjectMocks
    private UtilisateurService utilisateurService;

    @BeforeEach
    public void setUp() {
        // à modifier en utilisant saveUtilisateur instead
        utilisateurRepository.save(Utilisateur.builder().prenom("ettaleby").nom("neha").email("neha@example.com").password("Neha123!").poids(63).taille(162).build());
        utilisateurRepository.save(Utilisateur.builder().prenom("ettaleby").nom("leila").email("leila@example.com").password("Leila123!").poids(63).taille(162).build());
        utilisateurRepository.save(Utilisateur.builder().prenom("ettaleby").nom("houda").email("houda@example.com").password("Houda123!").poids(63).taille(162).build());

    }

    @Test
    public void Should_Return_Utilisateur_For_Valid_Login_Credentials() {
        // Given
        String email = "neha@example.com";
        String password = "Neha123!";

        // Create a mock utilisateur with encoded password
        Utilisateur mockUtilisateur = Utilisateur.builder()
                .prenom("ettaleby")
                .nom("neha")
                .email(email)
                .password(password)
                .poids(63)
                .taille(162)
                .build();

        // Configure the mock repository to return the mock utilisateur when findByEmail is called with the email
        when(utilisateurRepository.findByEmail(email).orElse(null)).thenReturn(mockUtilisateur);

        // When
        Utilisateur loginUtilisateur = utilisateurService.Login(email, password);

        // Then
        Assertions.assertThat(loginUtilisateur).isNotNull();
        Assertions.assertThat(loginUtilisateur.getEmail()).isEqualTo(email);

        // Verify that findByEmail is called with the expected email
        verify(utilisateurRepository, times(1)).findByEmail(email);
    }
    @Test
    public void Should_Return_Null_When_Passwords_Do_Not_Match() {
        // Given
        String email = "neha@example.com";
        String password = "Neha123!";

        // Create a mock utilisateur with a different password
        Utilisateur mockUtilisateur = Utilisateur.builder()
                .prenom("ettaleby")
                .nom("neha")
                .email(email)
                .password(password)
                .poids(63)
                .taille(162)
                .build();

        // Configure the mock repository to return the mock utilisateur when findByEmail is called with the email
        when(utilisateurRepository.findByEmail(email).orElse(null)).thenReturn(mockUtilisateur);

        // When
        Utilisateur loginUtilisateur = utilisateurService.Login(email, password);

        // Then
        Assertions.assertThat(loginUtilisateur).isNull();

        // Verify that findByEmail is called with the expected email
        verify(utilisateurRepository, times(1)).findByEmail(email);
    }

    @Test
    public void Should_Register_Utilisateur() {
        // Given
        Utilisateur utilisateur = Utilisateur.builder()
                .prenom("John")
                .nom("Doe")
                .email("john.doe@example.com")
                .password("Password123!")
                .poids(70)
                .taille(175)
                .build();

        // Create a mock utilisateur with the encoded password
        Utilisateur mockUtilisateur = Utilisateur.builder()
                .prenom(utilisateur.getPrenom())
                .nom(utilisateur.getNom())
                .email(utilisateur.getEmail())
                .password(utilisateur.getPassword())
                .poids(utilisateur.getPoids())
                .taille(utilisateur.getTaille())
                .build();

        // Configure the mock repository to return the mock utilisateur when save is called
        when(utilisateurRepository.save(utilisateur)).thenReturn(mockUtilisateur);

        // When
        Utilisateur registeredUtilisateur = utilisateurService.Register(utilisateur);

        // Then
        Assertions.assertThat(registeredUtilisateur).isNotNull();
        Assertions.assertThat(registeredUtilisateur.getEmail()).isEqualTo(utilisateur.getEmail());

        // Verify that save is called with the utilisateur object
        verify(utilisateurRepository, times(1)).save(utilisateur);
    }
    @Test
    public void Should_Throw_Exception_When_Invalid_Email() {
        // Given
        Utilisateur utilisateur = Utilisateur.builder()
                .prenom("John")
                .nom("Doe")
                .email("invalid-email")
                .password("Password123!")
                .poids(70)
                .taille(175)
                .build();

        // When
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> utilisateurService.Register(utilisateur));

        // Verify that save is not called
        verify(utilisateurRepository, never()).save(utilisateur);
    }
    @Test
    public void Should_Throw_Exception_When_Invalid_Password() {
        // Given
        Utilisateur utilisateur = Utilisateur.builder()
                .prenom("John")
                .nom("Doe")
                .email("john.doe@example.com")
                .password("weakpassword")
                .poids(70)
                .taille(175)
                .build();

        // When/Then
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> utilisateurService.Register(utilisateur));

        // Verify that save is not called
        verify(utilisateurRepository, never()).save(utilisateur);
    }



}
