package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Utilizator ;
import net.javaguides.springboot.repository.UtilizatorRepository ;
import net.javaguides.springboot.web.dto.UtilizatorRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UtilizatorServiceImpl implements UtilizatorService{

    private UtilizatorRepository utilizatorRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UtilizatorServiceImpl(UtilizatorRepository utilizatorRepository) {
        super();
        this.utilizatorRepository = utilizatorRepository;
    }

    @Override
    public Utilizator save(UtilizatorRegistrationDto registrationDto) {
       Utilizator user = new Utilizator(registrationDto.getNume(),
                registrationDto.getUtilizator(),
                passwordEncoder.encode(registrationDto.getParola()), "USER");

        return utilizatorRepository.save(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Utilizator user = utilizatorRepository.findByUtilizator(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        // Folosește un singur rol (șir simplu) într-o listă de GrantedAuthority
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getNivel_acces()));
        System.out.println(authorities);
        return new org.springframework.security.core.userdetails.User(user.getUtilizator(), user.getParola(), authorities);
    }


}

