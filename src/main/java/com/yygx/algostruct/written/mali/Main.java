package com.yygx.algostruct.written.mali;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        //write your code here......
        for (Employee employee : employees) {
            double val = calculateTax(employee.getSalary());
            System.out.println("");
        }
        

    }


    // 计算个人所得税的方法
    public static double calculateTax(double salary) {
        double taxableIncome = salary - 3500; // 扣除数为3500元
        if (taxableIncome <= 0) {
            return 0.0;
        }
        double tax = 0.0;
        if (taxableIncome <= 1500) {
            tax = taxableIncome * 0.03;
        } else if (taxableIncome <= 4500) {
            tax = taxableIncome * 0.1 - 105;
        } else if (taxableIncome <= 9000) {
            tax = taxableIncome * 0.2 - 555;
        } else if (taxableIncome <= 35000) {
            tax = taxableIncome * 0.25 - 1005;
        } else if (taxableIncome <= 55000) {
            tax = taxableIncome * 0.3 - 2755;
        } else if (taxableIncome <= 80000) {
            tax = taxableIncome * 0.35 - 5505;
        } else {
            tax = taxableIncome * 0.45 - 13505;
        }

        return Math.round(tax * 10) / 10.0; // 保留一位小数
    }
}
class Employee{
    private String name;
    private double salary;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}




