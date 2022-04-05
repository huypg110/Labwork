/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mainboard;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author HUY
 */
public class ExportMain extends javax.swing.JPanel implements ListSelectionListener {

    private ArrayList<Export>export;
    private DefaultListModel listExportModel;
    public static int Gasoline1 = 1000; /////So luong xang tung loai
    public static int Diesel1 = 1000;
    public static int Lubrocant1 = 1000;
    public static int Hydraulic1 = 1000;
    
    public ExportMain() {
        initComponents();
        export = new ArrayList<Export>(); ///// tao array list
        listExportModel = new DefaultListModel(); //// tao obj cho DefaultListModel
        jList1.setModel(listExportModel);
        flatui();
    }
    public void flatui(){
        JProgressBar[] ProgressBars = { jGasoline1,jDiesel1,jHydraulic1,jLubrocant1 };
         for (JProgressBar ProgressBar : ProgressBars) 
             {
                 ProgressBar.setUI(new BasicProgressBarUI());
                 ProgressBar.setStringPainted(true);
                 ProgressBar.setForeground(new java.awt.Color(102,102,102));
                 UIManager.put("ProgressBar.selectionForeground", Color.white);
                 UIManager.put("ProgressBar.selectionBackground", Color.black);
             }
         jGasoline1.setUI(new BasicProgressBarUI());
         jGasoline1.setStringPainted(true);
         jGasoline1.setForeground(new java.awt.Color(102,102,102));
         UIManager.put("jGasoline1.selectionForeground", Color.white);
         UIManager.put("jGasoline1.selectionBackground", Color.black);
     JButton [] btns = { btnProceed1,btnXuat1};
       
        
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
   
    public void addexport(){
         Export p = new Export(
                    txtName1.getText(),
                    txtDate1.getText(),
                    jComboBox1.getSelectedItem().toString(),     //NOTED FOR FIXING
                    txtAmount1.getText(),
                    txtPricePerLiter1.getText(),
                    txtTotalPrice1.getText()
                );
                export.add(p);
                refreshExportList();
    }
    public void refreshExportList(){
        listExportModel.removeAllElements();
        System.out.println("Remove");  
        for(Export p : export){
            System.out.println("Add:"+p.getName());
            System.out.println("Add:"+p.getDate());
            System.out.println("Add:"+p.getType());
            System.out.println("Add:"+p.getAmount());  
            System.out.println("Add:"+p.getPricePerLiter());
            System.out.println("Add:"+p.getTotalPrice());
            
            listExportModel.addElement("Name:"+p.getName());
            listExportModel.addElement("Date:"+p.getDate());
            listExportModel.addElement("Type:"+p.getType());
            listExportModel.addElement("Amount:"+p.getAmount());
            listExportModel.addElement("Price per Liter:"+p.getPricePerLiter());
            listExportModel.addElement("Total price:"+p.getTotalPrice());
            listExportModel.addElement("----------");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jDieselName1 = new javax.swing.JLabel();
        jDiesel1 = new javax.swing.JProgressBar();
        jLubrocantName1 = new javax.swing.JLabel();
        jLubrocant1 = new javax.swing.JProgressBar();
        jHydraulicName1 = new javax.swing.JLabel();
        jHydraulic1 = new javax.swing.JProgressBar();
        jGasolineName1 = new javax.swing.JLabel();
        jGasoline1 = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        jBuyer1 = new javax.swing.JLabel();
        jDate1 = new javax.swing.JLabel();
        jType1 = new javax.swing.JLabel();
        jAmount1 = new javax.swing.JLabel();
        jPricePerLiter1 = new javax.swing.JLabel();
        jTotalPrice1 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        txtDate1 = new javax.swing.JTextField();
        txtAmount1 = new javax.swing.JTextField();
        txtPricePerLiter1 = new javax.swing.JTextField();
        txtTotalPrice1 = new javax.swing.JTextField();
        jComboBox1 = new Combobox();
        btnCalculate1 = new javax.swing.JButton();
        btnProceed1 = new javax.swing.JButton();
        btnXuat1 = new javax.swing.JButton();
        jPanel1.setBounds(0,3,160,460);
        jBuyer1.setBounds(40,55,80,30);
        jDate1.setBounds(40,95,80,30);
        jType1.setBounds(40,135,80,30);
        jAmount1.setBounds(40,175,80,30); 
        jPricePerLiter1.setBounds(40,215,100,30); 
        jTotalPrice1.setBounds(40,255,100,30);
        txtName1.setBounds(140,55,260,30);
        txtDate1.setBounds(140,95,260,30);
        jComboBox1.setBounds(140,135,260,30);
        txtAmount1.setBounds(140,175,260,30);
        txtPricePerLiter1.setBounds(140,215,260,30);
        txtTotalPrice1.setBounds(140,255,260,30);
        btnXuat1.setBounds(40,300,163,35);
        btnProceed1.setBounds(380,300,100,35);
        jList1.setBounds(13,10,150,400);
       

        jGasolineName1.setBounds(0,53,145,16);
        jDieselName1.setBounds(0,132,145,16);
        jLubrocantName1.setBounds(0,212,145,16);
        jHydraulicName1.setBounds(0,292,145,16);
        
        jGasoline1.setBounds(0,88,145,27);
        jDiesel1.setBounds(0,165,145,27);
        jLubrocant1.setBounds(0,243,145,27);
        jHydraulic1.setBounds(0,323,145,27);
        
        setBackground(new java.awt.Color(241, 242, 251));
        setLayout(null);
        setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        setBounds(0,0,800,600);
        //setBackground(Color.LIGHT_GRAY);

        jPanel1.setBackground(new java.awt.Color(241, 242, 251));

        jScrollPane1.setViewportView(jList1);
        
        jPanel1.add(jScrollPane1);
        
        jPanel1.setLayout(null);
        jPanel1.add(jList1);

        jPanel3.setBackground(new java.awt.Color(241, 242, 251));

        jDieselName1.setText("Diesel:");
       jDieselName1.setFont(new java.awt.Font("Morn-Regular", 0, 13));

        jDiesel1.setBackground(new java.awt.Color(255, 255, 255));
        jDiesel1.setForeground(new java.awt.Color(0, 204, 51));
        jDiesel1.setMaximum(1000);
        jDiesel1.setValue(1000);
        jDiesel1.setString("1000");
        jDiesel1.setStringPainted(true);

        jLubrocantName1.setText("Lubricant:");
         jLubrocantName1.setFont(new java.awt.Font("Morn-Regular", 0, 13));

        jLubrocant1.setBackground(new java.awt.Color(255, 255, 255));
        jLubrocant1.setForeground(new java.awt.Color(0, 204, 51));
        jLubrocant1.setMaximum(1000);
        jLubrocant1.setValue(1000);
        jLubrocant1.setString("1000");
        jLubrocant1.setStringPainted(true);

        jHydraulicName1.setText("Hydraulic:");
        jHydraulicName1.setFont(new java.awt.Font("Morn-Regular", 0, 13));

        jHydraulic1.setBackground(new java.awt.Color(255, 255, 255));
        jHydraulic1.setForeground(new java.awt.Color(0, 204, 51));
        jHydraulic1.setMaximum(1000);
        jHydraulic1.setValue(1000);
        jHydraulic1.setString("1000");
        jHydraulic1.setStringPainted(true);

        jGasolineName1.setText("Gasoline:");
        jGasolineName1.setFont(new java.awt.Font("Morn-Regular", 0, 13));

        jGasoline1.setBackground(new java.awt.Color(255, 255, 255));
        jGasoline1.setForeground(new java.awt.Color(0, 204, 51));
        jGasoline1.setMaximum(1000);
        jGasoline1.setValue(1000);
        jGasoline1.setString("1000");
        jGasoline1.setStringPainted(true);

        jPanel3.add(jLubrocantName1);
        jPanel3.add(jLubrocant1);
        jPanel3.add(jDiesel1);
        jPanel3.add(jDieselName1);
        jPanel3.add(jGasoline1);
        jPanel3.add(jGasolineName1);
        jPanel3.add(jHydraulicName1);
        jPanel3.add(jHydraulic1);
        jPanel3.setBounds(700,40,200,460);
        jPanel3.setLayout(null);
                
        jPanel2.setBackground(new java.awt.Color(241, 242, 251));

        jBuyer1.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        jBuyer1.setText("Buyer");

        jDate1.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        jDate1.setText("Date");

        jType1.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        jType1.setText("Type");

        jAmount1.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        jAmount1.setText("Amount");

        jPricePerLiter1.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        jPricePerLiter1.setText("Price per liter");

        jTotalPrice1.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        jTotalPrice1.setText("Total price");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasoline", "Diesel", "Lubrocant", "Hydraulic" }));

       txtAmount1.getDocument().addDocumentListener(new DocumentListener() {
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
      	  		if(txtAmount1.getText().trim().isEmpty() || txtPricePerLiter1.getText().trim().isEmpty()) {
      	  			txtTotalPrice1.setText("0");
      	  		}
      	  		else {
      	  			int amount = Integer.parseInt(txtAmount1.getText());
  	  				int pricePerLiter = Integer.parseInt(txtPricePerLiter1.getText());
  	  				String totalPrice = String.valueOf(amount*pricePerLiter);
  	  				txtTotalPrice1.setText(totalPrice);
      	  		}
      	  	}
        });
        
        txtPricePerLiter1.getDocument().addDocumentListener(new DocumentListener() {
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
      	  		if(txtAmount1.getText().trim().isEmpty() || txtPricePerLiter1.getText().trim().isEmpty()) {
      	  			txtTotalPrice1.setText("0");
      	  		}
      	  		else {
      	  			int amount = Integer.parseInt(txtAmount1.getText());
	  				int pricePerLiter = Integer.parseInt(txtPricePerLiter1.getText());
	  				String totalPrice = String.valueOf(amount*pricePerLiter);
	  				txtTotalPrice1.setText(totalPrice);
      	  		}
      	  	}
        });
        btnProceed1.setForeground(new java.awt.Color(240, 240, 240));
        btnProceed1.setText("Proceed");
        btnProceed1.setFont(new java.awt.Font("Morn-Regular", 1, 13));
        btnProceed1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceed1ActionPerformed(evt);
            }
        });
         btnXuat1.setForeground(new java.awt.Color(240, 240, 240));
        btnXuat1.setText("Export to txt");
        btnXuat1.setFont(new java.awt.Font("Morn-Regular", 1, 13));
        btnXuat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuat1ActionPerformed(evt);
            }
        });

        jPanel2.add(btnXuat1);
        jPanel2.add(jAmount1);
        jPanel2.add(jDate1);
        jPanel2.add(jType1);
        jPanel2.add(jTotalPrice1);
        jPanel2.add(jPricePerLiter1);
        jPanel2.add(jBuyer1);
        jPanel2.add(txtTotalPrice1);
        jPanel2.add(txtPricePerLiter1);
        jPanel2.add(txtName1);
        jPanel2.add(txtDate1);
        jPanel2.add(txtAmount1);
        jPanel2.add(jComboBox1);
        jPanel2.add(btnCalculate1);
        jPanel2.add(btnProceed1);
        jPanel2.setBounds(160,40,540,460);
        jPanel2.setLayout(null);

        add(jPanel1);
        add(jPanel2);
        add(jPanel3);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProceed1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceed1ActionPerformed
      
       
                
        if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Gasoline")){
            if(Gasoline1 > 0 && Gasoline1 - Integer.valueOf(txtAmount1.getText()) > 0)
            {   Gasoline1  = Gasoline1  -  Integer.valueOf(txtAmount1.getText());
                jGasoline1.setValue(Gasoline1);
                jGasoline1.setString(Integer.toString(Gasoline1));
                addexport();
            }  
            else
            {
                JOptionPane.showMessageDialog(null,"Insufficient gas ");
            }
        }
        else if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Diesel")){
            if(Diesel1 > 0 && Diesel1 - Integer.valueOf(txtAmount1.getText()) > 0)
            {   Diesel1  = Diesel1  -  Integer.valueOf(txtAmount1.getText());
                jDiesel1.setValue(Diesel1);
                jDiesel1.setString(Integer.toString(Diesel1));
             addexport();
            }  
            else
            {
                JOptionPane.showMessageDialog(null,"Insufficient gas ");
            }
        }
        else if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Lubrocant")){
            if(Lubrocant1 > 0 && Lubrocant1 - Integer.valueOf(txtAmount1.getText()) > 0)
            {   Lubrocant1  = Lubrocant1  -  Integer.valueOf(txtAmount1.getText());
                jLubrocant1.setValue(Lubrocant1);
                jLubrocant1.setString(Integer.toString(Lubrocant1));
             addexport();
            }  
            else
            {
                JOptionPane.showMessageDialog(null,"Insufficient gas ");
            }
        }
        else{
            if(Hydraulic1 > 0 && Hydraulic1 - Integer.valueOf(txtAmount1.getText()) > 0)
            {   Hydraulic1  = Hydraulic1  -  Integer.valueOf(txtAmount1.getText());
                jHydraulic1.setValue(Hydraulic1);
                jHydraulic1.setString(Integer.toString(Hydraulic1));
             addexport();
            }  
            else
            {
                JOptionPane.showMessageDialog(null,"Insufficient gas ");
            } 
        }
    }//GEN-LAST:event_btnProceed1ActionPerformed

    private void btnCalculate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculate1ActionPerformed
        int amount = Integer.parseInt(txtAmount1.getText());
        int pricePerLiter = Integer.parseInt(txtPricePerLiter1.getText());
        
        String totalPrice = String.valueOf(amount*pricePerLiter);
        txtTotalPrice1.setText(totalPrice);
    }//GEN-LAST:event_btnCalculate1ActionPerformed

    private void btnXuat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuat1ActionPerformed
        // TODO add your handling code here:
        createFolder();
        try {
            readImportFile();
        } catch (IOException ex) {
            Logger.getLogger(MainBoardFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
        countLines();
        addData(txtName1.getText(),txtDate1.getText(),jComboBox1.getSelectedItem().toString(),txtAmount1.getText(),txtPricePerLiter1.getText(),txtTotalPrice1.getText());
        JOptionPane.showMessageDialog(null,"Xuat Thanh Cong!");
    }//GEN-LAST:event_btnXuat1ActionPerformed

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
            java.util.logging.Logger.getLogger(ExportMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExportMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExportMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExportMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExportMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate1;
    private javax.swing.JButton btnProceed1;
    private javax.swing.JButton btnXuat1;
    private javax.swing.JLabel jAmount1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jDate1;
    public static javax.swing.JProgressBar jDiesel1;
    private javax.swing.JLabel jDieselName1;
    public static javax.swing.JProgressBar jGasoline1;
    private javax.swing.JLabel jGasolineName1;
    public static javax.swing.JProgressBar jHydraulic1;
    private javax.swing.JLabel jHydraulicName1;
    private javax.swing.JList<String> jList1;
    public static javax.swing.JProgressBar jLubrocant1;
    private javax.swing.JLabel jLubrocantName1;
    private javax.swing.JLabel jBuyer1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jPricePerLiter1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTotalPrice1;
    private javax.swing.JLabel jType1;
    private javax.swing.JTextField txtAmount1;
    private javax.swing.JTextField txtDate1;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtPricePerLiter1;
    private javax.swing.JTextField txtTotalPrice1;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int item = jList1.getSelectedIndex();
        if(item >= 0){
            Export p = export.get(item);
                    txtName1.setText(p.getName());
                    txtDate1.setText(p.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    txtAmount1.setText(p.getAmount());
                    txtPricePerLiter1.setText(p.getPricePerLiter());
                    txtTotalPrice1.setText(p.getTotalPrice());
                    
        }           
    }
    String resource = System.getProperty("user.resource");
    File f = new File("resource\\Oil\\Export"); //tao file 
    int ln;
    
    void createFolder(){
        if(!f.exists()){
        f.mkdirs();
        }
    }
    
    void readImportFile() throws IOException{
        try {
            FileReader fr = new FileReader(f+"\\FileExportText.txt");
            System.out.println("file exists!");
           
            
        } catch(FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f+"\\FileExportText.txt");
                System.out.println("File created");
                RandomAccessFile wrtf = new RandomAccessFile(f+"\\FileExportText.txt", "rw");
                wrtf.writeBytes("Time,Buyer,Type,Amount,Price per liter,Total Price \r\n");
            } catch (IOException ex1) {
                Logger.getLogger(MainBoardFrm.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
    }
    void addData(String usr,String dat,String typ,String quant,String price, String total){   // nhÆ¡ doi
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\FileExportText.txt", "rw");
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
            RandomAccessFile raf = new RandomAccessFile(f+"\\FileExportText.txt", "rw");
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

