package cs356minitwitter.form;

import cs356minitwitter.node.RootComposite;
import cs356minitwitter.model.UserGroupTreeModel;

/**
 * GUI for an Admin MiniTwitter window
 * All ActionListeners must be assigned to components in inherited class
 * JTree set up to work with UserGroupComponents
 * 
 * @author Connor
 */
public abstract class AdminUI extends javax.swing.JFrame {

    /**
     * Creates new form, look, and feel of AdminUI
     */
    protected AdminUI() {
        setNimbusLookAndFeel();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openUserViewButton = new javax.swing.JButton();
        showPositivePercentageButton = new javax.swing.JButton();
        showMessagesTotalButton = new javax.swing.JButton();
        showUserTotalButton = new javax.swing.JButton();
        showGroupTotalButton = new javax.swing.JButton();
        addUserButton = new javax.swing.JButton();
        addGroupButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        userIDTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        groupIDTextArea = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        userGroupTreePane = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        openUserViewButton.setText("Open User View");

        showPositivePercentageButton.setText("Show Positive Percentage");

        showMessagesTotalButton.setText("Show Messages Total");

        showUserTotalButton.setText("Show User Total");

        showGroupTotalButton.setText("Show Group Total");

        addUserButton.setText("Add User");

        addGroupButton.setText("Add Group");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        userIDTextArea.setColumns(20);
        userIDTextArea.setRows(5);
        jScrollPane2.setViewportView(userIDTextArea);
        userIDTextArea.getAccessibleContext().setAccessibleName("UserIDTextArea");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        groupIDTextArea.setColumns(20);
        groupIDTextArea.setRows(5);
        jScrollPane3.setViewportView(groupIDTextArea);
        groupIDTextArea.getAccessibleContext().setAccessibleName("GroupIDTextArea");

        userGroupTreePane.setModel(new UserGroupTreeModel(new RootComposite("root")));
        userGroupTreePane.setToolTipText("");
        jScrollPane5.setViewportView(userGroupTreePane);
        userGroupTreePane.getAccessibleContext().setAccessibleName("UserGroupTreePane");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openUserViewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showUserTotalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(showMessagesTotalButton, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(showPositivePercentageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(showGroupTotalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addGroupButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addComponent(openUserViewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showUserTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showGroupTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(showPositivePercentageButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(showMessagesTotalButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))))
                .addContainerGap())
        );

        openUserViewButton.getAccessibleContext().setAccessibleName("openUserViewButton");
        showPositivePercentageButton.getAccessibleContext().setAccessibleName("ShowPositivePercentageButton");
        showMessagesTotalButton.getAccessibleContext().setAccessibleName("ShowMessagesTotalButton");
        showUserTotalButton.getAccessibleContext().setAccessibleName("ShowUserTotalButton");
        showGroupTotalButton.getAccessibleContext().setAccessibleName("ShowGroupTotalButton");
        showGroupTotalButton.getAccessibleContext().setAccessibleDescription("");
        addUserButton.getAccessibleContext().setAccessibleName("AddUserButton");
        addGroupButton.getAccessibleContext().setAccessibleName("AddGroupButton");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Called in constructor
     * Sets the Nimbus Look and Feel for the UI for this and
     * all windows created after unless specified otherwise
     */
    protected static void setNimbusLookAndFeel() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton addGroupButton;
    protected javax.swing.JButton addUserButton;
    protected javax.swing.JTextArea groupIDTextArea;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    protected javax.swing.JButton openUserViewButton;
    protected javax.swing.JButton showGroupTotalButton;
    protected javax.swing.JButton showMessagesTotalButton;
    protected javax.swing.JButton showPositivePercentageButton;
    protected javax.swing.JButton showUserTotalButton;
    protected javax.swing.JTree userGroupTreePane;
    protected javax.swing.JTextArea userIDTextArea;
    // End of variables declaration//GEN-END:variables
}
