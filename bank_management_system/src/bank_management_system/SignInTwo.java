
package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.util.*;

//Download the JCalender jar file in you system
//https://repo1.maven.org/maven2/com/toedter/jcalendar/1.4/jcalendar-1.4.jar
//right click on bank_management_system and go to properties -> go to java Build path -> select class path -> click on add external jar files -> select the file from the download location -> apply and close
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignInTwo extends JFrame implements ActionListener{
	
	long form_number;
	
	JTextField f_name, AadharNumber,Pan;
	JDateChooser dateChooser;
	JRadioButton yes,no;
	JButton next;
	JComboBox<String> acc_type_dd;
	JCheckBox s1,s2,s3,s4,s5,s6; //services 
	
	private static final long serialVersionUID = 1L;
	SignInTwo(long form_number)
	{
//		System.out.println("received"+formNumber);
		this.form_number = form_number;
//		System.out.println("updated"+this.formNumber);
		
		setLayout(null);
		
		//PRINTS THE FORM NUMBER 
//		String newString = "APPLICATION FORM NO. 2 is : "+(String)formNumber;
//		System.out.println(newString);
		JLabel app_num= new JLabel("APPLICATION FORM NO. 2 is : "+form_number);
		app_num.setFont(new Font("Raleway", Font.BOLD , 38));
		app_num.setBounds(180, 20, 800, 40);
		add(app_num);
		
		//PERSONAL DETAILS PAGE 2
		JLabel personal_details= new JLabel("Personal Details : Page 2");
		personal_details.setFont(new Font("Raleway",Font.PLAIN , 34));
		personal_details.setBounds(40, 80 , 800, 45);
		add(personal_details);
		
		//ACCOUNT TYPE
		JLabel acc_type = new JLabel("Type           : ");
		acc_type.setFont(new Font("Raleway", Font.PLAIN , 25));
		acc_type.setBounds(40, 150 , 160, 40);
		add(acc_type);
		//Dropdown for account type
		String acc_type_list [] = {"Select Account type","Saving","Current","Fixed Deposit"};
		acc_type_dd = new JComboBox<String>(acc_type_list);
		acc_type_dd.setBounds(220,155,500,30);
		acc_type_dd.setFont(new Font("Raleway", Font.PLAIN ,15));
		acc_type_dd.setBackground(Color.WHITE);
		acc_type_dd.setForeground(Color.BLACK);
		add(acc_type_dd);
		
		//Aadhar number from the user
		JLabel aadharLabel= new JLabel("Aadhar       : ");
		aadharLabel.setFont(new Font("Raleway", Font.PLAIN, 25));
		aadharLabel.setBounds(40, 200 , 160, 40);
		add(aadharLabel);
		
		AadharNumber = new JTextField("Enter valid UID");
		AadharNumber.setFont(new Font("Raleway", Font.PLAIN ,15));
		AadharNumber.setBounds(220,205,500,30);
		add(AadharNumber);
		
		//PanNumber Details
		JLabel PanNumber= new JLabel("PAN            :");
		PanNumber.setFont(new Font("Arial", Font.PLAIN, 25));
		PanNumber.setBounds(40, 250 , 160, 40);
		add(PanNumber);

		Pan = new JTextField("Enter valid PAN");
		Pan.setFont(new Font("Raleway", Font.PLAIN ,15));
		Pan.setBounds(220 , 255, 500, 30);
		add(Pan);
		
		//Concent to store personal details/Agree with terms and consitions
		JLabel Store_data= new JLabel("Record data :");
		Store_data.setFont(new Font("Raleway", Font.PLAIN, 25));
		Store_data.setBounds(40, 300 , 160, 40);
		add(Store_data);
		
		yes = new JRadioButton("YES");
		yes.setBounds(220, 305 , 160, 40);
		yes.setFont(new Font("Raleway", Font.PLAIN, 20));
		yes.setBackground(Color.WHITE);
		add(yes);
		
		no = new JRadioButton("NO");
		no.setBounds(400, 305 , 150	, 40);
		no.setFont(new Font("Raleway", Font.PLAIN, 20));
		no.setBackground(Color.WHITE);
		add(no);
		//this grouping avoids multiple selection of radio buttons... those in the groups only one of them can be chosen
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(yes);
		gendergroup.add(no);

		//Creating check boxes for the services required 
		JLabel services= new JLabel("Select the services you wish to opt :");
		services.setFont(new Font("Raleway", Font.PLAIN, 25));
		services.setBounds(40, 370 , 500, 40);
		add(services);

		//Available services - InternetBnaking-ATM-CreditCard-SMS-UPI
		//In the program the servies logic is binary - 1 for opted and 0 for not opted
		//suppose a person chooses InternetBanking and CreditCard it is represented as -> 10100 (String)

		s1 = new JCheckBox("    Internet Banking");
		s1.setFont(new Font("Raleway", Font.PLAIN, 20));
		s1.setBounds(40, 420 , 500, 40);
		s1.setBackground(Color.white);
		add(s1);
		s2 = new JCheckBox("    ATM");
		s2.setFont(new Font("Raleway", Font.PLAIN, 20));
		s2.setBounds(40, 470 , 500, 40);
		s2.setBackground(Color.white);
		add(s2);
		s3 = new JCheckBox("    Credit Card");
		s3.setFont(new Font("Raleway", Font.PLAIN, 20));
		s3.setBounds(40, 520 , 500, 40);
		s3.setBackground(Color.white);
		add(s3);
		s4 = new JCheckBox("    SMS - CHARGABLE MONTHLY");
		s4.setFont(new Font("Raleway", Font.PLAIN, 20));
		s4.setBounds(40, 570 , 500, 40);
		s4.setBackground(Color.white);
		add(s4);
		s5 = new JCheckBox("    UPI");
		s5.setFont(new Font("Raleway", Font.PLAIN, 20));
		s5.setBounds(40, 620 , 500, 40);
		s5.setBackground(Color.white);
		add(s5);



		//creating a next button to move to the next page
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.PLAIN, 20));
		next.setBounds(575, 720 , 150, 40);
		add(next);
		//adding a acdtion listner
		next.addActionListener(this);

		// default view of the application is set to right corner for easy view during developement,
		// later it should be aligned to center

		getContentPane().setBackground(Color.WHITE);
		setSize(900,800);
		setLocation(1020,10);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {  
		
		//extract the values from the JTextFields
		String formno = "" + form_number;
		String permissionGranted = (yes.isSelected())?"yes":(no.isSelected())?"no":null;
		String accountType = (String) (acc_type_dd.getSelectedItem());
		String aadharnumber = AadharNumber.getText();
		String pannumber = Pan.getText();
		String service = "";
		System.out.println(s1.isSelected());
		service += (s1.isSelected())?"1":"0";
		service += (s2.isSelected())?"1":"0";
		service += (s3.isSelected())?"1":"0";
		service += (s4.isSelected())?"1":"0";
		service += (s5.isSelected())?"1":"0";

		System.out.println(service);

		
		
		try {
			if(permissionGranted == null || permissionGranted.equals("no"))
			{
				JOptionPane.showMessageDialog(null, "You need to grant permission to proceed");
			}
			else if(accountType == "Select Account type")
			{
				JOptionPane.showMessageDialog(null, "Select the appropriate account type");
			}
			else if(aadharnumber == ""){
			 	
				JOptionPane.showMessageDialog(null, "Enter Aadhar number");
				//check if the aadhar number is valid
				//check other conditions for valid aadhar number
			}
			else if(pannumber == ""){
			 	//check if the pan number is valid
				JOptionPane.showMessageDialog(null, "PAN number cannot be empty");
			}
			else
			{
				Conn c = new Conn();
				//Table name
				String table_name = "add_det";
				//create table add_det(formno varchar(7), account_type varchar(20), aadhar varchar(20), pan varchar(20), permission varchar(7));
				String querry = "insert into "+table_name+" values ('"+formno+"','"+accountType+"','"+aadharnumber+"','"+pannumber+"','"+permissionGranted+"','"+service+"');";
				if(c.s != null) {
					try {
						c.s.executeUpdate(querry);
						System.out.println("1 row added! to add_det table");
					}catch (Exception e) {
						System.out.println(e);
						JOptionPane.showMessageDialog(null, "Account Could not be created! Plase try again later");
					}
					finally {
						System.out.println("Executing insie the finally block");
						setVisible(false);
						new Credentials(form_number).setVisible(true);	
					}
					
				}
				else {
					System.out.println("Connection could not be established");
					
				}					
			}
		}catch (Exception ax){
			System.err.println(ax);
		}
	}
	//to run the page individually uncomment the main method. Pass only negative values to keep a track of the record
	public static void main(String args [])
	{
		new SignInTwo(-12l);
	}
}