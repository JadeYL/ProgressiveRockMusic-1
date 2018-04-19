package LowestCopy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NyApparat extends JFrame {

	private JPanel contentPane;
	private JTextField txtNamnApparat;
	private JTextField txtPrisApparat;
	private JTextField txtSlitage;
	private JButton btnOkApparat;
	private JButton btnCancelApparat;
	private JLabel label;

	public NyApparat() {
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
