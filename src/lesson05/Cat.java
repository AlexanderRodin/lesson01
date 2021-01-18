package lesson05;

public class Cat extends Animals {

    public Cat (String name, float maxRun, float maxSwimming, float maxJump){
        super(name, maxRun, maxSwimming, maxJump);
    }

    @Override
    protected int swimming(float distance) {
        return Animals.NANE;
    }

}
