package it.davinci.eu;
import jdk.jfr.Frequency;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static javax.swing.JFrame.*;
import static javax.swing.text.html.HTML.Attribute.ALIGN;

public class Test
{
    public static void main(String[] args)
    {
        //istanza per l'interfaccia grafica
        guI interfacciaGrafica = new guI();
        //inizializzazione dello switch
        Buffer b1=new Buffer();
        Buffer b2=new Buffer();
        Buffer b3= new Buffer();
        Buffer b4=new Buffer();
        Buffer b5=new Buffer();
        Buffer b6= new Buffer();
        Porta p1= new Porta(b1, b2, b3);
        Porta p2= new Porta(b4, b5, b6);
        Switch s= new Switch(p1, p2);
        //variabili per il funzionamento del random
        Random r = new Random();
        //serve per il numero di valori possibili da generare  (0...2)
        int upperBound = 3;
        //variabile per il valore uscito dal random funzione di scelta porta e buffer
        int n;
        //stringa per la stampa
        String strStampa;
        //variabili per media lunghezza singoli buffer
        Double lunghezzaPorta1=0.0;
        Double lunghezzaBuffer1=0.0;
        Double lunghezzaBuffer2=0.0;
        Double lunghezzaBuffer3=0.0;
        Double lunghezzaPorta2=0.0;
        Double lunghezzaBuffer4=0.0;
        Double lunghezzaBuffer5=0.0;
        Double lunghezzaBuffer6=0.0;
        //contatore del ciclo
        Integer i;
        Integer i_MAX=15;
        /*inserimento di un ciclo per essere
        totalmente autonomo e controllare il
        funzionamento dello switch completo*/
        for(i=0;i<i_MAX;i++){
            //variabile per il valore del frame in entrata con inizializzazione
            String str1="0";
            //operazione per scelta buffer
            n = r.nextInt(upperBound);
            //ciclo per generare un frame casuale
            for(Integer j=0;j<6;j++)
                str1+=r.nextInt(upperBound);
            //creazione del nuovo frame
                Frame f = new Frame(str1);
            //operazione per la scelta dell'inserimento dei frame
            if(i==0) {
                if (n == 0){
                    s.inserisciFrame(f, 0);
                    str1="0";
                    for(Integer j=0;j<6;j++)
                    str1+=r.nextInt(upperBound);
                    f = new Frame(str1);
                    s.inserisciFrame(f, 0);
                }
            else if(n==1){
                    s.inserisciFrame(f, 1);
                    str1="0";
                    for(Integer j=0;j<6;j++)
                    str1+=r.nextInt(upperBound);
                    f = new Frame(str1);
                    s.inserisciFrame(f, 1);
                }
            else{
                    s.inserisciFrame(f, 0);
                    str1="0";
                    for(Integer j=0;j<6;j++)
                    str1+=r.nextInt(upperBound);
                    f = new Frame(str1);
                    s.inserisciFrame(f, 1);
                }
                //calcolo lunghezza dei buffer e delle porte
                lunghezzaBuffer1+=b1.lunghezzaBuffer();
                lunghezzaBuffer2+=b2.lunghezzaBuffer();
                lunghezzaBuffer3+=b3.lunghezzaBuffer();
                lunghezzaBuffer4+=b4.lunghezzaBuffer();
                lunghezzaBuffer5+=b5.lunghezzaBuffer();
                lunghezzaBuffer6+=b6.lunghezzaBuffer();
                lunghezzaPorta1+=lunghezzaBuffer1+lunghezzaBuffer2+lunghezzaBuffer3;
                lunghezzaPorta2+=lunghezzaBuffer4+lunghezzaBuffer5+lunghezzaBuffer6;

            }
            //dal secondo in poi inserisce e controlla la priorita' partendo dalla porta 1
            else{

                str1="0";
                //ciclo creazione frame casuale
                for(Integer j=0;j<6;j++)
                str1+=r.nextInt(upperBound);
                //creazione del nuovo frame
                f=new Frame(str1);
                //operazione per scelta priorità casuale
                n=r.nextInt(upperBound);
                //operazione per la scelta dell'inserimento dei frame
                if (n == 0){
                    s.inserisciFrame(f, 0);
                    str1="0";
                    for(Integer j=0;j<6;j++)
                    str1+=r.nextInt(upperBound);
                    f = new Frame(str1);
                    s.inserisciFrame(f, 0);
                }
                else if(n==1){
                    s.inserisciFrame(f, 1);
                    str1="0";
                    for(Integer j=0;j<6;j++)
                    str1+=r.nextInt(upperBound);
                    f = new Frame(str1);
                    s.inserisciFrame(f, 1);
                }
                else{
                    s.inserisciFrame(f, 0);
                    str1="0";
                    for(Integer j=0;j<6;j++)
                    str1+=r.nextInt(upperBound);
                    f = new Frame(str1);
                    s.inserisciFrame(f, 1);
                }
                //eliminazione di un frame per porta con priorità
                Boolean b=p1.eliminaFrame();
                Boolean p=p2.eliminaFrame();
                //calcolo lunghezza dei buffer e delle porte
                lunghezzaBuffer1+=b1.lunghezzaBuffer();
                lunghezzaBuffer2+=b2.lunghezzaBuffer();
                lunghezzaBuffer3+=b3.lunghezzaBuffer();
                lunghezzaBuffer4+=b4.lunghezzaBuffer();
                lunghezzaBuffer5+=b5.lunghezzaBuffer();
                lunghezzaBuffer6+=b6.lunghezzaBuffer();
                lunghezzaPorta1+=lunghezzaBuffer1+lunghezzaBuffer2+lunghezzaBuffer3;
                lunghezzaPorta2+=lunghezzaBuffer4+lunghezzaBuffer5+lunghezzaBuffer6;
            }


        }
        //calcolo lunghezza singole porte
        lunghezzaPorta1=(Double)(lunghezzaPorta1/((i-1)*3));
        lunghezzaPorta2=(Double)(lunghezzaPorta1/((i-1)*3));

        //assegnazione ad un final per inserirla nel textfield
        Double finalLunghezzaPorta2 = lunghezzaPorta2;
        Double finalLunghezzaPorta1 = lunghezzaPorta1;
        Double finalLunghezzaBuffer1 = lunghezzaBuffer1/(i-1);
        Double finalLunghezzaBuffer2 = lunghezzaBuffer2/(i-1);
        Double finalLunghezzaBuffer3 = lunghezzaBuffer3/(i-1);
        Double finalLunghezzaBuffer4 = lunghezzaBuffer4/(i-1);
        Double finalLunghezzaBuffer5 = lunghezzaBuffer5/(i-1);
        Double finalLunghezzaBuffer6 = lunghezzaBuffer6/(i-1);

        //implementazione del  action listener del nottone per far si che una volta cliccato escano i risultati
        interfacciaGrafica.getStampaMedieButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfacciaGrafica.getTextField1().setText(String.valueOf(finalLunghezzaPorta1));
                interfacciaGrafica.getTextField5().setText(String.valueOf(finalLunghezzaPorta2));
                interfacciaGrafica.getTextField2().setText(String.valueOf(finalLunghezzaBuffer1));
                interfacciaGrafica.getTextField3().setText(String.valueOf(finalLunghezzaBuffer2));
                interfacciaGrafica.getTextField4().setText(String.valueOf(finalLunghezzaBuffer3));
                interfacciaGrafica.getTextField7().setText(String.valueOf(finalLunghezzaBuffer4));
                interfacciaGrafica.getTextField9().setText(String.valueOf(finalLunghezzaBuffer5));
                interfacciaGrafica.getTextField11().setText(String.valueOf(finalLunghezzaBuffer6));

            }
        });
        //codice che serve per avviare l'interfaccia grafica
        interfacciaGrafica.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        interfacciaGrafica.setLocationRelativeTo(null);
        interfacciaGrafica.setSize(700,375);
        interfacciaGrafica.setVisible(true);
        interfacciaGrafica.setResizable(false);

    }
}