import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testowanie metody mieszającej litery");
        System.out.println(fyrlaj("abcde"));
        System.out.println("Testowanie generatora haseł");
        System.out.println(generujProsteHaslo(10, true, true, true));
        System.out.println(generujRowneHaslo(14, true, true, true));
        System.out.println(generujSuperHaslo(14, true, true, true));
    }

    /**
     * Generowanie hasła o  mniejwięcej równej liczbie różnych znaków
     *
     * @param liczbaznakow
     * @param czyDuze
     * @param czyCyfry
     * @param czyZnaki
     * @return
     */
    private static String generujSuperHaslo(int liczbaznakow, boolean czyDuze, boolean czyCyfry, boolean czyZnaki) {
        String haslo = "";
        Random random = new Random();
        String duzeLitery = "QWERTYUIOPLKJHGFDSAZXCVBNM";
        String cyfry = "0123456789";
        String znakiSpecjalne = "!@#$%^&*()_+=-?<>,.";
        String male = "qwertyuioplkjhgfdsazxcvbnm";
        //co najmniej 1 litera
        haslo = haslo + male.charAt(random.nextInt(male.length()));

        if (czyDuze && haslo.length() < liczbaznakow) {
            haslo = haslo + duzeLitery.charAt(random.nextInt(duzeLitery.length()));
        }
        if (czyZnaki && haslo.length() < liczbaznakow) {
            haslo = haslo + znakiSpecjalne.charAt(random.nextInt(znakiSpecjalne.length()));
        }
        if (czyCyfry && haslo.length() < liczbaznakow) {
            haslo = haslo + cyfry.charAt(random.nextInt(cyfry.length()));
        }

        while (haslo.length() < liczbaznakow) {
            int ktora = random.nextInt(3);
            switch (ktora) {
                case 0:
                    if (czyDuze && haslo.length() < liczbaznakow) {
                        haslo = haslo + duzeLitery.charAt(random.nextInt(duzeLitery.length()));
                    }
                    break;
                case 1:
                    if (czyZnaki && haslo.length() < liczbaznakow) {
                        haslo = haslo + znakiSpecjalne.charAt(random.nextInt(znakiSpecjalne.length()));
                    }
                    break;
                case 2:
                    if (czyCyfry && haslo.length() < liczbaznakow) {
                        haslo = haslo + cyfry.charAt(random.nextInt(cyfry.length()));
                    }
                    break;
                default:
                    haslo = haslo + male.charAt(random.nextInt(male.length()));
                    break;
            }
        }

        haslo = fyrlaj(haslo);
        return haslo;
    }

    private static String generujRowneHaslo(int liczbaznakow, boolean czyDuze, boolean czyCyfry, boolean czyZnaki) {
        String haslo = "";
        Random random = new Random();
        String duzeLitery = "QWERTYUIOPLKJHGFDSAZXCVBNM";
        int ileRodzajow = 1;
        if (czyCyfry) {
            ileRodzajow++;
        }
        if (czyDuze) {
            ileRodzajow++;
        }
        if (czyZnaki) {
            ileRodzajow++;
        }
        int minimalnaLiczbaZnakowDanegoRodzaju = liczbaznakow / ileRodzajow;
        if (czyDuze)
            for (int i = 0; i < minimalnaLiczbaZnakowDanegoRodzaju; i++) {
                haslo = haslo + duzeLitery.charAt(random.nextInt(duzeLitery.length()));
            }
        String cyfry = "0123456789";
        if (czyCyfry) {
            for (int i = 0; i < minimalnaLiczbaZnakowDanegoRodzaju; i++) {
                haslo = haslo + cyfry.charAt(random.nextInt(cyfry.length()));
            }
        }
        String znakiSpecjalne = "!@#$%^&*()_+=-?<>,.";
        if (czyZnaki) {
            for (int i = 0; i < minimalnaLiczbaZnakowDanegoRodzaju; i++) {
                haslo = haslo + znakiSpecjalne.charAt(random.nextInt(znakiSpecjalne.length()));
            }
        }
        String male = "qwertyuioplkjhgfdsazxcvbnm";

        for (int i = 0; i < minimalnaLiczbaZnakowDanegoRodzaju; i++) {
            haslo = haslo + male.charAt(random.nextInt(male.length()));
        }
        if (czyDuze && haslo.length() < liczbaznakow) {
            haslo = haslo + duzeLitery.charAt(random.nextInt(duzeLitery.length()));
        }
        if (czyZnaki && haslo.length() < liczbaznakow) {
            haslo = haslo + znakiSpecjalne.charAt(random.nextInt(znakiSpecjalne.length()));
        }
        if (czyCyfry && haslo.length() < liczbaznakow) {
            haslo = haslo + cyfry.charAt(random.nextInt(cyfry.length()));
        }
        haslo = fyrlaj(haslo);
        return haslo;
    }

    /**
     * metoda generuje haslo z co najwyzej 1 dużą litera, jedną cyfrą jednym znakiem specjalnym
     * pozostałe litery są małe
     * zakladamy że liczba znakow ok
     *
     * @param liczbaznakow
     * @param czyDuze
     * @param czyCyfry
     * @param czyZnaki
     * @return
     */
    private static String generujProsteHaslo(int liczbaznakow, boolean czyDuze, boolean czyCyfry, boolean czyZnaki) {
        String haslo = "";
        Random random = new Random();
        String duzeLitery = "QWERTYUIOPLKJHGFDSAZXCVBNM";
        if (czyDuze) {
            haslo = haslo + duzeLitery.charAt(random.nextInt(duzeLitery.length()));
        }
        String cyfry = "0123456789";
        if (czyCyfry) {
            haslo = haslo + cyfry.charAt(random.nextInt(cyfry.length()));
        }
        String znakiSpecjalne = "!@#$%^&*()_+=-?<>,.";
        if (czyZnaki) {
            haslo = haslo + znakiSpecjalne.charAt(random.nextInt(znakiSpecjalne.length()));
        }
        String male = "qwertyuioplkjhgfdsazxcvbnm";
        int dlugosc = haslo.length();
        for (int i = dlugosc; i < liczbaznakow; i++) {
            haslo = haslo + male.charAt(random.nextInt(male.length()));
        }
        haslo = fyrlaj(haslo);
        return haslo;
    }

    private static String fyrlaj(String hasloDoFyrlania) {
        //Collections.shuffle();
        Random random = new Random();
        for (int i = 0; i < hasloDoFyrlania.length(); i++) {
            int losowyIndeks = random.nextInt(hasloDoFyrlania.length());
            char pierwszaLitera = hasloDoFyrlania.charAt(losowyIndeks);
            char drugaLitera = hasloDoFyrlania.charAt(i);
            hasloDoFyrlania = hasloDoFyrlania.substring(0, losowyIndeks) + drugaLitera +
                    hasloDoFyrlania.substring(losowyIndeks + 1);
            hasloDoFyrlania = hasloDoFyrlania.substring(0, i) + pierwszaLitera +
                    hasloDoFyrlania.substring(i + 1);
        }
        return hasloDoFyrlania;
    }

}