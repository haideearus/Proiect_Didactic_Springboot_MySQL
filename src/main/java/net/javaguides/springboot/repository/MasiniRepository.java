package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Masini ;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MasiniRepository extends CrudRepository<Masini,String> {

//    @Query("SELECT m FROM Masini m WHERE " +
//            "COALESCE(:model, m.model) = m.model AND " +
//            "COALESCE(:culoare, m.culoare) = m.culoare AND " +
//            "COALESCE(:tip_de_combustibil, m.tipul_de_combustibil) = m.tipul_de_combustibil")
    @Query("from Masini where "
    +"(model=?1 or ?1 is null or ?1='')"
    +"and (culoare=?2 or ?2 is null or ?2='')"
    +"and (tipul_de_combustibil=?3 or ?3 is null or ?3='')")
    List<Masini> filtruMasini(
            @Param("model") String model,
            @Param("culoare") String culoare,
            @Param("tipul_de_combustibil") String tip_de_combustibil
    );
}