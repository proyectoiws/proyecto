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
            	lista.add(new Customer(rs.getString(1),rs.getString(3),rs.getString(4),(String) rs.getString(2), rs.getString(5), rs.getString(13),rs.getString(6),rs.getString(14)));

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

		try (PreparedStatement pst = con.prepareStatement("INSERT INTO COCHES (matricula,plazas,origen,destino,fecha,hora,userp,ocupadas) VALUES ('" + COCHE.getMatricula() + "', " +COCHE.getPlazas() + ", '" +COCHE.getOrigen() +"', '" +COCHE.getDestino() +"','"+COCHE.getFecha()+"','"+COCHE.getHora()+"','"+COCHE.getPropietario()+"','"+COCHE.getOcupadas()+"' );");
			 ResultSet rs = pst.executeQuery()) {
			 System.out.println("se ha insertardo bien"+rs);

		}


		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void getClientesC(ArrayList<Customer> lista, Entrada entrada) {
		System.out.println(entrada.getOrigen());
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM coches WHERE userp = '"+entrada.getName()+"' or user1 = '"+entrada.getName()+"' or user2= '"+entrada.getName()+"' or user3= '"+entrada.getName()+"' or user4 = '"+entrada.getName()+"' or user5 = '"+entrada.getName()+"' or user6= '"+entrada.getName()+"';");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Customer(rs.getString(1),rs.getString(3),rs.getString(4),(String) rs.getString(2), rs.getString(5), rs.getString(13),rs.getString(6),rs.getString(14)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}

	public static void preUpdate(ArrayList<Customer> lista, Customer entrada) {
		System.out.println(entrada.getName());
		Connection con=ConnectionDAO.getInstance().getConnection();

		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM coches WHERE (userp = '"+entrada.getName()+"' or user1 = '"+entrada.getName()+"' or user2 = '"+entrada.getName()+"' or user3 = '"+entrada.getName()+"' or user4 = '"+entrada.getName()+"' or user5 = '"+entrada.getName()+"' or user6= '"+entrada.getName()+"' ) and matricula = '"+entrada.getMatricula()+"' and fecha= '"+entrada.getFecha()+"' and hora= '"+entrada.getHora()+"' ;");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Customer(rs.getString(1),rs.getString(3),rs.getString(4),(String) rs.getString(2), rs.getString(5), rs.getString(13),rs.getString(6),rs.getString(14)));
				System.out.println(lista.size());
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}


	}

	public static void update(ArrayList<Customer> lista, Customer entrada) {

		System.out.println("hora"+entrada.getHora());
		Connection con=ConnectionDAO.getInstance().getConnection();
		if (entrada.getOcupadas().equals("0")) {
			try (PreparedStatement pst = con.prepareStatement(" UPDATE COCHES SET user1= '" + entrada.getName() + "', ocupadas = ocupadas + 1 WHERE matricula = '" + entrada.getMatricula() + "'and fecha = '" + entrada.getFecha() + "' and hora = '" + entrada.getHora() + "' ;");
				 ResultSet rs = pst.executeQuery()) {
				System.out.println("se ha actualizado bien" + rs);

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		else if (entrada.getOcupadas().equals("1")) {
			try (PreparedStatement pst = con.prepareStatement(" UPDATE COCHES SET user2= '" + entrada.getName() + "', ocupadas = ocupadas + 1 WHERE matricula = '" + entrada.getMatricula() + "'and fecha = '" + entrada.getFecha() + "' and hora = '" + entrada.getHora() + "' ;");
				 ResultSet rs = pst.executeQuery()) {
				System.out.println("se ha actualizado bien" + rs);

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		else if (entrada.getOcupadas().equals("2")) {
			System.out.println("aqui bien antes qqqq");
			try (PreparedStatement pst = con.prepareStatement(" UPDATE COCHES SET user3= '" + entrada.getName() + "', ocupadas = ocupadas + 1 WHERE matricula = '" + entrada.getMatricula() + "'and fecha = '" + entrada.getFecha() + "' and hora = '" + entrada.getHora() + "' ;");
				 ResultSet rs = pst.executeQuery()) {
				System.out.println("se ha actualizado bien" + rs);

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		else if (entrada.getOcupadas().equals("3")) {

			try (PreparedStatement pst = con.prepareStatement(" UPDATE COCHES SET user4= '" + entrada.getName() + "', ocupadas = ocupadas + 1 WHERE matricula = '" + entrada.getMatricula() + "'and fecha = '" + entrada.getFecha() + "' and hora = '" + entrada.getHora() + "' ;");
				 ResultSet rs = pst.executeQuery()) {
				System.out.println("se ha actualizado bien" + rs);

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		else if (entrada.getOcupadas().equals("4")) {

			try (PreparedStatement pst = con.prepareStatement(" UPDATE COCHES SET user5= '" + entrada.getName() + "', ocupadas = ocupadas + 1 WHERE matricula = '" + entrada.getMatricula() + "'and fecha = '" + entrada.getFecha() + "' and hora = '" + entrada.getHora() + "' ;");
				 ResultSet rs = pst.executeQuery()) {
				System.out.println("se ha actualizado bien" + rs);

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		else if (entrada.getOcupadas().equals("5")) {

			try (PreparedStatement pst = con.prepareStatement(" UPDATE COCHES SET user6= '" + entrada.getName() + "', ocupadas = ocupadas + 1 WHERE matricula = '" + entrada.getMatricula() + "'and fecha = '" + entrada.getFecha() + "' and hora = '" + entrada.getHora() + "' ;");
				 ResultSet rs = pst.executeQuery()) {
				System.out.println("se ha actualizado bien" + rs);

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}


		//System.out.println("Aqui okk");
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM coches WHERE (userp = '"+entrada.getName()+"' or user1 = '"+entrada.getName()+"' or user2 = '"+entrada.getName()+"' or user3 = '"+entrada.getName()+"' or user4 = '"+entrada.getName()+"' or user5 = '"+entrada.getName()+"' or user6= '"+entrada.getName()+"' ) and matricula = '"+entrada.getMatricula()+"' and fecha= '"+entrada.getFecha()+"' and hora= '"+entrada.getHora()+"';");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Customer(rs.getString(1),rs.getString(3),rs.getString(4),(String) rs.getString(2), rs.getString(5), rs.getString(13),rs.getString(6),rs.getString(14)));
				System.out.println(lista.size());
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}



	}

	//public static void main(String[] args) {


}
