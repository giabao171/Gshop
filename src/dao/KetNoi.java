package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {

	public Connection cn;
    public void KetNoi() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Da xac dinh HQTCSDL");
            String url = "jdbc:sqlserver://LAPTOP-NBTB1CPB:1433;databaseName=Gshop;user=sa; password=0338876816";
            //String url =  "jdbc:sqlserver://DESKTOP-QII8E8O:1433;databaseName=tenCSDL;user=sa; password=123456";
            cn=DriverManager.getConnection(url);
            System.out.println("connected");

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        KetNoi kn = new KetNoi();
        kn.KetNoi();
    }
	
}
