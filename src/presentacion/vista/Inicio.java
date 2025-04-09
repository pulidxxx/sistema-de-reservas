package presentacion.vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
        private static Inicio instancia;
	private JPanel contentPane;

	public Inicio() {
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

		// Botones
		JLabel btnIniciarApp = new JLabel("");
		btnIniciarApp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIniciarApp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIniciarApp.setIcon(new ImageIcon(Inicio.class.getResource("/presentacion/img/buttons/inicio-hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnIniciarApp.setIcon(new ImageIcon(Inicio.class.getResource("/presentacion/img/buttons/inicio.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
                                setVisible(false);
				Login.getInstancia().hacerVisible();
			}
		});
		btnIniciarApp.setIcon(new ImageIcon(Inicio.class.getResource("/presentacion/img/buttons/inicio.png")));
		btnIniciarApp.setBounds(210, 336, 119, 34);
		contentPane.add(btnIniciarApp);

		JLabel btnSalir = new JLabel("");
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalir.setIcon(new ImageIcon(Inicio.class.getResource("/presentacion/img/buttons/salir.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSalir.setIcon(new ImageIcon(Inicio.class.getResource("/presentacion/img/buttons/salir-hover.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cerrar();
			}
		});
		btnSalir.setIcon(new ImageIcon(Inicio.class.getResource("/presentacion/img/buttons/salir-hover.png")));
		btnSalir.setBounds(380, 336, 105, 34);
		contentPane.add(btnSalir);

		// Labels con titulos, fondos e iconos
		JLabel lblLogoNegro = new JLabel("");
		lblLogoNegro.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoNegro.setOpaque(false);
		lblLogoNegro.setBounds(0, 100, 700, 127);
		lblLogoNegro.setIcon(new ImageIcon(Inicio.class.getResource("/presentacion/img/icons/Logo negro.png")));
		contentPane.add(lblLogoNegro);

		JLabel lblLogoBlanco = new JLabel("");
		lblLogoBlanco.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoBlanco.setOpaque(false);
		lblLogoBlanco.setBounds(700, 0, 300, 550);
		lblLogoBlanco.setIcon(new ImageIcon(Inicio.class.getResource("/presentacion/img/icons/Logo blanco.png")));
		contentPane.add(lblLogoBlanco);

		JLabel lblReservasApp = new JLabel("Reservas App");
		lblReservasApp.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservasApp.setForeground(Color.BLACK);
		lblReservasApp.setFont(new Font("Arial", Font.BOLD, 40));
		lblReservasApp.setBounds(0, 257, 700, 41);
		contentPane.add(lblReservasApp);

		JLabel fondoBlanco = new JLabel("");
		fondoBlanco.setBounds(0, 0, 700, 550);
		fondoBlanco.setBackground(new Color(217, 209, 233));
		fondoBlanco.setOpaque(true);
		contentPane.add(fondoBlanco);

		JLabel fondoMorado = new JLabel("");
		fondoMorado.setIcon(new ImageIcon(getClass().getResource("/presentacion/img/Background purple.jpg")));
		fondoMorado.setBounds(700, 0, 300, 550);
		fondoMorado.setOpaque(true);
		contentPane.add(fondoMorado);
	}

	// Metodo del boton cerrar
	private void cerrar() {
		String botones[] = { "Cerrar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(this, "\u00bfDeseas cerrar la aplicaci\u00f3n?", "Cerrar aplicaci\u00f3n", 0, 0,
				null, botones, this);
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}
        
        public static Inicio getInstancia() {
            return instancia;
        }
}
