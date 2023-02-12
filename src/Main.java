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
//            System.out.println("\\033[H\\033[2J");
//            System.out.flush();
            System.out.println("Pick a number:");
            do {
                turn = scanner.nextInt(); // take the players input
                b.pick_spot(turn, player_team); // pick spot, then pick spot automatically checks for a win
                b.draw_board(map); // draw the board to the terminal
            } while (b.invalid_spot);
            //cpu.play(b, map); // the cpu will now take its turn
            // now the code can simply repeat
        } while (game_running);
    }
}