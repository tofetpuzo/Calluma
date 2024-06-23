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
public class PayFriendsGUIC extends Frame {

    public PayFriendsGUIC(String String) throws ClassNotFoundException {
        super(String);
        try {
            Button showButton = new Button("show");
            b.setBounds(130, 100, 100, 50);
            
            add(b);
            setSize(400, 500);
            setLayout(null); //It helps you to lay out your object on the frame
            setVisible(true);
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel()");
            UIManager.setLookAndFeel("javax.swing.plaf.motif.MotifLookAndFeel()");
        } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PayFriendsGUIC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String args[]){
        try {
            PayFriendsGUI payFriends = new PayFriendsGUI("payFriendsGUI");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PayFriendsGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
