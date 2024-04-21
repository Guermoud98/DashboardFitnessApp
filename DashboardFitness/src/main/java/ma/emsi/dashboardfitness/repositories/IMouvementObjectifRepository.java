package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.MouvementObjectif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMouvementObjectifRepository  extends JpaRepository<MouvementObjectif, Long> {
}
