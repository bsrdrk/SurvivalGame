import java.util.Scanner;

public class Player {
    private int damage;
    private int healthy;
    private int realHealthy;
    private int money;
    private String name;
    private String characterName;
    private Inventory inventory;
    Scanner scan = new Scanner(System.in);

    public Player(String name) {

        this.setName(name);
        this.inventory = new Inventory();
    }

    public void selectCharacter() {
        switch (characterMenu()) {
            case 1: // Samurai
                initPlayer("Samurai" ,5,21,15);
                break;
            case 2: // Archer
                initPlayer("Archer", 7,18,20);
                break;
            case 3: // Knight
                initPlayer("Knight" , 8,24,5);
                break;
            default:
                initPlayer("Samurai" ,5,21,15);
                break;


        }
        System.out.println("Character : " + getCharacterName() + "\t" + "Damage:" + getDamage() + "\t" + "Healthy:" + getHealthy() + "\t" + "Money" + getMoney());
    }
    public void initPlayer(String characterName , int damage,int healthy, int money){
        setCharacterName(characterName);
        setDamage(damage);
        setHealthy(healthy);
        setMoney(money);
        setRealHealthy(healthy);
    }
    public int characterMenu() {
        System.out.println("Please select a character :");
        System.out.println("1- Samurai , \t Damage : 5 , \t Healthy : 21 ,\t Money : 15");
        System.out.println("2- Archer  ,  \t Damage : 7 , \t Healthy : 18 ,\t Money : 20");
        System.out.println("3- Knight  ,  \t Damage : 8 , \t Healthy : 24 ,\t Money : 5");
        System.out.println("Your character selection:");
        int characterID = scan.nextInt();

        while ((characterID < 1) || (characterID > 3)) {
            System.out.println("Please enter a valid character number!");
            System.out.print("Your character selection: ");
            characterID = scan.nextInt();
        }
        return characterID;
    }
    public int getTotalDamage(){
        return this.getDamage() + this.getInventory().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getRealHealthy() {
        return realHealthy;
    }

    public void setRealHealthy(int realhHealthy) {
        this.realHealthy = realhHealthy;
    }
}
