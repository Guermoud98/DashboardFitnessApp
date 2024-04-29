package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface INutritionRepository extends JpaRepository<Nutrition, Long> {
    List<Nutrition> findByNomNutritionContainingIgnoreCase(String name);
}
