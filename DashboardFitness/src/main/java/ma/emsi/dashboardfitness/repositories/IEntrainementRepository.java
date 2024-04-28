package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IEntrainementRepository extends JpaRepository<Entrainement, Long> {
    List<Entrainement> findByNom(String name);
    Optional<Entrainement> findByDuree(long duree);
    Optional<Entrainement> findByNutrition (Nutrition nutrition);
    @Query("SELECT e FROM Entrainement e WHERE e.imcMin <= :imc AND e.imcMax >= :imc")
    Optional<Entrainement> findByIMCRange(double imc);
}
