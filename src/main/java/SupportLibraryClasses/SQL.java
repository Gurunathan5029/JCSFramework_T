package SupportLibraryClasses;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SQL {
	static Connection conn = null;
	static PropertyFileHandling prop = new PropertyFileHandling();
	int size;
	static int count;
	HashMap<String, String> sqlMap = new HashMap<String, String>();
	
	static String database;

	// Connection To Database Created by GG
	public static void sqlConnection() {

		try {
			database = prop.getProperty("sql.database").trim();
			String dbURL = "jdbc:sqlserver://" + prop.getProperty("sql.server").trim() + ";databaseName=" + ""
					+ database + "";
			String user = prop.getProperty("sql.username").trim();
			String pass = prop.getProperty("sql.password").trim();			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(dbURL, user, pass);
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Retrieve data from database Created by GG
	public static String retrieve(String field, String table, String whereFields, String whereValues) {
		sqlConnection();
		Statement statement;
		try {
			statement = conn.createStatement();
			String exten = ".dbo.";
			String query = "select " + "" + field + "" + " from " + "[" + database + "]" + "" + exten + "" + "[" + table
					+ "]" + " where " + "" + whereFields + "" + "=" + "'" + whereValues + "'";
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {				
				return rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Retrieve data from database Created by GG
	public static ArrayList<HashMap<String, String>> retrieve(String field, String table, String whereFields,
			String whereValues, String conditional) {
		sqlConnection();
		Statement statement;
		String selectFields[] = field.split(",");
		String fields[] = whereFields.split(",");
		String values[] = whereValues.split(",");
		String whrFields = "";
		ArrayList<HashMap<String, String>> dbRows = new ArrayList<HashMap<String, String>>();
		if (fields.length > 0 && values.length > 0) {
			for (int i = 0; i <= fields.length - 1; i++) {
				whrFields = whrFields + fields[i].trim() + "=" + "'" + values[i] + "'";
				if (!(fields.length - (i + 1) == 0)) {
					whrFields = whrFields + " " + conditional + " ";
				}
			}
		}

		try {
			statement = conn.createStatement();
			String exten = ".dbo.";
			String query = "select " + "" + field + "" + " from " + "[" + database + "]" + "" + exten + "" + "[" + table
					+ "]" + " where " + "" + whrFields;
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				HashMap<String, String> hm = new HashMap<String, String>();
				for (int i = 0; i <= selectFields.length - 1; i++) {
					hm.put(selectFields[i].trim(), rs.getString(selectFields[i].trim()));
				}
				dbRows.add(hm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbRows;
	}

	// Retrieve data from database Created by GG
	public static String retrieveBySorting(String field, String table, String wherefield, String wherevalue, String sortColumn,
			String sortOrder) {
		sqlConnection();
		Statement statement;
		if (sortOrder.isEmpty()) {
			sortOrder = "DESC";
		}
		try {
			statement = conn.createStatement();
			String exten = ".dbo.";
			String query = "select " + "" + field + "" + " from " + "[" + database + "]" + "" + exten + "" + "[" + table
					+ "]" + " where " + "" + wherefield + "" + "=" + "'" + wherevalue + "'" + " ORDER BY " + sortColumn
					+ " " + sortOrder;
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {				
				return rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Retrieve data from database Created by GG
	public static ArrayList<HashMap<String, String>> retrieveBySorting(String fields, String table, String whereFields,
			String whereValues, String sortColumn, String sortOrder, String conditional) {
		sqlConnection();
		Statement statement;
		if (sortOrder.isEmpty()) {
			sortOrder = "DESC";
		}
		String selectFields[] = fields.split(",");
		String whrFields[] = whereFields.split(",");
		String whrValues[] = whereValues.split(",");
		String whrConditions = "";
		ArrayList<HashMap<String, String>> dbRows = new ArrayList<HashMap<String, String>>();
		if (whrFields.length > 0 && whrValues.length > 0) {
			for (int i = 0; i <= whrFields.length - 1; i++) {
				whrConditions = whrConditions + whrFields[i].trim() + "=" + "'" + whrValues[i] + "'";
				if (!(whrFields.length - (i + 1) == 0)) {
					whrConditions = whrConditions + " " + conditional + " ";
				}
			}
		}
		try {
			statement = conn.createStatement();
			String exten = ".dbo.";
			String query = "select " + fields + " from " + "[" + database + "]" + exten + "[" + table + "]" + " where "
					+ whrConditions + " ORDER BY " + sortColumn + " " + sortOrder;
			System.out.println(query);
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				HashMap<String, String> hm = new HashMap<String, String>();
				for (int i = 0; i <= selectFields.length - 1; i++) {
					hm.put(selectFields[i].trim(), rs.getString(selectFields[i].trim()));
				}
				dbRows.add(hm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbRows;
	}

	// Update values in Database Created by GG
	public static void update(String database, String value, String field, String table, String wherefield, String wherevalue,
			String conditional) {
		sqlConnection();
		String whrFields[] = wherefield.split(",");
		String whrValues[] = wherevalue.split(",");
		String whrConditions = "";
		if (whrFields.length > 0 && whrValues.length > 0) {
			for (int i = 0; i <= whrFields.length - 1; i++) {
				whrConditions = whrConditions + whrFields[i].trim() + "=" + "'" + whrValues[i] + "'";
				if (!(whrFields.length - (i + 1) == 0)) {
					whrConditions = whrConditions + " " + conditional + " ";
				}
			}
		}
		Statement statement;
		try {
			statement = conn.createStatement();
			String exten = ".dbo.";
			String updatequery = "Update " + "[" + database + "]" + "" + exten + "" + "[" + table + "]" + " Set " + ""
					+ field + "=" + "'" + value + "'" + " where " + "" + whrConditions;
			statement.executeUpdate(updatequery);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Adding records to Database Created by GG
	public static void addingRecords(String database, String table, String Fields, String values) {
		sqlConnection();
		Statement statement;
		try {
			statement = conn.createStatement();
			String exten = ".dbo.";
			String Insertquery = "INSERT INTO " + "[" + database + "]" + "" + exten + "" + "[" + table + "]" + Fields
					+ "VALUES" + values;
			statement.executeUpdate(Insertquery);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Delete Record from Database Created by GG
	public static ArrayList<String> deleterecord(String database, String table, String wherefield, String wherevalue) {
		sqlConnection();
		Statement statement;
		try {
			statement = conn.createStatement();
			String exten = ".dbo.";
			String deletequery = "DELETE FROM " + "[" + database + "]" + "" + exten + "" + "[" + table + "]" + " where "
					+ "" + wherefield + "" + "=" + "'" + wherevalue + "'";
			System.out.println(deletequery);
			statement.executeUpdate(deletequery);
			ArrayList<String> records = new ArrayList<String>();
			String query = "select " + "" + wherefield + "" + " from " + "[" + database + "]" + "" + exten + "" + "["
					+ table + "]";
			ResultSet rs = statement.executeQuery(query);			
			while (rs.next()) {				
				records.add(rs.getString(wherefield));				
			}
			return records;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Retrieve list of values of particular column from Database Created by GG
	public static ArrayList<String> retrievelist(String database, String field, String table) {
		sqlConnection();
		Statement statement;
		try {
			statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String exten = ".dbo.";
			String query = "select " + "" + field + "" + " from " + "[" + database + "]" + "" + exten + "" + "[" + table
					+ "]";
			ResultSet rs = statement.executeQuery(query);
			ArrayList<String> records = new ArrayList<String>();
			while (rs.next()) {
				records.add(rs.getString(field));
			}
			return records;

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	// Get values of particular row based on given condition Created by GG
	public static ArrayList<String> retrivevalueswithheaders(String database, String table, String wherefield,
			String wherevalue) {
		sqlConnection();
		Statement statement;
		String exten = ".dbo.";
		try {
			statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet = statement.executeQuery("SELECT * FROM [AMSCurrentTJ].dbo.[EMPLOYEE]");
			ResultSetMetaData meta = resultSet.getMetaData();
			int count = meta.getColumnCount();
			String valuequery = "select " + "*" + " from " + "[" + database + "]" + "" + exten + "" + "[" + table + "]"
					+ " where " + "" + wherefield + "" + "=" + "'" + wherevalue + "'";
			ResultSet rs = statement.executeQuery(valuequery);
			ArrayList<String> Database = new ArrayList<String>();
			while (rs.next()) {
				for (int j = 1; j < count; j++) {
					if (rs.wasNull()) {
					} else {						
						Database.add(rs.getString(j));
					}

				}

			}
			return Database;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}