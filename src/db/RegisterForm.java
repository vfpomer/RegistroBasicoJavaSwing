package db;

import db.UserDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterForm() {
        setTitle("Formulario de registro");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Usuario:");
        usernameField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        registerButton = new JButton("Registrar");

        panel.add(userLabel);
        panel.add(usernameField);
        panel.add(passLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty placeholder
        panel.add(registerButton);

        add(panel);

        UserDAO userDAO = new UserDAO();

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (userDAO.registerUser(username, password)) {
                    JOptionPane.showMessageDialog(RegisterForm.this, "Registro correcto");
                    new LoginForm().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(RegisterForm.this, "Fallo en el registro");
                }
            }
        });
    }
}
