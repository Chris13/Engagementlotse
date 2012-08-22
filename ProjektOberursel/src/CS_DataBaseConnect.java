import java.sql.*;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;


public class CS_DataBaseConnect {
	
	private static ResultSet rs;
	private static DefaultTableModel dtm;
	private static Connection con;
	
	public CS_DataBaseConnect(){}
	
	
	static boolean dbQuery(String sqlAbfrage)
	{
		try
		{			
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e)
		{
			e.toString();
		}
		
		try
		{
			Connection con = null;
			rs = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oberursel2","root","");
			Statement stmsql = null;
			stmsql = con.createStatement();
			rs = stmsql.executeQuery(sqlAbfrage);
			
			if(rs != null)
				myModel(rs);
			
			con.close();
			
			return true;
		}
		catch(Exception ex)
		{			
			if(ex instanceof SQLException)
			{
				System.out.println(ex.getMessage());
				System.out.println(ex.getStackTrace());
			}
			
			return false;
		}
	}
	
	static boolean dbUpdate(String sqlAbfrage)
	{
		try
		{			
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e)
		{
			e.toString();
		}
		
		try
		{
			Connection con = null;
			rs = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oberursel2","root","");
			Statement stmsql = con.createStatement();
			int e = stmsql.executeUpdate(sqlAbfrage);
			
			con.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());

			return false;
		}
	}
	
	
	static DefaultTableModel myModel(ResultSet rs)
	{
		dtm = new DefaultTableModel();
		try
		{	
			ResultSetMetaData metaData = null;
			metaData = rs.getMetaData();
			
			
			int numberofcol = metaData.getColumnCount();
			Vector columnName = new Vector();
			
			for(int column = 0;column < numberofcol; column++)
			{
				columnName.addElement(metaData.getColumnLabel(column+1));
			}
			
			Vector rows = new Vector();
			while(rs.next())
			{
				Vector newRow = new Vector();
			
				for(int i = 1 ; i <= numberofcol ; i++)
				{
					newRow.addElement(rs.getObject(i));
				}
				rows.addElement(newRow);
			}
			
			return dtm = new DefaultTableModel(rows,columnName);
		
		}
		catch(SQLException sqlEx)
		{
			return dtm = null;
		}
		
	}
		
	
	static DefaultTableModel getModel()
	{
		return dtm;	
	}

	

}
