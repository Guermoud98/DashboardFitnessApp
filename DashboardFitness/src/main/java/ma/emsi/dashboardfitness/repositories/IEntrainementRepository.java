package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//class workout

public interface IEntrainementRepository extends JpaRepository<Entrainement, Long> {
    Entrainement findByname(String name);
    Entrainement findByduree(long duree);
    Entrainement findBynutrition(Nutrition nutrition);
    @Query("SELECT e FROM Entrainement e WHERE e.imcMin <= :imc AND e.imcMax >= :imc")
    Entrainement findByIMCRange(double imc);
}
