package cr.una.PracticaGui;

import javafx.event.ActionEvent;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame implements ActionListener {//, FocusListener

    JButton suma;
    JButton resta;
    JTextField valor1, valor2, resultado;
    JLabel text;
    JLabel resSuma, resResta, igual;

    public Calculadora() {
        super("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();

        valor1 = new JTextField("0", 5);
        valor1.setName("valor1");
        valor2 = new JTextField("0", 5);
        valor2.setName("valor2");
        suma = new JButton("La suma es: ");
        resta = new JButton("La resta es: ");
        resSuma = new JLabel("+");
        resResta = new JLabel("-");
        igual = new JLabel("=");

        suma.addActionListener(this);
        resta.addActionListener(this);

        FlowLayout flow = new FlowLayout();
        setLayout(flow);

        suma.setName("suma");
        resta.setName("resta");
        text.setName("resultado");

        add(suma);
        add(resta);
        add(text);

        //valor1.addFocusListener(this);
        // valor2.addFocusListener(this);
        // set up sum field
        resultado.setEditable(false);
        // add components
        add(valor1);
        add(resSuma);
        add(valor2);
        add(igual);
        add(resultado);
        setVisible(true);

        pack();

        setVisible(true);
    }

    // @Override
    public void actionPerformed(java.awt.event.ActionEvent evento) {
        Object source = evento.getSource();
        if (source == suma) {
            text.setText("La suma es: ");
        } else if (source == resta) {
            text.setText("La resta es: ");
        }
        repaint();
    }

    /*public void focusLost(FocusEvent event) {
        focusGained(event);
    }

    public void focusGained(FocusEvent event) {
        try {
            float total = Float.parseFloat(valor1.getText()) +
                    Float.parseFloat(valor2.getText());
            suma.setText("" + total);
        } catch (NumberFormatException nfe) {
            valor1.setText("0");
            valor2.setText("0");
            suma.setText("0");
        }
    }*/

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception exc) {
            System.err.println("Couldn't use the system "
                    + "look and feel: " + exc);
        }
    }

    public static void main(String[] arguments) {
        Calculadora frame = new Calculadora();
    }
}
