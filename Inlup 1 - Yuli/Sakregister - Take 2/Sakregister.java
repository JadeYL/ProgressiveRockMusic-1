import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Lecture5.Igelkott;

import javax.swing.JLabel;
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

public class Sakregister extends JFrame {

	private JPanel contentPane;
	String[] comboList = new String[]{"Smycke", "Aktie","Apparat"};

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
		
		JRadioButton rdbtnNamn = new JRadioButton("Namn");
		rdbtnNamn.setBounds(362, 156, 109, 23);
		contentPane.add(rdbtnNamn);
		
		JRadioButton rdbtnVrde = new JRadioButton("V\u00E4rde");
		rdbtnVrde.setBounds(362, 186, 109, 23);
		contentPane.add(rdbtnVrde);
		
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
					
				}		
			}	
		}
		);
		contentPane.add(comboBoxNew);
		
		JButton btnVisa = new JButton("Visa");
		btnVisa.setBounds(175, 220, 89, 23);
		btnVisa.addActionListener(new Visa());
		contentPane.add(btnVisa);
		
		JButton btnBrskrasch = new JButton("B\u00F6rskrasch");
		btnBrskrasch.setBounds(267, 220, 89, 23);
		contentPane.add(btnBrskrasch);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 31, 350, 178);
		contentPane.add(textArea);
	}
	
	
	
	class Visa implements ActionListener{
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
			
			btnCancelApparat = new JButton("Cancel");
			btnCancelApparat.setBounds(122, 98, 76, 23);
			contentPane.add(btnCancelApparat);
			
			label = new JLabel("");
			label.setIcon(new ImageIcon(NyApparat.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
			label.setBounds(10, 11, 32, 32);
			contentPane.add(label);
			
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
			
			btnCancelAktie = new JButton("Cancel");
			btnCancelAktie.setBounds(127, 88, 89, 23);
			contentPane.add(btnCancelAktie);
			
			
		}

	}
	
	class NyttSmycke1 extends JFrame {

		private JPanel contentPane;
		private JTextField txtSmyckeNamn;
		private JTextField txtsmyckeStenar;
		private JButton btnOkSmycke;
		private JButton btnCancelSmycke;
		private JLabel lblImage;

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
			
			btnOkSmycke = new JButton("OK");
			btnOkSmycke.setBounds(58, 90, 64, 23);
			contentPane.add(btnOkSmycke);
			
			btnCancelSmycke = new JButton("Cancel");
			btnCancelSmycke.setBounds(127, 90, 87, 23);
			contentPane.add(btnCancelSmycke);
			
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(NyttSmycke.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
			lblImage.setBounds(23, 14, 37, 39);
			contentPane.add(lblImage);
		}
	}
	
	
}
