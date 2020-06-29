package TschauSepp.main;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-Mai-29
 */

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

class BackgroundImageJFrame extends JFrame
{

    JButton b1;
    JLabel l1;

    public BackgroundImageJFrame() {

        setSize(600,600);
        setVisible(true);

        setLayout(new BorderLayout());

        JLabel background=new JLabel(new ImageIcon("C:\\Users\\Felix\\OneDrive\\Felix\\Privat\\Programmieren\\TschauSepp\\src\\TschauSepp\\main\\holzHintergrundzugeschnitten.jpg"));

        add(background);

        background.setLayout(new FlowLayout());

        l1=new JLabel("Here is a button");
        b1=new JButton("I am a button");

        background.add(l1);
        background.add(b1);

        repaint();
    }

    public static void main(String args[])
    {
        new BackgroundImageJFrame();
    }
}