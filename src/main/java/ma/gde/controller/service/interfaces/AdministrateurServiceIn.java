package ma.gde.controller.service.interfaces;

import ma.gde.entities.Demande;
import ma.gde.enun.Etat;
import ma.gde.enun.TypeDemande;

import java.util.List;

public interface AdministrateurServiceIn {
    public List<Demande> getDemandeByTypeAndEtat(TypeDemande typeDemande, Etat etatDemande);

    public void setEtat(Long id, Etat etatDemande);
    public void setjustification(Long id, String justification);
}
