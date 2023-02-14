import java.util.Scanner;
public class Main {
    public static String player_team;
    public static String cpu_team;
    static int turn;
    static boolean game_running = true;

    public static String[] map = { // board to display to the screen
            "1 ", "2 ", "3",
            "4 ", "5 ", "6",
            "7 ", "8 ", "9"
    };

    public static String[] pos_map = { // use this as a spot possibility check
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9"
    };

    public static void main(String[] args) {
        Board b = new Board(); // initialize the board
        Cpu cpu = new Cpu();
        Scanner scanner = new Scanner(System.in); // create a scanner for inputs
        b.pick_teams(); // pick teams

        b.draw_board(map);
        do {
            System.out.println("Pick a number:");
            do {
                try {
                    turn = scanner.nextInt(); // take the players input
                }
                catch (Exception e) {
                    System.out.println("There was an error: " + e);
                }
                b.pick_spot(turn, player_team); // pick spot
                b.check_win(player_team);
            } while (b.invalid_spot);
            cpu.play(b, map);
            b.check_win(cpu_team);
            b.draw_board(map);
        } while (game_running);
    }
}