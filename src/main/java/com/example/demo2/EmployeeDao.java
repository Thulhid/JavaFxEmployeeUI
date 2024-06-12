
package com.example.demo2;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    
    private static List<Employee> get(String qry) {

        List<Employee> employees = new ArrayList<>();

        try {
            ResultSet rslt = CommonDao.get(qry);

            while (rslt.next()) {
                Employee employee = new Employee();
                employee.setId(rslt.getInt("id"));
                employee.setName(rslt.getString("name"));
                employee.setNic(rslt.getString("nic"));

                employee.setGender(GenderDao.getById(rslt.getInt("gender_id")));

                employees.add(employee);
            }
        } catch (Exception e) {
           System.out.println("can't Connect as" + e.getMessage());

    }
    return employees;
}

    public static List<Employee> getAll() {
        
        String qry = "SELECT * FROM employee";
        List<Employee> employees = get(qry);
        return employees;
    }

    public static List<Employee> getAllByName(String name) {

        String qry = "select * from employee where name like'" + name + "%'";
        List<Employee> employees = get(qry);
        // Sout

        boolean x = employees.isEmpty();
        System.out.println(x);

        return employees;
    }

    public static List<Employee> getAllByGender(Gender gender) {
        String qry = "select * from employee where gender_id=" + gender.getId();

        List<Employee> employees = get(qry);

        return employees;
    }

    public static List<Employee> getGandN(Gender gender, String name) {
        String qry = "SELECT * FROM employee WHERE name LIKE'" + name + "%' AND gender_id =  " + gender.getId();
        List<Employee> employees = get(qry);

        return employees;

    }

}
