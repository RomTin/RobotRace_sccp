public class FlyingRobot{

    private String name;
    private int maxspeed;
    /** max must be under 500. */
    private int speed;
    private int accel;
    private int fuel;

    public BasicFighter(String name, int speed){
        this.name = name;
        maxspeed = speed;
        fuel = 1000;

    }

    public void Fly(){
        setDistance(Accelerate() + getDistance());

    }

    private int Accelerate(){
        return speed*1.5 + (accel*Math.pow(1.5, 2) / 2);
    }

    private int Boost(){
        accel = -(int)(Math.random()*25);
        speed += accel;
        return speed;
    }
}
