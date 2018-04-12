package Inlup1_Del2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVrdesaker = new JLabel("V\u00E4rdesaker");
		lblVrdesaker.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVrdesaker.setBounds(146, 0, 82, 14);
		contentPane.add(lblVrdesaker);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 22, 362, 190);
		contentPane.add(textArea);
		
		JLabel lblSortering = new JLabel("Sortering");
		lblSortering.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSortering.setBounds(382, 91, 67, 14);
		contentPane.add(lblSortering);
		
		JRadioButton rdbtnNamn = new JRadioButton("Namn");
		rdbtnNamn.setBounds(378, 112, 109, 23);
		contentPane.add(rdbtnNamn);
		
		JRadioButton rdbtnVrde = new JRadioButton("V\u00E4rde");
		rdbtnVrde.setBounds(378, 138, 109, 23);
		contentPane.add(rdbtnVrde);
		
		JButton btnVisa = new JButton("Visa");
		btnVisa.setBounds(139, 221, 89, 23);
		contentPane.add(btnVisa);
		
		JButton btnBrskrasch = new JButton("B\u00F6rskrasch");
		btnBrskrasch.setBounds(231, 221, 89, 23);
		contentPane.add(btnBrskrasch);
		
		
		String[] choices = { "Smycke", "Aktier", "Apparat"};
		JComboBox comboBoxChoices = new JComboBox(choices);
		comboBoxChoices.setBounds(20, 222, 99, 20);
		comboBoxChoices.setSelectedIndex(2);	
		comboBoxChoices.addActionListener(this);
		contentPane.add(comboBoxChoices);
		
	}
	
	public void actionPerformed(ActionEvent e){
		JComboBox cb = (JComboBox)e.getSource();		
		String s = (String)cb.getSelectedItem();
		
		switch (s) {
		case "Smycke":
			System.out.println("it works");
			NyttSmycke ns = new NyttSmycke();
			ns.setVisible(true);
			break;		
		case "Aktier":
			System.out.println("Rar");
			break;
		case "Apparat":
			break;			
		}
		
	}
	
	public static void main(String args[]){
		Main rar = new Main();
		rar.setVisible(true);
	}
}
