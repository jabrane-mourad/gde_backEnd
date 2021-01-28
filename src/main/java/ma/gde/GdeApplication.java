package ma.gde;

import ma.gde.controller.service.UtilisateurService;
import ma.gde.entities.utilisateur.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

@SpringBootApplication
@CrossOrigin("*")
public class GdeApplication {
    public static void main(String[] args) {
        SpringApplication.run(GdeApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer crosConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*");

            }
        };
    }

    @Bean
    CommandLineRunner start(UtilisateurService utilisateurService) {
        return args -> {
            //Etudiant e = new Etudiant(null, "jabrane", "mourad", new Date(), "xjabrane@gmail.com", "ETUDIANT", "XJ123", "f135368925");
            Etudiant e = new Etudiant(null, "Etudiant", "Etudiant", new Date(),
                    "Etudiant@gmail.com", Role.ROLE_ETUDIANT, "Etudiant", "codem", Niveau.cinquiemeAnnee);
            utilisateurService.save(e);
            Administrateur a = new Administrateur(null, "Administrateur", "Administrateur", new Date(),
                    "Administrateur@gmail.com", Role.ROLE_ADMINISTRATEUR, "Administrateur", "idAdmin");
            utilisateurService.save(a);

            Enseignant en = new Enseignant(null, "Enseignant", "Enseignant", new Date(),
                    "Enseignant@gmail.com", Role.ROLE_ENSEIGNANT, "Enseignant", "idEnseignant");
            utilisateurService.save(en);


        };
    }

}
