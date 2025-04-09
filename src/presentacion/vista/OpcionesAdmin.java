package presentacion.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class OpcionesAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane = new JPanel();
    private static OpcionesAdmin instancia;

    private OpcionesAdmin() {
        instancia = this;

        // Configuraciones por defecto del frame
        setTitle("Reservas App");

        // logo
        setIconImage(new ImageIcon(getClass().getResource("/presentacion/img/icons/Logo blanco.png")).getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setAutoRequestFocus(false);
        setResizable(false);
        setBounds(0, 0, 1000, 550);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        // Bot�n para cerrar el programa
        JButton btnCerrar = new JButton("X");
        btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cerrar();
            }
        });
        contentPane.setLayout(null);
        btnCerrar.setOpaque(false);
        btnCerrar.setForeground(Color.BLACK);
        btnCerrar.setFont(new Font("Arial", Font.BOLD, 13));
        btnCerrar.setBorder(null);
        btnCerrar.setBackground(new Color(0, 0, 51));
        btnCerrar.setBounds(20, 20, 20, 20);
        contentPane.add(btnCerrar);

        // Bot�n para cerrar el frame
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                regresar();
            }
        });
        btnRegresar.setOpaque(false);
        btnRegresar.setForeground(Color.BLACK);
        btnRegresar.setFont(new Font("Arial", Font.BOLD, 13));
        btnRegresar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        btnRegresar.setBackground(new Color(0, 0, 51));
        btnRegresar.setBounds(20, 500, 92, 30);
        contentPane.add(btnRegresar);

        ///////////////////////////////////////////////////////////////////////
        JButton btnRealizarRegistro = new JButton("Realizar registro");
        btnRealizarRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                RealizarRegistro.getInstancia().hacerVisible();
            }
        });
        btnRealizarRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRealizarRegistro.setOpaque(false);
        btnRealizarRegistro.setForeground(Color.BLACK);
        btnRealizarRegistro.setFont(new Font("Arial", Font.BOLD, 13));
        btnRealizarRegistro.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
        btnRealizarRegistro.setBackground(new Color(0, 0, 0, 0));
        btnRealizarRegistro.setBounds(100, 445, 160, 28);
        contentPane.add(btnRealizarRegistro);

        JButton btnRealizarRegistro1 = new JButton("");
        btnRealizarRegistro1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                RealizarRegistro.getInstancia().hacerVisible();
            }
        });
        btnRealizarRegistro1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRealizarRegistro1.setIcon(new ImageIcon(OpcionesAdmin.class.getResource("/presentacion/img/icons/Registro.png")));
        btnRealizarRegistro1.setVerticalAlignment(SwingConstants.CENTER);
        btnRealizarRegistro1.setOpaque(false);
        btnRealizarRegistro1.setHorizontalAlignment(SwingConstants.CENTER);
        btnRealizarRegistro1.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
        btnRealizarRegistro1.setBackground(new Color(0, 0, 51));
        btnRealizarRegistro1.setBounds(100, 280, 160, 170);
        contentPane.add(btnRealizarRegistro1);

        JButton btnConsultarReserva = new JButton("Consultar reserva");
        btnConsultarReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConsultarReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                try {
                    ConsultarReserva.getInstancia().hacerVisible();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnConsultarReserva.setOpaque(false);
        btnConsultarReserva.setForeground(Color.BLACK);
        btnConsultarReserva.setFont(new Font("Arial", Font.BOLD, 13));
        btnConsultarReserva.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
        btnConsultarReserva.setBackground(new Color(0, 0, 0, 0));
btnConsultarReserva.setBounds(258, 445, 160, 28);btnConsultarReserva.setBounds(258, 445, 160, 28);
        contentPane.add(btnConsultarReserva);

        JButton btnConsultarReserva1 = new JButton("");
        btnConsultarReserva1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConsultarReserva1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                try {
                    ConsultarReserva.getInstancia().hacerVisible();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnConsultarReserva1
                .setIcon(new ImageIcon(OpcionesAdmin.class.getResource("/presentacion/img/icons/Consultar reserva.png")));
        btnConsultarReserva1.setVerticalAlignment(SwingConstants.CENTER);
        btnConsultarReserva1.setOpaque(false);
        btnConsultarReserva1.setHorizontalAlignment(SwingConstants.CENTER);
        btnConsultarReserva1.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
        btnConsultarReserva1.setBackground(new Color(0, 0, 51));
	btnConsultarReserva1.setBounds(258, 280, 160, 170);
        contentPane.add(btnConsultarReserva1);

        JButton btnConfiguraciones = new JButton("Configuraciones");
        btnConfiguraciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConfiguraciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Configuraciones.getInstancia().hacerVisible();
            }
        });
        btnConfiguraciones.setOpaque(false);
        btnConfiguraciones.setForeground(Color.BLACK);
        btnConfiguraciones.setFont(new Font("Arial", Font.BOLD, 13));
        btnConfiguraciones.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
        btnConfiguraciones.setBackground(new Color(0, 0, 0, 0));
        btnConfiguraciones.setBounds(416, 445, 150, 28);
        contentPane.add(btnConfiguraciones);

        JButton btnConfiguraciones1 = new JButton("");
        btnConfiguraciones1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConfiguraciones1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Configuraciones.getInstancia().hacerVisible();
            }
        });
        btnConfiguraciones1.setIcon(new ImageIcon(OpcionesAdmin.class.getResource("/presentacion/img/icons/Configuraciones.png")));
        btnConfiguraciones1.setVerticalAlignment(SwingConstants.CENTER);
        btnConfiguraciones1.setOpaque(false);
        btnConfiguraciones1.setHorizontalAlignment(SwingConstants.CENTER);
        btnConfiguraciones1.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
        btnConfiguraciones1.setBackground(new Color(0, 0, 51));
        btnConfiguraciones1.setBounds(416, 280, 150, 170);
        contentPane.add(btnConfiguraciones1);

        //////////////////////////////////////////////////////////
        JLabel lblTitulo = new JLabel("\u00BFQu\u00E9 deseas realizar?");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 38));
        lblTitulo.setBounds(0, 150, 700, 40);
        contentPane.add(lblTitulo);

        JLabel lblReservasApp = new JLabel("Reservas app");
        lblReservasApp.setHorizontalAlignment(SwingConstants.CENTER);
        lblReservasApp.setForeground(SystemColor.controlHighlight);
        lblReservasApp.setFont(new Font("Arial", Font.BOLD, 38));
        lblReservasApp.setBounds(700, 275, 300, 70);
        contentPane.add(lblReservasApp);

        JLabel lblLogoNegro = new JLabel("");
        lblLogoNegro.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogoNegro.setOpaque(false);
        lblLogoNegro.setBounds(0, 50, 700, 100);
        lblLogoNegro.setIcon(new ImageIcon(Login.class.getResource("/presentacion/img/icons/Logo negro.png")));
        contentPane.add(lblLogoNegro);

        JLabel lblLogoBlanco = new JLabel("");
        lblLogoBlanco.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogoBlanco.setOpaque(false);
        lblLogoBlanco.setBounds(700, 175, 300, 100);
        lblLogoBlanco.setIcon(new ImageIcon(Login.class.getResource("/presentacion/img/icons/Logo blanco.png")));
        contentPane.add(lblLogoBlanco);

        JLabel fondoMorado = new JLabel("");
        fondoMorado.setIcon(new ImageIcon(getClass().getResource("/presentacion/img/Background purple.jpg")));
        fondoMorado.setBounds(700, 0, 300, 550);
        fondoMorado.setOpaque(true);
        contentPane.add(fondoMorado);

        JLabel fondoBlanco = new JLabel("");
        fondoBlanco.setBounds(0, 0, 700, 550);
        fondoBlanco.setBackground(new Color(217, 209, 233));
        fondoBlanco.setOpaque(true);
        contentPane.add(fondoBlanco);

    }

    // Metodo del boton regresar
    public void regresar() {
        String botones[] = {"Regresar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "\u00bfDeseas regresar a la anterior ventana?", "Regresar", 0, 0,
                null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            Login.getInstancia().hacerVisible();
        }
    }

    // Metodo del boton cerrar
    public void cerrar() {
        String botones[] = {"Cerrar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "\u00bfDeseas cerrar la aplicaci\u00f3n?",
                "Cerrar aplicaci\u00f3n", 0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }

    public static OpcionesAdmin getInstancia() {
        if (instancia != null) {
            return instancia;
        }

        return new OpcionesAdmin();
    }

    public void hacerVisible() {
        setVisible(true);
        toFront();
    }
}
