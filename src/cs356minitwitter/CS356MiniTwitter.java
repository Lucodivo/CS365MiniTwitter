/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356minitwitter;

import cs356minitwitter.nodes.GroupComposite;
import cs356minitwitter.nodes.UserLeaf;
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
        
        GroupComposite bands = new GroupComposite("Bands");
        adminWindow.addGroupNode(bands, "root");
        
        GroupComposite crystalCastles = new GroupComposite("Crystal Castles");
        adminWindow.addGroupNode(crystalCastles, "Bands");
        UserLeaf ethan = new UserLeaf("Ethan");
        UserLeaf edith = new UserLeaf("Edith");
        UserLeaf notAlice = new UserLeaf("Not Alice");
        adminWindow.addLeafNode(ethan, "Crystal Castles");
        adminWindow.addLeafNode(edith, "Crystal Castles");
        adminWindow.addLeafNode(notAlice, "Crystal Castles");
        
        GroupComposite futureIslands = new GroupComposite("Future Islands");
        adminWindow.addGroupNode(futureIslands, "Bands");
        UserLeaf samuel = new UserLeaf("Samuel");
        UserLeaf gerrit = new UserLeaf("Gerrit");
        UserLeaf william = new UserLeaf("William");
        adminWindow.addLeafNode(samuel, "Future Islands");
        adminWindow.addLeafNode(gerrit, "Future Islands");
        adminWindow.addLeafNode(william, "Future Islands");
        
        GroupComposite noMembers = new GroupComposite("No Members");
        adminWindow.addGroupNode(noMembers, "Bands");
    }
    
}
