package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilizatorRepository extends JpaRepository <Utilizator,Long>{
    Utilizator findByUtilizator(String utilizator);
}
