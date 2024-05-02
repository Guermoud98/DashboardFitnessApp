package ma.emsi.dashboardfitness.controllers;

import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Utilisateur;
import ma.emsi.dashboardfitness.repositories.IUtilisateurRepository;
import ma.emsi.dashboardfitness.services.EntrainementService;
import ma.emsi.dashboardfitness.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Utilisateurs")
public class UtilisateurRestController {

    private UtilisateurService utilisateurService;
    @Autowired
    private IUtilisateurRepository utilisateurRepository;
    @Autowired
    private EntrainementService entrainementService;

    public UtilisateurRestController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    /*@PostMapping(path = "/api/Utilisateurs/create")
    public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur utilisateur) {
        Utilisateur createdUtilisateur = utilisateurService.Register(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUtilisateur);
    }
    @GetMapping(path = "/api/Utilisateurs/login")
    public ResponseEntity<Utilisateur> login(@RequestParam String email, @RequestParam String password) {
        Utilisateur existingUser=utilisateurService.Login(email,password);
        if(existingUser==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(existingUser);

    }*/
    @GetMapping(path = "/api/Utilisateurs/getAll")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return ResponseEntity.ok(utilisateurs);
    }
   /*@GetMapping(path = "/api/Utilisateurs/GetSuggestedEntrainement")
   public ResponseEntity<List<Entrainement>> getWorkoutUtilisateur(@RequestParam String email , @RequestParam String password)
   {
       Utilisateur existingUser=utilisateurService.Login(email,password);
       List<Entrainement> workoutList=entrainementService.suggestEntrainementToUserByIMC(existingUser.getPoids(), existingUser.getTaille());
       return ResponseEntity.ok(workoutList);

   }*/
}
