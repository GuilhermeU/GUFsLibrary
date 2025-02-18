package main;

import DataBase.DbConfigurator;

public class Mylib {

	public static void main(String[] args) {
		DbConfigurator dataBase = new DbConfigurator();
		dataBase.resetUsers();
		dataBase.createBooksTable();
		
		
		dataBase.closeConnection();
	}

}
