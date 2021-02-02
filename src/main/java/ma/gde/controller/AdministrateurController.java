package ma.gde.controller;

import ma.gde.controller.service.interfaces.AdministrateurServiceIn;
import ma.gde.entities.Demande;
import ma.gde.enun.Etat;
import ma.gde.enun.TypeDemande;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/adminisateur")
public class AdministrateurController {
    private AdministrateurServiceIn administrateurService;

    public AdministrateurController(AdministrateurServiceIn administrateurService) {
        this.administrateurService = administrateurService;
    }

    @GetMapping("/demandes")
    public List<Demande> demandes(@RequestParam("typeDemande") TypeDemande typeDemande,@RequestParam("etatDemande") Etat etatDemande) {
        return administrateurService.getDemandeByTypeAndEtat(typeDemande,etatDemande);
    }
}
