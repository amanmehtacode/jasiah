/******************************
 * CSCI 185 Spring 2023
 * MO5
 * Gregorio Morelos And Aman Mehta (Developers)
 * Wenjia Li (Professor)
 * Advanced GUI Lab
 * April 20, 2023
 * Var 0.1
 ******************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MeasurementConverter extends JFrame {

    public MeasurementConverter() {
        super("Measurement Converter");
    }

    public static void main(String[] args) {
        //Setting The Frame
        MeasurementConverter frame = new MeasurementConverter();

        frame.setSize(250, 185);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocation(500, 200);

        frame.getContentPane().setLayout(new BorderLayout(3, 3));

        //Adding A Label
        JLabel label1 = new JLabel("   Measurement Unit Converter", SwingConstants.LEFT);
        frame.add(label1, BorderLayout.NORTH);

        //Adding A Panel To The Center
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 2, 5, 25));
        frame.add(panel1, BorderLayout.CENTER);

        //Adding The Text Areas And Text Fields
        JLabel label2 = new JLabel("Pound (lb):", SwingConstants.CENTER);
        JTextField textInput = new JTextField("", 15);

        panel1.add(label2);
        panel1.add(textInput);

        JLabel label3 = new JLabel("Kilogram (kg):", SwingConstants.CENTER);
        JTextArea textOutput = new JTextArea("", 1, 15);

        panel1.add(label3);
        panel1.add(textOutput);

        //Adding The Buttons
        JPanel panel2 = new JPanel();
        frame.add(panel2, BorderLayout.SOUTH);

        final JButton convert = new JButton("Convert");
        final JButton clear = new JButton("Clear");

        panel2.add(convert);
        panel2.add(clear);

        //Adding The Functions To The Components
        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double pound = Double.parseDouble(textInput.getText());
                    double kilogram = pound * 0.45359237;
                    textOutput.setText(Double.toString(kilogram));
                } catch (NumberFormatException ex) {
                    throw new ConversionException("Invalid input: " + ex.getMessage());
                } catch (ConversionException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Conversion Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textInput.setText("");
                textOutput.setText("");
            }
        });
    }

    public static class ConversionException extends Exception {
        public ConversionException(String errorMessage) {
            super(errorMessage);
        }
    }
}
