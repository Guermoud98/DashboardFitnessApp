package ma.emsi.dashboardfitness.repositories;

import ma.emsi.dashboardfitness.entities.Administrateur;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AdministrateurRepositoryTest {
    @Autowired
    private IAdministrateurRepository administrateurRepository;
    @BeforeEach
    public void setUp (){
        Administrateur administrateur = Administrateur.builder()
                .login("administrateur")
                .password("administrateur")
                .build();
        administrateurRepository.save(administrateur);
    }
    @Test
    public void IAdministrateurRepository_findByLoginAndPassword_ReturnAdministrateur(){
        Administrateur expected = Administrateur.builder()
                .login("administrateur")
                .password("administrateur")
                .build();
        Administrateur result = administrateurRepository.findByLoginAndPassword("administrateur", "administrateur");
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getLogin()).isEqualTo(expected.getLogin());
        Assertions.assertThat(result.getPassword()).isEqualTo(expected.getPassword());


    }
}
