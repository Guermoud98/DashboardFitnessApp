package ma.emsi.dashboardfitness.controllers;

import ma.emsi.dashboardfitness.entities.Utilisateur;
import ma.emsi.dashboardfitness.repositories.IUtilisateurRepository;
import ma.emsi.dashboardfitness.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Utilisateurs")
public class UtilisateurRestController {

    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private IUtilisateurRepository utilisateurRepository;


    @PostMapping(path = "/api/Utilisateurs/create/utilisateur")
    public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur utilisateur) {
        Utilisateur createdUtilisateur = utilisateurService.Register(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUtilisateur);
    }
    @GetMapping(path = "/api/Utilisateurs/getAll")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return ResponseEntity.ok(utilisateurs);
    }
}
