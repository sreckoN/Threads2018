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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panelEast;
	private JButton btnStart;
	private JButton btnStop;
	private JScrollPane scrollPane;
	private JTextArea textAreaEkran;

	

	/**
	 * Create the frame.
	 */
	public ThreadGUI() {
		setTitle("Patti Smith - Because The Night ft. Bruce Springsteen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
			panelEast.setPreferredSize(new Dimension(120, 30));
			GroupLayout gl_panelEast = new GroupLayout(panelEast);
			gl_panelEast.setHorizontalGroup(
				gl_panelEast.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelEast.createSequentialGroup()
						.addGap(10)
						.addGroup(gl_panelEast.createParallelGroup(Alignment.LEADING)
							.addComponent(getBtnStart(), GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addComponent(getBtnStop(), GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
						.addGap(10))
			);
			gl_panelEast.setVerticalGroup(
				gl_panelEast.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelEast.createSequentialGroup()
						.addGap(5)
						.addComponent(getBtnStart(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
						.addComponent(getBtnStop(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(9))
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
}
