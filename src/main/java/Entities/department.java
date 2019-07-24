package Entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "department")
@NamedQuery(name="department.findAll", query="SELECT e FROM department e")
public class department implements Serializable {

    @Id
    @Column(name = "DEPTCODE")

    private String deptcode;
    @Column(name = "DEPTNAME")
    private String deptname;

    @Column (name = "MANAGER")
    private String manager;

    /*@OneToMany(mappedBy="employee", cascade={CascadeType.ALL})
    private List<employee> employeeList;

    public List<employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<employee> employeeList) {
        this.employeeList = employeeList;
    }*/

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
