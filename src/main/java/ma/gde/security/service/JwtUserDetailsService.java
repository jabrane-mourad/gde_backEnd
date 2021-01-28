package ma.gde.security.service;

import ma.gde.dao.UtilisateurRepo;
import ma.gde.entities.utilisateur.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UtilisateurRepo utilisateurRepo;
    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) {
        Utilisateur utilisateur = utilisateurRepo.findByEmail(username);

        if (utilisateur == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(String.valueOf(utilisateur.getRole())));
        return new org.springframework.security.core.userdetails.User(utilisateur.getEmail(), utilisateur.getPassword(),
                authorities);

    }
}