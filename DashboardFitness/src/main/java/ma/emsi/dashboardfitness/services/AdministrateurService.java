package ma.emsi.dashboardfitness.services;


import jdk.jshell.execution.Util;
import ma.emsi.dashboardfitness.entities.Administrateur;
import ma.emsi.dashboardfitness.entities.Exercice;
import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.entities.Utilisateur;
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
    //couplage faible
    public AdministrateurService(IAdministrateurRepository administrateurRepository,NutritionService nutritionService, ExerciceService exerciceService, UtilisateurService utilisateurService) {
        this.administrateurRepository = administrateurRepository;
        this.nutritionService = nutritionService;
       this.exerciceService = exerciceService;
       this.utilisateurService = utilisateurService;
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




}
