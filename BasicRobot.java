public class BasicRobot{
    private static int id=0;
    private int robotid;
    private String name;
    private int distance = 0;
    private int energy = 100;

    public BasicRobot(String name){
        this.name = name;
        robotid = id++;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return String.format("%10s","[" + name + "]");
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

    public int getDistance(){
        return distance;
    }

    public void setEnergy(int energy){
        this.energy = energy;
    }

    public int getEnergy(){
        return energy;
    }

    public String getInfo(){
        return String.format("Type:%d[%s]\t(EN=%d,POS=%d)", id, name, energy, distance);
    }

}
