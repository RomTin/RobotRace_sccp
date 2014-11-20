public class RobotSimulator{

    private RacingRobot[] Robots = new RacingRobot[6];
    private String[] NameArray = {"GUNDAM","MACROSS","GETTER","Mk.28","SUSHI","MAGURO"};

    public RobotSimulator(){

        register();

        try{
            Thread.sleep(3000);
            /** ロボット登録からレース開始までの待機時間 */
        }catch(InterruptedException e){}

        System.out.println("\t〜レース開始！！〜");

        for(int j=0; j<10; j++){

            for(int i=0; i<6; i++){
                Robots[i].Run();
            }
            System.out.println("---------------------------------------------");
            try{
                Thread.sleep(2000);
                /** 次の行動までの待機時間 */
            }catch(InterruptedException e){}
        }

        System.out.println("\t〜レース終了！！〜");

    }

    public void register(){
        for(int i=0; i<6; i++){
            Robots[i] = new RacingRobot(NameArray[i]);
            System.out.println(Robots[i].getRobotInfo());
        }
    }

    public static void main(String[] args){

        new RobotSimulator();

    }

}
