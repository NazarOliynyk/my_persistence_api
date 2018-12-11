package models;

import javax.persistence.*;
import java.util.TreeSet;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;
    private String department_name;
    @ElementCollection
    private TreeSet<String> list_of_staff = new TreeSet<>();
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //EAGER gives a user when a contact is called
    private Company company;

    public Department() {
    }

    public Department( TreeSet<String> list_of_staff) {
        this.list_of_staff = list_of_staff;
    }

    public Department(String department_name, TreeSet<String> list_of_staff, Company company) {
        this.department_name = department_name;
        this.list_of_staff = list_of_staff;
        this.company = company;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public TreeSet<String> getList_of_staff() {
        return list_of_staff;
    }

    public void setList_of_staff(TreeSet<String> list_of_staff) {
        this.list_of_staff = list_of_staff;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (department_id != that.department_id) return false;
        if (department_name != null ? !department_name.equals(that.department_name) : that.department_name != null)
            return false;
        if (list_of_staff != null ? !list_of_staff.equals(that.list_of_staff) : that.list_of_staff != null)
            return false;
        return company != null ? company.equals(that.company) : that.company == null;
    }

    @Override
    public int hashCode() {
        int result = department_id;
        result = 31 * result + (department_name != null ? department_name.hashCode() : 0);
        result = 31 * result + (list_of_staff != null ? list_of_staff.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}
