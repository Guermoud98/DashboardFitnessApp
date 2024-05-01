package ma.emsi.dashboardfitness.controllers;

import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.repositories.IAdministrateurRepository;
import ma.emsi.dashboardfitness.services.AdministrateurService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdministrateurRestController {
    private AdministrateurService administrateurService;
    public AdministrateurRestController(AdministrateurService administrateurService) {
        this.administrateurService = administrateurService;
    }
    @GetMapping(path = "/nutritions")
    public List<Nutrition> getNutritions() {
        return administrateurService.afficherNutritions();
    }
    @GetMapping(path ="/deleteNutritionsbyId/{idNutrition}" )
    public void deleteNutritionsbyId(@PathVariable Long idNutrition) {
        administrateurService.deleteNutritionById( idNutrition);
    }
    @GetMapping(path = "/afficherNutritionsById/{idNutrition}" )
    public Nutrition getNutritionById(@PathVariable Long idNutrition) {
        return administrateurService.afficherNutritionById(idNutrition);
    }
}
