public class FlyingRobot extends BasicRobot implements Forwardable{
    private int speed;
    private int luck;
    private int dis_query;
    private int speed_query;
    private WingParts wing;

    public FlyingRobot(String name){
        super(name);
        wing = new WingParts(40);
        luck = 30;
        speed = 30;
    }

    public void forward(){
        if(isMovable()){
            setEnergy(getEnergy() - 10);
            if(luck + (int)(Math.random()*70)>50){
                /** "運"と"70以下の自然数"の和が50より大きければ前に進む */
                MoveForward();
                printRacingInfo();
                System.out.print("\n");
            }else{
                printRacingInfo();
                System.out.println(" 「故障が発生して動けなかった！」");
            }
        }
    }

    public boolean isMovable(){
        return getEnergy() > 0;
    }

    public void MoveForward(){
        speed_query=(int)(Math.random()*100);
        if(speed_query > speed){
            setDistance(getDistance() + (int)(speed + wing.Boost())/10);
            /** speed + Boost以上の速度で前に進むことはできない */
        }else{
            setDistance(getDistance() + (int)(speed_query + wing.Boost())/10);
        }
    }

    public void printRacingInfo(){
        dis_query = getDistance();
        System.out.print(getRobotInfoS() + " {" + getRacingDistance((int)dis_query/3));
    }

    private String getRacingDistance(int distance){
        if(distance > 0){
            /** distance/3の数だけ"="を繋げた文字列を返す */
            return "=" + getRacingDistance(distance - 1);
        }else{
            return ">";
        }
    }

    private String getRobotInfoS(){
        return String.format("%s SP:%3d EN:%3d", getName(), speed + wing.getSpeed(), getEnergy());
    }

    public String getRobotInfo(){
        return String.format("%s SP:%3d+wing(%2d) Luck:%3d", getInfo(), speed, wing.getMax(), luck);
    }

}
