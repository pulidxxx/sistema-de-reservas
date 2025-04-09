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
import negocio.Persona;

public class Registrarse extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNombre1;
    private JTextField txtApellido2;
    private JComboBox<Object> comboBoxTipoDocumento;
    private JTextField textNombre2;
    private JTextField txtApellido1;
    private JTextField txtNumeroDocumento;
    private static Registrarse instancia;
    private Aplicacion app;

    @SuppressWarnings({"unchecked", "rawtypes"})
    private Registrarse() {
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

        ///////////////////////////////////////////////////////////////
        // Text fields y comboBox para editar la informacion
        comboBoxTipoDocumento = new JComboBox<Object>();
        comboBoxTipoDocumento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBoxTipoDocumento.setModel(
                new DefaultComboBoxModel(new String[]{"Tipo de documento", "CC", "CE", "TI", "TE", "NIT"}));
        comboBoxTipoDocumento.setToolTipText("");
        comboBoxTipoDocumento.setFont(new Font("Arial", Font.PLAIN, 17));
        comboBoxTipoDocumento.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        comboBoxTipoDocumento.setBackground(new Color(217, 209, 233));
        comboBoxTipoDocumento.setBounds(100, 260, 180, 25);
        contentPane.add(comboBoxTipoDocumento);

        txtNumeroDocumento = new JTextField();
        txtNumeroDocumento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtNumeroDocumento.getText().toString().equals("N\u00B0 de documento")) {
                    txtNumeroDocumento.setText("");
                }
            }
        });
        txtNumeroDocumento.setText("N\u00B0 de documento");
        txtNumeroDocumento.setOpaque(false);
        txtNumeroDocumento.setForeground(Color.BLACK);
        txtNumeroDocumento.setFont(new Font("Arial", Font.PLAIN, 17));
        txtNumeroDocumento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtNumeroDocumento.setBounds(380, 260, 180, 20);
        contentPane.add(txtNumeroDocumento);

        txtNombre1 = new JTextField();
        txtNombre1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtNombre1.getText().toString().equals("Primer nombre")) {
                    txtNombre1.setText("");
                }
            }
        });
        txtNombre1.setText("Primer nombre");
        txtNombre1.setOpaque(false);
        txtNombre1.setForeground(Color.BLACK);
        txtNombre1.setFont(new Font("Arial", Font.PLAIN, 17));
        txtNombre1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtNombre1.setBounds(100, 308, 180, 20);
        contentPane.add(txtNombre1);

        textNombre2 = new JTextField();
        textNombre2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (textNombre2.getText().toString().equals("Segundo nombre")) {
                    textNombre2.setText("");
                }
            }
        });
        textNombre2.setText("Segundo nombre");
        textNombre2.setOpaque(false);
        textNombre2.setForeground(Color.BLACK);
        textNombre2.setFont(new Font("Arial", Font.PLAIN, 17));
        textNombre2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        textNombre2.setBounds(380, 308, 180, 20);
        contentPane.add(textNombre2);

        txtApellido1 = new JTextField();
        txtApellido1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtApellido1.getText().toString().equals("Primer apellido")) {
                    txtApellido1.setText("");
                }
            }
        });
        txtApellido1.setText("Primer apellido");
        txtApellido1.setOpaque(false);
        txtApellido1.setForeground(Color.BLACK);
        txtApellido1.setFont(new Font("Arial", Font.PLAIN, 17));
        txtApellido1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtApellido1.setBounds(100, 350, 180, 20);
        contentPane.add(txtApellido1);

        txtApellido2 = new JTextField();
        txtApellido2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtApellido2.getText().toString().equals("Segundo apellido")) {
                    txtApellido2.setText("");
                }
            }
        });
        txtApellido2.setText("Segundo apellido");
        txtApellido2.setOpaque(false);
        txtApellido2.setForeground(Color.BLACK);
        txtApellido2.setFont(new Font("Arial", Font.PLAIN, 17));
        txtApellido2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtApellido2.setBounds(380, 350, 180, 20);
        contentPane.add(txtApellido2);

        // Boton para guardar cambios
        JButton btnRegsitrarse = new JButton("Registrarse");
        btnRegsitrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegsitrarse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    validarRegistro();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnRegsitrarse.setOpaque(false);
        btnRegsitrarse.setForeground(Color.BLACK);
        btnRegsitrarse.setFont(new Font("Arial", Font.BOLD, 13));
        btnRegsitrarse.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
        btnRegsitrarse.setBackground(new Color(0, 0, 0, 0));
        btnRegsitrarse.setBounds(230, 442, 180, 28);
        contentPane.add(btnRegsitrarse);

        ////////////////////////////////////////////
        JLabel lblTitulo = new JLabel("Registrarse");
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

    public static Registrarse getInstancia() {
        if (instancia != null) {
            return instancia;
        }

        return new Registrarse();
    }

    public void validarRegistro() throws Exception {
        String nombre2, apellido2;
        
        if(((String) comboBoxTipoDocumento.getSelectedItem()).equals("Tipo de documento"))
            throw new Exception("Selecciona un tipo de documento");
        
        if(txtNumeroDocumento.getText().equals("N\u00B0 de documento"))
            throw new Exception("Digita tu N\u00B0 de documento");
        
        Persona persona = app.getPersona(Long.parseLong(txtNumeroDocumento.getText()), (String) comboBoxTipoDocumento.getSelectedItem());
        if(persona != null) throw new Exception("El usuario ya existe");
        
        if (txtNombre1.getText().equals("") || txtNombre1.getText().equals("Primer nombre")
            || txtApellido1.getText().equals("") || txtApellido1.getText().equals("Primer apellido"))
            throw new Exception("Digita tu primer nombre y apellido");
        
        nombre2 = ("Segundo nombre".equals(textNombre2.getText()) || "".equals(textNombre2.getText())) ? null : textNombre2.getText();
        apellido2 = ("Segundo apellido".equals(txtApellido2.getText()) || "".equals(txtApellido2)) ? null : textNombre2.getText();
        
        app.agregarPersona((String) comboBoxTipoDocumento.getSelectedItem(), Long.parseLong(txtNumeroDocumento.getText()), 
                txtNombre1.getText(), nombre2, txtApellido1.getText(), apellido2);
        
        JOptionPane.showMessageDialog(null, "Usuario creado exitosamente", "Usuario creado", JOptionPane.INFORMATION_MESSAGE);
        
        setVisible(false);
        Login.getInstancia().hacerVisible();
    }
    
    public void hacerVisible() {
        comboBoxTipoDocumento.setSelectedIndex(0);
        txtNombre1.setText("Primer nombre");
        textNombre2.setText("Segundo nombre");
        txtApellido1.setText("Primer apellido");
        txtApellido2.setText("Segundo apellido");
        txtNumeroDocumento.setText("N\u00B0 de documento");
        
        setVisible(true);
        toFront();
    }

}
