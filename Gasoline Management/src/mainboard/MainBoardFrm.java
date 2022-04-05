/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mainboard;

import controller.ControllerImp;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.event.*;
import view.View;
import model.Information;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Salary;
import model.ScheduleManager;
import model.ScheduleStaff;
import view.InformationEditFrm;
import view.InformationFrm;
import view.SalaryEditFrm;
import view.SalaryFrm;
import view.ScheduleInformationFrm;
import view.ScheduleManagerEditFrm;
import view.ScheduleManagerFrm;
import view.ScheduleStaffEditFrm;
import view.ScheduleStaffFrm;

/**
 *
 * @author dell
 */
public class MainBoardFrm extends javax.swing.JFrame implements View {

    /**
     * Creates new form NewJFrame
     */
    private static boolean auth = false;
    private ControllerImp controller;

    public MainBoardFrm() {
        initComponents();
        jTabbedPane1.setSelectedIndex(4);
        setLISOPanel();
        this.setLocationRelativeTo(null);
        JButton[] btns = {Exportbutton, logbutton, importbutton, statbutton, employbutton};

        for (JButton btn : btns) {
            btn.setBackground(new Color(44, 44, 44));
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
                    btn.setBackground(new Color(61, 59, 59));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new Color(44, 44, 44));
                }
            });
        }

        // Add Information array
        informations = new ArrayList<>();
        tblModel1 = (DefaultTableModel) tblInformation.getModel();

        // Add Schedule for Manager array
        scheduleManager = new ArrayList<>();
        tblModel2 = (DefaultTableModel) tblSchedule1.getModel();

        // Add Schedule for Staff array
        scheduleStaff = new ArrayList<>();
        tblModel3 = (DefaultTableModel) tblSchedule2.getModel();

        // Add Salary for Salary array
        salary = new ArrayList<>();
        tblModel4 = (DefaultTableModel) tblSalary.getModel();

        // Add controller for save file
        controller = new ControllerImp();

        // Show the employee information when open file
        showInformation();
        showScheduleManager();
        showScheduleStaff();
        showSalary();
    }

    // Array list Employee
    private java.util.List<Information> informations;
    private java.util.List<ScheduleManager> scheduleManager;
    private java.util.List<ScheduleStaff> scheduleStaff;
    private java.util.List<Salary> salary;
    private DefaultTableModel tblModel1;
    private DefaultTableModel tblModel2;
    private DefaultTableModel tblModel3;
    private DefaultTableModel tblModel4;

    // Call Frame Employee information
    public void addInformation(Information i) {
        informations.add(i); // Add new information to the list
        this.showData(informations, tblModel1);
        controller.writeToFile(informations, "Employee information.txt");
    }

    // Call Frame Manager schedule
    public void addScheduleManagerFrm(ScheduleManager s1) {
        scheduleManager.add(s1); // Add new information to the list
        this.showData(scheduleManager, tblModel2);
        controller.writeToFile(scheduleManager, "Manager schedule.txt");
    }

    // Call Frame Staff schedule
    public void addScheduleStaffFrm(ScheduleStaff s2) {
        scheduleStaff.add(s2);
        this.showData(scheduleStaff, tblModel3);
        controller.writeToFile(scheduleStaff, "Staff schedule.txt");

    }

    // Call Frame Salary
    public void addSalaryFrm(Salary s3) {
        salary.add(s3);
        this.showData(salary, tblModel4);
        controller.writeToFile(salary, "Salary.txt");
    }

    // Save Information data
    private void showInformation() {
        informations = controller.readDataFromFile("Employee information.txt");
        if (informations.size() > 0) {
            int mNumber = informations.get(informations.size() - 1).getNo();
            Information.setNumber(mNumber + 1);
        }
        this.showData(informations, tblModel1);
    }

    // Save Manager schedule data
    private void showScheduleManager() {
        scheduleManager = controller.readDataFromFile("Manager schedule.txt");
        this.showData(scheduleManager, tblModel2);
    }

    // Save Staff schedule data
    private void showScheduleStaff() {
        scheduleStaff = controller.readDataFromFile("Staff schedule.txt");
        this.showData(scheduleStaff, tblModel3);
    }

    // Save Salary
    private void showSalary() {
        salary = controller.readDataFromFile("Salary.txt");
        this.showData(salary, tblModel4);
    }

    @Override
    public <T> void showData(java.util.List<T> list, DefaultTableModel model) {
        model.setRowCount(0);
        for (T t : list) {
            if (t instanceof Information) {
                Information i = (Information) t;
                model.addRow(new Object[]{
                    i.getNo(), i.getName(), i.getID(), i.getPhoneNumber(), i.getGender(), i.getDoB(), i.getAddress(), i.getWorkFrom(), i.getExe(), i.getPosition()
                });
            }
            if (t instanceof ScheduleManager) {
                ScheduleManager s1 = (ScheduleManager) t;
                model.addRow(new Object[]{
                    s1.getDate(), s1.getManagerID1(), s1.getManagerID2()
                });
            }
            if (t instanceof ScheduleStaff) {
                ScheduleStaff s2 = (ScheduleStaff) t;
                model.addRow(new Object[]{
                    s2.getDate(), s2.getStaffId1(), s2.getStaffId2(), s2.getStaffId3(), s2.getStaffId4(), s2.getStaffId5(), s2.getStaffId6(), s2.getStaffId7()
                });
            }
            if (t instanceof Salary) {
                Salary s3 = (Salary) t;
                model.addRow(new Object[]{
                    s3.getYear(), s3.getMonth(), s3.getManagerSalary1(), s3.getManagerSalary2(), s3.getStaffSalary1(), s3.getStaffSalary2(), s3.getStaffSalary3(), s3.getStaffSalary4(), s3.getStaffSalary5()
                });
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Feature = new javax.swing.JPanel();
        Exportbutton = new javax.swing.JButton();
        importbutton = new javax.swing.JButton();
        statbutton = new javax.swing.JButton();
        employbutton = new javax.swing.JButton();
        logbutton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        EXPane = new ExportMain();
        IMPane = new ImportMain();
        STPane = new StatPanel();
        jPanel4 = new javax.swing.JPanel();
        LISOPane = new LISOpanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        employeeTab = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        lbInforTitle = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInformation = new javax.swing.JTable();
        btnInformationAdd = new javax.swing.JButton();
        btnInformationEdit = new javax.swing.JButton();
        btnInformationDelete = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        tblSchedule = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSchedule1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSchedule2 = new javax.swing.JTable();
        lbScheduleManager = new javax.swing.JLabel();
        lbScheduleStaff = new javax.swing.JLabel();
        btnScheduleManagerAdd = new javax.swing.JButton();
        btnScheduleStaffAdd = new javax.swing.JButton();
        btnScheduleManagerEdit = new javax.swing.JButton();
        btnScheduleStaffEdit = new javax.swing.JButton();
        btnScheduleManagerDelete = new javax.swing.JButton();
        btnScheduleStaffDelete = new javax.swing.JButton();
        btnScheduleInformation = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSalary = new javax.swing.JTable();
        btnSalaryAdd = new javax.swing.JButton();
        btnSalaryEdit = new javax.swing.JButton();
        btnSalaryDelete = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(0, 0, 900, 500);

        Feature.setBackground(new java.awt.Color(44, 44, 44));
        Feature.setBounds(0, 0, 900, 40);
        Feature.setLayout(new java.awt.GridBagLayout());

        Exportbutton.setBackground(new java.awt.Color(44, 44, 44));
        Exportbutton.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        Exportbutton.setForeground(new java.awt.Color(240, 240, 240));
        Exportbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_export_20px.png"))); // NOI18N
        Exportbutton.setText("Export");
        Exportbutton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Exportbutton.setIconTextGap(2);
        Exportbutton.setInheritsPopupMenu(true);
        Exportbutton.setMaximumSize(new java.awt.Dimension(180, 30));
        Exportbutton.setPreferredSize(new java.awt.Dimension(180, 30));
        Exportbutton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Exportbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportbuttonActionPerformed(evt);
            }
        });
        Feature.add(Exportbutton, new java.awt.GridBagConstraints());

        importbutton.setBackground(new java.awt.Color(44, 44, 44));
        importbutton.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        importbutton.setForeground(new java.awt.Color(240, 240, 240));
        importbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_import_20px.png"))); // NOI18N
        importbutton.setText("Import");
        importbutton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        importbutton.setMaximumSize(new java.awt.Dimension(180, 30));
        importbutton.setPreferredSize(new java.awt.Dimension(180, 30));
        importbutton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        importbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importbuttonActionPerformed(evt);
            }
        });
        Feature.add(importbutton, new java.awt.GridBagConstraints());

        statbutton.setBackground(new java.awt.Color(44, 44, 44));
        statbutton.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        statbutton.setForeground(new java.awt.Color(240, 240, 240));
        statbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_spreadsheet_file_20px_1.png"))); // NOI18N
        statbutton.setText("Statistic");
        statbutton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        statbutton.setMaximumSize(new java.awt.Dimension(180, 30));
        statbutton.setMinimumSize(new java.awt.Dimension(180, 30));
        statbutton.setPreferredSize(new java.awt.Dimension(180, 30));
        statbutton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        statbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statbuttonActionPerformed(evt);
            }
        });
        Feature.add(statbutton, new java.awt.GridBagConstraints());

        employbutton.setBackground(new java.awt.Color(44, 44, 44));
        employbutton.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        employbutton.setForeground(new java.awt.Color(240, 240, 240));
        employbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_group_20px.png"))); // NOI18N
        employbutton.setText("Employee ");
        employbutton.setMaximumSize(new java.awt.Dimension(180, 30));
        employbutton.setPreferredSize(new java.awt.Dimension(180, 30));
        employbutton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        employbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employbuttonActionPerformed(evt);
            }
        });
        Feature.add(employbutton, new java.awt.GridBagConstraints());

        logbutton.setBackground(new java.awt.Color(44, 44, 44));
        logbutton.setFont(new java.awt.Font("Morn-Regular", 1, 14)); // NOI18N
        logbutton.setForeground(new java.awt.Color(240, 240, 240));
        logbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_login_20px.png"))); // NOI18N
        logbutton.setText("Log in/Sign out");
        logbutton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        logbutton.setMaximumSize(new java.awt.Dimension(180, 30));
        logbutton.setMinimumSize(new java.awt.Dimension(180, 30));
        logbutton.setPreferredSize(new java.awt.Dimension(180, 30));
        logbutton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        logbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logbuttonActionPerformed(evt);
            }
        });
        Feature.add(logbutton, new java.awt.GridBagConstraints());

        jTabbedPane1.addTab("tab1", EXPane);

        jTabbedPane1.addTab("tab2", IMPane);

        jTabbedPane1.addTab("tab3", STPane);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 579, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 213, Short.MAX_VALUE)
        );

        employeeTab.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        lbInforTitle.setText("INFORMATION TABLE");

        tblInformation.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "No", "Name", "ID", "Phone Number", "Gender", "DoB", "Address", "Start Working From", "Experience", "Position"
                }
        ));
        jScrollPane3.setViewportView(tblInformation);

        btnInformationAdd.setText("Add");
        btnInformationAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformationAddActionPerformed(evt);
            }
        });

        btnInformationEdit.setText("Edit");
        btnInformationEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformationEditActionPerformed(evt);
            }
        });

        btnInformationDelete.setText("Delete");
        btnInformationDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformationDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGap(317, 317, 317)
                                                .addComponent(btnInformationAdd)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnInformationEdit)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnInformationDelete))
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGap(373, 373, 373)
                                                .addComponent(lbInforTitle)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lbInforTitle)
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnInformationAdd)
                                        .addComponent(btnInformationEdit)
                                        .addComponent(btnInformationDelete))
                                .addGap(12, 12, 12))
        );

        employeeTab.addTab("Information", jPanel15);

        tblSchedule.setText("ADD THE DATE AND THE SCHEDULE TO THE TABLE");

        tblSchedule1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblSchedule1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null},
                    {null, null, null}
                },
                new String[]{
                    "Date", "M-A", "E-N"
                }
        ));
        tblSchedule1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane4.setViewportView(tblSchedule1);

        tblSchedule2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null}
                },
                new String[]{
                    "Date", "M1", "M2", "A1", "A2", "E1", "E2", "N"
                }
        ));
        jScrollPane5.setViewportView(tblSchedule2);

        lbScheduleManager.setText("SCHEDULE TABLE: MANAGER");

        lbScheduleStaff.setText("SCHEDULE TABLE: STAFF");

        btnScheduleManagerAdd.setText("Add manager schedule");
        btnScheduleManagerAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleManagerAddActionPerformed(evt);
            }
        });

        btnScheduleStaffAdd.setText("Add staff schedule");
        btnScheduleStaffAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleStaffAddActionPerformed(evt);
            }
        });

        btnScheduleManagerEdit.setText("Edit manager schedule");
        btnScheduleManagerEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleManagerEditActionPerformed(evt);
            }
        });

        btnScheduleStaffEdit.setText("Edit staff schedule");
        btnScheduleStaffEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleStaffEditActionPerformed(evt);
            }
        });

        btnScheduleManagerDelete.setText("Delete manager schedule");
        btnScheduleManagerDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleManagerDeleteActionPerformed(evt);
            }
        });

        btnScheduleStaffDelete.setText("Delete staff schedule");
        btnScheduleStaffDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleStaffDeleteActionPerformed(evt);
            }
        });

        btnScheduleInformation.setText("i");
        btnScheduleInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleInformationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(263, 263, 263)
                                                .addComponent(tblSchedule))
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                                                .addComponent(lbScheduleManager)
                                                                .addGap(101, 101, 101)))
                                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                                .addComponent(btnScheduleInformation)
                                                                .addGap(125, 125, 125)
                                                                .addComponent(lbScheduleStaff)))))
                                .addContainerGap(47, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnScheduleManagerEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnScheduleManagerAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnScheduleManagerDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnScheduleStaffEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnScheduleStaffAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnScheduleStaffDelete))
                                .addGap(143, 143, 143))
        );
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tblSchedule)
                                .addGap(7, 7, 7)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbScheduleManager)
                                        .addComponent(lbScheduleStaff)
                                        .addComponent(btnScheduleInformation))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnScheduleManagerAdd)
                                        .addComponent(btnScheduleStaffAdd))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnScheduleStaffEdit)
                                        .addComponent(btnScheduleManagerEdit))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnScheduleStaffDelete)
                                        .addComponent(btnScheduleManagerDelete))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        employeeTab.addTab("Schedule", jPanel10);

        jLabel2.setText("SALARY TABLE");

        tblSalary.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null}
                },
                new String[]{
                    "Year", "Month", "MA1", "MA2", "S1", "S2", "S3", "S4", "S5"
                }
        ));
        jScrollPane7.setViewportView(tblSalary);

        btnSalaryAdd.setText("Add salary");
        btnSalaryAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalaryAddActionPerformed(evt);
            }
        });

        btnSalaryEdit.setText("Edit salary");
        btnSalaryEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalaryEditActionPerformed(evt);
            }
        });

        btnSalaryDelete.setText("Delete salary");
        btnSalaryDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalaryDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane7))
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGap(263, 263, 263)
                                                .addComponent(btnSalaryAdd)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSalaryEdit)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSalaryDelete)
                                                .addGap(0, 258, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(383, 383, 383)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSalaryAdd)
                                        .addComponent(btnSalaryEdit)
                                        .addComponent(btnSalaryDelete))
                                .addGap(12, 12, 12))
        );

        employeeTab.addTab("Salary", jPanel11);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(employeeTab, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(employeeTab)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(508, 508, 508)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(412, 412, 412)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 950, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel4);

        jTabbedPane1.addTab("tab5", LISOPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Feature, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Feature, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    private void btnInformationAddActionPerformed(java.awt.event.ActionEvent evt) {
        InformationFrm informationFrm = new InformationFrm(this, rootPaneCheckingEnabled);
        informationFrm.setVisible(true);
    }

    private void btnScheduleManagerAddActionPerformed(java.awt.event.ActionEvent evt) {
        ScheduleManagerFrm scheduleManagerFrm = new ScheduleManagerFrm(this, rootPaneCheckingEnabled);
        scheduleManagerFrm.setVisible(true);
    }

    private void btnScheduleStaffAddActionPerformed(java.awt.event.ActionEvent evt) {
        ScheduleStaffFrm scheduleStaffFrm = new ScheduleStaffFrm(this, rootPaneCheckingEnabled);
        scheduleStaffFrm.setVisible(true);
    }

    private void btnSalaryAddActionPerformed(java.awt.event.ActionEvent evt) {
        SalaryFrm salaryFrm = new SalaryFrm(this, rootPaneCheckingEnabled);
        salaryFrm.setVisible(true);
    }

    private void btnInformationDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int removeInformation = tblInformation.getSelectedRow();
        if (removeInformation == -1 && !informations.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Select row to delete.");
        } else if (informations.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "No information to delete.");
        } else {
            informations.remove(removeInformation);
            showData(informations, tblModel1);
            controller.writeToFile(informations, "Employee information.txt");
        }
    }

    private void btnScheduleManagerDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int removeScheduleManager = tblSchedule1.getSelectedRow();
        if (removeScheduleManager == -1 && !scheduleManager.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Select row to delete.");
        } else if (scheduleManager.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "No information to delete.");
        } else {
            scheduleManager.remove(removeScheduleManager);
            showData(scheduleManager, tblModel2);
            controller.writeToFile(scheduleManager, "Manager schedule.txt");
        }
    }

    private void btnScheduleStaffDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int removeScheduleStaff = tblSchedule2.getSelectedRow();
        if (removeScheduleStaff == -1 && !scheduleStaff.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Select row to delete.");
        } else if (scheduleStaff.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "No information to delete.");
        } else {
            scheduleStaff.remove(removeScheduleStaff);
            showData(scheduleStaff, tblModel3);
            controller.writeToFile(scheduleStaff, "Staff schedule.txt");

        }
    }

    private void btnSalaryDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int removeSalary = tblSalary.getSelectedRow();
        if (removeSalary == -1 && !salary.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Select row to delete.");
        } else if (salary.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "No information to delete.");
        } else {
            salary.remove(removeSalary);
            showData(salary, tblModel4);
            controller.writeToFile(salary, "Salary.txt");

        }
    }

    private int editInformation, editScheduleManager, editScheduleStaff, editSalary;

    private void btnInformationEditActionPerformed(java.awt.event.ActionEvent evt) {
        editInformation = tblInformation.getSelectedRow();
        if (editInformation == -1 && !informations.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Select row to edit.");
        } else if (informations.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "No information to edit.");
        } else {
            InformationEditFrm informationEdit = new InformationEditFrm(this, rootPaneCheckingEnabled);
            informationEdit.setEditData(informations.get(editInformation));
            informationEdit.setVisible(true);
        }
    }

    private void btnScheduleInformationActionPerformed(java.awt.event.ActionEvent evt) {
        ScheduleInformationFrm scheduleInformation = new ScheduleInformationFrm(this, rootPaneCheckingEnabled);
        scheduleInformation.setVisible(true);
    }

    private void btnScheduleManagerEditActionPerformed(java.awt.event.ActionEvent evt) {
        editScheduleManager = tblSchedule1.getSelectedRow();
        if (editScheduleManager == -1 && !scheduleManager.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Select row to edit.");
        } else if (scheduleManager.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "No information to edit.");
        } else {
            ScheduleManagerEditFrm scheduleManagerEdit = new ScheduleManagerEditFrm(this, rootPaneCheckingEnabled);
            scheduleManagerEdit.setEditData(scheduleManager.get(editScheduleManager));
            scheduleManagerEdit.setVisible(true);
        }
    }

    private void btnSalaryEditActionPerformed(java.awt.event.ActionEvent evt) {
        editSalary = tblSalary.getSelectedRow();
        if (editSalary == -1 && !salary.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Select row to edit.");
        } else if (salary.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "No information to edit.");
        } else {
            SalaryEditFrm salaryEdit = new SalaryEditFrm(this, rootPaneCheckingEnabled);
            salaryEdit.setEditData(salary.get(editSalary));
            salaryEdit.setVisible(true);
        }

    }

    private void btnScheduleStaffEditActionPerformed(java.awt.event.ActionEvent evt) {
        editScheduleStaff = tblSchedule1.getSelectedRow();
        if (editScheduleStaff == -1 && !scheduleStaff.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Select row to edit.");
        } else if (scheduleStaff.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "No information to edit.");
        } else {
            ScheduleStaffEditFrm scheduleStaffEdit = new ScheduleStaffEditFrm(this, rootPaneCheckingEnabled);
            scheduleStaffEdit.setEditData(scheduleStaff.get(editScheduleStaff));
            scheduleStaffEdit.setVisible(true);
        }
    }

    public void updateInformation(Information i) {
        informations.remove(editInformation);
        this.addInformation(i);
    }

    public void updateScheduleManagerFrm(ScheduleManager s1) {
        scheduleManager.remove(editScheduleManager);
        this.addScheduleManagerFrm(s1);
    }

    public void updateScheduleStaffFrm(ScheduleStaff s2) {
        scheduleStaff.remove(editScheduleStaff);
        this.addScheduleStaffFrm(s2);
    }

    public void updateSalary(Salary s3) {
        salary.remove(editSalary);
        this.addSalaryFrm(s3);
    }

    private void ExportbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
        ExportMain.jGasoline1.setValue(ExportMain.Gasoline1);
        ExportMain.jGasoline1.setString(Integer.toString(ExportMain.Gasoline1));
        ExportMain.jDiesel1.setValue(ExportMain.Diesel1);
        ExportMain.jDiesel1.setString(Integer.toString(ExportMain.Diesel1));
        ExportMain.jLubrocant1.setValue(ExportMain.Lubrocant1);
        ExportMain.jLubrocant1.setString(Integer.toString(ExportMain.Lubrocant1));
        ExportMain.jHydraulic1.setValue(ExportMain.Hydraulic1);
        ExportMain.jHydraulic1.setString(Integer.toString(ExportMain.Hydraulic1));
    }

    private void logbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        jTabbedPane1.setSelectedIndex(4);
    }

    private void employbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        jTabbedPane1.setSelectedIndex(3);
    }

    private void importbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        jTabbedPane1.setSelectedIndex(1);
        ImportMain.jGasoline2.setValue(ExportMain.Gasoline1);
        ImportMain.jGasoline2.setString(Integer.toString(ExportMain.Gasoline1));
        ImportMain.jDiesel2.setValue(ExportMain.Diesel1);
        ImportMain.jDiesel2.setString(Integer.toString(ExportMain.Diesel1));
        ImportMain.jLubrocant2.setValue(ExportMain.Lubrocant1);
        ImportMain.jLubrocant2.setString(Integer.toString(ExportMain.Lubrocant1));
        ImportMain.jHydraulic2.setValue(ExportMain.Hydraulic1);
        ImportMain.jHydraulic2.setString(Integer.toString(ExportMain.Hydraulic1));
    }

    private void statbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        jTabbedPane1.setSelectedIndex(2);
    }

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
            java.util.logging.Logger.getLogger(MainBoardFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainBoardFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainBoardFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainBoardFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainBoardFrm().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton Exportbutton;
    private javax.swing.JPanel Feature;
    private static javax.swing.JButton employbutton;
    private static javax.swing.JButton importbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private LISOpanel LISOPane;
    private ExportMain EXPane;
    private ImportMain IMPane;
    private StatPanel STPane;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logbutton;
    private static javax.swing.JButton statbutton;
        private javax.swing.JButton ExportExelHistory;
    private javax.swing.JButton btnInformationAdd;
    private javax.swing.JButton btnInformationDelete;
    private javax.swing.JButton btnInformationEdit;
    private javax.swing.JButton btnSalaryAdd;
    private javax.swing.JButton btnSalaryDelete;
    private javax.swing.JButton btnSalaryEdit;
    private javax.swing.JButton btnScheduleInformation;
    private javax.swing.JButton btnScheduleManagerAdd;
    private javax.swing.JButton btnScheduleManagerDelete;
    private javax.swing.JButton btnScheduleManagerEdit;
    private javax.swing.JButton btnScheduleStaffAdd;
    private javax.swing.JButton btnScheduleStaffDelete;
    private javax.swing.JButton btnScheduleStaffEdit;
    private javax.swing.JTabbedPane employeeTab;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;    
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbInforTitle;
    private javax.swing.JLabel lbScheduleManager;
    private javax.swing.JLabel lbScheduleStaff;
    private javax.swing.JTable tblInformation;
    private javax.swing.JTable tblSalary;
    private javax.swing.JLabel tblSchedule;
    private javax.swing.JTable tblSchedule1;
    private javax.swing.JTable tblSchedule2;
    // End of variables declaration//GEN-END:variables

    public static void setAuth(boolean temp) {
        auth = temp;
    }

    public static void setLISOPanel() {
        if (auth == false) {
            Exportbutton.hide();
            importbutton.hide();
            employbutton.hide();
            statbutton.hide();
        } else {
            Exportbutton.show();
            importbutton.show();
            employbutton.show();
            statbutton.show();
            auth = true;
        }
    }

}
