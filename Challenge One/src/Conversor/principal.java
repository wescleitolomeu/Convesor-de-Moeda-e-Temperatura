package Conversor;


	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	@SuppressWarnings("serial")
	public class principal extends JFrame {

		private JButton continuar;
		private JButton sair;
		private JComboBox<String> opcoes;

		public principal() {

			setTitle("Menu Principal");
			setLayout(null);

			continuar = new JButton("CONTINUAR");
			continuar.setBounds(20, 200, 140, 30);
			continuar.setForeground(Color.WHITE);
			continuar.setBackground(new Color(34, 124, 112));
			continuar.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(continuar);

			sair = new JButton("FECHAR");
			sair.setBounds(195, 200, 120, 30);
			sair.setForeground(Color.WHITE);
			sair.setBackground(new Color(34, 124, 112));
			sair.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(sair);

			String[] items = { "Conversor de Moedas", "Conversor de Temperatura" };
			opcoes = new JComboBox<String>(items);
			opcoes.setBounds(40, 50, 250, 30);
			opcoes.setForeground(Color.WHITE);
			opcoes.setBackground(new Color(34, 124, 112));
			opcoes.setFont(new Font("Tahoma", Font.BOLD, 16));
			add(opcoes);

			continuar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					Conversor();

				}

			});

			sair.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					try {

						int sair = JOptionPane.showConfirmDialog(principal.this, "Está seguro de sair da aplicação?",
								"Exit Confirmation", JOptionPane.YES_NO_OPTION);
						if (sair == JOptionPane.YES_OPTION) {

							System.exit(0);
						}
					} catch (Exception ex) {

						JOptionPane.showMessageDialog(principal.this, "Ocorreu um erro: " + ex.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			setSize(600, 450);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);

		}

		public void Conversor() {

			try {

				String Conversor = (String) opcoes.getSelectedItem();

				if (Conversor.equals("Conversor de Moedas")) {

					dispose();

					conversorMoeda conversor1 = new conversorMoeda();
					conversor1.setVisible(true);

				} else if (Conversor.equals("Conversor de Temperatura")) {

					dispose();

					conversorTemperatura conversor2 = new conversorTemperatura();
					conversor2.setVisible(true);

				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(principal.this, "Ocorreu um erro: " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		public static void main(String[] args) {
			principal principal = new principal();
			principal.setVisible(true);
		}

	}	
		


