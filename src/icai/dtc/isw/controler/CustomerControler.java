package icai.dtc.isw.controler;

import java.util.*;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Entrada;
import icai.dtc.isw.domain.Usuario;

public class CustomerControler {

	public void getUsuario(ArrayList<Usuario> lista, HashMap<String, Object> mapa) {
		Usuario entrada = (Usuario) mapa.get("Peticion");
		System.out.println(entrada.getId()+"  bien hasta DAO   "+entrada.getPassword());
		//System.out.println(entrada+" ok");
		CustomerDAO.getUsuarios(lista, entrada);
	}

	public void getCustomer(ArrayList<Customer> lista,HashMap<String, Object> mapa) {
		//Aquí los distintos metodos según el String por ahora cogemos el value y hacemos downcasting
		//System.out.println(" ok controler");
		Entrada entrada = (Entrada) mapa.get("Peticion");
		//System.out.println(entrada+" ok");
		CustomerDAO.getClientes(lista, entrada);
	}

	public void setUsuario(ArrayList<Usuario> lista, HashMap<String, Object> mapa) {
		Usuario entrada = (Usuario) mapa.get("Peticion");
		CustomerDAO.setUsuarios(lista, entrada);

	}

	public void setCustomer(ArrayList<Customer> lista, HashMap<String, Object> mapa) {
		Customer entrada = (Customer) mapa.get("Peticion");
		CustomerDAO.setCustomer(lista, entrada);

	}

	public void getCustomerC(ArrayList<Customer> lista, HashMap<String, Object> mapa) {
		Entrada entrada = (Entrada) mapa.get("Peticion");
		CustomerDAO.getClientesC(lista, entrada);
	}
}
