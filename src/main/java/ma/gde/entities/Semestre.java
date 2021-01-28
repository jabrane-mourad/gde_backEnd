package ma.gde.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

enum Filiere {
    GL,
    DIID,
    GRT,
    GPI,
    GE
}

enum Departement {
    GL,
    DIID,
    GRT,
    GPI,
    GE
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;
    @Column
    private Filiere filiere;
    @Column
    private Departement departement;
    @Column
    private String emploi;
    @OneToMany(targetEntity = Module.class, mappedBy = "semestre")
    private Collection<Module> modules = new ArrayList<>();
}

