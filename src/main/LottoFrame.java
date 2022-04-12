package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;

public class LottoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LottoFrame frame = new LottoFrame();
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
	public LottoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel one = new JLabel("New label");
		one.setBounds(34, 16, 100, 100);
		contentPane.add(one);
		BevelBorder border=new BevelBorder(BevelBorder.RAISED);//3차원적인 테두리 효과를 위한것이고 양각의 옵션을 준다.
		one.setBorder(border);//라벨에 적용시킨다.
		  getContentPane().add(one);
		  
		  JLabel one2 = new JLabel("New label");
			one2.setBounds(259, 19, 100, 100);
			contentPane.add(one2);
			BevelBorder border2=new BevelBorder(BevelBorder.RAISED);//3차원적인 테두리 효과를 위한것이고 양각의 옵션을 준다.
			one2.setBorder(border2);//라벨에 적용시킨다.
			  getContentPane().add(one2);
			  
			  JLabel one3 = new JLabel("New label");
				one3.setBounds(499, 23, 100, 100);
				contentPane.add(one3);
				BevelBorder border3=new BevelBorder(BevelBorder.RAISED);//3차원적인 테두리 효과를 위한것이고 양각의 옵션을 준다.
				one3.setBorder(border3);//라벨에 적용시킨다.
				  getContentPane().add(one3);
		
				  JLabel one4 = new JLabel("New label");
					one4.setBounds(383, 18, 100, 100);
					contentPane.add(one4);
					BevelBorder border4=new BevelBorder(BevelBorder.RAISED);//3차원적인 테두리 효과를 위한것이고 양각의 옵션을 준다.
					one4.setBorder(border4);//라벨에 적용시킨다.
					  getContentPane().add(one4);
		
					  JLabel one5 = new JLabel("New label");
						one5.setBounds(633, 11, 100, 100);
						contentPane.add(one5);
						BevelBorder border5=new BevelBorder(BevelBorder.RAISED);//3차원적인 테두리 효과를 위한것이고 양각의 옵션을 준다.
						one5.setBorder(border5);//라벨에 적용시킨다.
						  getContentPane().add(one5);
			
						  JLabel one6 = new JLabel("New label");
							one6.setBounds(149, 9, 100, 100);
							contentPane.add(one6);
							BevelBorder border6=new BevelBorder(BevelBorder.RAISED);//3차원적인 테두리 효과를 위한것이고 양각의 옵션을 준다.
							one6.setBorder(border6);//라벨에 적용시킨다.
							  getContentPane().add(one6);
				

		

		
	}
}
