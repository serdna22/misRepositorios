package com.crud.modeloDao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.modelo.Persona;

@Repository
public interface IPersona extends CrudRepository<Persona, Integer>{

}
