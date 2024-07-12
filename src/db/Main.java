package db;

import db.DBConnection;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Crear la tabla de usuarios si no existe
        DBConnection.createTable();

        // Iniciar la interfaz gráfica
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}
