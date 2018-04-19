package LowestCopy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class NyttSmycke extends JFrame {

	private JPanel contentPane;
	private JTextField txtSmyckeNamn;
	private JTextField txtsmyckeStenar;
	private JButton btnOkSmycke;
	private JButton btnCancelSmycke;
	private JLabel lblImage;

	NyttSmycke(){
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
