
package DATA;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Quan_li_bai_do_xe extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JPanel panelWest;
    private JPanel   panelSouth;

    private JButton btnDelete;
    private JButton btnAdd;
    private JButton btnLoad;
    private JButton btnUpdate;
    private JButton btnfind_bienSoXe;
    private JButton btnfind_MaSo;


    private JTextField tf_MaSo;
    private JTextField tf_bienSoXe;
    private JTextField tf_ThoiGian;
    private JTextField tf_Ngay;
    private JTextField tf_FindBienSo;
    private JTextField tf_FindMaSo;
    private JLabel lblMaSo;
    private JLabel lblThoiGian;
    private JLabel lblNgay;
    private JLabel lblViTri;
    private JLabel lblBienSo;
    private JLabel lblFindMaSo;
    private JLabel lblFindBienSoXe;

    private JTable table;
    private DefaultTableModel tablemodel ;
    private JComboBox<String> comboBox;  
    private JScrollPane scrollPane;
    

    
   private int masovalue;
    private Connection connection;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
  
                try {
                	 new Quan_li_bai_do_xe();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        
    

    /**
     * Create the frame.
     */
    public Quan_li_bai_do_xe() {
    	//khởi tạo thuộc tính
    	   contentPane = new JPanel();
           panelWest = new JPanel();
           panelSouth = new JPanel();

    	  btnDelete = new JButton("Delete");
    	  btnDelete.setBounds(300, 260, 80, 23);
    	  btnUpdate = new JButton("Update");
    	
    	  btnUpdate.setBounds(400, 230, 80, 23);
    	   btnAdd = new JButton("Add");
    	   btnAdd.setBounds(300, 230, 80, 23);
    	     btnLoad = new JButton("Load");
           
            btnLoad.setBounds(400, 260, 80, 23);
            btnfind_bienSoXe = new JButton("find");
            btnfind_bienSoXe.setBounds(172, 228, 71, 23);
            btnfind_MaSo = new JButton("find");
            btnfind_MaSo.setBounds(168, 259, 75, 23);
            tf_MaSo = new JTextField();
            tf_MaSo.setBounds(75, 17, 66, 20);
            tf_bienSoXe = new JTextField();
            tf_bienSoXe.setBounds(75, 48, 66, 20);
            tf_ThoiGian = new JTextField();
            tf_ThoiGian.setEditable(false);
            tf_ThoiGian.setBounds(75, 79, 66, 20);
            tf_Ngay = new JTextField();
            tf_Ngay.setEditable(false);
            tf_Ngay.setBounds(75, 116, 100, 20);
            tf_FindBienSo = new JTextField();
            tf_FindBienSo.setBounds(77, 229, 83, 20);

            tf_FindMaSo = new JTextField();
            tf_FindMaSo.setBounds(75, 260, 83, 20);
            lblThoiGian = new JLabel("thời gian");
            lblThoiGian.setBounds(10, 82, 50, 14);
            lblNgay = new JLabel("ngày");
            lblNgay.setBounds(10, 117, 55, 14);
             lblViTri = new JLabel("vị trí");
             lblViTri.setBounds(10, 142, 55, 14);
             lblFindMaSo = new JLabel("mã số");
             lblFindMaSo.setBounds(10, 266, 55, 14);
             lblFindBienSoXe = new JLabel("biển số ");
             lblFindBienSoXe.setBounds(10, 232, 55, 14);
             lblMaSo = new JLabel("mã số");
             lblMaSo.setBounds(10, 21, 55, 14);
             lblBienSo = new JLabel("biển số xe");
             lblBienSo.setBounds(10, 46, 131, 14);
             comboBox = new JComboBox<>(new String[]{"Khu A", "Khu B", "Khu C"});
             comboBox.setBounds(70, 150, 66, 20);

             tablemodel = new DefaultTableModel();
             tablemodel.addColumn("Stt");
             tablemodel.addColumn("mã số");
             tablemodel.addColumn("biển số xe");
             tablemodel.addColumn("thời gian");
             tablemodel.addColumn("ngày");
             tablemodel.addColumn("vị trí");
             
             table = new JTable(tablemodel);
              scrollPane = new JScrollPane(table);
             scrollPane.setBounds(206, 0, 301, 186);
             


           //gắn nghe
           btnDelete.addActionListener(this);
           btnUpdate.addActionListener(this);
           btnAdd.addActionListener(this);
           btnLoad.addActionListener(this);
           btnfind_bienSoXe.addActionListener(this);
           btnfind_MaSo.addActionListener(this);

           
         
          //thiết lập layout
      
        setContentPane(contentPane);
        contentPane.setLayout(null);
        panelWest.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelWest.setBounds(0, 0, 207, 186);
        panelWest.setLayout(null);
        panelSouth.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelSouth.setBounds(0, 187, 507, 136);
        panelSouth.setLayout(null);
        //chèn thành phần 
        contentPane.add(btnDelete);
        contentPane.add(btnUpdate);
        contentPane.add(btnAdd);
        contentPane.add(btnLoad);
        contentPane.add(btnfind_bienSoXe);
        contentPane.add(btnfind_MaSo);
        contentPane.add(tf_MaSo);
        contentPane.add(tf_bienSoXe);
        contentPane.add(tf_ThoiGian);
        contentPane.add(tf_Ngay);
        contentPane.add(tf_FindBienSo);
        contentPane.add(tf_FindMaSo);
        contentPane.add(lblThoiGian);
        contentPane.add(lblNgay);
        contentPane.add(lblViTri);
        contentPane.add(lblMaSo);
        contentPane.add(lblBienSo);
        
        contentPane.add(lblFindBienSoXe);

        contentPane.add(lblFindMaSo);
        
        contentPane.add(scrollPane);

        contentPane.add(comboBox);
        contentPane.add(panelWest);
        contentPane.add(panelSouth);

        // Kết nối đến cơ sở dữ liệu
        connectToDatabase();
     // Load dữ liệu từ cơ sở dữ liệu và cập nhật bảng hiển thị ban đầu
        loadData();
        
     // Thêm sự kiện lắng nghe cho bảng
      table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    	 public void valueChanged(ListSelectionEvent event)
    	  {
    		  if(!event.getValueIsAdjusting()&&table.getSelectedRow()!=-1)
    		  {
    			  displayRecord(table.getSelectedRow());
    		  }
    	  }
      });
        //chỉnh sửa frame
        setTitle("quản lý bãi giữ xe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
		
        setBounds(100,100,525,365);
        setVisible(true);
        
    }

    private void connectToDatabase() {
      try
      {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             String url="jdbc:sqlserver://DESKTOP-Q0095O8\\SQLEXPRESS:1433;databaseName=QLBai_giu_xe;trustServerCertificate=true";
             String username="sa";
             String password="123456789";
             connection=DriverManager.getConnection(url, username, password);
             System.out.println("kết nối thành công");
        }catch(Exception e)
      {
    	  e.printStackTrace();
      }
    }

    private void addRecord() {
    	
    	 try {
    		 int maSo = Integer.parseInt(tf_MaSo.getText());
    	    	String bien_so_xe= tf_bienSoXe.getText();
    		if(checkDuplicate_maso(maSo))
    		{
    			System.out.println("mã số đã trùng");
    			return;
    		}
    		if(checkDuplicate_bienSoXe(bien_so_xe))
    		{
    			System.out.println("biển số đã trùng");
    			return;
    		}
    		    
    	        String sql = "INSERT INTO tblBai_giu_xe ([mã số],[biển số xe],[thời gian],[ngày],[vị trí]) VALUES (?, ?, ?, ?, ?)";
    	        PreparedStatement statement = connection.prepareStatement(sql);
    	            // Kiểm tra nếu giá trị mã số là một số hợp lệ
    	           
    	               
    	                statement.setInt(1, maSo);
    	         

    	            // Thiết lập giá trị cho các tham số khác
    	            statement.setString(2, tf_bienSoXe.getText()); // Giả sử textField là biển số xe
    	            // Lấy giá trị thời gian thực
    	            Date currentTime = new Date();
    	            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    	            String formattedTime = timeFormat.format(currentTime);
    	            statement.setString(3,formattedTime);
    	            tf_ThoiGian.setText(formattedTime);
    	           

    	            // Lấy giá trị ngày thực
    	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	            String formattedDate = dateFormat.format(currentTime);
    	            statement.setString(4,formattedDate);

    	            tf_Ngay.setText(formattedDate);
    	           
    	      
    	            // Lấy giá trị từ JComboBox
    	            statement.setString(5, comboBox.getSelectedItem().toString());

    	            
    	           statement.executeUpdate();
    	        
    	            

    	          
    	            // Load lại dữ liệu từ cơ sở dữ liệu và cập nhật bảng hiển thị
    	            loadData();
    	        
    	    } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void editRecord() {
        try {
        	
        	String sql = "UPDATE tblBai_giu_xe SET [mã số] = ?, [biển số xe] = ?, [thời gian] = ?, [ngày] = ?, [vị trí] = ? WHERE [mã số] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
                // Thiết lập giá trị cho tham số
            	
                statement.setInt(1, Integer.parseInt(tf_MaSo.getText())); // Giả sử textField là mã số
                statement.setString(2, tf_bienSoXe.getText()); // Giả sử textField_1 là biển số xe
                statement.setString(3, tf_ThoiGian.getText()); // Giả sử textField_2 là thời gian
                statement.setString(4, tf_Ngay.getText()); // Giả sử textField_3 là ngày
                statement.setString(5, comboBox.getSelectedItem().toString()); // Giả sử comboBox là vị trí
                statement.setInt(6,masovalue); // 
                // Thực hiện truy vấn sửa
                statement.executeUpdate();

                
                // Load lại dữ liệu từ cơ sở dữ liệu và cập nhật bảng hiển thị
                loadData();
        	
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteRecord() {
        try {
        	if(table.getSelectedRow()!=-1) {
            String sql = "DELETE FROM tblBai_giu_xe WHERE [mã số] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
                  statement.setInt(1, masovalue); // Lấy mã số của bản ghi được chọn từ JTable

                // Thực hiện truy vấn xóa
                statement.executeUpdate();

             
               loadData();
        	}else System.out.println("mời chọn hàng cần xóa");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void findRecords_bienso() {
        try {
            String valueToFind = tf_FindBienSo.getText();
            String sql = "SELECT * FROM tblBai_giu_xe WHERE [biển số xe] = ? ";
           PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, valueToFind);

                ResultSet resultSet = statement.executeQuery();

                clearTable();
              int stt=1;
                while (resultSet.next()) {
                    String column2Value = resultSet.getString("mã số");
                    String column3Value = resultSet.getString("biển số xe");
                    String column4Value = resultSet.getString("thời gian");
                    String column5Value = resultSet.getString("ngày");
                    String column6Value = resultSet.getString("vị trí");

                    tablemodel.addRow(new Object[]{stt++, column2Value, column3Value, column4Value, column5Value,column6Value});
                }

                
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void findRecords_maso() {
        try {
            int valueToFind = Integer.parseInt(tf_FindMaSo.getText());
            String sql = "SELECT * FROM tblBai_giu_xe WHERE [mã số] = ? ";
           PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, valueToFind);
                ResultSet resultSet = statement.executeQuery();

                clearTable();
                int stt=1;

                while (resultSet.next()) {
                	  String column2Value = resultSet.getString("mã số");
                      String column3Value = resultSet.getString("biển số xe");
                      String column4Value = resultSet.getString("thời gian");
                      String column5Value = resultSet.getString("ngày");
                      String column6Value = resultSet.getString("vị trí");

                      tablemodel.addRow(new Object[]{stt++, column2Value, column3Value, column4Value, column5Value,column6Value});
                  }
                statement.executeUpdate();

            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

 

    private void clearTable() {
    	tablemodel.setRowCount(0);
    }
    private void loadData() {
        try {
            String sql = "SELECT * FROM tblBai_giu_xe";
           PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery();

                clearTable();
               
                int stt = 1;
                while (resultSet.next()) {
                    String column2Value = resultSet.getString("mã số");
                    String column3Value = resultSet.getString("biển số xe");
                    String column4Value = resultSet.getString("thời gian");
                    String column5Value = resultSet.getString("ngày");
                    String column6Value = resultSet.getString("vị trí");

                   tablemodel.addRow(new Object[]{stt++, column2Value, column3Value, column4Value, column5Value, column6Value});
                    
                    
                }
                
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void displayRecord(int selectedRow) {
        if (selectedRow != -1) {
            tf_MaSo.setText(tablemodel.getValueAt(selectedRow, 1).toString()); // Giả sử cột 1 là "mã số"
            tf_bienSoXe.setText(tablemodel.getValueAt(selectedRow, 2).toString()); // Giả sử cột 2 là "biển số xe"
            tf_ThoiGian.setText(tablemodel.getValueAt(selectedRow, 3).toString()); // Giả sử cột 3 là "thời gian"
            tf_Ngay.setText(tablemodel.getValueAt(selectedRow, 4).toString()); // Giả sử cột 4 là "ngày"
            comboBox.setSelectedItem(tablemodel.getValueAt(selectedRow, 5).toString()); // Giả sử cột 5 là "vị trí"
            masovalue=Integer.parseInt(tablemodel.getValueAt(selectedRow, 1).toString());
        }
    }
    private boolean checkDuplicate_maso(int maSo) {
        for (int i = 0; i < tablemodel.getRowCount(); i++) {
            int existingMaSo = Integer.parseInt(tablemodel.getValueAt(i, 1).toString());
            if (maSo == existingMaSo) {
                return true; // Mã số đã tồn tại
            }
        }
        return false; // Mã số không tồn tại
    }
    private boolean checkDuplicate_bienSoXe(String bien_so_xe) {
        for (int i = 0; i < tablemodel.getRowCount(); i++) {
            String existingMaSo = tablemodel.getValueAt(i, 2).toString();
            if (existingMaSo.equals(bien_so_xe)) {
                return true; 
            }
        }
        return false; 
    }
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==btnDelete){
    		
    			deleteRecord();
    		
    	}
    	if(e.getSource()==btnUpdate){
    		
    			editRecord();    		
    	}
    	if(e.getSource()==btnAdd){
    		
    		addRecord();
		
	}
    	if(e.getSource()==btnLoad){
    		
          loadData();		
	}
    	if(e.getSource()==btnfind_bienSoXe){
    		
    		findRecords_bienso();		
  	}

    	if(e.getSource()==btnfind_MaSo){
    		
    		findRecords_maso();		
  	}

    	
    }
 
  
   
}