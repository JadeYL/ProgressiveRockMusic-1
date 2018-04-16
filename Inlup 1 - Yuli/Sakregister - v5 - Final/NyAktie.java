package LowestCopy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NyAktie extends JFrame {

	private JPanel contentPane;
	private JTextField txtAktieNamn;
	private JTextField txtAntalAktie;
	private JTextField txtAktieKurs;
	private JLabel lblKurs;
	private JLabel label;
	private JButton btnOkAktie;
	private JButton btnCancelAktie;

	public NyAktie() {
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
