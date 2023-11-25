package net.javaguides.springboot.Controller;

import net.javaguides.springboot.model.Masini ;
import net.javaguides.springboot.exception.MasiniNotFoundException ;
import net.javaguides.springboot.service.MasiniService ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MasiniController {
    @Autowired private MasiniService masiniService;

    @GetMapping("/masini")
    public String showMasiniList(Model model){
        List<Masini> masiniList=masiniService.listaAll();
        model.addAttribute("masiniList",masiniList);


        return "masini";
    }

    @GetMapping("/masini/new")
    public String showNewForm(Model model){
        model.addAttribute("masini",new Masini());
        model.addAttribute("pageTitle","Add new car");
        return "masini_form";
    }

    @PostMapping("/masini/save")
    public String saveMasina( @ModelAttribute("masini") Masini masina, RedirectAttributes redirectAttributes){
      //  masina.setNr_inmatriculare(masina.getNr_inmatriculare());
        System.out.println("model");
        System.out.println(masina.getModel());
    masiniService.save(masina);
    redirectAttributes.addFlashAttribute("message","Masina a fost adaugata");
    return "redirect:/masini";
    }

    @GetMapping("/masini/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model,RedirectAttributes redirectAttributes) throws MasiniNotFoundException {
        try{
           Masini masini= masiniService.get(id);
           model.addAttribute("masini",masini);
           model.addAttribute("pageTitle","Edit masina"+ id);
           return "masini_form";
        }catch (MasiniNotFoundException e){
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            return "redirect:/masini";
        }

    }

    @GetMapping("/masini/delete/{id}")
    public String deleteMasina(@PathVariable("id") String id, RedirectAttributes redirectAttributes) throws MasiniNotFoundException {
        try{
            masiniService.delete(id);
        }catch (MasiniNotFoundException e){
            redirectAttributes.addFlashAttribute("message",e.getMessage());

        }
        return "redirect:/masini";
    }
    @GetMapping ("/masini/filtrate")
    public String getMasiniFiltrate(
            @RequestParam(name = "model",required = false) String model,
            @RequestParam(name = "culoare",required = false) String culoare,
            @RequestParam(name = "tipul_de_combustibil",required = false) String tipul_de_combustibil,
            Model mode){
       List<Masini> masiniFiltrate=masiniService.filtruMasini(model,culoare,tipul_de_combustibil);
       masiniFiltrate.forEach(System.out::println);
       mode.addAttribute("masiniFiltrate",masiniFiltrate);
       return "masini";
    }


}
