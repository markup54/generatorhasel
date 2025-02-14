import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello world!");
        GeneratorHasla generatorHasla = new GeneratorHasla();
        //System.out.println(generatorHasla.fyrlanie("abcdefgh"));
        generatorHasla.generujHasloProste(10,true,false,true);
        System.out.println(generatorHasla.getHaslo());
        generatorHasla.generujHasloRowne(10,true,true,true);
        System.out.println(generatorHasla.getHaslo());
        /*System.out.println("Wylosowana tablica:");
        int[] tablica = wylosujDoTablicy(20, 1, 100);
        System.out.println(Arrays.toString(tablica));
        System.out.println("Wylosowana Lista");
        ArrayList<Integer> wylosowanaLista = wylosujListe(20, 1, 100);
        System.out.println(wylosowanaLista);

        Scanner scanner = new Scanner(System.in);
        tablica = sortujBabelkowo(tablica);
        System.out.println("Po Sortowaniu");
        System.out.println(Arrays.toString(tablica));
        System.out.println("Podaj szukaną liczbę w tablicy");
        int szukana = scanner.nextInt();

        int indeksSzukanej = wyszukajBinarnie(tablica, szukana);
        if (indeksSzukanej > -1) {
            System.out.println(String.format("%d znaleziono pod indeksem %d", szukana, indeksSzukanej));
        } else {
            System.out.println("Wartość nie została znaleziona");
        }
        szukana = scanner.nextInt();
        int indeksSzukanej2 = wyszukajLiniowo(wylosowanaLista, szukana);
        if (indeksSzukanej2 > -1) {
            System.out.println(String.format("%d znaleziono pod indeksem %d", szukana, indeksSzukanej2));
        } else {
            System.out.println("Wartość nie została znaleziona");
        }*/
    }

    private static ArrayList<Integer> wylosujListe(int n, int a, int b) {
        ArrayList<Integer> wylosowana = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            wylosowana.add(random.nextInt(a, b + 1));
        }
        return wylosowana;
    }

    /**
     * złożoność obliczeniowa O(n) liniowa
     *
     * @param n - liczba losowanych elementów
     * @param a - początek zakresu losowania
     * @param b - koniec zakresu losowania
     * @return
     */
    private static int[] wylosujDoTablicy(int n, int a, int b) {
        int[] wylosowanaTablica = new int[n];
        Random random = new Random();
        for (int i = 0; i < wylosowanaTablica.length; i++) {
            wylosowanaTablica[i] = random.nextInt(a, b + 1);
        }
        return wylosowanaTablica;
    }

    /**
     * @param tablicaDoWypisania
     */
    private static void wypiszTablice(int[] tablicaDoWypisania) {

    }

    private static int wyszukajLiniowo(int[] tablicaZLiczbami, int szukanaWartosc) {
        for (int i = 0; i < tablicaZLiczbami.length; i++) {
            if (szukanaWartosc == tablicaZLiczbami[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int wyszukajLiniowo(ArrayList<Integer> listaZliczbami, int szukanaWartosc) {
        for (int i = 0; i < listaZliczbami.size(); i++) {
            if (listaZliczbami.get(i).equals(szukanaWartosc)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * złożonośc kwadratowa - O(n^2)
     *
     * @param tablicaLiczbowa
     * @return
     */
    private static int[] sortujBabelkowo(int[] tablicaLiczbowa) {
        boolean zamiana = true;
        while (zamiana) {
            zamiana = false;
            for (int i = 0; i < tablicaLiczbowa.length  - 1; i++) {
                if (tablicaLiczbowa[i] > tablicaLiczbowa[i + 1]) {
                    int pomoc = tablicaLiczbowa[i];
                    tablicaLiczbowa[i] = tablicaLiczbowa[i + 1];
                    tablicaLiczbowa[i + 1] = pomoc;
                    zamiana = true;
                }
            }
        }

        return tablicaLiczbowa;
    }
    private static ArrayList<Integer> sortujBabelkowo(ArrayList<Integer> listaLiczbowa) {
        boolean zamiana = true;
        while (zamiana) {
            zamiana = false;
            for (int i = 0; i < listaLiczbowa.size() - 1; i++) {
               if(listaLiczbowa.get(i)>listaLiczbowa.get(i+1)){
                   int pomoc = listaLiczbowa.get(i);
                   listaLiczbowa.set(i,listaLiczbowa.get(i+1));
                   listaLiczbowa.set(i+1,pomoc);
                   zamiana = true;
                }
            }
        }

        return listaLiczbowa;
    }


    /**
     * @param tablicaZLiczbami  - uporządkowana tablica liczb całkowitych
     * @param szukanaWartosc
     * @return
     */
    private static int wyszukajBinarnie(int[] tablicaZLiczbami, int szukanaWartosc) {
        //Arrays.binarySearch(tablicaZLiczbami,szukanaWartosc);
        int poczatek = 0;
        int koniec = tablicaZLiczbami.length-1;
        int srodek;
        while (poczatek<=koniec){
            srodek = (poczatek+koniec) /2;
            if(szukanaWartosc>tablicaZLiczbami[srodek]){
                poczatek = srodek+1;
            }
            else if(szukanaWartosc<tablicaZLiczbami[srodek]){
                koniec =srodek -1;
            }
            else{
                return srodek;
            }
        }


        return -1;
    }

    private static int wyszukajBinarnie(ArrayList<Integer> listaZLiczbami, int szukanaWartosc) {
        return -1;
    }
}