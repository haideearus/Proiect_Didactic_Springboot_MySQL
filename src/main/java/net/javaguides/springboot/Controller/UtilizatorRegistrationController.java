package net.javaguides.springboot.Controller;

import net.javaguides.springboot.service.UtilizatorService;
import net.javaguides.springboot.web.dto.UtilizatorRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registration")
public class UtilizatorRegistrationController {
    private UtilizatorService utilizatorService;

    public UtilizatorRegistrationController(UtilizatorService utilizatorService) {
        super();
        this.utilizatorService = utilizatorService;
    }

    @ModelAttribute("utilizator")
    public UtilizatorRegistrationDto utilizatorRegistrationDto(){return new UtilizatorRegistrationDto();}

    @GetMapping
    public String showRegistrationForm(){return"registration";}
    @PostMapping
    public String registerUserAccount(@ModelAttribute("utilizator") UtilizatorRegistrationDto registrationDto) {
        utilizatorService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
