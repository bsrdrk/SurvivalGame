import java.util.Scanner;

public class Game {
    Player player;
    Location location = null ;
    Scanner scan = new Scanner(System.in);

    public void login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Survival Game!");
        System.out.print("Please enter your name : ");
        //String playerName; // = scan.nextLine();
        Player player = new Player("busra");
        player.selectCharacter();
        start(player);
    }

    public void start(Player player) {
       while(true){
           System.out.println();
           System.out.println("===================================================");
           System.out.println();
           System.out.println("Please select a location : ");
           System.out.println("1. Safe House -> There is no enemy!");
           System.out.println("2. Cave       -> Zombies can be found here.");
           System.out.println("3. Forest     -> Vampires can be found here.");
           System.out.println("4. River      -> Bears can be found here.");
           System.out.println("5. Shop       -> You can buy weapons or armor");
           int selectLocation = scan.nextInt();
           while (selectLocation < 0 || selectLocation > 5) {
               System.out.println("Please select a valid location!");
               selectLocation = scan.nextInt();
           }
           switch (selectLocation) {
               case 1:
                   location = new SafeHouse(player);
                   break;
               case 2:
                   location = new Cave(player);
                   break;
               case 3:
                   location = new Forest(player);
                   break;
               case 4:
                   location = new River(player);
                   break;

               case 5:
                   location = new ToolStore(player);
                   break;
               default:
                   location = new SafeHouse(player);
           }
           if(location.getClass().getName().equals("SafeHouse")){
               if(player.getInventory().isFirewood() &&player.getInventory().isWater() && player.getInventory().isFood() ){
                   System.out.println("Congratulations! You won!");
                   break;
               }
           }
           if(!location.getLocation()){
               System.out.println("Game Over");
               break;

           }
       }


    }
}
