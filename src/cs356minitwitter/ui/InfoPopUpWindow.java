/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Connor
 */
public class InfoPopUpWindow extends InfoPopUpUI {
    private InfoPopUpWindow infoPopUpWindow;
    
    public InfoPopUpWindow(String infoString) {
        super();
        
        infoPopUpWindow = this;
        initializeViews(infoString);
    }
    
    private void initializeViews(String infoString){
        // setting text and making window visible
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                infoLabel.setText(infoString);
                setVisible(true);
            }
        });
        
        this.okButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                dispatchEvent(new WindowEvent(infoPopUpWindow, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
