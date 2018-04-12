package Inlup1_Del2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NyttSmycke extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFieldNamn;
	private JTextField txtFieldStenar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NyttSmycke dialog = new NyttSmycke();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NyttSmycke() {
		setBounds(100, 100, 220, 169);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNamn = new JLabel("Namn:");
			lblNamn.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNamn.setBounds(51, 26, 46, 14);
			contentPanel.add(lblNamn);
		}
		{
			JLabel lblStenar = new JLabel("Stenar:");
			lblStenar.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblStenar.setBounds(51, 51, 46, 14);
			contentPanel.add(lblStenar);
		}
		
		txtFieldNamn = new JTextField();
		txtFieldNamn.setBounds(101, 23, 97, 20);
		contentPanel.add(txtFieldNamn);
		txtFieldNamn.setColumns(10);
		
		txtFieldStenar = new JTextField();
		txtFieldStenar.setBounds(101, 48, 97, 20);
		contentPanel.add(txtFieldStenar);
		txtFieldStenar.setColumns(10);
		
		JCheckBox chckbxAvGuld = new JCheckBox("Av guld");
		chckbxAvGuld.setBounds(101, 75, 97, 23);
		contentPanel.add(chckbxAvGuld);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setBounds(51, 105, 57, 23);
		contentPanel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
			
		btnCancel.setBounds(111, 105, 72, 23);
		contentPanel.add(btnCancel);
		
	}
	
//	public void actionPerformed(ActionEvent e){		
//		if (e.getSource() == btnCancel){
//			this.setVisible(false);
//		}
//	}
}
