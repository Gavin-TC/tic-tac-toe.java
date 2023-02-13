import java.util.Random;

public class Cpu {
    static String[] pos_spots = {
            " "
    };

    public void play(Board b, String[] board) {
        int spot = new Random().nextInt(board.length+1);

//        for (int i = 0; i < board.length; i++) {
//            if (board[i] == "X" || board[i] == "O") {
//
//            }
//        }

        do {
            spot = new Random().nextInt(board.length+1);
        } while(board[spot] == "X" || board[spot] == "O");

        b.pick_spot(spot, Main.cpu_team);
        System.out.println("CPU plays " + spot + ".");
    }
}
