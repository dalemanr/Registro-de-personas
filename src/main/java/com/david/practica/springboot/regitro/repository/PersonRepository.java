package com.david.practica.springboot.regitro.repository;

import com.david.practica.springboot.regitro.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <Person, Long>{
}
