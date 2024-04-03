package bank_management_system;
import javax.swing.*;

import com.mysql.cj.xdevapi.Schema.Validation;

//java.awt has Image class
import java.awt.*;
//awt.even has actionListner interface
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener{
	
	
	private static final long serialVersionUID = 1L;
	static int l = 60;//this was used to change the vertical alignment remove it and replace with the actual values
	JButton SignIn, Clear, Register;
	JComboBox acc_type_dd ;
	
	JTextField LoginIdTF;
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
		
		//label for account number box
		JLabel UserType = new JLabel("User Type                  :");
		UserType.setFont(new Font("osward", Font.BOLD, 20));
		UserType.setBounds(90, 100, 250, 70);
		add(UserType);
		//add option for usertype
		String acc_type_list [] = {"Customer","Employee","Manager","Data Base Administrator"};
		acc_type_dd = new JComboBox<String>(acc_type_list);
		acc_type_dd.setBounds(300, 122, 250, 30);
		acc_type_dd.setFont(new Font("Raleway", Font.PLAIN ,15));
		acc_type_dd.setBackground(Color.WHITE);
		acc_type_dd.setForeground(Color.BLACK);
		// JTextField tf= (JTextField) ((acc_type_dd.getEditor()).getEditorComponent());
		// tf.getDocument().addDocumentListener(this);
		add(acc_type_dd);
		
		
		//adding account number field 
		
		//label for account number box
		JLabel LoginId = new JLabel("Login ID                  :");
		LoginId.setFont(new Font("osward", Font.BOLD, 20));
		LoginId.setBounds(90, 100+l, 250, 70);
		add(LoginId);
		//textField for Account Number
		LoginIdTF= new JTextField();
		LoginIdTF.setBounds(300, 122+l, 250, 30);
		add(LoginIdTF);
		
		
		//adding password field 
		
		//label for password
		JLabel Password = new JLabel("Password               :");
		Password.setFont(new Font("osward", Font.BOLD, 20));
		Password.setBounds(90, 160+l, 250, 70);
		add(Password);
		
		//textField for password
		PasswordTF= new JPasswordField();
		PasswordTF.setBounds(300, 182+l, 250, 30);
		add(PasswordTF);
		
		//creating the buttons for action 

		//sign in 
		SignIn = new JButton("SIGN IN");
		SignIn.setBounds(300, 250+l, 120, 30);
		add(SignIn);
		SignIn.setForeground(Color.WHITE);
		SignIn.setBackground(Color.BLACK);
		SignIn.addActionListener(this);
		
		//clear 
		Clear = new JButton("CLEAR");
		Clear.setBounds(430, 250+l, 120, 30);
		add(Clear);
		Clear.setForeground(Color.WHITE);
		Clear.setBackground(Color.BLACK);
		Clear.addActionListener(this);
		
		//register
		Register = new JButton("REGISTER FOR NETBANKING");
		Register.setBounds(300, 290+l, 250, 30);
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

	private int verifyuser(String table_name,String loginId, String pass){
		Conn c = new Conn();
		String query="";
		if(table_name == "netbanking"){
			query = "select Pass from "+ table_name +" where accountnumber ='"+loginId+"';";
		}
		else if(table_name == "Employee"){
			query = "select Pass from "+ table_name +" where LoginId ='"+loginId+"';";
		}
		
		try {
			ResultSet res = c.s.executeQuery(query);
			res.next();
			System.out.println(pass);
			System.out.println("fond pass"+res.getString(1));
			//System.out.println(res.getString(1));
			if(pass.equals(res.getString(1))){
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			//e.printStackTrace();
		}
		return 0;
	}

	//the abstract methods of the interface implemented needs to be overridden  always	
	public void actionPerformed(ActionEvent e) {
		// You can see the ActionListener Interface by ctrl+click on ActionListener after implements in the class declaration
		if(e.getSource() == Clear)
		{
			//System.out.println("Clear");
			PasswordTF.setText("");
			LoginIdTF.setText("");
			
		}
		else if(e.getSource() == SignIn )
		{
			System.out.println("SignIn");
			Conn con = new Conn();
			String LoginId = LoginIdTF.getText();
			String pass = PasswordTF.getText();

			System.out.println("User has enterd : "+LoginId+"   " + pass);
			String query = "";
			System.out.println("Selected index is"+acc_type_dd.getSelectedIndex());
			//this must be a private function to avoid any problems 
			if(acc_type_dd.getSelectedItem() == "Customer"){//user type is customer
				System.out.println("Entered into customer section");

				if(verifyuser("netbanking",LoginId , pass) == 1){
					System.out.println("User is verified");
				}
				else {
					System.out.println("User is not verified");
					JOptionPane.showMessageDialog(rootPane, "Wrong Credentials");
				}

			}
			else if(acc_type_dd.getSelectedIndex() == 1){//if user type is employee
				//acc_type_dd.getSelectedItem() == "Employee" can also be used 
				System.out.println("Entered in the employee section");
				if(verifyuser("Employee",LoginId , pass) == 1){
					System.out.println("User is verified");
					this.setVisible(false);
					
				}
				else {
					System.out.println("User is not verified");
					JOptionPane.showMessageDialog(rootPane, "Wrong Credentials");
				}

			}
			else {
				System.out.println("The user type cound not be identified");
			}

			
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
