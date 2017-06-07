package Main;

import java.io.IOException;
import java.sql.Connection;

import Arduino.ArduinoUsbChannel;
import Database.ConnectionBD;
import GUI.MenuGUI;
import Session.SessionManager;
import jssc.SerialPortException;

public class Main {

	public static SessionManager sessionManager;
	public static SystemAccount currentSystemAccount;
	public static Connection conn;
	public static MenuGUI mg;
	public static ArduinoUsbChannel vcpChannel;
	public static boolean arduinoConnected = true;

	public static void main(String[] args) throws InterruptedException {
		conn = ConnectionBD.connect();
		String port = null;

		// Recherche du port de l'Arduino

		System.err.println("RECHERCHE d'un port disponible...");
		port = ArduinoUsbChannel.getOneComPort();
		// TODO mettre la methode de recherche de port dans TimingManager
		if (port != null) {
			try {
				vcpChannel = new ArduinoUsbChannel(port);
			} catch (IOException e) {
				e.printStackTrace(System.err);
			}
		} else {
			arduinoConnected = false;
			System.out.println("Impossible de se connecter au module de mesure de pressions, poursuite du programme "
					+ "sans mesure de pressions");
		}
		if (arduinoConnected) {
			try {
				vcpChannel.open();
			} catch (SerialPortException | IOException e1) {
				System.exit(-1);
			}
		}

		sessionManager = new SessionManager();
		// GUI initGui = new GUI(); //initialisation de l'interface
		mg = new MenuGUI();
		// SyncUtil sync = new SyncUtil();
		// sync.start();
	}

	// permet de tester si deux mots de passe correspondent
	public static boolean passwordMatch(char[] p1, char[] p2) {
		if (p1.length == p2.length) { // on test d'abbord les longueurs pour
										// gagner du temps
			// on test ensuite chaque caracere separement
			for (int i = 0; i < p1.length; i++) {
				if (p1[i] != p2[i]) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

}
