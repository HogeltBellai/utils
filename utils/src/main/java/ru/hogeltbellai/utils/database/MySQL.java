package ru.hogeltbellai.utils.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	
	public Connection connection = null;
    public Statement statmt = null;
    public PreparedStatement preparedStatmt = null;
	
	public MySQL() {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://mysql.joinserver.xyz:3306/s86013_minecraft", "u86013_EUitHD4bg7", "aYhft^pG@4OeHB84A36t.VNg");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
    public void createTables(String table, String column) {
        try {
            statmt = connection.createStatement();
			statmt.execute("CREATE TABLE IF NOT EXISTS "+table+"("+column+")");
			statmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public PreparedStatement preparedStatement(String insert) {
		try {
			preparedStatmt = connection.prepareStatement(insert);
			preparedStatmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatmt;
    }
}
