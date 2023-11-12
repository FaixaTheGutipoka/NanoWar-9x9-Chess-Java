package Chess_Pieces;

import Main_Chess_Game.Chess_Board;
import java.awt.image.BufferedImage;
public class Queen extends Chess_Pieces{
    public Queen(Chess_Board chess_board, int col, int row, boolean is_white){
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
        this.piece_name="Queen";
        this.sprite=piece_png.getSubimage(png_scale, is_white?0:png_scale,png_scale,png_scale).getScaledInstance(chess_board.chess_board_tile_size,chess_board.chess_board_tile_size, BufferedImage.SCALE_SMOOTH);
    }
    @Override
    public boolean is_Valid_Movement(int col, int row) {
        //Queen is the union of Rook and Bishop.
        //It moves along the same column, the same row, or a diagonal.
        return /*Rook Part: */(col == this.col) || (row == this.row) ||
                /*Bishop Part: */(Math.abs(col - this.col) == Math.abs(row - this.row));
    }
    @Override
    public boolean collision(int col, int row) {
        //Queen is the union of Rook and Bishop.
        //Check if it's along the same column, the same row, or a diagonal.
        //Rook Part:
        if (this.col == col) {
            // Check for vertical collision.
            int step = (this.row < row) ? 1 : -1;
            for (int r = this.row + step; r != row; r += step) {
                if (chess_board.getChess_Pieces(this.col, r) != null)
                    return true;
            }
        } else if (this.row == row) {
            // Check for horizontal collision.
            int step = (this.col < col) ? 1 : -1;
            for (int c = this.col + step; c != col; c += step) {
                if (chess_board.getChess_Pieces(c, this.row) != null)
                    return true;
            }
        }
        //Bishop Part:
        else if (Math.abs(col - this.col) == Math.abs(row - this.row)) {
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
