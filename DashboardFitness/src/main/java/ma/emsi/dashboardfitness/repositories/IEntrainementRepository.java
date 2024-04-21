package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.Entrainement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEntrainementRepository extends JpaRepository<Entrainement, Long> {
}
