package com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation;

import java.util.List;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import com.projarq.trabfinal.adapterInterface.repositories.entities.App;
import com.projarq.trabfinal.adapterInterface.repositories.entities.Customer;
import com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces.JpaApplicationRepositoryInterface;
import com.projarq.trabfinal.domain.entities.ApplicationModel;
import com.projarq.trabfinal.domain.repositoriesInterfaces.ApplicationRepositoryInterface;

public class ApplicationRepository implements ApplicationRepositoryInterface {
    private final JpaApplicationRepositoryInterface jpaRepository;

    @Autowired
    public ApplicationRepository(JpaApplicationRepositoryInterface jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<ApplicationModel> findAll(){
        return jpaRepository.findAll().stream().map(App::toApplicationModel).toList();
    }

    @Override
    public ApplicationModel findById(long id){
        return App.toApplicationModel(jpaRepository.findById(id));
    }

    @Override
    public List<ApplicationModel> findByNome(String nome){
        return jpaRepository.findByNome(nome).stream().map(App::toApplicationModel).toList();
    }

    @Override
    public List<ApplicationModel> findByMonthlyCost(double monthlyCost){
        return jpaRepository.findByMonthlyCost(monthlyCost).stream().map(App::toApplicationModel).toList();
    }

    public ApplicationModel save(ApplicationModel applicationModel){
        return App.toAplicativoModel(JpaApplicationRepositoryInterface.save(App.fromAplicativoModel(applicationModel)));
    }
}
