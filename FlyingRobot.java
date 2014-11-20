public class FlyingRobot extends BasicRobot{
    private int speed;
    private int luck;
    private int dis_query;
    private int speed_query;

    public FlyingRobot(String name){
        super(name);
        WingParts wing = new WingParts(60);
        speed = 30;
        luck = 30;
    }

    public void Action(){
        setEnergy(getEnergy() - 5);
        if(luck+(int)(Math.random()*50)>45){
            Fly();
            printRacingInfo();
        }else{
            printRacingInfo();
            System.out.println(getName() + " は故障が発生し動けなかった！");
        }
    }

    public void Fly(){
        speed = 30;
        speed_query= speed + wing.Boost();
        setDistance((getDistance() + speed_query) / 10);
    }

    public void printRacingInfo(){
        dis_query = getDistance();
        System.out.print(getName() + " EN:" + getEnergy() + " {");
        for(int i=0; i<dis_query/3; i++){
            System.out.print("=");
        }
        System.out.println(">");
    }

    public String getRobotInfo(){
        return String.format("%s SP:%3d,Luck:%3d", getInfo(), speed, luck);
    }

}
