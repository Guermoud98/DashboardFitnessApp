package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IEntrainementRepository extends JpaRepository<Entrainement, Long> {
    List<Entrainement> findByNomContainingIgnoreCase(String name);
    List<Entrainement> findByDuree(long duree);
    @Query("SELECT e FROM Entrainement e WHERE e.imcMin <= :imc AND e.imcMax >= :imc")
    List<Entrainement> findByIMCRange(double imc);
}
