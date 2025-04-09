package presentacion.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
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
import negocio.Aplicacion;

public class RealizarRegistro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtTelefono;
    private JTextField txtNumeroDocumento;
    private JComboBox<Object> comboBoxTipoDocumento;
    private JTextField txtAnio;
    private JComboBox<Object> comboBoxDia;
    private JComboBox<Object> comboBoxMes;
    private JTextField txtDireccion;
    private Aplicacion app;
    private static RealizarRegistro instancia;

    @SuppressWarnings({"rawtypes", "unchecked"})
    private RealizarRegistro() {
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

        // Boton para cerrar el programa
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

        // Boton para cerrar el frame
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

        /////////////////////////////////////////////
        comboBoxTipoDocumento = new JComboBox<Object>();
        comboBoxTipoDocumento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBoxTipoDocumento.setModel(
                new DefaultComboBoxModel(new String[]{"Tipo de documento", "CC", "CE", "TI", "TE", "NIT"}));
        comboBoxTipoDocumento.setToolTipText("");
        comboBoxTipoDocumento.setFont(new Font("Arial", Font.PLAIN, 17));
        comboBoxTipoDocumento.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        comboBoxTipoDocumento.setBackground(new Color(217, 209, 233));
        comboBoxTipoDocumento.setBounds(120, 220, 180, 25);
        contentPane.add(comboBoxTipoDocumento);

        txtNumeroDocumento = new JTextField();
        txtNumeroDocumento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtNumeroDocumento.getText().toString().equals("N\u00FAmero de documento")) {
                    txtNumeroDocumento.setText("");
                }
            }
        });
        txtNumeroDocumento.setText("N\u00FAmero de documento");
        txtNumeroDocumento.setOpaque(false);
        txtNumeroDocumento.setForeground(Color.BLACK);
        txtNumeroDocumento.setFont(new Font("Arial", Font.PLAIN, 17));
        txtNumeroDocumento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtNumeroDocumento.setBounds(390, 220, 180, 20);
        contentPane.add(txtNumeroDocumento);

        txtDireccion = new JTextField();
        txtDireccion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtDireccion.getText().toString().equals("Direcci\u00F3n")) {
                    txtDireccion.setText("");
                }
            }
        });
        txtDireccion.setText("Direcci\u00F3n");
        txtDireccion.setOpaque(false);
        txtDireccion.setForeground(Color.BLACK);
        txtDireccion.setFont(new Font("Arial", Font.PLAIN, 17));
        txtDireccion.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtDireccion.setBounds(120, 280, 180, 20);
        contentPane.add(txtDireccion);

        txtTelefono = new JTextField();
        txtTelefono.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtTelefono.getText().toString().equals("Tel\u00E9fono")) {
                    txtTelefono.setText("");
                }
            }
        });
        txtTelefono.setText("Tel\u00E9fono");
        txtTelefono.setOpaque(false);
        txtTelefono.setForeground(Color.BLACK);
        txtTelefono.setFont(new Font("Arial", Font.PLAIN, 17));
        txtTelefono.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtTelefono.setBounds(390, 280, 180, 20);
        contentPane.add(txtTelefono);

        comboBoxDia = new JComboBox<Object>();
        comboBoxDia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBoxDia.setModel(new DefaultComboBoxModel(new String[]{"Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09",
            "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
            "27", "28", "29", "30", "31"}));
        comboBoxDia.setToolTipText("");
        comboBoxDia.setFont(new Font("Arial", Font.PLAIN, 17));
        comboBoxDia.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        comboBoxDia.setBackground(new Color(217, 209, 233));
        comboBoxDia.setBounds(120, 360, 180, 25);
        contentPane.add(comboBoxDia);

        comboBoxMes = new JComboBox<>();
        comboBoxMes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBoxMes.setModel(new DefaultComboBoxModel(new String[]{"Mes", "01", "02", "03", "04",
            "05", "06", "07", "08", "09", "10", "11", "12"}));
        comboBoxMes.setToolTipText("");
        comboBoxMes.setFont(new Font("Arial", Font.PLAIN, 17));
        comboBoxMes.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        comboBoxMes.setBackground(new Color(217, 209, 233));
        comboBoxMes.setBounds(120, 410, 180, 25);
        contentPane.add(comboBoxMes);

        txtAnio = new JTextField();
        txtAnio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtAnio.getText().toString().equals("A\u00F1o")) {
                    txtAnio.setText("");
                }
            }
        });
        txtAnio.setText("A\u00F1o");
        txtAnio.setOpaque(false);
        txtAnio.setForeground(Color.BLACK);
        txtAnio.setFont(new Font("Arial", Font.PLAIN, 17));
        txtAnio.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtAnio.setBounds(380, 360, 180, 20);
        contentPane.add(txtAnio);

        // Boton para confirmar registro
        JButton btnRegistrarEntrada = new JButton("Registrar entrada");
        btnRegistrarEntrada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegistrarEntrada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String btns[] = {"Confirmar", "Cancelar"};

                int option = JOptionPane.showOptionDialog(null, "Realizar Check-in ?", "Check-in", 0, 3, null, btns, this);

                if (option == JOptionPane.YES_OPTION) {
                    try {
                        addHuesped();
                    } catch (Exception ex) {
                        Logger.getLogger(RealizarRegistro.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                OpcionesAdmin.getInstancia().setVisible(true);
                OpcionesAdmin.getInstancia().toFront();
            }
        });

        btnRegistrarEntrada.setOpaque(false);
        btnRegistrarEntrada.setForeground(Color.BLACK);
        btnRegistrarEntrada.setFont(new Font("Arial", Font.BOLD, 13));
        btnRegistrarEntrada.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
        btnRegistrarEntrada.setBackground(new Color(0, 0, 0, 0));
        btnRegistrarEntrada.setBounds(122, 481, 180, 28);
        contentPane.add(btnRegistrarEntrada);

        JButton btnRegistrarSalida = new JButton("Registrar salida");
        btnRegistrarEntrada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegistrarSalida.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                try {
                    checkOut();
                } catch (Exception ex) {
                    Logger.getLogger(RealizarRegistro.class.getName()).log(Level.SEVERE, null, ex);
                }

                setVisible(false);
                OpcionesAdmin.getInstancia().hacerVisible();
            }
        });
        btnRegistrarSalida.setOpaque(false);
        btnRegistrarSalida.setForeground(Color.BLACK);
        btnRegistrarSalida.setFont(new Font("Arial", Font.BOLD, 13));
        btnRegistrarSalida.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
        btnRegistrarSalida.setBackground(new Color(0, 0, 0, 0));
        btnRegistrarSalida.setBounds(380, 480, 180, 28);
        contentPane.add(btnRegistrarSalida);

        JLabel lblFechaDeReserva = new JLabel("Fecha de nacimiento:");
        lblFechaDeReserva.setHorizontalAlignment(SwingConstants.LEFT);
        lblFechaDeReserva.setForeground(Color.BLACK);
        lblFechaDeReserva.setFont(new Font("Arial", Font.BOLD, 20));
        lblFechaDeReserva.setBounds(120, 320, 300, 20);
        contentPane.add(lblFechaDeReserva);

        ////////////////////////////////////////////
        JLabel lblTitulo = new JLabel("Realizar registro");
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
        int eleccion = JOptionPane.showOptionDialog(this, "\u00bfDeseas regresar a la anterior ventana?", "Regresar", 0,
                0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            setVisible(false);
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

    // Metodo para anhadir un huesped:
    public void addHuesped() throws Exception {
        
        LocalDate currentDate = LocalDate.now();

        try {

            String k_tipoDocumento = (String) comboBoxTipoDocumento.getSelectedItem();
            Long k_numeroDocumento = Long.parseLong(txtNumeroDocumento.getText());
            String o_direccion = txtDireccion.getText();
            int o_telefono = Integer.parseInt(txtTelefono.getText().trim());
            String stringFechaNacimiento = txtAnio.getText() + '-' + (String) comboBoxMes.getSelectedItem() + '-' + (String) comboBoxDia.getSelectedItem();
            LocalDate f_nacimientoParsed = LocalDate.parse(stringFechaNacimiento);
            String f_nacimiento = f_nacimientoParsed.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            int dateComparison = f_nacimiento.compareTo(currentDate.toString());
            
            if(dateComparison >= 0) {
                JOptionPane.showMessageDialog(null, "No ha nacido pa...pero bueno.", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            if (app.getPersona(k_numeroDocumento, k_tipoDocumento) != null) {
                app.agregarHuesped(o_direccion, o_telefono, f_nacimiento, k_tipoDocumento, k_numeroDocumento);
                JOptionPane.showMessageDialog(null, "Check-In realizado", "Information", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                OpcionesAdmin.getInstancia().hacerVisible();
            } else {
                JOptionPane.showMessageDialog(null, "La persona no existe");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input format: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    // Metodo del boton "registrar salida" para el check-out.
    public void checkOut() throws Exception {

        Long k_numeroDocumento = Long.parseLong(txtNumeroDocumento.getText());
        String k_tipoDocumento = (String) comboBoxTipoDocumento.getSelectedItem();

        String[] result = app.buscarReservas(k_numeroDocumento, k_tipoDocumento);
        String value = result[0];
        int pendingReservation = Integer.parseInt(value);

        app.cambiarEstadoReserva(pendingReservation, "paga");
        JOptionPane.showMessageDialog(null, "Check-Out realizado", "Information", JOptionPane.INFORMATION_MESSAGE);

    }

    // Metodo del boton confirmar para realizar la reserva
    public void confirmarReserva() {
        String botones[] = {"Cancelar", "Confirmar"};
        int eleccion = JOptionPane.showOptionDialog(this,
                "\u00bfDeseas realizar la reserva?\nPara el numero de personas que elegiste,"
                + "\nTe corresponden las habitaciones 101 y 102" + "\n El descuento aplicado es del 100%"
                + "\n\nPor un valor de $100.000",
                "\u00bfConfirmar reserva?", 0, 3, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {

        }

    }

    public static RealizarRegistro getInstancia() {
        if (instancia != null) {
            return instancia;
        }

        return new RealizarRegistro();
    }

    public void hacerVisible() {
        comboBoxTipoDocumento.setSelectedIndex(0);
        txtNumeroDocumento.setText("N\u00FAmero de documento");
        txtDireccion.setText("Direcci\u00F3n");
        txtTelefono.setText("Tel\u00E9fono");
        comboBoxDia.setSelectedIndex(0);
        comboBoxMes.setSelectedIndex(0);
        txtAnio.setText("A\u00F1o");

        setVisible(true);
        toFront();
    }
}
