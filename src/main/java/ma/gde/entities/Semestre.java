package ma.gde.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gde.enun.Niveau;
import ma.gde.enun.Departement;
import ma.gde.enun.Filiere;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Semestre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;
    @Column
    private Niveau niveau;
    @Column
    private Filiere filiere;
    @Column
    private Departement departement;
    @Column
    private String emploi;
    @OneToMany(targetEntity = Module.class, mappedBy = "semestre", fetch = FetchType.LAZY)
    private Collection<Module> modules = new ArrayList<>();
}

