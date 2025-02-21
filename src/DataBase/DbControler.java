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
	
	public Boolean insertData(String query) {
		log.print("insertData");
		try {
			dbExecutor.execute(query);
		} catch (SQLException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean deleteData(String table, String where) {
		log.print("deleteData");
		String query = "DELETE FROM "+table+" WHERE "+where;
		try {
			dbExecutor.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			log.error("Error while deleting data from table "+table);
			e.printStackTrace();
			return false;
		}

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
