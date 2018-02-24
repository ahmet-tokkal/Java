import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public abstract class DataTemplate extends Database
{
	abstract void setData(String bName);
	abstract int setID();
	abstract String query(int id);
	abstract void showDialog();
	public final void addDB()
	{
		int id = setID();
		try 
		{
			dbConnect();
			Statement statement;
			statement = conn.createStatement();
			String strSquery= query(id);
			statement.executeUpdate(strSquery);
			showDialog();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
