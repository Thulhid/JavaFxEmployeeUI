package com.example.demo2;

import java.util.Hashtable;
import java.util.List;

public class EmployeeController { 


public static List<Employee> get (Hashtable<String,Object> ht){

    List<Employee> employees;

    if (ht == null)
        employees = EmployeeDao.getAll();

    else {
        String name = (String) ht.get("name");
        Gender gender = (Gender) ht.get("gender");





        if (gender == null)
            employees = EmployeeDao.getAllByName(name);
        else if (name == null)
            employees = EmployeeDao.getAllByGender(gender);
        else{
            employees = EmployeeDao.getGandN(gender, name);
        }


    }
   // System.out.println(employees);
return employees;
}
    
}
