public class WingParts{

    private int maxSpeed;
    private int speed;

    public WingParts(int speed){
        this.maxSpeed = speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public int Boost(){
        speed = maxSpeed - (int)(Math.random()*maxSpeed);
        return speed;
    }

    public int getSpeed(){
        return speed;
    }

}
