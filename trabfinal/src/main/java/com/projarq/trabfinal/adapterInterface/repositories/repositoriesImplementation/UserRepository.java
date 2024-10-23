package com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation;

import com.bcopstein.t1.adaptadorDeInterface.entidades.Usuario;
import com.bcopstein.t1.aplicacao.repositorios.IUsuarioRepository;
import com.bcopstein.t1.dominio.models.UsuarioModel;
import com.bcopstein.t1.infraestrutura.repositorios.UsuarioRepositoryJpa;

import com.projarq.trabfinal.adapterInterface.repositories.entities.User;
import com.projarq.trabfinal.domain.repositoriesInterfaces.UserRepositoryInterface;
import com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces.JpaUserRepositoryInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserRepositoryInterface {
    private JpaUserRepositoryInterface jpaUserRepositoryInterface;

    @Autowired
    public UsuarioRepositoryImpl(UsuarioRepositoryJpa usuarioRepositoryJpa) {
        this.jpaUserRepositoryInterface = usuarioRepositoryJpa;
    }

    @Override
    public List<UsuarioModel> findByLogin(String login) {
        return jpaUserRepositoryInterface.findByLogin(login).stream().map(User::toUsuarioModel).toList();
    }
}
