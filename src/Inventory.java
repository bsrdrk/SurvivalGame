public class Inventory {
    private boolean water;
    private boolean food;
    private boolean firewood; //bu üçünü topladığında oyunu kazanacak
    private String weapenName;
    private String armorName;
    private int damage;
    private int armor ; //Silahtan ve zırhtan gelen değerler
Inventory(){
    //initialize
    this.setWater(false);
    this.setFood(false);
    this.setFirewood(false);
    this.setDamage(0);
    this.setArmor(0);
    this.setWeapenName(null);
    this.setArmorName(null);
}

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public String getWeapenName() {
        return weapenName;
    }

    public void setWeapenName(String weapenName) {
        this.weapenName = weapenName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}

