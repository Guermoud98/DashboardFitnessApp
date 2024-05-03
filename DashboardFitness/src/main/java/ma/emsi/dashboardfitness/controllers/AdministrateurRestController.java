package ma.emsi.dashboardfitness.controllers;

import ma.emsi.dashboardfitness.entities.Exercice;
import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.entities.Utilisateur;
import ma.emsi.dashboardfitness.repositories.IAdministrateurRepository;
import ma.emsi.dashboardfitness.services.AdministrateurService;
import ma.emsi.dashboardfitness.services.UtilisateurService;
import org.springframework.http.ResponseEntity;
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

    /*************************** Exercice ***********************/

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
    @GetMapping(path ="/exercices/getById/{idExercice}")
    public Exercice getExerciceById(@PathVariable Long idExercice) {
        return administrateurService.getExerciceById(idExercice);
    }

    /*************************** Utilisateurs ***********************/

    /*@PostMapping(path="/utilisateurs/inscription")
    public Utilisateur register(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.Register(utilisateur);
    }*/
    @PutMapping(path="/utilisateurs/updateUtilisateur")
    public Utilisateur UpdateUtilisateur(@RequestBody Utilisateur utilisateur) {
        return administrateurService.UpdateUtilisateur(utilisateur);
    }
    @DeleteMapping(path ="/utilisateurs/deleteById/{idUtilisateur}" )
    public void DeleteUtilisateurById(@PathVariable Long idUtilisateur) {
        administrateurService.DeleteUtilisateurById(idUtilisateur);
    }
    @GetMapping(path="/utilisateurs/afficherTous")
    public List<Utilisateur> getUtilisateurs() {
        return administrateurService.getAllUtilisateurs();
    }
    @GetMapping(path ="/utilisateurs/afficherById/{idUtilisateur}")
    public Utilisateur getUtilisateurById(@PathVariable Long idUtilisateur) {
        return administrateurService.getUtilisateurById(idUtilisateur);
    }
    @PutMapping(path = "/utilisateurs/updateUtilisateurById/{id}")
    public Utilisateur UpdateUtilisateurById(@PathVariable Long id) {
        return administrateurService.UpdateUtilisateurById(id);
    }
    @GetMapping("/utilisateurs/nom/{nom}")
    public ResponseEntity<List<Utilisateur>> getUtilisateursByNom(@PathVariable String nom) {
        List<Utilisateur> utilisateurs = administrateurService.getUtilisateursByNom(nom);
        if (!utilisateurs.isEmpty()) {
            return ResponseEntity.ok(utilisateurs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/utilisateurs/prenom/{prenom}")
    public ResponseEntity<List<Utilisateur>> getUtilisateursByPrenom(@PathVariable String prenom) {
        List<Utilisateur> utilisateurs = administrateurService.getUtilisateursByPrenom(prenom);
        if (!utilisateurs.isEmpty()) {
            return ResponseEntity.ok(utilisateurs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/utilisateurs/taille/{taille}")
    public ResponseEntity<List<Utilisateur>> getUtilisateursByTaille(@PathVariable long taille) {
        List<Utilisateur> utilisateurs = administrateurService.getUtilisateursByTaille(taille);
        if (!utilisateurs.isEmpty()) {
            return ResponseEntity.ok(utilisateurs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/utilisateurs/poids/{poids}")
    public ResponseEntity<List<Utilisateur>> getUtilisateursByPoids(@PathVariable int poids) {
        List<Utilisateur> utilisateurs = administrateurService.getUtilisateursByPoids(poids);
        if (!utilisateurs.isEmpty()) {
            return ResponseEntity.ok(utilisateurs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
