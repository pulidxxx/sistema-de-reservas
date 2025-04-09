package presentacion.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class OpcionesUsuario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane = new JPanel();
    private static OpcionesUsuario instancia;

    private OpcionesUsuario() {
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
        JButton btnRealizarReserva = new JButton("Realizar reserva");
        btnRealizarReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                RealizarReserva.getInstancia().hacerVisible();
            }
        });
        btnRealizarReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRealizarReserva.setOpaque(false);
        btnRealizarReserva.setForeground(Color.BLACK);
        btnRealizarReserva.setFont(new Font("Arial", Font.BOLD, 13));
        btnRealizarReserva.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
        btnRealizarReserva.setBackground(new Color(0, 0, 0, 0));
        btnRealizarReserva.setBounds(105, 439, 180, 28);
        contentPane.add(btnRealizarReserva);

        JButton btnRealizarReserva1 = new JButton("");
        btnRealizarReserva1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                RealizarReserva.getInstancia().hacerVisible();
            }
        });
        btnRealizarReserva1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRealizarReserva1.setIcon(new ImageIcon(OpcionesUsuario.class.getResource("/presentacion/img/icons/Agregar.png")));
        btnRealizarReserva1.setVerticalAlignment(SwingConstants.CENTER);
        btnRealizarReserva1.setOpaque(false);
        btnRealizarReserva1.setHorizontalAlignment(SwingConstants.CENTER);
        btnRealizarReserva1.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
        btnRealizarReserva1.setBackground(new Color(0, 0, 51));
        btnRealizarReserva1.setBounds(105, 275, 180, 170);
        contentPane.add(btnRealizarReserva1);

        JButton btnMisReservas = new JButton("Mis reservas\r\n");
        btnMisReservas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnMisReservas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                try {
                    MisReservas.getInstancia().cargarReservas();
                    MisReservas.getInstancia().hacerVisible();
                } catch (Exception ex) {
                    Logger.getLogger(OpcionesUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
        btnMisReservas.setOpaque(false);
        btnMisReservas.setForeground(Color.BLACK);
        btnMisReservas.setFont(new Font("Arial", Font.BOLD, 13));
        btnMisReservas.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));
        btnMisReservas.setBackground(new Color(0, 0, 0, 0));
        btnMisReservas.setBounds(390, 439, 180, 28);
        contentPane.add(btnMisReservas);

        JButton btnMisReservas1 = new JButton("");
        btnMisReservas1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                try {
                    MisReservas.getInstancia().cargarReservas();
                    MisReservas.getInstancia().hacerVisible();
                } catch (Exception ex) {
                    Logger.getLogger(OpcionesUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        btnMisReservas1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnMisReservas1.setIcon(new ImageIcon(OpcionesUsuario.class.getResource("/presentacion/img/icons/Buscar.png")));
        btnMisReservas1.setVerticalAlignment(SwingConstants.CENTER);
        btnMisReservas1.setOpaque(false);
        btnMisReservas1.setHorizontalAlignment(SwingConstants.CENTER);
        btnMisReservas1.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
        btnMisReservas1.setBackground(new Color(0, 0, 51));
        btnMisReservas1.setBounds(390, 275, 180, 170);
        contentPane.add(btnMisReservas1);

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

    public static OpcionesUsuario getInstancia() {
        if (instancia != null) {
            return instancia;
        }

        return new OpcionesUsuario();
    }
    
    public void hacerVisible() {
        setVisible(true);
        toFront();
    }
}
