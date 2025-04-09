package presentacion.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
import negocio.Habitacion;
import negocio.Hotel;
import static presentacion.vista.Login.documento;
import static presentacion.vista.Login.tipoDocumento;

public class RealizarReserva extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNumeroPersonas;
    private JTextField txtNumeroNoches;
    private JTextField txtAnioReserva;
    private JComboBox<Object> comboBoxMesReserva;
    private JComboBox<Object> comboBoxDiaReserva;
    private JComboBox<Object> comboBoxTipoHabitacion;
    private Aplicacion app;
    private static RealizarReserva instancia;

    @SuppressWarnings({"rawtypes", "unchecked"})
    private RealizarReserva() {
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

        comboBoxTipoHabitacion = new JComboBox<Object>();
        comboBoxTipoHabitacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBoxTipoHabitacion.setModel(
                new DefaultComboBoxModel(new String[]{"Tipo de habitaci\u00F3n ", "Simple", "Doble", "Triple"}));
        comboBoxTipoHabitacion.setToolTipText("");
        comboBoxTipoHabitacion.setFont(new Font("Arial", Font.PLAIN, 17));
        comboBoxTipoHabitacion.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        comboBoxTipoHabitacion.setBackground(new Color(217, 209, 233));
        comboBoxTipoHabitacion.setBounds(120, 230, 180, 25);
        contentPane.add(comboBoxTipoHabitacion);

        txtNumeroNoches = new JTextField();
        txtNumeroNoches.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtNumeroNoches.getText().toString().equals("N\u00FAmero de noches")) {
                    txtNumeroNoches.setText("");
                }
            }
        });
        txtNumeroNoches.setText("N\u00FAmero de noches");
        txtNumeroNoches.setOpaque(false);
        txtNumeroNoches.setForeground(Color.BLACK);
        txtNumeroNoches.setFont(new Font("Arial", Font.PLAIN, 17));
        txtNumeroNoches.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtNumeroNoches.setBounds(380, 230, 180, 20);
        contentPane.add(txtNumeroNoches);

        txtNumeroPersonas = new JTextField();
        txtNumeroPersonas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtNumeroPersonas.getText().toString().equals("N\u00FAmero de personas")) {
                    txtNumeroPersonas.setText("");
                }
            }
        });
        txtNumeroPersonas.setText("N\u00FAmero de personas");
        txtNumeroPersonas.setOpaque(false);
        txtNumeroPersonas.setForeground(Color.BLACK);
        txtNumeroPersonas.setFont(new Font("Arial", Font.PLAIN, 17));
        txtNumeroPersonas.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtNumeroPersonas.setBounds(120, 280, 180, 20);
        contentPane.add(txtNumeroPersonas);

        comboBoxDiaReserva = new JComboBox<Object>();
        comboBoxDiaReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBoxDiaReserva.setModel(new DefaultComboBoxModel(new String[]{"Dia", "01", "02", "03", "04", "05", "06", "07",
            "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
            "25", "26", "27", "28", "29", "30", "31"}));
        comboBoxDiaReserva.setToolTipText("");
        comboBoxDiaReserva.setFont(new Font("Arial", Font.PLAIN, 17));
        comboBoxDiaReserva.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        comboBoxDiaReserva.setBackground(new Color(217, 209, 233));
        comboBoxDiaReserva.setBounds(120, 360, 180, 25);
        contentPane.add(comboBoxDiaReserva);

        comboBoxMesReserva = new JComboBox<Object>();
        comboBoxMesReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBoxMesReserva.setModel(new DefaultComboBoxModel(new String[]{"Mes", "01", "02", "03", "04",
            "05", "06", "07", "08", "09", "10", "11", "12"}));
        comboBoxMesReserva.setToolTipText("");
        comboBoxMesReserva.setFont(new Font("Arial", Font.PLAIN, 17));
        comboBoxMesReserva.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        comboBoxMesReserva.setBackground(new Color(217, 209, 233));
        comboBoxMesReserva.setBounds(120, 410, 180, 25);
        contentPane.add(comboBoxMesReserva);

        txtAnioReserva = new JTextField();
        txtAnioReserva.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtAnioReserva.getText().toString().equals("A\u00F1o")) {
                    txtAnioReserva.setText("");
                }
            }
        });
        txtAnioReserva.setText("A\u00F1o");
        txtAnioReserva.setOpaque(false);
        txtAnioReserva.setForeground(Color.BLACK);
        txtAnioReserva.setFont(new Font("Arial", Font.PLAIN, 17));
        txtAnioReserva.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtAnioReserva.setBounds(380, 360, 180, 20);
        contentPane.add(txtAnioReserva);

        // Boton para confirmar reserva
        JButton btnConfirmarReserva = new JButton("Confirmar reserva");
        btnConfirmarReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConfirmarReserva.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                confirmarReserva();
            }
        });
        btnConfirmarReserva.setOpaque(false);
        btnConfirmarReserva.setForeground(Color.BLACK);
        btnConfirmarReserva.setFont(new Font("Arial", Font.BOLD, 13));
        btnConfirmarReserva.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
        btnConfirmarReserva.setBackground(new Color(0, 0, 0, 0));
        btnConfirmarReserva.setBounds(239, 486, 180, 28);
        contentPane.add(btnConfirmarReserva);

        JLabel lblFechaDeReserva = new JLabel("Fecha de reseva:");
        lblFechaDeReserva.setHorizontalAlignment(SwingConstants.LEFT);
        lblFechaDeReserva.setForeground(Color.BLACK);
        lblFechaDeReserva.setFont(new Font("Arial", Font.BOLD, 20));
        lblFechaDeReserva.setBounds(120, 325, 300, 20);
        contentPane.add(lblFechaDeReserva);

        ////////////////////////////////////////////
        JLabel lblTitulo = new JLabel("Realizar reserva");
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
            OpcionesUsuario.getInstancia().hacerVisible();
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

    // Metodo del boton confirmar para realizar la reserva
    public void confirmarReserva() {
        String botones[] = {"Confirmar", "Cancelar"};
        Habitacion habitacion;
        Hotel hotel;
        String f_inicio, f_fin;

        try {
            f_inicio = txtAnioReserva.getText() + "-" + (String) comboBoxMesReserva.getSelectedItem() + "-" + (String) comboBoxDiaReserva.getSelectedItem();
            LocalDate fechaFinal = LocalDate.parse(f_inicio).plusDays(Integer.parseInt(txtNumeroNoches.getText()));
            f_fin = fechaFinal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Obtener una habitación disponible para esa fecha
            habitacion = app.getHabitacionDisponible(((String) comboBoxTipoHabitacion.getSelectedItem()).substring(0, 1), f_inicio, f_fin);
            if (habitacion == null) {
                throw new Exception("No se encontarron habitaciones disponibles para la fecha especificada.");
            }

            // Obtener el hotel en cuestión
            hotel = app.getHotel(habitacion.getK_hotel());
            if (hotel == null) {
                throw new Exception("No se encontarro el hotel asociado a la habitación.");
            }

            int descuento = Integer.parseInt(txtNumeroNoches.getText()) >= hotel.getQ_diasDescuento() ? hotel.getT_descuento() : 0;
            double costo = Integer.parseInt(txtNumeroNoches.getText()) * app.getTipo(habitacion.getK_tipo()).getV_precioNoche();

            if (habitacion.getK_tipo().equals("S") && Integer.parseInt(txtNumeroPersonas.getText()) > 3) {
                throw new Exception("Para una habitación simple, se permite un máximo de 3 personas.");
            }

            if (habitacion.getK_tipo().equals("D") && Integer.parseInt(txtNumeroPersonas.getText()) > 7) {
                throw new Exception("Para una habitación doble, se permite un máximo de 7 personas.");
            }

            if (habitacion.getK_tipo().equals("T") && Integer.parseInt(txtNumeroPersonas.getText()) > 11) {
                throw new Exception("Para una habitación triple, se permite un máximo de 11 personas.");
            }

            if (new SimpleDateFormat("yyyy-MM-dd").parse(f_inicio).before(new Date())) {
                throw new Exception("Solo puedes hacer reservas para fechas mayores a la actual");
            }

            if (app.getTotalPersonas(f_inicio, f_fin) + Integer.parseInt(txtNumeroPersonas.getText()) > hotel.getQ_apacidad() * hotel.getT_aforo() / 100) {
                throw new Exception("Lo sentimos, para la fecha que especificaste, se supera el aforo máximo de personas.");
            }

            int eleccion = JOptionPane.showOptionDialog(this,
                    "\u00bfDeseas realizar la reserva?\n"
                    + "\nHabitación: " + habitacion.getK_numeroHabitacion() + "\nTaza de descuento aplicada: " + descuento + "%"
                    + "\nCosto: $" + costo
                    + "\nDescuento aplicado: $" + costo * descuento / 100
                    + "\n\nCosto final: $" + (costo - costo * descuento / 100) + "\n",
                    "\u00bfConfirmar reserva?", 0, 3, null, botones, this);

            if (eleccion == JOptionPane.YES_OPTION) {
                app.agregarReserva(f_inicio, f_fin, Integer.parseInt(txtNumeroNoches.getText()),
                        Integer.parseInt(txtNumeroPersonas.getText()), (costo - costo * descuento / 100),
                        habitacion.getK_numeroHabitacion(), tipoDocumento, documento);

                JOptionPane.showMessageDialog(null, "La reserva se realizó satisfactoriamente", "Reserva confirmada", JOptionPane.INFORMATION_MESSAGE);
                txtNumeroPersonas.setText("N\u00FAmero de personas");
                txtNumeroNoches.setText("N\u00FAmero de noches");
                txtAnioReserva.setText("A\u00F1o");
                comboBoxMesReserva.setSelectedIndex(0);
                comboBoxDiaReserva.setSelectedIndex(0);
                comboBoxTipoHabitacion.setSelectedIndex(0);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static RealizarReserva getInstancia() {
        if (instancia != null) {
            return instancia;
        }

        return new RealizarReserva();
    }
    
    public void hacerVisible() {
        comboBoxTipoHabitacion.setSelectedIndex(0);
        txtNumeroNoches.setText("N\u00FAmero de noches");
        txtNumeroPersonas.setText("N\u00FAmero de personas");
        comboBoxDiaReserva.setSelectedIndex(0);
        comboBoxMesReserva.setSelectedIndex(0);
        txtAnioReserva.setText("A\u00F1o");
        
        setVisible(true);
        toFront();
    }
}
