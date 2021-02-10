package ma.gde;

import ma.gde.service.implementation.UtilisateurService;
import ma.gde.service.interfaces.FilesStorageService;
import ma.gde.dao.*;
import ma.gde.entities.Demande;
import ma.gde.entities.Module;
import ma.gde.entities.Semestre;
import ma.gde.entities.Absence;
import ma.gde.entities.Note;
import ma.gde.entities.Administrateur;
import ma.gde.entities.Enseignant;
import ma.gde.entities.Etudiant;
import ma.gde.enun.*;
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
    CommandLineRunner start(UtilisateurService utilisateurService,
                            ModuleRepo moduleRepo,
                            SemestreRepo semestreRepo,
                            DemandeRepo demandeRepo,
                            NoteRepo noteRepo,
                            AbsenceRepo absenceRepo,
                            FilesStorageService storageService) {
        return args -> {
            //Etudiant e = new Etudiant(null, "jabrane", "mourad", new Date(), "xjabrane@gmail.com", "ETUDIANT", "XJ123", "f135368925");
            Etudiant jabrane = new Etudiant(null, "JABRANE", "Mourad", new Date(),
                    "jabrane@gmail.com", "jabrane", "F35368935", Niveau.quatriemeAnnee, Filiere.GL);
            utilisateurService.save(jabrane);
            Etudiant lahlou = new Etudiant(null, "lahlou", "abdelarim", new Date(),
                    "lahlou@gmail.com", "lahlou", "W14582", Niveau.cinquiemeAnnee, Filiere.GL);
            utilisateurService.save(lahlou);


            Administrateur a = new Administrateur(null, "Jabrane", "Admin", new Date(),
                    "administrateur123@gmail.com", "administrateur123", "idAdmin");
            utilisateurService.save(a);

            Enseignant ahmadi = new Enseignant(null, "ahmadi", "mourad", new Date(),
                    "ahmadi@gmail.com", "ahmadi", "id147");
            utilisateurService.save(ahmadi);

            Enseignant achiri = new Enseignant(null, "achiri", "abdo", new Date(),
                    "achiri@gmail.com", "achiri", "id258");
            utilisateurService.save(achiri);

            Enseignant hadad = new Enseignant(null, "hadad", "chaimaa", new Date(),
                    "hadad@gmail.com", "hadadhadad", "id5697");
            utilisateurService.save(hadad);

            Enseignant fadili = new Enseignant(null, "fadili", "nihal", new Date(),
                    "fadili@gmail.com", "fadili", "id5697");
            utilisateurService.save(fadili);


            demandeRepo.save(new Demande(null, TypeDemande.Convention, Etat.attente, "qlq chose1", "just11", jabrane));
            demandeRepo.save(new Demande(null, TypeDemande.ReleveDesNotes, Etat.attente, "qlq chose2", "just22", jabrane));
            demandeRepo.save(new Demande(null, TypeDemande.RetirerDiplome, Etat.attente, "qlq chose3", "just31", jabrane));

            demandeRepo.save(new Demande(null, TypeDemande.Convention, Etat.attente, "qlq chose1", "just12", jabrane));
            demandeRepo.save(new Demande(null, TypeDemande.ReleveDesNotes, Etat.attente, "qlq chose2", "just21", jabrane));
            demandeRepo.save(new Demande(null, TypeDemande.RetirerDiplome, Etat.attente, "qlq chose3", "just32", lahlou));

            demandeRepo.save(new Demande(null, TypeDemande.Convention, Etat.attente, "qlq chose1", "just13", lahlou));
            demandeRepo.save(new Demande(null, TypeDemande.ReleveDesNotes, Etat.attente, "qlq chose2", "just23", lahlou));
            demandeRepo.save(new Demande(null, TypeDemande.RetirerDiplome, Etat.attente, "qlq chose3", "just33", lahlou));


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
            moduleRepo.save(new Module(null, "Analyse", "M111", "http://localhost:8080/files/111.pdf", 20, s1N1, null, null, hadad));
            moduleRepo.save(new Module(null, "Mécanique", "M112", "http://localhost:8080/files/112.pdf", 16, s1N1, null, null, achiri));
            moduleRepo.save(new Module(null, "Algèbre", "M113", "http://localhost:8080/files/11.pd3f", 32, s1N1, null, null, ahmadi));

            moduleRepo.save(new Module(null, "Informatique", "M121", "http://localhost:8080/files/M121.pdf", 15, s2N1, null, null, achiri));
            moduleRepo.save(new Module(null, "Physique", "M122", "http://localhost:8080/files/M122.pdf", 10, s2N1, null, null, ahmadi));
            moduleRepo.save(new Module(null, "Français", "M123", "http://localhost:8080/files/M123.pdf", 22, s2N1, null, null, hadad));


            moduleRepo.save(new Module(null, "Electronique", "M211", "http://localhost:8080/files/M211.pdf", 14, s1N2, null, null, hadad));
            moduleRepo.save(new Module(null, "Electromagnetisme", "M212", "http://localhost:8080/files/M212.pdf", 15, s1N2, null, null, achiri));
            moduleRepo.save(new Module(null, "Anglais", "M213", "http://localhost:8080/files/M213.pdf", 24, s1N2, null, null, ahmadi));

            moduleRepo.save(new Module(null, "Language c", "M221", "http://localhost:8080/files/M221.pdf", 20, s2N2, null, null, ahmadi));
            moduleRepo.save(new Module(null, "Matlab", "M222", "http://localhost:8080/files/M222.pdf", 8, s2N2, null, null, hadad));
            moduleRepo.save(new Module(null, "Français", "M223", "http://localhost:8080/files/M223.pdf", 16, s2N2, null, null, achiri));


            moduleRepo.save(new Module(null, "Algorithmique", "M311", "http://localhost:8080/files/M311.pdf", 22, s1N3Gl, null, null, ahmadi));
            moduleRepo.save(new Module(null, "Probabilité", "M312", "http://localhost:8080/files/M312.pdf", 24, s1N3Gl, null, null, achiri));
            moduleRepo.save(new Module(null, "Economie", "M313", "http://localhost:8080/files/M313.pdf", 25, s1N3Gl, null, null, hadad));

            moduleRepo.save(new Module(null, "Systèmes d'information", "M321", "http://localhost:8080/files/M321.pdf", 12, s2N3Gl, null, null, hadad));
            moduleRepo.save(new Module(null, "Electronique", "M322", "http://localhost:8080/files/M322.pdf", 14, s2N3Gl, null, null, achiri));
            moduleRepo.save(new Module(null, "Statistiques", "M323", "http://localhost:8080/files/M323.pdf", 18, s2N3Gl, null, null, ahmadi));

            Module module1 = new Module(null, "Méthodes d'analyse et conception", "M411", "http://localhost:8080/files/M411.pdf", 28, s1N4Gl, null, null, ahmadi);
            Module module2 = new Module(null, "Recherche Opérationnelle", "M412", "http://localhost:8080/files/M412.pdf", 16, s1N4Gl, null, null, achiri);
            Module module3 = new Module(null, "Technologie", "M413", "http://localhost:8080/files/M413.pdf", 14, s1N4Gl, null, null, hadad);


            Module module4 = new Module(null, "Systèmes", "M421", "http://localhost:8080/files/M421.pdf", 15, s2N4Gl, null, null, fadili);
            Module module5 = new Module(null, "Fonctions  clés de l'entreprise", "M422", "http://localhost:8080/files/M422.pdf", 18, s2N4Gl, null, null, hadad);
            Module module6 = new Module(null, "Oracle", "M423", "http://localhost:8080/files/M423.pdf", 18, s2N4Gl, null, null, achiri);

            Module module7 = new Module(null, "Technologie jee", "M511", "http://localhost:8080/files/M511.pdf", 20, s1N5Gl, null, null, achiri);
            Module module8 = new Module(null, "Administration et Sécurité Systèmes & Réseaux", "M512", "http://localhost:8080/files/M512.pdf", 22, s1N5Gl, null, null, fadili);
            Module module9 = new Module(null, "Système distribué ", "M523", "http://localhost:8080/files/M523.pdf", 26, s1N5Gl, null, null, hadad);


            Module module10 = new Module(null, "Pfe", "M521", "http://localhost:8080/files/M521.pdf", 0, s2N5Gl, null, null, fadili);
            moduleRepo.save(module1);
            moduleRepo.save(module2);
            moduleRepo.save(module3);

            moduleRepo.save(module4);
            moduleRepo.save(module5);
            moduleRepo.save(module6);
            moduleRepo.save(module7);
            moduleRepo.save(module8);
            moduleRepo.save(module9);
            moduleRepo.save(module10);

            noteRepo.save(new Note(null, (float) 18.20, module1, jabrane));
            noteRepo.save(new Note(null, (float) 8.45, module2, jabrane));
            noteRepo.save(new Note(null, (float) 18.20, module3, jabrane));
            noteRepo.save(new Note(null, (float) 14.28, module4, jabrane));
            noteRepo.save(new Note(null, (float) 15.08, module5, jabrane));
            noteRepo.save(new Note(null, (float) 8.00, module6, jabrane));

            noteRepo.save(new Note(null, (float) 13.25, module7, lahlou));
            noteRepo.save(new Note(null, (float) 11.22, module8, lahlou));
            noteRepo.save(new Note(null, (float) 12.66, module9, lahlou));
            noteRepo.save(new Note(null, (float) 19.00, module10, lahlou));

            absenceRepo.save(new Absence(null, 2, module1, jabrane));
            absenceRepo.save(new Absence(null, 0, module2, jabrane));
            absenceRepo.save(new Absence(null, 1, module3, jabrane));
            absenceRepo.save(new Absence(null, 0, module4, jabrane));
            absenceRepo.save(new Absence(null, 0, module5, jabrane));
            absenceRepo.save(new Absence(null, 4, module6, jabrane));

            absenceRepo.save(new Absence(null, 1, module7, lahlou));
            absenceRepo.save(new Absence(null, 0, module8, lahlou));
            absenceRepo.save(new Absence(null, 2, module9, lahlou));
            absenceRepo.save(new Absence(null, 0, module10, lahlou));

            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            //System.out.println(moduleRepo.findByEtudiantInformation("s1",Niveau.quatriemeAnnee,Filiere.GL));
        };
    }

}
