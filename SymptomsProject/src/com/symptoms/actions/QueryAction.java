package com.symptoms.actions;

import java.sql.SQLException;

import com.mysql.jdbc.MySQLConnection;
import com.opensymphony.xwork2.ActionSupport;

import connection.DataConnector;

public class QueryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tableValues;
	private String SQLQuery;

	private DataConnector inputDataConnector = new DataConnector();
	private MySQLConnection inputConnection;
	
	public String execute() throws Exception {
		  
		  final String readNameTableString = "SELECT INGREDIENTID, INGREDIENTNAME FROM SYMPTOMSDB.INGREDIENTS";
			System.out.println("Exxing!!!");
			try {
				 inputConnection = inputDataConnector.getConnection();
				 tableValues = inputDataConnector.readTableVals(inputConnection, readNameTableString, true);
				
				 return SUCCESS;
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ERROR;  
			}
	  }
	
	

		public String getSQLQuery() {
			return SQLQuery;
		}
	
		public void setSQLQuery(String sQLQuery) {
			SQLQuery = sQLQuery;
		}
	  
		public String getTableValues() {
			return tableValues;
		}

		public void setTableValues(String tableValues) {
			this.tableValues = tableValues;
		}
	
}
