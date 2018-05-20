package gui.controller;

import java.awt.EventQueue;

import javax.swing.JTextArea;

import gui.ThreadGUI;
import test.Test;

public class GuiController {
	
	private static ThreadGUI mw;
	private static Test t;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiController.mw = new ThreadGUI();
					GuiController.mw.setVisible(true);
					GuiController.t = new Test();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void singInThreads(JTextArea ekran) {
		t.startThreads(ekran);
	}
	
	public static void stopAllThreads() {
		t.stopAll();
	}
	
}
