package src.main.java.ma.emsi.dashboardfitness.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import src.main.java.ma.emsi.dashboardfitness.entities.Administrateur;

public interface IAdministrateurRepository extends JpaRepository<Administrateur, Long> {
    boolean findLoginAndPassword(String login, String password);
}
