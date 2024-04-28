package ma.emsi.dashboardfitness.repositories;

import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Nutrition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EntrainementRepositoryTest {
    @Autowired
    private IEntrainementRepository entrainementRepository;


    @Test
    public void IEntrainenementRepository_SaveAll_ReturnSavedEntrainement() {
        //Given

        Entrainement entrainement = Entrainement.builder()
                .idEntrainement(null)
                .nom("WorkoutForAss")
                .duree(50)
                .imcMax(150)
                .imcMin(60)
                .description("for get a big ass ")
                .build();

        //When
        Entrainement savedEntrainement = entrainementRepository.save(entrainement);
        // Then
        Assertions.assertThat(savedEntrainement).isNotNull();
        Assertions.assertThat(savedEntrainement.getIdEntrainement()).isGreaterThan(0);



    }

}

