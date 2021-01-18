package lesson05;

public class Main {

    static String nameString;
    static String eventName;
    static String eventResult;

    public static void main(String[] args) {
        Bird bird = new Bird("Bird", 5,(float) 0.2, 5);
        Cat cat = new Cat("Cat", 200, 2, 3);
        Dog dog = new Dog("Dog", 500, (float) 0.5, 10);
        Horse horse = new Horse("Horse", 1500,  3, 100);
        Dog dog2 = new Dog("Тузик", 500, (float) 0.5,  3);

        Animals[] arr = {bird, cat, dog, horse, dog2};
        float toRun = 250;
        float toSwimming = 8;
        float toJump = (float) 2.5;

        for(int i = 0; i < arr.length; i++) {
            nameString = arr[i].getName() + " может ";
            runningEstofeta(arr[i], toRun);
            swimmingEstofeta(arr[i], toSwimming);
            jumpingEstophet(arr[i], toJump);
        }
    }
    private static void runningEstofeta(Animals animals, float distance){
        eventName = String.format("побежать на %.2f m. Пытается пробежать на ", animals.getMaxRun());
        eventResult = animals.run(distance) ? " м. и это получилось" : " м. и это не получилось";
        System.out.println(nameString+eventName+distance+eventResult);
    }
    private static void swimmingEstofeta(Animals animals, float distance){
        int swimResult = animals.swimming(distance);
        eventName = String.format("проплыть на %.2f m. Пытается пробежать на ", animals.getMaxSwimming());
        eventResult = (swimResult == Animals.OK) ? " м. и это получилось" : " м. и это не получилось";
        if(swimResult == Animals.NANE)
            eventResult = "не получилось так как не умеет плавать!";
        System.out.println(nameString + eventName + distance + eventResult);
    }
    private static void jumpingEstophet(Animals animals, float distance){
        eventName = String.format("прыгнуть на %.2f m. Пытается прыгнуть на ", animals.getMaxJump());
        eventResult = animals.jump(distance) ? " м. и это получилось" : " м. и это не получилось";
        System.out.println(nameString+eventName+distance+eventResult);
    }
}
