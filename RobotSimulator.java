public class RobotSimulator{

    public static void main(String[] args){
        BasicRobot[] Robots;
        String[] NameArray = {"GUNDAM","MACROSS","GETTER","Mk.28","SUSHI","MAGURO"};

        for(int i=0; i<3; i++){
            Robots[i] = new RacingRobot(NameArray[i]);
            System.out.println(Robots[i].getRobotInfo());
        }
        for(int i=3; i<6; i++){
            Robots[i] = new FlyingRobot(NameArray[i]);
            System.out.println(Robots[i].getRobotInfo());
        }

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){}

        System.out.println("\t〜レース開始！！〜");

        for(int i=0; i<10; i++){

            for(int j=0; j<6; j++){
                Robots[j].Action();
            }
            System.out.println("---------------------------------------------");
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){}
        }

        System.out.println("\t〜レース終了！！〜");

    }

}
