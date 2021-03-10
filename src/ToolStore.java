public class ToolStore extends NormalLocation {
    ToolStore(Player player) {

        super(player, "ToolStore");
    }

    public boolean getLocation() {
        System.out.println("Money : " + player.getMoney());
        System.out.println("1. Weapons");
        System.out.println("2. Armor");
        System.out.println("3. Exit");
        System.out.print("Your selection : ");
        int selectTool = scan.nextInt();
        int selectItemID;
        switch (selectTool) {
            case 1:
                selectItemID = weaponMenu();
                buyWeapon(selectItemID);

                break;
            case 2:
                selectItemID = armorMenu();
                buyArmor(selectItemID);
                break;
            default:
                break;
        }
        return true;
    }

    public int armorMenu() {
        System.out.println("1. Light \t < Money : 15 - Armor : 1 ");
        System.out.println("2. Medium\t < Money : 25 - Armor : 3 ");
        System.out.println("3. Heavy \t < Money : 40 - Armor : 5 ");
        System.out.println("4. Exit");
        System.out.print("Your selection : ");
        int armorID = scan.nextInt();
        return armorID;

    }

    public void buyArmor(int armorID) {
        int armor = 0, price = 0;
        String armorName = null;
        switch (armorID) {
            case 1:
                armor = 1;
                armorName = "Light";
                price = 15;
                break;
            case 2:
                armor = 3;
                armorName = "Medium";
                price = 25;
                break;
            case 3:
                armor = 5;
                armorName = "Heavy";
                price = 40;
                break;
            case 4:
                System.out.println("Exit ...");
                break;
            default:
                System.out.println("Invalid Selection!");
                break;
        }
        if (price >0){
            if(player.getMoney()>=price){
                player.getInventory().setArmor(armor);
                player.getInventory().setArmorName(armorName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You bought a " + armorName + "! Your armor : " + player.getInventory().getArmor() );
                System.out.println("Your money : " + player.getMoney());
            }
            else{
                System.out.println("You don't have enough money");
            }
        }

    }

    public int weaponMenu() {
        System.out.println("1. Gun  \t < Money : 25 - Damage 2 >");
        System.out.println("2. Sword\t < Money : 35 - Damage 3 >");
        System.out.println("3. Rifle\t < Money : 45 - Damage 7 >");
        System.out.println("4. Çıkış");
        System.out.print("Your Selection : ");
        int selectedWeapon = scan.nextInt();


        return selectedWeapon;
    }

    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String weaponName = null;

        switch (itemID) {
            case 1:
                damage = 2;
                weaponName = "Gun";
                price = 25;
                break;
            case 2:
                damage = 3;
                weaponName = "Sword";
                price = 35;
                break;
            case 3:
                damage = 7;
                weaponName = "Rifle";
                price = 45;
                break;
            case 4:
                System.out.println("Exit ...");
                break;
            default:
                System.out.println("Invalid Selection!");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setDamage(damage);
                player.getInventory().setWeapenName(weaponName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You bought a " + weaponName + "! Your previous damage : " + player.getDamage() + "" +
                        "Your new damage : " + player.getTotalDamage());
                System.out.println("Your money : " + player.getMoney());
            } else {
                System.out.println("You don't have enough money ..!");
            }
        }

    }
}
