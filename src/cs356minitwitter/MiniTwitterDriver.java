package cs356minitwitter;

import cs356minitwitter.node.GroupComposite;
import cs356minitwitter.node.UserLeaf;

/**
 * The Driver class of the MiniTwitter project
 * Opens an AdminWindow and populates the window with several users and groups
 * Program allows you to:
 * - add new users and new groups through it's GUI
 * - open up users in their own window and post tweets
 * - follow users and see their new posts
 * - analyze data about the current tweets, groups, and users
 *
 * @author Connor
 */
public class MiniTwitterDriver {

    /**
     * Function that creates an AdminWindow and populates it with groups and users
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // access the adminWindow singleton
        AdminWindow adminWindow = AdminWindow.getAdminWindow();
        
        // add a group called "Bands" in the root
        GroupComposite bands = new GroupComposite("Bands");
        adminWindow.addNode(bands, "root");
        
        // add groups to the "Bands" group
        GroupComposite crystalCastles = new GroupComposite("Crystal Castles");
        GroupComposite futureIslands = new GroupComposite("Future Islands");
        GroupComposite noMembers = new GroupComposite("No Members");
        adminWindow.addNode(crystalCastles, "Bands");
        adminWindow.addNode(futureIslands, "Bands");
        adminWindow.addNode(noMembers, "Bands");
        
        // add users and group to "Crystal Castles" group
        UserLeaf ethan = new UserLeaf("Ethan");
        UserLeaf edith = new UserLeaf("Edith");
        GroupComposite testGroup = new GroupComposite("???");
        UserLeaf notAlice = new UserLeaf("Not Alice");
        adminWindow.addNode(ethan, "Crystal Castles");
        adminWindow.addNode(edith, "Crystal Castles");
        adminWindow.addNode(testGroup, "Crystal Castles");
        adminWindow.addNode(notAlice, "Crystal Castles");
        
        // add users to "Future Islands" group
        UserLeaf samuel = new UserLeaf("Samuel");
        UserLeaf gerrit = new UserLeaf("Gerrit");
        UserLeaf william = new UserLeaf("William");
        adminWindow.addNode(samuel, "Future Islands");
        adminWindow.addNode(gerrit, "Future Islands");
        adminWindow.addNode(william, "Future Islands");
        
    }
    
}
