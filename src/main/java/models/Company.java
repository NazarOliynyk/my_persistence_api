package models;

import javax.persistence.*;
import java.util.TreeSet;

@Entity
@Table(name="Companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int company_id;
    private String company_name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "company")   //EAGER gives all cont with a user
    private TreeSet<Department> departments = new TreeSet<>();

    public Company() {
    }

    public Company(String company_name, TreeSet<Department> departments) {
        this.company_name = company_name;
        this.departments = departments;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public TreeSet<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(TreeSet<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (company_id != company.company_id) return false;
        if (company_name != null ? !company_name.equals(company.company_name) : company.company_name != null)
            return false;
        return departments != null ? departments.equals(company.departments) : company.departments == null;
    }

    @Override
    public int hashCode() {
        int result = company_id;
        result = 31 * result + (company_name != null ? company_name.hashCode() : 0);
        result = 31 * result + (departments != null ? departments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "company_id=" + company_id +
                ", company_name='" + company_name + '\'' +
                '}';
    }
}
