package ma.gde;

import ma.gde.controller.service.UtilisateurService;
import ma.gde.dao.ModuleRepo;
import ma.gde.dao.SemestreRepo;
import ma.gde.entities.Departement;
import ma.gde.entities.Filiere;
import ma.gde.entities.Module;
import ma.gde.entities.Semestre;
import ma.gde.entities.utilisateur.Administrateur;
import ma.gde.entities.utilisateur.Enseignant;
import ma.gde.entities.utilisateur.Etudiant;
import ma.gde.entities.utilisateur.Niveau;
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
    CommandLineRunner start(UtilisateurService utilisateurService, ModuleRepo moduleRepo, SemestreRepo semestreRepo) {
        return args -> {
            //Etudiant e = new Etudiant(null, "jabrane", "mourad", new Date(), "xjabrane@gmail.com", "ETUDIANT", "XJ123", "f135368925");
            Etudiant e = new Etudiant(null, "Etudiant", "Etudiant", new Date(),
                    "Etudiant@gmail.com", "Etudiant", "codem", Niveau.premierAnnee, Filiere.All);
            utilisateurService.save(e);
            Administrateur a = new Administrateur(null, "Administrateur", "Administrateur", new Date(),
                    "Administrateur@gmail.com", "Administrateur", "idAdmin");
            utilisateurService.save(a);

            Enseignant en = new Enseignant(null, "Enseignant", "Enseignant", new Date(),
                    "Enseignant@gmail.com", "Enseignant", "idEnseignant");
            utilisateurService.save(en);




            Semestre s1N1 = new Semestre(null, "s1", Niveau.premierAnnee, Filiere.All, Departement.INFO, "https://drive.google.com/file/d/1kkpBGwnhZmTdJvXh9zzAV1wGvCL0Ljsj/view?usp=sharing", null);
            Semestre s2N1 = new Semestre(null, "s2", Niveau.premierAnnee, Filiere.All, Departement.INFO, "https://drive.google.com/file/d/1vm4vXVo5mzZWEfKBGKyMdFe6T917pX2b/view?usp=sharing", null);

            Semestre s1N2 = new Semestre(null, "s1", Niveau.deuxiemeAnnee, Filiere.GL, Departement.INFO, "https://drive.google.com/file/d/1oCbc4lXYMLyDVEBNxsCfj87e7WEcecU0/view?usp=sharing", null);
            Semestre s2N2 = new Semestre(null, "s2", Niveau.deuxiemeAnnee, Filiere.GL, Departement.INFO, "https://drive.google.com/file/d/1wGbGNhiUQ3Au8mVo_cw1prqDK0tmap3M/view?usp=sharing", null);

            Semestre s1N3Gl = new Semestre(null, "s1", Niveau.troisiemeAnnee, Filiere.GL, Departement.INFO, "https://drive.google.com/file/d/1h86n2iz5TApKyHEOdA2osgcWbx3ycwQR/view?usp=sharing", null);
            Semestre s2N3Gl = new Semestre(null, "s2", Niveau.troisiemeAnnee, Filiere.GL, Departement.INFO, "https://drive.google.com/file/d/132xiM5fXVExzyaMwa6rdUlc3RyeQZuqU/view?usp=sharing", null);

            Semestre s1N4Gl = new Semestre(null, "s1", Niveau.quatriemeAnnee, Filiere.GL, Departement.INFO, "https://drive.google.com/file/d/1OEiS6PSVrA4ZCtmKFScaS_AOJp8tq4aG/view?usp=sharing", null);
            Semestre s2N4Gl = new Semestre(null, "s2", Niveau.quatriemeAnnee, Filiere.GL, Departement.INFO, "https://drive.google.com/file/d/1PfBGkb_CBbnUKaWLSaHemGuyp76G_mvG/view?usp=sharing", null);

            Semestre s1N5Gl = new Semestre(null, "s1", Niveau.cinquiemeAnnee, Filiere.GL, Departement.INFO, "https://drive.google.com/file/d/121AU3e1AoRi-4-tmIoM6dap2BN1iJ1Yt/view?usp=sharing", null);
            Semestre s2N5Gl = new Semestre(null, "s2", Niveau.cinquiemeAnnee, Filiere.GL, Departement.INFO, "https://drive.google.com/file/d/18Oya3CebN0636IeN8agKVQAAq_ykax94/view?usp=sharing", null);


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
            moduleRepo.save(new Module(null, "Analyse", "M111", "https://drive.google.com/file/d/1ziW2Q7oT9TPcuXP0kS1zM05rZce06RUu/view?usp=sharing", s1N1, null, null, en));
            moduleRepo.save(new Module(null, "Mécanique", "M112", "https://drive.google.com/file/d/1zpz8b73n9J-WrYD5biLYLQj0PdE8vIIG/view?usp=sharing", s1N1, null, null, en));
            moduleRepo.save(new Module(null, "Algèbre", "M113", "https://drive.google.com/file/d/1FCojUP6p6FbgZFn9gD27AxFEqA-IHJfS/view?usp=sharing", s1N1, null, null, en));

            moduleRepo.save(new Module(null, "Informatique", "M121", "https://drive.google.com/file/d/1ViS1-U5O7a0y4zL8BiF7ztguKneIWQIr/view?usp=sharing", s2N1, null, null, en));
            moduleRepo.save(new Module(null, "Physique", "M122", "https://drive.google.com/file/d/1qQCxtusFED86gzivZFD1bIHRWrKNEiCY/view?usp=sharing", s2N1, null, null, en));
            moduleRepo.save(new Module(null, "Français", "M123", "https://drive.google.com/file/d/104T1geP2yNaGMcaGKRiUr7jwmj3OhKXb/view?usp=sharing", s2N1, null, null, en));


            moduleRepo.save(new Module(null, "Electronique", "M211", "https://drive.google.com/file/d/1RyJWK9q5aFFEXsb86ovMp4Milk3CC6Ec/view?usp=sharing", s1N2, null, null, en));
            moduleRepo.save(new Module(null, "Electromagnetisme", "M212", "https://drive.google.com/file/d/1rNMU0_VFi_eFplDb7KXJBi7zR61omGd0/view?usp=sharing", s1N2, null, null, en));
            moduleRepo.save(new Module(null, "Anglais", "M213", "https://drive.google.com/file/d/1pymbxnpBkyNfu876pCHnCDY9DrmkYWJL/view?usp=sharing", s1N2, null, null, en));

            moduleRepo.save(new Module(null, "Language c", "M221", "https://drive.google.com/file/d/10Vp12ayc7TSSHaegd4ZJnwTVuJFg08pU/view?usp=sharing", s2N2, null, null, en));
            moduleRepo.save(new Module(null, "Matlab", "M222", "https://drive.google.com/file/d/11YrPhrsIpCmR8yS3FErTPlgJOUeUOK-G/view?usp=sharing", s2N2, null, null, en));
            moduleRepo.save(new Module(null, "Français", "M223", "https://drive.google.com/file/d/1iR15apbOxJcPuDGNGpP-3GTkW-MX2P4B/view?usp=sharing", s2N2, null, null, en));


            moduleRepo.save(new Module(null, "Algorithmique", "M311", "https://drive.google.com/file/d/1zEUpRN7hdQIAGxqGWJ9qv6FJPmOn9ZAb/view?usp=sharing", s1N3Gl, null, null, en));
            moduleRepo.save(new Module(null, "Probabilité", "M312", "https://drive.google.com/file/d/1xV7nZ5MCZsDLxXIDp18GAv7aRo30iPFM/view?usp=sharing", s1N3Gl, null, null, en));
            moduleRepo.save(new Module(null, "Economie", "M313", "https://drive.google.com/file/d/1JrW7qXf77_scIVhhAzYu5NUEKFXOnEW0/view?usp=sharing", s1N3Gl, null, null, en));

            moduleRepo.save(new Module(null, "Systèmes d'information", "M321", "https://drive.google.com/file/d/1m3enK7KofJo4Jv4nExWdOlZB8Y-xZjwm/view?usp=sharing", s2N3Gl, null, null, en));
            moduleRepo.save(new Module(null, "Electronique", "M322", "https://drive.google.com/file/d/1RoVGX7QeJ6M1YO3GT4QngeZOIRwW2T-s/view?usp=sharing", s2N3Gl, null, null, en));
            moduleRepo.save(new Module(null, "Statistiques", "M323", "https://drive.google.com/file/d/1q9upRd4tdwdJveJM7vYYmENQYK8PTtyf/view?usp=sharing", s2N3Gl, null, null, en));

            moduleRepo.save(new Module(null, "Méthodes d'analyse et conception", "M411", "https://drive.google.com/file/d/1d1Vf2FhPMuGtNU5X08fFKFhz8olt_Qbc/view?usp=sharing", s1N4Gl, null, null, en));
            moduleRepo.save(new Module(null, "Recherche Opérationnelle", "M412", "https://drive.google.com/file/d/11cqdxq16jVOzQz45rOb2N0PTxFw2IuE5/view?usp=sharing", s1N4Gl, null, null, en));
            moduleRepo.save(new Module(null, "Technologie", "M413", "https://drive.google.com/file/d/1cTuNbYlU1WY6LqOx8rGE-hM6u5N72S9P/view?usp=sharing", s1N4Gl, null, null, en));

            moduleRepo.save(new Module(null, "Systèmes", "M421", "https://drive.google.com/file/d/1fi0U58id8kjsbgWDhZ24cRTKEJB0lWs6/view?usp=sharing", s2N4Gl, null, null, en));
            moduleRepo.save(new Module(null, "Fonctions  clés de l'entreprise", "M422", ":https://drive.google.com/file/d/1olFnBhTpYuwMwyQfupV2t7I9epEBzzXk/view?usp=sharing", s2N4Gl, null, null, en));
            moduleRepo.save(new Module(null, "Oracle", "M423", "https://drive.google.com/file/d/1NxjiFZyAkgm6YloumwQWKDISX6_bl2sM/view?usp=sharing", s2N4Gl, null, null, en));

            moduleRepo.save(new Module(null, "Technologie jee", "M511", "https://drive.google.com/file/d/1mDlrQclvo8ZIAsX19y3yQKrXmotuhirS/view?usp=sharing", s1N5Gl, null, null, en));
            moduleRepo.save(new Module(null, "Administration et Sécurité Systèmes & Réseaux", "M512", "https://drive.google.com/file/d/1xbjXCRqU5j6I3yFWMMTH6ht-cgSBg55H/view?usp=sharing", s1N5Gl, null, null, en));
            moduleRepo.save(new Module(null, "Système distribué ", "M513", "https://drive.google.com/file/d/1owexNQgJXPddN8K7QhcD30B6bgQveK5G/view?usp=sharing", s1N5Gl, null, null, en));


            moduleRepo.save(new Module(null, "Pfe", "M521", "https://drive.google.com/file/d/1sT_EehtEt8n5nxLdDAj0kOK5BrFJCpfO/view?usp=sharing", s2N5Gl, null, null, en));


            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            //System.out.println(moduleRepo.findByEtudiantInformation("s1",Niveau.quatriemeAnnee,Filiere.GL));
        };
    }

}
