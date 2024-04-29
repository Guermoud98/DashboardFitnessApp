package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IExerciceRepository extends JpaRepository<Exercice, Long> {
    List<Exercice> findByNomContainingIgnoreCase(String nom);
}
