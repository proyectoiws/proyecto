package icai.dtc.isw.domain;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private String origen;
	private String destino;
	private String plazas;
	private String matricula;
	private String fecha;
	private String hora;
	private String  propietario;
	private ArrayList<String> usuarios;

	public Customer(String matricula, String origen, String destino, String plazas, String fecha, String hora, String propietario)
	{
		this.matricula= matricula;
		this.origen= origen;
		this.destino = destino;
		this.plazas = plazas;
		this.fecha = String.valueOf(fecha);
		this.hora = hora;
		this.propietario=propietario;
	}

	public Customer(String matricula, String origen, String destino, String plazas, String fecha, String hora, String propietario,ArrayList<String> usuarios)
	{
		this.matricula= matricula;
		this.origen= origen;
		this.destino = destino;
		this.plazas = plazas;
		this.fecha = String.valueOf(fecha);
		this.hora = hora;
		this.propietario=propietario;
		this.usuarios= usuarios;
	}


	public Customer(String matricula){this.matricula=matricula;}

	public String getOrigen()
	{
		return origen;
	}

	public String getDestino()
	{
		return destino;
	}

	public String getPlazas()
	{
		return plazas;
	}

	public String getMatricula()
	{
		return matricula;
	}

	public String getFecha() { return fecha; }

	public String getHora() { return hora; }

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public ArrayList<String> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<String> usuarios) {
		this.usuarios = usuarios;
	}

}
