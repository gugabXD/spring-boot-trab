package com.projarq.trabfinal.domain.repositoriesInterfaces;

import com.projarq.trabfinal.domain.entities.ApplicationModel;

import java.util.List;

public interface ApplicationRepositoryInterface {
    List<ApplicationModel> findAll();
    ApplicationModel findByCode(long id);
    List<ApplicationModel> findByName(String nome);
    List<ApplicationModel> findByMonthCost(double custoMensal);
    ApplicationModel save(ApplicationModel aplicativo);
}