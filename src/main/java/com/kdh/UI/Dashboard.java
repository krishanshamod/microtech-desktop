package com.kdh.UI;
import com.kdh.database.DataModifier;
import com.kdh.database.DataRetriever;
import com.kdh.database.SQLDatabase;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;


public class Dashboard extends javax.swing.JFrame {
    
    DefaultTableModel itemsTable;
    DefaultTableModel ordersTable;
    DefaultTableModel userTable;
    DefaultTableModel adminTable;
    SQLDatabase sqldatabase;
    DataModifier dataModifier;
    Connection connection;
    DataRetriever dataRetriever;
    String userName;

    /**
     * Creates new form Dashboard
     */
    public Dashboard(String userName) throws SQLException {
        this.userName = userName;
        System.out.println(userName);
        initComponents(); 
        this.sqldatabase = new SQLDatabase("jdbc:mysql://localhost:8889/microtech", "root", "root");
        this.connection = sqldatabase.getConnection();
        this.dataModifier = new DataModifier(connection);
        this.dataRetriever = new DataRetriever(connection);
        
        CreateTableColumns();
        AddTableData();
        AddStatisticData();
    }

    public String getWelcomeStatement() {
        return "Welcome " + this.userName;
    }
    
    private void AddStatisticData(){
        
        jLabel54.setText(dataRetriever.retrieveNumberOfNewOrders().toString()); 
        jLabel27.setText("LKR ".concat(dataRetriever.retrieveDailyRevenue().toString()).concat(" /="));
        jLabel76.setText(dataRetriever.retrieveNumberOfNewUsers().toString());
        jLabel56.setText(dataRetriever.retrieveNumberOfDeliveredOrders().toString());
        jLabel58.setText(dataRetriever.retrieveNumberOfPendingOrders().toString());
        jLabel78.setText(dataRetriever.retrieveNumberOfCancelledOrders().toString());
        
    }
    
    private void CreateTableColumns () {
        itemsTable = (DefaultTableModel)jTable1.getModel();
        ordersTable = (DefaultTableModel)jTable2.getModel();
        userTable = (DefaultTableModel)jTable3.getModel();
        adminTable = (DefaultTableModel)jTable4.getModel();
                
        //Add Cols
        itemsTable.addColumn("Item Name");
        itemsTable.addColumn("Category");
        itemsTable.addColumn("Brand");
        itemsTable.addColumn("Item Price");
        
        ordersTable.addColumn("Order ID");
        ordersTable.addColumn("Item Name");
        ordersTable.addColumn("No of Items");
        ordersTable.addColumn("User Name");
        ordersTable.addColumn("User Address");
        ordersTable.addColumn("User Phone");
        ordersTable.addColumn("Status");
        
        userTable.addColumn("Email");
        userTable.addColumn("User Name");
        userTable.addColumn("Phone");
        userTable.addColumn("Address");
        userTable.addColumn("Verified");
        
        adminTable.addColumn("Admin Email");
        adminTable.addColumn("First Name");
        adminTable.addColumn("Last Name");

        jTable1.getTableHeader().setBackground(Color.decode("#cecef0"));
        jTable2.getTableHeader().setBackground(Color.decode("#cecef0"));
        jTable3.getTableHeader().setBackground(Color.decode("#cecef0"));
        jTable4.getTableHeader().setBackground(Color.decode("#cecef0"));
    }
    
    private void AddTableData() throws SQLException{
        ResultSet itemResults = dataRetriever.retrieveDataFromItemsTable();
        while (itemResults.next()) {
            String name = itemResults.getString("item_name");
            String cat = itemResults.getString("category");
            String brand = itemResults.getString("brand");
            String price = itemResults.getString("item_price");
            
            itemsTable.addRow(new Object[]{name, cat, brand, price});
        }
        
        ResultSet usersResults = dataRetriever.retrieveDataFromUsersTable();
        while (usersResults.next()) {
            String email = usersResults.getString("email");
            String name = usersResults.getString("f_name").concat(" ").concat(usersResults.getString("l_name"));
            String phone = usersResults.getString("phone_no");
            String address = usersResults.getString("addr_line1").concat(", ").concat(usersResults.getString("addr_line2")).concat(", ").concat(usersResults.getString("city")).concat(", ").concat(usersResults.getString("country"));
            String status = usersResults.getString("status");
            
            userTable.addRow(new Object[]{email, name, phone, address, status});
        }
        
        ResultSet adminResults = dataRetriever.retrieveDataFromAdminsTable();
        while (adminResults.next()) {
            String email = adminResults.getString("email");
            String fname = adminResults.getString("f_name");
            String lname = adminResults.getString("l_name");
            adminTable.addRow(new Object[]{email, fname, lname});
        }
        
        ResultSet ordersResults = dataRetriever.retrieveOrderData();
        while(ordersResults.next()) {
            String id = ordersResults.getString("order_id");
            String itemname = ordersResults.getString("item_name");
            String noofitems = ordersResults.getString("no_of_items");
            String name = ordersResults.getString("f_name").concat(" ").concat(ordersResults.getString("l_name"));
            String address = ordersResults.getString("addr_line1").concat(", ").concat(ordersResults.getString("addr_line2")).concat(", ").concat(ordersResults.getString("city")).concat(", ").concat(ordersResults.getString("country"));
            String phone = ordersResults.getString("phone_no");
            String status = ordersResults.getString("status");
            
            ordersTable.addRow(new Object[]{id, itemname, noofitems, name, address, phone, status });
            
        }
    }
    //Add row data
    private void Populate(String name, String cat, String brand, String price){
        
        String[] rowData = {name,cat,brand,price};
        itemsTable.addRow(rowData);
        
        //Add
        dataModifier.addItem(name, cat, brand, price);
    
    }
    
    
    private void AdminPopulate(String fname, String lname, String email, String pass){
        
        String[] rowData = {email,fname,lname};
        adminTable.addRow(rowData);
        
        //Add
        dataModifier.addAdmin(fname,lname, email, pass);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel10 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jPanel11 = new javax.swing.JPanel();
        removeRow = new javax.swing.JButton();
        addRow = new javax.swing.JButton();
        updateRow = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        priceText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        catText = new javax.swing.JTextField();
        brandText = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        delivered = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        pending = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jPanel12 = new javax.swing.JPanel();
        removeRow4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        jPanel14 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        adminNameText1 = new javax.swing.JTextField();
        addRow1 = new javax.swing.JButton();
        adminEmailText = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        adminPassText = new javax.swing.JTextField();
        removeRow5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel50 = new javax.swing.JLabel();
        adminNameText = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        jPanel15 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(42, 39, 41));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(42, 39, 41));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        jLabel2.setBackground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("jLabel2");
        jLabel2.setOpaque(true);
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Home");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 50));

        jPanel4.setBackground(new java.awt.Color(42, 39, 41));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/009.png"))); // NOI18N
        jLabel4.setText("jLabel1");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        jLabel5.setBackground(new java.awt.Color(102, 102, 255));
        jLabel5.setText("jLabel2");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Inventory");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 180, 50));

        jPanel5.setBackground(new java.awt.Color(42, 39, 41));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery.png"))); // NOI18N
        jLabel7.setText("jLabel1");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        jLabel8.setBackground(new java.awt.Color(102, 102, 255));
        jLabel8.setText("jLabel2");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Orders");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 180, 50));

        jPanel6.setBackground(new java.awt.Color(42, 39, 41));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/002_1.png"))); // NOI18N
        jLabel10.setText("jLabel1");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        jLabel11.setBackground(new java.awt.Color(102, 102, 255));
        jLabel11.setText("jLabel2");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Users");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 180, 50));

        jPanel7.setBackground(new java.awt.Color(42, 39, 41));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/007.png"))); // NOI18N
        jLabel13.setText("jLabel1");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        jLabel14.setBackground(new java.awt.Color(102, 102, 255));
        jLabel14.setText("jLabel2");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Admin");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 180, 50));

        jPanel8.setBackground(new java.awt.Color(42, 39, 41));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/006.png"))); // NOI18N
        jLabel16.setText("jLabel1");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 30, 30));

        jLabel17.setBackground(new java.awt.Color(102, 102, 255));
        jLabel17.setText("jLabel2");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Contact");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 180, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 550));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jLabel21.setText("jLabel21");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 290, 90));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/closing.png"))); // NOI18N
        jLabel24.setToolTipText("LogOut");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        jLabel52.setBackground(new java.awt.Color(204, 204, 255));
        jLabel52.setFont(new java.awt.Font("Lucida Grande", 0, 28)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(102, 102, 102));
        jLabel52.setText(getWelcomeStatement());
        jPanel9.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 350, 40));

        jLabel53.setBackground(new java.awt.Color(102, 102, 255));
        jLabel53.setOpaque(true);
        jPanel9.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 10));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 720, 120));

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame1.setBorder(null);
        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(204, 204, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(51, 0, 153), java.awt.Color.gray));

        jLabel27.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("0");

        jLabel51.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Daily Revenue");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel51))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel51)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 260, 150));

        jPanel18.setBackground(new java.awt.Color(204, 204, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(51, 0, 153), java.awt.Color.gray));

        jLabel54.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("0");

        jLabel55.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("New Orders");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel54))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel55)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel55)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 190, 150));

        jPanel19.setBackground(new java.awt.Color(194, 242, 200));
        jPanel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(51, 0, 153), java.awt.Color.gray));
        jPanel19.setToolTipText("");

        jLabel56.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("0");

        jLabel62.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Delivered");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel56))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel62)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel62)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 190, 150));

        jPanel20.setBackground(new java.awt.Color(254, 204, 205));
        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(51, 0, 153), java.awt.Color.gray));

        jLabel59.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Pending");

        jLabel58.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("0");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel58))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel59)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel59)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 260, 150));

        jLabel57.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(153, 153, 153));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Orders Status");
        jPanel10.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jPanel22.setBackground(new java.awt.Color(204, 204, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(51, 0, 153), java.awt.Color.gray));

        jLabel76.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("0");

        jLabel77.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("New Users");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel77)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel76)
                .addGap(84, 84, 84))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel77)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 190, 150));

        jPanel23.setBackground(new java.awt.Color(204, 204, 204));
        jPanel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(51, 0, 153), java.awt.Color.gray));

        jLabel78.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("0");

        jLabel79.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("Cancelled");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel78)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel79)
                .addGap(34, 34, 34))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel78)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel79)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 190, 150));

        jInternalFrame1.getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 490));

        jDesktopPane1.add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -40, 760, 490));

        jInternalFrame2.setBorder(null);
        jInternalFrame2.setVisible(false);
        jInternalFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        removeRow.setBackground(new java.awt.Color(204, 204, 255));
        removeRow.setText("Remove");
        removeRow.setToolTipText("");
        removeRow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeRowMouseClicked(evt);
            }
        });
        removeRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRowActionPerformed(evt);
            }
        });
        jPanel11.add(removeRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 140, 40));

        addRow.setText("Add");
        addRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowActionPerformed(evt);
            }
        });
        jPanel11.add(addRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 140, 40));

        updateRow.setText("Update");
        updateRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRowActionPerformed(evt);
            }
        });
        jPanel11.add(updateRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 140, 40));

        jLabel29.setText("Item Price  :");
        jPanel11.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabel31.setText("Category    : ");
        jPanel11.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel32.setText("Brand         : ");
        jPanel11.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));
        jPanel11.add(priceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 270, -1));
        jPanel11.add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 270, -1));

        catText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catTextActionPerformed(evt);
            }
        });
        jPanel11.add(catText, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 270, -1));
        jPanel11.add(brandText, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 270, -1));

        jLabel33.setText("Item Name : ");
        jPanel11.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setGridColor(new java.awt.Color(204, 204, 255));
        jTable1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel11.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 640, 170));

        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        jPanel11.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 640, 200));

        jInternalFrame2.getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 13, 720, 460));

        jDesktopPane1.add(jInternalFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -40, 760, 490));
        jInternalFrame2.getAccessibleContext().setAccessibleName("0");
        jInternalFrame2.getAccessibleContext().setAccessibleDescription("0");

        jInternalFrame3.setBorder(null);
        jInternalFrame3.setVisible(false);
        jInternalFrame3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setGridColor(new java.awt.Color(204, 204, 255));
        jTable2.setSelectionBackground(new java.awt.Color(102, 102, 255));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel13.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 680, 190));

        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jPanel13.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jLabel35.setText("User Name     : ");
        jPanel13.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel36.setText("User Address : ");
        jPanel13.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        delivered.setBackground(new java.awt.Color(204, 204, 255));
        delivered.setText("Delivered");
        delivered.setToolTipText("");
        delivered.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deliveredMouseClicked(evt);
            }
        });
        delivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveredActionPerformed(evt);
            }
        });
        jPanel13.add(delivered, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 140, 40));

        jLabel30.setText("User Phone    :");
        jPanel13.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabel37.setText("Item Name     : ");
        jPanel13.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jPanel13.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, -1, -1));

        jLabel39.setText("Order ID :");
        jPanel13.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));

        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jPanel13.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jPanel13.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jLabel42.setForeground(new java.awt.Color(102, 102, 102));
        jPanel13.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        jLabel43.setText("No of Items : ");
        jPanel13.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        jLabel44.setText("Status : ");
        jPanel13.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        jLabel45.setForeground(new java.awt.Color(102, 102, 102));
        jPanel13.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        cancel.setBackground(new java.awt.Color(204, 204, 255));
        cancel.setToolTipText("");
        cancel.setLabel("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel13.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 140, 40));

        pending.setBackground(new java.awt.Color(204, 204, 255));
        pending.setText("Pending");
        pending.setToolTipText("");
        pending.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pendingMouseClicked(evt);
            }
        });
        pending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingActionPerformed(evt);
            }
        });
        jPanel13.add(pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 140, 40));

        jLabel46.setForeground(new java.awt.Color(102, 102, 102));
        jPanel13.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, -1));

        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        jPanel13.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 680, 200));

        jInternalFrame3.getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 730, 460));

        jDesktopPane1.add(jInternalFrame3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -40, 760, 490));

        jInternalFrame4.setBorder(null);
        jInternalFrame4.setVisible(false);
        jInternalFrame4.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        removeRow4.setBackground(new java.awt.Color(204, 204, 255));
        removeRow4.setText("Remove user");
        removeRow4.setToolTipText("");
        removeRow4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeRow4MouseClicked(evt);
            }
        });
        removeRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRow4ActionPerformed(evt);
            }
        });
        jPanel12.add(removeRow4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 140, 40));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable3.setGridColor(new java.awt.Color(204, 204, 255));
        jTable3.setSelectionBackground(new java.awt.Color(102, 102, 255));
        jScrollPane3.setViewportView(jTable3);

        jPanel12.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 680, 370));

        jInternalFrame4.getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 730, 460));

        jDesktopPane1.add(jInternalFrame4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -40, 760, 490));

        jInternalFrame5.setBorder(null);
        jInternalFrame5.setVisible(false);
        jInternalFrame5.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setText("Last Name    : ");
        jPanel14.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));
        jPanel14.add(adminNameText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 270, -1));

        addRow1.setText("Add");
        addRow1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addRow1MouseClicked(evt);
            }
        });
        addRow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRow1ActionPerformed(evt);
            }
        });
        jPanel14.add(addRow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 140, 40));

        adminEmailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminEmailTextActionPerformed(evt);
            }
        });
        jPanel14.add(adminEmailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 270, -1));

        jLabel48.setText("Admin Email :");
        jPanel14.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel49.setText("Password      : ");
        jPanel14.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));
        jPanel14.add(adminPassText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 270, -1));

        removeRow5.setBackground(new java.awt.Color(204, 204, 255));
        removeRow5.setText("Remove");
        removeRow5.setToolTipText("");
        removeRow5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeRow5MouseClicked(evt);
            }
        });
        removeRow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRow5ActionPerformed(evt);
            }
        });
        jPanel14.add(removeRow5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 140, 40));

        jTable4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable4.setGridColor(new java.awt.Color(204, 204, 255));
        jTable4.setSelectionBackground(new java.awt.Color(102, 102, 255));
        jTable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel14.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 640, 170));

        jLabel50.setText("First Name    : ");
        jPanel14.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));
        jPanel14.add(adminNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 270, -1));

        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        jPanel14.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 640, 200));

        jInternalFrame5.getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 730, 460));

        jDesktopPane1.add(jInternalFrame5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -40, 760, 490));

        jInternalFrame6.setBorder(null);
        jInternalFrame6.setVisible(false);
        jInternalFrame6.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel25.setBackground(new java.awt.Color(204, 204, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(51, 0, 153), java.awt.Color.gray));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 0, 102));
        jLabel19.setText("Gampaha Branch");

        jLabel22.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Address");

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("DIN Alternate", 2, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("KDH (PVT LTD),");

        jLabel63.setBackground(new java.awt.Color(255, 255, 255));
        jLabel63.setFont(new java.awt.Font("DIN Alternate", 2, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("No. 245,");

        jLabel64.setBackground(new java.awt.Color(255, 255, 255));
        jLabel64.setFont(new java.awt.Font("DIN Alternate", 2, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Asgiriya Garden,");

        jLabel65.setBackground(new java.awt.Color(255, 255, 255));
        jLabel65.setFont(new java.awt.Font("DIN Alternate", 2, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Horana");

        jLabel67.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(102, 102, 102));
        jLabel67.setText("Email");

        jLabel68.setBackground(new java.awt.Color(255, 255, 255));
        jLabel68.setFont(new java.awt.Font("DIN Alternate", 2, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("microtech.kdh@gmail.com");

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(51, 0, 102));
        jLabel69.setText("Head Office");

        jLabel66.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(102, 102, 102));
        jLabel66.setText("Address");

        jLabel70.setBackground(new java.awt.Color(255, 255, 255));
        jLabel70.setFont(new java.awt.Font("DIN Alternate", 2, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("KDH (PVT LTD),");

        jLabel71.setBackground(new java.awt.Color(255, 255, 255));
        jLabel71.setFont(new java.awt.Font("DIN Alternate", 2, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("No. 14/4,");

        jLabel72.setBackground(new java.awt.Color(255, 255, 255));
        jLabel72.setFont(new java.awt.Font("DIN Alternate", 2, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Kompe Road,");

        jLabel73.setBackground(new java.awt.Color(255, 255, 255));
        jLabel73.setFont(new java.awt.Font("DIN Alternate", 2, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Gampaha");

        jLabel74.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(102, 102, 102));
        jLabel74.setText("Email");

        jLabel75.setBackground(new java.awt.Color(255, 255, 255));
        jLabel75.setFont(new java.awt.Font("DIN Alternate", 2, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("kdh.malwaththa@gmail.com");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel68))
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel75)
                                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(82, 82, 82))))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel65))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel73)))
                .addGap(49, 49, 49)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel75))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel68)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 690, 400));

        jInternalFrame6.getContentPane().add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 730, 460));

        jDesktopPane1.add(jInternalFrame6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -40, 760, 490));

        jPanel1.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 720, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        bar(jLabel2);
        jInternalFrame1.setVisible(true);
        jLabel52.setVisible(true);
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(false);
        jInternalFrame6.setVisible(false);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        jPanel3.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        jPanel3.setBackground(Color.decode("#2a2729"));
    }//GEN-LAST:event_jPanel3MouseExited

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new LoginUI().setVisible(true);
            setVisible(false); 
            dispose(); 
        }
    });
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        bar(jLabel5);
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(true);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(false);
        jInternalFrame6.setVisible(false);
        jLabel52.setVisible(false);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        jPanel4.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        jPanel4.setBackground(Color.decode("#2a2729"));
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        bar(jLabel8);
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(true);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(false);
        jInternalFrame6.setVisible(false);
        jLabel52.setVisible(false);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        jPanel5.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        jPanel5.setBackground(Color.decode("#2a2729"));
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        bar(jLabel11);
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(true);
        jInternalFrame5.setVisible(false);
        jInternalFrame6.setVisible(false);
        jLabel52.setVisible(false);
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        jPanel6.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        jPanel6.setBackground(Color.decode("#2a2729"));
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        bar(jLabel14);
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(true);
        jInternalFrame6.setVisible(false);
        jLabel52.setVisible(false);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        jPanel7.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        jPanel7.setBackground(Color.decode("#2a2729"));
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        bar(jLabel17);
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(false);
        jInternalFrame6.setVisible(true);
        jLabel52.setVisible(false);
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        jPanel8.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        jPanel8.setBackground(Color.decode("#2a2729"));
    }//GEN-LAST:event_jPanel8MouseExited

    private void catTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catTextActionPerformed

    }//GEN-LAST:event_catTextActionPerformed

    private void removeRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRowActionPerformed

    }//GEN-LAST:event_removeRowActionPerformed

    private void addRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRowActionPerformed
        Populate(nameText.getText(), catText.getText(), brandText.getText(), priceText.getText());
        
        //CLEAR TEXT
        nameText.setText(""); 
        catText.setText("");
        brandText.setText("");
        priceText.setText("");
    }//GEN-LAST:event_addRowActionPerformed
    
    //UPDATE
    private void updateRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRowActionPerformed
        itemsTable.setValueAt(nameText.getText(), jTable1.getSelectedRow(),0);
        itemsTable.setValueAt(catText.getText(), jTable1.getSelectedRow(),1);
        itemsTable.setValueAt(brandText.getText(), jTable1.getSelectedRow(),2);
        itemsTable.setValueAt(priceText.getText(), jTable1.getSelectedRow(),3);
        
        //UPDATE
        dataModifier.updateItem(nameText.getText(), catText.getText(), brandText.getText(), priceText.getText());        
        
        //CLEAR TEXT
        nameText.setText(""); 
        catText.setText("");
        brandText.setText("");
        priceText.setText("");
    }//GEN-LAST:event_updateRowActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        nameText.setText(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString()); 
        catText.setText(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString());
        brandText.setText(jTable1.getValueAt(jTable1.getSelectedRow(),2).toString());
        priceText.setText(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString());
    }//GEN-LAST:event_jTable1MouseClicked
    
    //REMOVE
    private void removeRowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeRowMouseClicked
        
        //Delete
        dataModifier.deleteItem(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
        itemsTable.removeRow(jTable1.getSelectedRow());
    }//GEN-LAST:event_removeRowMouseClicked

    private void deliveredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliveredMouseClicked

        dataModifier.updateOrderStatus(jTable2.getValueAt(jTable2.getSelectedRow(),0).toString(), "delivered");
        ordersTable.setValueAt("delivered", jTable2.getSelectedRow(),6);
        jLabel45.setText("delivered");
        jLabel45.setForeground (Color.green);
        
    }//GEN-LAST:event_deliveredMouseClicked

    private void deliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deliveredActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        dataModifier.updateOrderStatus(jTable2.getValueAt(jTable2.getSelectedRow(),0).toString(), "cancelled");
        ordersTable.setValueAt("cancelled", jTable2.getSelectedRow(),6);
        jLabel45.setText("cancelled");
        jLabel45.setForeground (Color.gray);
    }//GEN-LAST:event_cancelMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void pendingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingMouseClicked
        dataModifier.updateOrderStatus(jTable2.getValueAt(jTable2.getSelectedRow(),0).toString(), "pending");
        ordersTable.setValueAt("pending", jTable2.getSelectedRow(),6);
        jLabel45.setText("pending");
        jLabel45.setForeground (Color.red);
    }//GEN-LAST:event_pendingMouseClicked

    private void pendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pendingActionPerformed

    private void removeRow4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeRow4MouseClicked
        //Delete
        dataModifier.deleteUser(jTable3.getValueAt(jTable3.getSelectedRow(),0).toString());
        userTable.removeRow(jTable3.getSelectedRow());
    }//GEN-LAST:event_removeRow4MouseClicked

    private void removeRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRow4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeRow4ActionPerformed

    private void addRow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRow1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addRow1ActionPerformed

    private void adminEmailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminEmailTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminEmailTextActionPerformed

    private void removeRow5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeRow5MouseClicked
        dataModifier.deleteAdmin(jTable4.getValueAt(jTable4.getSelectedRow(),0).toString());
        adminTable.removeRow(jTable4.getSelectedRow());
    }//GEN-LAST:event_removeRow5MouseClicked

    private void removeRow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRow5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeRow5ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        adminEmailText.setText(jTable4.getValueAt(jTable4.getSelectedRow(),0).toString()); 
        adminNameText.setText(jTable4.getValueAt(jTable4.getSelectedRow(),1).toString());
        adminNameText1.setText(jTable4.getValueAt(jTable4.getSelectedRow(),2).toString());
    }//GEN-LAST:event_jTable4MouseClicked

    private void addRow1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRow1MouseClicked
        AdminPopulate(adminNameText.getText(), adminNameText1.getText(), adminEmailText.getText(), adminPassText.getText());
        
        //CLEAR TEXT
        adminNameText1.setText(""); 
        adminNameText.setText(""); 
        adminEmailText.setText("");
        adminPassText.setText("");

    }//GEN-LAST:event_addRow1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        jLabel38.setText(jTable2.getValueAt(jTable2.getSelectedRow(),0).toString()); 
        jLabel40.setText(jTable2.getValueAt(jTable2.getSelectedRow(),1).toString());
        jLabel46.setText(jTable2.getValueAt(jTable2.getSelectedRow(),2).toString());
        jLabel41.setText(jTable2.getValueAt(jTable2.getSelectedRow(),3).toString());
        jLabel42.setText(jTable2.getValueAt(jTable2.getSelectedRow(),4).toString());
        jLabel34.setText(jTable2.getValueAt(jTable2.getSelectedRow(),5).toString());
        jLabel45.setText(jTable2.getValueAt(jTable2.getSelectedRow(),6).toString());
                
        if(jTable2.getValueAt(jTable2.getSelectedRow(),6).toString().equals("pending")){
            jLabel45.setForeground (Color.red);
        }else if(jTable2.getValueAt(jTable2.getSelectedRow(),6).toString().equals("delivered")){
            jLabel45.setForeground (Color.green);
        }else{
            jLabel45.setForeground (Color.gray);
        }
    }//GEN-LAST:event_jTable2MouseClicked

  
    public void bar(JLabel lab) {
        jLabel2.setOpaque(false);
        jLabel5.setOpaque(false);
        jLabel8.setOpaque(false);
        jLabel11.setOpaque(false);
        jLabel14.setOpaque(false);
        jLabel17.setOpaque(false);
        lab.setOpaque(true);
        jPanel2.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRow;
    private javax.swing.JButton addRow1;
    private javax.swing.JTextField adminEmailText;
    private javax.swing.JTextField adminNameText;
    private javax.swing.JTextField adminNameText1;
    private javax.swing.JTextField adminPassText;
    private javax.swing.JTextField brandText;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField catText;
    private javax.swing.JButton delivered;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField nameText;
    private javax.swing.JButton pending;
    private javax.swing.JTextField priceText;
    private javax.swing.JButton removeRow;
    private javax.swing.JButton removeRow4;
    private javax.swing.JButton removeRow5;
    private javax.swing.JButton updateRow;
    // End of variables declaration//GEN-END:variables
}
