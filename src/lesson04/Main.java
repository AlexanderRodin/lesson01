package lesson04;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] arrId ={};

        arrId = userId(arrId);
        Employee employeeOne = new Employee(arrId.length,"Федотов Дмитрий Иваович", "Директор", "+79295000000", 64000, 54);
        arrId = userId(arrId);
        Employee employeeTwo = new Employee(arrId.length,"Смирнова Ирина Ивановна", "Главный бухгалтер", "+79296677874", 48000, 57);
        arrId = userId(arrId);
        Employee employeeThree  = new Employee(arrId.length,"Иванов Дмитрий Александрович", "Менеджер", "+79227444422", 45000, 26);
        arrId = userId(arrId);
        Employee employeeFour = new Employee(arrId.length,"Сидоров Анатолий Федорович", "Менеджер", "+79826723322", 43000, 35);
        arrId = userId(arrId);
        Employee employeeFive = new Employee(arrId.length,"Надеина Кристина Дмитриена", "Стражор", "+79227445564", 24000, 23);

        employeeOne.showEmployeeId();
        employeeOne.showEmployees();
        employeeOne.employeePosition();
        System.out.println();
        employeeTwo.showEmployeeId();
        employeeTwo.showEmployees();
        employeeTwo.employeePosition();
        System.out.println();
        employeeThree.showEmployeeId();
        employeeThree.showEmployees();
        employeeThree.employeePosition();
        System.out.println();
        employeeFour.showEmployeeId();
        employeeFour.showEmployees();
        employeeFour.employeePosition();
        System.out.println();
        employeeFive.showEmployeeId();
        employeeFive.showEmployees();
        employeeFive.employeePosition();
        System.out.println();

        String[] arrUser = {employeeOne.fullName, employeeTwo.fullName, employeeThree.fullName, employeeFour.fullName, employeeFive.fullName};
        int[] arr = {employeeOne.age, employeeTwo.age, employeeThree.age, employeeFour.age, employeeFive.age};
        System.out.println("Сотрудники старше 40 лет: ");

        for (int i=0;i<arr.length;i++){
            if(arr[i]>40){
                System.out.println(arrUser[i]);
            }
        }
        System.out.println();
        employeeOne.salaryIncrease();
        System.out.println();
        employeeTwo.salaryIncrease();
        System.out.println();
        employeeThree.salaryIncrease();
        System.out.println();
        employeeFour.salaryIncrease();
        System.out.println();
        employeeFive.salaryIncrease();



    }

    public static int[] userId(int[] arr){
        int value = (int) (Math.random() * 100);;

        for(int i = 0; i < arr.length;i++) {
             if(arr[i] == value) value = (int) (Math.random() * 100);
        }
        int[] result = Arrays.copyOf(arr, arr.length + 1);
        result[result.length - 1] = value;
        return result;

        }
}
