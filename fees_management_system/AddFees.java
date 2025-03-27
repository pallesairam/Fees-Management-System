/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author N AKSHAYA
 */
public class AddFees extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
    public AddFees() {
        initComponents();
        displayCashFirst();
        fillComboBox();
        int receiptNo=getReceiptNo();
        text_reciptNo1.setText(Integer.toString(receiptNo));
    }
    public void displayCashFirst()
    {
        lbl_ddNo.setVisible(false);
        lbl_chequeNo.setVisible(false);
        lbl_bankName.setVisible(false);
        text_ddNo.setVisible(false);
        txt_chequeNo.setVisible(false);
        txt_bankName.setVisible(false);
    }
    public boolean validation()
    {
        
        
        if(combo_PaymentMode.getSelectedItem().toString().equalsIgnoreCase("cheque")){
            if(txt_chequeNo.getText().equals("")){
                JOptionPane.showMessageDialog(this,"please enter cheque number");
                return false;
            }
            if(txt_bankName.getText().equals("")){
                JOptionPane.showMessageDialog(this,"please enter the bank name");
                return false;
            }
        }
        if(combo_PaymentMode.getSelectedItem().toString().equalsIgnoreCase("dd")){
            if(text_ddNo.getText().equals("")){
                JOptionPane.showMessageDialog(this,"please enter DD number");
                return false;
            }
            if(txt_bankName.getText().equals("")){
                JOptionPane.showMessageDialog(this,"please enter the bank name");
                return false;
            }
        }
        if(combo_PaymentMode.getSelectedItem().toString().equalsIgnoreCase("card")){
           
            if(txt_bankName.getText().equals("")){
                JOptionPane.showMessageDialog(this,"please enter the bank name");
                return false;
            }
        }
        if (txt_receviedFrom.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Please enter user name");
            return false;
        }
        if(dateChooser.getDate()==null){
            JOptionPane.showMessageDialog( this,"Please select date");
            return false;
        }
        if (txt_courseAmount.getText().equals("")||txt_courseAmount.getText().matches("[0-9]+")==false) {
            JOptionPane.showMessageDialog(this,"please enter amount(in numbers)");
            return false;
        }
        
            
            
        return true;
    }
    public void fillComboBox()
    {
        try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/feemanagementsystem?zeroDateTimeBehavior=CONVERT_TO_NULL","root","Ram@1014");
            PreparedStatement pst=con.prepareStatement("select cname from course");
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                combo_course.addItem(rs.getString("cname"));
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
     public int getReceiptNo()
        {        
            int receipt_no=0;
            try {
                Connection con=DBconnection.getConnection();
                PreparedStatement pst=con.prepareStatement("select max(reciept_no)from fees_details");
                ResultSet rs=pst.executeQuery();
                if(rs.next()==true){
                    receipt_no=rs.getInt(1);
                }
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            return receipt_no+1;
       }
     public String insertData(){
         String status="";
         int reiceptNo=Integer.parseInt(text_reciptNo1.getText());
         String studentName=txt_receviedFrom.getText();
         String rollno=txt_rollNo.getText();
         String paymentMode=combo_PaymentMode.getSelectedItem().toString();
         String chequeNo=txt_chequeNo.getText();
         String bankName=txt_bankName.getText();
         String ddNo=text_ddNo.getText();
         String courseName=txt_courseName.getText();
         String gstin=txt_GSTIN.getText();
         float totalAmount=Float.parseFloat(txt_totalAmout.getText());
         SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
         String date=dateFormat.format(dateChooser.getDate());
         float intialAmount=Float.parseFloat(txt_courseAmount.getText());
         float cgst=Float.parseFloat(txt_CGST.getText());
         float sgst=Float.parseFloat(txt_SGST.getText());
         String totalInWords=txt_totalinWords.getText();
         String remark=txt_remarks.getText();
         int year1=Integer.parseInt(txt_year1.getText());
         int year2=Integer.parseInt(txt_year2.getText());
         try {
             Connection con=DBconnection.getConnection();
             PreparedStatement pst=con.prepareStatement("insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
             pst.setInt(1,reiceptNo);
             pst.setString(2,studentName);
             pst.setString(3,rollno);
             pst.setString(4,paymentMode );
             pst.setString(5,chequeNo );
             pst.setString(6,bankName);
             pst.setString(7,ddNo);
             pst.setString(8,courseName);
             pst.setString(9,gstin);
             pst.setFloat(10,totalAmount);
             pst.setString(11, date);
             pst.setFloat(12,intialAmount);
             pst.setFloat(13, cgst);
             pst.setFloat(14,sgst);
             pst.setString(15,totalInWords);
             pst.setString(16,remark );
             pst.setInt(17,year1);
             pst.setInt(18, year2);
             int rowCount=pst.executeUpdate();
             if(rowCount==1){
                 status=("Success");
             }
             else{
                 status="failed";
             }
         } 
         catch (Exception e) {
             e.printStackTrace();
         }
         return status;
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelsideBar = new javax.swing.JPanel();
        panelHome = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        panelSearch = new javax.swing.JPanel();
        btnSearch = new javax.swing.JLabel();
        panelEditCourses = new javax.swing.JPanel();
        btnEditCourses = new javax.swing.JLabel();
        panelCourseList = new javax.swing.JPanel();
        btnCourseList = new javax.swing.JLabel();
        panelViewAllRecord = new javax.swing.JPanel();
        btnViewAllRecord = new javax.swing.JLabel();
        panelBack = new javax.swing.JPanel();
        btnBack = new javax.swing.JLabel();
        panelLogOut = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JLabel();
        panelPrint = new javax.swing.JPanel();
        btnPrint = new javax.swing.JLabel();
        panelEdit = new javax.swing.JPanel();
        btnEdit = new javax.swing.JLabel();
        panelParent = new javax.swing.JPanel();
        txt_GSTIN = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_ddNo = new javax.swing.JLabel();
        lbl_chequeNo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_chequeNo = new javax.swing.JTextField();
        text_ddNo = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        panelChild = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_totalAmout = new javax.swing.JTextField();
        txt_year2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_year1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        combo_course = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_receviedFrom = new javax.swing.JTextField();
        txt_totalinWords = new javax.swing.JTextField();
        txt_courseAmount = new javax.swing.JTextField();
        txt_CGST = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txt_SGST = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_courseName = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remarks = new javax.swing.JTextPane();
        btn_print = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_rollNo = new javax.swing.JTextField();
        lbl_bankName = new javax.swing.JLabel();
        txt_bankName = new javax.swing.JTextField();
        combo_PaymentMode = new javax.swing.JComboBox<>();
        text_reciptNo1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsideBar.setBackground(new java.awt.Color(0, 102, 102));
        panelsideBar.setPreferredSize(new java.awt.Dimension(350, 80));
        panelsideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHome.setBackground(new java.awt.Color(0, 102, 102));
        panelHome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelHome.setPreferredSize(new java.awt.Dimension(350, 80));
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        btnHome.setText("   Home");
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        panelHome.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 290, -1));

        panelsideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 330, 70));

        panelSearch.setBackground(new java.awt.Color(0, 102, 102));
        panelSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelSearch.setPreferredSize(new java.awt.Dimension(350, 80));
        panelSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/search2.png"))); // NOI18N
        btnSearch.setText("Search Record");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
        });
        panelSearch.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 290, -1));

        panelsideBar.add(panelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 330, 70));

        panelEditCourses.setBackground(new java.awt.Color(0, 102, 102));
        panelEditCourses.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelEditCourses.setPreferredSize(new java.awt.Dimension(350, 80));
        panelEditCourses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditCourses.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        btnEditCourses.setForeground(new java.awt.Color(255, 255, 255));
        btnEditCourses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/edit.png"))); // NOI18N
        btnEditCourses.setText(" Edit Courses");
        btnEditCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditCoursesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditCoursesMouseExited(evt);
            }
        });
        panelEditCourses.add(btnEditCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 50));

        panelsideBar.add(panelEditCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 330, 70));

        panelCourseList.setBackground(new java.awt.Color(0, 102, 102));
        panelCourseList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelCourseList.setPreferredSize(new java.awt.Dimension(350, 80));
        panelCourseList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCourseList.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        btnCourseList.setForeground(new java.awt.Color(255, 255, 255));
        btnCourseList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/list_1.png"))); // NOI18N
        btnCourseList.setText("Course List");
        btnCourseList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCourseListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCourseListMouseExited(evt);
            }
        });
        panelCourseList.add(btnCourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, -1));

        panelsideBar.add(panelCourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 330, 70));

        panelViewAllRecord.setBackground(new java.awt.Color(0, 102, 102));
        panelViewAllRecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelViewAllRecord.setPreferredSize(new java.awt.Dimension(350, 80));
        panelViewAllRecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnViewAllRecord.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        btnViewAllRecord.setForeground(new java.awt.Color(255, 255, 255));
        btnViewAllRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/view all record.png"))); // NOI18N
        btnViewAllRecord.setText("View All Record");
        btnViewAllRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnViewAllRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnViewAllRecordMouseExited(evt);
            }
        });
        panelViewAllRecord.add(btnViewAllRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 290, -1));

        panelsideBar.add(panelViewAllRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 330, 70));

        panelBack.setBackground(new java.awt.Color(0, 102, 102));
        panelBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBack.setPreferredSize(new java.awt.Dimension(350, 80));
        panelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/back1.png"))); // NOI18N
        btnBack.setText("     Back");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        panelBack.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 290, 70));

        panelsideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 330, 70));

        panelLogOut.setBackground(new java.awt.Color(0, 102, 102));
        panelLogOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelLogOut.setPreferredSize(new java.awt.Dimension(350, 80));
        panelLogOut.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogOut.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/logout.png"))); // NOI18N
        btnLogOut.setText("Log Out");
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogOutMouseExited(evt);
            }
        });
        panelLogOut.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 290, -1));

        panelsideBar.add(panelLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 330, 70));

        panelPrint.setBackground(new java.awt.Color(0, 102, 102));
        panelPrint.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelPrint.setPreferredSize(new java.awt.Dimension(350, 80));
        panelPrint.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPrint.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/printer-.png"))); // NOI18N
        btnPrint.setText("  Print");
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrintMouseExited(evt);
            }
        });
        panelPrint.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 290, -1));

        panelsideBar.add(panelPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, 330, 70));

        panelEdit.setBackground(new java.awt.Color(0, 102, 102));
        panelEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelEdit.setPreferredSize(new java.awt.Dimension(350, 80));
        panelEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/edit.png"))); // NOI18N
        btnEdit.setText(" Edit");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditMouseExited(evt);
            }
        });
        panelEdit.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 290, 60));

        panelsideBar.add(panelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 720, 330, 70));

        getContentPane().add(panelsideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 1040));

        panelParent.setBackground(new java.awt.Color(0, 153, 153));
        panelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_GSTIN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_GSTIN.setText("22Y75B652");
        panelParent.add(txt_GSTIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 100, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Mode Of Payment:");
        panelParent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 160, -1));

        lbl_ddNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_ddNo.setText(" DD no:");
        panelParent.add(lbl_ddNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 100, -1));

        lbl_chequeNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_chequeNo.setText("Cheque No:");
        panelParent.add(lbl_chequeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 100, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Recipt No:");
        panelParent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 150, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Date:");
        panelParent.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 100, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("GSTIN:");
        panelParent.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 100, -1));

        txt_chequeNo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_chequeNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_chequeNoActionPerformed(evt);
            }
        });
        panelParent.add(txt_chequeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 220, -1));

        text_ddNo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        panelParent.add(text_ddNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 210, -1));
        panelParent.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, 150, 30));

        panelChild.setBackground(new java.awt.Color(0, 153, 153));
        panelChild.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("The following Payments the collage for the year :");
        panelChild.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 400, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("to");
        panelChild.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 20, -1));

        txt_totalAmout.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_totalAmout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalAmoutActionPerformed(evt);
            }
        });
        panelChild.add(txt_totalAmout, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 230, -1));

        txt_year2.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        panelChild.add(txt_year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 90, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Recivers Sign:");
        panelChild.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 480, 150, -1));

        txt_year1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        panelChild.add(txt_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 90, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Amount:");
        panelChild.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 200, 150, 30));

        combo_course.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        combo_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_courseActionPerformed(evt);
            }
        });
        panelChild.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 440, -1));
        panelChild.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 1130, 20));
        panelChild.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 380, 320, 10));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Roll no:");
        panelChild.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 70, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Sr No:");
        panelChild.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 150, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Heads:");
        panelChild.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 130, 30));

        txt_receviedFrom.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_receviedFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receviedFromActionPerformed(evt);
            }
        });
        panelChild.add(txt_receviedFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 350, -1));

        txt_totalinWords.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_totalinWords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalinWordsActionPerformed(evt);
            }
        });
        panelChild.add(txt_totalinWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 410, -1));

        txt_courseAmount.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_courseAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseAmountActionPerformed(evt);
            }
        });
        panelChild.add(txt_courseAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, 230, -1));

        txt_CGST.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_CGST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CGSTActionPerformed(evt);
            }
        });
        panelChild.add(txt_CGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 230, -1));
        panelChild.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 1130, 20));

        txt_SGST.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_SGST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SGSTActionPerformed(evt);
            }
        });
        panelChild.add(txt_SGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 230, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("SGST 9%");
        panelChild.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 110, -1));

        txt_courseName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_courseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseNameActionPerformed(evt);
            }
        });
        panelChild.add(txt_courseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 410, -1));
        panelChild.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 320, 10));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Remarks:");
        panelChild.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 150, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Total in words:");
        panelChild.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 150, -1));

        jScrollPane1.setViewportView(txt_remarks);

        panelChild.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 280, 60));

        btn_print.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        panelChild.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 540, 90, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setText("Course:");
        panelChild.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 110, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("CGST 9%");
        panelChild.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 110, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setText("Recevied From:");
        panelChild.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 150, -1));

        txt_rollNo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        panelChild.add(txt_rollNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 160, -1));

        panelParent.add(panelChild, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1310, 800));

        lbl_bankName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_bankName.setText("Bank Name:");
        panelParent.add(lbl_bankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 150, -1));

        txt_bankName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_bankName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bankNameActionPerformed(evt);
            }
        });
        panelParent.add(txt_bankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 350, -1));

        combo_PaymentMode.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        combo_PaymentMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "CHEQUE", "CASH", "CARD" }));
        combo_PaymentMode.setSelectedIndex(2);
        combo_PaymentMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_PaymentModeActionPerformed(evt);
            }
        });
        panelParent.add(combo_PaymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, 30));

        text_reciptNo1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        panelParent.add(text_reciptNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 160, -1));

        getContentPane().add(panelParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 1310, 1040));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        Color clr=new Color(0,153,153);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        Color clr=new Color(0,103,103);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        Color clr=new Color(0,153,153);
        panelSearch.setBackground(clr);
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        Color clr=new Color(0,103,103);
        panelSearch.setBackground(clr);
    }//GEN-LAST:event_btnSearchMouseExited

    private void btnEditCoursesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditCoursesMouseEntered
        Color clr=new Color(0,153,153);
        panelEditCourses.setBackground(clr);
    }//GEN-LAST:event_btnEditCoursesMouseEntered

    private void btnEditCoursesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditCoursesMouseExited
        Color clr=new Color(0,103,103);
        panelEditCourses.setBackground(clr);
    }//GEN-LAST:event_btnEditCoursesMouseExited

    private void btnCourseListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseListMouseEntered
        Color clr=new Color(0,153,153);
        panelCourseList.setBackground(clr);
    }//GEN-LAST:event_btnCourseListMouseEntered

    private void btnCourseListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseListMouseExited
        Color clr=new Color(0,103,103);
        panelCourseList.setBackground(clr);
    }//GEN-LAST:event_btnCourseListMouseExited

    private void btnViewAllRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllRecordMouseEntered
        Color clr=new Color(0,153,153);
        panelViewAllRecord.setBackground(clr);
    }//GEN-LAST:event_btnViewAllRecordMouseEntered

    private void btnViewAllRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllRecordMouseExited
        Color clr=new Color(0,103,103);
        panelViewAllRecord.setBackground(clr);
    }//GEN-LAST:event_btnViewAllRecordMouseExited

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
       Color clr=new Color(0,153,153);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        Color clr=new Color(0,103,103);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseExited

    private void btnLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseEntered
       Color clr=new Color(0,153,153);
        panelLogOut.setBackground(clr);
    }//GEN-LAST:event_btnLogOutMouseEntered

    private void btnLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseExited
        Color clr=new Color(0,103,103);
        panelLogOut.setBackground(clr);
    }//GEN-LAST:event_btnLogOutMouseExited

    private void txt_chequeNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_chequeNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_chequeNoActionPerformed

    private void txt_totalAmoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalAmoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalAmoutActionPerformed

    private void txt_bankNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bankNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bankNameActionPerformed

    private void txt_receviedFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receviedFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receviedFromActionPerformed

    private void txt_totalinWordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalinWordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalinWordsActionPerformed

    private void txt_courseAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseAmountActionPerformed
        Float amnt=Float.parseFloat(txt_courseAmount.getText());
        Float cgst=(float)(amnt*0.09);
        Float sgst=(float)(amnt*0.09);
        txt_CGST.setText(cgst.toString());
        txt_SGST.setText(sgst.toString());
        float total=amnt+cgst+sgst;
        txt_totalAmout.setText(Float.toString(total));
        txt_totalinWords.setText(NumberToWordConverter.convert((int)total));
        
    }//GEN-LAST:event_txt_courseAmountActionPerformed

    private void txt_CGSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CGSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CGSTActionPerformed

    private void txt_SGSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SGSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SGSTActionPerformed

    private void txt_courseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseNameActionPerformed
       
    }//GEN-LAST:event_txt_courseNameActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        if(validation()==true){
            String result=insertData();
        if (result.equals("Success")) {
            JOptionPane.showMessageDialog(this,"record inserted succussful");
            PrintReciept p=new PrintReciept();
            p.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,"record insertion failed");
        }
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void combo_PaymentModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_PaymentModeActionPerformed
        if (combo_PaymentMode.getSelectedIndex()==0) {
            lbl_ddNo.setVisible(true);
            text_ddNo.setVisible(true);
            lbl_chequeNo.setVisible(false);
            txt_chequeNo.setVisible(false);
            lbl_bankName.setVisible(true);
            txt_bankName.setVisible(true);
        }
        if (combo_PaymentMode.getSelectedIndex()==1) {
            lbl_ddNo.setVisible(false);
            text_ddNo.setVisible(false);
            lbl_chequeNo.setVisible(true);
            txt_chequeNo.setVisible(true);
            lbl_bankName.setVisible(true);
            txt_bankName.setVisible(true);
        }
        if (combo_PaymentMode.getSelectedIndex()==2) {
            lbl_ddNo.setVisible(false);
            text_ddNo.setVisible(false);
            lbl_chequeNo.setVisible(false);
            txt_chequeNo.setVisible(false);
            lbl_bankName.setVisible(false);
            txt_bankName.setVisible(false);
        }
        if (combo_PaymentMode.getSelectedIndex()==3) {
            lbl_ddNo.setVisible(false);
            text_ddNo.setVisible(false);
            lbl_chequeNo.setVisible(false);
            txt_chequeNo.setVisible(false);
            lbl_bankName.setVisible(true);
            txt_bankName.setVisible(true);
        }

        
    }//GEN-LAST:event_combo_PaymentModeActionPerformed

    private void combo_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_courseActionPerformed
        txt_courseName.setText(combo_course.getSelectedItem().toString());
    }//GEN-LAST:event_combo_courseActionPerformed

    private void btnPrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseEntered
       Color clr=new Color(0,153,153);
        panelPrint.setBackground(clr);
    }//GEN-LAST:event_btnPrintMouseEntered

    private void btnPrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseExited
        Color clr=new Color(0,103,103);
        panelPrint.setBackground(clr);
    }//GEN-LAST:event_btnPrintMouseExited

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        Color clr=new Color(0,153,153);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        Color clr=new Color(0,103,103);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseExited

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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnCourseList;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnEditCourses;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnLogOut;
    private javax.swing.JLabel btnPrint;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel btnViewAllRecord;
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox<String> combo_PaymentMode;
    private javax.swing.JComboBox<String> combo_course;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_bankName;
    private javax.swing.JLabel lbl_chequeNo;
    private javax.swing.JLabel lbl_ddNo;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelChild;
    private javax.swing.JPanel panelCourseList;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JPanel panelEditCourses;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogOut;
    private javax.swing.JPanel panelParent;
    private javax.swing.JPanel panelPrint;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelViewAllRecord;
    private javax.swing.JPanel panelsideBar;
    private javax.swing.JTextField text_ddNo;
    private javax.swing.JTextField text_reciptNo1;
    private javax.swing.JTextField txt_CGST;
    private javax.swing.JLabel txt_GSTIN;
    private javax.swing.JTextField txt_SGST;
    private javax.swing.JTextField txt_bankName;
    private javax.swing.JTextField txt_chequeNo;
    private javax.swing.JTextField txt_courseAmount;
    private javax.swing.JTextField txt_courseName;
    private javax.swing.JTextField txt_receviedFrom;
    private javax.swing.JTextPane txt_remarks;
    private javax.swing.JTextField txt_rollNo;
    private javax.swing.JTextField txt_totalAmout;
    private javax.swing.JTextField txt_totalinWords;
    private javax.swing.JTextField txt_year1;
    private javax.swing.JTextField txt_year2;
    // End of variables declaration//GEN-END:variables
}
