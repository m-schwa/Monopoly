
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Chance {
	private int number;
	private Player player;
	private ArrayList<Chance> chances;
	
	public Chance(int n, Player p) {
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
			player.addMoney(50);
		else if(i == 2)
			if(player.getLocation() < 3)
				player.setLocation(40 - 3 - player.getLocation());
			else
				player.setLocation(player.getLocation() - 3);
		else if(i == 4) 
			player.setLocation(39);		
		else if(i == 5) {
			if(player.getLocation() < 5)
				player.setLocation(5);
			else if(player.getLocation() < 15) 
				player.setLocation(15);
			else if(player.getLocation() < 25)
				player.setLocation(25);
			else if(player.getLocation() < 35)
				player.setLocation(35);
		}
		else if(i == 6) {			
			player.setLocation(10);
		}
		else if(i == 7) {
			if(player.getLocation() > 11)
				player.addMoney(200);
			player.setLocation(11);
		}
		else if(i == 8)
			player.addMoney(150);
		else if(i == 9)
			player.addMoney(-15);
		else if(i == 10) {
			if(player.getLocation() > 24)
				player.addMoney(200);
			player.setLocation(24);			
		}
		else if(i == 11) {
			if(player.getLocation() > 5)
				player.addMoney(200);
		}
		else if(i == 12) {
			if(player.getLocation() < 5)
				player.setLocation(5);
			else if(player.getLocation() < 15) 
				player.setLocation(15);
			else if(player.getLocation() < 25)
				player.setLocation(25);
			else if(player.getLocation() < 35)
				player.setLocation(35);
		}
		else if(i == 13) {
			if(player.getLocation() > 28 || player.getLocation() < 12) {
				if(player.getLocation() > 28)
					player.addMoney(200);
				player.setLocation(12);
			}
			else
				player.setLocation(28);
		}
		else if(i == 14)
			player.setLocation(0);
		else if(i == 15) {
			player.addMoney(-1* (50 * (players.length - 1)));
			for(int x = 0; x < players.length; x++) {
				if(players[x].getPlayerNumber() != player.getPlayerNumber()) {
					players[x].addMoney(50);
				}
			}
		}
		else if(i == 16)
			player.addMoney(-25 * player.getNumHouses() + -100 * player.getNumHotels());		
	}
	
	public ArrayList<Chance> getAllChanceCards(){
		chances = new ArrayList<Chance>();
		for(int i = 1; i < 17; i++) {
			if(i != 3) {
				chances.add(new Chance(i, player));	
			}					
		}
		return chances;
	}
	
	public JLabel getImageLabel() {
		JLabel pic = new JLabel();
		pic.setBounds(0, 0, 240, 138);
		ImageIcon med = new ImageIcon(number + ".png");
		Image img = med.getImage();		
		Image finalImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);	
		//learned on Stack Overflow, resizes the image to fit the JLabel
		pic.setIcon(new ImageIcon(finalImg));
		return pic;
	}
	
	
}
