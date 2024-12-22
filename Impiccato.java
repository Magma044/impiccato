/*Gioco dell’impiccato
Data una stringa inserita direttamente nel codice hard coded (ad esempio “Cadel Evans”), 
chiedere all’utente un carattere alla volta da indovinare e visualizzare man mano la stringa facendo comparire solo
i caratteri indovinati. Si noti che non occorre distinguere tra minuscole e maiuscole.
Quando la stringa sarà completamente svelata, stampare a video il numero di caratteri inseriti per scoprirla completamente. */

import java.util.Scanner;

public class Impiccato{
    private static String parola = "rabarbaro";
    private static char[] parolaNascosta = new char[parola.length()];
    private static int tentativi = 0;
    private static int erroriRimasti = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < parola.length(); i++) {
            parolaNascosta[i] = '_';
        }
        while(erroriRimasti > 0 && new String(parolaNascosta).contains("_")){
            System.out.println(new String(parolaNascosta));
            System.out.print("Inserisci una lettera: ");
            char tentativo = scanner.nextLine().toLowerCase().charAt(0);

            boolean giusta = false;

            for (int i = 0; i < parola.length(); i++) {
                if (parola.charAt(i) == tentativo) {
                    parolaNascosta[i] = tentativo;
                    giusta = true;
                }
            }

            if(!giusta){
                erroriRimasti--;
                System.out.println("La lettera è sbagliata! Tentativi rimasti: "+erroriRimasti);
            }
            tentativi++;
        }
        scanner.close();
        if(new String(parolaNascosta).equals(parola)){
            System.out.println("Hai vinto in "+tentativi+" tentativi!");
        }
        else{
            System.out.println("Hai perso! La parola era: "+parola);
        }
    }
}