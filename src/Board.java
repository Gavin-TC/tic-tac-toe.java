import java.util.Objects;
import java.util.Random;

public class Board {

    public static String[] teams = {"X ", "O "};
    static String winner;
    static boolean win = false;
    public static boolean invalid_spot = false;

    public void pick_teams() {
        int rand = new Random().nextInt(teams.length);
        Main.player_team = teams[rand];
        if (rand == 0) {
            Main.cpu_team = teams[1];
        } else {
            Main.cpu_team = teams[0];
        }

//        team1 = teams[rand];
//
//        System.out.println(team1);
//        return team1;
    }

    public void draw_board(String[] s) {
        System.out.println(s[0] + s[1] + s[2]);
        System.out.println(s[3] + s[4] + s[5]);
        System.out.println(s[6] + s[7] + s[8]);

//       for (int i = 0; i < s.length; i++) {
//           if ((i+3) % 3 == 0) {
//               System.out.print(s[i] + s[i+1] + s[i+2]);
//           } else {
//               System.out.println(s[i] + s[i+1] + s[i+2]);
//           }
//      }
    }

    public void pick_spot(int spot, String team) {
        int true_spot = spot-1; // users input is array[index] + 1, so -1 corrects it
        String spot_string = String.valueOf(spot);

//        System.out.println("spot string == " + spot_string);
//        System.out.println("true spot == " + Main.map[true_spot]);

        if (!Objects.equals(Main.map[true_spot], "X") && !Objects.equals(Main.map[true_spot], "O")) { // if the spot is == to int spot (not a letter) then place it
//            System.out.println("THE SPOT IS AVAILABLE");
            invalid_spot = false;
            Main.map[true_spot] = team;
            check_win(team);
        } else {
            invalid_spot = true;
            System.out.println("That spot is invalid.");
        }
    }
    public static void check_win(String team) {
        int[] diagonal_win; // diagonal/horizontal/vertical win conditions
        int[] hor_win;
        int[] ver_win;

        if (Main.map[0] == team && Main.map[4] == team && Main.map[8] == team) { // diagonal left-right
            win = true;
            winner = team;
        } else if (Main.map[6] == team && Main.map[4] == team && Main.map[2] == team) {
            win = true;
            winner = team;
        }

        if (win) {
            Main.game_running = false;
            System.out.println(team + " wins the game!");
        }
    }
}