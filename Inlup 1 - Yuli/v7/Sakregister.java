
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;



public class Sakregister extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String[] comboList = new String[]{"Smycke", "Aktie","Apparat"};	
	ArrayList<Item> alla = new ArrayList<>();
	ArrayList<Object> superList = new ArrayList<Object>();	
		
	//iterators
	Iterator<Item> itItem = alla.iterator();
	
	/**  Main  */
	public static void main(String[] args) {

		Sakregister frame = new Sakregister();
		frame.setVisible(true);
	}


	
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

		JLabel lblNytt = new JLabel("Nytt:");
		lblNytt.setBounds(42, 224, 31, 14);
		contentPane.add(lblNytt);
		
		JComboBox<String> comboBoxNew = new JComboBox<String>(comboList);
		comboBoxNew.setBounds(76, 220, 94, 22);
		comboBoxNew.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				String selected = (String) combo.getSelectedItem();
				
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
				
		JRadioButton rdbtnNamn = new JRadioButton("Namn");
		rdbtnNamn.setBounds(362, 156, 109, 23);
		contentPane.add(rdbtnNamn);
		
		JRadioButton rdbtnVrde = new JRadioButton("V\u00E4rde");
		rdbtnVrde.setBounds(362, 186, 109, 23);
		contentPane.add(rdbtnVrde);
		
		
		
		/** ---------------------------------
		 * Add all elements onto superlist 
		 *  Not really needed. but used here
		 *  for Antiquated code. 
		 *  ---------------------------------*/
		
		superList.add(alla);

		
		/** Button Visa */
		JButton btnVisa = new JButton("Visa");
		btnVisa.setBounds(175, 220, 89, 23);
		
		btnVisa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(textArea != null){
					textArea.setText("");
				}
				
				
				textArea.append(alla.toString().replace("[", "").replace("]", "").replace(", ", ""));
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
				alla.removeAll(alla);				
			}
		});
		
		
		
		/** radio buttons **/
		rdbtnNamn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) { 
				System.out.println("");
				if(rdbtnNamn.isSelected()){
					
					/** Sorteras via Getname 
					 * 
					 *  kunde använda något som 
					 *  alla.sort((y, x) -> Integer.compare((int)x.getValue(), (int)y.getValue())); istället fast för sortname*/
										
					if(rdbtnNamn.isSelected()){
						rdbtnVrde.setSelected(false);
						System.out.println("SortName");
						String sortnames = textArea.getText();
						String sort2 = sortnames.replaceAll("Smycke:", "#Smycke:").replaceAll("Apparat:", "#Apparat:").replaceAll("Aktie:", "#Aktie:");
						String[] sortArray = sort2.split("#");  
						ArrayList<String> sortRegion = new ArrayList<String>(Arrays.asList(sortArray));
						Collections.sort(sortRegion);						
						String joined2 = String.join("#", sortRegion);
						String joined4 = joined2.replaceAll("# ", "#");
						textArea.setText("");
						
						/**    Seperator helper function for Formatting strings between Stenar Kurs and Slitage   **/
						String containsStenar ="stenar";
						String containsKurs = "kurs";
						String containsSlitage = "slitage";
																		
						/**  Sort by Name   **/
						if(joined4.toLowerCase().indexOf(containsStenar.toLowerCase()) != -1){
							String joined3 = joined4.replaceAll("#Smycke:", "Smycke:");
							textArea.setText(joined3);
							System.out.println("found case: Smycke:");						
						}												
						if(joined4.toLowerCase().indexOf(containsKurs.toLowerCase()) != -1){
							String joined3 = joined4.replaceAll("#Aktie:", "Aktie:");
							textArea.setText(joined3);
							System.out.println("found case: Aktie:");						
						}
						if(joined4.toLowerCase().indexOf(containsSlitage.toLowerCase()) != -1){
							String joined3 = joined4.replaceAll("#Apparat:", "Apparat:");
							textArea.setText(joined3);
							System.out.println("found case: Apparat:");						
						}						
						String joined3 = joined4.replaceAll("#Smycke:", "Smycke:").replaceAll("#Aktie:", "Aktie:").replaceAll("#Apparat:", "Apparat:");
						textArea.setText(joined3);																																		
					}				
					if(rdbtnVrde.isSelected()){
						rdbtnNamn.setSelected(false); 						
					}																				
				}				
			}
		});		
		
		rdbtnVrde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("selected sort values");
				if(rdbtnVrde.isSelected()){
					rdbtnNamn.setSelected(false);
					

					alla.sort((y, x) -> Integer.compare((int)x.getValue(), (int)y.getValue()));				
					textArea.setText(superList.toString().replace("[", "").replace("]", "").replace(", ", ""));
					
					
					
					
				}
				
			}
		});

		
	}

	
	/** Nyapparat */
	class NyApparat1 extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
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
			
			txtPrisApparat = new JFormattedTextField();
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
						int valuSlitage = Integer.valueOf(txtSlitage.getText());
						
						if (txtNamnApparat != null && txtPrisApparat != null && txtSlitage != null){
						
							Apparat appa = new Apparat(getApparatNamn(), getInkopsPris(), getSlitage());
							
							
							if (valuSlitage >= 0 && valuSlitage <= 10) {
								alla.add(appa);	
							} else {
								Fel1 appFel = new Fel1();
								appFel.setVisible(true);
							}
							
						} 
							
					} catch (NumberFormatException e1) {
						
						Fel1 appFel = new Fel1();
						appFel.setVisible(true);																		
					}
					dispose();
					
				}
												
			});
			
			
			
			btnCancelApparat = new JButton("Cancel");
			btnCancelApparat.setBounds(122, 98, 76, 23);
			contentPane.add(btnCancelApparat);
			btnCancelApparat.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();				
				}
			});	
			
			label = new JLabel("");		
			label.setIcon(new ImageIcon(Sakregister.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
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
	
	/** NyAktie */
	class NyAktie1 extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
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
			
		
			txtAktieKurs = new JFormattedTextField();
			txtAktieKurs.setBounds(117, 64, 99, 20);
			contentPane.add(txtAktieKurs);
			txtAktieKurs.setColumns(10);
			
			lblKurs = new JLabel("Kurs:");
			lblKurs.setBounds(76, 67, 46, 14);
			contentPane.add(lblKurs);
			
			label = new JLabel(" ");
			label.setIcon(new ImageIcon(Sakregister.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));  //kan skapa errors
			label.setBounds(10, 14, 31, 32);
			contentPane.add(label);
			
			btnOkAktie = new JButton("OK");
			btnOkAktie.setBounds(54, 88, 68, 23);
			contentPane.add(btnOkAktie);
			btnOkAktie.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
										
					try {
						if (txtAktieNamn != null && txtAntalAktie != null && txtAktieKurs != null ){				
							Aktie ak = new Aktie(getAktieNamn(), getAktieAntal(), getAktieKurs());						
							alla.add(ak);
						}
							
					} catch (NumberFormatException e1) {
						Fel1 aktfel = new Fel1();
						aktfel.setVisible(true);					
					}dispose();
					
				}
												
			});
			
			btnCancelAktie = new JButton("Cancel");
			btnCancelAktie.setBounds(127, 88, 89, 23);
			contentPane.add(btnCancelAktie);
			btnCancelAktie.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();				
				}
			});						
		}
		
		public String getAktieNamn() {
			return txtAktieNamn.getText();
		}	
		public int getAktieAntal(){
			return Integer.parseInt(txtAntalAktie.getText());
		}
		public float getAktieKurs(){					
			return Float.parseFloat(txtAktieKurs.getText());
		}

		

	}
	/** NySmycke */
	class NyttSmycke1 extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTextField txtSmyckeNamn;
		private JTextField txtsmyckeStenar;
		private JButton btnOkSmycke;
		private JButton btnCancelSmycke;
		private JLabel lblImage;
		private boolean isGold = false;
		
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
					}
				}
			});

			btnOkSmycke = new JButton("OK");
			btnOkSmycke.setBounds(58, 90, 64, 23);
			contentPane.add(btnOkSmycke);
			btnOkSmycke.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						if (txtsmyckeStenar != null && getAdelsten() != 0){		
							Smycke ms = new Smycke(getNamn(), getAdelsten(), isGold);
							alla.add(ms);
							
						}
							
					} catch (NumberFormatException e1) {
						Fel1 smyckFel = new Fel1();
						smyckFel.setVisible(true);					
					} dispose();
					
				}
												
			});
			
			btnCancelSmycke = new JButton("Cancel");
			btnCancelSmycke.setBounds(127, 90, 87, 23);
			contentPane.add(btnCancelSmycke);
			btnCancelSmycke.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					
					
				}
			});		
			
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(Sakregister.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
			lblImage.setBounds(23, 14, 37, 39);
			contentPane.add(lblImage);
		}
		
		public String getNamn() {
			return txtSmyckeNamn.getText();
		}				
		public int getAdelsten() {
			return Integer.parseInt(txtsmyckeStenar.getText());
		}
		public Boolean checkGold() {  //uppercasted Boolean 'normally' boolean.
			return isGold;
		}				
		public int getValue(){
			int kost;
			int smyckePris;
			if(isGold == false){
				kost = 2000;
			} else {
				kost = 700;
			}
			smyckePris = ( Integer.parseInt(txtsmyckeStenar.getText()) * 500 ) + kost;
			return smyckePris;
		}
		
		public String toString(){
			return null;						
		}
	}
	
	
	/**  Class Fel poppup **/
	class Fel1 extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;

		public Fel1() {
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
					dispose();
				}				
			});
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(Sakregister.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
			label.setBounds(14, 11, 32, 42);
			contentPane.add(label);
		}		
	}	
}
