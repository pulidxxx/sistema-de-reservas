package presentacion.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import negocio.Aplicacion;
import negocio.Persona;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static Login instancia;
    private Aplicacion app;
    private JTextField txtUser;
    private JComboBox<Object> comboBoxTipoDocumento;
    private JRadioButton rdbtnUsuario;
    private JRadioButton rdbtnAdministrador;
    public static Long documento;
    public static String tipoDocumento;

    private Login() {
        app = new Aplicacion();
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

        txtUser = new JTextField();
        txtUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtUser.getText().toString().equals("N\u00B0 de documento")) {
                    txtUser.setText("");
                }
            }
        });
        txtUser.setText("N\u00B0 de documento");
        txtUser.setOpaque(false);
        txtUser.setForeground(Color.BLACK);
        txtUser.setFont(new Font("Arial", Font.PLAIN, 17));
        txtUser.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtUser.setBounds(100, 230, 300, 20);
        contentPane.add(txtUser);

        comboBoxTipoDocumento = new JComboBox<Object>();
        comboBoxTipoDocumento.setModel(
                new DefaultComboBoxModel(new String[]{"Tipo de documento", "CC", "CE", "TI", "TE", "NIT"}));
        comboBoxTipoDocumento.setToolTipText("");
        comboBoxTipoDocumento.setFont(new Font("Arial", Font.PLAIN, 17));
        comboBoxTipoDocumento.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        comboBoxTipoDocumento.setBackground(new Color(217, 209, 233));
        comboBoxTipoDocumento.setBounds(100, 270, 300, 25);
        contentPane.add(comboBoxTipoDocumento);

        // Radio buttons
        rdbtnUsuario = new JRadioButton("Usuario");
        rdbtnUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rdbtnUsuario.setOpaque(false);
        rdbtnUsuario.setFont(new Font("Arial", Font.PLAIN, 17));
        rdbtnUsuario.setBounds(100, 320, 100, 23);
        contentPane.add(rdbtnUsuario);

        rdbtnAdministrador = new JRadioButton("Recepcionista");
        rdbtnAdministrador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rdbtnAdministrador.setOpaque(false);
        rdbtnAdministrador.setFont(new Font("Arial", Font.PLAIN, 17));
        rdbtnAdministrador.setBounds(200, 320, 150, 23);
        contentPane.add(rdbtnAdministrador);

        // Grupo que contiene a los radio buttons
        ButtonGroup tipoUsuario = new ButtonGroup();
        tipoUsuario.add(rdbtnUsuario);
        tipoUsuario.add(rdbtnAdministrador);

        // Bot�n para registrar usuario
        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Registrarse.getInstancia().hacerVisible();
            }
        });
        btnRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegistrarse.setOpaque(false);
        btnRegistrarse.setForeground(Color.BLACK);
        btnRegistrarse.setFont(new Font("Arial", Font.BOLD, 13));
        btnRegistrarse.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
        btnRegistrarse.setBackground(new Color(0, 0, 0, 0));
        btnRegistrarse.setBounds(300, 380, 150, 30);
        contentPane.add(btnRegistrarse);

        // Bot�n para ingresar
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (rdbtnAdministrador.isSelected() || rdbtnUsuario.isSelected()) {

                    try {
                        confirmarRegistro();
                    } catch (Exception ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un boton", "Error de Registro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnIngresar.setOpaque(false);
        btnIngresar.setForeground(Color.BLACK);
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 13));
        btnIngresar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
        btnIngresar.setBackground(new Color(0, 0, 0, 0));
        btnIngresar.setBounds(100, 380, 150, 30);
        contentPane.add(btnIngresar);

        //////////////////////////////////////////// 77777
        JLabel lblTitulo = new JLabel("Login");
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
            Inicio.getInstancia().setVisible(true);
            Inicio.getInstancia().toFront();
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

    public static Login getInstancia() {
        if (instancia != null) {
            return instancia;
        }

        return new Login();
    }

    public void confirmarRegistro() throws Exception {

        try {
            if ("".equals(txtUser.getText()) || "N\u00B0 de documento".equals(txtUser.getText()) && ((String) comboBoxTipoDocumento.getSelectedItem()).equals("Tipo de documento")) {

                JOptionPane.showMessageDialog(null, "No está registrado o digitó mal el documento", "Error de Ingreso", JOptionPane.ERROR_MESSAGE);

            } else {
                Persona persona = app.getPersona(Long.parseLong(txtUser.getText()), (String) comboBoxTipoDocumento.getSelectedItem());

                if (persona == null) {

                    JOptionPane.showMessageDialog(null, "No está registrado o digitó mal el documento", "Error de Ingreso", JOptionPane.ERROR_MESSAGE);

                } else {
                    if (rdbtnAdministrador.isSelected()) {
                        setVisible(false);
                        OpcionesAdmin.getInstancia().hacerVisible();
                    } else {
                        documento = persona.getK_numeroDocumento();
                        tipoDocumento = persona.getK_tipoDocumento();
                        this.setVisible(false);
                        OpcionesUsuario.getInstancia().hacerVisible();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Ingreso", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void hacerVisible() {
        txtUser.setText("N\u00B0 de documento");
        comboBoxTipoDocumento.setSelectedIndex(0);
        setVisible(true);
        toFront();
    }
}
