package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IAdministrateurRepository extends JpaRepository<Administrateur, Long> {
    boolean findByLoginAndPassword(String login, String password);
}
