package it.davinci.eu;

public class Porta
{
    private Buffer b1;
    private Buffer b2;
    private Buffer b3;

    public Porta(Buffer b1, Buffer b2, Buffer b3)
    {
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
    }

    public Buffer getB1()
    {
        return this.b1;
    }

    public Buffer getB2()
    {
        return this.b2;
    }

    public Buffer getB3()
    {
        return this.b3;
    }

    public Frame inserisciFrame(Frame f, Integer i){
        if(i==0)
            b1.inserisciFrame(f);
        else if(i==1)
            b2.inserisciFrame(f);
        else
            b3.inserisciFrame(f);

        return f;
    }

    public Boolean eliminaFrame(){
        Boolean b=false;
        /*se i=0 entra fa il controllo se la pila
         ha l'elemento viene tolto altrimenti controlla
         il buffer con priorità minore*/
        if(!b)
            if(b1.ricercaFrame()){
                b=b1.eliminaFrame();
                b=true;
            }
        if(!b)
            if(b2.ricercaFrame()){
                b=b2.eliminaFrame();
                b=true;
            }
        else
            if(b3.ricercaFrame()){
                b=b3.eliminaFrame();
                b=true;
            }


        return b;
    }

    public String toString(){

        String str;
        str="******** Porta ********";
        str+="\nBuffer con priorita' 1: "+b1.toString();
        str+="\nBuffer con priorita' 2: "+b2.toString();
        str+="\nBuffer con priorita' 3: "+b3.toString();
        return str;
    }
}