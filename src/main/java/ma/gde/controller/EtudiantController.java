package ma.gde.controller;

import ma.gde.service.interfaces.EtudiantServiceIn;
import ma.gde.dto.DemandeDTO;
import ma.gde.entities.Demande;
import ma.gde.entities.Module;
import ma.gde.entities.Semestre;
import ma.gde.entities.Absence;
import ma.gde.entities.Note;
import ma.gde.entities.Etudiant;
import ma.gde.enun.Filiere;
import ma.gde.enun.Niveau;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/etudiants")
public class EtudiantController {



    private EtudiantServiceIn etudiantService;

    public EtudiantController(EtudiantServiceIn etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping("/modules")
    public List<Module> modules(@RequestParam("nom") String nom,
                            @RequestParam("niveau") Niveau niveau,
                            @RequestParam("filiere") Filiere filiere) {
        return etudiantService.modules(nom, niveau, filiere);
    }

    @GetMapping("/modulesByMotCle")
    public List<Module> modulesByMotCle(@RequestParam("nom") String nom,
                                    @RequestParam("niveau") Niveau niveau,
                                    @RequestParam("filiere") Filiere filiere,
                                    @RequestParam("motCle") String motCle) {
        return etudiantService.modulesByMotCle(nom,niveau,filiere,motCle);
    }

    @PostMapping("/demandes")
    public void ajouterDemande(@RequestBody DemandeDTO demandeDTO) {
        etudiantService.ajouterDemande(demandeDTO);
    }


    @GetMapping("/emplois")
    public Semestre emplois(@RequestParam("semestre") String semestre,
                            @RequestParam("niveau") Niveau niveau,
                            @RequestParam("filiere") Filiere filiere) {
        return etudiantService.emplois(semestre, niveau, filiere);
    }

    @GetMapping("/demandes")
    public List<Demande> demandes(@RequestParam("codeMasar") String codeMasar) {
        return etudiantService.demandes(codeMasar);
    }

    @GetMapping("/{codeMasar}")
    public Etudiant getEtudiant(@PathVariable String codeMasar) {
        return etudiantService.getEtudiant(codeMasar);
    }

    @GetMapping("/notes")
    public List<Note> getNnotes(@RequestParam("codeMasar") String codeMasar,
                                @RequestParam("niveau") Niveau niveau) {
        return etudiantService.getNnotes(codeMasar, niveau);
    }

    @GetMapping("/absences")
    public List<Absence> getAbsences(@RequestParam("codeMasar") String codeMasar,
                                     @RequestParam("niveau") Niveau niveau) {
        return etudiantService.getAbsences(codeMasar, niveau);
    }
}
