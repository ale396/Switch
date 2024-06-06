package it.davinci.eu;

public class Frame
{
    private String dato;

    public Frame(String dato)
    {
        this.dato = dato;
    }

    public String getDato()
    {
        return this.dato;
    }

    public String toString(){

        String str="******** Frame ********";
        str+="\nIl frame e': "+this.dato;
        return str;
    }
}