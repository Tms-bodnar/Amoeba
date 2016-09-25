/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author bodnart
 */
public class Amoeba {

    static String jatekosO = nevBekero("Első Játékos, 'O'-val leszel, add meg a neved: ");
    static String jatekosX = nevBekero("Második Játékos, 'X'-el leszel, add meg a neved: ");

    /**
     * A nevBekero függvény bekéri a játékosok nevét, és visszaadja ezt
     * String-ként.
     *
     * @param szöveg
     * @return nev
     */
    public static String nevBekero(String szoveg) {

        Scanner sc = new Scanner(System.in);
        System.out.println(szoveg);
        String nev = sc.nextLine();
        return nev;
    }

    /**
     * A palyaValaszto függvény bekéri, mekkora pályán játszunk, és visszaadja
     * ezt az értéket int-ként.
     *
     * @param s
     * @return int tablameret
     */
    public static int palyaValaszto() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Mekkora pályán akarsz játszani? Minimum méret 3, maximum 12.");
        System.out.println("A győzelemhez 5x5-ös pályaméret alatt 3 jel,");
        System.out.println("felette 5 jel szükséges egy vonalban vagy átlóban.");
        int tablaMeret = sc.nextInt();
        return tablaMeret;
    }

    /**
     * A lepesBekero beolvassa aparaméterként megadott játékos következő
     * lépését, és viszaadja egy Stringként
     *
     * @param nev
     * @return String beirt
     */
    public static String lepesBekero(String nev) {

        Scanner sc = new Scanner(System.in);
        System.out.println(nev + ", lépj egy mezőre!");
        System.out.println("Előszőr a sort, majd az oszlopot: (pl:A2, b3, stb...)");
        String beirt = sc.nextLine();
        if (Character.isLowerCase(beirt.charAt(0))) {
            String beirtNagy = beirt.toUpperCase();
            beirt = beirtNagy;
        }
        return beirt;
    }

    /**
     *
     * A lepesAtalakito a lépés első betűjét számmá alakítja, majd visszaadja
     * int tömbként
     *
     * @param beirt
     * @return int[] lepes
     */
    public static int[] lepesAtalakito(String beirt) {

        int[] lepes = new int[2];
        char[] fuggBetu = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'};
        lepes[1] = Character.getNumericValue(beirt.charAt(1));
        for (int i = 0; i < fuggBetu.length; i++) {
            if (beirt.charAt(0) == fuggBetu[i]) {
                lepes[0] = (i);
            }
        }
        return lepes;
    }

    /**
     *
     * A lepesSor a paraméterként megadott lepes tömb első tagját int számmá
     * alakítja, majd visszaadja, mint a sor száma
     *
     * @param lepes
     * @return int sor
     */
    public static int lepesSor(int[] lepes) {

        int sor = lepes[0];
        return sor;
    }

    /**
     *
     * A lepesOszlop a paraméterként megadott lepes tömb második tagját int
     * számmá alakítja, majd visszaadja, mint az oszlop száma
     *
     * @param lepes
     * @return int oszlop
     */
    public static int lepesOszlop(int[] lepes) {

        int oszlop = lepes[1] - 1;
        return oszlop;
    }

    /**
     *
     * A táblaRajzolo a paraméterként megadott kétdimenziós tabla tömb alapján
     * megrajzolja a játékteret, bejelöli a sorokat, oszlopokat és beírja a
     * megadott lépéseket
     *
     * @param tabla
     *
     */
    public static void tablaRajzolo(String[][] tabla) {

        String[][] matrix = tabla;
        String[] fuggBetu = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
//üres pálya felrajzolása:
        //A cellák kitöltése
        boolean foglalt = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (tabla[i][j] == "O" || tabla[i][j] == "X") {
                    foglalt = true;
                }
                if (!foglalt) {
                    matrix[i][j] = " ";
                }
            }
        }
        //A tábla oszlopok számozása
        for (int i = 0; i < 1; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                if (k == 0) {
                    System.out.print(" ");
                }
                if (k >= 9) {
                    System.out.print("  " + (k + 1) + "");
                } else {
                    System.out.print("  " + (k + 1) + " ");
                }
            }
            System.out.println();
        }
        //A tábla első vízszintes sorai
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                if (k == 0) {
                    System.out.print(" ");
                }
                System.out.print("+---");
            }
            // A tábla sorok betűjelei   
            System.out.println("+");
            for (int k = 0; k < matrix[i].length; k++) {
                if (k == 0) {
                    System.out.print(fuggBetu[i]);
                }
                System.out.print("| " + matrix[i][k] + " ");
            }
            System.out.println("|");
        }
        //A tábla legalsó sora
        for (int i = 0; i < 1; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                if (k == 0) {
                    System.out.print(" ");
                }
                System.out.print("+---");
            }
            System.out.print("+");
        }
        System.out.println();
    }

    /**
     *
     * A nyertesVizsgalo a paraméterként megadott tabla tömb és jel alapján
     * megvizsgálja először vízszintesen, majd függőlegesen, utána átlóban
     * jobbról balra, végül átlóban balról jobbra, hogy az egymás melletti jelek
     * a nyero változóban deklarált számúak-e.
     *
     * @param tabla
     * @param jel
     * @return boolean nyertes
     */
    public static boolean nyertesVizsgalo(String[][] tabla, String jel) {

        boolean nyertes = false;
        String[][] matrix = tabla;
        int nyero = 0;
        System.out.println(jel);
        if (matrix.length <= 5) {
            nyero = 3;
        }
        if (matrix.length > 5) {
            nyero = 5;
        }
//vízszintes sorok vizsgálata       
        for (int i = 0; i < matrix.length; i++) {
            int talalat = 0;
            for (int j = matrix.length - 1; j >= 0; j--) {

                if (matrix[i][j] == jel) {
                    talalat = 1;
                    nyertes = true;
                }
                while (talalat < nyero && j - 1 >= 0 && nyertes) {
                    if (j - talalat >= 0 && matrix[i][j - talalat] == jel) {
                        nyertes = true;
                        talalat++;
                        if (nyertes && talalat == nyero) {
                            eredmenyHirdetes(jel);
                        }

                    } else {
                        nyertes = false;
                        talalat = 0;
                    }
                }
            }
        }
//Függőleges sorok vizsgálata
        nyertes = false;
        for (int i = 0; i < matrix.length; i++) {
            int talalat = 0;
            for (int j = matrix.length - 1; j >= 0; j--) {

                if (matrix[j][i] == jel) {
                    talalat = 1;
                    nyertes = true;
                }
                while (talalat < nyero && j - 1 >= 0 && nyertes) {
                    if (j - talalat >= 0 && matrix[j - talalat][i] == jel) {
                        nyertes = true;
                        talalat++;
                        if (nyertes && talalat == nyero) {
                            eredmenyHirdetes(jel);
                        }
                    } else {
                        nyertes = false;
                        talalat = 0;
                    }
                }
            }
        }
//átlók vizsgálata jobbról balra           
        nyertes = false;
        int talalat = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix.length - 1; j >= 0; j--) {

                if (matrix[j][i] == jel) {
                    talalat = 1;
                    nyertes = true;
                }
                while (talalat < nyero && i - 1 >= 0 && j - 1 >= 0 && nyertes) {
                    if (j - talalat >= 0 && i - talalat >= 0 && matrix[j - talalat][i - talalat] == jel) {
                        nyertes = true;
                        talalat++;
                        if (nyertes && talalat == nyero) {
                            eredmenyHirdetes(jel);
                        }
                    } else {
                        nyertes = false;
                        talalat = 0;
                    }
                }
            }
        }
// átlók vizsgálata balról jobbra
        nyertes = false;
        talalat = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == jel) {
                    talalat = 1;
                    nyertes = true;
                }
                while (talalat < nyero && i - 1 >= 0 && j + talalat < matrix.length && nyertes) {
                    if (j - talalat >= 0 && matrix[i - talalat][j + talalat] == jel) {
                        nyertes = true;
                        talalat++;
                        if (nyertes && talalat == nyero) {
                            eredmenyHirdetes(jel);
                        }
                    } else {
                        nyertes = false;
                        talalat = 0;
                    }
                }
            }
        }
        if (talalat != 3) {
            nyertes = false;
        }
        return nyertes;
    }
    /**
     * Az eredmenyHirdetes függvény a kapott jel String alapján
     * gratulál a nyertes játékosnak, és lehetőséget ad egy új játék indítására
     *
     * @param jel
     */
    public static void eredmenyHirdetes(String jel) {
        if (jel == "O") {
            System.out.println("Gratulálok " + jatekosO + ", nyertél!");
        } else {
            System.out.println("Gratulálok " + jatekosX + ", nyertél!");
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Akarsz még játszani?");
        System.out.println("Igen: 1.)");
        System.out.println("Nem: 2.)");
        int visszaVago = sc.nextInt();
        switch (visszaVago) {
            case 1:
                jatekStart();
                break;
            default:
                System.out.println("Viszlát!");
                System.exit(0);
        }
    }
    /**
     * A jatekStart függvényben történik a szükséges függvények hívása,
     * a játék levezénylése
     *
     * @param args
     */
    public static void jatekStart() {

        int t = palyaValaszto();
        String[][] tabla = new String[t][t];
        tablaRajzolo(tabla);
        int jatekosSorszam = 1;
        String jatekos = jatekosX;
        String jel = "";
        do {
            if (jatekosSorszam % 2 == 1) {
                jatekos = jatekosO;
                jel = "O";
            } else {
                jatekos = jatekosX;
                jel = "X";
            }

            String beirt = lepesBekero(jatekos);
            lepesAtalakito(beirt);
            int sor = lepesSor(lepesAtalakito(beirt));
            int oszlop = lepesOszlop(lepesAtalakito(beirt));
            if (tabla[sor][oszlop] != " ") {
                System.out.println("Hibás lépés!");
                beirt = lepesBekero(jatekos);
                lepesAtalakito(beirt);
                sor = lepesSor(lepesAtalakito(beirt));
                oszlop = lepesOszlop(lepesAtalakito(beirt));
                if (jatekosSorszam % 2 == 1) {
                    jel = "O";
                    tabla[sor][oszlop] = jel;
                    tablaRajzolo(tabla);
                } else {
                    tabla[sor][oszlop] = jel;
                    tablaRajzolo(tabla);
                }
            } else if (jatekosSorszam % 2 == 1) {
                jel = "O";
                tabla[sor][oszlop] = jel;
                tablaRajzolo(tabla);
            } else {
                tabla[sor][oszlop] = jel;
                tablaRajzolo(tabla);
            }
            jatekosSorszam++;

        } while (!nyertesVizsgalo(tabla, jel));
    }

    /**
     * A main függvény indítja az amőba játékot
     *
     * @param args
     */
    public static void main(String[] args) {
        jatekStart();
    }
}
