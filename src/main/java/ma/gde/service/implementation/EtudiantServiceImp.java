package ma.gde.service.implementation;

import ma.gde.service.interfaces.EtudiantServiceIn;
import ma.gde.dao.*;
import ma.gde.dto.DemandeDTO;
import ma.gde.entities.Demande;
import ma.gde.entities.Module;
import ma.gde.entities.Semestre;
import ma.gde.entities.Absence;
import ma.gde.entities.Note;
import ma.gde.entities.Etudiant;
import ma.gde.enun.Etat;
import ma.gde.enun.Filiere;
import ma.gde.enun.Niveau;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImp implements EtudiantServiceIn {
    private SemestreRepo semestreRepo;
    private DemandeRepo demandeRepo;
    private EtudiantRepo etudiantRepo;
    private NoteRepo noteRepo;
    private AbsenceRepo absenceRepo;
    private ModuleRepo moduleRepo;

    public EtudiantServiceImp(SemestreRepo semestreRepo, DemandeRepo demandeRepo, EtudiantRepo etudiantRepo, NoteRepo noteRepo, AbsenceRepo absenceRepo, ModuleRepo moduleRepo) {
        this.semestreRepo = semestreRepo;
        this.demandeRepo = demandeRepo;
        this.etudiantRepo = etudiantRepo;
        this.noteRepo = noteRepo;
        this.absenceRepo = absenceRepo;
        this.moduleRepo = moduleRepo;
    }

    @Override
    public List<Module> modules(String nom, Niveau niveau, Filiere filiere) {
        return moduleRepo.findByEtudiantInformation(nom, niveau, filiere);
    }

    @Override
    public List<Module> modulesByMotCle(String nom, Niveau niveau, Filiere filiere, String motCle) {
        return moduleRepo.modulesByMotCle(nom, niveau, filiere, motCle);
    }

    @Override
    public void ajouterDemande(DemandeDTO demandeDTO) {
        demandeRepo.save(new Demande(null,
                demandeDTO.getTypeDemande(),
                Etat.attente,
                demandeDTO.getDescription(),
                "",
                etudiantRepo.getEtudiantByCodeMasar(demandeDTO.getCodeMasar())));

    }

    @Override
    public Semestre emplois(String semestre, Niveau niveau, Filiere filiere) {
        return semestreRepo.findByEtudiantInformation(semestre, niveau, filiere);
    }

    @Override
    public List<Demande> demandes(String codeMasar) {
        return demandeRepo.findDemandeByEtudiantInformation(codeMasar);
    }

    @Override
    public Etudiant getEtudiant(String codeMasar) {
        return etudiantRepo.getEtudiantByCodeMasar(codeMasar);
    }

    @Override
    public List<Note> getNnotes(String codeMasar, Niveau niveau) {
        return noteRepo.findNoteByEtudiantInformation(codeMasar, niveau);
    }

    @Override
    public List<Absence> getAbsences(String codeMasar, Niveau niveau) {
        return absenceRepo.findAbsenceByEtudiantInformation(codeMasar, niveau);
    }
}
