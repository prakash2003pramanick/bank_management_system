package bank_management_system;
import javax.swing.*;
//java.awt has Image class
import java.awt.*;
//awt.even has actionListner interface
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
	
	
	private static final long serialVersionUID = 1L;
	JButton SignIn, Clear, Register;
	
	JTextField AccountNumberTF;
	JPasswordField PasswordTF;
	
	Login()
	{
		
		setLayout(null);
		
		//Setting the title of the frame it is displayed at the top of the frame like a name of the application
		setTitle("BANKING APPLICATION");
		
		// Setting the size of the frame setSize(horizontal,vertical)
		setSize(800,480);
		
		//Setting up logo for the organization
		//Image and ImageIcon are two different class
		//here obImageIcon is object of ImageIcon class
		//here obImage is object of Image class
//		get system resources is to get any system files into the program
		ImageIcon obImageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logo3.jpeg"));
		//Image class is in java.awt package
		Image obImage = obImageIcon.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT );
		//JLabel can take only object of ImageIcon class as parameters so converting the obImage of class Image to the obImageIcon class
		obImageIcon = new ImageIcon(obImage);
		
		
		//JLabel is used to display on the screen
		JLabel icon=new JLabel(obImageIcon);
		//positioning the image 
		icon.setBounds(10,10,70,70);
		//adding the icon to the frame
		add(icon);
		
		
		//adding text to the screen
		JLabel BankName = new JLabel("Welcome to SBI");
		BankName.setFont(new Font("osward", Font.BOLD, 30));
		BankName.setBounds(90, 12, 250, 70);
		add(BankName);
		
		
		//creating login form 
		
		
		
		//adding account number field 
		
		//label for account number box
		JLabel AccountNumber = new JLabel("Account Number :");
		AccountNumber.setFont(new Font("osward", Font.BOLD, 20));
		AccountNumber.setBounds(90, 100, 250, 70);
		add(AccountNumber);
		//textField for Account Number
		AccountNumberTF= new JTextField();
		AccountNumberTF.setBounds(300, 122, 250, 30);
		add(AccountNumberTF);
		
		
		//adding password field 
		
		//label for password
		JLabel Password = new JLabel("Password               :");
		Password.setFont(new Font("osward", Font.BOLD, 20));
		Password.setBounds(90, 160, 250, 70);
		add(Password);
		
		//textField for password
		PasswordTF= new JPasswordField();
		PasswordTF.setBounds(300, 182, 250, 30);
		add(PasswordTF);
		
		//creating the buttons for action 

		//sign in 
		SignIn = new JButton("SIGN IN");
		SignIn.setBounds(300, 250, 120, 30);
		add(SignIn);
		SignIn.setForeground(Color.WHITE);
		SignIn.setBackground(Color.BLACK);
		SignIn.addActionListener(this);
		
		//clear 
		Clear = new JButton("CLEAR");
		Clear.setBounds(430, 250, 120, 30);
		add(Clear);
		Clear.setForeground(Color.WHITE);
		Clear.setBackground(Color.BLACK);
		Clear.addActionListener(this);
		
		//register
		Register = new JButton("REGISTER FOR NETBANKING");
		Register.setBounds(300, 290, 250, 30);
		add(Register);
		Register.setForeground(Color.WHITE);
		Register.setBackground(Color.GRAY);
		Register.addActionListener(this);
		//by default it is false so we need to set it true for the frame to be visible
		setVisible(true);
	}

	public static void main(String args[]){
	Login ob =new Login();
	}

	//the abstract methods of the interface implemented needs to be overridden  always	
	public void actionPerformed(ActionEvent e) {
		// You can see the ActionListener Interface by ctrl+click on ActionListener after implements in the class declaration
		if(e.getSource() == Clear)
		{
			//System.out.println("Clear");
			PasswordTF.setText("");
			AccountNumberTF.setText("");
			
		}
		else if(e.getSource() == SignIn )
		{
			System.out.println("SignIn");
			
			
		}
		else if(e.getSource() == Register)
		{
			//System.out.println("Register");
			setVisible(false);
			new SignInOne().setVisible(true);
		}
		else
		{
			//System.out.println("no button");
		}

	}
}
