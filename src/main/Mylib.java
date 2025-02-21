package main;

import java.sql.ResultSet;
import java.sql.SQLException;

import DataBase.DbConfigurator;
import DataBase.DbControler;

public class Mylib {
	
	public static void main(String[] args) {
		LibraryLog log = new LibraryLog(Mylib.class);
		DbConfigurator dataBase = new DbConfigurator();
		dataBase.resetUsers();
		//dataBase.createBooksTable();
		DbControler controler = new DbControler(dataBase.getDbExecutor());
		//controler.dropTable("books");
		String query = "INSERT INTO books (id, name, resume, pages) values"
				+ "(1,'CRONICAS DE SPIDERWICK','Livro sobre crinças e criaturas magicas',575),"
				+ "(2,'Eragon','livro sobre dragoes e reis maus', 475)";
		//controler.insertData(query);
		ResultSet resultSet;
		try {
			resultSet = dataBase.getDbExecutor().executeQuery("SELECT * FROM books");
			while(resultSet.next()) {
				log.print("Book name: "+resultSet.getString("name")+" - pages: "+resultSet.getInt("pages"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		dataBase.closeConnection();
	}

}
