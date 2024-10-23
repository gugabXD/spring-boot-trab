package com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projarq.trabfinal.adapterInterface.repositories.entities.App;
import com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces.JpaApplicationRepositoryInterface;
import com.projarq.trabfinal.domain.entities.ApplicationModel;
import com.projarq.trabfinal.domain.repositoriesInterfaces.ApplicationRepositoryInterface;

public class ApplicationRepository implements ApplicationRepositoryInterface {
    private final JpaApplicationRepositoryInterface jpaApplicationRepositoryInterface;

    @Autowired
    public ApplicationRepository(JpaApplicationRepositoryInterface jpaApplicationRepositoryInterface) {
        this.jpaApplicationRepositoryInterface = jpaApplicationRepositoryInterface;
    }

    @Override
    public List<ApplicationModel> findAll(){
        return jpaApplicationRepositoryInterface.findAll().stream().map(App::toApplicationModel).toList();
    }

    @Override
    public ApplicationModel findByCode(long code){
        return App.toApplicationModel(jpaApplicationRepositoryInterface.findByCode(code));
    }

    @Override
    public List<ApplicationModel> findByName(String nome){
        return jpaApplicationRepositoryInterface.findByName(nome).stream().map(App::toApplicationModel).toList();
    }

    @Override
    public List<ApplicationModel> findByMonthlyCost(double monthlyCost){
        return List.of(jpaApplicationRepositoryInterface.findByMonthlyCost(monthlyCost)).stream().map(App::toApplicationModel).toList();
    }

    public ApplicationModel save(ApplicationModel applicationModel){
        return App.toApplicationModel(jpaApplicationRepositoryInterface.save(App.fromApplicationModel(applicationModel)));
    }
}
