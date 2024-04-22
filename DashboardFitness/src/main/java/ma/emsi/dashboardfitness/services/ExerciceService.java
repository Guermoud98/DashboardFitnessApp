package ma.emsi.dashboardfitness.services;

import ma.emsi.dashboardfitness.repositories.IExerciceRepository;

public class ExerciceService {
    private IExerciceRepository exerciceRepository;

    //injection de dependance
    public ExerciceService(IExerciceRepository exerciceRepository) {
        this.exerciceRepository = exerciceRepository;
    }
}
