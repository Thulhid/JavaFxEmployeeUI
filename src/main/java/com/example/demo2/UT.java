package com.example.demo2;

import java.util.List;

public class UT {
    public static void main(String[] args) {

        // Unit test-1->GenderDao->getById()

       /* Gender gen1 = GenderDao.getById(1);
        System.out.println(gen1.getId() + " ");
        System.out.println(gen1.getName() + "\n");

        Gender gen2 = GenderDao.getById(2);
        System.out.println(gen2.getId() + " ");
        System.out.println(gen2.getName() + "\n");

        Gender gen3 = GenderDao.getById(3);
        System.out.println(gen3.getId() + " ");
        System.out.println(gen3.getName());
       */


       //Unit Test->EmployeeDao->getAll()

       /* //Unit Test-3->EmployeeController->get()
       List<Employee> employees = EmployeeDao.getAll();

       for (Employee emp : employees){
        System.out.print(emp.getId() + " ");
        System.out.print(emp.getName() + " ");
        System.out.print(emp.getNic() + " ");
        System.out.println(emp.getGender().getName() + "\n");
        */

       //Unit Test-3->EmployeeController->get()
       List<Employee> employees = EmployeeDao.getAll();

       for (Employee emp : employees){
        System.out.print(emp.getId() + " ");
        System.out.print(emp.getName() + " ");
        System.out.print(emp.getNic() + " ");
        System.out.println(emp.getGender().getName() + "\n");
       }
    
    }
}
