package ma.gde.controller;

import ma.gde.dao.EtudiantRepo;
import ma.gde.entities.utilisateur.Etudiant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EtudiantController {
    private EtudiantRepo etudiantRepo;

    public EtudiantController(EtudiantRepo etudiantRepo) {
        this.etudiantRepo = etudiantRepo;
    }

    @RequestMapping(value = "/all")
    public List<Etudiant> createAuthentionToken() {

        return etudiantRepo.findAll();
    }

}
