package src.main.java.ma.emsi.dashboardfitness.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import src.main.java.ma.emsi.dashboardfitness.entities.Exercice;

public interface IExerciceRepository extends JpaRepository<Exercice, Long> {
}
