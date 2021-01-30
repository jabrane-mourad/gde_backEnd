package ma.gde.controller;

import ma.gde.dao.ModuleRepo;
import ma.gde.dao.SemestreRepo;
import ma.gde.entities.Filiere;
import ma.gde.entities.Module;
import ma.gde.entities.Semestre;
import ma.gde.entities.utilisateur.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/etudiants")
public class EtudiantController {
    @Autowired
    SemestreRepo semestreRepo;
    @GetMapping("/modules")
    public Semestre modules(@RequestParam("nom") String nom,
                                @RequestParam("niveau") Niveau niveau,
                                @RequestParam("filiere") Filiere filiere){
        return semestreRepo.findByEtudiantInformation(nom,niveau,filiere);
    }

    @GetMapping("/emplois")
    public Semestre emplois(@RequestParam("semestre") String semestre,
                            @RequestParam("niveau") Niveau niveau,
                            @RequestParam("filiere") Filiere filiere){
        return semestreRepo.findByEtudiantInformation(semestre,niveau,filiere);
    }
}
