/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import tools.CaixaDeDialogo;


/**
 *
 * @author vinicius.altenhofen
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menCadastros = new javax.swing.JMenu();
        menUsuarios = new javax.swing.JMenuItem();
        menCandidatos = new javax.swing.JMenuItem();
        menSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menCadastros.setText("Cadastros");

        menUsuarios.setText("Usuarios");
        menUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menUsuariosActionPerformed(evt);
            }
        });
        menCadastros.add(menUsuarios);

        menCandidatos.setText("Candidatos");
        menCandidatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCandidatosActionPerformed(evt);
            }
        });
        menCadastros.add(menCandidatos);

        jMenuBar1.add(menCadastros);

        menSair.setText("Sair");
        menSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menSairActionPerformed(evt);
            }
        });
        jMenuBar1.add(menSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 926, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menUsuariosActionPerformed
        // TODO add your handling code here:
      try{
            CadastroUsuario tela = new CadastroUsuario();
            tela.setVisible(true);
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro");
        }
        
        
    }//GEN-LAST:event_menUsuariosActionPerformed

    private void menSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menSairActionPerformed
        // TODO add your handling code here:
        try{
            boolean resposta;
            resposta = CaixaDeDialogo.obterinstancia()
                    .pedirConfirmacao("Deseja mesmo sair do programa?",
                            "Confirmação", 'p');
            
            if (resposta){
                System.exit(0); //fecha todo o programa
            }
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        } 
        
        
    }//GEN-LAST:event_menSairActionPerformed

    private void menCandidatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCandidatosActionPerformed
       
    }//GEN-LAST:event_menCandidatosActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menCadastros;
    private javax.swing.JMenuItem menCandidatos;
    private javax.swing.JMenu menSair;
    private javax.swing.JMenuItem menUsuarios;
    // End of variables declaration//GEN-END:variables
}
