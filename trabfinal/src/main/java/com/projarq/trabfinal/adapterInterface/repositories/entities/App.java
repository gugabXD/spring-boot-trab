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
    private Double month_Cost;

    protected App() {
    }

    public App(Long code, String name, Double month_Cost) {
        this.code = code;
        this.name = name;
        this.month_Cost = month_Cost;
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

    public Double getmonth_Cost() {
        return month_Cost;
    }

    public void setmonth_Cost(Double month_Cost) {
        this.month_Cost = month_Cost;
    }

    public static ApplicationModel toApplicationModel(App app) {
        return new ApplicationModel(app.getCode(), app.getName(), app.getmonth_Cost());
    }

    public static App fromApplicationModel(ApplicationModel applicationModel) {
        return new App(applicationModel.getCode(), applicationModel.getName(), applicationModel.getmonthCost());
    }
}
