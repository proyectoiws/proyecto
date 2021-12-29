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


	public static void getClientes(ArrayList<Customer> lista, Entrada entrada) {

		System.out.println(entrada.getOrigen());
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM coches WHERE origen = '"+entrada.getOrigen()+"' AND destino ='"+entrada.getDestino()+"' AND fecha ='"+entrada.getFecha()+"' AND hora= '"+ entrada.getHora() +"';");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	lista.add(new Customer(rs.getString(1),rs.getString(3),rs.getString(4),(String) rs.getString(2), null, null));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
	}

	public static void getUsuarios(ArrayList<Usuario> lista, Usuario entrada) {


		System.out.println(entrada.getId());
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE name = '" + entrada.getId() + "' AND password='" + entrada.getPassword() + "';");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Usuario(rs.getString(1), rs.getString(2)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}

	public static void setUsuarios(ArrayList<Usuario> lista2, Usuario entrada) {

		System.out.println("El usuario que se va a meter antes de la query es "+entrada.getId()+" con contraseña "+entrada.getPassword());
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE name = '" + entrada.getId() + "';");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista2.add(new Usuario(rs.getString(1), rs.getString(2)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}

		try (PreparedStatement pst = con.prepareStatement("INSERT INTO users (name, password) VALUES ('" + entrada.getId() + "', '" + entrada.getPassword() + "');");
				 ResultSet rs = pst.executeQuery()) {
					System.out.println("se ha insertardo bien"+rs);


			}


		catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}

	}

	public static void setCustomer(ArrayList<Customer> lista4, Customer COCHE) {

		System.out.println("El coche que se va a meter antes de la query es "+COCHE.getMatricula());
		Connection con = ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM COCHES WHERE matricula = '" + COCHE.getMatricula()+"';");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista4.add(new Customer(rs.getString(1)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}

		try (PreparedStatement pst = con.prepareStatement("INSERT INTO COCHES (matricula,plazas,origen,destino) VALUES ('" + COCHE.getMatricula() + "', " +COCHE.getPlazas() + ", '" +COCHE.getOrigen() +"', '" +COCHE.getDestino() +"');");
			 ResultSet rs = pst.executeQuery()) {
			 System.out.println("se ha insertardo bien"+rs);

		}


		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}
	//public static void main(String[] args) {


}
