package presentacion.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import negocio.Aplicacion;
import negocio.Hotel;

public class Configuraciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDiasDescuento;
	private JTextField txtDescuento;
        private JTextField txtAforo;
        private JTextField txtCapacidad;
        private static Configuraciones instancia;
        private Aplicacion app;

	private Configuraciones() {
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

		////////////////////////////////////////////////////////////////

		txtDescuento = new JTextField();
		txtDescuento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDescuento.setText("");
			}
		});
		txtDescuento.setText("Porcentaje de descuento");
		txtDescuento.setOpaque(false);
		txtDescuento.setForeground(Color.BLACK);
		txtDescuento.setFont(new Font("Arial", Font.PLAIN, 17));
		txtDescuento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDescuento.setBounds(80, 280, 220, 20);
		contentPane.add(txtDescuento);
                
                JButton btnInfoDescuento = new JButton("");
                btnInfoDescuento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnInfoDescuento.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        masInfo("Porcentaje de descuento", "Porcentaje de descuento");
                    }
                });
                btnInfoDescuento.setIcon(new ImageIcon(MisReservas.class.getResource("/presentacion/img/icons/Informacion.png")));
                btnInfoDescuento.setOpaque(false);
                btnInfoDescuento.setForeground(Color.BLACK);
                btnInfoDescuento.setFont(new Font("Arial", Font.BOLD, 13));
                btnInfoDescuento.setBorderPainted(false);
                btnInfoDescuento.setBackground(new Color(0, 0, 0, 0));
                btnInfoDescuento.setBounds(310, 280, 32, 28);
                contentPane.add(btnInfoDescuento);

		txtAforo = new JTextField();
		txtAforo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAforo.setText("");
			}
		});
		txtAforo.setText("% de m\u00E1ximo aforo");
		txtAforo.setOpaque(false);
		txtAforo.setForeground(Color.BLACK);
		txtAforo.setFont(new Font("Arial", Font.PLAIN, 17));
		txtAforo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtAforo.setBounds(390, 280, 220, 20);
		contentPane.add(txtAforo);
                
                JButton btnInfoAforo = new JButton("");
                btnInfoAforo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnInfoAforo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        masInfo("Porcentaje de aforo", "Porcentaje de aforo");
                    }
                });
                btnInfoAforo.setIcon(new ImageIcon(MisReservas.class.getResource("/presentacion/img/icons/Informacion.png")));
                btnInfoAforo.setOpaque(false);
                btnInfoAforo.setForeground(Color.BLACK);
                btnInfoAforo.setFont(new Font("Arial", Font.BOLD, 13));
                btnInfoAforo.setBorderPainted(false);
                btnInfoAforo.setBackground(new Color(0, 0, 0, 0));
                btnInfoAforo.setBounds(620, 280, 32, 28);
                contentPane.add(btnInfoAforo);

		txtDiasDescuento = new JTextField();
		txtDiasDescuento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDiasDescuento.setText("");
			}
		});
		txtDiasDescuento.setText("M\u00EDnimo de dias para el descuento");
		txtDiasDescuento.setOpaque(false);
		txtDiasDescuento.setForeground(Color.BLACK);
		txtDiasDescuento.setFont(new Font("Arial", Font.PLAIN, 17));
		txtDiasDescuento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDiasDescuento.setBounds(80, 350, 220, 20);
		contentPane.add(txtDiasDescuento);
                
                JButton btnInfoMinDescuento = new JButton("");
                btnInfoMinDescuento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnInfoMinDescuento.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        masInfo("M\u00EDnimo de dias para el descuento", "M\u00EDnimo de dias para el descuento");
                    }
                });
                btnInfoMinDescuento.setIcon(new ImageIcon(MisReservas.class.getResource("/presentacion/img/icons/Informacion.png")));
                btnInfoMinDescuento.setOpaque(false);
                btnInfoMinDescuento.setForeground(Color.BLACK);
                btnInfoMinDescuento.setFont(new Font("Arial", Font.BOLD, 13));
                btnInfoMinDescuento.setBorderPainted(false);
                btnInfoMinDescuento.setBackground(new Color(0, 0, 0, 0));
                btnInfoMinDescuento.setBounds(310, 350, 32, 28);
                contentPane.add(btnInfoMinDescuento);

		btnCerrar.setOpaque(false);
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(new Color(0, 0, 51));
		btnCerrar.setBounds(10, 11, 39, 23);
		contentPane.add(btnCerrar);
                
                txtCapacidad = new JTextField();
		txtCapacidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCapacidad.setText("");
			}
		});
		txtCapacidad.setText("Capacidad");
		txtCapacidad.setOpaque(false);
		txtCapacidad.setForeground(Color.BLACK);
		txtCapacidad.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCapacidad.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtCapacidad.setBounds(390, 350, 220, 20);
		contentPane.add(txtCapacidad);
                
                JButton btnInfoCapacidad = new JButton("");
                btnInfoCapacidad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnInfoCapacidad.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        masInfo("Capacidad del hotel", "Capacidad del hotel");
                    }
                });
                btnInfoCapacidad.setIcon(new ImageIcon(MisReservas.class.getResource("/presentacion/img/icons/Informacion.png")));
                btnInfoCapacidad.setOpaque(false);
                btnInfoCapacidad.setForeground(Color.BLACK);
                btnInfoCapacidad.setFont(new Font("Arial", Font.BOLD, 13));
                btnInfoCapacidad.setBorderPainted(false);
                btnInfoCapacidad.setBackground(new Color(0, 0, 0, 0));
                btnInfoCapacidad.setBounds(620, 350, 32, 28);
                contentPane.add(btnInfoCapacidad);

		// Boton para registrarse
		JButton btnAplicarCambios = new JButton("Aplicar cambios");
		btnAplicarCambios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAplicarCambios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            try {
                                 actualizarHotel();
                                 JOptionPane.showMessageDialog(null, "Datos actualizados correctamente", "Reserva confirmada", JOptionPane.INFORMATION_MESSAGE);
                                 hacerVisible();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
			}
		});
		btnAplicarCambios.setOpaque(false);
		btnAplicarCambios.setForeground(Color.BLACK);
		btnAplicarCambios.setFont(new Font("Arial", Font.BOLD, 13));
		btnAplicarCambios.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
		btnAplicarCambios.setBackground(new Color(0, 0, 0, 0));
		btnAplicarCambios.setBounds(230, 442, 180, 28);
		contentPane.add(btnAplicarCambios);

		JLabel lblPorcentajesManejadosPor = new JLabel("Porcentajes manejados por el hotel:");
		lblPorcentajesManejadosPor.setHorizontalAlignment(SwingConstants.LEFT);
		lblPorcentajesManejadosPor.setForeground(Color.BLACK);
		lblPorcentajesManejadosPor.setFont(new Font("Arial", Font.BOLD, 20));
		lblPorcentajesManejadosPor.setBounds(100, 220, 340, 24);
		contentPane.add(lblPorcentajesManejadosPor);

		//////////////////////////////////////////// 77777

		JLabel lblTitulo = new JLabel("Configuraciones");
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
		String botones[] = { "Regresar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(this, "\u00bfDeseas regresar a la anterior ventana?", "Regresar", 0,
				0, null, botones, this);
		if (eleccion == JOptionPane.YES_OPTION) {
			setVisible(false);
                        OpcionesAdmin.getInstancia().hacerVisible();
		}
	}

	// Metodo del boton cerrar
	public void cerrar() {
		String botones[] = { "Cerrar", "Cancelar" };
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
        
        public static Configuraciones getInstancia() {
            if(instancia != null) {
                return instancia;
            }
            
            return new Configuraciones();
        }
        
        public void actualizarHotel() throws Exception {
            app.actualizarHotel(1, Integer.parseInt(txtDiasDescuento.getText()), Integer.parseInt(txtDescuento.getText()), 
                    Integer.parseInt(txtAforo.getText()), Integer.parseInt(txtCapacidad.getText()));
        }
        
        public void hacerVisible() {
            try {
                Hotel hotel = app.getHotel(1);
                
                txtDescuento.setText("Descuento: "+hotel.getT_descuento()+"%");
                txtAforo.setText("Aforo: "+hotel.getT_aforo()+"%");
                txtDiasDescuento.setText("Días descuento: "+hotel.getQ_diasDescuento()+" días");
                txtCapacidad.setText("Capacidad: "+hotel.getQ_apacidad()+" personas");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se encontró el hotel", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            setVisible(true);
            toFront();
        }
}