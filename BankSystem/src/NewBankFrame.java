import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewBankFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txFldBankName;
	
	public NewBankFrame(Customer customer) {
		setBackground(new Color(0, 139, 139));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 139, 139));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblBankName = new JLabel("Bank Name :");
		lblBankName.setForeground(new Color(25, 25, 112));
		lblBankName.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblBankName.setBounds(22, 113, 135, 25);
		contentPanel.add(lblBankName);
		
		txFldBankName = new JTextField();
		txFldBankName.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		txFldBankName.setColumns(10);
		txFldBankName.setBounds(169, 108, 200, 30);
		contentPanel.add(txFldBankName);
		
		JLabel lblCreateNewBank = new JLabel("Create New Bank");
		lblCreateNewBank.setForeground(new Color(255, 255, 0));
		lblCreateNewBank.setFont(new Font("Roboto Slab", Font.BOLD, 20));
		lblCreateNewBank.setBounds(119, 38, 193, 25);
		contentPanel.add(lblCreateNewBank);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 139, 139));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Add");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						DataTemplate bank=new Bank();
						bank.setData(txFldBankName.getText());
						Database db = new Database();
						bank.addDB();
						setVisible(false); //you can't see me!
						dispose(); //Destroy the JFrame object
						CreateAccountFrame frame = new CreateAccountFrame(customer);
						frame.setVisible(true);
					}
				});
				okButton.setFont(new Font("Roboto Slab", Font.BOLD, 20));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(25, 25, 112));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false); //you can't see me!
						dispose(); //Destroy the JFrame object
						CreateAccountFrame frame = new CreateAccountFrame(customer);
						frame.setVisible(true);
					}
				});
				cancelButton.setFont(new Font("Roboto Slab", Font.BOLD, 20));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(25, 25, 112));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
