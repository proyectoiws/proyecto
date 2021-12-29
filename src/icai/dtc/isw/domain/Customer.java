package icai.dtc.isw.domain;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;

import java.io.Serializable;

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

	public Customer(String matricula, String origen, String destino, String plazas, JDatePickerImpl fecha, String hora)
	{
		this.matricula= matricula;
		this.origen= origen;
		this.destino = destino;
		this.plazas = plazas;
		this.fecha = String.valueOf(fecha);
		this.hora = hora;
	}
	public Customer(String matricula){
		this.matricula=matricula;
	}

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
}
