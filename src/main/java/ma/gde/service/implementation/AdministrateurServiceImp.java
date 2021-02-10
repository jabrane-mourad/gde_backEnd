package ma.gde.service.implementation;

import ma.gde.service.interfaces.AdministrateurServiceIn;
import ma.gde.dao.DemandeRepo;
import ma.gde.dao.SemestreRepo;
import ma.gde.entities.Demande;
import ma.gde.entities.Semestre;
import ma.gde.enun.Etat;
import ma.gde.enun.Filiere;
import ma.gde.enun.TypeDemande;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurServiceImp implements AdministrateurServiceIn {
    private DemandeRepo demandeRepo;
    private SemestreRepo semestreRepo;

    public AdministrateurServiceImp(DemandeRepo demandeRepo, SemestreRepo semestreRepo) {
        this.demandeRepo = demandeRepo;
        this.semestreRepo = semestreRepo;
    }

    @Override
    public List<Demande> getDemandeByTypeAndEtat(TypeDemande typeDemande) {
        return demandeRepo.getDemandesByTypeAndEtat(typeDemande);
    }

    @Override
    public void setEtat(Long id, Etat etatDemande) {
        Demande demande = demandeRepo.getOne(id);
        demande.setEtat(etatDemande);
        demandeRepo.save(demande);
    }

    @Override
    public void setjustification(Long id, String justification) {
        Demande demande = demandeRepo.getOne(id);
        demande.setJustification(justification);
        demandeRepo.save(demande);
    }

    @Override
    public Demande accepterdemande(Long id) {
        Demande demande = demandeRepo.getOne(id);
        demande.setEtat(Etat.accepter);
        return demandeRepo.save(demande);

    }

    @Override
    public Demande refuserdemande(Long id, String justification) {
        Demande demande = demandeRepo.getOne(id);
        demande.setEtat(Etat.rejetée);
        demande.setJustification(justification);
        return demandeRepo.save(demande);
    }

    @Override
    public List<Semestre> getEmploisBySemestreAndFiliere(String semestre, Filiere filiere) {
        return semestreRepo.getEmploisBySemestreAndFiliere(semestre,filiere);
    }
}
