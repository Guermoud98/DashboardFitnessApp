package ma.emsi.dashboardfitness.controllers;

import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.repositories.IAdministrateurRepository;
import ma.emsi.dashboardfitness.services.AdministrateurService;
import org.springframework.web.bind.annotation.GetMapping;
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
}
