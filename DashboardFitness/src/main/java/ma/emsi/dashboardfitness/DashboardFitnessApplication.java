package ma.emsi.dashboardfitness;

import ma.emsi.dashboardfitness.entities.Nutrition;
import ma.emsi.dashboardfitness.repositories.INutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DashboardFitnessApplication{



    public static void main(String[] args) {

        SpringApplication.run(DashboardFitnessApplication.class, args);
    }


}
