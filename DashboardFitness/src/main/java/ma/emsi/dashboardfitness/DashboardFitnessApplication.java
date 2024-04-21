package ma.emsi.dashboardfitness;
import jakarta.persistence.EntityManager;
import ma.emsi.dashboardfitness.entities.*;
import ma.emsi.dashboardfitness.repositories.IUtilisateurRepository;
import ma.emsi.dashboardfitness.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

@SpringBootApplication
@EnableJpaRepositories("ma.emsi.dashboardfitness.entities") // Spécifiez le package de vos models
public class DashboardFitnessApplication implements CommandLineRunner  {
    @Autowired
    private static UtilisateurService utilisateurService;
    @Bean
    public IUtilisateurRepository utilisateurRepository(EntityManager entityManager) {
        JpaRepositoryFactory factory = new JpaRepositoryFactory(entityManager);
        return factory.getRepository(IUtilisateurRepository.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(DashboardFitnessApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(DashboardFitnessApplication.class);
        UtilisateurService utilisateurService = context.getBean(UtilisateurService.class);

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("ettaleby");
        utilisateur.setPrenom("neha");
        utilisateur.setEmail("neha@gmail.com");
        utilisateur.setPassword("Password123!");
        utilisateur.setPoids(62);
        utilisateur.setTaille(161);

        utilisateurService.Register(utilisateur);
    }
}

/* @Autowired
    private static UtilisateurService utilisateurService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DashboardFitnessApplication.class, args);
        utilisateurService = context.getBean(UtilisateurService.class);

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("ettaleby");
        utilisateur.setPrenom("neha");
        utilisateur.setEmail("neha@gmail.com");
        utilisateur.setPassword("Password123!");
        utilisateur.setPoids(62);
        utilisateur.setTaille(161);

        utilisateurService.register(utilisateur);
    }*/