package ma.gde.controller.service.implementation;

import ma.gde.controller.service.interfaces.AdministrateurServiceIn;
import ma.gde.dao.DemandeRepo;
import ma.gde.entities.Demande;
import ma.gde.enun.Etat;
import ma.gde.enun.TypeDemande;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurServiceImp implements AdministrateurServiceIn {
    private DemandeRepo demandeRepo;

    public AdministrateurServiceImp(DemandeRepo demandeRepo) {
        this.demandeRepo = demandeRepo;
    }

    @Override
    public List<Demande> getDemandeByTypeAndEtat(TypeDemande typeDemande, Etat etatDemande) {
        return demandeRepo.getDemandesByTypeAndEtat(typeDemande,etatDemande);
    }

    @Override
    public void setEtat(Long id, Etat etatDemande) {
        Demande demande=demandeRepo.getOne(id);
        demande.setEtat(etatDemande);
        demandeRepo.save(demande);
    }

    @Override
    public void setjustification(Long id, String justification) {
        Demande demande=demandeRepo.getOne(id);
        demande.setJustification(justification);
        demandeRepo.save(demande);
    }
}
