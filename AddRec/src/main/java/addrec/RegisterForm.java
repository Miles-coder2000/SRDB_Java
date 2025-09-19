package addrec;

public class RegisterForm extends javax.swing.JFrame {

    public RegisterForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        
        txtUSERNAME = new javax.swing.JTextField();
        txtPASSWORD = new javax.swing.JPasswordField();
        txtCONFIRM = new javax.swing.JPasswordField();
        btnREGISTER = new javax.swing.JButton();
        btnCANCEL = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");
        jLabel1.setText("Register New Account");
        jLabel3.setText("Username:");
        jLabel4.setText("Password:");
        btnREGISTER.setText("Register");
        btnREGISTER.addActionListener(evt -> btnREGISTERActionPerformed(evt));

        btnCANCEL.setText("Cancel");
        btnCANCEL.addActionListener(evt -> dispose());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        
                        .addComponent(txtUSERNAME)
                        .addComponent(txtPASSWORD)
                        .addComponent(txtCONFIRM)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnREGISTER)
                            .addGap(18)
                            .addComponent(btnCANCEL))))
                .addGroup(layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(30)
                .addComponent(jLabel1)
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    
                    )
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUSERNAME))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPASSWORD))
                .addGap(10)
                .addComponent(txtCONFIRM)
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnREGISTER)
                    .addComponent(btnCANCEL))
                .addGap(30)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void btnREGISTERActionPerformed(java.awt.event.ActionEvent evt) {
        String user = txtUSERNAME.getText().trim();
        String pass = new String(txtPASSWORD.getPassword());
        String confirm = new String(txtCONFIRM.getPassword());

        if (user.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "⚠ All fields are required!");
            return;
        }

        if (!pass.equals(confirm)) {
            javax.swing.JOptionPane.showMessageDialog(this, "⚠ Passwords do not match!");
            return;
        }

        if (DatabaseHelper.register(user, pass)) {
            javax.swing.JOptionPane.showMessageDialog(this, "✅ Registration Successful!");
            new LoginForm().setVisible(true);
            dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "⚠ Registration failed! Try a different Username.");
        }
    }

    private javax.swing.JButton btnCANCEL;
    private javax.swing.JButton btnREGISTER;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtPASSWORD;
    private javax.swing.JPasswordField txtCONFIRM;
    private javax.swing.JTextField txtUSERNAME;
    
}
