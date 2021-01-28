package ma.gde.security.security.jwt.model;

import ma.gde.entities.utilisateur.Utilisateur;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;
public class JwtResponse implements Serializable {
    private final String jwttoken;
    private String id;
    private Utilisateur utilisateur;

    public JwtResponse(String jwttoken, String id, Utilisateur utilisateur) {
        this.jwttoken = jwttoken;
        this.id = id;
        this.utilisateur = utilisateur;
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}