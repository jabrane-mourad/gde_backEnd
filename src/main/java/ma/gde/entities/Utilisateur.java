package ma.gde.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gde.enun.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(name = "Etudiant", value = Etudiant.class),
        @JsonSubTypes.Type(name = "Enseignant", value = Enseignant.class),
        @JsonSubTypes.Type(name = "Administrateur", value = Administrateur.class),})
public abstract class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private Date dateNaissance;
    @Column
    private String email;
    @Column
    private Role role;
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
