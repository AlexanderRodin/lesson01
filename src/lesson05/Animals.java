package lesson05;

import java.util.Random;

public abstract class Animals {

    static final int NANE = -1;
    static final int OK = 1;
    static final int FAIL = 0;

    private String name;
    private float maxRun;
    private float maxSwimming;
    private float maxJump;
    private final Random random = new Random();


    Animals(String name, float maxRun, float maxSwimming, float maxJump){
        float runDiff = random.nextFloat()*maxRun-(maxRun/2);
        float swimmingDiff = random.nextFloat()*maxSwimming-(maxSwimming/2);
        float jumpDiff = random.nextFloat()*maxJump-(maxJump/2);

        this.name=name;
        this.maxRun =  maxRun + runDiff;
        this.maxSwimming = maxSwimming + swimmingDiff;
        this.maxJump = maxJump + jumpDiff;
    }

    String getName(){
        return this.name;
    }
    float getMaxRun(){
        return this.maxRun;
    }
    float getMaxSwimming(){
        return this.maxSwimming;
    }
    float getMaxJump(){
        return this.maxJump;
    }
    protected boolean run(float distance){
        return (distance<=maxRun);
    }
    protected int swimming(float distance){
        return (distance<=maxSwimming)? OK : FAIL;
    }
    protected boolean jump(float distance){
        return (distance<=maxJump);
    }

}
