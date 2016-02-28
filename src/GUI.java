package bluePrint.src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI extends JFrame implements ActionListener{

	private ArrayList<Card> cards;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea txtPros;
	private JTextArea txtCons;
	private JButton btnSubmitPros;
	private JButton btnSubmitCons;
	private JButton btnSubmitCard;
	private JButton btnStop;

	/**
	 * Create the frame.
	 */
	public GUI() {
		
		cards = new ArrayList<Card>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Font font = new Font("Helvetica", Font.BOLD, 12);
		
		txtPros = new JTextArea();
		txtPros.setBounds(10, 90, 200, 125);
		txtPros.setFont(font);
		contentPane.add(txtPros);
	
		txtCons = new JTextArea();
		txtCons.setBounds(220, 90, 200, 125);
		txtCons.setFont(font);
		contentPane.add(txtCons);
		
		textField = new JTextField();
		textField.setBounds(108, 24, 200, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPros = new JLabel("Pros");
		lblPros.setBounds(92, 65, 46, 14);
		lblPros.setFont(font);
		contentPane.add(lblPros);
		
		JLabel lblCons = new JLabel("Cons");
		lblCons.setBounds(298, 65, 46, 14);
		lblPros.setFont(font);

		contentPane.add(lblCons);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(185, -1, 46, 14);
		lblPros.setFont(font);
		contentPane.add(lblName);
		
		
		btnSubmitCard = new JButton("Submit Card");
		btnSubmitCard.setBounds(172, 226, 89, 23);
		btnSubmitCard.addActionListener(this);
		contentPane.add(btnSubmitCard);
		
		btnStop = new JButton("STAHP");
		btnStop.setBounds(335, 11, 89, 23);
		btnStop.addActionListener(this);
		contentPane.add(btnStop);
	}
	
	public void actionPerformed(ActionEvent e){
//		if(e.getSource() == btnSubmitPros){
//			String pros = txtPros.getText();
//		}else if(e.getSource() == btnSubmitCons){
//			String cons = txtCons.getText();
		if(e.getSource() == btnSubmitCard){
			String name = textField.getText();
			String pros = txtPros.getText();
			String cons = txtCons.getText();
			
			Card card = new Card(name, pros, cons, cards.size());
			System.out.println(card);
			cards.add(card);
			System.out.println(cards);
			
			txtPros.setText("");
			txtCons.setText("");
			textField.setText("");
		}else if(e.getSource() == btnStop){
//			if(txtPros.getText().compareTo("") != 0 ||
//					txtCons.getText().compareTo("") != 0 ||
//					txtField.getText().compareTo("") != 0 ||)
//				JOptionPane.
			Collections.shuffle(cards);
			UserSort userSort = new UserSort(cards);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
