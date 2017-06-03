package GUI;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class UseTOTPPane extends JPanel{
	
	String key;

	public UseTOTPPane(String key){
		this.key=key;
		
		JTextField codeField = new JTextField();
		
		JButton okButton = new JButton();
		
		this.add(codeField);
		this.add(okButton);
		
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, codeField, 0, SpringLayout.VERTICAL_CENTER, this);
		layout.putConstraint(SpringLayout.WEST, codeField, 50, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, codeField, -50, SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, okButton, 30, SpringLayout.VERTICAL_CENTER, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, okButton, 30, SpringLayout.HORIZONTAL_CENTER, this);
		
		
	
	}
	
}
