package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import db.MySQLDB;

public class RegistFrame1 extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField passwordField;
	private JPasswordField rePasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistFrame1 frame = new RegistFrame1();
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
	public RegistFrame1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("돌아가기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(275, 82, 105, 28);
		contentPane.add(button);
		
		JLabel label = new JLabel("회원가입");
		label.setBounds(222, 12, 59, 18);
		contentPane.add(label);
		
		JLabel idlabel_1 = new JLabel("아이디");
		idlabel_1.setBounds(56, 35, 59, 18);
		contentPane.add(idlabel_1);
		
		idField = new JTextField();
		idField.setBounds(34, 48, 114, 22);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel pwlabel_1 = new JLabel("비밀번호");
		pwlabel_1.setBounds(56, 87, 59, 18);
		contentPane.add(pwlabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(34, 113, 114, 22);
		contentPane.add(passwordField);
		
		JLabel relabel_1 = new JLabel("비밀번호 확인");
		relabel_1.setBounds(71, 147, 59, 18);
		contentPane.add(relabel_1);
		
		rePasswordField = new JPasswordField();
		rePasswordField.setBounds(33, 179, 115, 28);
		contentPane.add(rePasswordField);
		
		JButton button_1 = new JButton("회원가입");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean idFix = false;
				boolean pwFix = false;
				String id = idField.getText();
				int idLeng=id.length();
				if(id == null || id.equals("")) {
					System.out.println("아이디가 비었습니다");
					JOptionPane.showMessageDialog(contentPane, "아이디를 입력하세요", "경고", JOptionPane.WARNING_MESSAGE);
				}else {
					
					}
				
				
				String resultID= id.trim().replaceAll(" ","" );
				int resultLeng = resultID.length();
				String onlyEng= resultID.replaceAll("[^a-zA-Z0-9]", "");
				
				MySQLDB db1= new MySQLDB();
				boolean select = db1.selectOne(onlyEng);
				
				if(onlyEng.length()>0) {
					System.out.println("영어로만 이루어진 올바른 아이디입니다");
					System.out.println("디비에 저장될 아이디"+onlyEng);
					idFix=true;
				}else {
					System.out.println("영아가 아닌 다른문자가 있다");
					JOptionPane.showMessageDialog(contentPane, "영어로만 입력합시다", "경고", JOptionPane.WARNING_MESSAGE);
				}
				
				System.out.println("입력된 아이디값"+resultID);
				System.out.println("입력된 아이디길이"+resultLeng);
				
				String pw = passwordField.getText();
				String rePw = rePasswordField.getText();
				System.out.println("첫번째 패스워드 값"+pw);
				System.out.println("두번째 패스워드 값"+rePw);
				
				if(pw == null || pw.equals("")) {
					System.out.println("비밀번호가 비었습니다");
					JOptionPane.showMessageDialog(contentPane, "비밀번호를 입력하세요", "경고", JOptionPane.WARNING_MESSAGE);
				}else {
					String resultPW=pw.trim().replaceAll(" ","" );
					if(resultPW.equals(rePw)) {
						System.out.println("비밀번호가 일치합니다");
						System.out.println("디비에 저장될 패스워드"+pw);
						pwFix = true;
						
					}else {
						System.out.println("비밀번호가 일치하지 않습니다");
						JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치하지 않습니다", "경고", JOptionPane.WARNING_MESSAGE);
					}
					System.out.println("비밀번호가 들어있습니다");
				}
				

				
				if(idFix==true && pwFix==true &&select== false) {
					MySQLDB db = new MySQLDB();
					db.insert(onlyEng, pw);
					
				}else {
					System.out.println("아이디와 비밀번호를 올바르게 입력해주세요");
					JOptionPane.showMessageDialog(contentPane, "아이디와 비밀번호를 올바르게 입력해주세요", "경고", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		button_1.setBounds(275, 142, 105, 28);
		contentPane.add(button_1);
	}
}
