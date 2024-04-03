package bank_management_system;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Cashier extends JFrame implements ActionListener{
    
    JTextField AccountNumber, DebitNumber, AmountTF;
    JButton SearchAccount, Debit, Credit;
    


	public Cashier() {
        setLayout(null);
        //kaam suru 

        JLabel CashierWindow = new JLabel("Cashier Window");
        CashierWindow.setBounds(290,20,200,20);
        CashierWindow.setFont(new Font("Arial", Font.PLAIN, 25));
        add(CashierWindow);
        
        //Accepting account number from the cashier
        JLabel Account = new JLabel("Account Number");
        Account.setBounds(80,80,350,20);
        Account.setFont(new Font("Arial", Font.PLAIN, 15));
        add(Account);
        
        AccountNumber = new JTextField("Enter account number");
        AccountNumber.setBounds(250,80,350,25);
        AccountNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        add(AccountNumber);

        //Accepting debit card number from the cashier
        JLabel Debit = new JLabel("Debit Number");
        Debit.setBounds(80,120,350,20);
        Debit.setFont(new Font("Arial", Font.PLAIN, 15));
        add(Debit);
        
        DebitNumber = new JTextField("Enter Debit number");
        DebitNumber.setBounds(250,120,350,25);
        DebitNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        add(DebitNumber);

        //creating a search button for processing 
        SearchAccount = new JButton("Search");
        SearchAccount.setBounds(450,160,150,30);
        SearchAccount.setForeground(Color.WHITE);
        SearchAccount.setBackground(Color.BLACK);
        SearchAccount.addActionListener(this);
        add(SearchAccount);


     

        



        
        //kaam ktham

        getContentPane().setBackground(Color.WHITE);
        setTitle("Cashier");
		setSize(750,800);
		setLocation(170,0);
		setVisible(true);
		setVisible(true);
	}
    public void detailsFound(String AccountNumberFetched,String Name, String BalanceFetched){
        int b = 150;
        //Displaying the text account number on the pane
        JLabel AccountNumberLabel= new JLabel("Account Number");
        AccountNumberLabel.setBounds(80,220,350,20);
        AccountNumberLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(AccountNumberLabel);
        //Displaying the account number fetched
        JLabel ACFetched= new JLabel(AccountNumberFetched);
        ACFetched.setBounds(250,220,350,20);
        ACFetched.setFont(new Font("Arial", Font.PLAIN, 15));
        add(ACFetched);

        //Displaying the text AccountHolder
        JLabel AccountHolderLabel= new JLabel("Account Holder");
        AccountHolderLabel.setBounds(80,245,350,20);
        AccountHolderLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(AccountHolderLabel);
        //Displaying the AccountHolder name
        JLabel AccountHolderName= new JLabel(Name);
        AccountHolderName.setBounds(250,245,350,20);
        AccountHolderName.setFont(new Font("Arial", Font.PLAIN, 15));
        add(AccountHolderName);


        JLabel Balance = new JLabel("Balance");
        Balance.setBounds(80,270,350,20);
        Balance.setFont(new Font("Arial", Font.PLAIN, 15));
        add(Balance);
        //Displaying the Balance Fetched from the user
        JLabel BalanceFetchedLabel = new JLabel(BalanceFetched);
        BalanceFetchedLabel.setBounds(250,270,350,20);
        BalanceFetchedLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(BalanceFetchedLabel);

        // MiniStatement
        JLabel MiniStatement = new JLabel("Mini Statement :");
        MiniStatement.setBounds(80,300,350,20);
        add(MiniStatement);

        // JPanel MiniStatementExtractor = new JPanel();
        // MiniStatement.add(new JTextComponent() {
            
        // });
        // BalanceFetchedLabel.setBounds(250,380,350,20);
        // add(MiniStatementExtractor);

        //Accepting account number from the cashier
        JLabel Amount = new JLabel("Enter Ammount");
        Amount.setBounds(80,350+b,350,20);
        Amount.setFont(new Font("Arial", Font.PLAIN, 15));
        add(Amount);
        
        AmountTF = new JTextField("Enter amount");
        AmountTF.setBounds(250,350+b,350,25);
        AmountTF.setFont(new Font("Arial", Font.PLAIN, 15));
        add(AmountTF);

        //creating a search button for Credit
        Credit = new JButton("Credit");
        Credit.setBounds(280,390+b,150,30);
        Credit.setForeground(Color.WHITE);
        Credit.setBackground(Color.BLACK);
        Credit.addActionListener(this);
        add(Credit);

        //creating button for debit
        Debit = new JButton("Debit");
        Debit.setBounds(450,390+b,150,30);
        Debit.setForeground(Color.WHITE);
        Debit.setBackground(Color.BLACK);
        Debit.addActionListener(this);
        add(Debit);
        
    }
    public static void main(String args[]){
        new Cashier();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == SearchAccount){
            String accountNumber = AccountNumber.getText();
            String debitNumber = DebitNumber.getText();
            System.out.println(accountNumber);
            System.out.println(debitNumber);

            if((! accountNumber.isEmpty() || !debitNumber.isEmpty() ) && (!accountNumber.equals("Enter account number") || !debitNumber.equals("Enter Debit number"))){
                //write sql logic to retrive the account details of the user
                Conn con = new Conn();
                String query = "";
                //if any record is found then perform these actions
                String AccountNumberFetched = "1234234234";
                String Name = "xyz";
                String BalanceFetched = "000";

                detailsFound(AccountNumberFetched, Name, BalanceFetched);
                this.repaint();
                this.revalidate();
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Enter either account number or debit card number");
            }

        }
    }
}