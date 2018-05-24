package com.esucri.financa.view;

import com.esucri.financa.model.Usuario;
import com.esucri.financa.controller.DaoUsuario;
import com.esucri.financa.utils.AlertUtils;
import com.esucri.financa.utils.MD5Utils;
import com.esucri.financa.utils.StringUtils;

public class Login extends javax.swing.JFrame {

    public Login() {        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelLogin = new javax.swing.JTextField();
        botaoLogin = new javax.swing.JButton();
        labelCadastroUsuario = new javax.swing.JLabel();
        labelSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setName("Login"); // NOI18N
        setType(java.awt.Window.Type.POPUP);

        jLabel1.setText("Login:");

        jLabel2.setText("Senha:");

        botaoLogin.setText("Login");
        botaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLoginActionPerformed(evt);
            }
        });

        labelCadastroUsuario.setText("Não possui login? clique aqui");
        labelCadastroUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCadastroUsuarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botaoLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(labelLogin)
                            .addComponent(labelSenha)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(labelCadastroUsuario)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoLogin)
                .addGap(18, 18, 18)
                .addComponent(labelCadastroUsuario)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelCadastroUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCadastroUsuarioMouseClicked
        CadastroUsuario cadastroUsuario = new CadastroUsuario();
        cadastroUsuario.create();
    }//GEN-LAST:event_labelCadastroUsuarioMouseClicked

    private void botaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLoginActionPerformed
        try {
            String[] fieldList = { labelLogin.getText(), 
                                   labelSenha.getText()
            };
            if (!StringUtils.stringListIsValid(fieldList)) {
               AlertUtils.warning("Nem todos os campos foram preennchidos!");
               return;
            }
            Boolean loginExiste = new DaoUsuario().loginValido(labelLogin.getText(), labelSenha.getText());
            if (loginExiste) {
                Usuario usuarioLogado = new DaoUsuario().findByLoginSenha(labelLogin.getText(), MD5Utils.encriptarSenha(labelSenha.getText()));
                Menu.create(usuarioLogado.getId(), usuarioLogado.getLogin());
                this.dispose();
            } else {
                AlertUtils.warning("Usuário não encontrado!");
            }
        } catch (Exception ex) {
            AlertUtils.error(ex.getMessage());
        }
    }//GEN-LAST:event_botaoLoginActionPerformed

    public void create() {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {                
                Login login = new Login();
                login.setTitle("Login - Finanças");
                login.setLocationRelativeTo(null);
                login.setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelCadastroUsuario;
    private javax.swing.JTextField labelLogin;
    private javax.swing.JPasswordField labelSenha;
    // End of variables declaration//GEN-END:variables
}
