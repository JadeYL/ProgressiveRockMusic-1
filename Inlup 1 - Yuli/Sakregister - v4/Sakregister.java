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
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButtonMenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Sakregister extends JFrame {

	private JPanel contentPane;
	String[] comboList = new String[]{"Smycke", "Aktie","Apparat"};
	ArrayList<Smycke> allaSmycke = new ArrayList<>();  //then make arraylist of Arraylists cause why not :3
	ArrayList<Aktie> allaAktie = new ArrayList<>();
	ArrayList<Apparat> allaApparat = new ArrayList<>();
	
	ArrayList<Integer> sorterValIndexes = new ArrayList<Integer>(); //sorter for values
	ArrayList<Object> superList = new ArrayList<Object>();
	
	ArrayList<Object> superListNum = new ArrayList<Object>();
	
	
	
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
		
		
		JRadioButton rdbtnNamn = new JRadioButton("Namn");
		rdbtnNamn.setBounds(362, 156, 109, 23);
		contentPane.add(rdbtnNamn);
		
		JRadioButton rdbtnVrde = new JRadioButton("V\u00E4rde");
		rdbtnVrde.setBounds(362, 186, 109, 23);
		contentPane.add(rdbtnVrde);
		
		
		
		superList.add(allaSmycke);
		superList.add(allaAktie);
		superList.add(allaApparat);	
		
		
		
		JButton btnVisa = new JButton("Visa");
		btnVisa.setBounds(175, 220, 89, 23);
		btnVisa.addActionListener(new Visa());
		
		btnVisa.addActionListener(new ActionListener() {
		
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//unsorted method - simplified to primitive code
//				for(int ii = 0;ii<allaAktie.size()+allaApparat.size()+allaSmycke.size();ii++){
//					textArea.setText("");
//					System.out.println("Printing Smycke");				
//					String texttext = allaSmycke.toString();				
//					textArea.append(texttext.replace("[", "").replace("]", "").replace(", ", ""));
//					System.out.println("printing Aktie");
//					String textak = allaAktie.toString();
//					textArea.append(textak.replace("[", "").replace("]", "").replace(", ", ""));
//					System.out.println("printing Apparat");
//					String app = allaApparat.toString();
//					textArea.append(app.replace("[", "").replace("]", "").replace(", ", ""));					
//				}		
				
				
				
				//makes sure Visa doesn't continously spam previous data.
				if(textArea != null){
					textArea.setText("");
				}
				
																											
				/**    Below code works but it keeps seperating Smycke/Aktie/Apparat into its own corner */				
				StringBuilder txt = new StringBuilder(); //get  collectinput				
				for(Object obj : superList){
					if (txt.length() > 0){
						//txt.append("\n"); //Unneeded since toString accounts for.
					}
					txt.append(String.valueOf(obj)); //handle null objects
				}				
				textArea.setText(txt.toString().replace("[", "").replace("]", "").replace(", ", ""));												
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
		

		rdbtnNamn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {  /** Can actually toss entire sensorfile into Visa btn **/
				System.out.println("");
				if(rdbtnNamn.isSelected()){
					
					//sort getname
					if(rdbtnNamn.isSelected()){
						rdbtnVrde.setSelected(false);
						System.out.println("SortName");
								
						
						/**
						 * 
						 * Insert Sort Code Here.
						 * 
						 * **/
						
						String sortnames = textArea.getText();
						String sort2 = sortnames.replaceAll("Smycke:", "#Smycke:").replaceAll("Apparat:", "#Apparat:").replaceAll("Aktie:", "#Aktie:");
						System.out.println(sort2); //please find a way to reconsolidate. Perhaps contains slitage etc = bla
						String[] sortArray = sort2.split("#");  //maybe not needed
						//first thing on this array is nothing.
						System.out.println("print array");
						System.out.println(sortArray[1]);  //tester
						//Arrays.sort(sortArray);  //probs need to do String x = arrays.sort etc.
						ArrayList<String> sortRegion = new ArrayList<String>(Arrays.asList(sortArray));
						Collections.sort(sortRegion);
						
						String joined2 = String.join("#", sortRegion);
						String joined4 = joined2.replaceAll("# ", "#");
						textArea.setText("");
						
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
						/** PROBLEM :  Om sifror räknas som namn kommer sifror ex. 15 vara mindre än 2 pga Java sortstyle
						 * 				Brukar inte vara något problem när det gäller namn.  **/																												
					}
					
					
					
					if(rdbtnVrde.isSelected()){
						rdbtnNamn.setSelected(false); 
						
						
						
						
						
//						if(!(superList.size() <0)){
//							
//						}
						
						

						
						
						//have loop check if everything behind värde: contains a number or a ',' if so factor in.
						
						
						
						
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
					
					System.out.println("Sort by Value");
					
					
					String sortVal = textArea.getText(); // possible need to split.textArea first.
					String sortValue2 = sortVal.replaceAll("\n", "\nnn#");
					String[] sortValues = sortValue2.split("nn#");
					System.out.println("print namearray");
					//System.out.println(sortValues[1]);  //tester
					System.out.println(Arrays.deepToString(sortValues));
					
					int[] allowedVals = {'1','2','3','4','5','6','7','8','9','0'}; //perhaps include ' ' cause it's also present.
					
					//Collections.sort(superList,(allaSmycke as,allaAktier aa) -> as.getClass().getValue());
					
//					Collections.sort(allaSmycke,(o1,o2)->o1.getValue());
//					Collections.sort(allaAktie,(o1,o2)->o1.getValue());
//					
//				
					
//					
					
					
					//Collections.sort(allaApparat,(o1,o2)->o1.getValue() && allaAktie,(o1,o2)->o1.getValue() && allaSmycke,(o1,o2)->o1.getValue());
					
					//Collections.sort(allaSmycke,(o1,o2)->o1.getValue());
					
					Collections.sort(superList,(o1,o2)-> o1.getClass().getName().compareTo(o2.getClass().getName()));
					//Collections.sort(superList,(o1,o2)-> o1.getClass().compareTo(o2.getClass().getName()));
					
					textArea.setText(superList.toString().replace("[", "").replace("]", "").replace(", ", ""));
					for(int iix=0;iix<sortValues.length;iix++){  //plus one since the actual array somehow wants to start at 1.
						System.out.print("Found index at: ");
						System.out.println(sortValues[iix].indexOf("värde:"));	 //then use index+1 cause its after that											
						int firstindexofSortVal = sortValues[iix].indexOf("värde:"); 
						
						//get the final index of substring		
						
//						/** runs through to check if it's a num or not **/
//						if(sortValues[iix+4].contains('0')){
//							System.out.println("doesn't contain zero");
//						}
						
//						for (int iii : allowedVals){
//							if(sortValues[firstindexofSortVal] != allowedVals[iii]){
//								System.out.println("iterating through no" + iii);
//							} else {
//								int finalindexofSortVal = iii;
//								System.out.println("final val index: " +  iii);
//							}
//						}
						
							
						
//						for(int rr=0;rr < allowedVals.length;rr++){
//							if(sortValues[iix].indexOf(firstindexofSortVal) != allowedVals[rr]){  //possibly overcasted. go low layer
//							
//								System.out.println("iterating through no" + rr);
//								int finalindexofSortVal = rr; //rr?
//								System.out.println("final index is" + finalindexofSortVal);
//								
//							} else if (sortValues[iix].indexOf(firstindexofSortVal) != allowedVals[rr]){
//								
//							}
//						}
												
					}
					
					
					
					
					
					ArrayList<String> splitVarde = new ArrayList<String>();
					
					String containsValue = "värde:";
					
//					for(int ia =0; ia < superList.size();ia++){
//						if(sortVal.toLowerCase().indexOf(containsValue.toLowerCase()) != -1){
//							
//						}
//					}
//					
					
					for(int ij = 0; ij <superList.size(); ij++){ 
						
						
						if(sortVal.contains("värde:")){
							
							for(int iy =1; iy<=sortVal.length();iy++){ //look through len of sortVal
								
							}
							
							//and for value between substring this. double? to this.  Get value)
							//evaluate the (cast)double/float between the strings
								//sort.    //if it doesn't work have it push upwards in rank?
							//yank element out and put into superListNum based on sort result
							
							//get Index. 
							
							
							sorterValIndexes.add(superList.indexOf(ij)); //perhaps literally yank the element out of the superList into second superList.
						}
					}
					
					
					
					
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
						if (txtNamnApparat != null && txtPrisApparat != null && txtSlitage != null){
							NyApparat1 nyap = new NyApparat1();		
							Apparat ap = new Apparat(getName(), getInkopsPris(), getSlitage());  //added cast int later when I switch everything to float.
							/**  perhaps have helper class here **/
							allaApparat.add(ap);
							
							
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
			label.setIcon(new ImageIcon(NyApparat.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
			label.setBounds(10, 11, 32, 32);
			contentPane.add(label);
			
		}
		
		public String getApparatNamn(){
			return txtNamnApparat.getText();
		}		
		public int getInkopsPris(){
			return Integer.parseInt(txtPrisApparat.getText());
			  //cast float eventually
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
			
			
			//requires number formatter to constantly get it to #.00 etc
			DecimalFormat dc = new DecimalFormat("##.##");			
			txtAktieKurs = new JFormattedTextField(); //need to somehow set it to DecimalFormat without it overwriting itself
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
										
					try {
						if (txtAktieNamn != null && txtAntalAktie != null && txtAktieKurs != null ){  //flag for problem
							NyAktie1 nyak = new NyAktie1();
							
							Aktie ak = new Aktie(getAktieNamn(), getAktieAntal(), getAktieKurs());
							//Smycke ms = new Smycke(getNamn(), getAdelsten(), isGold); //Trace
							
							
							allaAktie.add(ak);
							
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
			
			/** ForceSet to .2f% doesn't work **/
//			DecimalFormat dff = new DecimalFormat("##.##");
//			dff.setMaximumFractionDigits(2);
//			Float floatfloat = Float.parseFloat(txtAktieKurs.getText());
//			return Float.parseFloat(dff.format(floatfloat));
			//return Float.parseFloat(String.format("%.2f", Float.parseFloat(txtAktieKurs.getText())));		
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
						Fel1 smyckFel = new Fel1();
						smyckFel.setVisible(true);
						
						
					}dispose();
					
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
					dispose(); //close window  //placeholder getFrames per now.
					
					
					
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
