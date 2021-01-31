package ma.gde.controller;

import ma.gde.dao.DemandeRepo;
import ma.gde.dao.EtudiantRepo;
import ma.gde.dao.NoteRepo;
import ma.gde.dao.SemestreRepo;
import ma.gde.dto.DemandeDTO;
import ma.gde.entities.Demande;
import ma.gde.entities.Semestre;
import ma.gde.entities.data.Note;
import ma.gde.entities.utilisateur.Etudiant;
import ma.gde.enun.Etat;
import ma.gde.enun.Filiere;
import ma.gde.enun.Niveau;
import ma.gde.enun.TypeDemande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/etudiants")
public class EtudiantController {
    @Autowired
    private SemestreRepo semestreRepo;
    @Autowired
    private DemandeRepo demandeRepo;
    @Autowired
    private EtudiantRepo etudiantRepo;
    @Autowired
    private NoteRepo noteRepo;

    @GetMapping("/modules")
    public Semestre modules(@RequestParam("nom") String nom,
                            @RequestParam("niveau") Niveau niveau,
                            @RequestParam("filiere") Filiere filiere) {
        return semestreRepo.findByEtudiantInformation(nom, niveau, filiere);
    }

    @PostMapping("/modules")
    public void ajouterDemande(@RequestBody DemandeDTO demandeDTO) {
        demandeRepo.save(new Demande(null,
                demandeDTO.getTypeDemande(),
                Etat.attente,
                demandeDTO.getDescription(),
                "",
                etudiantRepo.getEtudiantByCodeMasar(demandeDTO.getCodeMasar())));
    }


    @GetMapping("/emplois")
    public Semestre emplois(@RequestParam("semestre") String semestre,
                            @RequestParam("niveau") Niveau niveau,
                            @RequestParam("filiere") Filiere filiere) {
        return semestreRepo.findByEtudiantInformation(semestre, niveau, filiere);
    }

    @GetMapping("/demandes")
    public List<Demande> demandes(@RequestParam("codeMasar") String codeMasar) {
        return demandeRepo.findDemandeByEtudiantInformation(codeMasar);
    }

    @GetMapping("/{codeMasar}")
    public Etudiant getEtudiant(@PathVariable String codeMasar) {
        return etudiantRepo.getEtudiantByCodeMasar(codeMasar);
    }

    @GetMapping("/notes")
    public List<Note> notes(@RequestParam("codeMasar") String codeMasar,
                            @RequestParam("niveau") Niveau niveau) {
        return noteRepo.findNoteByEtudiantInformation(codeMasar, niveau);
    }
}
