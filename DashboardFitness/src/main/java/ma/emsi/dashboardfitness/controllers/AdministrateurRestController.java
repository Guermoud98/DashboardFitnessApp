package ma.emsi.dashboardfitness.controllers;

import ma.emsi.dashboardfitness.entities.Exercice;
import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.repositories.IAdministrateurRepository;
import ma.emsi.dashboardfitness.services.AdministrateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdministrateurRestController {
    private AdministrateurService administrateurService;

    public AdministrateurRestController(AdministrateurService administrateurService) {
        this.administrateurService = administrateurService;
    }

    /***************************Nutritions***********************/
    @GetMapping(path = "/nutritions/afficherTous")
    public List<Nutrition> getNutritions() {
        return administrateurService.afficherNutritions();
    }
    @DeleteMapping(path ="/nutritions/deletebyId/{idNutrition}" )
    public void deleteNutritionsbyId(@PathVariable Long idNutrition) {
        administrateurService.deleteNutritionById( idNutrition);
    }
    @GetMapping(path = "/nutritions/afficherById/{idNutrition}" )
    public Nutrition getNutritionById(@PathVariable Long idNutrition) {
        return administrateurService.afficherNutritionById(idNutrition);
    }
    @PutMapping(path="/nutritions/updateNutrition/{idNutrition}")
    public void updateNutritions(@PathVariable Long idNutrition, @RequestBody Nutrition updatedNutrition) {
        administrateurService.updateNutrition(idNutrition, updatedNutrition);
    } //doesn't work
    @PostMapping(path ="nutritions/create")
    public Nutrition creerNutrition(@RequestBody Nutrition nutrition) {
        return administrateurService.createNutrition(nutrition);
    }

    /***************************Exercice***********************/
    @PostMapping(path= "/exercices/create")
    public Exercice createExercice(@RequestBody Exercice exercice) {
        return administrateurService.creerExercice(exercice);
    }
    @DeleteMapping(path="/exercices/supprimerById")
    public void supprimerExercice(Long idExercice) {
        administrateurService.deleteExercice(idExercice);
    }
    @PutMapping(path="/exercices/updateExercice/{idExercice}")
    public void modifierExercice(@PathVariable Long idExercice, @RequestParam Exercice updatedExercice) {
        administrateurService.modifierExercice(idExercice, updatedExercice);
    }
    @GetMapping(path="/exercices/afficherTous")
    public List<Exercice> getExercices() {
        return administrateurService.afficherExercices();
    }


}
