package star_1;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
	
public class Star_1 extends JFrame {
	private JTextField 				textField;
	private JTextArea 				textArea;
	private JButton 				btnSend, btnClear;
	private GridBagLayout 			gridBagLayout;
	private GridBagConstraints 		gbc_textField, gbc_textArea, gbc_btnSend, gbc_btnClear;
	private JScrollPane				jsp;
	
	public Star_1() {
		super("Star_Test");
		
		this.init();
		this.setLayout();
		this.addListener();
		this.showFrame();
	}

	private void init() {
		this.gridBagLayout 					= new GridBagLayout();
		this.gridBagLayout.columnWidths 	= new int[]{0, 0, 0, 0, 0};
		this.gridBagLayout.rowHeights 		= new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		this.gridBagLayout.columnWeights 	= new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.gridBagLayout.rowWeights 		= new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		this.textArea 						= new JTextArea();
		this.jsp	  						= new JScrollPane(this.textArea);
		
		this.gbc_textArea 					= new GridBagConstraints();
		this.gbc_textArea.gridheight 		= 8;
		this.gbc_textArea.gridwidth 		= 4;
		this.gbc_textArea.insets 			= new Insets(0, 0, 5, 5);
		this.gbc_textArea.fill 				= GridBagConstraints.BOTH;
		this.gbc_textArea.gridx 			= 0;
		this.gbc_textArea.gridy 			= 0;
		
		this.textField 						= new JTextField();
		this.gbc_textField 					= new GridBagConstraints();
		this.gbc_textField.gridwidth 		= 2;
		this.gbc_textField.insets 			= new Insets(0, 0, 0, 5);
		this.gbc_textField.fill 			= GridBagConstraints.HORIZONTAL;
		this.gbc_textField.gridx 			= 0;
		this.gbc_textField.gridy 			= 8;
		
		this.btnSend 						= new JButton("보내기");
		this.gbc_btnSend 					= new GridBagConstraints();
		this.gbc_btnSend.insets 			= new Insets(0, 0, 0, 5);
		this.gbc_btnSend.gridx 				= 2;
		this.gbc_btnSend.gridy 				= 8;
		
		this.btnClear 						= new JButton("지우기");
		this.gbc_btnClear 					= new GridBagConstraints();
		this.gbc_btnClear.gridx 			= 3;
		this.gbc_btnClear.gridy 			= 8;
	}

	private void setLayout() {
		this.setLayout(gridBagLayout);
		this.textField.setColumns(10);
		this.textArea.setEditable(false);
		
		this.add(jsp, gbc_textArea);
		this.add(textField, gbc_textField);
		this.add(btnSend, gbc_btnSend);
		this.add(btnClear, gbc_btnClear);

	}

	private void addListener() {
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columns();
			}
		});
		
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				columns();
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
	}
	
	public void columns() {
		String str = textField.getText();
		if (!str.equals("")) {
			// 정수를 입력받기 위한 코드
			int a = Integer.parseInt(str);
			
			// 2중 포문을 이용한 빈 문자열 생성
			for (int i = 1; i <= a; i++) {
				for (int j = 1; j <= a-i; j++) {
					textArea.append(" ");
				}
				// 포문을 이용한 별표 생성
				for (int k = 1; k <= i*2-1; k++) {
					textArea.append("*");
				}
				textArea.append("\n");
			}
			// 2중 포문을 이용한 빈 문자열 생성
			for (int i = a-1; i >= 1; i--) {
				for (int j = 1; j <= a-i; j++) {
					textArea.append(" ");
				}
				// 포문을 이용한 별표 생성
				for (int k = 1; k <= i*2-1; k++) {
					textArea.append("*");
				}
				textArea.append("\n");
			}
			textField.setText("");
		}
	}
	
	private void showFrame() {
		this.setSize(300,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Star_1();
	} //main
}
