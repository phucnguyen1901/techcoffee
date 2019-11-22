/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techcoffee;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author dell
 */
public class HomeUser extends javax.swing.JFrame {

    /**
     * Creates new form HomeUser
     */
    String bann;
    int soban;
    public void clock(){
        
        Thread clock=new Thread(){
            public void run(){
                try{
                   for(;;){
                        Calendar call =new GregorianCalendar();
                        int thu=call.get(Calendar.DAY_OF_WEEK);
                        int day=call.get(Calendar.DAY_OF_MONTH);
                        int month=call.get(Calendar.MONTH)+1;
                        int year=call.get(Calendar.YEAR);
                        int year1=call.get(Calendar.AM_PM);//Test sau 
                        int second=call.get(Calendar.SECOND);
                        int minute=call.get(Calendar.MINUTE);
                        int hour=call.get(Calendar.HOUR_OF_DAY);
                        if(thu==1)
                            lbThu.setText("Chủ Nhật");
                        else
                            lbThu.setText("Thứ: "+thu);
                        
                        if(minute>=0 && minute <=9 )
                                lbTime.setText(""+hour+":0"+minute);
                        else
                            lbTime.setText(""+hour+":"+minute);
                        
                         if(hour >=0 && hour <=9)
                             if(minute>=0 && minute <=9 )
                                lbTime.setText("0"+hour+":0"+minute);
                             else
                                lbTime.setText("0"+hour+":"+minute);
                       
                           
                        
                        lbDay.setText(""+day+"-"+month+"-"+year);
                        
                        if(hour >=5 && hour <=10)
                            lbWelcome.setText("Tôtô xin chúc quý khách buổi sáng vui vẻ !");
                        else if(hour >10 && hour <=3)
                            lbWelcome.setText("Tôtô xin chúc quý khách buổi trưa vui vẻ !");
                        else if(hour >3 && hour <=6)
                            lbWelcome.setText("Tôtô xin chúc quý khách buổi chiều vui vẻ !");
                        else 
                            lbWelcome.setText("Tôtô xin chúc quý khách buổi tối hạnh phúc !");
                        
                        
                        sleep(1000);
                   }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        
        clock.start();
        lbSo1.setBackground(Color.red);
        
    }
    public void switchPanel(JPanel panel){
        Container.removeAll();
        Container.add(panel);
        Container.repaint();
        Container.revalidate();
        
        //hihi la cardlayout
    
    }

    Connection conn=null;
    public void ConnectDatabase(){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/democafe?"+"user=root&password=H_Ghost");
            System.out.println("Sucess");   
            
        }catch(Exception ex){
            System.out.println("That Bai");
            ex.printStackTrace();
        }
    }
    public int getStatus(String ban){
        int xuat=0;
        PreparedStatement pStmt=null;
        ResultSet rs =null;
        
        try{
            pStmt = conn.prepareStatement("select xuatTT(?)");
            pStmt.setString(1, ban);
            rs=pStmt.executeQuery();
            while(rs.next()){
               xuat=rs.getInt(1); 
            }
        }catch(Exception ex){
            System.out.println("SQL exception: "+ex.getMessage());
        }finally{
            //Giai phong
            if(rs!=null){
               try{
                   rs.close();    
               }catch(SQLException sqlEx){}
               rs=null;
            }
            if(pStmt!= null){
                try{
                    pStmt.close();
                }catch(SQLException sqlEx){}
                pStmt=null;
            }
        }
        return xuat;
        
    }
    
    void dangDat(String ban){
        CallableStatement cStmt = null; 
        ResultSet rs =null;
        try{
        cStmt = conn.prepareCall("{call dangdat(?)}"); 
        cStmt.setString(1, ban); 
        rs = cStmt.executeQuery();
        }catch(Exception ex){
            System.out.println("SQL exception: "+ex.getMessage());
        }finally{
            //Giai phong
            if(rs!=null){
               try{
                   rs.close();    
               }catch(SQLException sqlEx){}
               rs=null;
            }
            if(cStmt!= null){
                try{
                    cStmt.close();
                }catch(SQLException sqlEx){}
                cStmt=null;
            }
        }
    }
    void dungXong(String ban){
        CallableStatement cStmt = null; 
        ResultSet rs =null;
        try{
        cStmt = conn.prepareCall("{call dungXong(?)}"); 
        cStmt.setString(1, ban); 
        rs = cStmt.executeQuery();
        }catch(Exception ex){
            System.out.println("SQL exception: "+ex.getMessage());
        }finally{
            //Giai phong
            if(rs!=null){
               try{
                   rs.close();    
               }catch(SQLException sqlEx){}
               rs=null;
            }
            if(cStmt!= null){
                try{
                    cStmt.close();
                }catch(SQLException sqlEx){}
                cStmt=null;
            }
        }
    }
    
    public HomeUser() {
        initComponents();
        clock();
        ConnectDatabase();
        
  
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        btn_4 = new javax.swing.JPanel();
        ind_4 = new javax.swing.JPanel();
        lbThu4 = new javax.swing.JLabel();
        btn_2 = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        lbThu2 = new javax.swing.JLabel();
        btn_5 = new javax.swing.JPanel();
        ind_5 = new javax.swing.JPanel();
        lbThu5 = new javax.swing.JLabel();
        btn_3 = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        lbThu3 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbNameUser = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();
        lbThu = new javax.swing.JLabel();
        lbDay = new javax.swing.JLabel();
        Container = new javax.swing.JPanel();
        PanelHome = new javax.swing.JPanel();
        btnOrder = new javax.swing.JButton();
        btnGuide = new javax.swing.JButton();
        lbStaff = new javax.swing.JLabel();
        btnDailyCheck = new javax.swing.JButton();
        lbOrder = new javax.swing.JLabel();
        lbDailyCheckin = new javax.swing.JLabel();
        lbHDSD = new javax.swing.JLabel();
        btnContact = new javax.swing.JButton();
        lbContact = new javax.swing.JLabel();
        lbWelcome = new javax.swing.JLabel();
        lbOrder3 = new javax.swing.JLabel();
        lbOrder2 = new javax.swing.JLabel();
        lbWelcome1 = new javax.swing.JLabel();
        PanelDatban = new javax.swing.JPanel();
        btnSo1 = new javax.swing.JButton();
        btnSo2 = new javax.swing.JButton();
        btnSo3 = new javax.swing.JButton();
        btnSo4 = new javax.swing.JButton();
        btnSo5 = new javax.swing.JButton();
        btnSo6 = new javax.swing.JButton();
        btnSo7 = new javax.swing.JButton();
        btnSo8 = new javax.swing.JButton();
        btnSo9 = new javax.swing.JButton();
        btnSo10 = new javax.swing.JButton();
        lbSo1 = new javax.swing.JLabel();
        lbSo2 = new javax.swing.JLabel();
        lbSo3 = new javax.swing.JLabel();
        lbSo4 = new javax.swing.JLabel();
        lbSo5 = new javax.swing.JLabel();
        lbSo6 = new javax.swing.JLabel();
        lbSo7 = new javax.swing.JLabel();
        lbSo8 = new javax.swing.JLabel();
        lbSo9 = new javax.swing.JLabel();
        lbSo10 = new javax.swing.JLabel();
        lbBack = new javax.swing.JLabel();
        PanelTichdiem = new javax.swing.JPanel();
        btnBack1 = new javax.swing.JButton();
        PanelHuongdan = new javax.swing.JPanel();
        btnBack2 = new javax.swing.JButton();
        PanelLienhe = new javax.swing.JPanel();
        btnBack3 = new javax.swing.JButton();
        PanelFormDB = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topPanel.setBackground(new java.awt.Color(32, 90, 180));
        topPanel.setForeground(new java.awt.Color(255, 255, 255));
        topPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topPanelMouseDragged(evt);
            }
        });
        topPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topPanelMousePressed(evt);
            }
        });
        topPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_4.setBackground(new java.awt.Color(32, 90, 180));
        btn_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_4MousePressed(evt);
            }
        });
        btn_4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_4.setOpaque(false);
        ind_4.setPreferredSize(new java.awt.Dimension(3, 42));

        javax.swing.GroupLayout ind_4Layout = new javax.swing.GroupLayout(ind_4);
        ind_4.setLayout(ind_4Layout);
        ind_4Layout.setHorizontalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        ind_4Layout.setVerticalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        btn_4.add(ind_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 3));

        lbThu4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbThu4.setForeground(new java.awt.Color(255, 255, 255));
        lbThu4.setText("USER");
        btn_4.add(lbThu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 50));

        topPanel.add(btn_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 110, 50));

        btn_2.setBackground(new java.awt.Color(45, 57, 80));
        btn_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_2MousePressed(evt);
            }
        });
        btn_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_2.setPreferredSize(new java.awt.Dimension(42, 3));

        javax.swing.GroupLayout ind_2Layout = new javax.swing.GroupLayout(ind_2);
        ind_2.setLayout(ind_2Layout);
        ind_2Layout.setHorizontalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        ind_2Layout.setVerticalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        btn_2.add(ind_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 3));

        lbThu2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbThu2.setForeground(new java.awt.Color(255, 255, 255));
        lbThu2.setText("HOME");
        btn_2.add(lbThu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 2, -1, 50));

        topPanel.add(btn_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 120, 50));

        btn_5.setBackground(new java.awt.Color(32, 90, 180));
        btn_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_5MousePressed(evt);
            }
        });
        btn_5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_5.setOpaque(false);
        ind_5.setPreferredSize(new java.awt.Dimension(3, 42));

        javax.swing.GroupLayout ind_5Layout = new javax.swing.GroupLayout(ind_5);
        ind_5.setLayout(ind_5Layout);
        ind_5Layout.setHorizontalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        ind_5Layout.setVerticalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        btn_5.add(ind_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 3));

        lbThu5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbThu5.setForeground(new java.awt.Color(255, 255, 255));
        lbThu5.setText("Profile");
        btn_5.add(lbThu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 50));

        topPanel.add(btn_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 110, 50));

        btn_3.setBackground(new java.awt.Color(32, 90, 180));
        btn_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_3MousePressed(evt);
            }
        });
        btn_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_3.setOpaque(false);
        ind_3.setPreferredSize(new java.awt.Dimension(3, 42));

        javax.swing.GroupLayout ind_3Layout = new javax.swing.GroupLayout(ind_3);
        ind_3.setLayout(ind_3Layout);
        ind_3Layout.setHorizontalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        ind_3Layout.setVerticalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        btn_3.add(ind_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 3));

        lbThu3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbThu3.setForeground(new java.awt.Color(255, 255, 255));
        lbThu3.setText("Setting");
        btn_3.add(lbThu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 50));

        topPanel.add(btn_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 110, 50));

        btnExit.setBackground(new java.awt.Color(32, 90, 180));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-turnoff.png"))); // NOI18N
        btnExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExit.setBorderPainted(false);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        topPanel.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 40, 50));

        getContentPane().add(topPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 50));

        jPanel3.setBackground(new java.awt.Color(32, 90, 180));

        jPanel4.setBackground(new java.awt.Color(97, 136, 198));

        jPanel5.setBackground(new java.awt.Color(32, 56, 151));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-avatar.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-calendar.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-padlock.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-giftbox.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-notiffi.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6)
                        .addGap(43, 43, 43))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(23, 23, 23))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-user.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-logout.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        lbNameUser.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbNameUser.setForeground(new java.awt.Color(255, 255, 255));
        lbNameUser.setText("NameUser");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNameUser)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbTime.setFont(new java.awt.Font("SansSerif", 0, 42)); // NOI18N
        lbTime.setForeground(new java.awt.Color(255, 255, 255));
        lbTime.setText(" Clock");

        lbThu.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbThu.setForeground(new java.awt.Color(255, 255, 255));
        lbThu.setText("Thu");

        lbDay.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbDay.setForeground(new java.awt.Color(255, 255, 255));
        lbDay.setText("Date");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbThu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbDay, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbThu)
                    .addComponent(lbDay))
                .addGap(56, 56, 56)
                .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 260, 440));

        Container.setLayout(new java.awt.CardLayout());

        PanelHome.setBackground(new java.awt.Color(255, 255, 255));
        PanelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-order.png"))); // NOI18N
        btnOrder.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOrder.setBorderPainted(false);
        btnOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrderMouseClicked(evt);
            }
        });
        PanelHome.add(btnOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 130, 100));

        btnGuide.setBackground(new java.awt.Color(255, 255, 255));
        btnGuide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-guide.png"))); // NOI18N
        btnGuide.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuide.setBorderPainted(false);
        btnGuide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuideMouseClicked(evt);
            }
        });
        PanelHome.add(btnGuide, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 130, 100));

        lbStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-staff.png"))); // NOI18N
        PanelHome.add(lbStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, 150));

        btnDailyCheck.setBackground(new java.awt.Color(255, 255, 255));
        btnDailyCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-dailycheck.png"))); // NOI18N
        btnDailyCheck.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDailyCheck.setBorderPainted(false);
        btnDailyCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDailyCheckMouseClicked(evt);
            }
        });
        PanelHome.add(btnDailyCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 130, 100));

        lbOrder.setFont(new java.awt.Font("Noto Sans CJK KR Bold", 1, 14)); // NOI18N
        lbOrder.setText("Đặt Bàn");
        PanelHome.add(lbOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 80, 30));

        lbDailyCheckin.setFont(new java.awt.Font("Noto Sans CJK KR Bold", 1, 14)); // NOI18N
        lbDailyCheckin.setText("Tích Điểm ");
        PanelHome.add(lbDailyCheckin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 90, 30));

        lbHDSD.setFont(new java.awt.Font("Noto Sans CJK SC Bold", 1, 14)); // NOI18N
        lbHDSD.setText("Hướng Dẫn ");
        PanelHome.add(lbHDSD, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 100, 30));

        btnContact.setBackground(new java.awt.Color(255, 255, 255));
        btnContact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-email.png"))); // NOI18N
        btnContact.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnContact.setBorderPainted(false);
        btnContact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnContactMouseClicked(evt);
            }
        });
        PanelHome.add(btnContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 130, 100));

        lbContact.setFont(new java.awt.Font("Noto Sans CJK KR Bold", 1, 14)); // NOI18N
        lbContact.setText("Liên Hệ");
        PanelHome.add(lbContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 90, 30));

        lbWelcome.setFont(new java.awt.Font("Noto Sans CJK TC Thin", 1, 16)); // NOI18N
        lbWelcome.setText("Tôtô xin chúc quý khách có một ngày vui vẻ !");
        PanelHome.add(lbWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 500, 30));

        lbOrder3.setFont(new java.awt.Font("Noto Sans CJK KR Thin", 1, 16)); // NOI18N
        lbOrder3.setText("NameUser,");
        PanelHome.add(lbOrder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 110, 30));

        lbOrder2.setFont(new java.awt.Font("Noto Sans CJK JP Thin", 1, 16)); // NOI18N
        lbOrder2.setText("Xin Chào");
        PanelHome.add(lbOrder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 90, 30));

        lbWelcome1.setFont(new java.awt.Font("Noto Sans CJK JP Thin", 1, 16)); // NOI18N
        lbWelcome1.setText("TechCoffe hân hạnh được phục vụ quý khách !");
        PanelHome.add(lbWelcome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 500, 30));

        Container.add(PanelHome, "card2");

        PanelDatban.setBackground(new java.awt.Color(255, 255, 255));
        PanelDatban.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSo1.setBackground(new java.awt.Color(255, 255, 255));
        btnSo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-table.png"))); // NOI18N
        btnSo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSo1.setBorderPainted(false);
        btnSo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSo1MouseClicked(evt);
            }
        });
        PanelDatban.add(btnSo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 100));

        btnSo2.setBackground(new java.awt.Color(255, 255, 255));
        btnSo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-table.png"))); // NOI18N
        btnSo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSo2.setBorderPainted(false);
        btnSo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSo2MouseClicked(evt);
            }
        });
        PanelDatban.add(btnSo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 130, 100));

        btnSo3.setBackground(new java.awt.Color(255, 255, 255));
        btnSo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-table.png"))); // NOI18N
        btnSo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSo3.setBorderPainted(false);
        btnSo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSo3MouseClicked(evt);
            }
        });
        PanelDatban.add(btnSo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 130, 100));

        btnSo4.setBackground(new java.awt.Color(255, 255, 255));
        btnSo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-table.png"))); // NOI18N
        btnSo4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSo4.setBorderPainted(false);
        btnSo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSo4MouseClicked(evt);
            }
        });
        PanelDatban.add(btnSo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 130, 100));

        btnSo5.setBackground(new java.awt.Color(255, 255, 255));
        btnSo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-table.png"))); // NOI18N
        btnSo5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSo5.setBorderPainted(false);
        btnSo5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSo5MouseClicked(evt);
            }
        });
        PanelDatban.add(btnSo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 130, 100));

        btnSo6.setBackground(new java.awt.Color(255, 255, 255));
        btnSo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-table.png"))); // NOI18N
        btnSo6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSo6.setBorderPainted(false);
        btnSo6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSo6MouseClicked(evt);
            }
        });
        PanelDatban.add(btnSo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 130, 100));

        btnSo7.setBackground(new java.awt.Color(255, 255, 255));
        btnSo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-table.png"))); // NOI18N
        btnSo7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSo7.setBorderPainted(false);
        btnSo7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSo7MouseClicked(evt);
            }
        });
        PanelDatban.add(btnSo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 130, 100));

        btnSo8.setBackground(new java.awt.Color(255, 255, 255));
        btnSo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-table.png"))); // NOI18N
        btnSo8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSo8.setBorderPainted(false);
        btnSo8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSo8MouseClicked(evt);
            }
        });
        PanelDatban.add(btnSo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 130, 100));

        btnSo9.setBackground(new java.awt.Color(255, 255, 255));
        btnSo9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-table.png"))); // NOI18N
        btnSo9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSo9.setBorderPainted(false);
        btnSo9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSo9MouseClicked(evt);
            }
        });
        PanelDatban.add(btnSo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 130, 100));

        btnSo10.setBackground(new java.awt.Color(255, 255, 255));
        btnSo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-table.png"))); // NOI18N
        btnSo10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSo10.setBorderPainted(false);
        btnSo10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSo10MouseClicked(evt);
            }
        });
        PanelDatban.add(btnSo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 130, 100));

        lbSo1.setFont(new java.awt.Font("Noto Sans CJK KR Bold", 1, 14)); // NOI18N
        lbSo1.setText("Bàn Số 1");
        PanelDatban.add(lbSo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 90, 30));

        lbSo2.setFont(new java.awt.Font("Noto Sans CJK KR Bold", 1, 14)); // NOI18N
        lbSo2.setText("Bàn Số 2");
        PanelDatban.add(lbSo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 90, 30));

        lbSo3.setFont(new java.awt.Font("Noto Sans CJK KR Bold", 1, 14)); // NOI18N
        lbSo3.setText("Bàn Số 3");
        PanelDatban.add(lbSo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 90, 30));

        lbSo4.setFont(new java.awt.Font("Noto Sans CJK KR Bold", 1, 14)); // NOI18N
        lbSo4.setText("Bàn Số 4");
        PanelDatban.add(lbSo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 90, 30));

        lbSo5.setFont(new java.awt.Font("Noto Sans CJK KR Bold", 1, 14)); // NOI18N
        lbSo5.setText("Bàn Số 5");
        PanelDatban.add(lbSo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 90, 30));

        lbSo6.setFont(new java.awt.Font("Noto Sans CJK KR Bold", 1, 14)); // NOI18N
        lbSo6.setText("Bàn Số 6");
        PanelDatban.add(lbSo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 90, 30));

        lbSo7.setFont(new java.awt.Font("Noto Sans CJK KR Bold", 1, 14)); // NOI18N
        lbSo7.setText("Bàn Số 7");
        PanelDatban.add(lbSo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 90, 30));

        lbSo8.setFont(new java.awt.Font("Noto Sans CJK KR Bold", 1, 14)); // NOI18N
        lbSo8.setText("Bàn Số 8");
        PanelDatban.add(lbSo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 90, 30));

        lbSo9.setFont(new java.awt.Font("Noto Sans CJK KR Bold", 1, 14)); // NOI18N
        lbSo9.setText("Bàn Số 9");
        PanelDatban.add(lbSo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 90, 30));

        lbSo10.setFont(new java.awt.Font("Noto Sans CJK KR Bold", 1, 14)); // NOI18N
        lbSo10.setText("Bàn Số 10");
        PanelDatban.add(lbSo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 90, 30));

        lbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-back.png"))); // NOI18N
        lbBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBackMouseClicked(evt);
            }
        });
        PanelDatban.add(lbBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, -1, 60));

        Container.add(PanelDatban, "card3");

        PanelTichdiem.setBackground(new java.awt.Color(255, 255, 255));
        PanelTichdiem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack1.setBackground(new java.awt.Color(255, 255, 255));
        btnBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-back.png"))); // NOI18N
        btnBack1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack1.setBorderPainted(false);
        btnBack1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBack1MouseClicked(evt);
            }
        });
        PanelTichdiem.add(btnBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 325, 130, 100));

        Container.add(PanelTichdiem, "card3");

        PanelHuongdan.setBackground(new java.awt.Color(255, 255, 255));
        PanelHuongdan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack2.setBackground(new java.awt.Color(255, 255, 255));
        btnBack2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-back.png"))); // NOI18N
        btnBack2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack2.setBorderPainted(false);
        btnBack2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBack2MouseClicked(evt);
            }
        });
        PanelHuongdan.add(btnBack2, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 325, 130, 100));

        Container.add(PanelHuongdan, "card3");

        PanelLienhe.setBackground(new java.awt.Color(255, 255, 255));
        PanelLienhe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack3.setBackground(new java.awt.Color(255, 255, 255));
        btnBack3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/techcoffee/Images/ic-back.png"))); // NOI18N
        btnBack3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack3.setBorderPainted(false);
        btnBack3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBack3MouseClicked(evt);
            }
        });
        PanelLienhe.add(btnBack3, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 325, 130, 100));

        Container.add(PanelLienhe, "card3");

        PanelFormDB.setBackground(new java.awt.Color(255, 255, 255));
        PanelFormDB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Hủy Đặt");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        PanelFormDB.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, -1, -1));

        Container.add(PanelFormDB, "card3");

        getContentPane().add(Container, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 700, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_4MousePressed
        // TODO add your handling code here:
        setColor(btn_4);
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{btn_2,btn_3,btn_5},new JPanel[]{ind_2,ind_3,ind_5});
    }//GEN-LAST:event_btn_4MousePressed

    private void btn_5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_5MousePressed
        // TODO add your handling code here:
        setColor(btn_5);
        ind_5.setOpaque(true);
        resetColor(new JPanel[]{btn_2,btn_3,btn_4},new JPanel[]{ind_2,ind_3,ind_4});
    }//GEN-LAST:event_btn_5MousePressed

    private void btn_3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_3MousePressed
        // TODO add your handling code here:
        setColor(btn_3);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_2,btn_5,btn_4},new JPanel[]{ind_2,ind_5,ind_4});
    }//GEN-LAST:event_btn_3MousePressed

    private void btn_2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_2MousePressed
        // TODO add your handling code here:
        setColor(btn_2);
        ind_2.setOpaque(true);
        resetColor(new JPanel[]{btn_4,btn_3,btn_5},new JPanel[]{ind_4,ind_3,ind_5});
    }//GEN-LAST:event_btn_2MousePressed

    //Drag window 
    int xx,xy;
    private void topPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanelMousePressed
        // TODO add your handling code here:
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_topPanelMousePressed

    private void topPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanelMouseDragged
        // TODO add your handling code here:
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_topPanelMouseDragged

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        dungXong(bann);
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrderMouseClicked
        // TODO add your handling code here:
        switchPanel(PanelDatban);
    }//GEN-LAST:event_btnOrderMouseClicked

    private void btnBack1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack1MouseClicked
        // TODO add your handling code here:
        switchPanel(PanelHome);
    }//GEN-LAST:event_btnBack1MouseClicked

    private void btnBack2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack2MouseClicked
        // TODO add your handling code here:
        switchPanel(PanelHome);
    }//GEN-LAST:event_btnBack2MouseClicked

    private void btnBack3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBack3MouseClicked
        // TODO add your handling code here:
        switchPanel(PanelHome);
    }//GEN-LAST:event_btnBack3MouseClicked

    private void btnDailyCheckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDailyCheckMouseClicked
        // TODO add your handling code here:
        switchPanel(PanelTichdiem);
    }//GEN-LAST:event_btnDailyCheckMouseClicked

    private void btnGuideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuideMouseClicked
        // TODO add your handling code here:
        switchPanel(PanelHuongdan);
    }//GEN-LAST:event_btnGuideMouseClicked

    private void btnContactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContactMouseClicked
        // TODO add your handling code here:
        switchPanel(PanelLienhe);
    }//GEN-LAST:event_btnContactMouseClicked

    private void btnSo10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSo10MouseClicked
        // TODO add your handling code here:
        bann="So10";
        int temp;
        temp=getStatus(bann);
        if(temp==2)
            JOptionPane.showMessageDialog(this,"Bàn đang được người khác đặt");
        else{
        dangDat(bann);
        switchPanel(PanelFormDB);
        }
    }//GEN-LAST:event_btnSo10MouseClicked

    private void btnSo9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSo9MouseClicked
        // TODO add your handling code here:
        bann="So9";
        int temp;
        temp=getStatus(bann);
        if(temp==2)
            JOptionPane.showMessageDialog(this,"Bàn đang được người khác đặt");
        else{
        dangDat(bann);
        switchPanel(PanelFormDB);
        }
    }//GEN-LAST:event_btnSo9MouseClicked

    private void btnSo8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSo8MouseClicked
        // TODO add your handling code here:
        bann="So8";
        int temp;
        temp=getStatus(bann);
        if(temp==2)
            JOptionPane.showMessageDialog(this,"Bàn đang được người khác đặt");
        else{
        dangDat(bann);
        switchPanel(PanelFormDB);
        }
    }//GEN-LAST:event_btnSo8MouseClicked

    private void btnSo7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSo7MouseClicked
        // TODO add your handling code here:
        bann="So7";
        int temp;
        temp=getStatus(bann);
        if(temp==2)
            JOptionPane.showMessageDialog(this,"Bàn đang được người khác đặt");
        else{
        dangDat(bann);
        switchPanel(PanelFormDB);
        }
    }//GEN-LAST:event_btnSo7MouseClicked

    private void btnSo6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSo6MouseClicked
        // TODO add your handling code here:
        bann="So6";
        int temp;
        temp=getStatus(bann);
        if(temp==2)
            JOptionPane.showMessageDialog(this,"Bàn đang được người khác đặt");
        else{
        dangDat(bann);
        switchPanel(PanelFormDB);
        }
    }//GEN-LAST:event_btnSo6MouseClicked

    private void btnSo5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSo5MouseClicked
        // TODO add your handling code here:
        bann="So5";
        int temp;
        temp=getStatus(bann);
        if(temp==2)
            JOptionPane.showMessageDialog(this,"Bàn đang được người khác đặt");
        else{
        dangDat(bann);
        switchPanel(PanelFormDB);
        }
    }//GEN-LAST:event_btnSo5MouseClicked

    private void btnSo4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSo4MouseClicked
        // TODO add your handling code here:
        bann="So4";
        int temp;
        temp=getStatus(bann);
        if(temp==2)
            JOptionPane.showMessageDialog(this,"Bàn đang được người khác đặt");
        else{
        dangDat(bann);
        switchPanel(PanelFormDB);
        }
    }//GEN-LAST:event_btnSo4MouseClicked

    private void btnSo3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSo3MouseClicked
        // TODO add your handling code here:
        bann="So3";
        int temp;
        temp=getStatus(bann);
        if(temp==2)
            JOptionPane.showMessageDialog(this,"Bàn đang được người khác đặt");
        else{
        dangDat(bann);
        switchPanel(PanelFormDB);
        }
    }//GEN-LAST:event_btnSo3MouseClicked

    private void btnSo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSo2MouseClicked
        // TODO add your handling code here:
        soban=2;
        bann="So2";
        int temp;
        temp=getStatus(bann);
        if(temp==2)
            JOptionPane.showMessageDialog(this,"Bàn đang được người khác đặt");
        else{
        dangDat(bann);
        switchPanel(PanelFormDB);
        }
    }//GEN-LAST:event_btnSo2MouseClicked

    private void btnSo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSo1MouseClicked
        // TODO add your handling code here:
        soban=1;
        bann="So1";
        int temp;
        temp=getStatus(bann);
        if(temp==2)
            JOptionPane.showMessageDialog(this,"Bàn đang được người khác đặt");
        else{
        dangDat(bann);
        switchPanel(PanelFormDB);
        }
        
//        int temp;
//        temp=getStatus(soban);
//        if(temp==2)
//            JOptionPane.showMessageDialog(this,"Bàn đang được người khác đặt");
    }//GEN-LAST:event_btnSo1MouseClicked

    private void lbBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackMouseClicked
        // TODO add your handling code here:
        switchPanel(PanelHome);
    }//GEN-LAST:event_lbBackMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Login login=new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        dungXong(bann);
        switchPanel(PanelDatban);
        
    }//GEN-LAST:event_jButton1MouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeUser().setVisible(true);
            }
        });
    }

    private void setColor(JPanel pane){
        pane.setBackground(new Color(45,57,80));
    }
    
    private void resetColor(JPanel [] pane, JPanel [] indicators){
        for(int i=0; i<pane.length; i++){
            pane[i].setBackground(new Color(32,90,180));
        }
        for(int i=0; i<indicators.length; i++){
            indicators[i].setOpaque(false);
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel PanelDatban;
    private javax.swing.JPanel PanelFormDB;
    private javax.swing.JPanel PanelHome;
    private javax.swing.JPanel PanelHuongdan;
    private javax.swing.JPanel PanelLienhe;
    private javax.swing.JPanel PanelTichdiem;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnBack3;
    private javax.swing.JButton btnContact;
    private javax.swing.JButton btnDailyCheck;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGuide;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnSo1;
    private javax.swing.JButton btnSo10;
    private javax.swing.JButton btnSo2;
    private javax.swing.JButton btnSo3;
    private javax.swing.JButton btnSo4;
    private javax.swing.JButton btnSo5;
    private javax.swing.JButton btnSo6;
    private javax.swing.JButton btnSo7;
    private javax.swing.JButton btnSo8;
    private javax.swing.JButton btnSo9;
    private javax.swing.JPanel btn_2;
    private javax.swing.JPanel btn_3;
    private javax.swing.JPanel btn_4;
    private javax.swing.JPanel btn_5;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_4;
    private javax.swing.JPanel ind_5;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbBack;
    private javax.swing.JLabel lbContact;
    private javax.swing.JLabel lbDailyCheckin;
    private javax.swing.JLabel lbDay;
    private javax.swing.JLabel lbHDSD;
    private javax.swing.JLabel lbNameUser;
    private javax.swing.JLabel lbOrder;
    private javax.swing.JLabel lbOrder2;
    private javax.swing.JLabel lbOrder3;
    private javax.swing.JLabel lbSo1;
    private javax.swing.JLabel lbSo10;
    private javax.swing.JLabel lbSo2;
    private javax.swing.JLabel lbSo3;
    private javax.swing.JLabel lbSo4;
    private javax.swing.JLabel lbSo5;
    private javax.swing.JLabel lbSo6;
    private javax.swing.JLabel lbSo7;
    private javax.swing.JLabel lbSo8;
    private javax.swing.JLabel lbSo9;
    private javax.swing.JLabel lbStaff;
    private javax.swing.JLabel lbThu;
    private javax.swing.JLabel lbThu2;
    private javax.swing.JLabel lbThu3;
    private javax.swing.JLabel lbThu4;
    private javax.swing.JLabel lbThu5;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbWelcome;
    private javax.swing.JLabel lbWelcome1;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
