package Chess_Pieces;

import Main_Chess_Game.Chess_Board;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public abstract class Chess_Pieces {
        public enum PieceColor{
        BLACK,
        WHITE;
        }
    public int col, row, x_cod_pos, y_cod_pos;
    public boolean is_white, is_1st_move = true;
    public boolean getIs_white() {
        return is_white;
    }
    public PieceColor color;
    public String piece_name;
    BufferedImage piece_png;
    public Chess_Board chess_board;
    Image sprite;
    {
        try {
            piece_png = ImageIO.read(ClassLoader.getSystemResourceAsStream("Chess_Pieces.png"));
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
    protected int png_scale = piece_png.getWidth()/6;
    public Chess_Pieces(Chess_Board chess_board){
        this.chess_board = chess_board;
    }
    public void paint(Graphics2D graphics2D){
        graphics2D.drawImage(sprite, x_cod_pos, y_cod_pos, null);
    }
    public boolean is_Valid_Movement(int col, int row){return true;}
    public boolean collision(int col, int row){return false;}
}
