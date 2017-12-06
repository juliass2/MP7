import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class Game extends JPanel{
	//INSTANCE VARIABLES
	private boolean gameEnded;
	private Room[] rooms;
	private Player ourPlayer;
	
	int x = 0;
    int y = 0;
    private void moveBall() {
        x = x + 1;
        y = y + 1;
    }
	
	public Game () {
		//This game has 7 Riddles.
		
		//This game has 7 Items.
		
		//This game has 7 Rooms.
		
		//This game has 1 player.
		
		gameEnded = false;
	}
	
	public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, 30, 30);
    }
	
	public static void main(String[] args) throws InterruptedException {
		JFrame myFrame = new JFrame("GETOUTTAHERE");
		Game game = new Game();
		myFrame.add(game);
		myFrame.setSize(900,800);
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		
	}

}
