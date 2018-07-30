import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Utility implements Spaces{
	private int number;
	private int multiplier = 4;
	private boolean isOwned = false;
	private String name;
	private Player owner = null;
	
	public Utility(int n) {
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
	
	public int getPropNum() {
		return -2;
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
	
	public Utility[] getAllUtilities() {
		Utility[] allU = new Utility[2];
		allU[0] = new Utility(12);
		allU[0].name = "Electric Company";
		allU[1] = new Utility(28);
		allU[1].name = "Water Works";
		return allU;
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

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public int compareTo(Spaces s) {
		return this.number - s.getNumber();
	}

	@Override
	public int getRent(ArrayList<Spaces> p) {
		return 0;
	}
	
	public int getRent(int roll, ArrayList<Spaces> p) {
		int numUts = 0;
		for(Spaces prop : p) {
			if(prop.getPropNum() == -2)
				numUts++;
		}
		if(numUts == 2)
			multiplier = 10;
		return multiplier * roll;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 150;
	}

	@Override
	public void bought(Player p) {
		isOwned = true;
		owner = p;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	public boolean isOwned() {
		return isOwned;
	}

}
