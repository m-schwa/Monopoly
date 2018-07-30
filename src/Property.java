import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.HashMap;

public class Property implements Spaces {
	private int price = 0;
	private int housePrice = 0;
	private int hotelPrice = 0;
	private int mortgagePrice = 0;
	private int rent = 0;
	private int propNum = -1;
	private int numHouses = 0;
	private int numHotels = 0;
	private boolean isOwned = false;
	private boolean isMonopoly = false;
	private int number;
	private int owned;
	private String name;
	private Player owner = null;
	
	private String[] props = {"Mediterranean", "Baltic", "Oriental", "Vermont", "Connecticut", "St. Charles", "States", "Virginia", "St. James", "Tennessee", "New York", "Kentucky", "Indiana", "Illinois", "Atlantic", "Vetnor", "Marvin Gardens", "Pacific", "North Carolina", "Pennsylvania", "Park Place", "Boardwalk"};               
	
	public Property(int number) {
		this.number = number;
	}		
	
	public void setOwner(Player p) {
		owner = p;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public int getType() {
		return 0;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int compareTo(Spaces s) {
		return this.number - s.getNumber();
	}
	
	public int getNumOwned() {
		return owned;
	}
	
	public void bought(Player p) {
		isOwned = true;
		//owner = p;
	}
	
	public boolean isMonopoly(ArrayList<Spaces> p) {		
		boolean[][] colors = new boolean[8][3];
		ArrayList<Property> props = new ArrayList<Property>();		
		for(Spaces s : p) {
			if(s.getType() == 0) {
				props.add((Property)s);
			}
		}
		int propertyNumber = this.getPropNum();
		if(propertyNumber == 0) {
			for(Property prop : props) {
				if(prop.getPropNum() == 1) {
					return true;
				}
			}
		}
		else if(propertyNumber == 1) {
			for(Property prop : props) {
				if(prop.getPropNum() == 0) {
					return true;
				}
			}
		}
		else if(propertyNumber == 2) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 3)
					first = true;
				else if(prop.getPropNum() == 4)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 3) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 2)
					first = true;
				else if(prop.getPropNum() == 4)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 4) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 2)
					first = true;
				else if(prop.getPropNum() == 3)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 5) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 6)
					first = true;
				else if(prop.getPropNum() == 7)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 6) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 5)
					first = true;
				else if(prop.getPropNum() == 7)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 7) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 5)
					first = true;
				else if(prop.getPropNum() == 6)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 8) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 9)
					first = true;
				else if(prop.getPropNum() == 10)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 9) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 8)
					first = true;
				else if(prop.getPropNum() == 10)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 10) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 8)
					first = true;
				else if(prop.getPropNum() == 9)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 11) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 12)
					first = true;
				else if(prop.getPropNum() == 13)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 12) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 13)
					first = true;
				else if(prop.getPropNum() == 11)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 13) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 12)
					first = true;
				else if(prop.getPropNum() == 11)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 14) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 15)
					first = true;
				else if(prop.getPropNum() == 16)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 15) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 14)
					first = true;
				else if(prop.getPropNum() == 16)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 16) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 14)
					first = true;
				else if(prop.getPropNum() == 15)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 17) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 18)
					first = true;
				else if(prop.getPropNum() == 19)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 18) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 19)
					first = true;
				else if(prop.getPropNum() == 17)
					second = true;
			}
			if(first && second)
				return true;
		}
		else if(propertyNumber == 19) {
			boolean second = false;
			boolean first = false;
			for(Property prop : props) {
				if(prop.getPropNum() == 18)
					first = true;
				else if(prop.getPropNum() == 17)
					second = true;
			}
			if(first && second)
				return true;
		}
		if(propertyNumber == 20) {
			for(Property prop : props) {
				if(prop.getPropNum() == 21) {
					return true;
				}
			}
		}
		else if(propertyNumber == 21) {
			for(Property prop : props) {
				if(prop.getPropNum() == 20) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int getPropNum() {
		return propNum;
	}
	
	public String getName() {
		return name;
	}
	
	public void addHouse() {
		numHouses ++;
		
	}
	
	public int getNumHouses() {
		return numHouses;
	}
	
	public int getNumHotels() {
		return numHotels;
	}
	
	public void addHotel() {
		numHotels++;
	}
	
	public int getRent() {
		return 0;
	}
	
	public int getRent(ArrayList<Spaces> p) {
		if(!isMonopoly(p)) {
			return rent;
		}
		if(p.size() > 0) {
			if(isMonopoly(p))
				return rent * 2;
		}
		Property[] allProps = getAllProperties();
		for(int i = 0; i < allProps.length; i++) {
			if(i < 2) {
				if(numHouses == 1)
					rent = 10 + 10*i;
				else if(numHouses == 2)
					rent = 30 + 30 * i;
				else if(numHouses == 3) {
					rent = 90 + 90*i;
				}
				else if(numHouses == 4) {
					rent = 160+160*i;
				}
				else if(numHotels == 1) {
					rent = 250 + 200*i;
				}
			}
			else if(i < 5) {
				if(i < 4) {
					if(numHouses == 1) 
						rent = 30;
					else if(numHouses == 2)
						rent = 90;
					else if(numHouses == 3) 
						rent = 270;
					else if(numHouses == 4) 
						rent = 400;
					else if(numHotels == 1) 
						rent = 550;					
				}
				else {
					if(numHouses == 1) 
						rent = 40;
					else if(numHouses == 2)
						rent = 100;
					else if(numHouses == 3) 
						rent = 300;
					else if(numHouses == 4) 
						rent = 450;
					else if(numHotels == 1) 
						rent = 600;
				}
				
			}
			else if(i < 8) { 
				if(i < 7) {
					if(numHouses == 1) 
						rent = 50;
					else if(numHouses == 2)
						rent = 150;
					else if(numHouses == 3) 
						rent = 450;
					else if(numHouses == 4) 
						rent = 625;
					else if(numHotels == 1) 
						rent = 750;					
				}
				else {
					if(numHouses == 1) 
						rent = 60;
					else if(numHouses == 2)
						rent = 180;
					else if(numHouses == 3) 
						rent = 500;
					else if(numHouses == 4) 
						rent = 700;
					else if(numHotels == 1) 
						rent = 900;
				}			
			}
			else if(i < 11) {
				if(i < 10) {
					if(numHouses == 1) 
						rent = 70;
					else if(numHouses == 2)
						rent = 200;
					else if(numHouses == 3) 
						rent = 550;
					else if(numHouses == 4) 
						rent = 750;
					else if(numHotels == 1) 
						rent = 950;					
				}
				else {
					if(numHouses == 1) 
						rent = 80;
					else if(numHouses == 2)
						rent = 220;
					else if(numHouses == 3) 
						rent = 600;
					else if(numHouses == 4) 
						rent = 800;
					else if(numHotels == 1) 
						rent = 1000;
				}	
			}
			else if(i < 14) {
				if(i < 13) {
					if(numHouses == 1) 
						rent = 90;
					else if(numHouses == 2)
						rent = 250;
					else if(numHouses == 3) 
						rent = 700;
					else if(numHouses == 4) 
						rent = 875;
					else if(numHotels == 1) 
						rent = 1050;					
				}
				else {
					if(numHouses == 1) 
						rent = 100;
					else if(numHouses == 2)
						rent = 300;
					else if(numHouses == 3) 
						rent = 750;
					else if(numHouses == 4) 
						rent = 925;
					else if(numHotels == 1) 
						rent = 1100;
				}			
			}
			else if (i < 17) {
				if(i < 16) {
					if(numHouses == 1)
						rent = 110;
					else if(numHouses == 2)
						rent = 330;
					else if(numHouses == 3) 
						rent = 800;
					else if(numHouses == 4) 
						rent = 975;
					else if(numHotels == 1) 
						rent = 1150;					
				}
				else {
					if(numHouses == 1) 
						rent = 120;
					else if(numHouses == 2)
						rent = 360;
					else if(numHouses == 3) 
						rent = 850;
					else if(numHouses == 4) 
						rent = 1025;
					else if(numHotels == 1) 
						rent = 1200;
				}			
			}
			else if (i < 20) {
				if(i < 19) {
					if(numHouses == 1) 
						rent = 130;
					else if(numHouses == 2)
						rent = 390;
					else if(numHouses == 3) 
						rent = 900;
					else if(numHouses == 4) 
						rent = 1100;
					else if(numHotels == 1) 
						rent = 1275;					
				}
				else {
					if(numHouses == 1) 
						rent = 150;
					else if(numHouses == 2)
						rent = 450;
					else if(numHouses == 3) 
						rent = 1000;
					else if(numHouses == 4) 
						rent = 1200;
					else if(numHotels == 1) 
						rent = 1400;
				}
			}
			else {
				if(i < 21) {
					if(numHouses == 1) 
						rent = 175;
					else if(numHouses == 2)
						rent = 500;
					else if(numHouses == 3) 
						rent = 1100;
					else if(numHouses == 4) 
						rent = 1300;
					else if(numHotels == 1) 
						rent = 1500;					
				}
				else {
					if(numHouses == 1) 
						rent = 200;
					else if(numHouses == 2)
						rent = 600;
					else if(numHouses == 3) 
						rent = 1400;
					else if(numHouses == 4) 
						rent = 1700;
					else if(numHotels == 1) 
						rent = 2000;
				}
			}
		}
		return rent;
	}
	
	public Property[] getAllProperties() {
		Property[] allProps = new Property[props.length];
		for(int i = 0; i < props.length; i++) {
			Property prop = new Property(-1);			
			if(i < 2) {
				prop = new Property(i + i + 1);
				prop.name = props[i];
				prop.propNum = i;
				prop.price = 60;
				prop.housePrice = 50;
				prop.hotelPrice = 50;
				prop.mortgagePrice = 30;
				prop.rent = (i+1) * 2;				
				 
			}
			else if(i < 5) {				
				if(i == 4) { 
					prop = new Property(i + 5);
					prop.name = props[i];
					prop.propNum = i;
					prop.price = 120;
					prop.rent = 8;
					prop.mortgagePrice = 60;
					prop.housePrice = 50;
					prop.hotelPrice = 50;	
				}
				else {
					prop = new Property(2*(i-2)+6);
					prop.name = props[i];
					prop.propNum = i;
					prop.rent = 6;
					prop.price = 100;
					prop.mortgagePrice = 50;
					prop.housePrice = 50;
					prop.hotelPrice = 50;	
				}				
			}
			else if(i < 8) { 				
				if(i == 7) {
					prop = new Property(14);
					prop.name = props[i];
					prop.propNum = i;
					prop.price = 160;
					prop.rent = 12;
					prop.mortgagePrice = 80;
					prop.housePrice = 100;
					prop.hotelPrice = 100;
				}
				else {
					prop = new Property(2*(i-5)+11);
					prop.name = props[i];
					prop.propNum = i;
					prop.rent = 10;
					prop.price = 140;
					prop.mortgagePrice = 70;
					prop.housePrice = 100;
					prop.hotelPrice = 100;
				}
							
			}
			else if(i < 11) 				
				if(i == 10) {
					prop = new Property(19);
					prop.name = props[i];
					prop.propNum = i;
					prop.price = 200;
					prop.rent = 16;
					prop.mortgagePrice = 100;
					prop.housePrice = 100;
					prop.hotelPrice = 100;	
				}		
				else {
					prop = new Property(2*(i - 8) + 16);
					prop.name = props[i];
					prop.propNum = i;
					prop.rent = 14;
					prop.price = 180;
					prop.mortgagePrice = 90;
					prop.housePrice = 100;
					prop.hotelPrice = 100;	
				}							
			
			else if(i < 14) {
				
				if(i == 13) {
					prop = new Property(24);
					prop.name = props[i];
					prop.propNum = i;
					prop.price = 240;
					prop.rent = 20;
					prop.mortgagePrice = 120;
					prop.housePrice = 150;
					prop.hotelPrice = 150;	
				}
				else {
					prop = new Property(2*(i - 11) + 21);
					prop.name = props[i];
					prop.propNum = i;
					prop.rent = 18;
					prop.price = 220;
					prop.mortgagePrice = 110;
					prop.housePrice = 150;
					prop.hotelPrice = 150;	
				}
							
			}
			else if (i < 17) {				
				if(i == 16) { 
					prop = new Property(29);
					prop.name = props[i];
					prop.propNum = i;
					prop.price = 280;
					prop.rent = 24;
					prop.mortgagePrice = 140;
					prop.housePrice = 150;
					prop.hotelPrice = 150;	
				}			
				else {
					prop = new Property((i - 14) + 26);
					prop.name = props[i];
					prop.propNum = i;
					prop.rent = 22;
					prop.price = 260;
					prop.mortgagePrice = 130;
					prop.housePrice = 150;
					prop.hotelPrice = 150;	
				}							
			}
			else if (i < 20) {
				
				if(i == 19) { 
					prop = new Property(34);
					prop.name = props[i];
					prop.propNum = i;
					prop.price = 320;
					prop.rent = 28;
					prop.mortgagePrice = 160;
					prop.housePrice = 200;
					prop.hotelPrice = 200;	
				}		
				else {
					prop = new Property((i - 17) + 31);
					prop.name = props[i];
					prop.propNum = i;
					prop.rent = 26;
					prop.price = 300;
					prop.mortgagePrice = 150;
					prop.housePrice = 200;
					prop.hotelPrice = 200;	
				}
				
			}
			else {
				prop = new Property(37);
				prop.name = props[i];
				prop.propNum = i;
				prop.rent = 35;
				prop.price = 350;
				prop.mortgagePrice = 175;
				if(i == 21) { 
					prop = new Property(39);
					prop.name = props[i];
					prop.propNum = i;
					prop.price = 400;
					prop.rent = 50;
					prop.mortgagePrice = 200;
				}				
				prop.housePrice = 200;
				prop.hotelPrice = 200;	
			}
			allProps[i] = prop;
		}
		return allProps;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getHousePrice() {
		return housePrice;
	}
	
	public int getHotelPrice() {
		return hotelPrice;
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

	@Override
	public boolean isOwned() {
		// TODO Auto-generated method stub
		return isOwned;
	}
	
}
