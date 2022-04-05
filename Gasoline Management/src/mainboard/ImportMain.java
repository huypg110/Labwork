/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mainboard;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author Admin
 */
public class ImportMain extends javax.swing.JPanel {
    private ArrayList<Import>imports;
    private DefaultListModel listImportModel;
    
    

    /**
     * Creates new form ImportMain
     */
    public ImportMain() {
        initComponents();
        imports = new ArrayList<Import>(); 
        listImportModel = new DefaultListModel(); 
        jList2.setModel(listImportModel);
        flatui();
    }
    public void flatui(){
        JProgressBar[] ProgressBars = { jGasoline2,jDiesel2,jHydraulic2,jLubrocant2 };
         for (JProgressBar ProgressBar : ProgressBars) 
             {
                 ProgressBar.setUI(new BasicProgressBarUI());
                 ProgressBar.setStringPainted(true);
                 ProgressBar.setForeground(new java.awt.Color(102,102,102));
                 UIManager.put("ProgressBar.selectionForeground", Color.white);
                 UIManager.put("ProgressBar.selectionBackground", Color.black);
             }
         jGasoline2.setUI(new BasicProgressBarUI());
         jGasoline2.setStringPainted(true);
         jGasoline2.setForeground(new java.awt.Color(102,102,102));
         UIManager.put("jGasoline1.selectionForeground", Color.white);
         UIManager.put("jGasoline1.selectionBackground", Color.black);
     JButton [] btns = { btnProceed2,btnXuat2};
       
        
        for (JButton btn : btns) {
            btn.setBackground(new Color(44,44,44));
            btn.setUI(new BasicButtonUI());
            btn.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                     btn.setBackground(new Color(61,59,59)); 
                }

                @Override
                public void mouseExited(MouseEvent e) {
                     btn.setBackground(new Color(44,44,44));
                }
            } );
        
     
    }
    }
    public void addimport(){
         Import i = new Import(
                   txtSeller2.getText(),
                   txtDate2.getText(),
                   jComboBox2.getSelectedItem().toString(),
                   txtAmount2.getText(),
                   txtPricePerLiter2.getText(),
                   txtTotalPrice2.getText()
                );
                imports.add(i);
                refreshImportList();
    }
    public void refreshImportList(){
        listImportModel.removeAllElements();
        System.out.println("Remove");  
        for(Import i : imports){
            System.out.println("Add:"+i.getSeller2());
            System.out.println("Add:"+i.getDate2());
            System.out.println("Add:"+i.getType2());
            System.out.println("Add:"+i.getAmount2());  
            System.out.println("Add:"+i.getPricePerLiter2());
            System.out.println("Add:"+i.getTotalPrice2());
            
            listImportModel.addElement("Name:"+i.getSeller2());
            listImportModel.addElement("Date:"+i.getDate2());
            listImportModel.addElement("Type:"+i.getType2());
            listImportModel.addElement("Amount:"+i.getAmount2());
            listImportModel.addElement("Price per Liter:"+i.getPricePerLiter2());
            listImportModel.addElement("Total price:"+i.getTotalPrice2());
            listImportModel.addElement("----------");
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBounds(160,40,540,460);
        jSeller2 = new javax.swing.JLabel();
        jDate2 = new javax.swing.JLabel();
        jType2 = new javax.swing.JLabel();
        jAmount2 = new javax.swing.JLabel();
        jPricePerLiter2 = new javax.swing.JLabel();
        jTotalPrice2 = new javax.swing.JLabel();
        txtSeller2 = new javax.swing.JTextField();
        txtDate2 = new javax.swing.JTextField();
        txtAmount2 = new javax.swing.JTextField();
        txtPricePerLiter2 = new javax.swing.JTextField();
        txtTotalPrice2 = new javax.swing.JTextField();
        jComboBox2 = new Combobox();
        btnProceed2 = new javax.swing.JButton();
        btnXuat2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jDieselName2 = new javax.swing.JLabel();
        jDiesel2 = new javax.swing.JProgressBar();
        jLubrocantName2 = new javax.swing.JLabel();
        jLubrocant2 = new javax.swing.JProgressBar();
        jHydraulicName2 = new javax.swing.JLabel();
        jHydraulic2 = new javax.swing.JProgressBar();
        jGasolineName2 = new javax.swing.JLabel();
        jGasoline2 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        
        jPanel1.setBounds(0,3,160,460);
        jList2.setBounds(13,10,150,400);
        jPanel1.add(jList2);
        jPanel1.setBackground(new java.awt.Color(241, 242, 251));
        jPanel1.setLayout(null);
        
        jSeller2.setBounds(40,55,80,30);
        jDate2.setBounds(40,95,80,30);
        jType2.setBounds(40,135,80,30);
        jAmount2.setBounds(40,175,80,30); 
        jPricePerLiter2.setBounds(40,215,100,30); 
        jTotalPrice2.setBounds(40,255,80,30);
        txtSeller2.setBounds(140,55,260,30);
        txtDate2.setBounds(140,95,260,30);
        jComboBox2.setBounds(140,135,260,30);
        txtAmount2.setBounds(140,175,260,30);
        txtPricePerLiter2.setBounds(140,215,260,30);
        txtTotalPrice2.setBounds(140,255,260,30);
        btnXuat2.setBounds(40,300,163,35);
        btnProceed2.setBounds(380,300,100,35);

        jGasolineName2.setBounds(0,53,145,16);
        jDieselName2.setBounds(0,132,145,16);
        jLubrocantName2.setBounds(0,212,145,16);
        jHydraulicName2.setBounds(0,292,145,16);
        
        jGasoline2.setBounds(0,88,145,27);
        jDiesel2.setBounds(0,165,145,27);
        jLubrocant2.setBounds(0,243,145,27);
        jHydraulic2.setBounds(0,323,145,27);
        
        setBackground(new java.awt.Color(241, 242, 251));
        setLayout(null);
        setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        setBounds(0,0,800,600);
        //setBackground(Color.LIGHT_GRAY);

        jPanel2.setBackground(new java.awt.Color(241, 242, 251));

        jSeller2.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        jSeller2.setText("Seller");

        jDate2.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        jDate2.setText("Date");

        jType2.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        jType2.setText("Type");

        jAmount2.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        jAmount2.setText("Amount");

        jPricePerLiter2.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        jPricePerLiter2.setText("Price per liter");

        jTotalPrice2.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        jTotalPrice2.setText("Total price");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasoline", "Diesel", "Lubrocant", "Hydraulic" }));

        txtAmount2.getDocument().addDocumentListener(new DocumentListener() {
        	public void changedUpdate(DocumentEvent e) {
        		warn();
      	  	}
      	  	public void removeUpdate(DocumentEvent e) {
      	  		warn();
      	  	}
      	  	public void insertUpdate(DocumentEvent e) {
      	  		warn();
      	  	}

      	  	public void warn() {
      	  		if(txtAmount2.getText().trim().isEmpty() || txtPricePerLiter2.getText().trim().isEmpty()) {
      	  			txtTotalPrice2.setText("0");
      	  		}
      	  		else {
      	  			int amount = Integer.parseInt(txtAmount2.getText());
  	  				int pricePerLiter = Integer.parseInt(txtPricePerLiter2.getText());
  	  				String totalPrice = String.valueOf(amount*pricePerLiter);
  	  				txtTotalPrice2.setText(totalPrice);
      	  		}
      	  	}
        });
        
        txtPricePerLiter2.getDocument().addDocumentListener(new DocumentListener() {
        	public void changedUpdate(DocumentEvent e) {
        		warn();
      	  	}
      	  	public void removeUpdate(DocumentEvent e) {
      	  		warn();
      	  	}
      	  	public void insertUpdate(DocumentEvent e) {
      	  		warn();
      	  	}

      	  	public void warn() {
      	  		if(txtAmount2.getText().trim().isEmpty() || txtPricePerLiter2.getText().trim().isEmpty()) {
      	  			txtTotalPrice2.setText("0");
      	  		}
      	  		else {
      	  			int amount = Integer.parseInt(txtAmount2.getText());
	  				int pricePerLiter = Integer.parseInt(txtPricePerLiter2.getText());
	  				String totalPrice = String.valueOf(amount*pricePerLiter);
	  				txtTotalPrice2.setText(totalPrice);
      	  		}
      	  	}
        });
       
        btnProceed2.setText("Proceed");
        btnProceed2.setForeground(new java.awt.Color(240, 240, 240));
        btnProceed2.setFont(new java.awt.Font("Morn-Regular", 1, 13));
        btnProceed2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceed2ActionPerformed(evt);
            }
        });
        btnXuat2.setForeground(new java.awt.Color(240, 240, 240));
        btnXuat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuat2ActionPerformed(evt);
            }
        });
        btnXuat2.setFont(new java.awt.Font("Morn-Regular", 1, 13));
        btnXuat2.setText("Export to txt");
        
        jPanel2.add(btnXuat2);
        jPanel2.add(btnProceed2);
        jPanel2.add(jSeller2);
        jPanel2.add(jDate2);
        jPanel2.add(jType2);
        jPanel2.add(jTotalPrice2);
        jPanel2.add(jPricePerLiter2);
        jPanel2.add(jAmount2);
        jPanel2.add(txtTotalPrice2);
        jPanel2.add(txtPricePerLiter2);
        jPanel2.add(txtSeller2);
        jPanel2.add(txtDate2);
        jPanel2.add(txtAmount2);
        jPanel2.add(jComboBox2);
        jPanel2.setBounds(160,40,540,460);
        jPanel2.setLayout(null);
                
        

        jPanel3.setBackground(new java.awt.Color(241, 242, 251));

        jDieselName2.setText("Diesel:");
        jDieselName2.setFont(new java.awt.Font("Morn-Regular", 0, 13));

        jDiesel2.setBackground(new java.awt.Color(255, 255, 255));
        jDiesel2.setForeground(new java.awt.Color(0, 204, 51));
        jDiesel2.setMaximum(1000);
        jDiesel2.setValue(1000);
        jDiesel2.setString("1000");
        jDiesel2.setStringPainted(true);

        jLubrocantName2.setText("Lubricant:");
        jLubrocantName2.setFont(new java.awt.Font("Morn-Regular", 0, 13));
        jLubrocant2.setBackground(new java.awt.Color(255, 255, 255));
        jLubrocant2.setForeground(new java.awt.Color(0, 204, 51));
        jLubrocant2.setMaximum(1000);
        jLubrocant2.setValue(1000);
        jLubrocant2.setString("1000");
        jLubrocant2.setStringPainted(true);

        jHydraulicName2.setText("Hydraulic");
        jHydraulicName2.setFont(new java.awt.Font("Morn-Regular", 0, 13));
        jHydraulic2.setBackground(new java.awt.Color(255, 255, 255));
        jHydraulic2.setForeground(new java.awt.Color(0, 204, 51));
        jHydraulic2.setMaximum(1000);
        jHydraulic2.setValue(1000);
        jHydraulic2.setString("1000");
        jHydraulic2.setStringPainted(true);

        jGasolineName2.setText("Gasoline:");
        jGasolineName2.setFont(new java.awt.Font("Morn-Regular", 0, 13));

        jGasoline2.setBackground(new java.awt.Color(255, 255, 255));
        jGasoline2.setForeground(new java.awt.Color(0, 204, 51));
        jGasoline2.setMaximum(1000);
        jGasoline2.setValue(1000);
        jGasoline2.setString("1000");
        jGasoline2.setStringPainted(true);

        jPanel3.add(jHydraulic2); 
        jPanel3.add(jLubrocant2);
        jPanel3.add(jLubrocantName2);
        jPanel3.add(jHydraulicName2);
        jPanel3.add(jDiesel2);
        jPanel3.add(jDieselName2);
        jPanel3.add(jGasolineName2);
        jPanel3.add(jGasoline2);
        jPanel3.setBounds(700,40,200,460);
        jPanel3.setLayout(null);

        jScrollPane1.setViewportView(jList2);

        /*javax.swing.GroupLayout layout = new javax.swing.GroupLayout();
        //setLayout(layout);
        setHorizontalGroup(
            ImportMain.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        //pack();
         * 
        */
        add(jScrollPane1);
        add(jPanel2);
        add(jPanel3);
        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnXuat2ActionPerformed(java.awt.event.ActionEvent evt) {
    	createFolder();
        try {
            readImportFile();
        } catch (IOException ex) {
            Logger.getLogger(MainBoardFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
        countLines();
        addData(txtSeller2.getText(),txtDate2.getText(),jComboBox2.getSelectedItem().toString(),txtAmount2.getText(),txtPricePerLiter2.getText(),txtTotalPrice2.getText());
        JOptionPane.showMessageDialog(null,"Xuat Thanh Cong!");
    }
    
    private void btnProceed2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceed2ActionPerformed

        Import i = new Import(
                   txtSeller2.getText(),
                   txtDate2.getText(),
                   jComboBox2.getSelectedItem().toString(),     //NOTED FOR FIXING
                   txtAmount2.getText(),
                   txtPricePerLiter2.getText(),
                   txtTotalPrice2.getText()
                );
                imports.add(i);
                refreshImportList();

        if(jComboBox2.getSelectedItem().toString().equalsIgnoreCase("Gasoline")){
            if(ExportMain.Gasoline1 >= 0 && ExportMain.Gasoline1 + Integer.valueOf(txtAmount2.getText()) <= 1000   )
            {   ExportMain.Gasoline1  = ExportMain.Gasoline1  +  Integer.valueOf(txtAmount2.getText());
                jGasoline2.setValue(ExportMain.Gasoline1);
                jGasoline2.setString(Integer.toString(ExportMain.Gasoline1));
            }
            else
            {
                JOptionPane.showMessageDialog(null,"The tank is full now!");
            }
        }
        else if(jComboBox2.getSelectedItem().toString().equalsIgnoreCase("Diesel")){
            if(ExportMain.Diesel1 >= 0 && ExportMain.Diesel1 + Integer.valueOf(txtAmount2.getText()) <= 1000)
            {   ExportMain.Diesel1  = ExportMain.Diesel1  +  Integer.valueOf(txtAmount2.getText());
                jDiesel2.setValue(ExportMain.Diesel1);
                jDiesel2.setString(Integer.toString(ExportMain.Diesel1));
            }
            else
            {
                JOptionPane.showMessageDialog(null,"The tank is full now!");
            }
        }
        else if(jComboBox2.getSelectedItem().toString().equalsIgnoreCase("Lubrocant")){
            if(ExportMain.Lubrocant1 >= 0 && ExportMain.Lubrocant1 + Integer.valueOf(txtAmount2.getText()) <= 1000)
            {   ExportMain.Lubrocant1  = ExportMain.Lubrocant1  +  Integer.valueOf(txtAmount2.getText());
                jLubrocant2.setValue(ExportMain.Lubrocant1);
                jLubrocant2.setString(Integer.toString(ExportMain.Lubrocant1));
            }
            else
            {
                JOptionPane.showMessageDialog(null,"The tank is full now!");
            }
        }
        else{
            if(ExportMain.Hydraulic1 >= 0 && ExportMain.Hydraulic1 + Integer.valueOf(txtAmount2.getText()) <= 1000)
            {   ExportMain.Hydraulic1  = ExportMain.Hydraulic1  +  Integer.valueOf(txtAmount2.getText());
                jHydraulic2.setValue(ExportMain.Hydraulic1);
                jHydraulic2.setString(Integer.toString(ExportMain.Hydraulic1));
            }
            else
            {
                JOptionPane.showMessageDialog(null,"The tank is full now!");
            }
        }
    }//GEN-LAST:event_btnProceed2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImportMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProceed2;
    private javax.swing.JButton btnXuat2;
    private javax.swing.JLabel jAmount2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jDate2;
    public static  javax.swing.JProgressBar jDiesel2;
    private javax.swing.JLabel jDieselName2;
    public static  javax.swing.JProgressBar jGasoline2;
    private javax.swing.JLabel jGasolineName2;
    public static  javax.swing.JProgressBar jHydraulic2;
    private javax.swing.JLabel jHydraulicName2;
    private javax.swing.JList<String> jList2;
    public static  javax.swing.JProgressBar jLubrocant2;
    private javax.swing.JLabel jLubrocantName2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jPricePerLiter2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jSeller2;
    private javax.swing.JLabel jTotalPrice2;
    private javax.swing.JLabel jType2;
    private javax.swing.JTextField txtAmount2;
    private javax.swing.JTextField txtDate2;
    private javax.swing.JTextField txtPricePerLiter2;
    private javax.swing.JTextField txtSeller2;
    private javax.swing.JTextField txtTotalPrice2;
    // End of variables declaration//GEN-END:variables
    
    public void valueChanged(ListSelectionEvent e) {
        int item = jList2.getSelectedIndex();
        if(item >= 0){
            Import i = imports.get(item);
                    txtSeller2.setText(i.getSeller2());
                    txtDate2.setText(i.getDate2().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    txtAmount2.setText(i.getAmount2());
                    txtPricePerLiter2.setText(i.getPricePerLiter2());
                    txtTotalPrice2.setText(i.getTotalPrice2());
                    
        }           
    }
    
    String resource = System.getProperty("user.resource");
    File f = new File("resource\\Oil\\Import"); //tao file 
    int ln;
    
    void createFolder(){
        if(!f.exists()){
        f.mkdirs();
        }
    }
    
    void readImportFile() throws IOException{
        try {
            FileReader fr = new FileReader(f+"\\FileImportText.txt");
            System.out.println("file exists!");
           
            
        } catch(FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f+"\\FileImportText.txt");
                System.out.println("File created");
                RandomAccessFile wrtf = new RandomAccessFile(f+"\\FileImportText.txt", "rw");
                wrtf.writeBytes("Time,Seller,Type,Amount,Price per liter,Total Price \r\n");
            } catch (IOException ex1) {
                Logger.getLogger(MainBoardFrm.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
    }
    void addData(String usr,String dat,String typ,String quant,String price, String total){   // nhÆ¡ doi
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\FileImportText.txt", "rw");
            for(int i=0;i<ln;i++){
                raf.readLine();
            }
         
            
            raf.writeBytes(dat+ ";");
            raf.writeBytes(usr+";");
            
            raf.writeBytes(typ+ ";");
            raf.writeBytes(quant+"L"+ ";");
            raf.writeBytes(price+" vnd"+ ";");
            raf.writeBytes(total+" vnd"+"\r\n");
        } catch(FileNotFoundException ex) {
            Logger.getLogger(MainBoardFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException ex) {
            Logger.getLogger(MainBoardFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     void countLines(){
        try {
            ln=0;
            RandomAccessFile raf = new RandomAccessFile(f+"\\FileImportText.txt", "rw");
            for(int i=0;raf.readLine()!=null;i++){
                ln++;
            }
            System.out.println("number of lines:"+ln);
        } catch(FileNotFoundException ex){
            Logger.getLogger(MainBoardFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException ex){
            Logger.getLogger(MainBoardFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

