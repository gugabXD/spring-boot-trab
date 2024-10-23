package com.projarq.trabfinal.domain.repositoriesInterfaces;

import com.projarq.trabfinal.domain.entities.ApplicationModel;

import java.util.List;

public interface ApplicationRepositoryInterface {
    List<ApplicationModel> findAll();
    ApplicationModel findById(long id);
    List<ApplicationModel> findByNome(String nome);
    List<ApplicationModel> findByMonthlyCost(double custoMensal);
    ApplicationModel save(ApplicationModel aplicativo);
}