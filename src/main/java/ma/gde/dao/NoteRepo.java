package ma.gde.dao;

import ma.gde.entities.Note;
import ma.gde.enun.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepo extends JpaRepository<Note, Long> {
    @Query(value = "SELECT n FROM Note n where n.etudiant.codeMasar=?1 and n.module.semestre.niveau=?2")
    List<Note> findNoteByEtudiantInformation(
            @Param("codeMasar") String codeMasar,
            @Param("niveau") Niveau niveau
    );
}
