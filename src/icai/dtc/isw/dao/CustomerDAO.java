package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Entrada;

public class CustomerDAO {

	private static Entrada ENTRADA;


	public static void getClientes(ArrayList<Customer> lista, Entrada entrada) {
		ENTRADA = entrada;
		System.out.println(ENTRADA.getOrigen());
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM coches WHERE origen = '"+ENTRADA.getOrigen()+"';");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	lista.add(new Customer(rs.getString(6),rs.getString(2),rs.getString(3),(String) rs.getString(1)));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
	}
	
	public static void main(String[] args) {
		
		
		ArrayList<Customer> lista=new ArrayList<Customer>();

		CustomerDAO.getClientes(lista,ENTRADA);
		
		
		 for (Customer customer : lista) {			
			System.out.println("He leído la matricula: "+customer.getMatricula());
		}
		
	
	}

}
