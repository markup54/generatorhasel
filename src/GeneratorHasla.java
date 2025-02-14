import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GeneratorHasla {
    private String haslo;

    public GeneratorHasla() {
        this.haslo = "";
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String fyrlanie(String slowo) {
        String wyfyrlaneSlowo = "";
        /*String[] literki = wyfyrlaneSlowo.split("");
        System.out.println(literki[0]);*/
        //Collections.shuffle(); jak zmienić tekst na tablicę

        Random random = new Random();
        int dlugosc = slowo.length();
        for (int i = dlugosc; i >= 1; i--) {
            int liczba = random.nextInt(i);
            wyfyrlaneSlowo = wyfyrlaneSlowo + slowo.charAt(liczba);
            slowo = slowo.substring(0, liczba) + slowo.substring(liczba + 1, slowo.length());
        }


        return wyfyrlaneSlowo;
    }

    public void generujHasloProste(int ileZnakow, boolean czyDuze, boolean czyZnaki, boolean czyCyfry) {
        haslo = "";
        Random random = new Random();
        int losowa;
        String maleLitery = "qwertyuioplkjhgfdsazxcvbnm";
        String duzeLitery = "QWERTYUIOPLKJHGFDSAZXCVBNM";
        String znaki = "!@#$%^&*()_+-=<>?./";
        String cyfry = "1234567890";
        if (czyDuze) {
            losowa = random.nextInt(duzeLitery.length());
            haslo = haslo + duzeLitery.charAt(losowa);
        }
        if (czyZnaki) {
            losowa = random.nextInt(znaki.length());
            haslo = haslo + znaki.charAt(losowa);
        }
        if (czyCyfry) {
            losowa = random.nextInt(cyfry.length());
            haslo = haslo + cyfry.charAt(losowa);
        }
        int dlugosc = haslo.length();
        for (int i =dlugosc ; i <ileZnakow ; i++) {
            losowa = random.nextInt(maleLitery.length());
            haslo = haslo+maleLitery.charAt(losowa);
        }
        haslo = fyrlanie(haslo);
    }

    public void generujHasloRowne(int ileZnakow, boolean czyDuze, boolean czyZnaki, boolean czyCyfry) {
        haslo = "";
        Random random = new Random();
        int losowa;
        String maleLitery = "qwertyuioplkjhgfdsazxcvbnm";
        String duzeLitery = "QWERTYUIOPLKJHGFDSAZXCVBNM";
        String znaki = "!@#$%^&*()_+-=<>?./";
        String cyfry = "1234567890";
        int ileRodzajow =1;
        if(czyDuze){
            ileRodzajow++;
        }
        if (czyCyfry){
            ileRodzajow++;
        }
        if(czyZnaki){
            ileRodzajow++;
        }
        int ile = ileZnakow/ileRodzajow;
        if(czyDuze){
            for (int i = 0; i < ile; i++) {
                losowa = random.nextInt(duzeLitery.length());
                haslo = haslo + duzeLitery.charAt(losowa);
            }
        }
        if(czyCyfry){
            for (int i = 0; i < ile; i++) {
                losowa = random.nextInt(cyfry.length());
                haslo = haslo+maleLitery.charAt(losowa);
            }
        }
        if (czyZnaki) {
            for (int i = 0; i < ile; i++) {
                losowa = random.nextInt(znaki.length());
                haslo = haslo + znaki.charAt(losowa);
            }
        }
        for (int i = 0; i < ile; i++) {
            losowa = random.nextInt(maleLitery.length());
            haslo = haslo + maleLitery.charAt(losowa);
        }
        if(haslo.length()<ileZnakow){
            losowa = random.nextInt(maleLitery.length());
            haslo = haslo + maleLitery.charAt(losowa);
        }
        if(haslo.length()<ileZnakow && czyDuze){
            losowa = random.nextInt(duzeLitery.length());
            haslo = haslo + duzeLitery.charAt(losowa);
        }
        if(haslo.length()<ileZnakow && czyZnaki){
            losowa = random.nextInt(znaki.length());
            haslo = haslo + znaki.charAt(losowa);
        }
        if(haslo.length()<ileZnakow && czyCyfry){
            losowa = random.nextInt(cyfry.length());
            haslo = haslo + cyfry.charAt(losowa);
        }
        haslo = fyrlanie(haslo);
    }

    private void generujHasloLosowe(int ileZnakow, boolean czyDuze, boolean czyZnaki, boolean czyCyfry) {

    }


}
