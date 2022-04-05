package mainboard;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class LISOpanel extends JPanel implements ActionListener {

    JPanel holder = new JPanel();
    JLabel title = new JLabel("Petrolium Management");
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel wrongpswdindicator = new JLabel("**INCORRECT**");
    JButton loginButton = new JButton("Login");
    JButton signOutButton = new JButton("Sign Out");
    JButton registerButton = new JButton("Register");
    JButton clearButton = new JButton("Clear acc");
    JCheckBox showPassword = new JCheckBox("Show Password");
    
    File acc = new File("C:\\Users\\ngoda\\Desktop\\MainBoard\\src");
    int ln;
    String Username, Password;
    

    LISOpanel() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setComponentProperties();

    }

    public void setLayoutManager() {
        setLayout(null);
        setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        setBackground(Color.LIGHT_GRAY);
        setBounds(0, 30, 900, 470);
    }

    public void setLocationAndSize() {
    	title.setBounds(250, 35, 450, 60);
    	holder.setBounds(250, 90, 450, 300);
        userLabel.setBounds(36, 40, 100, 30);
        passwordLabel.setBounds(36, 90, 100, 30);
        userTextField.setBounds(137, 40, 270, 30);
        passwordField.setBounds(137, 90, 270, 30);
        showPassword.setBounds(140, 120, 150, 24);
        wrongpswdindicator.setBounds(290, 120, 280, 30);
        loginButton.setBounds(36, 145, 370, 40);
        signOutButton.setBounds(36, 145, 370, 40);
        registerButton.setBounds(300, 195, 100, 30);
        clearButton.setBounds(190, 195, 100, 30);


    }
    
    public void setComponentProperties() {
    	title.setFont(new Font("Javanese Text", Font.BOLD, 39));
    	title.setForeground(Color.orange);
    	title.setHorizontalAlignment(SwingConstants.CENTER);
    	holder.setLayout(null);
    	holder.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
    	wrongpswdindicator.hide();
    	registerButton.setBorder(null);
    	registerButton.setBackground(Color.green);
    	registerButton.setForeground(Color.WHITE);
        clearButton.setBorder(null);
    	clearButton.setBackground(Color.red);
    	clearButton.setForeground(Color.WHITE);
        clearButton.setVisible(false);
    	loginButton.setBorder(null);
    	loginButton.setBackground(Color.blue);
    	loginButton.setForeground(Color.WHITE);
    	signOutButton.setBorder(null);
    	signOutButton.setBackground(Color.blue);
    	signOutButton.setForeground(Color.WHITE);
    	signOutButton.setVisible(false);
    }

    public void addComponentsToContainer() {
    	add(title);
    	add(holder);
        holder.add(userLabel);
        holder.add(passwordLabel);
        holder.add(userTextField);
        holder.add(passwordField);
        holder.add(showPassword);
        holder.add(wrongpswdindicator);
        holder.add(loginButton);
        holder.add(signOutButton);
        holder.add(registerButton);
        holder.add(clearButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        signOutButton.addActionListener(this);
        registerButton.addActionListener(this);
        clearButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
    
    void createFolder(){
        if(!acc.exists()){
        	acc.mkdirs();
        }
    }
    
    void readFile(){
        try {
            FileReader fr = new FileReader(acc+"\\account.txt");
            //System.out.println("file exists!");
        } 
        catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(acc+"\\account.txt");
                //System.out.println("File created");
            } 
            catch (IOException ex1) {
                Logger.getLogger(LISOpanel.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
    }
    
    void addData(String usr,String pswd){
        try {
            RandomAccessFile raf = new RandomAccessFile(acc+"\\account.txt", "rw");
            for(int i=0;i<ln;i++){
                raf.readLine();
            }
            //if condition added after video to have no lines on first entry
            if(ln>0){
            raf.writeBytes("\r\n");
            }
            raf.writeBytes("Username:"+usr+ "\r\n");
            raf.writeBytes("Password:"+pswd+ "\r\n");
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(LISOpanel.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(LISOpanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    void authentication(String usr,String pswd){
        try {
            RandomAccessFile raf = new RandomAccessFile(acc+"\\account.txt", "rw");
            for(int i=0;i<ln;i+=3) {
            	System.out.println("count "+i);
                String forUser = raf.readLine().substring(9);
                String forPswd = raf.readLine().substring(9);
                if(usr.equals(forUser) & pswd.equals(forPswd)){
                	wrongpswdindicator.hide();
                	MainBoardFrm.setAuth(true);
                	MainBoardFrm.setLISOPanel();
                	System.out.println("seted");
                        loginButton.setVisible(false);
        	        signOutButton.setVisible(true);
                        clearButton.setVisible(true);
                    break;
                }else if(i==(ln-2)){
                	wrongpswdindicator.show();
                	MainBoardFrm.setAuth(false);
                	MainBoardFrm.setLISOPanel();
                    break;
                }
                raf.readLine();
            }
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(LISOpanel.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(LISOpanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void countLines(){
        try {
            ln=0;
            RandomAccessFile raf = new RandomAccessFile(acc+"\\account.txt", "rws");
            while(raf.readLine()!=null){
                ln++;
            }
            System.out.println("number of lines:"+ln);
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(LISOpanel.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(LISOpanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void clearFile(){
        try {
            FileWriter fw = new FileWriter(acc+"\\account.txt");
            JOptionPane.showMessageDialog(null, "Cleared");
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(LISOpanel.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(LISOpanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    

// ======================================================== Button handling ==========================================================//
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	//----------------------Login button----------------------//
        if (e.getSource() == loginButton) {
        	createFolder(); 
        	readFile();
        	countLines();
        	authentication(userTextField.getText(), passwordField.getText());
        }
        
        if(e.getSource() == signOutButton) {
        	MainBoardFrm.setAuth(false);
        	MainBoardFrm.setLISOPanel();
        	loginButton.setVisible(true);
        	signOutButton.setVisible(false);
                clearButton.setVisible(false);
        }
        
        
        ////----------------------Show password button----------------------//
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
        
        
        ///----------------------Register button----------------------//
        if (e.getSource() == registerButton) {
        	createFolder(); 
        	readFile();
        	countLines();
        	addData(userTextField.getText(),passwordField.getText());
        	countLines();
                JOptionPane.showMessageDialog(null, "Registered");
        }
        if (e.getSource() == clearButton) {
            clearFile();
        }
    }
    /*void scaleLISOPanel() {
    	int panelWidth = MainBoardFrm.frameWidth - 16;
    	int panelHeight = MainBoardFrm.frameHeight - 74;
    	System.out.println(panelWidth);
    	System.out.println(panelHeight);
    	
    	int titleX = (int)Math.round(panelWidth*0.21);
    	int titleY = (int)Math.round(panelHeight*0.08);
    	int titleWidth = (int)Math.round(panelWidth*0.57);
    	int titleHeight = (int)Math.round(panelHeight*0.11);
    	
    	
    	int holderX = (int)Math.round(panelWidth*0.21);
    	int holderY = (int)Math.round(panelHeight*0.19);
    	int holderWidth = (int)Math.round(panelWidth*0.57);
    	int holderHeight = (int)Math.round(panelHeight*0.70);
    	
    	
    	int labelX = (int)Math.round(panelWidth*0.05);
    	int labelY = (int)Math.round(panelHeight*0.07);
    	int labelY2 = (int)Math.round(panelHeight*0.17);
    	int labelWidth = (int)Math.round(panelWidth*0.13);
    	int labelHeight = (int)Math.round(panelHeight*0.06);
        
        
        int fieldX = (int)Math.round(panelWidth*0.17);
    	int fieldY = (int)Math.round(panelHeight*0.07);
    	int fieldY2 = (int)Math.round(panelHeight*0.17);
    	int fieldWidth = (int)Math.round(panelWidth*0.34);
    	int fieldHeight = (int)Math.round(panelHeight*0.06);
        
        
        int sPX = (int)Math.round(panelWidth*0.18);
    	int sPY = (int)Math.round(panelHeight*0.23);
    	int sPWidth = (int)Math.round(panelWidth*0.2);
    	int sPHeight = (int)Math.round(panelHeight*0.05);
        
        
        int wPX = (int)Math.round(panelWidth*0.37);
    	int wPY = (int)Math.round(panelHeight*0.23);
    	int wPWidth = (int)Math.round(panelWidth*0.38);
    	int wPHeight = (int)Math.round(panelHeight*0.06);
        
        
        int lisoX = (int)Math.round(panelWidth*0.05);
    	int lisoY = (int)Math.round(panelHeight*0.29);
    	int lisoWidth = (int)Math.round(panelWidth*0.46);
    	int lisoHeight = (int)Math.round(panelHeight*0.07);
        
        
        int resX = (int)Math.round(panelWidth*0.38);
    	int resY = (int)Math.round(panelHeight*0.37);
    	int resWidth = (int)Math.round(panelWidth*0.13);
    	int resHeight = (int)Math.round(panelHeight*0.06);
        
        if(panelWidth > 0 && panelHeight > 0) {
        	title.setBounds(titleX, titleY, titleWidth, titleHeight);
        	holder.setBounds(holderX, holderY, holderWidth, holderHeight);
        	userLabel.setBounds(labelX, labelY, labelWidth, labelHeight);
            passwordLabel.setBounds(labelX, labelY2, labelWidth, labelHeight);
        	userTextField.setBounds(fieldX, fieldY, fieldWidth, fieldHeight);
            passwordField.setBounds(fieldX, fieldY2, fieldWidth, fieldHeight);
        	showPassword.setBounds(sPX, sPY, sPWidth, sPHeight);
        	wrongpswdindicator.setBounds(wPX, wPY, wPWidth, wPHeight);
        	loginButton.setBounds(lisoX, lisoY, lisoWidth, lisoHeight);
            signOutButton.setBounds(lisoX, lisoY, lisoWidth, lisoHeight);
        	registerButton.setBounds(resX, resY, resWidth, resHeight);
    	}
        
    }
    */
    
}