public class RacingRobot extends BasicRobot{
    private int speed;
    private int luck;
    private int dis_query;
    private int speed_query;

    public RacingRobot(String name){
        super(name);
        speed = (int)(Math.random()*100) + 20;
        luck = 120 - speed;
    }

    public void Action(){
        setEnergy(getEnergy() - 5);
        if(luck + (int)(Math.random()*70)>50){
            Run();
            printRacingInfo();
            System.out.print("\n");
        }else{
            printRacingInfo();
            System.out.println(" \"故障が発生し動けなかった！\"");
        }
    }

    public void Run(){
        speed_query=(int)(Math.random()*100) + 20;
        if(speed_query > speed){
            setDistance(getDistance() + (int)speed/10);
        }else{
            setDistance(getDistance() + (int)speed_query/10);
        }
    }

    public void printRacingInfo(){
        dis_query = getDistance();
        System.out.print(getName() + " EN:" + getEnergy() + " {");
        for(int i=0; i<dis_query/3; i++){
            System.out.print("=");
        }
        System.out.print(">");
    }

    public String getRobotInfo(){
        return String.format("%s SP:%3d,Luck:%3d", getInfo(), speed, luck);
    }

}
