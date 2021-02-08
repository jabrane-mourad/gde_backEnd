package ma.gde.controller.service.interfaces;

import ma.gde.entities.Demande;
import ma.gde.entities.Semestre;
import ma.gde.enun.Etat;
import ma.gde.enun.Filiere;
import ma.gde.enun.TypeDemande;

import java.util.List;

public interface AdministrateurServiceIn {

    List<Demande> getDemandeByTypeAndEtat(TypeDemande typeDemande);

    void setEtat(Long id, Etat etatDemande);

    void setjustification(Long id, String justification);

    Demande accepterdemande(Long id);

    Demande refuserdemande(Long id, String justification);

    List<Semestre> getEmploisBySemestreAndFiliere(String semestre, Filiere filiere);
}
