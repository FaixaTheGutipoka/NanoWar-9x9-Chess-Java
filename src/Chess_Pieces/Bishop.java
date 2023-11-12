package Chess_Pieces;

import Main_Chess_Game.Chess_Board;
import java.awt.image.BufferedImage;
public class Bishop extends Chess_Pieces{
    public Bishop(Chess_Board chess_board, int col, int row, boolean is_white){
        super(chess_board);
        this.col=col;
        this.row=row;
        this.x_cod_pos=col*chess_board.chess_board_tile_size;
        this.y_cod_pos=row*chess_board.chess_board_tile_size;
        this.is_white=is_white;

        PieceColor color;
        if(is_white){
            color = PieceColor.WHITE;
        }else {
            color = PieceColor.BLACK;
        }

        this.piece_name="Bishop";
        this.sprite=piece_png.getSubimage(2*png_scale, is_white?0:png_scale,png_scale,png_scale).getScaledInstance(chess_board.chess_board_tile_size,chess_board.chess_board_tile_size, BufferedImage.SCALE_SMOOTH);
    }
    public boolean is_Valid_Movement(int col, int row){
        //Bishop moves diagonally, so the column and row differences should be equal.
        return Math.abs(col - this.col) == Math.abs(row - this.row);
    }
    public boolean collision(int col, int row) {
        if (Math.abs(col - this.col) == Math.abs(row - this.row)) {
            // Check for diagonal collision.
            int stepCol = (this.col < col) ? 1 : -1;
            int stepRow = (this.row < row) ? 1 : -1;
            int c = this.col + stepCol;
            int r = this.row + stepRow;
            while (c != col && r != row) {
                if (chess_board.getChess_Pieces(c, r) != null)
                    return true;
                c += stepCol;
                r += stepRow;
            }
        }
        return false;
    }
}