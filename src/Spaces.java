import java.util.ArrayList;

import javax.swing.JLabel;

public interface Spaces {
	
	public int getNumber();
	public int compareTo(Spaces s);
	public int getRent(ArrayList<Spaces> p);
	public int getPrice();
	public void bought(Player p);
	public int getType();
	public JLabel getImageLabel();
	public JLabel getMenuLabel();
	public boolean isOwned();
	public int getPropNum();
	public Player getOwner();
	public void setOwner(Player p);
	public String getName();
}
