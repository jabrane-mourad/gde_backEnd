package ma.gde;

import ma.gde.controller.FilesController;
import ma.gde.controller.service.implementation.UtilisateurService;
import ma.gde.controller.service.interfaces.FilesStorageService;
import ma.gde.dao.*;
import ma.gde.entities.Demande;
import ma.gde.entities.Module;
import ma.gde.entities.Semestre;
import ma.gde.entities.data.Absence;
import ma.gde.entities.data.Note;
import ma.gde.entities.utilisateur.Administrateur;
import ma.gde.entities.utilisateur.Enseignant;
import ma.gde.entities.utilisateur.Etudiant;
import ma.gde.enun.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

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
    CommandLineRunner start(UtilisateurService utilisateurService,
                            ModuleRepo moduleRepo,
                            SemestreRepo semestreRepo,
                            DemandeRepo demandeRepo,
                            NoteRepo noteRepo,
                            AbsenceRepo absenceRepo,
                            FilesStorageService storageService) {
        return args -> {
            //Etudiant e = new Etudiant(null, "jabrane", "mourad", new Date(), "xjabrane@gmail.com", "ETUDIANT", "XJ123", "f135368925");
            Etudiant e = new Etudiant(null, "Etudiant", "Etudiant", new Date(),
                    "Etudiant@gmail.com", "Etudiant", "codem", Niveau.quatriemeAnnee, Filiere.GL);
            utilisateurService.save(e);
            Administrateur a = new Administrateur(null, "Administrateur", "Administrateur", new Date(),
                    "administrateur123@gmail.com", "administrateur123", "idAdmin");
            utilisateurService.save(a);

            Enseignant en = new Enseignant(null, "Enseignant", "Enseignant", new Date(),
                    "Enseignant@gmail.com", "Enseignant", "idEnseignant");
            utilisateurService.save(en);
            demandeRepo.save(new Demande(null, TypeDemande.Convention, Etat.attente, "qlq chose1", "just1", e));
            demandeRepo.save(new Demande(null, TypeDemande.ReleveDesNotes, Etat.rejetée, "qlq chose2", "just2", e));
            demandeRepo.save(new Demande(null, TypeDemande.RetirerDiplome, Etat.accepter, "qlq chose3", "just3", e));


            Semestre s1N1 = new Semestre(null, "s1", Niveau.premierAnnee, Filiere.CP, Departement.INFO, "http://localhost:8080/files/CP1S1.pdf", null);
            Semestre s2N1 = new Semestre(null, "s2", Niveau.premierAnnee, Filiere.CP, Departement.INFO, "http://localhost:8080/files/CP1S2.pdf", null);

            Semestre s1N2 = new Semestre(null, "s1", Niveau.deuxiemeAnnee, Filiere.CP, Departement.INFO, "http://localhost:8080/files/CP2S1.pdf", null);
            Semestre s2N2 = new Semestre(null, "s2", Niveau.deuxiemeAnnee, Filiere.CP, Departement.INFO, "http://localhost:8080/files/CP2S2.pdf", null);

            Semestre s1N3Gl = new Semestre(null, "s1", Niveau.troisiemeAnnee, Filiere.GL, Departement.INFO, "http://localhost:8080/files/GL1S1.pdf", null);
            Semestre s2N3Gl = new Semestre(null, "s2", Niveau.troisiemeAnnee, Filiere.GL, Departement.INFO, "http://localhost:8080/files/GL1S2.pdf", null);

            Semestre s1N4Gl = new Semestre(null, "s1", Niveau.quatriemeAnnee, Filiere.GL, Departement.INFO, "http://localhost:8080/files/GL2S1.pdf", null);
            Semestre s2N4Gl = new Semestre(null, "s2", Niveau.quatriemeAnnee, Filiere.GL, Departement.INFO, "http://localhost:8080/files/GL2S2.pdf", null);

            Semestre s1N5Gl = new Semestre(null, "s1", Niveau.cinquiemeAnnee, Filiere.GL, Departement.INFO, "http://localhost:8080/files/GL3S1.pdf", null);
            Semestre s2N5Gl = new Semestre(null, "s2", Niveau.cinquiemeAnnee, Filiere.GL, Departement.INFO, "http://localhost:8080/files/GL3S2.pdf", null);


            semestreRepo.save(s1N1);
            semestreRepo.save(s2N1);
            semestreRepo.save(s1N2);
            semestreRepo.save(s2N2);
            semestreRepo.save(s1N3Gl);
            semestreRepo.save(s2N3Gl);
            semestreRepo.save(s1N4Gl);
            semestreRepo.save(s2N4Gl);
            semestreRepo.save(s1N5Gl);
            semestreRepo.save(s2N5Gl);
            moduleRepo.save(new Module(null, "Analyse", "M111", "http://localhost:8080/files/111.pdf", 20, s1N1, null, null, en));
            moduleRepo.save(new Module(null, "Mécanique", "M112", "http://localhost:8080/files/112.pdf", 16, s1N1, null, null, en));
            moduleRepo.save(new Module(null, "Algèbre", "M113", "http://localhost:8080/files/11.pd3f", 32, s1N1, null, null, en));

            moduleRepo.save(new Module(null, "Informatique", "M121", "http://localhost:8080/files/M121.pdf", 15, s2N1, null, null, en));
            moduleRepo.save(new Module(null, "Physique", "M122", "http://localhost:8080/files/M122.pdf", 10, s2N1, null, null, en));
            moduleRepo.save(new Module(null, "Français", "M123", "http://localhost:8080/files/M123.pdf", 22, s2N1, null, null, en));


            moduleRepo.save(new Module(null, "Electronique", "M211", "http://localhost:8080/files/M211.pdf", 14, s1N2, null, null, en));
            moduleRepo.save(new Module(null, "Electromagnetisme", "M212", "http://localhost:8080/files/M212.pdf", 15, s1N2, null, null, en));
            moduleRepo.save(new Module(null, "Anglais", "M213", "http://localhost:8080/files/M213.pdf", 24, s1N2, null, null, en));

            moduleRepo.save(new Module(null, "Language c", "M221", "http://localhost:8080/files/M221.pdf", 20, s2N2, null, null, en));
            moduleRepo.save(new Module(null, "Matlab", "M222", "http://localhost:8080/files/M222.pdf", 8, s2N2, null, null, en));
            moduleRepo.save(new Module(null, "Français", "M223", "http://localhost:8080/files/M223.pdf", 16, s2N2, null, null, en));


            moduleRepo.save(new Module(null, "Algorithmique", "M311", "http://localhost:8080/files/M311.pdf", 22, s1N3Gl, null, null, en));
            moduleRepo.save(new Module(null, "Probabilité", "M312", "http://localhost:8080/files/M312.pdf", 24, s1N3Gl, null, null, en));
            moduleRepo.save(new Module(null, "Economie", "M313", "http://localhost:8080/files/M313.pdf", 25, s1N3Gl, null, null, en));

            moduleRepo.save(new Module(null, "Systèmes d'information", "M321", "http://localhost:8080/files/M321.pdf", 12, s2N3Gl, null, null, en));
            moduleRepo.save(new Module(null, "Electronique", "M322", "http://localhost:8080/files/M322.pdf", 14, s2N3Gl, null, null, en));
            moduleRepo.save(new Module(null, "Statistiques", "M323", "http://localhost:8080/files/M323.pdf", 18, s2N3Gl, null, null, en));

            Module module1 = new Module(null, "Méthodes d'analyse et conception", "M411", "http://localhost:8080/files/M411.pdf", 28, s1N4Gl, null, null, en);
            moduleRepo.save(module1);
            Module module2 = new Module(null, "Recherche Opérationnelle", "M412", "http://localhost:8080/files/M412.pdf", 16, s1N4Gl, null, null, en);
            moduleRepo.save(module2);
            moduleRepo.save(new Module(null, "Technologie", "M413", "http://localhost:8080/files/M413.pdf", 14, s1N4Gl, null, null, en));

            moduleRepo.save(new Module(null, "Systèmes", "M421", "http://localhost:8080/files/M421.pdf", 15, s2N4Gl, null, null, en));
            moduleRepo.save(new Module(null, "Fonctions  clés de l'entreprise", "M422", "http://localhost:8080/files/M422.pdf", 18, s2N4Gl, null, null, en));
            moduleRepo.save(new Module(null, "Oracle", "M423", "http://localhost:8080/files/M423.pdf", 18, s2N4Gl, null, null, en));

            moduleRepo.save(new Module(null, "Technologie jee", "M511", "http://localhost:8080/files/M511.pdf", 20, s1N5Gl, null, null, en));
            moduleRepo.save(new Module(null, "Administration et Sécurité Systèmes & Réseaux", "M512", "http://localhost:8080/files/M512.pdf", 22, s1N5Gl, null, null, en));
            moduleRepo.save(new Module(null, "Système distribué ", "M513", "http://localhost:8080/files/M523.pdf", 26, s1N5Gl, null, null, en));


            moduleRepo.save(new Module(null, "Pfe", "M521", "http://localhost:8080/files/M521.pdf", 0, s2N5Gl, null, null, en));

            noteRepo.save(new Note(null, (float) 18.20, module1, e));
            absenceRepo.save(new Absence(null, 2, module2, e));
            absenceRepo.save(new Absence(null, 4, module1, e));

            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            //System.out.println(moduleRepo.findByEtudiantInformation("s1",Niveau.quatriemeAnnee,Filiere.GL));
        };
    }

}
