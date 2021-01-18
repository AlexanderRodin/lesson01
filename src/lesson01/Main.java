package lesson01;

public class Main {


    public static void main(String[] args) {

        int a1 = 7;
        int a2 = 10;
        int a3 = 5;
        int a4 = 14;
        int a5 = -5;
        String nameUser = "Ivan";
        int userYear = 200;

        System.out.println("a * (b + (c / d)) = "+rezult(a1, a2, a3, a4));
        System.out.println();
        System.out.println("Сумма чисел "+ a1 + " и " + a2 + " находится в диапазоне от 10 до 20 включительно? = " + limit(a1, a2));
        System.out.println();
        System.out.println("Число "+ a5 + " - "+ number(a5));
        System.out.println();
        System.out.println(userGreeting(nameUser));
        System.out.println();
        System.out.println("Указанный год - " + leapYear(userYear));


    }

    private static float rezult(int a, int b, int c, int d) {
        return a*(b + ((float)c / d));
    }

    private static boolean limit(int a,int b){
        if((a+b)>=10 && (a+b)<=20)return true;
        else return false;
    }

    private static String number(int x){
        if(x>=0){
            return "Положительное";
        } else return "Отрицательное";
    }

    private static String userGreeting (String user){
        return "Привет, " + user;
    }

    private static String leapYear(int year){
        if(year%4==0 && year%100 !=0 || year%400==0) return "високосный";
        else return "не високостный";
    }

    }
