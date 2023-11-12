package Main_Chess_Game;
import Chess_Pieces.Chess_Pieces;
public class Moves {
    int pre_col, pre_row, new_col, new_row;
    Chess_Pieces piece, taken_piece;
    boolean is_1st_move;
    public Moves(Chess_Board chess_board, Chess_Pieces piece, int new_col, int new_row){
        this.pre_col=piece.col;
        this.pre_row=piece.row;
        this.new_col=new_col;
        this.new_row=new_row;
        this.piece=piece;
        this.taken_piece=chess_board.getChess_Pieces(new_col,new_row);
    }
}
