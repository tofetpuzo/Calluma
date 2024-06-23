/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Button;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author femitemiola
 */
public class AWTExampleC extends Frame {

    public AWTExampleC(String String) throws ClassNotFoundException {
        super(String);
        try {
            Button b = new Button("show");
            b.setBounds(130, 100, 100, 50);
            
            add(b);
            setSize(400, 500);
            setLayout(null); //It helps you to lay out your object on the frame
            setVisible(true);
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel()");
            UIManager.setLookAndFeel("javax.swing.plaf.motif.MotifLookAndFeel()");
        } catch (InstantiationException ex) {
            Logger.getLogger(AWTExampleC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AWTExampleC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AWTExampleC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String args[]){
        try {
            AWTExampleC awtExampleC = new AWTExampleC("My Example");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AWTExampleC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
