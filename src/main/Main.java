package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;

import db.MySQLDB;

import javax.swing.event.AncestorEvent;
import javax.swing.JPasswordField;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(52, 62, 114, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("로그인");
		label.setBounds(150, 12, 59, 18);
		contentPane.add(label);
		
		JButton button = new JButton("확인");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String loginID= textField.getText();
				String loginPW = passwordField.getText();
					System.out.println("로그인아이디:"+loginID);
					System.out.println("로그인비밀번호:"+loginPW);
					
					MySQLDB db = new MySQLDB();
					int loginResult = db.login(loginID,loginPW);
					if(loginResult == 1000) {
						LottoFrame lf = new LottoFrame();
                   lf.setVisible(true);
						setVisible(false);
						System.out.println("로그인성공");
					}else {
						JOptionPane.showMessageDialog(contentPane, "아이디나 비밀번호가 틀립니다", "경고", JOptionPane.WARNING_MESSAGE);
						System.out.println("로그인실패");
					}
					
//					MySQLDB db = new MySQLDB();
//					db.insert(id, pw);
			}
		});
		button.setBounds(202, 56, 105, 28);
		contentPane.add(button);
		
		JButton button_1 = new JButton("회원가입");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistFrame1 rf= new RegistFrame1();
				rf.setVisible(true);
				setVisible(false);
				
				
			}
		});
		button_1.setBounds(150, 123, 105, 28);
		contentPane.add(button_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(48, 96, 105, 25);
		contentPane.add(passwordField);
	}
}
