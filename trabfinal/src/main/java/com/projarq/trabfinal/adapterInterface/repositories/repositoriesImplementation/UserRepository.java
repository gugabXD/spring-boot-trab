package com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation;

import com.bcopstein.t1.adaptadorDeInterface.entidades.Usuario;
import com.bcopstein.t1.aplicacao.repositorios.IUsuarioRepository;
import com.bcopstein.t1.dominio.models.UsuarioModel;
import com.bcopstein.t1.infraestrutura.repositorios.UsuarioRepositoryJpa;

import com.projarq.trabfinal.adapterInterface.repositories.entities.User;
import com.projarq.trabfinal.domain.repositoriesInterfaces.UserRepositoryInterface;
import com.projarq.trabfinal.ada

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserRepositoryInterface {
    private JpaUserRepository jpaUserRepository;

    @Autowired
    public UsuarioRepositoryImpl(UsuarioRepositoryJpa usuarioRepositoryJpa) {
        this.usuarioRepositoryJpa = usuarioRepositoryJpa;
    }

    @Override
    public List<UsuarioModel> findByLogin(String login) {
        return usuarioRepositoryJpa.findByLogin(login).stream().map(Usuario::toUsuarioModel).toList();
    }
}
