public class RobotSimulator{

    public static void main(String[] args){
        RacingRobot[] Robots = new RacingRobot[5];
        String[] NameArray = {"GUNDAM","MACROSS","GETTER","Mk.28","SUSHI"};

        for(int i=0; i<5; i++){
            Robots[i] = new RacingRobot(NameArray[i]);
            System.out.println(Robots[i].getRobotInfo());
        }

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){}

        System.out.println("\t〜レース開始！！〜");

        for(int i=0; i<20; i++){

            for(int j=0; j<5; j++){
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
