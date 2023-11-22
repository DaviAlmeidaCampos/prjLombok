package com.dave.Lombok.PrjLombok.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dave.Lombok.PrjLombok.entities.Usuario;

public interface UsuarioRepositorio extends JpaRepository <Usuario, Long>{

}
