package addrec;

import javax.swing.*;

public class LoginForm extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin, btnRegister;

    public LoginForm() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(30, 30, 80, 25);
        add(lblUser);

        txtUser = new JTextField();
        txtUser.setBounds(120, 30, 120, 25);
        add(txtUser);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(30, 70, 80, 25);
        add(lblPass);

        txtPass = new JPasswordField();
        txtPass.setBounds(120, 70, 120, 25);
        add(txtPass);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(30, 110, 100, 25);
        add(btnLogin);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(140, 110, 100, 25);
        add(btnRegister);

        // Actions
        btnLogin.addActionListener(e -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());

            if (DatabaseHelper.login(user, pass)) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                dispose();
                new AddRec().setVisible(true); // open your main app
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        });

        btnRegister.addActionListener(e -> {
            dispose();
            new RegisterForm().setVisible(true);
        });
    }

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }
}