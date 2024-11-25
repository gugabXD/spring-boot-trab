package com.projarq.trabfinal.adapterInterface.repositories.entities;

import com.projarq.trabfinal.domain.entities.ApplicationModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "apps")
public class App {
    @Id
    private Long code;
    private String name;
    private Double monthCost;

    protected App() {
    }

    public App(Long code, String name, Double monthCost) {
        this.code = code;
        this.name = name;
        this.monthCost = monthCost;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getmonthCost() {
        return monthCost;
    }

    public void setmonthCost(Double monthCost) {
        this.monthCost = monthCost;
    }

    public static ApplicationModel toApplicationModel(App app) {
        return new ApplicationModel(app.getCode(), app.getName(), app.getmonthCost());
    }

    public static App fromApplicationModel(ApplicationModel applicationModel) {
        return new App(applicationModel.getCode(), applicationModel.getName(), applicationModel.getmonthCost());
    }
}
