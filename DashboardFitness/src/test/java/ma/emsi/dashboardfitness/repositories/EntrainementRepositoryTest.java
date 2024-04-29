package ma.emsi.dashboardfitness.repositories;

import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Nutrition;
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
    @Autowired
    private INutritionRepository nutritionRepository;
    @BeforeEach
    public void setUp() {

        Nutrition n1=Nutrition.builder()
                .nomNutrition("Glute-Building Meal")
                .type("Pre-workout")
                .graisse(10) // in grams
                .calorie(400) // in calories
                .proteine(25) // in grams
                .build();
        Nutrition n2=Nutrition.builder()
                .nomNutrition("Glute-Strengthening Meal")
                .type("Post-workout")
                .graisse(8) // in grams
                .calorie(350) // in calories
                .proteine(20) // in grams
                .build();
        nutritionRepository.save(n1);
        nutritionRepository.save(n2);

        entrainementRepository.save(Entrainement.builder()
                .nom("WorkoutForStrongGlutes")
                .duree(40)
                .imcMax(60)
                .imcMin(20)
                .description("for get a strong glutes ")
                .nutrition(n1)//link each workout with his meal
                .build());
        entrainementRepository.save(Entrainement.builder()
                .nom("WorkoutForWeakGlutes")
                .duree(30)
                .imcMax(120)
                .imcMin(70)
                .description("for get a weak  glutes ")
                .nutrition(n2)
                .build());

    }
    @Test
    public void Should_Find_Entrainement_by_Nom() {
        String keyword = "Glutes";
        List<Entrainement> expected= List.of(
                Entrainement.builder()
                        .idEntrainement(1L)
                        .nom("WorkoutForStrongGlutes")
                        .duree(40)
                        .imcMax(60)
                        .imcMin(20)
                        .description("for get a strong glutes ")
                        .nutrition(Nutrition.builder()
                                .idNutrition(1L)
                                .nomNutrition("Glute-Building Meal")
                                .type("Pre-workout")
                                .graisse(10) // in grams
                                .calorie(400) // in calories
                                .proteine(25) // in grams
                                .build())
                        .build()
                ,
        Entrainement.builder()
                .idEntrainement(2L)
                .nom("WorkoutForWeakGlutes")
                .duree(30)
                .imcMax(120)
                .imcMin(70)
                .description("for get a weak  glutes ")
                .nutrition(Nutrition.builder()
                                .idNutrition(2L)
                                .nomNutrition("Glute-Strengthening Meal")
                                .type("Post-workout")
                                .graisse(8) // in grams
                                .calorie(350) // in calories
                                .proteine(20) // in grams
                                .build())
                .build()
        );

        List<Entrainement> result =entrainementRepository.findByNomContainingIgnoreCase(keyword);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEqualTo(expected);
        Assertions.assertThat(result.size()).isEqualTo(expected.size());
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
    @Test
    public void Should_Find_Entrainement_by_Duree() {
        long givenDuree=30;
        List<Entrainement> expected= List.of(  Entrainement.builder()
                .idEntrainement(2L)
                .nom("WorkoutForWeakGlutes")
                .duree(30)
                .imcMax(120)
                .imcMin(70)
                .description("for get a weak  glutes ")
                .nutrition(Nutrition.builder()
                        .idNutrition(2L)
                        .nomNutrition("Glute-Strengthening Meal")
                        .type("Post-workout")
                        .graisse(8) // in grams
                        .calorie(350) // in calories
                        .proteine(20) // in grams
                        .build())
                .build()

        );
        List<Entrainement> result =entrainementRepository.findByDuree(givenDuree);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEqualTo(expected);
        Assertions.assertThat(result.size()).isEqualTo(expected.size());
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

@Test
    public void Should_Find_Entrainement_by_Imc() {
        double imc=90;
         List<Entrainement> expected= List.of(  Entrainement.builder()
                 .idEntrainement(2L)
                 .nom("WorkoutForWeakGlutes")
                 .duree(30)
                 .imcMax(120)
                 .imcMin(70)
                 .description("for get a weak  glutes ")
                 .nutrition(Nutrition.builder()
                         .idNutrition(2L)
                         .nomNutrition("Glute-Strengthening Meal")
                         .type("Post-workout")
                         .graisse(8) // in grams
                         .calorie(350) // in calories
                         .proteine(20) // in grams
                         .build())
                 .build()
         );

        List<Entrainement>result=entrainementRepository.findByIMCRange(imc);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEqualTo(expected);
        Assertions.assertThat(result.size()).isEqualTo(expected.size());
        Assertions.assertThat(result.size()).isEqualTo(1);
       for (Entrainement entrainement : result) {
        AssertionsForClassTypes.assertThat(entrainement.getImcMin()).isLessThanOrEqualTo(imc);
        AssertionsForClassTypes.assertThat(entrainement.getImcMax()).isGreaterThanOrEqualTo(imc);
        System.out.println(entrainement);
      }

}


}

