package it.davinci.eu;

public class Switch
{
    private Porta p1;
    private Porta p2;

    public Switch(Porta p1, Porta p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Porta getP1()
    {
        return this.p1;
    }

    public Porta getP2()
    {
        return this.p2;
    }

    public Frame inserisciFrame(Frame f, Integer i){
        if(i==0)
            p1.inserisciFrame(f,i);

        else
            p2.inserisciFrame(f,i);

        return f;
    }
    public Boolean eliminaFrame(){
        Boolean b=false;

        b=p1.eliminaFrame();

        if(!b)
            b=p2.eliminaFrame();

        return b;
    }

    public String toString(){
        String str="***********************\n";
        str+="Porta 1: \n"+p1.toString();
        str+="\n***********************";
        str += "\nPorta 2: \n" + p2.toString();
        return str;
    }
}