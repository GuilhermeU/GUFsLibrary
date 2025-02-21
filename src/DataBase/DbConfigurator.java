package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.LibraryLog; 

public class DbConfigurator {
	Statement dbExecutor;
	Connection dbConnection;
	LibraryLog log = new LibraryLog(DbConfigurator.class);
	
	public DbConfigurator() {
		log.print("DbConfigurator()");
		try {
			dbConnection = DriverManager.getConnection("jdbc:sqlite:database.db");
			dbExecutor = dbConnection.createStatement();
			dbExecutor.setQueryTimeout(5);
			
		} catch (SQLException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} finally {
			if(dbConnection == null) {
				this.closeConnection();
			}
		}
	}
	
	public void resetUsers() {
		log.print("resetUsers()");
		try {
			dbExecutor.executeUpdate("DROP TABLE IF EXISTS terminalroot");
			dbExecutor.executeUpdate("CREATE TABLE terminalroot (id INTEGER, name STRING)");
			dbExecutor.executeUpdate("INSERT INTO terminalroot VALUES(1,'USER')");
		} catch (SQLException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void createBooksTable() {
		log.print("createBooksTable()");
		try {
			String query = "CREATE TABLE books ("+
					"id INTEGER NOT NULL PRIMARY KEY, "+
					"name String NOT NULL, "+
					"resume String, "+
					"pages INTEGER"+
					" )";
			dbExecutor.executeUpdate(query);
		} catch (SQLException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		log.print("closeConnection()");
		try {
			dbConnection.close();
		} catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Statement getDbExecutor() {
		return dbExecutor;
	}
	
	public void setDbExecutor(Statement dbExecutor) {
		this.dbExecutor = dbExecutor;
	}
}
