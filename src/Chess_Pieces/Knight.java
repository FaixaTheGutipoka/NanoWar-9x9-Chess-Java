package Chess_Pieces;

import Main_Chess_Game.Chess_Board;
import java.awt.image.BufferedImage;
public class Knight extends Chess_Pieces{
    public Knight(Chess_Board chess_board, int col, int row, boolean is_white){
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

        this.piece_name="Knight";
        this.sprite=piece_png.getSubimage(3*png_scale, is_white?0:png_scale,png_scale,png_scale).getScaledInstance(chess_board.chess_board_tile_size,chess_board.chess_board_tile_size, BufferedImage.SCALE_SMOOTH);
    }
    public boolean is_Valid_Movement(int col, int row){
        //Knight moves in an L-shape: (2,1) or (1,2)
        return (Math.abs(col - this.col) == 2 && Math.abs(row - this.row) == 1) || (Math.abs(col - this.col) == 1 && Math.abs(row - this.row) == 2);
    }
    public boolean collision(int col, int row){
        //there are no such collision cases for knight
        return false;
    }
}