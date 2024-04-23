package ma.emsi.dashboardfitness.services;
import ma.emsi.dashboardfitness.repositories.*;
import ma.emsi.dashboardfitness.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UtilisateurService {
@Autowired
    private IUtilisateurRepository utilisateurRepository;


    public UtilisateurService(IUtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }


    ///Les methodes de validité d'email et  password/////////////////////////////////////////////

    public boolean isValidEmail(String email) {

        //exemple d'email valide : utilisateur@example.com
        String regex = "^(.+)@(.+)$";
        return email.matches(regex);
    }
    public boolean isValidPassword(String password) {

        //exemple de password valide : Password123!
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password.matches(regex);
    }

    ////////////////////////////////////////////////////////////////////////////////////

    public Utilisateur Login (String email, String password) {
    Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
    if(utilisateur != null && utilisateur.getPassword().equals(password)) {
       return utilisateur;
    }
    return null;
    }
    public Utilisateur Register(Utilisateur utilisateur) {
        if (!isValidEmail(utilisateur.getEmail()))
        {
            throw new IllegalArgumentException("Email invalid");
        }
        if(!isValidPassword(utilisateur.getPassword()))
        {
            throw new IllegalArgumentException("Password invalid");
        }
       return  utilisateurRepository.save(utilisateur);
    }
    /*
    à tester dans le main
    @Bean
    public IUtilisateurRepository utilisateurRepository(EntityManager entityManager) {
    JpaRepositoryFactory factory = new JpaRepositoryFactory(entityManager);
    return factory.getRepository(IUtilisateurRepository.class);
}

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DashboardFitnessApplication.class);
        UtilisateurService utilisateurService = context.getBean(UtilisateurService.class);

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("ettaleby");
        utilisateur.setPrenom("neha");
        utilisateur.setEmail("neha@gmail.com");
        utilisateur.setPassword("Password123!");
        utilisateur.setPoids(62);
        utilisateur.setTaille(161);

        utilisateurService.register(utilisateur);
    * */
}
