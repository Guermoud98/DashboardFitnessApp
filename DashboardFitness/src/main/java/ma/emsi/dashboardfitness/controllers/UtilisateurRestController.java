package ma.emsi.dashboardfitness.controllers;

import ma.emsi.dashboardfitness.entities.Entrainement;
import ma.emsi.dashboardfitness.entities.Utilisateur;
import ma.emsi.dashboardfitness.services.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Utilisateurs")
public class UtilisateurRestController {

    private UtilisateurService utilisateurService;

    public UtilisateurRestController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    @PostMapping(path = "/create")
    public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur utilisateur) {
        Utilisateur createdUtilisateur = utilisateurService.Register(utilisateur);
        //Le corps de la réponse contient les détails de l'utilisateur nouvellement créé (createdUtilisateur).
        //retourne le code 201 created
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUtilisateur);
    }

    @GetMapping(path = "/login")
    //  ResponseEntity Utile pour personnaliser la réponse en fonction de certaines conditions
    //  ou pour gérer différents types de réponses HTTP.
    public ResponseEntity<Utilisateur> login(@RequestParam String email, @RequestParam String password) {
        Utilisateur existingUser = utilisateurService.Login(email, password);
        if (existingUser == null) {
            //retourne le code d'état 404 si la liste est vide, sinon retourne le code d'état 200.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(existingUser);


    }

    @GetMapping(path = "/ALL")
    public ResponseEntity<List<Utilisateur>> getAll() {
        return ResponseEntity.ok(utilisateurService.getAllUtilisateurs());
    }

    @GetMapping(path = "/GetSuggestedEntrainement")
    public ResponseEntity<List<Entrainement>> getWorkoutUtilisateur(@RequestParam String email, @RequestParam String password) {
        Utilisateur existingUser = utilisateurService.Login(email, password);
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // Retourne une ResponseEntity avec un code d'état HTTP 200 OK.
        // Indique que la requête a été traitée avec succès.
        // Le corps de la réponse contient les données spécifiées (dans ce cas, les détails de l'utilisateur).
        return ResponseEntity.ok(utilisateurService.getRecommendedEntrainementsForUser(existingUser));

    }

    @GetMapping(path = "/GetAllEntrainements")
    public ResponseEntity<List<Entrainement>> getAllEntrainement(@RequestParam String email, @RequestParam String password) {
        Utilisateur existingUser = utilisateurService.Login(email, password);
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(utilisateurService.getAllEntrainementsForUser(existingUser));
    }

    @PutMapping(path = "/me/Profile")
    public ResponseEntity<Utilisateur> UpdateProfile(@RequestBody Utilisateur utilisateur) {

        Utilisateur updated = utilisateurService.UpdateUtilisateur(utilisateur);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);


    }

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

