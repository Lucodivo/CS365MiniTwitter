package cs356minitwitter;

import cs356minitwitter.form.InfoPopUpUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.SwingUtilities;

/**
 * Window used to display information as a pop-up
 * Only functionality is setting it's label and closing itself
 *
 * @author Connor
 */
public class InfoPopUpWindow extends InfoPopUpUI {
    
    // self Reference used to close window
    private InfoPopUpWindow infoPopUpWindow;
    
    /**
     * Constuctor
     * Creates window that displays message
     * 
     * @param infoString String to be displayed as a JLabel in the pop-up window
     */
    public InfoPopUpWindow(String infoString) {
        super();
        
        // set self Reference
        infoPopUpWindow = this;
        
        //initialize UI components
        initializeViews(infoString);
    }
    
    private void initializeViews(String infoString){
        
        // safely setting text and making window visible
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                infoLabel.setText(infoString);
                setVisible(true);
            }
        });
        
        // set okButton to close the window
        this.okButton.addActionListener(new ActionListener() {  
            @Override      
            public void actionPerformed(ActionEvent e) {
                dispatchEvent(new WindowEvent(infoPopUpWindow, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
