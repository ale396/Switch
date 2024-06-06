package it.davinci.eu;

import java.util.Vector;

public class Buffer
{
    private Vector<Frame> vector;

    public Buffer(Vector<Frame> vector) {
        this.vector = vector;
    }

    public Buffer() {
        this.vector = new Vector<Frame>();
    }

    public Integer lunghezzaBuffer(){

        return vector.size();
    }
    public Frame inserisciFrame(Frame f){

        vector.add(0, f);

        return f;
    }
    public Boolean eliminaFrame(){
        //inizializzazione del frame da eliminare
        Frame f;
        f=vector.firstElement();
        Boolean b=vector.remove(f);
        if(b)
            return true;

        return null;
    }
    public Boolean ricercaFrame(){
        if(!vector.isEmpty())
            return true;
        return false;
    }
    public String toString(){
        String str;
        str="\nLa coda dei Frame: ";
        for(int i=0; i<vector.size();i++){

            str+="\n"+vector.elementAt(i);
        }
        return str;
    }
}