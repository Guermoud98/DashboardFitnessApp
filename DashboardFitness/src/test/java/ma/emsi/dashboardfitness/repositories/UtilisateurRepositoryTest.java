package ma.emsi.dashboardfitness.repositories;
import ma.emsi.dashboardfitness.entities.Utilisateur;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)

public class UtilisateurRepositoryTest {
@Autowired
    private IUtilisateurRepository utilisateurRepository;
 @BeforeEach
    public void setUp() {
     utilisateurRepository.save(Utilisateur.builder().prenom("ettaleby").nom("neha").email("neha@example.com").password("Neha123!").poids(63).taille(162).build());
     utilisateurRepository.save(Utilisateur.builder().prenom("ettaleby").nom("leila").email("leila@example.com").password("Leila123!").poids(63).taille(162).build());
     utilisateurRepository.save(Utilisateur.builder().prenom("ettaleby").nom("houda").email("houda@example.com").password("Houda123!").poids(63).taille(162).build());

 }
 @Test
 public void Should_Find_Utilisateur_ByEmail() {

     String givenEmail = "leila@example.com";
     Utilisateur result = utilisateurRepository.findByEmail(givenEmail);
     AssertionsForClassTypes.assertThat(result).isNotNull();

 }
    @Test
    public void Should_Not_Find_Utilisateur_ByEmail() {

        String givenEmail = "xxx@xxxxx.com";
        Utilisateur result = utilisateurRepository.findByEmail(givenEmail);
        AssertionsForClassTypes.assertThat(result).isNull();

    }

}