package presentacion.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.DefaultComboBoxModel;
import negocio.Aplicacion;
import negocio.Persona;
import negocio.Reserva;

public class ConsultarReserva extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane = new JPanel();
    private JTextField txtNumeroDocumento;
    private JTextField txtNumeroPersonas;
    private JTextField txtHabitaciones;
    private JTextField txtTipoDocumento;
    private JTextField txtValor;
    private JTextField txtNumeroNoches;
    private JComboBox<Object> comboBoxSeleccionarReserva;
    private JComboBox<Object> comboBoxCoincidencias;
    private JTextField txtDia;
    private JTextField txtMes;
    private JTextField txtAnio;
    private JTextField txtNombre;
    private static ConsultarReserva instancia;
    private Aplicacion app;

    private ConsultarReserva() {
        instancia = this;
        app = new Aplicacion();

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

        // Botón para cerrar el programa
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

        // Botón para cerrar el frame
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

        comboBoxSeleccionarReserva = new JComboBox<Object>();
        comboBoxSeleccionarReserva.setModel(new DefaultComboBoxModel(new String[]{"No tiene reservas"}));
        comboBoxSeleccionarReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBoxSeleccionarReserva.setToolTipText("");
        comboBoxSeleccionarReserva.setFont(new Font("Arial", Font.PLAIN, 17));
        comboBoxSeleccionarReserva.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        comboBoxSeleccionarReserva.setBackground(new Color(217, 209, 233));
        comboBoxSeleccionarReserva.setBounds(340, 260, 160, 25);
        contentPane.add(comboBoxSeleccionarReserva);

        comboBoxCoincidencias = new JComboBox<Object>();
        comboBoxCoincidencias.setModel(new DefaultComboBoxModel(new String[]{"Coincidencias"}));
        comboBoxCoincidencias.setToolTipText("");
        comboBoxCoincidencias.setFont(new Font("Arial", Font.PLAIN, 17));
        comboBoxCoincidencias.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        comboBoxCoincidencias.setBackground(new Color(217, 209, 233));
        comboBoxCoincidencias.setBounds(170, 260, 160, 25);
        contentPane.add(comboBoxCoincidencias);

        txtNombre = new JTextField();
        txtNombre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtNombre.getText().toString().equals("Nombre")) {
                    txtNombre.setText("");
                }
            }
        });
        txtNombre.setText("Nombre");
        txtNombre.setOpaque(false);
        txtNombre.setForeground(Color.BLACK);
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 17));
        txtNombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtNombre.setBounds(340, 210, 150, 20);
        contentPane.add(txtNombre);

        txtTipoDocumento = new JTextField();
        txtTipoDocumento.setEditable(false);
        txtTipoDocumento.setText("Tipo de documento");
        txtTipoDocumento.setOpaque(false);
        txtTipoDocumento.setForeground(Color.BLACK);
        txtTipoDocumento.setFont(new Font("Arial", Font.PLAIN, 17));
        txtTipoDocumento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtTipoDocumento.setBounds(40, 300, 150, 20);
        contentPane.add(txtTipoDocumento);

        txtNumeroDocumento = new JTextField();
        txtNumeroDocumento.setEditable(false);
        txtNumeroDocumento.setText("N° de documento");
        txtNumeroDocumento.setOpaque(false);
        txtNumeroDocumento.setForeground(Color.BLACK);
        txtNumeroDocumento.setFont(new Font("Arial", Font.PLAIN, 17));
        txtNumeroDocumento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtNumeroDocumento.setBounds(240, 300, 150, 20);
        contentPane.add(txtNumeroDocumento);

        txtHabitaciones = new JTextField();
        txtHabitaciones.setEditable(false);
        txtHabitaciones.setText("N° de habitacion");
        txtHabitaciones.setOpaque(false);
        txtHabitaciones.setForeground(Color.BLACK);
        txtHabitaciones.setFont(new Font("Arial", Font.PLAIN, 17));
        txtHabitaciones.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtHabitaciones.setBounds(440, 300, 150, 20);
        contentPane.add(txtHabitaciones);

        txtNumeroPersonas = new JTextField();
        txtNumeroPersonas.setEditable(false);
        txtNumeroPersonas.setText("N\u00B0  de personas");
        txtNumeroPersonas.setOpaque(false);
        txtNumeroPersonas.setForeground(Color.BLACK);
        txtNumeroPersonas.setFont(new Font("Arial", Font.PLAIN, 17));
        txtNumeroPersonas.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtNumeroPersonas.setBounds(440, 340, 150, 20);
        contentPane.add(txtNumeroPersonas);

        txtNumeroNoches = new JTextField();
        txtNumeroNoches.setEditable(false);
        txtNumeroNoches.setText("N\u00B0 de noches");
        txtNumeroNoches.setOpaque(false);
        txtNumeroNoches.setForeground(Color.BLACK);
        txtNumeroNoches.setFont(new Font("Arial", Font.PLAIN, 17));
        txtNumeroNoches.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtNumeroNoches.setBounds(40, 340, 150, 20);
        contentPane.add(txtNumeroNoches);

        txtValor = new JTextField();
        txtValor.setEditable(false);
        txtValor.setText("Valor");
        txtValor.setOpaque(false);
        txtValor.setForeground(Color.BLACK);
        txtValor.setFont(new Font("Arial", Font.PLAIN, 17));
        txtValor.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtValor.setBounds(242, 337, 150, 20);
        contentPane.add(txtValor);

        txtDia = new JTextField();
        txtDia.setEditable(false);
        txtDia.setText("Dia");
        txtDia.setOpaque(false);
        txtDia.setForeground(Color.BLACK);
        txtDia.setFont(new Font("Arial", Font.PLAIN, 17));
        txtDia.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtDia.setBounds(40, 430, 150, 20);
        contentPane.add(txtDia);

        txtMes = new JTextField();
        txtMes.setEditable(false);
        txtMes.setText("Mes");
        txtMes.setOpaque(false);
        txtMes.setForeground(Color.BLACK);
        txtMes.setFont(new Font("Arial", Font.PLAIN, 17));
        txtMes.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtMes.setBounds(240, 430, 150, 20);
        contentPane.add(txtMes);

        txtAnio = new JTextField();
        txtAnio.setEditable(false);
        txtAnio.setText("A\u00F1o");
        txtAnio.setOpaque(false);
        txtAnio.setForeground(Color.BLACK);
        txtAnio.setFont(new Font("Arial", Font.PLAIN, 17));
        txtAnio.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtAnio.setBounds(440, 430, 150, 20);
        contentPane.add(txtAnio);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    cargarReservas();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBuscar.setOpaque(false);
        btnBuscar.setForeground(Color.BLACK);
        btnBuscar.setFont(new Font("Arial", Font.BOLD, 13));
        btnBuscar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
        btnBuscar.setBackground(new Color(0, 0, 0, 0));
        btnBuscar.setBounds(532, 260, 100, 28);
        contentPane.add(btnBuscar);

        JButton btnBuscarNombre = new JButton("Buscar nombre");
        btnBuscarNombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarNombres();
            }
        });
        btnBuscarNombre.setOpaque(false);
        btnBuscarNombre.setForeground(Color.BLACK);
        btnBuscarNombre.setFont(new Font("Arial", Font.BOLD, 13));
        btnBuscarNombre.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
        btnBuscarNombre.setBackground(new Color(0, 0, 0, 0));
        btnBuscarNombre.setBounds(510, 200, 150, 28);
        contentPane.add(btnBuscarNombre);

        JButton btnMostrarInformacion = new JButton("Mostrar informacion");
        btnMostrarInformacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscar();
            }
        });
        btnMostrarInformacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnMostrarInformacion.setOpaque(false);
        btnMostrarInformacion.setForeground(Color.BLACK);
        btnMostrarInformacion.setFont(new Font("Arial", Font.BOLD, 13));
        btnMostrarInformacion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
        btnMostrarInformacion.setBackground(new Color(0, 0, 0, 0));
        btnMostrarInformacion.setBounds(240, 501, 159, 28);
        contentPane.add(btnMostrarInformacion);

        JButton btnInfoTipoDocumento = new JButton("");
        btnInfoTipoDocumento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnInfoTipoDocumento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masInfo("Tipo de documento", "Tipo de documento");
            }
        });
        btnInfoTipoDocumento.setIcon(new ImageIcon(MisReservas.class.getResource("/presentacion/img/icons/Informacion.png")));
        btnInfoTipoDocumento.setOpaque(false);
        btnInfoTipoDocumento.setForeground(Color.BLACK);
        btnInfoTipoDocumento.setFont(new Font("Arial", Font.BOLD, 13));
        btnInfoTipoDocumento.setBorderPainted(false);
        btnInfoTipoDocumento.setBackground(new Color(0, 0, 0, 0));
        btnInfoTipoDocumento.setBounds(195, 295, 32, 28);
        contentPane.add(btnInfoTipoDocumento);

        JButton btnInfoNumeroDocumento = new JButton("");
        btnInfoNumeroDocumento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masInfo("Numero de documento", "Numero de documento");
            }
        });
        btnInfoNumeroDocumento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnInfoNumeroDocumento.setIcon(new ImageIcon(MisReservas.class.getResource("/presentacion/img/icons/Informacion.png")));
        btnInfoNumeroDocumento.setOpaque(false);
        btnInfoNumeroDocumento.setForeground(Color.BLACK);
        btnInfoNumeroDocumento.setFont(new Font("Arial", Font.BOLD, 13));
        btnInfoNumeroDocumento.setBorderPainted(false);
        btnInfoNumeroDocumento.setBackground(new Color(0, 0, 0, 0));
        btnInfoNumeroDocumento.setBounds(400, 295, 32, 28);
        contentPane.add(btnInfoNumeroDocumento);

        JButton btnInfoHabitaciones = new JButton("");
        btnInfoHabitaciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masInfo("Habitaciones", "Habitaciones");
            }
        });
        btnInfoHabitaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnInfoHabitaciones.setBorderPainted(false);
        btnInfoHabitaciones.setOpaque(false);
        btnInfoHabitaciones.setIcon(new ImageIcon(MisReservas.class.getResource("/presentacion/img/icons/Informacion.png")));
        btnInfoHabitaciones.setForeground(Color.BLACK);
        btnInfoHabitaciones.setFont(new Font("Arial", Font.BOLD, 13));
        btnInfoHabitaciones.setBackground(new Color(0, 0, 0, 0));
        btnInfoHabitaciones.setBounds(600, 295, 32, 28);
        contentPane.add(btnInfoHabitaciones);

        JButton btnInfoNumeroPersonas = new JButton("");
        btnInfoNumeroPersonas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masInfo("Numero de personas", "Numero de personas");
            }
        });
        btnInfoNumeroPersonas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnInfoNumeroPersonas.setIcon(new ImageIcon(MisReservas.class.getResource("/presentacion/img/icons/Informacion.png")));
        btnInfoNumeroPersonas.setOpaque(false);
        btnInfoNumeroPersonas.setForeground(Color.BLACK);
        btnInfoNumeroPersonas.setFont(new Font("Arial", Font.BOLD, 13));
        btnInfoNumeroPersonas.setBorderPainted(false);
        btnInfoNumeroPersonas.setBackground(new Color(0, 0, 0, 0));
        btnInfoNumeroPersonas.setBounds(600, 335, 32, 28);
        contentPane.add(btnInfoNumeroPersonas);

        JButton btnInfoNumeroNoches = new JButton("");
        btnInfoNumeroNoches.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masInfo("Numero de noches", "Numero de noches");
            }
        });
        btnInfoNumeroNoches.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnInfoNumeroNoches.setIcon(new ImageIcon(MisReservas.class.getResource("/presentacion/img/icons/Informacion.png")));
        btnInfoNumeroNoches.setOpaque(false);
        btnInfoNumeroNoches.setForeground(Color.BLACK);
        btnInfoNumeroNoches.setFont(new Font("Arial", Font.BOLD, 13));
        btnInfoNumeroNoches.setBorderPainted(false);
        btnInfoNumeroNoches.setBackground(new Color(0, 0, 0, 0));
        btnInfoNumeroNoches.setBounds(200, 335, 32, 28);
        contentPane.add(btnInfoNumeroNoches);

        JButton btnInfoValor = new JButton("");
        btnInfoValor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masInfo("Valor", "Valor");
            }
        });
        btnInfoValor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnInfoValor.setIcon(new ImageIcon(MisReservas.class.getResource("/presentacion/img/icons/Informacion.png")));
        btnInfoValor.setOpaque(false);
        btnInfoValor.setForeground(Color.BLACK);
        btnInfoValor.setFont(new Font("Arial", Font.BOLD, 13));
        btnInfoValor.setBorderPainted(false);
        btnInfoValor.setBackground(new Color(0, 0, 0, 0));
        btnInfoValor.setBounds(400, 335, 32, 28);
        contentPane.add(btnInfoValor);

        JButton btnInfoDia = new JButton("");
        btnInfoDia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masInfo("Dia", "Dia");
            }
        });
        btnInfoDia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnInfoDia.setIcon(new ImageIcon(MisReservas.class.getResource("/presentacion/img/icons/Informacion.png")));
        btnInfoDia.setOpaque(false);
        btnInfoDia.setForeground(Color.BLACK);
        btnInfoDia.setFont(new Font("Arial", Font.BOLD, 13));
        btnInfoDia.setBorderPainted(false);
        btnInfoDia.setBackground(new Color(0, 0, 0, 0));
        btnInfoDia.setBounds(195, 426, 32, 28);
        contentPane.add(btnInfoDia);

        JButton btnInfoMes = new JButton("");
        btnInfoMes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masInfo("Mes", "Mes");
            }
        });
        btnInfoMes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnInfoMes.setIcon(new ImageIcon(MisReservas.class.getResource("/presentacion/img/icons/Informacion.png")));
        btnInfoMes.setOpaque(false);
        btnInfoMes.setForeground(Color.BLACK);
        btnInfoMes.setFont(new Font("Arial", Font.BOLD, 13));
        btnInfoMes.setBorderPainted(false);
        btnInfoMes.setBackground(new Color(0, 0, 0, 0));
        btnInfoMes.setBounds(395, 425, 32, 28);
        contentPane.add(btnInfoMes);

        JButton btnInfoAnio = new JButton("");
        btnInfoAnio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masInfo("A\u00F1o", "A\u00F1o");
            }
        });
        btnInfoAnio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnInfoAnio.setIcon(new ImageIcon(MisReservas.class.getResource("/presentacion/img/icons/Informacion.png")));
        btnInfoAnio.setOpaque(false);
        btnInfoAnio.setForeground(Color.BLACK);
        btnInfoAnio.setFont(new Font("Arial", Font.BOLD, 13));
        btnInfoAnio.setBorderPainted(false);
        btnInfoAnio.setBackground(new Color(0, 0, 0, 0));
        btnInfoAnio.setBounds(595, 425, 32, 28);
        contentPane.add(btnInfoAnio);

        JLabel lblEscribeUnaParte = new JLabel("Escribe una parte del nombre:");
        lblEscribeUnaParte.setHorizontalAlignment(SwingConstants.LEFT);
        lblEscribeUnaParte.setForeground(Color.BLACK);
        lblEscribeUnaParte.setFont(new Font("Arial", Font.BOLD, 20));
        lblEscribeUnaParte.setBounds(40, 213, 300, 20);
        contentPane.add(lblEscribeUnaParte);

        JLabel lblEligeTuReserva = new JLabel("Elige tu reserva:");
        lblEligeTuReserva.setHorizontalAlignment(SwingConstants.LEFT);
        lblEligeTuReserva.setForeground(Color.BLACK);
        lblEligeTuReserva.setFont(new Font("Arial", Font.BOLD, 20));
        lblEligeTuReserva.setBounds(10, 261, 300, 25);
        contentPane.add(lblEligeTuReserva);

        JLabel lblFechaDeReserva = new JLabel("Fecha de reserva:");
        lblFechaDeReserva.setHorizontalAlignment(SwingConstants.LEFT);
        lblFechaDeReserva.setForeground(Color.BLACK);
        lblFechaDeReserva.setFont(new Font("Arial", Font.BOLD, 20));
        lblFechaDeReserva.setBounds(40, 390, 300, 20);
        contentPane.add(lblFechaDeReserva);

        //////////////////////////////////////////////////////////
        JLabel lblTitulo = new JLabel("Tu reserva");
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
            OpcionesAdmin.getInstancia().hacerVisible();
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

    // Metodo delos botones que brindan informacion
    public void masInfo(String contenido, String titulo) {
        JOptionPane.showMessageDialog(null, contenido, titulo, 1);
    }

    public static ConsultarReserva getInstancia() throws Exception {
        if (instancia != null) {
            return instancia;
        }
        return new ConsultarReserva();
    }

    public void cargarNombres() {
        try {
            if (!txtNombre.getText().equals("Nombre") && !txtNombre.getText().equals("")) {
                String[] coincidencias = app.buscarNombres(txtNombre.getText());
                if (coincidencias != null) {
                    hacerVisible();
                    comboBoxCoincidencias.setModel(
                            new DefaultComboBoxModel(coincidencias));
                    JOptionPane.showMessageDialog(null, "Coincidencias cargadas", ":D", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Inserta un nombre o un fragmento", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void hacerVisible() {
        comboBoxSeleccionarReserva.setModel(new DefaultComboBoxModel(new String[]{"No tiene reservas"}));
        comboBoxCoincidencias.setModel(new DefaultComboBoxModel(new String[]{"Coincidencias"}));
        txtNombre.setText("Nombre");
        txtTipoDocumento.setText("Tipo de documento");
        txtNumeroDocumento.setText("N\u00B0 de documento");
        txtNumeroNoches.setText("N\u00B0 de noches");
        txtValor.setText("Valor");
        txtNumeroPersonas.setText("N\u00B0 de personas");
        txtDia.setText("Dia");
        txtMes.setText("Mes");
        txtAnio.setText("A\u00F1o");

        setVisible(true);
        toFront();
    }

    public void cargarReservas() throws Exception {
        if (!comboBoxCoincidencias.getSelectedItem().equals("Coincidencias")) {
            Persona persona = app.obtenerPersona((String) comboBoxCoincidencias.getSelectedItem());
            if (app.buscarReservas(persona.getK_numeroDocumento(), persona.getK_tipoDocumento()) != null) {
                comboBoxSeleccionarReserva.setModel(
                        new DefaultComboBoxModel(app.buscarReservas(persona.getK_numeroDocumento(), persona.getK_tipoDocumento())));
            } else {
                comboBoxSeleccionarReserva.setModel(
                        new DefaultComboBoxModel(new String[]{"No tiene reservas"}));
            }
            txtTipoDocumento.setText("Tipo de documento");
            txtNumeroDocumento.setText("N\u00B0 de documento");
            txtHabitaciones.setText("N\u00B0 de habitación");
            txtNumeroPersonas.setText("N\u00B0 de personas");
            txtNumeroNoches.setText("N\u00B0 de noches");
            txtValor.setText("Valor");

            txtDia.setText("Dia");
            txtMes.setText("Mes");
            txtAnio.setText("Año");

        } else {
            JOptionPane.showMessageDialog(null, "Primero escoge un usuario que tenga reserva", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscar() {
        try {
            if (comboBoxSeleccionarReserva.getSelectedItem() != "No tiene reservas") {
                Reserva reserva = app.getReserva(Integer.parseInt(comboBoxSeleccionarReserva.getSelectedItem().toString()));

                txtTipoDocumento.setText(reserva.getK_tipoDocumento());
                txtNumeroDocumento.setText(String.valueOf(reserva.getK_numeroDocumento()));
                txtHabitaciones.setText(String.valueOf(reserva.getK_numeroHabitacion()));
                txtNumeroPersonas.setText(String.valueOf(reserva.getQ_numeroPersonas()));
                txtNumeroNoches.setText(String.valueOf(reserva.getQ_nochesReservadas()));
                txtValor.setText("$" + String.valueOf(reserva.getV_precioEstadia()));

                String string = String.valueOf(reserva.getF_inicio());
                String[] parts = string.split("-");

                txtDia.setText(parts[0]);
                txtMes.setText(parts[1]);
                txtAnio.setText(parts[2]);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
