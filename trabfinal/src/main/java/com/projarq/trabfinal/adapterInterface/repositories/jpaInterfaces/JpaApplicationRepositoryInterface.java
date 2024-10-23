package com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces;

import com.projarq.trabfinal.adapterInterface.repositories.entities.App;
import com.projarq.trabfinal.domain.entities.ApplicationModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JpaApplicationRepositoryInterface extends JpaRepository<App, Long> {
    List<App> findAll();

    App findById(long id);

    List<App> findByNome(String nome);

    App findByMonthlyCost(double monthlyCost);

    App save(App aplicativo);
}