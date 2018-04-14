package Inlup1.TestCode;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Lecture5.IgelReg;
import Lecture5.Igelkott;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButtonMenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Sakregister extends JFrame {

	private JPanel contentPane;
	String[] comboList = new String[]{"Smycke", "Aktie","Apparat"};
	ArrayList<Smycke> allaSmycke = new ArrayList<>();  //then make arraylist of Arraylists cause why not :3
	ArrayList<Aktie> allaAktie = new ArrayList<>();
	ArrayList<Apparat> allaApparat = new ArrayList<>();
	int arraySuper = allaSmycke.size() + allaAktie.size();
	
	//iterators
	Iterator<Smycke> itSmyck = allaSmycke.iterator();
	Iterator<Aktie> itAktie = allaAktie.iterator();
	Iterator<Apparat> itApparat = allaApparat.iterator();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//corecode here
					Sakregister frame = new Sakregister();
					frame.setVisible(true);
					
					
					
					
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public Sakregister() {
		setTitle("Sakregister");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 286);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVrdesaker = new JLabel("V\u00E4rdesaker");
		lblVrdesaker.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVrdesaker.setBounds(135, 11, 87, 14);
		contentPane.add(lblVrdesaker);
		
		JLabel lblSortering = new JLabel("Sortering");
		lblSortering.setBounds(366, 135, 55, 14);
		contentPane.add(lblSortering);
		
//		public void checkSelectedRadioButton(){
//			if(rdbtnNamn.isSelected()){
//				rdbtnVrde.setSelected(false);
//			}
//		}
		
		
		
		JLabel lblNytt = new JLabel("Nytt:");
		lblNytt.setBounds(42, 224, 31, 14);
		contentPane.add(lblNytt);
		
		JComboBox<String> comboBoxNew = new JComboBox<String>(comboList);
		comboBoxNew.setBounds(76, 220, 94, 22);
		comboBoxNew.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				String selected = (String) combo.getSelectedItem(); //could use getSelected Index
				
				if(selected.equals("Smycke")){
					System.out.println("Smycke");
					NyttSmycke1 nysmy = new NyttSmycke1();
					nysmy.setVisible(true);
					
				} else if (selected.equals("Aktie")){
					System.out.println("Aktie");
					NyAktie1 nyak = new NyAktie1();
					nyak.setVisible(true);
					
				} else if (selected.equals("Apparat")){
					System.out.println("Apparat");
					NyApparat1 nysmy = new NyApparat1();
					nysmy.setVisible(true);
					
				} else {
					System.err.println("Error");
					Fel1 fel = new Fel1();
					fel.setVisible(true);
				}
			}	
		}
		);
		contentPane.add(comboBoxNew);
				
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 31, 350, 178);
		contentPane.add(textArea);
		
		JButton btnVisa = new JButton("Visa");
		btnVisa.setBounds(175, 220, 89, 23);
		btnVisa.addActionListener(new Visa());
		
		btnVisa.addActionListener(new ActionListener() {
		
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				for(int ii = 0;ii<allaAktie.size()+allaApparat.size()+allaSmycke.size();ii++){
					textArea.setText("");
					System.out.println("Printing Smycke");				
					String texttext = allaSmycke.toString();				
					textArea.append(texttext.replace("[", "").replace("]", "").replace(", ", ""));
					System.out.println("printing Aktie");
					String textak = allaAktie.toString();
					textArea.append(textak.replace("[", "").replace("]", "").replace(", ", ""));
					System.out.println("printing Apparat");
					String app = allaApparat.toString();
					textArea.append(app.replace("[", "").replace("]", "").replace(", ", ""));
					
				}							
			}
	});	
		
		
		
		contentPane.add(btnVisa);

		
		JButton btnBrskrasch = new JButton("B\u00F6rskrasch");
		btnBrskrasch.setBounds(267, 220, 89, 23);
		contentPane.add(btnBrskrasch);
		btnBrskrasch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				allaSmycke.removeAll(allaSmycke);
				allaAktie.removeAll(allaAktie);
				allaApparat.removeAll(allaApparat);
				//System.out.println(allaApparat.get(0));
				
			}
		});
		
		/** radio buttons **/
		
		JRadioButton rdbtnNamn = new JRadioButton("Namn");
		rdbtnNamn.setBounds(362, 156, 109, 23);
		contentPane.add(rdbtnNamn);
		
		JRadioButton rdbtnVrde = new JRadioButton("V\u00E4rde");
		rdbtnVrde.setBounds(362, 186, 109, 23);
		contentPane.add(rdbtnVrde);
		
		rdbtnNamn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("selected sort name");
				if(rdbtnNamn.isSelected()){
					rdbtnVrde.setSelected(false);
					
					String sortnames = textArea.getText();
					
					String sort2 = sortnames.replaceAll("Smycke:", "# ").replaceAll("Apparat:", "# ").replaceAll("Aktie:", "# ");
					System.out.println(sort2); //please find a way to reconsolidate. Perhaps contains slitage etc = bla
					String[] sortArray = sort2.split("#");  //maybe not needed
					//first thing on this array is nothing.
					System.out.println("print array");
					System.out.println(sortArray[1]);  //tester
					Arrays.sort(sortArray);  //probs need to do String x = arrays.sort etc.
					
					String joined2 = String.join("#", sortArray);
					String joined4 = joined2.replaceAll("# ", "#");
					textArea.setText("");
					
					String containsStenar ="stenar";
					String containsKurs = "kurs";
					String containsSlitage = "slitage";
					
					//Iterate here
					if(joined4.toLowerCase().indexOf(containsStenar.toLowerCase()) != -1){
						String joined3 = joined4.replaceAll("#", "Smycke:");
						textArea.setText(joined3);
						System.out.println("found case: Smycke:");						
					}
					if(joined4.toLowerCase().indexOf(containsKurs.toLowerCase()) != -1){
						String joined3 = joined4.replaceAll("#", "kurs:");
						textArea.setText(joined3);
						System.out.println("found case: Aktie:");						
					}
					if(joined4.toLowerCase().indexOf(containsSlitage.toLowerCase()) != -1){
						String joined3 = joined4.replaceAll("#", "Apparat:");
						textArea.setText(joined3);
						System.out.println("found case: Apparat:");						
					}
					
					/** PROBLEM :  Om sifror räknas som namn kommer sifror ex. 15 vara mindre än 2 pga Java sortstyle
					 * 				Brukar inte vara något problem när det gäller namn.  **/
					
					
					
					/**   ALTERNATE FIX. Make sure all factors of characters enter same Index. like
					 * 	  ¤¤Aktie
					 * 	  Apparat
					 *    ¤Smycke			¤Represents whitespace. funkar superbra när man ska sortera.**/
				}
				
			}
		});				
		rdbtnVrde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("selected sort values");
				if(rdbtnVrde.isSelected()){
					rdbtnNamn.setSelected(false);
					
				}
				
			}
		});

		
	}
	
	
	
	class Visa implements ActionListener{ //unimplement
		public void actionPerformed(ActionEvent ave) {
			System.out.println("Test");
		}
	}
	
	

	
	class ComboClick implements ActionListener{
		public void actionPerformed(ActionEvent ave) {
//			if (comboBoxNew.getSelectedItem().toString() == Smycke){
//				
//			}
		}
	}
	
	class NyApparat1 extends JFrame {

		private JPanel contentPane;
		private JTextField txtNamnApparat;
		private JTextField txtPrisApparat;
		private JTextField txtSlitage;
		private JButton btnOkApparat;
		private JButton btnCancelApparat;
		private JLabel label;

		public NyApparat1() {
			setTitle("Ny apparat");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 221, 171);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNamn = new JLabel("Namn:");
			lblNamn.setBounds(70, 17, 46, 14);
			contentPane.add(lblNamn);
			
			JLabel lblPrisApparat = new JLabel("Antal:");
			lblPrisApparat.setBounds(70, 45, 46, 14);
			contentPane.add(lblPrisApparat);
			
			txtNamnApparat = new JTextField();
			txtNamnApparat.setBounds(112, 11, 86, 20);
			contentPane.add(txtNamnApparat);
			txtNamnApparat.setColumns(10);
			
			txtPrisApparat = new JTextField();
			txtPrisApparat.setBounds(112, 39, 86, 20);
			contentPane.add(txtPrisApparat);
			txtPrisApparat.setColumns(10);
			
			txtSlitage = new JTextField();
			txtSlitage.setBounds(112, 67, 86, 20);
			contentPane.add(txtSlitage);
			txtSlitage.setColumns(10);
			
			JLabel lblSlitage = new JLabel("Slitage:");
			lblSlitage.setBounds(70, 73, 46, 14);
			contentPane.add(lblSlitage);
			
			btnOkApparat = new JButton("OK");
			btnOkApparat.setBounds(57, 98, 59, 23);
			contentPane.add(btnOkApparat);
			btnOkApparat.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						if (txtNamnApparat != null && txtPrisApparat != null && txtSlitage != null){
							NyApparat1 nyap = new NyApparat1();		
							Apparat ap = new Apparat(getApparatNamn(), getInkopsPris(), getSlitage());
							allaApparat.add(ap);
							
						}
							
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(Sakregister.this, "Fel indata!");
					}
					
				}
												
			});
			
			
			
			btnCancelApparat = new JButton("Cancel");
			btnCancelApparat.setBounds(122, 98, 76, 23);
			contentPane.add(btnCancelApparat);
			
			label = new JLabel("");
			label.setIcon(new ImageIcon(NyApparat.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
			label.setBounds(10, 11, 32, 32);
			contentPane.add(label);
			
		}
		
		public String getApparatNamn(){
			return txtNamnApparat.getText();
		}		
		public int getInkopsPris(){
			return Integer.parseInt(txtPrisApparat.getText());
		}
		public int getSlitage(){
			return Integer.parseInt(txtSlitage.getText());
		}
		
		

	}
	
	class NyAktie1 extends JFrame {

		private JPanel contentPane;
		private JTextField txtAktieNamn;
		private JTextField txtAntalAktie;
		private JTextField txtAktieKurs;
		private JLabel lblKurs;
		private JLabel label;
		private JButton btnOkAktie;
		private JButton btnCancelAktie;

		public NyAktie1() {
			setTitle("Ny aktie");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 242, 161);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNamn = new JLabel("Namn:");
			lblNamn.setBounds(76, 14, 46, 14);
			contentPane.add(lblNamn);
			
			JLabel lblAntal = new JLabel("Antal:");
			lblAntal.setBounds(76, 39, 46, 14);
			contentPane.add(lblAntal);
			
			txtAktieNamn = new JTextField();
			txtAktieNamn.setBounds(117, 11, 99, 20);
			contentPane.add(txtAktieNamn);
			txtAktieNamn.setColumns(10);
			
			txtAntalAktie = new JTextField();
			txtAntalAktie.setBounds(117, 36, 99, 20);
			contentPane.add(txtAntalAktie);
			txtAntalAktie.setColumns(10);
			
			txtAktieKurs = new JTextField();
			txtAktieKurs.setBounds(117, 64, 99, 20);
			contentPane.add(txtAktieKurs);
			txtAktieKurs.setColumns(10);
			
			lblKurs = new JLabel("Kurs:");
			lblKurs.setBounds(76, 67, 46, 14);
			contentPane.add(lblKurs);
			
			label = new JLabel(" ");
			label.setIcon(new ImageIcon(NyAktie.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
			label.setBounds(10, 14, 31, 32);
			contentPane.add(label);
			
			btnOkAktie = new JButton("OK");
			btnOkAktie.setBounds(54, 88, 68, 23);
			contentPane.add(btnOkAktie);
			btnOkAktie.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if (txtAktieNamn != null && txtAntalAktie != null && txtAktieKurs != null ){//check instead .equals?
						NyAktie1 nyak = new NyAktie1();
						
						Aktie ak = new Aktie(getAktieNamn(), getAktieAntal(), getAktieKurs());
						//Smycke ms = new Smycke(getNamn(), getAdelsten(), isGold); //Trace
						allaAktie.add(ak);
					} else {
						System.err.println("A Field is Empty");
						Fel1 problemaktie = new Fel1();
						problemaktie.setVisible(true);
					}
					
				}
												
			});
			
			btnCancelAktie = new JButton("Cancel");
			btnCancelAktie.setBounds(127, 88, 89, 23);
			contentPane.add(btnCancelAktie);
			
			
		}
		
		public String getAktieNamn() {
			return txtAktieNamn.getText();
		}	
		public int getAktieAntal(){
			return Integer.parseInt(txtAktieKurs.getText());
		}
		public float getAktieKurs(){			
			return Float.parseFloat(txtAntalAktie.getText());
		}

		

	}
	
	class NyttSmycke1 extends JFrame {

		private JPanel contentPane;
		private JTextField txtSmyckeNamn;
		private JTextField txtsmyckeStenar;
		private JButton btnOkSmycke;
		private JButton btnCancelSmycke;
		private JLabel lblImage;
		boolean isGold = false;  //perhaps inside

		NyttSmycke1(){
			
			
			setTitle("Nytt Smycke");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 268, 161);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNamn = new JLabel("Namn:");
			lblNamn.setBounds(76, 14, 46, 14);
			contentPane.add(lblNamn);
			
			JLabel lblStenar = new JLabel("Stenar:");
			lblStenar.setBounds(76, 39, 46, 14);
			contentPane.add(lblStenar);
			
			txtSmyckeNamn = new JTextField();
			txtSmyckeNamn.setBounds(119, 11, 122, 20);
			contentPane.add(txtSmyckeNamn);
			txtSmyckeNamn.setColumns(10);
			
			txtsmyckeStenar = new JTextField();
			txtsmyckeStenar.setBounds(119, 39, 122, 20);
			contentPane.add(txtsmyckeStenar);
			txtsmyckeStenar.setColumns(10);
			
			JCheckBox chckbxAvGuld = new JCheckBox("Av guld");
			chckbxAvGuld.setBounds(129, 60, 97, 23);
			contentPane.add(chckbxAvGuld);
			chckbxAvGuld.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e){
					if(e.getStateChange() == ItemEvent.SELECTED){
						isGold = true;
					} else {
						isGold = false;
					}  //throwable here if ever
				}
			});
			
			//button if Textbox empty && button pressed = throw error.
			
			btnOkSmycke = new JButton("OK");
			btnOkSmycke.setBounds(58, 90, 64, 23);
			contentPane.add(btnOkSmycke);
			btnOkSmycke.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						if (txtsmyckeStenar != null && getAdelsten() != 0){  //flag for problem
							NyttSmycke1 nysmy = new NyttSmycke1(); //super recursive???				
							Smycke ms = new Smycke(getNamn(), getAdelsten(), isGold); //Trace
							allaSmycke.add(ms);
							
						}
							
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(Sakregister.this, "Fel indata!");
					}
					
				}
												
			});
			
			btnCancelSmycke = new JButton("Cancel");
			btnCancelSmycke.setBounds(127, 90, 87, 23);
			contentPane.add(btnCancelSmycke);
			
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(NyttSmycke.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
			lblImage.setBounds(23, 14, 37, 39);
			contentPane.add(lblImage);
		}
		
		public String getNamn() {
			return txtSmyckeNamn.getText();
		}		
		
		
		
		public int getAdelsten() {  //parsed here
			return Integer.parseInt(txtsmyckeStenar.getText());
		}
		public Boolean checkGold() {  //uppercasted Boolean 'normally' boolean.
			return isGold;
		}
				
		public int getValue(){ //getValue of this class each one has diff GetVal
			int kost;
			int smyckePris;
			if(isGold == false){
				kost = 2000;
			} else {
				kost = 700;
			}
			smyckePris = ( Integer.parseInt(txtsmyckeStenar.getText()) * 500 ) + kost;  //used to be adelstenar
			return smyckePris;				//parseFloat? .2%f
		}
		
		public String toString(){
			return null;						
//			return "Smycke: " + txtSmyckeNamn + " Värde:" + getValue()
//					+ " stenar:"+Integer.parseInt(txtsmyckeStenar.getText())+ " silver";
		} //FIND A WAY TO PARSE FLOAT TO CERTAIN DECIMAL //Check helpdoc in Git
		  //getValue is a really ugly way to mess things up
	}
	
	class Fel1 extends JFrame { //have internal Fel per nested class?

		private JPanel contentPane;

		public Fel1() {
//			JTextField status = new JTextField(10);   //masterlist get bool
			setTitle("Fel");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 174, 121);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblFelInmatning = new JLabel("Fel inmatning!");
			lblFelInmatning.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFelInmatning.setBounds(56, 25, 84, 14);
			contentPane.add(lblFelInmatning);
			
			JButton btnOkFel = new JButton("OK");
			btnOkFel.setBounds(66, 48, 53, 23);
			contentPane.add(btnOkFel);
			btnOkFel.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					Fel1.getFrames();  //close window  //placeholder getFrames per now.
					
					
					
				}
				
			});
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(Fel.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
			label.setBounds(14, 11, 32, 42);
			contentPane.add(label);
		}		
//		public String getNamn() {
//			return status.getText();
//		}
	}

	
	
}
