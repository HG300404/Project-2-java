/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package material.management;

import java.rmi.Naming;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DAOInterface;
import model.User;

/**
 *
 * @author Administrator
 */
public class UserJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UserJPanel
     */
    ArrayList<User> list;
    DefaultTableModel model;

    public UserJPanel() {
        try {
            initComponents();
            DAOInterface dbi = (DAOInterface) Naming.lookup("rmi://localhost:9999/db");
            txtIDUser.setText(dbi.getIDUser());
            list = dbi.selectAllUser();

            model = (DefaultTableModel) jTableUser.getModel();
            model.setColumnIdentifiers(new Object[]{
                "UserName", "Password", "Role", "IDUser"
            });
            showData();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showData() {
        model.setRowCount(0); // reset du lieu trong bang ve 0
        for (User p : list) {
            model.addRow(new Object[]{
                p.getUserName(), p.getPassword(), p.getRole(), p.getIDUser()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUser = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRole = new javax.swing.JTextField();
        butInsert = new javax.swing.JButton();
        butDelete = new javax.swing.JButton();
        butReset = new javax.swing.JButton();
        butUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtIDUser = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ACCOUNT");

        jTableUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserName", "Password", "Role", "IDUser"
            }
        ));
        jTableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUser);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("UserName");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Password");

        txtUserName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Role");

        txtRole.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        butInsert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        butInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-avatar (1).png"))); // NOI18N
        butInsert.setText("Insert");
        butInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butInsertActionPerformed(evt);
            }
        });

        butDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        butDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteemp.png"))); // NOI18N
        butDelete.setText("Delete");
        butDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDeleteActionPerformed(evt);
            }
        });

        butReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        butReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        butReset.setText("Reset");
        butReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butResetActionPerformed(evt);
            }
        });

        butUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        butUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updateemp.png"))); // NOI18N
        butUpdate.setText("Update");
        butUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUpdateActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("IDUser");

        txtIDUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(72, 72, 72)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(txtPassword)
                                    .addComponent(txtRole)
                                    .addComponent(txtIDUser))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(147, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(butUpdate)
                            .addComponent(butInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(92, 92, 92)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(butDelete)
                            .addComponent(butReset, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(118, 118, 118)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butInsert)
                            .addComponent(butDelete)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butReset)
                    .addComponent(butUpdate))
                .addGap(113, 113, 113))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butInsertActionPerformed
        // TODO add your handling code here:
        try {
            User p = new User();
            p.setUserName(txtUserName.getText());
            p.setPassword(txtPassword.getText());
            p.setRole(txtRole.getText());
            p.setIDUser(Integer.parseInt(txtIDUser.getText()));
            DAOInterface dbi = (DAOInterface) Naming.lookup("rmi://localhost:9999/db");
            int result = dbi.insertUser(p.getUserName(), p.getPassword(), p.getRole(), p.getIDUser());
            JOptionPane.showMessageDialog(null, "Inserted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            list = dbi.selectAllUser();
            showData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butInsertActionPerformed

    private void butDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDeleteActionPerformed
        // TODO add your handling code here:
        try {
            User p = new User();
            p.setUserName(txtUserName.getText());
            p.setPassword(txtPassword.getText());
            p.setRole(txtRole.getText());
            if (p.getRole() == "Admin") {
                p.setIDUser(0);
            } else {
                p.setIDUser(Integer.parseInt(txtIDUser.getText()));
            }
            DAOInterface dbi = (DAOInterface) Naming.lookup("rmi://localhost:9999/db");
            int result = dbi.deleteUser(p.getUserName(), p.getPassword(), p.getRole(), p.getIDUser());
            JOptionPane.showMessageDialog(null, "Deleted Successfully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
            list = dbi.selectAllUser();
            showData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butDeleteActionPerformed

    private void butUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butUpdateActionPerformed
        // TODO add your handling code here:
        try {
            User p = new User();
            p.setUserName(txtUserName.getText());
            p.setPassword(txtPassword.getText());
            p.setRole(txtRole.getText());
            p.setIDUser(Integer.parseInt(txtIDUser.getText()));
            DAOInterface dbi = (DAOInterface) Naming.lookup("rmi://localhost:9999/db");
            int result = dbi.updateUser(p.getUserName(), p.getPassword(), p.getRole(), p.getIDUser());
            JOptionPane.showMessageDialog(null, "Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            list = dbi.selectAllUser();
            showData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butUpdateActionPerformed

    private void butResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butResetActionPerformed
        // TODO add your handling code here:
        try {
            DAOInterface dbi = (DAOInterface) Naming.lookup("rmi://localhost:9999/db");
            list = dbi.selectAllUser();
            showData();
            txtUserName.setText("");
            txtPassword.setText("");
            txtRole.setText("");
            txtIDUser.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_butResetActionPerformed

    private void jTableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUserMouseClicked
        // TODO add your handling code here:
        int index = jTableUser.getSelectedRow();
        model = (DefaultTableModel) jTableUser.getModel();

        String UserName = model.getValueAt(index, 0).toString();
        String Password = model.getValueAt(index, 1).toString();
        String Role = model.getValueAt(index, 2).toString();
        int IDUser = Integer.parseInt(model.getValueAt(index, 3).toString());
        txtUserName.setText(UserName);
        txtPassword.setText(Password);
        txtRole.setText(Role);
        txtIDUser.setText(String.valueOf(IDUser));
    }//GEN-LAST:event_jTableUserMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butDelete;
    private javax.swing.JButton butInsert;
    private javax.swing.JButton butReset;
    private javax.swing.JButton butUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUser;
    private javax.swing.JTextField txtIDUser;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
