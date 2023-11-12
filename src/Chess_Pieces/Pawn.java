package Chess_Pieces;

import Main_Chess_Game.Chess_Board;
import java.awt.image.BufferedImage;

public class Pawn extends Chess_Pieces{
    public Pawn(Chess_Board chess_board, int col, int row, boolean is_white){
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
        this.piece_name="Pawn";
        this.sprite=piece_png.getSubimage(5*png_scale, is_white?0:png_scale,png_scale,png_scale).getScaledInstance(chess_board.chess_board_tile_size,chess_board.chess_board_tile_size, BufferedImage.SCALE_SMOOTH);
    }
    @Override
    public boolean is_Valid_Movement(int col, int row){
        int colour = is_white? 1: -1;
        if(
                // Vertical movement check: It's a standard pawn move, if empty it moves forward
                (this.col==col&&row==this.row-colour&&chess_board.getChess_Pieces(col, row)==null) ||

                //Checks first move or not. If first move allows a pawn jump i.e. 2 tiles
                (is_1st_move&&this.col==col&&row==this.row-colour*2&&chess_board.getChess_Pieces(col, row)==null&&chess_board.getChess_Pieces(col, row+colour)==null) ||
                //for a pawn jump checks if the first tile is empty or not.
                (col==this.col-1&&row==this.row-colour&&chess_board.getChess_Pieces(col,row)!= null) ||
                //if pawn jump allowed then, gives option for moving only one tile.
                (col==this.col+1&&row==this.row-colour&&chess_board.getChess_Pieces(col,row)!= null) ||

                        //Checking diagonal movement and capturing
                        (chess_board.getChess_board_tile(col,row)==chess_board.en_passant&&col==this.col-1&&row==this.row-colour&&chess_board.getChess_Pieces(col,row+colour)!=null) ||
                        (chess_board.getChess_board_tile(col,row)==chess_board.en_passant&&col==this.col+1&&row==this.row-colour&&chess_board.getChess_Pieces(col,row+colour)!=null)
        )
            return true;
        return false;
    }
}