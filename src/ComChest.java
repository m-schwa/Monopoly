
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ComChest {
	private int number;
	private Player player;
	private ArrayList<ComChest> comChests;
	
	public ComChest(int n, Player p) {
		number = n;
		player = p;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setPlayer(Player a) {
		player = a;
	}
	
	public void task(Player[] players) {
		int i = number;
		if(i == 1)
			player.addMoney(25);
		else if(i == 2) {
			player.setLocation(0);
			player.addMoney(200);
		}
		else if(i == 3) 
			player.addMoney(45);
		else if(i == 4)
			player.addMoney(-150);
		else if(i == 5)
			player.addMoney(100);
		else if(i == 6)
			player.addMoney(100);
		else if(i == 7)
			player.addMoney(-100);
		else if(i == 8)
			player.addMoney(200);
		else if(i == 9) 
			player.addMoney(-1*(player.getNumHouses()*40 + player.getNumHotels()*115));
		else if(i == 10) {
			player.addMoney(-50*(players.length-1));
			for(int x = 0; x < players.length; x++) {
				if(players[x].getPlayerNumber() != player.getPlayerNumber())
					players[x].addMoney(50);
			}
		}
		else if(i == 11)
			player.addMoney(-50);
		else if(i == 12)
			player.addMoney(10);
		else if(i == 13)
			player.addMoney(100);
		else if(i == 14)
			player.addMoney(20);
	}
			
	public ArrayList<ComChest> getAllcomChestCards(){
		comChests = new ArrayList<ComChest>();
		for(int i = 1; i < 17; i++) {
			if(i != 3) {
				comChests.add(new ComChest(i, player));	
			}					
		}
		return comChests;
	}
	
	public JLabel getImageLabel() {
		JLabel pic = new JLabel();
		pic.setBounds(0, 0, 240, 138);
		ImageIcon med = new ImageIcon("c"+ number + ".jpg");
		Image img = med.getImage();		
		Image finalImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);	
		//learned on Stack Overflow, resizes the image to fit the JLabel
		pic.setIcon(new ImageIcon(finalImg));
		return pic;
	}
	
	
}
