package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEntrainementRepository extends JpaRepository<Entrainement, Long> {
    Entrainement findByNom(String name);
    Entrainement findByDuree(int duree);
    Entrainement findByNutrition (Nutrition nutrition);

}
