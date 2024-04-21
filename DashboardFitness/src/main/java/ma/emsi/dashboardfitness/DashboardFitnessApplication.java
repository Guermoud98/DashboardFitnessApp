package ma.emsi.dashboardfitness;

import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.repositories.INutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DashboardFitnessApplication implements CommandLineRunner {

    @Autowired
    private INutritionRepository nutritionRepository;

    public static void main(String[] args) {

        SpringApplication.run(DashboardFitnessApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        nutritionRepository.save(new Nutrition(null,"pomme",50, 10, 10,"dej" ));
    }
}
