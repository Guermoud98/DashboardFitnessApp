package ma.emsi.dashboardfitness.services;


import jdk.jshell.execution.Util;
import ma.emsi.dashboardfitness.entities.*;
import ma.emsi.dashboardfitness.repositories.IAdministrateurRepository;
import ma.emsi.dashboardfitness.repositories.INutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurService {
    private IAdministrateurRepository administrateurRepository;
    private NutritionService nutritionService;
    private ExerciceService exerciceService;
    private UtilisateurService utilisateurService;
    private EntrainementService entrainementService;
    //couplage faible
    public AdministrateurService(IAdministrateurRepository administrateurRepository,NutritionService nutritionService, ExerciceService exerciceService, UtilisateurService utilisateurService, EntrainementService entrainementService) {
        this.administrateurRepository = administrateurRepository;
        this.nutritionService = nutritionService;
       this.exerciceService = exerciceService;
       this.utilisateurService = utilisateurService;
       this.entrainementService = entrainementService;
    }
    /******************************Admin login*************************************/
    public Administrateur AdminLogin(String username, String password) {
        Administrateur administrateur = administrateurRepository.findByLoginAndPassword(username,password);
        if(administrateur != null) {
            System.out.println("Welcome " + username);
            return administrateur;
        }
        return null;
    }
    /******************************Nutrition*************************************/
    public Nutrition createNutrition(Nutrition nutrition) {
        return nutritionService.ajouterNutrition(nutrition);
    }
    public List<Nutrition> afficherNutritions() {
        return nutritionService.afficherNutritions();
    }
    public void deleteNutritionById(Long id) {
        nutritionService.supprimerNutritionById(id);
    }
    public Nutrition afficherNutritionById(Long id) {
        return nutritionService.getNutritionById(id);
    }
    public void updateNutrition(Long id , Nutrition updatedNutrition) {
        nutritionService.modifierNutrition(id, updatedNutrition);
    }

    /****************************** Exercices *************************************/
    public Exercice creerExercice(Exercice exercice) {
        return exerciceService.ajouterExercice(exercice);
    }
    public List<Exercice> afficherExercices() {
        return exerciceService.afficherExercices();
    }
    public void deleteExercice(Long id) {
        exerciceService.supprimerExerciceById(id);
    }
    public void modifierExercice(Long id , Exercice updatedExercice) {
        exerciceService.modifierExercice(id, updatedExercice);
    }
    public Exercice getExerciceById(Long idExercice) {
        return exerciceService.getExerciceById(idExercice);
    }

    /****************************** Users *************************************/

    /*public Utilisateur login(Utilisateur utilisateur) {
        return utilisateurService.Register(utilisateur);
    }*/
    public Utilisateur UpdateUtilisateur(Utilisateur utilisateur) {
        return utilisateurService.UpdateUtilisateur(utilisateur);
    }
    public void DeleteUtilisateurById(Long id) {
        utilisateurService.DeleteUtilisateurById(id);
    }
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurService.getUtilisateurById(id);
    }
    public Utilisateur UpdateUtilisateurById(long id) {
        Utilisateur exist = utilisateurService.getUtilisateurById(id);
        if (exist != null) {
            return utilisateurService.UpdateUtilisateur(exist);
        }
        return null;
    }
    public List<Utilisateur> getUtilisateursByNom(String nom) {
        return utilisateurService.getUtilisateursByNom(nom);
    }
    public List<Utilisateur> getUtilisateursByPrenom(String prenom) {
        return utilisateurService.getUtilisateursByPrenom(prenom);
    }

    public List<Utilisateur> getUtilisateursByTaille(long taille) {
        return utilisateurService.getUtilisateursByTaille(taille);
    }

    public List<Utilisateur> getUtilisateursByPoids(int poids) {
        return utilisateurService.getUtilisateursByPoids(poids);
    }

    /****************************** Entrainement *************************************/

    public List<Entrainement> getAllEntrainements() {
        return entrainementService.getAllEntrainements();
    }
    public List<Entrainement> getEntrainementByNom(String name) {
        return entrainementService.getEntrainementByNom(name);
    }

    public List<Entrainement> getEntrainementByDuree(int duree) {
        return entrainementService.getEntrainementByDuree(duree);
    }

    public Entrainement getEntrainementById(Long id) {
        return entrainementService.getEntrainementById(id);
    }

    public List<Entrainement> getEntrainementsByNutrition(String nomNutrition) {
        return entrainementService.getEntrainementsByNutrition(nomNutrition);
    }





}
