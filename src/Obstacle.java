import java.util.Random;

public class Obstacle { // canavar
    private int damage;
    private int healthy;
    private int award;
    private int maxnumber;
    private String obstacleName ;


    public Obstacle(int damage, int healthy, int award, int maxnumber, String obstacleName) {
        this.setDamage(damage);
        this.setHealthy(healthy);
        this.setAward(award);
        this.setMaxnumber(maxnumber);
        this.setObstacleName(obstacleName);
    }
    public int count(){
        Random rand = new Random();
        return rand.nextInt(this.maxnumber)+1;
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

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getMaxnumber() {
        return maxnumber;
    }

    public void setMaxnumber(int maxnumber) {
        this.maxnumber = maxnumber;
    }

    public String getObstacleName() {
        return obstacleName;
    }

    public void setObstacleName(String obstacleName) {
        this.obstacleName = obstacleName;
    }
}
