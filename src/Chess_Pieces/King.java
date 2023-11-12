package Chess_Pieces;

import Main_Chess_Game.Chess_Board;
import java.awt.image.BufferedImage;
public class King extends Chess_Pieces{
    public King(Chess_Board chess_board, int col, int row, boolean is_white){
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
        this.piece_name="King";
        this.sprite=piece_png.getSubimage(0, is_white?0:png_scale,png_scale,png_scale).getScaledInstance(chess_board.chess_board_tile_size,chess_board.chess_board_tile_size, BufferedImage.SCALE_SMOOTH);
    }
    public boolean is_Valid_Movement(int col, int row) {
        //King moves one square in any direction.
        return /*multiplication is for diagonal movement*/(Math.abs((col - this.col)*(row-this.row))==1) ||
                /*addition is for horizontal or vertical movement*/(Math.abs(col - this.col)+Math.abs(row - this.row))==1;
    }
    public boolean collision(int col, int row) {
        // Left Collision:
        if (this.col > col) {
            for (int c = this.col - 1; c > col; c--) {
                if (chess_board.getChess_Pieces(c, this.row) != null)
                    return true;
            }
        }
        // Right Collision:
        if (this.col < col) {
            for (int c = this.col + 1; c < col; c++) {
                if (chess_board.getChess_Pieces(c, this.row) != null)
                    return true;
            }
        }
        // Up Collision:
        if (this.row > row) {
            for (int r = this.row - 1; r > row; r--) {
                if (chess_board.getChess_Pieces(this.col, r) != null)
                    return true;
            }
        }
        // Down Collision:
        if (this.row < row) {
            for (int r = this.row + 1; r < row; r++) {
                if (chess_board.getChess_Pieces(this.col, r) != null)
                    return true;
            }
        }
        return false;
    }
}