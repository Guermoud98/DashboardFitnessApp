package ma.emsi.dashboardfitness.controllers;

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
    @GetMapping(path = "/nutritions")
    public List<Nutrition> getNutritions() {
        return administrateurService.afficherNutritions();
    }
    @GetMapping(path ="/nutritions/deletebyId/{idNutrition}" )
    public void deleteNutritionsbyId(@PathVariable Long idNutrition) {
        administrateurService.deleteNutritionById( idNutrition);
    }
    @GetMapping(path = "/nutritions/afficherById/{idNutrition}" )
    public Nutrition getNutritionById(@PathVariable Long idNutrition) {
        return administrateurService.afficherNutritionById(idNutrition);
    }
    @PutMapping(path="/nutritions/updateNutritions/{idNutrition}")
    public void updateNutritions(@PathVariable Long idNutrition, @RequestParam Nutrition updatedNutrition) {
        administrateurService.updateNutrition(idNutrition, updatedNutrition);
    } //doesn't work
    /***************************Users***********************/

}
