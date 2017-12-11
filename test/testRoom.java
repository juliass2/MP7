import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class testRoom {
	public static void main(String [] args) throws IOException {
		ArrayList<Room> rooms = new ArrayList<Room>();
		Riddle riddle1 = new Riddle("K");
		Riddle riddle2 = new Riddle("C");
		Riddle riddle3 = new Riddle("S");
		Riddle riddle4 = new Riddle("R");
		Riddle riddle5 = new Riddle("O");
		Riddle riddle6 = new Riddle("S");
		Riddle riddle7 = new Riddle("C");
		Riddle riddle8 = new Riddle("CSROCKS");
		//This game has 7 Items.
		Item item1 = new Item ("K");
		Item item2 = new Item ("C");
		Item item3 = new Item ("S");
		Item item4 = new Item ("R");
		Item item5 = new Item ("O");
		Item item6 = new Item ("S");
		Item item7 = new Item ("C");
		
		Room room2C = new Room (riddle2, item2, ImageIO.read(new File("resources/Room2C.jpg")));
		Room room3S = new Room (riddle3, item3, ImageIO.read(new File("resources/Room3S.jpg")));
		Room room4R = new Room (riddle4, item4, ImageIO.read(new File("resources/Room4R.jpg")));
		Room room5O = new Room (riddle5, item5, ImageIO.read(new File("resources/Room5O.jpg")));
		Room room7C = new Room (riddle7, item7, ImageIO.read(new File("resources/Room7C.jpg")));
		Room room1K = new Room (riddle1, item1, ImageIO.read(new File("resources/Room1K.jpg")));
		Room room6S = new Room (riddle6, item6, ImageIO.read(new File("resources/Room6S.jpg")));
		Room room8CSROCKS = new Room (riddle8, null, ImageIO.read(new File("resources/Room8CSROCKS.jpg")));
		rooms.add(room1K);
		rooms.add(room2C);
		rooms.add(room3S);
		rooms.add(room4R);
		rooms.add(room5O);
		rooms.add(room6S);
		rooms.add(room7C);
		rooms.add(room8CSROCKS);
		
		System.out.print(room8CSROCKS.getRoomNumber());
	}
}
