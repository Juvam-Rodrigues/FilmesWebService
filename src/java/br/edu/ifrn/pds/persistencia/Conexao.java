/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifrn.pds.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String URL = "jdbc:mysql://localhost:3306/filme_db?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String SENHA = "Juvam20041103";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; 
	private static Connection connection;
	
	public static Connection conectar(){
		
		try { 
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, SENHA);
			return connection;
		} catch (ClassNotFoundException e1) {
			System.out.println("Erro aqui: " + e1.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
		
	}
			
	public static void desconectar(){
		
		try{
			if(connection != null){
				connection.close();
				connection = null;
			}
		}
		
		catch(SQLException ex){
			System.out.println(ex.getMessage());
			
		}
		
	}
}
