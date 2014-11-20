public class WingParts{
    private int maxSpeed;
    private static int speed;

    public WingParts(int speed){
        this.maxSpeed = speed;
    }

    public int Boost(){
        speed = maxSpeed - (int)(Math.random()*maxSpeed);
        return speed;
    }

    public int getMax(){
        return maxSpeed;
    }

    public int getSpeed(){
        return speed;
    }

}
