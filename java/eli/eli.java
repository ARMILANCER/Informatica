package eli;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class eli {

    public static void main(String[] args) {
        String nomeFile = "/Users/christianbrito/Documents/Eli/eli/src/main/java/eli/stringhe.csv";
        Scanner t1 = new Scanner(System.in);
        eli metodi = new eli();
        final int DIM_MAX = 10;

        try (RandomAccessFile raf = new RandomAccessFile(nomeFile, "rwd")) {
            System.out.println(".:Benvenuto, premi:.\n(1) per SCRIVERE\n(2) per LEGGERE\n(3) per USCIRE");
            int scelta;

            while (true) {
                System.out.print("Inserisci la tua scelta: ");
                scelta = t1.nextInt();
                t1.nextLine();  // Pulisce il buffer per evitare problemi con `nextLine()`

                switch (scelta) {
                    case 1:
                        boolean scrivi = true;
                        System.out.println(".:Sei nel metodo SCRITTURA; inserisci una stringa: ");

                        while (scrivi) {
                            String parola = t1.nextLine();
                            metodi.writeString(parola, raf, DIM_MAX);

                            System.out.println(".:Desideri continuare? (si/no):");
                            // Opzione si/no
                            String scelta1 = t1.nextLine();
                            if (scelta1.equalsIgnoreCase("si")) {
                                System.out.println("Inserisci la stringa:");
                            } else if (scelta1.equalsIgnoreCase("no")) {
                                System.out.println(".:Arrivederci:.");
                                scrivi = false;
                            } else {
                                System.out.println("Opzione non valida, riprova.");
                            }
                        }
                        break;

                    case 2:
                        // Resetta il puntatore del file all'inizio per la lettura
                        raf.seek(0);
                        System.out.println(".:Lettura del file:");

                        while (raf.getFilePointer() < raf.length()) {
                            String str1 = metodi.readString(raf, DIM_MAX);
                            if (str1 != null) {
                                System.out.println(str1);
                            }
                        }
                        break;

                    case 3:
                        System.out.println(".:Arrivederci:.");
                        t1.close();
                        return; // Termina il programma

                    default:
                        System.out.println("Scelta non valida. Riprova.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeString(String s, RandomAccessFile raf, int DIM_MAX) {
        // Completa la stringa con '\0' fino a raggiungere DIM_MAX caratteri
        int dif = DIM_MAX - s.length();
        for (int i = 0; i < dif; i++) {
            s = s + "\0";
        }

        try {
            raf.writeChars(s);  // Scrivi i caratteri nel file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readString(RandomAccessFile raf, int DIM_MAX) {
        StringBuilder s = new StringBuilder();  // Utilizza StringBuilder per migliore efficienza
        char c;
        int cont = 0;

        try {
            // Leggi fino a trovare '\0' o raggiungere DIM_MAX caratteri
            while (cont < DIM_MAX) {
                c = raf.readChar();
                cont++;
                if (c != '\0') {
                    s.append(c);  // Aggiungi carattere alla stringa se non è il terminatore
                } else {
                    break;  // Fermati se trovi '\0'
                }
            }
            // Salta eventuali spazi vuoti rimanenti
            raf.skipBytes((DIM_MAX - cont) * 2);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return s.toString();  // Restituisci la stringa letta
    }
}
