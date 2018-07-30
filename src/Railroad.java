import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Railroad implements Spaces{
	private int rent = 25;
	private int mortgageValue = 100;
	private int number;
	private boolean bought = false;
	private int rrNum;
	private int price = 200;
	private int owned;
	private String name;
	private Player owner = null;
	
	public Railroad(int n) {
		number = n;		
	}
	
	public String getName() {
		return name;
	}
	
	public void setOwner(Player p) {
		owner = p;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public JLabel getMenuLabel() {
		JLabel pic = new JLabel();
		pic.setBounds(0, 0, 110, 150);
		ImageIcon med = new ImageIcon(name + ".png");
		Image img = med.getImage();
		Image finalImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
		//learned on Stack Overflow, resizes the image to fit the JLabel
		pic.setIcon(new ImageIcon(finalImg));
		return pic;
	}
	
	public int getPropNum() {
		return -1;
	}
	
	public boolean isOwned() {
		return bought;
	}
	
	public JLabel getImageLabel() {
		JLabel pic = new JLabel();
		pic.setBounds(0, 0, 220, 300);
		ImageIcon med = new ImageIcon(name + ".png");
		Image img = med.getImage();
		Image finalImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
		//learned on Stack Overflow, resizes the image to fit the JLabel
		pic.setIcon(new ImageIcon(finalImg));
		return pic;
	}
	
	public int getType() {
		return 1;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getRent(ArrayList<Spaces> p) {
		int numOwned = 0;
		for(Spaces s : p) {
			if(s.getPropNum() == -1)
				numOwned++;
		}
		if(numOwned == 1)
			return 25;
		else if(numOwned == 2)
			return 50;
		else if(numOwned == 3)
			return 100;
		else
			return 200;
	}
	
	public Railroad[] getAllRR() {
		Railroad[] allRR = new Railroad[4];
		allRR[0] = new Railroad(5);
		allRR[0].name = "Reading";
		allRR[1] = new Railroad(15);
		allRR[1].name = "Pennsylvania Railroad";
		allRR[2] = new Railroad(25);
		allRR[2].name = "B & O";
		allRR[3] = new Railroad(35);
		allRR[3].name = "Short Line";
		return allRR;
	}
	
	public void bought(Player p) {
		bought = true;
		owner = p;
	}
	
	public int getNumOwned() {
		return owned;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int compareTo(Spaces s) {
		return this.number - s.getNumber();
	}	
}
