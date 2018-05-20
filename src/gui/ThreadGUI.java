package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.controller.GuiController;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class ThreadGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panelEast;
	private JButton btnStart;
	private JButton btnStop;
	private JScrollPane scrollPane;
	private JTextArea textAreaEkran;
	private JButton btnIzlaz;
	private JLabel lblPhoto;

	

	/**
	 * Create the frame.
	 */
	public ThreadGUI() {
		setTitle("Patti Smith - Because The Night ft. Bruce Springsteen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelEast(), BorderLayout.EAST);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	private JPanel getPanelEast() {
		if (panelEast == null) {
			panelEast = new JPanel();
			panelEast.setPreferredSize(new Dimension(160, 60));
			GroupLayout gl_panelEast = new GroupLayout(panelEast);
			gl_panelEast.setHorizontalGroup(
				gl_panelEast.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelEast.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelEast.createParallelGroup(Alignment.LEADING)
							.addComponent(getBtnStop(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
							.addComponent(getBtnIzlaz(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
							.addComponent(getBtnStart(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
							.addComponent(getLblPhoto(), GroupLayout.PREFERRED_SIZE, 140, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_panelEast.setVerticalGroup(
				gl_panelEast.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelEast.createSequentialGroup()
						.addGap(41)
						.addComponent(getBtnStart(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(57)
						.addComponent(getLblPhoto(), GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
						.addComponent(getBtnStop(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(getBtnIzlaz())
						.addContainerGap())
			);
			panelEast.setLayout(gl_panelEast);
		}
		return panelEast;
	}
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GuiController.singInThreads(textAreaEkran);
				}
			});
			btnStart.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnStart.setAlignmentY(Component.TOP_ALIGNMENT);
		}
		return btnStart;
	}
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("Stop");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GuiController.stopAllThreads();
				}
			});
			btnStop.setAlignmentX(Component.RIGHT_ALIGNMENT);
		}
		return btnStop;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextAreaEkran());
		}
		return scrollPane;
	}
	public JTextArea getTextAreaEkran() {
		if (textAreaEkran == null) {
			textAreaEkran = new JTextArea();
		}
		return textAreaEkran;
	}
	private JButton getBtnIzlaz() {
		if (btnIzlaz == null) {
			btnIzlaz = new JButton("Izlaz");
			btnIzlaz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnIzlaz.setForeground(new Color(0, 0, 0));
		}
		return btnIzlaz;
	}
	private JLabel getLblPhoto() {
		if (lblPhoto == null) {
			lblPhoto = new JLabel("");
			lblPhoto.setIcon(new ImageIcon(ThreadGUI.class.getResource("/icons/patti.jpg")));
			
		}
		return lblPhoto;
	}
}
