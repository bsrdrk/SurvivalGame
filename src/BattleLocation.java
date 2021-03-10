public class BattleLocation extends Location {
    protected Obstacle obstacle;
    protected String award;

    BattleLocation(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
        this.award = award;
    }

    @Override
    public boolean getLocation() {
        int obstacleCount = obstacle.count(); // randomly created obstacle
        System.out.println("You are in the " + getName());
        if (obstacleCount > 1)
            System.out.println("Be careful! There are " + obstacleCount + " " + obstacle.getObstacleName() + "s");
        else
            System.out.println("Be careful! There is a " + obstacle.getObstacleName());
        System.out.print("<F>ight or <R>un ");
        String selectCase = scan.next();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("F")) {
            if (combat(obstacleCount)) {
                System.out.println("You defeated the enemies in the " + this.getName() + "!");
                if (this.award.equals("Food") && player.getInventory().isFood() == false) {
                    System.out.println("you won the " + this.award);
                    player.getInventory().setFood(true);
                } else if (this.award.equals("Water") && player.getInventory().isWater() == false) {
                    System.out.println("you won the " + this.award);
                    player.getInventory().setWater(true);
                } else if (this.award.equals("Firewood") && player.getInventory().isFirewood() == false) {
                    System.out.println("you won the " + this.award);
                    player.getInventory().setFirewood(true);
                }
                return true;
            }
            if(player.getHealthy()<= 0 ){
                System.out.println("You died!");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obstacleCount) {
        for (int i = 0; i < obstacleCount; i++) {
            int defaultObstacleHealthy = obstacle.getHealthy();
            playerStats();
            enemyStats();

            while (player.getHealthy() > 0 && obstacle.getHealthy() > 0) {
                System.out.print("<H>it or <R>un ");
                String selectCase = scan.next();
                selectCase = selectCase.toUpperCase();
                if (selectCase.equals("H")) {
                    System.out.println("You hit it!");
                    obstacle.setHealthy(obstacle.getHealthy() - player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealthy() > 0) {
                        System.out.println();
                        System.out.println(obstacle.getObstacleName() + " hit you!");
                        player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInventory().getArmor()));
                        afterHit();
                    }
                } else {
                    return false;
                }

            }
            if (obstacle.getHealthy() <= 0 && player.getHealthy() > 0) { //enemy died
                System.out.println("You defeated the enemy");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Your new money :" + player.getMoney());
                obstacle.setHealthy(defaultObstacleHealthy);
            } else {
                return false;
            }
            System.out.println("--------------------------");
        }
        return true;
    }

    public void playerStats() {
        System.out.println("Player Stats: \n -------------");
        System.out.println("Healthy : " + player.getHealthy());
        System.out.println("Damage  : " + player.getTotalDamage());
        System.out.println("Money   : " + player.getMoney());
        if (player.getInventory().getDamage() > 0) {
            System.out.println("Gun    : " + player.getInventory().getWeapenName());
        }
        if (player.getInventory().getArmor() > 0) {
            System.out.println("Armor  : " + player.getInventory().getArmorName());
        }

    }

    public void enemyStats() {
        System.out.println("\n" + obstacle.getObstacleName() + "  Stats \n----------------");
        System.out.println("Healty : " + obstacle.getHealthy());
        System.out.println("Damage : " + obstacle.getDamage());
        System.out.println("Award : " + obstacle.getAward());
    }

    public void afterHit() {
        System.out.println("Player Healthy : " + player.getHealthy());
        System.out.println(obstacle.getObstacleName() + " Healthy : " + obstacle.getHealthy());
        System.out.println();
    }
}
