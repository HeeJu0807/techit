package com.example.day11;

import java.util.HashSet;
import java.util.Objects;


class Employee {
    public String name;
    public String id;
    public String department;

    public Employee(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "이름 : " + name + ", 아이디 : " + id + ", 부서 : " + department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}



class EmployeeManager {
    HashSet<Employee> employees = new HashSet<>();

    public void addEmployee(Employee employee) {
        if(employees.contains(employee)) {
            System.out.println(employee.id + " 님은 이미 등록된 사원입니다.");
        }
        else {
            employees.add(employee);
            System.out.println(employee.id + " 님 정보 추가");
        }
    }

    public void findEmployee(String id) {
        for(Employee employee : employees) {
            if(employee.id.equals(id)) {
                System.out.println("검색 결과");
                System.out.println(employee);
                return;
            }
        }
        System.out.println(id + " 님의 정보가 존재하지 않습니다.");
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        System.out.println(employee.id + " 님 정보 삭제");
    }
}

public class EmployeeManagerDemo {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee("홍길동", "E01", "HR"));
        manager.addEmployee(new Employee("김철수", "E02", "Marketing"));
        manager.addEmployee(new Employee("홍길동", "E01", "HR")); // 중복 추가 시도

        manager.findEmployee("E01");
        manager.removeEmployee(new Employee("홍길동", "E01", "HR"));
        manager.findEmployee("E01");
    }
}
