package Main_Chess_Game;

import Chess_Pieces.Chess_Pieces;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Basically to move the pieces around in the board.
//We could either just implement built-in interfaces MouseListener and MouseMotionListener or inherit MouseAdapter.
public class Chess_Input extends MouseAdapter{
    static Chess_Board chess_board;
    public Chess_Input(Chess_Board chess_board){
        this.chess_board=chess_board;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int col = e.getX()/chess_board.chess_board_tile_size;
        int row = e.getY()/chess_board.chess_board_tile_size;
        Chess_Pieces chess_pieces_XY = chess_board.getChess_Pieces(col,row);
        if (chess_board.getIs_white_turn() && chess_pieces_XY.is_white) {
            if (chess_pieces_XY != null)
                chess_board.moving_chess_piece = chess_pieces_XY;
        }else if (!chess_board.getIs_white_turn() && !chess_pieces_XY.is_white) {
            chess_board.moving_chess_piece = chess_pieces_XY;
        }

        if (chess_pieces_XY != null) {
            if (chess_board.getIs_white_turn() && chess_pieces_XY.is_white ||
                    !chess_board.getIs_white_turn() && !chess_pieces_XY.is_white) {
                highlightPossibleMoves(chess_pieces_XY);
            }
        }
    }

    private void highlightPossibleMoves(Chess_Pieces chessPiece) {
        for (int r = 0; r < chess_board.row; r++) {
            for (int c = 0; c < chess_board.col; c++) {
                if (chess_board.is_Valid_Move(new Moves(chess_board, chessPiece, c, r))) {
                    chess_board.repaint(c * chess_board.chess_board_tile_size,
                            r * chess_board.chess_board_tile_size,
                            chess_board.chess_board_tile_size,
                            chess_board.chess_board_tile_size);
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(chess_board.moving_chess_piece != null){
            chess_board.moving_chess_piece.x_cod_pos=e.getX()-chess_board.chess_board_tile_size/2;
            chess_board.moving_chess_piece.y_cod_pos=e.getY()-chess_board.chess_board_tile_size/2;
            // here we divided it by 2 so that the piece is centered on the mouse
            chess_board.repaint();
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        int col = e.getX()/chess_board.chess_board_tile_size;
        int row = e.getY()/chess_board.chess_board_tile_size;
        if(chess_board.moving_chess_piece != null){
            Moves moves = new Moves(chess_board, chess_board.moving_chess_piece, col, row);
            if(chess_board.is_Valid_Move(moves)){
                chess_board.make_move(moves);
            }else{
                chess_board.moving_chess_piece.x_cod_pos=chess_board.moving_chess_piece.col*chess_board.chess_board_tile_size;
                chess_board.moving_chess_piece.y_cod_pos=chess_board.moving_chess_piece.row*chess_board.chess_board_tile_size;
            }
        }
        chess_board.moving_chess_piece=null;
        chess_board.repaint();
    }
}