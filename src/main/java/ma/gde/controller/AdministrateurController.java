package ma.gde.controller;

import ma.gde.service.interfaces.AdministrateurServiceIn;
import ma.gde.entities.Demande;
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
    public List<Demande> getDemandes(@RequestParam("typeDemande") TypeDemande typeDemande) {
        return administrateurService.getDemandeByTypeAndEtat(typeDemande);
    }

    @PostMapping("/demandes/accepter/{id}")
    public void ajouterDemande(@PathVariable("id") long id) {
        administrateurService.accepterdemande(id);
    }
    @PostMapping("/demandes/refuser")
    public void ajouterDemande(@RequestParam("id") Long id,@RequestParam("justification") String justification) {
        administrateurService.refuserdemande(id,justification);
    }
}
