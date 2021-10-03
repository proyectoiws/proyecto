package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Entrada;

public class CustomerDAO {

	private Entrada entrada;
	
	public static void setEntrada(Entrada entrada){
		this.entrada = entrada;
	}
	public static void getClientes(ArrayList<Customer> lista) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM coches WHERE origen ="+entrada.getOrigen()+"AND destino ="+entrada.getDestino());
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	lista.add(new Customer(rs.getString(6),rs.getString(2),rs.getString(3),rs.getString(1)));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
	}
	
	public static void main(String[] args) {
		
		
		ArrayList<Customer> lista=new ArrayList<Customer>();

		CustomerDAO.getClientes(lista);
		
		
		 for (Customer customer : lista) {			
			System.out.println("He leído la matricula: "+customer.getMatricula());
		}
		
	
	}

}
