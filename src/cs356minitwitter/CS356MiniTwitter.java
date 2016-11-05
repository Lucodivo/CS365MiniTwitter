/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter;

import cs356minitwitter.MiniTwitterUI.AdminWindow;

/**
 *
 * @author Connor
 */
public class CS356MiniTwitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdminWindow adminWindow = AdminWindow.getAdminWindow();
        adminWindow.addGroupNode("Bands", "root");
        adminWindow.addGroupNode("Crystal Castles", "Bands");
        adminWindow.addGroupNode("Future Islands", "Bands");
        adminWindow.addLeafNode("Samuel", "Future Islands");
        adminWindow.addLeafNode("Gerrit", "Future Islands");
        adminWindow.addLeafNode("William", "Future Islands");
        adminWindow.addLeafNode("Ethan", "Crystal Castles");
        adminWindow.addLeafNode("Edith", "Crystal Castles");
        adminWindow.addLeafNode("Not Alice", "Crystal Castles");
    }
    
}
