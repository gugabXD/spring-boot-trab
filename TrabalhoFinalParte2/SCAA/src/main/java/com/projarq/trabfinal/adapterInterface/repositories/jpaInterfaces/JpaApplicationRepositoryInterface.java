package com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces;

import com.projarq.trabfinal.adapterInterface.repositories.entities.App;
import com.projarq.trabfinal.domain.entities.ApplicationModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JpaApplicationRepositoryInterface extends JpaRepository<App, Long> {
    List<App> findAll();

    App findByCode(long code);

    List<App> findByName(String nome);

    App findByMonthCost(double month_Cost);

    App save(App aplicativo);
}