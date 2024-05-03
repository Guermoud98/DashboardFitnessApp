package ma.emsi.dashboardfitness.services;

import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.repositories.IEntrainementRepository;
import ma.emsi.dashboardfitness.repositories.INutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntrainementService {
    private final IEntrainementRepository entrainementRepository;
    private final INutritionRepository nutritionRepository;


    @Autowired
    public EntrainementService(IEntrainementRepository entrainementRepository, INutritionRepository nutritionRepository) {
        this.entrainementRepository = entrainementRepository;
        this.nutritionRepository = nutritionRepository;
    }

    /*************************** Affichage For User And Admin ****************************************/
    public List<Entrainement> getAllEntrainements() {
        return entrainementRepository.findAll();
    }

    public List<Entrainement> getEntrainementByNom(String name) {
        List<Entrainement> result = entrainementRepository.findByNomContainingIgnoreCase(name);
        return result;
    }

    public List<Entrainement> getEntrainementByDuree(int duree) {
        return entrainementRepository.findByDuree(duree);
    }

    public Entrainement getEntrainementById(Long id) {
        return entrainementRepository.findByIdEntrainement(id).orElse(null);
    }

    //affiche les entrainements associes a la nutrition recherche
    public List<Entrainement> getEntrainementsByNutrition(String nomNutrition) {
        List<Nutrition> nutritions = nutritionRepository.findByNomNutritionContainingIgnoreCase(nomNutrition);
        // Créer une liste pour stocker tous les entraînements associés à toutes les nutritions trouvées
        List<Entrainement> entrainements = new ArrayList<>();
        // Parcourir toutes les nutritions
        for (Nutrition nutrition : nutritions) {
            // Récupérer les entraînements associés à la nutrition actuelle
            List<Entrainement> entrainementsAssocies = entrainementRepository.findByNutrition(nutrition);

            // Ajouter les entraînements associés à la liste globale d'entraînements
            entrainements.addAll(entrainementsAssocies);


        }
        return entrainements;
    }
    /******************* For Admin ***********/
    /********************** Create Entrainenement **********************/
    public void createEntrainement(Entrainement entrainement) {
        entrainementRepository.save(entrainement);
    }
    /***************************Delete Entrainement *******************/
    public void deleteEntrainement(Entrainement entrainement) {
        entrainementRepository.delete(entrainement);
    }
    public void deleteEntrainementById(Long id) {
        entrainementRepository.deleteById(id);
    }
    /***************************Update  Entrainement *******************/
    public Entrainement updateEntrainement(Entrainement entrainement) {
        Entrainement existingEntrainement = entrainementRepository.findById(entrainement.getIdEntrainement()).orElse(null);

        if (existingEntrainement != null) {
            existingEntrainement.setNom(entrainement.getNom() != null ? entrainement.getNom() : existingEntrainement.getNom());
            existingEntrainement.setDuree(entrainement.getDuree() != 0 ? entrainement.getDuree() : existingEntrainement.getDuree());
            existingEntrainement.setDescription(entrainement.getDescription() != null ? entrainement.getDescription() : existingEntrainement.getDescription());
            existingEntrainement.setImcMin(entrainement.getImcMin() != 0 ? entrainement.getImcMin() : existingEntrainement.getImcMin());
            existingEntrainement.setImcMax(entrainement.getImcMax() != 0 ? entrainement.getImcMax() : existingEntrainement.getImcMax());
            existingEntrainement.setNutrition(entrainement.getNutrition() != null ? entrainement.getNutrition() : existingEntrainement.getNutrition());

            return entrainementRepository.save(existingEntrainement);
        }

        return null;
    }
    public void updateEntrainementById(long id, Entrainement entrainement) {
        Entrainement exist = entrainementRepository.findByIdEntrainement(id).orElse(null);
        if (exist != null) {
           exist.setNom((entrainement.getNom()));
           exist.setDescription(entrainement.getDescription());
           exist.setImcMin((entrainement.getImcMin()));
           exist.setImcMax((entrainement.getImcMax()));
           exist.setNutrition((entrainement.getNutrition()));
           exist.setDuree(entrainement.getDuree());
        }

    }

    /***** For user ************/
    public List<Entrainement> suggestEntrainementToUserByIMC(double weight, double height) {
        //this method suggest to the user the suitable workout according to his IMC
        //We consider that by default each workout has a Nutrition(By ForeingKey of it ) so suggestEntrainementToUserByIMC implique suggestion of Nutrition
        double imc = weight / (height * height);
        return entrainementRepository.findByIMCRange(imc);
    }


}
