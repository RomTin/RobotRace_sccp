public class RacingRobot extends BasicRobot implements Forwardable{
    private int speed;
    private int luck;
    private int dis_query;
    private int speed_query;
    private FootParts foot;

    public RacingRobot(String name){
        super(name);
        foot = new FootParts(20);
        luck = (int)(Math.random()*100);
        speed = 100 - luck + foot.getFootSpeed();
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
        speed_query=(int)(Math.random()*100) + foot.getFootSpeed();
        if(speed_query > speed){
            setDistance(getDistance() + (int)speed/10);
            /** speed以上の速度で前に進むことはできない */
        }else{
            setDistance(getDistance() + (int)speed_query/10);
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
        return String.format("%s SP:%3d EN:%3d", getName(), speed, getEnergy());
    }

    public String getRobotInfo(){
        return String.format("%s SP:%3d+foot(%2d) Luck:%3d", getInfo(), speed - foot.getFootSpeed(), foot.getFootSpeed(), luck);
    }

}
