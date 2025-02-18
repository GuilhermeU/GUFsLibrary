package DataBase;

import java.sql.SQLException;
import java.sql.Statement;

import main.LibraryLog;

public class DbControler {
	Statement dbExecutor;
	LibraryLog log = new LibraryLog(DbControler.class);
	
	public DbControler(Statement statement) {
		dbExecutor = statement;
	}
	
	public boolean insertData(String query) {
		try {
			dbExecutor.execute(query);
		} catch (SQLException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean dropTable(String query) {
		log.print("dropTable");
		query = "DROP TABLE "+query;
		try {
			this.dbExecutor.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			log.error(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	
}
