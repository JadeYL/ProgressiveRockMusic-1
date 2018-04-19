package LowestCopy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class Fel extends JFrame {

	private JPanel contentPane;

	public Fel() {
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
				//Inlup1.Aesthetics.Fel.DISPOSE_ON_CLOSE;
				
			}
			
		});
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Fel.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		label.setBounds(14, 11, 32, 42);
		contentPane.add(label);
	}
	
	

}
