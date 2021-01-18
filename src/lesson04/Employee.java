package lesson04;

public class Employee {
    int indexEmployee;
    String fullName;
    String position;
    String phoneNumber;
    int salary;
    int age;

    Employee(int idUser, String userFullName, String userPosition, String userPhoneNumber, int userSalary, int userAge){

        indexEmployee = idUser;
        fullName = userFullName;
        position = userPosition;
        phoneNumber = userPhoneNumber;
        salary = userSalary;
        age = userAge;
    }


    void showEmployees (){
        System.out.println("ФИО: "+fullName);
    }

    void employeePosition(){
        System.out.println("Должность: "+position);
    }

    void showEmployeePhoneNumber (){
        System.out.println("Должность: "+phoneNumber);
    }

    void showEmployeeSalary (){
        System.out.println("Должность: "+salary);
    }

    void showEmployeeAge(){
        System.out.println("Должность: "+age);
    }
    void showEmployeeId(){
        System.out.println("ID Сотрудника: "+ indexEmployee);
    }

    void salaryIncrease(){
        if(age>35) {
            int i = salary;
            salary += 10000;
            System.out.println("Текушущий стаж сотрудника " + fullName + " > 35 лет, ");
            System.out.println("Текущая зарплата составляет: " + i);
            System.out.println("Зарплата с учетом выслуги составит: " + salary);
        }
    }



}
