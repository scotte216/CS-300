/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import javax.swing.*;
import java.sql.*;



/**
 *
 * @author scott ewing
 */
public class TaskManager extends javax.swing.JFrame {
    private SQLConnect database = new SQLConnect();
    private String name = "scott";
    
    @SuppressWarnings("unchecked")
    final void FillList(JList to_fill, int tasktype)
    {
        try {
            Connection con =  database.ConnectDB();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM TASKS WHERE NAME = '"+name+"' AND TASKTYPE = '"+tasktype+"'";
            ResultSet rs = stmt.executeQuery(query);
            
            DefaultListModel<Task> DLM = new DefaultListModel<>();
            
            while (rs.next())
            {
                Task temp = new Task(rs.getString("task"),Integer.parseInt(rs.getString("reference")));
                DLM.addElement(temp);
            }
 
            to_fill.setModel(DLM);
 
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
    }   
            
    public TaskManager() {
        
        this.name = null;
        initComponents();
        FillList(toDoList,0);
        FillList(inProgressList,1);
        FillList(doneList,2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newTaskButton = new javax.swing.JButton();
        editTaskButton = new javax.swing.JButton();
        promoteToInProgressButton = new javax.swing.JButton();
        promoteToDoneButton = new javax.swing.JButton();
        deleteTaskButton = new javax.swing.JButton();
        toDoLabel = new javax.swing.JLabel();
        inProgressLabel = new javax.swing.JLabel();
        doneLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        doneList = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        inProgressList = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        toDoList = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        TaskManagerMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Task Manager");
        setName("To Do"); // NOI18N
        setResizable(false);

        newTaskButton.setText("New Task");
        newTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTaskButtonActionPerformed(evt);
            }
        });

        editTaskButton.setText("Edit Task");
        editTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTaskButtonActionPerformed(evt);
            }
        });

        promoteToInProgressButton.setText(">>");
        promoteToInProgressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promoteToInProgressButtonActionPerformed(evt);
            }
        });

        promoteToDoneButton.setText(">>");
        promoteToDoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promoteToDoneButtonActionPerformed(evt);
            }
        });

        deleteTaskButton.setText("Delete Task");
        deleteTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTaskButtonActionPerformed(evt);
            }
        });

        toDoLabel.setText("To Do");

        inProgressLabel.setText("In Progress");

        doneLabel.setText("Done");

        jScrollPane1.setViewportView(doneList);

        jScrollPane3.setViewportView(inProgressList);

        jScrollPane4.setViewportView(toDoList);

        TaskManagerMenu.setText("File");
        jMenuBar1.add(TaskManagerMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(toDoLabel)
                .addGap(224, 224, 224)
                .addComponent(inProgressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(doneLabel)
                .addGap(104, 104, 104))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editTaskButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newTaskButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteTaskButton))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(promoteToInProgressButton)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(promoteToDoneButton)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inProgressLabel)
                        .addComponent(doneLabel))
                    .addComponent(toDoLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(promoteToInProgressButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(promoteToDoneButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newTaskButton)
                    .addComponent(deleteTaskButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editTaskButton)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void promoteToInProgressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promoteToInProgressButtonActionPerformed
        
        if (toDoList.getSelectedIndex() >= 0){
            try {
                Task temp = (Task) toDoList.getSelectedValue();
                
                Connection con =  database.ConnectDB();
                Statement stmt = con.createStatement();
                String query = "UPDATE TASKS SET TASKTYPE = 1 WHERE REFERENCE = '"+temp.getReference()+"'";

                stmt.execute(query);
                
                FillList(toDoList,0);
                FillList(inProgressList,1);

            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
           }
        }
    }//GEN-LAST:event_promoteToInProgressButtonActionPerformed

    private void promoteToDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promoteToDoneButtonActionPerformed
        if (inProgressList.getSelectedIndex() >= 0){
            try {
                Task temp = (Task) inProgressList.getSelectedValue();
                
                Connection con =  database.ConnectDB();
                Statement stmt = con.createStatement();
                String query = "UPDATE TASKS SET TASKTYPE = 2 WHERE REFERENCE = '"+temp.getReference()+"'";

                stmt.execute(query);
                
                FillList(inProgressList,1);
                FillList(doneList,2);

            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
           }
        }
    }//GEN-LAST:event_promoteToDoneButtonActionPerformed

    private void deleteTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTaskButtonActionPerformed
        if (doneList.getSelectedIndex() >= 0){
            try {
                Task temp = (Task) doneList.getSelectedValue();
                
                Connection con =  database.ConnectDB();
                Statement stmt = con.createStatement();
                String query = "DELETE FROM TASKS WHERE REFERENCE = '"+temp.getReference()+"'";

                stmt.execute(query);
                
                FillList(doneList,2);

            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
           }
        }
   
    }//GEN-LAST:event_deleteTaskButtonActionPerformed

    private void newTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTaskButtonActionPerformed

        String newToDotxt = JOptionPane.showInputDialog(null,"New Task:","New Task",JOptionPane.PLAIN_MESSAGE);
        
        //If cancel is hit, newToDotxt is null. If okay is hit, but no text is entered, newToDotxt is not null but empty "". 
        if (newToDotxt != null && newToDotxt.length() > 0)
        {
            try {
                Connection con =  database.ConnectDB();
                Statement stmt = con.createStatement();
                //With NULL for an integer unique value, it will automatically pick the next biggest integer. 
                String query = "INSERT INTO TASKS VALUES(NULL,'"+name+"','"+newToDotxt+"','0')";
                stmt.execute(query);
            }   
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        FillList(toDoList,0);
        
    }//GEN-LAST:event_newTaskButtonActionPerformed

    private void editTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTaskButtonActionPerformed
        
        if (toDoList.getSelectedIndex() >= 0)
        {
            Task temp = (Task) toDoList.getSelectedValue();
            String editedToDotxt = (String)JOptionPane.showInputDialog(null, "Edit Task:","Edit Task", JOptionPane.QUESTION_MESSAGE,null,null,temp.toString());
            
            //Will be null if user hits cancel.
            if (editedToDotxt != null)
            {
                try {
                    Connection con = database.ConnectDB();
                    Statement stmt = con.createStatement();
                    String query;
                    
                    //Update the DB with the new text
                    if (editedToDotxt.length() > 0)
                    {
                        query = "UPDATE TASKS SET TASK = '"+editedToDotxt+"' WHERE REFERENCE  = '"+temp.getReference()+"'";
                    }
                    //else if the text is empty, assume they want to delete the task rather than have a task with an empty string "" 
                    else
                    {
                        query = "DELETE FROM TASKS WHERE REFERENCE = '"+temp.getReference()+"'";
                    }
                    stmt.execute(query);
                    FillList(toDoList,0);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }//GEN-LAST:event_editTaskButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TaskManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new TaskManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu TaskManagerMenu;
    private javax.swing.JButton deleteTaskButton;
    private javax.swing.JLabel doneLabel;
    private javax.swing.JList doneList;
    private javax.swing.JButton editTaskButton;
    private javax.swing.JLabel inProgressLabel;
    private javax.swing.JList inProgressList;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton newTaskButton;
    private javax.swing.JButton promoteToDoneButton;
    private javax.swing.JButton promoteToInProgressButton;
    private javax.swing.JLabel toDoLabel;
    protected javax.swing.JList toDoList;
    // End of variables declaration//GEN-END:variables
}
