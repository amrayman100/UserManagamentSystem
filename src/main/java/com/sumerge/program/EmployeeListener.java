package com.sumerge.program;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import Entities.employee;

public class EmployeeListener {


    @PrePersist
    public void methodInvokedBeforePersist(employee emp) {
        System.out.println("persisting employee with id = " + emp.getEmpid());
    }

}
