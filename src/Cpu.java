import java.util.Random;

public class Cpu {
    static String[] pos_spots = {
            " "
    };

    public void play(Board b, String[] map) {
        int spot = new Random().nextInt(map.length);

        for (int i = 0; i < map.length; i++) {
            if (map[i] != "X" || map[i] != "O") {
                b.pick_spot(spot, Main.cpu_team);
            }
        }
        System.out.println("CPU plays " + spot + ".");
    }
}
