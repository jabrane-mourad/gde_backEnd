package ma.gde.service.interfaces;

import ma.gde.dto.DemandeDTO;
import ma.gde.entities.Demande;
import ma.gde.entities.Module;
import ma.gde.entities.Semestre;
import ma.gde.entities.Absence;
import ma.gde.entities.Note;
import ma.gde.entities.Etudiant;
import ma.gde.enun.Filiere;
import ma.gde.enun.Niveau;

import java.util.List;

public interface EtudiantServiceIn {

    public List<Module> modules(String nom, Niveau niveau, Filiere filiere);

    public List<Module> modulesByMotCle(String nom, Niveau niveau, Filiere filiere, String motCle);

    public void ajouterDemande(DemandeDTO demandeDTO);

    public Semestre emplois(String semestre, Niveau niveau, Filiere filiere);

    public List<Demande> demandes(String codeMasar);

    public Etudiant getEtudiant(String codeMasar);

    public List<Note> getNnotes(String codeMasar, Niveau niveau);

    public List<Absence> getAbsences(String codeMasar, Niveau niveau);
}
