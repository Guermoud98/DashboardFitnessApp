package ma.emsi.dashboardfitness.repositories;


import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IExerciceRepository extends JpaRepository<Exercice, Long> {
    List<Exercice> findByNomContainingIgnoreCase(String nom);
}

