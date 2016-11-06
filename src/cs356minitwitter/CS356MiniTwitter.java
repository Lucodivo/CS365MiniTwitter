/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter;

import cs356minitwitter.ui.AdminWindow;
import cs356minitwitter.user.TwitterUser;

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
        TwitterUser ethan = new TwitterUser("Ethan");
        TwitterUser edith = new TwitterUser("Edith");
        TwitterUser notAlice = new TwitterUser("Not Alice");
        adminWindow.addLeafNode(ethan, "Crystal Castles");
        adminWindow.addLeafNode(edith, "Crystal Castles");
        adminWindow.addLeafNode(notAlice, "Crystal Castles");
        
        adminWindow.addGroupNode("Future Islands", "Bands");
        TwitterUser samuel = new TwitterUser("Samuel");
        TwitterUser gerrit = new TwitterUser("Gerrit");
        TwitterUser william = new TwitterUser("William");
        adminWindow.addLeafNode(samuel, "Future Islands");
        adminWindow.addLeafNode(gerrit, "Future Islands");
        adminWindow.addLeafNode(william, "Future Islands");
    }
    
}
