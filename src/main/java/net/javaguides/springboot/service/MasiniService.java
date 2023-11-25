package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Masini ;
import net.javaguides.springboot.exception.MasiniNotFoundException ;
import net.javaguides.springboot.repository.MasiniRepository ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;
import java.util.List;
import java.util.Optional;

@Service
public class MasiniService {

    @Autowired private MasiniRepository masiniRepository;

    public List<Masini> listaAll(){
        return (List<Masini>) masiniRepository.findAll();
    }

    public void save(Masini masina) {
        masiniRepository.save(masina);
    }

    public Masini get(String nr_inmatriculare) throws MasiniNotFoundException{
        Optional<Masini> optionalMasini=masiniRepository.findById(nr_inmatriculare);
        if(optionalMasini.isPresent()){
            System.out.println("s-a gasit masina");
            return optionalMasini.get();
        }

            throw  new MasiniNotFoundException("Nu s-a gasit masina");
    }



    public void delete(String id) throws MasiniNotFoundException {
        boolean exists=masiniRepository.existsById(id);
        if(exists==false){
            throw  new MasiniNotFoundException("Nu s-a gasit masina");
        }
        masiniRepository.deleteById(id);
    }

    public List<Masini> filtruMasini(String model, String culoare, String tip_de_combustibil) {

        System.out.println(model);
        System.out.println(culoare);
        System.out.println(tip_de_combustibil);
        return masiniRepository.filtruMasini(model, culoare, tip_de_combustibil);
    }
}
