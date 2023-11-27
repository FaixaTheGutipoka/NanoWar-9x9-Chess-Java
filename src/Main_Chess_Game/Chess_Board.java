package Main_Chess_Game;

import Chess_Pieces.Chess_Pieces;
import Chess_Pieces.Rook;
import Chess_Pieces.Knight;
import Chess_Pieces.Bishop;
import Chess_Pieces.Queen;
import Chess_Pieces.King;
import Chess_Pieces.Pawn;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Chess_Board extends JPanel {
    public static int move_counter = 0;
    public int chess_board_tile_size = 60;

    int row = 9;
    int col = 9;
    ArrayList<Chess_Pieces> chess_pieces_list = new ArrayList<>();
    public Chess_Pieces moving_chess_piece;
    Chess_Input input = new Chess_Input(this);
    public int en_passant = -1;

    public Chess_Board(){
        this.setPreferredSize(new Dimension(col*chess_board_tile_size, row*chess_board_tile_size));

        this.addMouseListener(input);
        this.addMouseMotionListener(input);

        add_chess_pieces();
    }

    public Chess_Pieces getChess_Pieces(int col, int row){
        Chess_Pieces chess_piece = null;
        for (Chess_Pieces piece : chess_pieces_list) {
            chess_piece = (piece.col == col && piece.row == row) ? piece : chess_piece;
        }
        return chess_piece;
    }

    public boolean is_Valid_Move(Moves moves){
        if(Colour_Check(moves.piece, moves.taken_piece)||
                (!moves.piece.is_Valid_Movement(moves.new_col,moves.new_row))||
                (moves.piece.collision(moves.new_col, moves.new_row))) {
            return false;
        }
        return true;
    }
    private boolean is_white_turn = true;
    public boolean getIs_white_turn() {
        return is_white_turn;
    }
    public void make_move(Moves moves) {
        if ((is_white_turn && moves.piece.is_white) || (!is_white_turn && !moves.piece.is_white)) {
            if (moves.piece.piece_name.equals("Pawn")) {
                pawn_move(moves);
            } else {
                moves.piece.col = moves.new_col;
                moves.piece.row = moves.new_row;

                moves.piece.x_cod_pos = moves.new_col * chess_board_tile_size;
                moves.piece.y_cod_pos = moves.new_row * chess_board_tile_size;

                moves.piece.is_1st_move = false;

                taken(moves.taken_piece);
            }

            is_white_turn = !is_white_turn;
        }
    }

    private void pawn_move(Moves moves){
        moves.piece.col = moves.new_col;
        moves.piece.row = moves.new_row;

        moves.piece.x_cod_pos = moves.new_col * chess_board_tile_size;
        moves.piece.y_cod_pos = moves.new_row * chess_board_tile_size;

        moves.piece.is_1st_move = false;

        taken(moves.taken_piece);

        //Promotion to Queen:
        if((moves.new_row==0&&moves.piece.is_white)||(moves.new_row==8&&!moves.piece.is_white)){
            chess_pieces_list.add(new Queen(this, moves.new_col, moves.new_row, moves.piece.is_white));
            taken(moves.piece);
        }
    }

    public void taken(Chess_Pieces chess_pieces){
        chess_pieces_list.remove(chess_pieces);
    }
    public boolean Colour_Check(Chess_Pieces piece1, Chess_Pieces piece2){
        if(piece1==null||piece2==null)
            return false;
        return piece1.is_white==piece2.is_white;
    }
    public int getChess_board_tile(int col, int row){
        return row*this.row+col;
    }
    public void add_chess_pieces(){
        //Arrangement of row 1 of black side:
        chess_pieces_list.add(new Rook(this, 0, 0, false));
        chess_pieces_list.add(new Knight(this, 1, 0, false));
        chess_pieces_list.add(new Bishop(this, 2, 0, false));
        chess_pieces_list.add(new Queen(this, 3, 0, false));
        chess_pieces_list.add(new King(this, 4, 0, false));
        chess_pieces_list.add(new Queen(this, 5, 0, false));
        chess_pieces_list.add(new Bishop(this, 6, 0, false));
        chess_pieces_list.add(new Knight(this, 7, 0, false));
        chess_pieces_list.add(new Rook(this, 8, 0, false));

        //Arrangement of row 2 of black side:
        chess_pieces_list.add(new Pawn(this, 0, 1, false));
        chess_pieces_list.add(new Pawn(this, 1, 1, false));
        chess_pieces_list.add(new Pawn(this, 2, 1, false));
        chess_pieces_list.add(new Pawn(this, 3, 1, false));
        chess_pieces_list.add(new Pawn(this, 4, 1, false));
        chess_pieces_list.add(new Pawn(this, 5, 1, false));
        chess_pieces_list.add(new Pawn(this, 6, 1, false));
        chess_pieces_list.add(new Pawn(this, 7, 1, false));
        chess_pieces_list.add(new Pawn(this, 8, 1, false));



        //Arrangement of row 1 of black side:
        chess_pieces_list.add(new Rook(this, 0, 8, true));
        chess_pieces_list.add(new Knight(this, 1, 8, true));
        chess_pieces_list.add(new Bishop(this, 2, 8, true));
        chess_pieces_list.add(new Queen(this, 3, 8, true));
        chess_pieces_list.add(new King(this, 4, 8, true));
        chess_pieces_list.add(new Queen(this, 5, 8, true));
        chess_pieces_list.add(new Bishop(this, 6, 8, true));
        chess_pieces_list.add(new Knight(this, 7, 8, true));
        chess_pieces_list.add(new Rook(this, 8, 8, true));

        //Arrangement of row 2 of black side:
        chess_pieces_list.add(new Pawn(this, 0, 7, true));
        chess_pieces_list.add(new Pawn(this, 1, 7, true));
        chess_pieces_list.add(new Pawn(this, 2, 7, true));
        chess_pieces_list.add(new Pawn(this, 3, 7, true));
        chess_pieces_list.add(new Pawn(this, 4, 7, true));
        chess_pieces_list.add(new Pawn(this, 5, 7, true));
        chess_pieces_list.add(new Pawn(this, 6, 7, true));
        chess_pieces_list.add(new Pawn(this, 7, 7, true));
        chess_pieces_list.add(new Pawn(this, 8, 7, true));
    }

    //paintComponent is a built-in method in JPanel which we will be overriding
    public void paintComponent(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;

        for(int r=0; r<row; r++) {
            for (int c = 0; c <col; c++) {
                graphics2D.setColor((c + r) % 2 == 0 ? new Color(212, 228, 255, 228) : new Color(0, 50, 86, 208));
                graphics2D.fillRect(c * chess_board_tile_size, r * chess_board_tile_size, chess_board_tile_size, chess_board_tile_size);
            }
        }

        //highlighting parts where the piece can move
        if(moving_chess_piece!=null) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (is_Valid_Move(new Moves(this, moving_chess_piece, c, r))) {
                        graphics2D.setColor(new Color(255, 247, 0, 178));
                        graphics2D.fillRect(c*chess_board_tile_size, r*chess_board_tile_size, chess_board_tile_size, chess_board_tile_size);
                    }
                }
            }
        }

        //painting pieces
        for (Chess_Pieces piece:chess_pieces_list){
            piece.paint(graphics2D);
        }
    }
}
