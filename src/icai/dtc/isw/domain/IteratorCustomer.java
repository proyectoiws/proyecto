package icai.dtc.isw.domain;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorCustomer implements Iterator<Customer>{

    private int posicionarray;
    private ArrayList<Customer> coches;
    private String name;


    public IteratorCustomer(ArrayList<Customer> coches,String name){
        this.posicionarray=0;
        this.coches=coches;
        this.name=name;
    }

    @Override
    public boolean hasNext() {
        boolean result;
        if(posicionarray< coches.size()){
            result=true;
        }
        else{
            result=false;
        }
        return result;
    }

    @Override
    public Customer next() {

        posicionarray++;
        return coches.get(posicionarray-1);

    }

    public String getText(){

        Customer coche=coches.get(posicionarray);
        posicionarray++;
        String texto;
        if (name.equals(coche.getPropietario())){
            texto = "Propietario del trayecto con origen en "+coche.getOrigen()+" y destino en "+coche.getDestino()+" para la fecha "+coche.getFecha()+" a las "+coche.getHora()+". Tiene x plazas ocupadas de las "+coche.getPlazas()+" disponibles";
        }
        else
            texto = "Se ha unido al trayecto con origen en "+coche.getOrigen()+" y destino en "+coche.getDestino()+" para la fecha "+coche.getFecha()+" a las "+coche.getHora()+". Tiene x plazas ocupadas de las "+coche.getPlazas()+" disponibles";
    return texto;
    }
}
