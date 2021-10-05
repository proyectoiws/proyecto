package icai.dtc.isw.controler;

import java.util.*;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Entrada;

public class CustomerControler {

	public void getCustomer(ArrayList<Customer> lista,HashMap<String, Object> mapa) {
		//Aquí los distintos metodos según el String por ahora cogemos el value y hacemos downcasting
		System.out.println(" ok controler");
		Entrada entrada = (Entrada) mapa.get("Peticion");
		System.out.println(entrada+" ok");
		CustomerDAO.getClientes(lista, entrada);
	}	
}
