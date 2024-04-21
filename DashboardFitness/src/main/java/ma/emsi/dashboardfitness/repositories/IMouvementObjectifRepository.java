package src.main.java.ma.emsi.dashboardfitness.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import src.main.java.ma.emsi.dashboardfitness.entities.MouvementObjectif;

public interface IMouvementObjectifRepository  extends JpaRepository<MouvementObjectif, Long> {
}
