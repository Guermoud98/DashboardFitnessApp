/*package ma.emsi.dashboardfitness.repositories;

import jakarta.persistence.Table;
import ma.emsi.dashboardfitness.entities.Utilisateur;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UtilisateurRepositoryTest {
@Autowired
    private  IUtilisateurRepository utilisateurRepository;
@Test
    public void IUtilisateurRepository_Save_ReturnSavedUtilisateur() {
    Utilisateur utilisateur =Utilisateur.builder()
            .idUtilisateur(null).nom("ett").prenom("neha")
            .poids(68).taille(161)
            .email("utilisateur@example.com").password("Password123!");
}


}*/
