package ma.emsi.dashboardfitness.services;

import ma.emsi.dashboardfitness.entities.Exercice;
import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.repositories.IExerciceRepository;

public class ExerciceService {
    private IExerciceRepository exerciceRepository;

    //injection de dependance
    public ExerciceService(IExerciceRepository exerciceRepository) {
        this.exerciceRepository = exerciceRepository;
    }
    //l'ajout d'un exercice par l'admin a la base de donnee
    public void ajouterExercice(Exercice exercice) {
        exerciceRepository.save(exercice);
    }
    //supprimer un exercice par l'admin de la base de donnee
    public void supprimerexercice(Exercice exercice) {
        exerciceRepository.delete(exercice);
    }
}
