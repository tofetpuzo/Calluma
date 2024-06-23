/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Button;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author femitemiola
 */
public class SwingExampleA {
        public static void main(String[] args){
            try {
                JFrame f = new JFrame();
                
                Button b = new Button("show");
                b.setBounds(130, 100, 100, 50);
                f.add(b);
                f.setSize(400, 500);
                f.setLayout(null); //It helps you to lay out your object on the frame
                f.setVisible(true);
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel()");
                UIManager.setLookAndFeel("javax.swing.plaf.motif.MotifLookAndFeel()");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(SwingExampleA.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
}
