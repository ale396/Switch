package it.davinci.eu;

import javax.swing.*;

public class guI extends JFrame{
    private JTextField simulazioneSwitchTextField;
    private JTextField porta1TextField;
    private JTextField buffer1TextField;
    private JTextField buffer2TextField;
    private JTextField buffer3TextField;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField porta2TextField;
    private JTextField textField5;
    private JTextField buffer1TextField1;
    private JTextField textField7;
    private JTextField buffer2TextField1;
    private JTextField textField9;
    private JTextField buffer3TextField1;
    private JTextField textField11;
    private JTextField premereIlBottonePerTextField;
    private JButton stampaMedieButton;
    private JPanel defaultPanel;

    public guI(){
        add(defaultPanel);
        pack();
        setVisible(true);
    }
    public void bottonePremuto(Double porta1, Double porta2, Double porta1Buffer1,Double porta1Buffer2, Double porta1Buffer3, Double porta2Buffer1, Double porta2Buffer2, Double porta2Buffer3){

        stampaMedieButton.addActionListener(e->{

            porta1TextField.setText(String.valueOf(porta1));
        });
    }

    public JButton getStampaMedieButton() {
        return stampaMedieButton;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public JTextField getTextField4() {
        return textField4;
    }

    public JTextField getTextField5() {
        return textField5;
    }

    public JTextField getTextField7() {
        return textField7;
    }

    public JTextField getTextField9() {
        return textField9;
    }

    public JTextField getTextField11() {
        return textField11;
    }
}
