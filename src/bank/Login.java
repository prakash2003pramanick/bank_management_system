package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Login extends JFrame implements ActionListener, FocusListener {

    private static final long serialVersionUID = 1L;

    JButton login, newuser;
    JTextField name;
    JPasswordField pass;
    int isFirstTimeClicked = 1;

    public Login() {
        // Constructor to set up the initial UI
        setLayout(null);
        setTitle("Prakash Bank");
        setLocation(350, 200);
        setSize(800, 480);
        getContentPane().setBackground(Color.white);

        JLabel companyName = new JLabel("Prakash Finance....");
        companyName.setBounds(3, 0, 1000, 70);
        companyName.setFont(new Font("osward", Font.BOLD, 50));
        add(companyName);

        JLabel userName = new JLabel("Username");
        userName.setBounds(150, 200, 120, 20);
        userName.setFont(new Font("osward", Font.BOLD, 20));
        add(userName);

        name = new JTextField("name");
        name.addFocusListener(this);  // Add FocusListener to name field
        name.setBounds(300, 200, 200, 20);
        add(name);

        JLabel password = new JLabel("Password ");
        password.setBounds(150, 250, 120, 29);
        password.setFont(new Font("osward", Font.BOLD, 20));
        add(password);

        pass = new JPasswordField();
        pass.setBounds(300, 250, 200, 20);
        add(pass);

        login = new JButton("LOGIN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        add(login);

        newuser = new JButton("SIGN UP");
        newuser.setBounds(410, 300, 100, 30);
        newuser.setBackground(Color.black);
        newuser.setForeground(Color.white);
        add(newuser);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        login.addActionListener(this); // Adding ActionListener for the login button
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            name.setText("");
            pass.setText("");
        }
    }

    // Implementing FocusListener methods
    public void focusGained(FocusEvent e) {
        if (e.getSource() == name && isFirstTimeClicked==2) {
            name.setText("");
            isFirstTimeClicked++;
        }
    }

    public void focusLost(FocusEvent e) {
        // Do nothing for focus lost
    }

    public static void main(String args[]) {
        new Login(); // Creating an instance of the Login class
    }
}
