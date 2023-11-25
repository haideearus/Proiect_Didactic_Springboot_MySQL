package net.javaguides.springboot.service;

import net.javaguides.springboot.web.dto.UtilizatorRegistrationDto;
import net.javaguides.springboot.model.Utilizator;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UtilizatorService extends UserDetailsService {
    Utilizator save(UtilizatorRegistrationDto registrationDto);

}
