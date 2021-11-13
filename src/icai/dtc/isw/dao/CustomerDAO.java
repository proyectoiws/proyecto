package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Entrada;
import icai.dtc.isw.domain.Usuario;

public class CustomerDAO {

	private static Entrada ENTRADA;
	private static Usuario USUARIO;




	public static void getClientes(ArrayList<Customer> lista, Entrada entrada) {
		ENTRADA = entrada;
		System.out.println(ENTRADA.getOrigen());
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM coches WHERE origen = '"+ENTRADA.getOrigen()+"' AND destino ='"+ENTRADA.getDestino()+"' AND plazas ='"+ENTRADA.getPlazas()+"';");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	lista.add(new Customer(rs.getString(1),rs.getString(3),rs.getString(4),(String) rs.getString(2)));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
	}

	public static void getUsuarios(ArrayList<Usuario> lista, Usuario entrada) {

		USUARIO = entrada;
		System.out.println(USUARIO.getId());
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE name = '" + USUARIO.getId() + "' AND password='" + USUARIO.getPassword() + "';");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Usuario(rs.getString(1), rs.getString(2)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}

	public static void setUsuarios(ArrayList<Usuario> lista2, Usuario entrada) {
		USUARIO = entrada;
		System.out.println("El usuario que se va a meter antes de la query es "+USUARIO.getId()+" con contraseña "+USUARIO.getPassword());
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE name = '" + USUARIO.getId() + "';");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista2.add(new Usuario(rs.getString(1), rs.getString(2)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}

		try (PreparedStatement pst = con.prepareStatement("INSERT INTO users (name, password) VALUES ('" + USUARIO.getId() + "', '" + USUARIO.getPassword() + "');");
				 ResultSet rs = pst.executeQuery()) {


			}


		catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

	}
	/*public static void main(String[] args) {
		
		
		ArrayList<Customer> lista=new ArrayList<Customer>();

		CustomerDAO.getClientes(lista,ENTRADA);
		
		
		 for (Customer customer : lista) {			
			System.out.println("He leído la matricula: "+customer.getMatricula());
		}
		
	
	}*/

}
