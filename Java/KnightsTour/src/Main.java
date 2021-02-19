
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.GregorianCalendar; 

/**
 * @author Nathan Busler
 *
 */
public class Main {

	/** public static void start()
	 * Erfragt vom Nutzer alle notwendigen Parameter zur Lösung des Springerproblems.
	 */
	public static void start() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte geben Sie die Größe des Schachbrettes ein.");
		int sizeBoard = Integer.parseInt(sc.next());
		
		Board myBoard = new Board(sizeBoard);
		System.out.println("\n" + myBoard.toString() + "\n");
		
		String startFeld = " ";
		while (startFeld.length() != 2 || 0 > startFeld.toCharArray()[0] - 97 || startFeld.toCharArray()[0] - 97 > sizeBoard || 0 > (Character.getNumericValue(startFeld.toCharArray()[1]) -1) || (Character.getNumericValue(startFeld.toCharArray()[1]) -1) > sizeBoard) {
			
		System.out.println("Bitte Geben das Startfeld des Springers in Schachnotation ein");
		startFeld = sc.next();
		}
		
		Field startfeld = myBoard.getBoard()[startFeld.toCharArray()[0]-97][(Character.getNumericValue(startFeld.toCharArray()[1]) -1)];
		Calculator calc1 = new Calculator(myBoard, startfeld);
		
		char mode = ' ';
		while (mode != 'K' && mode != 'S') {
			System.out.println("Für die klassische Variante geben Sie K ein. Für die simple Variante geben Sie S ein.");
			mode = sc.next().charAt(0);
		}
		
		if (mode == 'K') {
		
		int anzLsg = -1;
		while (anzLsg < 0) {
			System.out.println("Wie viele Lösungen sollen ausgegeben werden?");
			try {
				anzLsg = Integer.parseInt(sc.next());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		System.out.println("KLASSISCHE VARIANTE");
		GregorianCalendar now1 = new GregorianCalendar();
		DateFormat time = DateFormat.getTimeInstance(DateFormat.MEDIUM);
		DateFormat dt = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		System.out.println(dt.format(now1.getTime())); 
		System.out.println("\nStartfeld " + startfeld.toString());
		Path myPath = new Path();
		myPath.add(startfeld);
		calc1.classic(myPath, 1);
		System.out.println();
		System.out.println(calc1.pathsToString(anzLsg));
		GregorianCalendar now2 = new GregorianCalendar();
		System.out.println("KLASSISCHE VARIANTE\n" + calc1.pathsSize() + " Lösungen\n" + time.format(now1.getTime()) + " bis " + time.format(now2.getTime()));
	
		BufferedWriter br;
		StringBuilder resName = new StringBuilder();
		resName.append(sizeBoard);
		resName.append("_");
		resName.append(startfeld.toString());
		resName.append("_");
		resName.append("classic.txt");
		try {
			br = new BufferedWriter(new FileWriter(new File(resName.toString())));
			br.write("R E S U L T S");
			br.newLine();
			br.newLine();
			for (int i = calc1.getBoard().getBoard().length - 1; i >= 0; i--) {
				for ( int j = 0; j < calc1.getBoard().getBoard().length; j++) {
					br.write(calc1.getBoard().getBoard()[j][i].toString());
					br.write(" ");
				}
				br.newLine();
			}
			br.newLine();
			br.write("Startfeld " + startfeld.toString());
			br.newLine();
			br.write("Klassische Variante ");
			br.newLine();
			br.write(calc1.pathsSize() + " Lösungen");
			br.newLine();
			br.write(time.format(now1.getTime()) + " bis " + time.format(now2.getTime()));
			br.newLine();
			if (calc1.getPaths().size() < 10) {
				for (int i = 0; i < calc1.getPaths().size(); i++) {
					br.write(calc1.getPaths().get(i).toString());
					br.newLine();
				}
			}
			else {
				for (int i = 0; i < 10; i++) {
					br.write(calc1.getPaths().get(i).toString());
					br.newLine();
				}
			}
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		// Ab hier die simple Variante.
		else if (mode == 'S') {
			
			int anzLsg = -1;
			while (anzLsg < 0) {
				System.out.println("Wie viele Lösungen sollen ausgegeben werden?");
				try {
					anzLsg = Integer.parseInt(sc.next());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("SIMPLE VARIANTE");
			GregorianCalendar now1 = new GregorianCalendar();
			DateFormat time = DateFormat.getTimeInstance(DateFormat.MEDIUM);
			DateFormat dt = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
			System.out.println(dt.format(now1.getTime())); 
			System.out.println("\nStartfeld " + startfeld.toString());
			Path myPath = new Path();
			myPath.add(startfeld);
			calc1.simple(myPath, 1);
			System.out.println();
			System.out.println(calc1.pathsToString(anzLsg));
			GregorianCalendar now2 = new GregorianCalendar();
			System.out.println("SIMPLE VARIANTE\n" + calc1.pathsSize() + " Lösungen\n" + time.format(now1.getTime()) + " bis " + time.format(now2.getTime()));
		
			BufferedWriter br;
			StringBuilder resName = new StringBuilder();
			resName.append(sizeBoard);
			resName.append("_");
			resName.append(startfeld.toString());
			resName.append("_");
			resName.append("simple.txt");
			try {
				br = new BufferedWriter(new FileWriter(new File(resName.toString())));
				br.write("R E S U L T S");
				br.newLine();
				br.newLine();
				for (int i = calc1.getBoard().getBoard().length - 1; i >= 0; i--) {
					for ( int j = 0; j < calc1.getBoard().getBoard().length; j++) {
						br.write(calc1.getBoard().getBoard()[j][i].toString());
						br.write(" ");
					}
					br.newLine();
				}
				br.newLine();
				br.write("Startfeld " + startfeld.toString());
				br.newLine();
				br.write("Simple Variante ");
				br.newLine();
				br.write(calc1.pathsSize() + " Lösungen");
				br.newLine();
				br.write(time.format(now1.getTime()) + " bis " + time.format(now2.getTime()));
				br.newLine();
				if (calc1.getPaths().size() < 10) {
					for (int i = 0; i < calc1.getPaths().size(); i++) {
						br.write(calc1.getPaths().get(i).toString());
						br.newLine();
					}
				}
				else {
					for (int i = 0; i < 10; i++) {
						br.write(calc1.getPaths().get(i).toString());
						br.newLine();
					}
				}
				br.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** public static void main(String[] args)
	 * @param args
	 * Führt das Programm, also die start() Methode aus.
	 */
	public static void main(String[] args) {
		
		 start();
	}

}
