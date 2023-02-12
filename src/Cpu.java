public class Cpu {
    //Board b = new Board();
    public void play(Board b, String[] board) {
        for (int i = 1; i < board.length+1; i++) {
            if (board[i] != "X" || board[i] != "O") {
                b.pick_spot(i, Main.cpu_team);
                break;
            }
        }
    }
}
