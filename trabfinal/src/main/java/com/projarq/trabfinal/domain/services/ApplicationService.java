package com.projarq.trabfinal.domain.services;

import com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation.ApplicationRepository;
import com.projarq.trabfinal.domain.entities.ApplicationModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;
   
    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public ApplicationModel updateMonth_Cost(long code, double month_Cost) {

        ApplicationModel application = this.applicationRepository.findByCode(code);

        if (application != null) {
            application.setmonthCost(month_Cost);
            return this.applicationRepository.save(application);
        }
        return null;

    }

    public List<ApplicationModel> findAll() {
        return applicationRepository.findAll();
    }
    
}
