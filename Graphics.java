import java.awt.*;
import javax.swing.*;



public class Graphics extends JFrame
{
    public static void main(String [] args){

        JFrame frame = new JFrame("example project");

        frame.setSize(400, 400);
        frame.setVisible(true);

    }

    public void paint(Graphics g){
        g.fillOval(100,100,200,200);
    }
}