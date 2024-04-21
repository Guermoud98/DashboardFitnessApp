package src.main.java.ma.emsi.dashboardfitness.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import src.main.java.ma.emsi.dashboardfitness.entities.Nutrition;

public interface INutritionRepository extends JpaRepository<Nutrition, Long> {

}
