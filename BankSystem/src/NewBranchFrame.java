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

public class NewBranchFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txFldBranchName;

	public NewBranchFrame(Customer customer) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 128, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCreateNewBranch = new JLabel("Create New Branch");
			lblCreateNewBranch.setForeground(Color.YELLOW);
			lblCreateNewBranch.setFont(new Font("Roboto Slab", Font.BOLD, 20));
			lblCreateNewBranch.setBounds(119, 29, 193, 25);
			contentPanel.add(lblCreateNewBranch);
		}
		{
			JLabel lblBranchName = new JLabel("Branch Name :");
			lblBranchName.setForeground(new Color(25, 25, 112));
			lblBranchName.setFont(new Font("Roboto Slab", Font.BOLD, 20));
			lblBranchName.setBounds(23, 102, 143, 25);
			contentPanel.add(lblBranchName);
		}
		{
			txFldBranchName = new JTextField();
			txFldBranchName.setFont(new Font("Roboto Slab", Font.BOLD, 20));
			txFldBranchName.setColumns(10);
			txFldBranchName.setBounds(178, 99, 200, 30);
			contentPanel.add(txFldBranchName);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 128, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						DataTemplate brnch=new Branch();
						brnch.setData(txFldBranchName.getText());
						Database db = Login.getDb();
						brnch.addDB();
						setVisible(false); //you can't see me!
						dispose(); //Destroy the JFrame object
						CreateAccountFrame frame = new CreateAccountFrame(customer);
						frame.setVisible(true);
					}
				});
				okButton.setBackground(new Color(0, 0, 128));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setFont(new Font("Roboto Slab", Font.BOLD, 20));
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
				cancelButton.setBackground(new Color(0, 0, 128));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setFont(new Font("Roboto Slab", Font.BOLD, 20));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
