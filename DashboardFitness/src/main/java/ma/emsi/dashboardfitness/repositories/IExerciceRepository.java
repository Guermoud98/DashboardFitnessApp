package ma.emsi.dashboardfitness.repositories;
import ma.emsi.dashboardfitness.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExerciceRepository extends JpaRepository<Exercice, Long> {
}
