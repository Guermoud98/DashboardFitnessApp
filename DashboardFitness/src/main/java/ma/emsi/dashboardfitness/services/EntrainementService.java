package ma.emsi.dashboardfitness.services;

import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.entities.Utilisateur;
import ma.emsi.dashboardfitness.repositories.IEntrainementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrainementService {
    private final IEntrainementRepository entrainementRepository;
    private final UtilisateurService utilisateurService;


    @Autowired
    public EntrainementService(IEntrainementRepository entrainementRepository, UtilisateurService utilisateurService) {
        this.entrainementRepository = entrainementRepository;
        this.utilisateurService = utilisateurService;
    }

    public Entrainement findEntrainementByName(String name) {
        return entrainementRepository.findByNom(name);
    }

    public Entrainement findEntrainementByDuree(int duree) {
        return entrainementRepository.findByDuree(duree);
    }

    public Entrainement findEntrainementByNutrition(Nutrition nutrition) {
        return entrainementRepository.findByNutrition(nutrition);
    }
   /* public Entrainement suggestEntrainement(Utilisateur utilisateur) {
        //this method suggest to the user the suitable workout according to his IMC
        //We consider that by default each workout has a Nutrition(By ForeingKey of it ) so suggestEntrainement implique suggestion of Nutrition
        double weight =utilisateur.getPoids();
        double height = utilisateur.getTaille();
        double imc = weight / (height * height);
       return entrainementRepository.findByIMCRange(imc);
    }*/


}