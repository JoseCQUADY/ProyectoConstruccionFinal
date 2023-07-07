package View;

/**
 * @author Ian Aguilar, Jose Chi, Genaro Cutz
*/
public class ViewMenu extends javax.swing.JFrame {

    public ViewMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ButtonDeposit = new javax.swing.JButton();
        ButtonWithdrawal = new javax.swing.JButton();
        ButtonAccounts = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ButtonClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ButtonDeposit.setBackground(new java.awt.Color(255, 255, 254));
        ButtonDeposit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonDeposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/donacionjpg75.jpg"))); // NOI18N
        ButtonDeposit.setText("Deposito");
        ButtonDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDepositActionPerformed(evt);
            }
        });

        ButtonWithdrawal.setBackground(new java.awt.Color(255, 255, 254));
        ButtonWithdrawal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonWithdrawal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/retiro-de-dinero75.png"))); // NOI18N
        ButtonWithdrawal.setText("Retiro");
        ButtonWithdrawal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonWithdrawalActionPerformed(evt);
            }
        });

        ButtonAccounts.setBackground(new java.awt.Color(255, 255, 254));
        ButtonAccounts.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/usuario75.png"))); // NOI18N
        ButtonAccounts.setText("Cuentas");
        ButtonAccounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAccountsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ButtonClose.setBackground(new java.awt.Color(0, 153, 255));
        ButtonClose.setText("Cerrar");
        ButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ButtonDeposit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonWithdrawal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonAccounts)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonClose)))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonWithdrawal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonAccounts)
                    .addComponent(ButtonDeposit))
                .addGap(4, 4, 4)
                .addComponent(ButtonClose)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDepositActionPerformed

    }//GEN-LAST:event_ButtonDepositActionPerformed

    private void ButtonWithdrawalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonWithdrawalActionPerformed

    }//GEN-LAST:event_ButtonWithdrawalActionPerformed

    private void ButtonAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAccountsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonAccountsActionPerformed

    private void ButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCloseActionPerformed

    }//GEN-LAST:event_ButtonCloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ButtonAccounts;
    public javax.swing.JButton ButtonClose;
    public javax.swing.JButton ButtonDeposit;
    public javax.swing.JButton ButtonWithdrawal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
