import java.util.ArrayList;

public class Player {
	private int playerNumber;
	private int numPlayers = 0;
	private int balance;
	private ArrayList<Property> propertiesOwned;
	private ArrayList<Spaces> spacesOwned = new ArrayList<Spaces>();
	private int location = 0;
	private int numTurns = 0;
	private boolean[] monopolies = new boolean[22];
	private int roll = 0;
	private int numHouses = 0;
	private int numHotels = 0;
	
	public Player(int pn) {		
		playerNumber = pn;
		propertiesOwned = new ArrayList<Property>();
		balance = 1500;
	}	
	
	public void removeSpace(Spaces s) {
		spacesOwned.remove(s);
	}
	
	public boolean hasMonopoly() {
		for(Spaces s : spacesOwned) {
			if(s.getType() == 0) {
				if(((Property)(s)).isMonopoly(spacesOwned))
					return true;
			}
		}
		return false;
	}
	
	public void buyHouse(Property p) {
		numHouses++;
		balance -= p.getHousePrice();
	}
	
	public int getNumHouses() {
		return numHouses;
	}
	
	public int getNumHotels() {
		return numHotels;
	}
	
	public void buyHotel(Property p) {
		numHotels++;
		balance -= p.getHotelPrice();
	}
	
	public void addMoney(int m){
		balance += m;
	}
	
	public void addSpace(Spaces s) {
		spacesOwned.add(s);
		s.setOwner(this);
	}
	
	public void roll(int r) {
		roll = r;
	}
	
	public void newTurn() {
		numTurns++;
	}
	
	public int getNumTurns() {
		return numTurns;
	}
	
	public void setLocation(int n) {
		location = n;
	}
	
	public int getLocation() {
		return location;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public ArrayList<Spaces> getSpacesOwned(){
		return spacesOwned;
	}	
	
	public int getPlayerNumber() {
		return playerNumber;		
	}
	
	public int getNumOfPlayers() {
		return numPlayers;
	}
	
	public void buySpace(Spaces p) {		
		balance -= p.getPrice();
		spacesOwned.add(p);
		p.setOwner(this);
		
	}
	
	public void payRent(Spaces p, Player player) {
		if(p.getPropNum() == -2) {
			Utility u = (Utility)p;
			balance -= u.getRent(roll, player.spacesOwned);
		}
		else if(p.getPropNum() == -1) 
			balance -= p.getRent(player.spacesOwned);
		else 
			balance -= p.getRent(player.spacesOwned);
	}
	
	public void getPayed(Spaces p) {
		if(p.getPropNum() == -2) {
			Utility u = (Utility)p;
			balance += u.getRent(roll, spacesOwned);
		}
		else if(p.getPropNum() == -1) 
			balance += p.getRent(spacesOwned);
		else 
			balance += p.getRent(spacesOwned);
	}
	
	
}
