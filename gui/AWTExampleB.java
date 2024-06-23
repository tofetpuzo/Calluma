/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Button;
import java.awt.Frame;

/**
 *
 * @author femitemiola
 */
public class AWTExampleB {
    public AWTExampleB(){
        Frame f = new Frame();
        
        Button b = new Button("show");
        b.setBounds(130, 100, 100, 50);
        
        f.add(b);
        f.setSize(400, 500);
        
        f.setLayout(null); //It helps you to lay out your object on the frame
        f.setVisible(true);
    }
    
    public static void main(String[] args){
        new AWTExampleB();
    }
    
    
}
