package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Entrada;

public class CustomerDAO {

	public static Entrada ENTRADA; //ponemos esto en static para poder usarlo en getClientes
	
	public void setEntrada(Entrada entrada){ //antes esto era static pero no podía ponerse thi.entrada con static
		this.ENTRADA = entrada;
	}


	public static void getClientes(ArrayList<Customer> lista) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM coches WHERE origen ="+ CustomerDAO.ENTRADA.getOrigen()+"AND destino ="+ CustomerDAO.ENTRADA.getDestino()); //esto antes era: entrada.getOrigen()+"AND destino ="+entrada.getDestino());
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	lista.add(new Customer(rs.getString(6),rs.getString(2),rs.getString(3),rs.getInt(1))); // el cuarto parámetro (número de plazas) lo he cambiado a integer ya que no es un string
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
