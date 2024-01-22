package DATA;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectDatabase {

	public static void main(String[] args) {
		

     try {
    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          String url="jdbc:sqlserver://DESKTOP-Q0095O8\\SQLEXPRESS:1433;databaseName=QLBai_giu_xe;trustServerCertificate=true";
          String username="sa";
          String password="123456789";
          Connection connection=DriverManager.getConnection(url,username,password);
         System.out.println("kết nối thành công");
     }
     catch(Exception e)
     {
    	 e.printStackTrace();
     }
	}

}
