package ma.gde.controller;

import ma.gde.service.interfaces.UtilisateurServiceIn;
import ma.gde.entities.Semestre;
import ma.gde.enun.Filiere;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/emploiInfo")
public class UtilisateurController {
    private UtilisateurServiceIn utilisateurService;

    public UtilisateurController(UtilisateurServiceIn utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<Semestre> getEmplois(@RequestParam("semestre") String semestre, @RequestParam("filiere") Filiere filiere) {
        return utilisateurService.getEmploisBySemestreAndFiliere(semestre,filiere);
    }
}
