public class SafeHouse extends NormalLocation {
    SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean getLocation() {
        player.setHealthy(player.getRealHealthy());
        System.out.println("You healed.");
        System.out.println("You are in the Safe House...");
        return true;
    }
}
