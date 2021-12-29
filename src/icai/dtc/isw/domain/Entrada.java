package icai.dtc.isw.domain;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;

import java.io.Serializable;

public class Entrada implements Serializable {
    private String origen;
    private String destino;
    private String fecha;
    private String hora;

    public Entrada(String origen, String destino, JDatePickerImpl fecha, String hora)
    {
        this.origen= origen;
        this.destino = destino;
        this.fecha = String.valueOf(fecha);
        this.hora = hora;
    }

    public String getOrigen()
    {
        return origen;
    }

    public String getDestino()
    {
        return destino;
    }

//    public String getPlazas()
//    {
//        return plazas;
//    }

    public String getFecha() { return fecha; }

    public String getHora() { return hora; }
}
