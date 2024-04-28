package ma.emsi.dashboardfitness.repositories;

import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Utilisateur;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EntrainementRepositoryTest {
    @Autowired
    private IEntrainementRepository entrainementRepository;
    @BeforeEach
    public void setUp() {
        entrainementRepository.save(Entrainement.builder()
                .nom("WorkoutForAss")
                .duree(50)
                .imcMax(150)
                .imcMin(60)
                .description("for get a big ass ")
                .build());

        entrainementRepository.save(Entrainement.builder()
                .nom("WorkoutForGlutes")
                .duree(30)
                .imcMax(120)
                .imcMin(70)
                .description("for get a strong glutes ")
                .build());
        entrainementRepository.save(Entrainement.builder()
                .nom("WorkoutForGlutes")
                .duree(30)
                .imcMax(120)
                .imcMin(70)
                .description("for get a weak  glutes ")
                .build());

    }
    @Test
    public void Should_Find_Entrainement_by_Nom() {
        String keyword = "glutes";
        List<Entrainement> expected= List.of(
                Entrainement.builder()
                        .nom("WorkoutForGlutes")
                        .duree(30)
                        .imcMax(120)
                        .imcMin(70)
                        .description("for get a weak  glutes ")
                        .build()
                ,
        Entrainement.builder()
                .nom("WorkoutForGlutes")
                .duree(30)
                .imcMax(120)
                .imcMin(70)
                .description("for get a strong glutes ")
                .build()
        );

        List<Entrainement> result =entrainementRepository.findByNom(keyword);
       AssertionsForClassTypes.assertThat(result).isNotNull();
    }



}

