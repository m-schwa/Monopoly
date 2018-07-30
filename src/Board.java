import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;

public class Board{
	private static JFrame frame;
	//private static Board board;
	private static JPanel panel;
	private static int numPlayers;
	private static Player[] players;
	private static JLabel[] stats;
	private static HashMap<JButton, Spaces> hashmap = new HashMap<JButton, Spaces>();
	private static int rrOwned = 0;
	private static JLabel[] pieces;
	private static JPanel board;
	private static JLabel boardPic;
	private static JButton[] properties;
	private static JPanel[] panels;
	private static JButton buy;
	private static JButton trade;
	private static JButton mortgage;
	private static JButton buyHouse;
	private static JButton buyHotel;
	private static JButton pm;
	private static boolean turnOver = false;
	private static JButton endTurn;
	private static JPanel statsPanel;
	private static JPanel menu;
	private static JLabel propPic = null;	
	private static JPanel playerMenu;
	private static int indicator;
	private static int tradeIndicator;
	private static boolean click = false;
	private static Spaces tradeFirstProp = null;
	private static Spaces tradeSecondProp = null;
	private static JPanel tradeMenu = new JPanel();
	private static ActionListener tradeFirst;
	private static ActionListener tradeSecond;
	private static ArrayList<Chance> chanceCards = new ArrayList<Chance>();
	private static Chance chanceCard = new Chance(-1, new Player(-1));
	private static ArrayList<ComChest> comChests = new ArrayList<ComChest>();
	private static ComChest comChest = new ComChest(-1, new Player(-1));
	public static void main(String[] args) {
		startGame();				
	}	
	
	public static void startGame() {
		chanceCards = chanceCard.getAllChanceCards();
		comChests = comChest.getAllcomChestCards();
		frame = new JFrame();
		frame.setLayout(null);
		frame.setBounds(0,0,1920,956);
		frame.getContentPane().setBackground(new Color(136, 204, 241));
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(136, 204, 241));
		frame.add(panel);
		panel.setBounds(1920/2 - 450, 0, 900, 900);
		JButton start = new JButton("START");		
		panel.add(start);
		start.setBounds(400, 400, 100, 50);
		frame.setVisible(true);
		start.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				panel.remove(start);				
				panel.repaint();				
				howManyPlayers();				
			}
		});	
	}
	
	public static void howManyPlayers() {
		JLabel label = new JLabel("How many players?", JLabel.CENTER);		
		label.setForeground(Color.white);
		label.setFont(new Font("Courier", Font.BOLD, 60));
		panel.add(label);
		label.setBounds((int)panel.CENTER_ALIGNMENT, 50, 800, 150);
		 
		JButton twoPlayers = new JButton("2");
		twoPlayers.setFont(new Font("Courier", Font.BOLD, 60));
		twoPlayers.setOpaque(true);
		twoPlayers.setBackground(Color.white);
		panel.add(twoPlayers);
		twoPlayers.setBounds(35, 200, 80, 80);		
		
		JButton threePlayers = new JButton("3");
		threePlayers.setFont(new Font("Courier", Font.BOLD, 60));
		threePlayers.setOpaque(true);
		threePlayers.setBackground(Color.white);
		panel.add(threePlayers);
		threePlayers.setBounds(195, 200, 80, 80);
		
		JButton fourPlayers = new JButton("4");
		fourPlayers.setFont(new Font("Courier", Font.BOLD, 60));
		fourPlayers.setOpaque(true);
		fourPlayers.setBackground(Color.white);
		panel.add(fourPlayers);
		fourPlayers.setBounds(355, 200, 80, 80);
		
		JButton fivePlayers = new JButton("5");
		fivePlayers.setFont(new Font("Courier", Font.BOLD, 60));
		fivePlayers.setOpaque(true);
		fivePlayers.setBackground(Color.white);
		panel.add(fivePlayers);
		fivePlayers.setBounds(515, 200, 80, 80);
		
		JButton sixPlayers = new JButton("6");
		sixPlayers.setFont(new Font("Courier", Font.BOLD, 60));
		sixPlayers.setOpaque(true);
		sixPlayers.setBackground(Color.white);
		panel.add(sixPlayers);
		sixPlayers.setBounds(675, 200, 80, 80);
		
		ActionListener al = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == twoPlayers) { 
					numPlayers = 2;
					removePlayerButtons();
					makePlayers();
				}
				else if(e.getSource() == threePlayers) {
					numPlayers = 3;
					removePlayerButtons();
					makePlayers();
				}
				else if(e.getSource() == fourPlayers) {
					numPlayers = 4;
					removePlayerButtons();
					makePlayers();
				}
				else if(e.getSource() == fivePlayers) {
					numPlayers = 5;
					removePlayerButtons();
					makePlayers();
				}
				else if(e.getSource() == sixPlayers) {
					numPlayers = 6;		
					removePlayerButtons();
					makePlayers();
				}
			}
			
			public void removePlayerButtons() {
				panel.remove(twoPlayers);
				panel.remove(threePlayers);
				panel.remove(fourPlayers);
				panel.remove(fivePlayers);
				panel.remove(sixPlayers);
				panel.remove(label);
				panel.repaint();
				// out.print(numPlayers);
			}
			
		};
		twoPlayers.addActionListener(al);
		threePlayers.addActionListener(al);
		fourPlayers.addActionListener(al);
		fivePlayers.addActionListener(al);
		sixPlayers.addActionListener(al);	
	}
	
	public static void makePlayers() {
		players = new Player[numPlayers];
		for(int i = 0; i < numPlayers; i++) {
			players[i] = new Player(i);
		}
		Board board = new Board();
		//Pieces();
		playerTurn(players[0]);
	}
	
	public static void Pieces(JPanel go) {
		// out.print(numPlayers);
		pieces = new JLabel[numPlayers];
		Color[] colors = new Color[6];
		colors[0] = new Color(241, 143, 1);
		colors[1] = new Color(4, 139, 168);
		colors[2] = new Color(46, 64, 87);
		colors[3] = new Color(137, 128, 245);
		colors[4] = new Color(153, 194, 77);
		colors[5] = new Color(209, 17, 73);
		for(int i = 0; i < numPlayers; i++) {
			pieces[i] = new JLabel(""+ (i+1));
			pieces[i].setForeground(Color.white);
			pieces[i].setBackground(colors[i]);
			pieces[i].setFont(new Font("Courier", Font.BOLD, 40));
			pieces[i].setOpaque(true);
			go.add(pieces[i]);
			if(i < 3) 		
				pieces[i].setBounds(10 + i*32, 10, 30, 30);
			else
				pieces[i].setBounds(10 + (i-3)*32, 40, 30, 30);
		}
	}	
	
	
	public static void playerTurn(Player player) {
		player.newTurn();
		turnOver = false;
		menu(player);
		
		statsPanel = new JPanel();
		statsPanel.setLayout(null);
		frame.add(statsPanel);
		statsPanel.setBounds(1920/2 + 451, 0, 485, 900);
		statsPanel.setOpaque(false);
		
		JLabel playerNumber = new JLabel("Player" + (player.getPlayerNumber()+1));
		playerNumber.setBounds(120, 50, 300, 100);
		statsPanel.add(playerNumber);
		playerNumber.setForeground(Color.white);
		playerNumber.setFont(new Font("Courier", Font.BOLD, 60));
		
		JLabel balance = new JLabel("Balance: $"+ player.getBalance());
		balance.setBounds(55, 150, 500, 100);
		statsPanel.add(balance);
		balance.setForeground(Color.white);
		balance.setFont(new Font("Courier", Font.BOLD, 45));
		
		JLabel rollLabel = new JLabel("Roll: _");
		rollLabel.setFont(new Font("Courier", Font.BOLD, 60));
		statsPanel.add(rollLabel);
		rollLabel.setBounds(110, 250, 300, 100);
		rollLabel.setForeground(Color.white);
		
		JButton roll = new JButton("ROLL");
		roll.setForeground(Color.white);
		roll.setBackground(Color.blue);
		menu.add(roll);
		roll.setBounds(0, 0, 155, 50);
		roll.setFont(new Font("Courier", Font.BOLD, 50));
		//roll.setBorder(null);
		
		JPanel spacesOwned = new JPanel();
		spacesOwned.setBounds(0, 350, 485, 650);
		spacesOwned.setOpaque(false);
		spacesOwned.setLayout(null);
		statsPanel.add(spacesOwned);
		
		ArrayList<Spaces> playerSpacesOwned = player.getSpacesOwned();
		for(int i = playerSpacesOwned.size()-1; i >= 0; i--) {
			JLabel spacePic = playerSpacesOwned.get(i).getImageLabel();
			spacePic.setBounds(130, i*40, 220, 300);
			spacesOwned.add(spacePic);									
		}
		tradeIndicator = 0;
		trade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {				
				tradeIndicator++;
				if(tradeIndicator % 2 == 0) {
					tradeMenu.removeAll();
					boardPic.remove(tradeMenu);
					boardPic.repaint();
				}	
				else {
				tradeMenu.setLayout(null);
				tradeMenu.setBounds(120, 120, 660, 660);
				tradeMenu.setBackground(new Color(143, 227, 136));
				tradeMenu.setOpaque(true);
				boardPic.add(tradeMenu);
				JLabel instructions = new JLabel("<html>Click the property you <br/>would like to trade.</html>", SwingConstants.CENTER);
				JLabel secondInst = new JLabel("<html>Now click the property you <br/>would like to trade for.</html>", SwingConstants.CENTER);
				instructions.setBounds(30, 20, 600, 100);
				instructions.setFont(new Font("Courier", Font.BOLD, 40));
				instructions.setOpaque(false);
				instructions.setForeground(Color.white);
				secondInst.setBounds(5, 20, 650, 100);
				secondInst.setFont(new Font("Courier", Font.BOLD, 40));
				secondInst.setOpaque(false);
				secondInst.setForeground(Color.white);
				tradeMenu.add(instructions);
				JLabel label = new JLabel();
				label.setBounds(110, 510, 600, 100);
				
				ActionListener yes = new ActionListener() {
					public void actionPerformed(ActionEvent y) {
						Player first = tradeFirstProp.getOwner();
						Player second = tradeSecondProp.getOwner();	
						System.out.println(tradeSecondProp.getOwner().getPlayerNumber());
						System.out.println(tradeFirstProp.getOwner().getPlayerNumber());
						first.removeSpace(tradeFirstProp);
						second.removeSpace(tradeSecondProp);
						first.addSpace(tradeSecondProp);
						Spaces s = tradeFirstProp;
						second.addSpace(s);						
						System.out.println(tradeSecondProp.getOwner().getPlayerNumber());
						System.out.println(s.getOwner().getPlayerNumber());
						tradeMenu.removeAll();
						boardPic.remove(tradeMenu);
						boardPic.repaint();
					}
				
				};				
				
				
				tradeSecond = new ActionListener() {
					public void actionPerformed(ActionEvent ts) {
						click = false;
						JButton clicked = (JButton) ts.getSource();						
						JLabel clickedPic = hashmap.get(clicked).getImageLabel();
						clickedPic.setBounds(370, 200, 220, 300);
						tradeMenu.add(clickedPic);											
						tradeSecondProp = hashmap.get(clicked);							
						label.setText("Player" + 1 + tradeSecondProp.getOwner().getPlayerNumber() + ", you good?");
						label.setFont(new Font("Courier", Font.BOLD, 40));
						label.setOpaque(false);
						label.setForeground(Color.white);
						tradeMenu.add(label);
						JButton ye = new JButton("Ye");
						JButton nah = new JButton("Nah");
						ye.setFont(new Font("Courier", Font.BOLD, 40));
						ye.setBounds(160, 610, 100, 40);
						ye.setBackground(Color.white);
						ye.setForeground(new Color(143, 227, 136));
						nah.setFont(new Font("Courier", Font.BOLD, 40));
						nah.setBounds(350, 610, 110, 40);
						nah.setBackground(Color.white);
						nah.setForeground(new Color(143, 227, 136));
						tradeMenu.add(nah);
						tradeMenu.add(ye);						
						tradeMenu.repaint();
						ye.addActionListener(yes);
						nah.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent n) {
								tradeMenu.removeAll();
								boardPic.remove(tradeMenu);
								for(int i = 0; i < properties.length; i++) {
									for(int x = 0; x < properties[i].getActionListeners().length; x++) {
										properties[i].removeActionListener(tradeSecond);
									}
								}
								boardPic.repaint();
							}
						});						
					}
				};
				tradeFirst = new ActionListener() {
					public void actionPerformed(ActionEvent tf) {
						click = true;
						JButton clicked = (JButton) tf.getSource();
						JLabel clickedPic = hashmap.get(clicked).getImageLabel();
						clickedPic.setBounds(70, 200, 220, 300);
						tradeMenu.add(clickedPic);
						tradeMenu.remove(instructions);
						tradeMenu.add(secondInst);						
						tradeMenu.repaint();
						tradeFirstProp = hashmap.get(clicked);												
						for(int i = 0; i < properties.length; i++) {
							if(hashmap.get(properties[i]) != null && hashmap.get(properties[i]).isOwned()) {
								properties[i].removeActionListener(tradeFirst);
								properties[i].addActionListener(tradeSecond);	
							}						
						}
					}
				};
				
				for(int i = 0; i < properties.length; i++) {
					if(hashmap.get(properties[i]) != null) {
						properties[i].addActionListener(tradeFirst);
					}						
				}
				
				boardPic.repaint();
			}
			}
		});		
		
		indicator = 0;
		pm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				indicator++;
				if(indicator % 2 == 0) {
					playerMenu.removeAll();
					boardPic.remove(playerMenu);					
					for(int i = 0; i < pieces.length; i++) {
						pieces[i].setOpaque(true);
						pieces[i].setText(""+i+1);
						pieces[i].setFont(new Font("Courier", Font.BOLD, 40));
					}
					boardPic.repaint();
				}
				else {
				boardPic.remove(tradeMenu);
				for(int i = 0; i < pieces.length; i++) {
					pieces[i].setOpaque(false);
					pieces[i].setText("");
				}
				boardPic.repaint();
				
				playerMenu = new JPanel();
				playerMenu.setBounds(boardPic.getBounds());
				boardPic.add(playerMenu);
				playerMenu.setLayout(null);
				playerMenu.setOpaque(true);
				playerMenu.setBackground(new Color(143, 227, 136));
				for(int i = 0; i < numPlayers; i++) {
					ArrayList<Spaces> playerProps = players[i].getSpacesOwned();					
					JLabel playerName = new JLabel("Player" + (i+1));
					playerName.setFont(new Font("Courier", Font.BOLD, 40));
					playerName.setForeground(Color.white);
					playerName.setBounds(50, 10 + i*(playerMenu.getHeight()/6), 200, 60);
					playerName.setOpaque(true);
					playerName.setBackground(new Color(143, 227, 136));
					playerMenu.add(playerName);					
					for(int j = playerProps.size() - 1; j >= 0; j--) {
						JLabel propLabel = playerProps.get(j).getMenuLabel();
						propLabel.setLayout(null);
						propLabel.setBounds(290 +  32*(j+1), 10 + i*(playerMenu.getHeight()/6), propLabel.getWidth(), propLabel.getHeight());
						playerMenu.add(propLabel);				
					}
					// out.println();
				}
				}
				
				frame.repaint();
			}
		});		
		
		if(player.hasMonopoly()) {
			System.out.println(true);
			buyHouse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent hs) {
					System.out.println("click1");
					ArrayList<Spaces> spacesOwned = player.getSpacesOwned();					
					for(Spaces s : spacesOwned) {
						if(((Property)(s)).isMonopoly(spacesOwned)) {
							properties[s.getNumber()].addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent bhs) {									
									JButton houseButton = (JButton)bhs.getSource();
									Property houseProp = (Property)hashmap.get(houseButton);
									JPanel housePanel = panels[s.getNumber()];
									JLabel houseLabel = new JLabel();
									houseLabel.setBounds(houseProp.getNumHouses() * (housePanel.getWidth()/4), 0, housePanel.getWidth()/4, housePanel.getHeight()/5);
									houseProp.addHouse();
									houseLabel.setBackground(Color.red);
									housePanel.add(houseLabel);
									frame.repaint();
								}
							});
						}
					}
				}
					
			});
		}
		
		roll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pm.removeActionListener(pm.getActionListeners()[0]);
				trade.removeActionListener(trade.getActionListeners()[0]);
				int rollNum = (int)(Math.random()*6 + Math.random()*6 + 1);	
				int previosLoc = player.getLocation();
				player.roll(rollNum);
				// out.println(rollNum);
				boardPic.remove(pieces[player.getPlayerNumber()]);				
				if(player.getLocation() + rollNum > 39) 
					 player.setLocation(player.getLocation() + rollNum - 40);
				else
					player.setLocation(player.getLocation() + rollNum);	
				pieces[player.getPlayerNumber()].setBounds(50, 20, 30, 30);
				if(player.getLocation() < 10 || (player.getLocation() < 30 && player.getLocation() > 20)) {
					pieces[player.getPlayerNumber()].setBounds(8, 58, 30, 30);
				}				
				panels[player.getLocation()].add(pieces[player.getPlayerNumber()]);
				if(player.getLocation() - previosLoc < 0) {
					player.addMoney(200);
					balance.setText("Balance: $"+ player.getBalance());
					frame.repaint();
					
				}					
				// out.println(player.getLocation());
				Spaces s = hashmap.get(properties[player.getLocation()]);	
				if(player.getLocation() == 7 || player.getLocation() == 36 || player.getLocation() == 22) {
					for(Chance c : chanceCards) {
						c.setPlayer(player);
					}
					panels[player.getLocation()].remove(pieces[player.getPlayerNumber()]);
					chanceCards.get(0).task(players);
					propPic = chanceCards.get(0).getImageLabel();
					boardPic.add(propPic);
					propPic.setBounds(335, 380, 240, 138);
					balance.setText("Balance: $"+ player.getBalance());
					panels[player.getLocation()].add(pieces[player.getPlayerNumber()]);
					frame.repaint();
					Chance c = chanceCards.get(0);
					chanceCards.remove(0);
					chanceCards.add(c);					
				}
				else if(player.getLocation() == 2 || player.getLocation() == 17 || player.getLocation() == 33) {
					for(ComChest c : comChests) {
						c.setPlayer(player);
					}
					panels[player.getLocation()].remove(pieces[player.getPlayerNumber()]);
					comChests.get(0).task(players);
					propPic = comChests.get(0).getImageLabel();
					boardPic.add(propPic);
					propPic.setBounds(335, 380, 240, 138);
					balance.setText("Balance: $"+ player.getBalance());
					panels[player.getLocation()].add(pieces[player.getPlayerNumber()]);
					frame.repaint();
					ComChest c = comChests.get(0);
					comChests.remove(0);
					comChests.add(c);			
				}
				else if(player.getLocation() == 30) {
					panels[player.getLocation()].remove(pieces[player.getPlayerNumber()]);
					player.setLocation(10);
					panels[player.getLocation()].add(pieces[player.getPlayerNumber()]);
					frame.repaint();
				}
				menu.remove(roll);
				if(s != null) {
					propPic = s.getImageLabel();
					boardPic.add(propPic);
					propPic.setBounds(335, 300, 220, 300);
					buy.setText("Buy: $" + s.getPrice());
					if(!s.isOwned()) {
						buy.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								player.buySpace(s);
								s.bought(player);
								balance.setText("Balance: $"+ player.getBalance());
								buy.removeActionListener(buy.getActionListeners()[0]);
								ArrayList<Spaces> playerSpacesOwned = player.getSpacesOwned();	
								spacesOwned.removeAll();
								for(int i = playerSpacesOwned.size()-1; i >= 0; i--) {
									JLabel spacePic = playerSpacesOwned.get(i).getImageLabel();
									spacePic.setBounds(130, i*40, 220, 300);
									spacesOwned.add(spacePic);									
								}
								boardPic.remove(propPic);
								frame.repaint();
							}
						});
					}
					else {
						player.payRent(s, s.getOwner());
						balance.setText("Balance: $"+ player.getBalance());
					}
				}
				rollLabel.setText("Roll:"+ " "+rollNum);
				
				endTurn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nextPlayer();
						//endTurn.removeActionListener(endTurn.getActionListeners()[0]);
					}
				});
				if(player.getLocation() == 4) {
					player.addMoney(-200);
					balance.setText("Balance: $"+ player.getBalance());
				}
				else if(player.getLocation() == 38) {
					player.addMoney(-100);
					balance.setText("Balance: $"+player.getBalance());
				}					
				frame.repaint();
				
			}			
		});
		
		frame.setVisible(true);
	}
	
	public static void nextPlayer() {
		endTurn.removeAll();
		int turns = players[0].getNumTurns();
		int playerIndex = -1;
		for(int i = 0; i < players.length; i++) {
			if(players[i].getNumTurns() != turns){
				playerIndex = i;
				break;
			}
		}
		if(playerIndex == -1) {
			playerIndex = 0;
		}
		statsPanel.removeAll();	
		menu.removeAll();
		if(propPic != null) 			
			boardPic.remove(propPic);
		// out.println(players[playerIndex].getPlayerNumber());
		frame.repaint();				
		playerTurn(players[playerIndex]);	
	}
	
	public static void menu(Player player) {
			menu = new JPanel();
			menu.setBounds(0, 0, 485, 900);
			menu.setLayout(null);
			menu.setOpaque(false);
			frame.add(menu);
			
			buy = new JButton("BUY");
			buy.setFont(new Font("Courier", Font.BOLD, 50));			
			buy.setForeground(Color.white);
			buy.setBounds(60, 200, 350, 60);
			buy.setBackground(new Color(143, 227, 136));			
			menu.add(buy);		
			
			pm = new JButton("Players");
			pm.setFont(new Font("Courier", Font.BOLD, 50));
			pm.setForeground(Color.white);
			pm.setBounds(60, 260, 350, 60);
			pm.setBackground(new Color(143, 227, 136));			
			menu.add(pm);	
			
			trade = new JButton("Trade");
			trade.setFont(new Font("Courier", Font.BOLD, 50));			
			trade.setForeground(Color.white);
			trade.setBounds(60, 320, 350, 60);
			trade.setBackground(new Color(143, 227, 136));			
			menu.add(trade);		
			
			buyHouse = new JButton("Buy House");
			buyHouse.setFont(new Font("Courier", Font.BOLD, 50));
			buyHouse.setForeground(Color.white);
			buyHouse.setBounds(60, 380,  350, 60);
			buyHouse.setBackground(new Color(143, 227, 136));
			menu.add(buyHouse);
			
			buyHotel = new JButton("Buy Hotel");
			buyHotel.setFont(new Font("Courier", Font.BOLD, 50));
			buyHotel.setForeground(Color.white);
			buyHotel.setBounds(60, 440,  350, 60);
			buyHotel.setBackground(new Color(143, 227, 136));
			menu.add(buyHotel);
			
			endTurn = new JButton("End Turn");
			endTurn.setFont(new Font("Courier", Font.BOLD, 50));
			endTurn.setForeground(Color.white);
			endTurn.setBounds(60, 500,  350, 60);
			endTurn.setBackground(new Color(143, 227, 136));
			menu.add(endTurn);
			menu.repaint();
	}
	
	public Board() {
		panels = new JPanel[40];
		for(int i = 0; i < 40; i++) {
			panels[i] = new JPanel();
		}
		
		frame.remove(panel);
		board = new JPanel();
		board.setOpaque(true);
		frame.add(board);
		board.setLayout(null);
		board.setBounds(1920/2 - 450, 0, 900, 900);
		board.setVisible(true);
		
		ImageIcon image = new ImageIcon("monopoly board.jpg");
		boardPic = new JLabel(image);
		boardPic.setBounds(0,0,900, 900);
		board.add(boardPic);		
		boardPic.setOpaque(true);
		boardPic.setVisible(true);
		
		//Adds properties to the board
		int x = 74;
		int y = 0;
		properties = new JButton[40];
		JButton go = new JButton();
		boardPic.add(go);
		go.setBounds(74*9+115, 780, 120, 120);
		go.setContentAreaFilled(false);	
		JPanel panel = new JPanel();	
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(0, 0, 120, 120);		
		go.add(panel);
		Pieces(panel);
		go.setBorder(null);
		panels[0] = panel;
		properties[0] = go;
		for(int i = 0; i < 9; i++) {
			JButton button = new JButton();
			boardPic.add(button);
			button.setBounds(x*(9-i)+42, 780, 77, 120);
			button.setContentAreaFilled(false);
			properties[i+1] = button;
			panel = new JPanel();	
			panel.setLayout(null);
			panel.setOpaque(false);
			panel.setBounds(0, 0, button.getWidth(), button.getHeight());
			properties[i + 1].add(panel);
			panels[i+1] = panel;
			button.setBorderPainted(false);			
			button.setVisible(true);
		}
		JButton jail = new JButton();
		boardPic.add(jail);
		jail.setBounds(0, 780, 120, 120);
		jail.setContentAreaFilled(false);		
		properties[10] = jail;
		JPanel panel2 = new JPanel();	
		panel2.setLayout(null);
		panel2.setOpaque(false);
		jail.add(panel2);
		jail.setBorder(null);
		panels[10] = panel2;		
		y = 74;
		for(int i = 0; i < 9; i++) {
			JButton button = new JButton();
			boardPic.add(button);
			button.setBounds(0, y*(9-i)+42, 120, 77);
			button.setContentAreaFilled(false);
			properties[i+11] = button;
			panel = new JPanel();	
			panel.setLayout(null);
			panel.setOpaque(false);
			panel.setBounds(0, 0, button.getWidth(), button.getHeight());
			properties[i + 11].add(panel);
			panels[i+11] = panel;
			button.setBorderPainted(false);
			button.setVisible(true);
		}
		JButton freeParking = new JButton();
		boardPic.add(freeParking);
		freeParking.setBounds(0, 0, 120, 120);
		freeParking.setContentAreaFilled(false);		
		properties[20] = freeParking;
		JPanel panel3 = new JPanel();	
		panel3.setLayout(null);
		panel3.setOpaque(false);
		freeParking.add(panel3);
		freeParking.setBorder(null);
		panels[20] = panel3;
		for(int i = 0; i < 9; i++) {
			JButton button = new JButton();
			boardPic.add(button);
			button.setBounds(x*i + 115, 0, 77, 120);
			button.setContentAreaFilled(false);
			properties[i+21] = button;
			panel = new JPanel();	
			panel.setLayout(null);
			panel.setOpaque(false);
			panel.setBounds(0, 0, button.getWidth(), button.getHeight());
			properties[i + 21].add(panel);
			panels[i+21] = panel;
			button.setBorderPainted(false);
			button.setVisible(true);
		}
		JButton gtj = new JButton();
		boardPic.add(gtj);
		gtj.setBounds(x*9 + 115, 0, 120, 120);
		gtj.setContentAreaFilled(false);		
		properties[30] = gtj;
		JPanel panel4 = new JPanel();	
		panel4.setLayout(null);
		panel4.setOpaque(false);
		gtj.setBorder(null);
		gtj.add(panel4);
		for(int i = 0; i < 9; i++) {
			JButton button = new JButton();
			boardPic.add(button);
			button.setBounds(x * 9 + 115, y*(i) + 115, 120, 77);
			button.setContentAreaFilled(false);
			properties[i+31] = button;
			panel = new JPanel();	
			panel.setLayout(null);
			panel.setOpaque(false);
			panel.setBounds(0, 0, button.getWidth(), button.getHeight());
			properties[i+31].add(panel);
			panels[i+31] = panel;
			button.setBorderPainted(false);
			button.setVisible(true);
		}
		Property p = new Property(-1);
		Property[] allProps = p.getAllProperties();
		Railroad rr = new Railroad(-1);
		Railroad[] allRR = rr.getAllRR();
		Utility ut = new Utility(-1);
		Utility[] allU = ut.getAllUtilities();
		int k = 0;
		int r = 0;
		int u = 0;
		for(int i = 0; i < properties.length; i++) {			
			if(allProps[k].getNumber() == i) {				
				hashmap.put(properties[i], allProps[k]);
				k++;
			}			
			else if(allRR[r].getNumber() == i) {
				hashmap.put(properties[i], allRR[r]);
				if(r < 3) 
					r++;				
			}
			else if(allU[u].getNumber() == i) {
				hashmap.put(properties[i], allU[u]);
				if(u < 1) 
					u++;				
			}
			else {
				hashmap.put(properties[i], null);
			}
		}
				
		
		frame.setVisible(true);		
	}
}
