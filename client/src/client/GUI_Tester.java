package client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import common.IAnimal;

public class GUI_Tester extends JFrame {

	private JPanel Page;
	private JFrame frame;
	private JTextField handlerNameInput;
	private JTextField animalNameInput;
	private JTextField animalSpeciesInput;
	private JTextField animalRaceInput;
	private JTextField displayAddedClient;
	private JTextField animalSearchInput;
	private JTextField getAnimalState;
	private JTextField autoInsertedAnimals;
	private JTextField animalStateInput;
	private JTextField nInsertedAnimals;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Tester frame = new GUI_Tester();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public GUI_Tester() throws ParseException {
		
		setTitle("RMI TESTER GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 504);
		Page = new JPanel();
		Page.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Page);
		Page.setLayout(null);
		
		JTextArea terminalDisplay = new JTextArea();
		terminalDisplay.setFont(new Font("Dialog", Font.PLAIN, 11));
		terminalDisplay.setBounds(20, 314, 592, 129);
		Page.add(terminalDisplay);
		
		JButton insertAnimalsBtn = new JButton("Insérer des animaux (5) avec leurs propriétaires");
		insertAnimalsBtn.setFont(new Font("Dialog", Font.BOLD, 10));
		insertAnimalsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client = null;
				try {
					client = new Client();
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
				
				try {
					client.startClient();
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
				
				try {
					client.addAnimal("Cookie", "Arnaud", "Chien", "YorkShire", "Bonne Santé");
					client.addAnimal("Felix", "Adam", "Chien", "Golden Retriever");
					client.addAnimal("Alex", "Jeremie", "Peroquet", "Electus");
					client.addAnimal("Didou", "Marc", "Chat", "Maine Coon", "Bonne Santé");
					client.addAnimal("Lilo", "Stéphane", "Chien", "Bulldog Français", "Nécessite Surveillance");
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
								
				autoInsertedAnimals.setEditable(false);
				autoInsertedAnimals.setText("Création des clients terminée ...");
				
				try {
					terminalDisplay.setText(client.outputCabinet());
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		insertAnimalsBtn.setBounds(10, 21, 327, 30);
		Page.add(insertAnimalsBtn);
		
		JButton quitBtn = new JButton("Quitter");
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quitBtn.setForeground(new Color(255, 0, 0));
		quitBtn.setBounds(658, 427, 96, 30);
		Page.add(quitBtn);
		
		handlerNameInput = new JTextField();
		handlerNameInput.setToolTipText("Nom de l'animal");
		handlerNameInput.setBounds(10, 149, 96, 19);
		Page.add(handlerNameInput);
		handlerNameInput.setColumns(10);
		
		animalNameInput = new JTextField();
		animalNameInput.setToolTipText("Nom du maître");
		animalNameInput.setColumns(10);
		animalNameInput.setBounds(116, 149, 96, 19);
		Page.add(animalNameInput);
		
		animalSpeciesInput = new JTextField();
		animalSpeciesInput.setToolTipText("Espèce");
		animalSpeciesInput.setColumns(10);
		animalSpeciesInput.setBounds(222, 149, 96, 19);
		Page.add(animalSpeciesInput);
		
		animalRaceInput = new JTextField();
		animalRaceInput.setToolTipText("Race");
		animalRaceInput.setColumns(10);
		animalRaceInput.setBounds(328, 149, 96, 19);
		Page.add(animalRaceInput);
		
		JFormattedTextField numberClient = new JFormattedTextField(new MaskFormatter("###"));
		numberClient.setBounds(176, 72, 59, 19);
		Page.add(numberClient);
		numberClient.setEnabled(false);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 214, 224, 20);
		Page.add(separator);
		
		JButton addClientBtn = new JButton("Ajouter");
		addClientBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Client client = null;
				try {
					client = new Client();
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
				
				try {
					client.startClient();
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
				displayAddedClient.setEditable(false);
				
				if(animalStateInput.getText() == null) {
					try {
						client.addAnimal(animalNameInput.getText(), handlerNameInput.getText(), animalSpeciesInput.getText(), animalRaceInput.getText(), "Non renseigné");		
						displayAddedClient.setText(client.displayAnimal(animalNameInput.getText()).getString());
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						client.addAnimal(animalNameInput.getText(), handlerNameInput.getText(), animalSpeciesInput.getText(), animalRaceInput.getText(), animalStateInput.getText());		
						displayAddedClient.setText(client.displayAnimal(animalNameInput.getText()).getString());
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}	
			}
		});
		addClientBtn.setBounds(546, 143, 96, 30);
		Page.add(addClientBtn);
		
		JLabel newClientTitle = new JLabel("Ajouter un Client");
		newClientTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		newClientTitle.setBounds(10, 101, 158, 46);
		Page.add(newClientTitle);
		
		JLabel newClientIndications = new JLabel("(NomAnimal, NomMaître, EspeceAnimal, RaceAnimal, Etat)");
		newClientIndications.setFont(new Font("Tahoma", Font.PLAIN, 10));
		newClientIndications.setBounds(149, 103, 406, 46);
		Page.add(newClientIndications);
		
		displayAddedClient = new JTextField();
		displayAddedClient.setToolTipText("Nom du maître");
		displayAddedClient.setColumns(10);
		displayAddedClient.setBounds(10, 185, 272, 19);
		Page.add(displayAddedClient);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handlerNameInput.setText("");
				animalNameInput.setText("");
				animalSpeciesInput.setText("");
				animalRaceInput.setText("");
				displayAddedClient.setText("");
				animalStateInput.setText("");
			}
		});
		clearBtn.setBounds(648, 149, 106, 19);
		Page.add(clearBtn);
		
		JLabel lblObtenirLtatDun = new JLabel("Obtenir l'état d'un patient");
		lblObtenirLtatDun.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblObtenirLtatDun.setBounds(10, 214, 278, 46);
		Page.add(lblObtenirLtatDun);
		
		animalSearchInput = new JTextField();
		animalSearchInput.setToolTipText("Indiquez l'état");
		animalSearchInput.setColumns(10);
		animalSearchInput.setBounds(194, 254, 113, 19);
		Page.add(animalSearchInput);
		
		JLabel lblNewLabel = new JLabel("Nom du patient (animal)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 254, 202, 19);
		Page.add(lblNewLabel);
		
		JLabel lblEtatDuPatient = new JLabel("Etat du patient :");
		lblEtatDuPatient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEtatDuPatient.setBounds(10, 283, 147, 19);
		Page.add(lblEtatDuPatient);
		
		getAnimalState = new JTextField();
		getAnimalState.setToolTipText("Indiquez l'état");
		getAnimalState.setColumns(10);
		getAnimalState.setBounds(116, 283, 202, 19);
		Page.add(getAnimalState);
		getAnimalState.setEditable(false);

		
		JButton animalSearch = new JButton("Rechercher");
		animalSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client = null;
				try {
					client = new Client();
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
				
				try {
					client.startClient();
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
				
				String animalName = animalSearchInput.getText();
				IAnimal animalExist = null;
				try {
					animalExist = client.displayAnimal(animalName);
				} catch (RemoteException e2) {
					e2.printStackTrace();
				} 
				
				if(animalExist != null) {
					try {
						getAnimalState.setText(client.displayAnimal(animalName).getDossier().getEtat());
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				} else {
					getAnimalState.setText("Animal inexistant");
				}
				
				
				getAnimalState.setEditable(false);
			}
		});
		animalSearch.setBounds(328, 248, 126, 30);
		Page.add(animalSearch);
		
		autoInsertedAnimals = new JTextField();
		autoInsertedAnimals.setBounds(360, 27, 252, 19);
		Page.add(autoInsertedAnimals);
		autoInsertedAnimals.setColumns(10);
		autoInsertedAnimals.setEditable(false);
		
		animalStateInput = new JTextField();
		animalStateInput.setToolTipText("Etat de l'animal");
		animalStateInput.setColumns(10);
		animalStateInput.setBounds(434, 149, 96, 19);
		Page.add(animalStateInput);
		
		JButton btnInsrerClients = new JButton("Insérer n clients");
		btnInsrerClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client client = null;
				try {
					client = new Client();
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
				
				try {
					client.startClient();
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
				
				//int n = Integer.valueOf(numberClient.getText());
					
				try {
					for(int i = 0; i < 100; i++) {
						client.addAnimal( String.valueOf(i), "maitre " + String.valueOf(i), "Chien", "Doge", "Tranquille");
					}
					
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
								
				nInsertedAnimals.setEditable(false);
				nInsertedAnimals.setText("Insertion réalisée avec succès");
			}
		});
		
		btnInsrerClients.setBounds(241, 63, 204, 30);
		Page.add(btnInsrerClients);
		
		nInsertedAnimals = new JTextField();
		nInsertedAnimals.setColumns(10);
		nInsertedAnimals.setBounds(457, 72, 252, 19);
		Page.add(nInsertedAnimals);
		nInsertedAnimals.setEditable(false);
		
		JLabel lblInsertionDeClients = new JLabel("Insertion de clients");
		lblInsertionDeClients.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInsertionDeClients.setBounds(10, 57, 278, 46);
		Page.add(lblInsertionDeClients);
		
		}
}
