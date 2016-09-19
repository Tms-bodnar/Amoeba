import java.util.*;


	/**
	 *
	 * @author bodnart
	 */
	public class Amoeba {

		/**
		 * A palyaValaszto függvény bekéri, mekkora pályán játszunk, és visszaadja
		 * ezt az értéket int-ként.
		 * @return int tablameret
		 */

		public static String nevBekero(String szoveg){
			Scanner sc = new Scanner(System.in);
			System.out.println(szoveg);
			String nev = sc.nextLine();
			return nev;
		}

		public static int palyaValaszto() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Mekkora pályán akarsz játszani? Minimum méret 3, maximum 12.");
			System.out.println("A győzelemhez 5x5-ös pályaméret alatt 3 jel,");
			System.out.println("felette 5 jel szükséges egy vonalban vagy átlóban.");
			int tablaMeret = sc.nextInt();
			return tablaMeret;
		}

		/**
		 * A palyaRajzolo rajzolja ki a táblát és benne a lépéseket
		 *
		 * @param t a tábla mérete
		 * @return String[][] matrix
		 */

		public static String[][] palyaRajzolo(int t){

			String[][] matrix = new String[t][t];
			String[] fuggBetu = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
//üres pálya felrajzolása:
			//A cellák kitöltése

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					matrix[i][j] = " ";
				}
			}
			//A tábla oszlopok számozása
			for (int i = 0; i < 1; i++) {
				for (int k = 0; k < matrix[i].length; k++) {
					if (k == 0){
						System.out.print(" ");
					}
					if (k >= 9){
						System.out.print("  "+ (k + 1) + "");
					}else{
						System.out.print("  " + (k + 1) + " ");
					}
				}
				System.out.println();
			}
			//A tábla első vízszintes sorai
			for (int i = 0; i < matrix.length; i++) {
				for (int k = 0; k < matrix[i].length; k++) {
					if (k == 0){
						System.out.print(" ");
					}
					System.out.print("+---");
				}
				// A tábla sorok betűjelei   
				System.out.println("+");
				for (int k = 0; k < matrix[i].length; k++) {
					if (k == 0){
						System.out.print(fuggBetu[i]);
					}
					System.out.print("| " + matrix[i][k] + " ");
				}
				System.out.println("|");
			}
			//A tábla legalsó sora
			for (int i = 0; i < 1; i++) {
				for (int k = 0; k < matrix[i].length; k++) {
					if(k == 0){
						System.out.print(" ");
					}
					System.out.print("+---");
				}
				System.out.print("+");
			}
			System.out.println();   
			return matrix;
		}
		/**
		 *A lepesBekero beolvassa a következő lépést, és viszaadja egy Stringként
		 * @param 
		 * @return String beirt
		 */
		public static String lepesBekero(String nev) {
			Scanner sc = new Scanner(System.in);
			System.out.println(nev +", lépj egy mezőre!");
			System.out.println("Előszőr a sort, majd az oszlopot: (pl:A2, b3, stb...)");
			String beirt = sc.nextLine();
			if (Character.isLowerCase(beirt.charAt(0))){
				String beirtNagy = beirt.toUpperCase();
				beirt = beirtNagy;
			}
			return beirt;
		}
		/**
		 *
		 * A lepesAtalakito a lépés első betűjét számmá alakítja, majd
		 * visszaadja int tömbként
		 * @param beirt
		 * @return int[] lepes
		 */

		public static int[] lepesAtalakito(String beirt){

			int [] lepes = new int[2];
			char[] fuggBetu = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'};
			lepes[1] = Character.getNumericValue(beirt.charAt(1));
			for (int i = 0; i < fuggBetu.length; i++){
                if( beirt.charAt(0) == fuggBetu[i]){
					lepes[0] = (i);
				}
			}
			return lepes;
		}

		public static int lepesSor(int[] lepes){
			int sor = lepes[0];
			return sor;
		}

		public static int lepesOszlop(int[] lepes){
			int oszlop = lepes[1]-1;
			return oszlop;
		}

		public static void tablaRajzolo(String[][] tabla){

			String[][] matrix = tabla;
			String[] fuggBetu = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
//üres pálya felrajzolása:
			//A cellák kitöltése
			boolean foglalt = false;

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if(tabla[i][j] == "O" || tabla[i][j] == "X"){
						foglalt = true;
						}
						if(!foglalt){
						matrix[i][j] = " ";
					}
				}
			}

			//A tábla oszlopok számozása
			for (int i = 0; i < 1; i++) {
				for (int k = 0; k < matrix[i].length; k++) {
					if (k == 0){
						System.out.print(" ");
					}
					if (k >= 9){
						System.out.print("  "+ (k + 1) + "");
					}else{
						System.out.print("  " + (k + 1) + " ");
					}
				}
				System.out.println();
			}
			//A tábla első vízszintes sorai
			for (int i = 0; i < matrix.length; i++) {
				for (int k = 0; k < matrix[i].length; k++) {
					if (k == 0){
						System.out.print(" ");
					}
					System.out.print("+---");
				}
				// A tábla sorok betűjelei   
				System.out.println("+");
				for (int k = 0; k < matrix[i].length; k++) {
					if (k == 0){
						System.out.print(fuggBetu[i]);
					}
					System.out.print("| " + matrix[i][k] + " ");
				}
				System.out.println("|");
			}
			//A tábla legalsó sora
			for (int i = 0; i < 1; i++) {
				for (int k = 0; k < matrix[i].length; k++) {
					if(k == 0){
						System.out.print(" ");
					}
					System.out.print("+---");
				}
				System.out.print("+");
			}
			System.out.println();   
		}

		public static boolean nyertesO(String[][] tabla){
			boolean nyertesO = false;
			String[][] matrix = tabla;
			int nyero = 0;
			if (matrix.length <= 5){
				nyero = 3;
			}
			if (matrix.length > 5){
				nyero = 5;
			}

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j] == "O"){
						int x = 1;
						while(x < nyero && x + j < matrix.length){
							if(matrix[i][j + x] == "O"){
								nyertesO = true;
							}else
								nyertesO = false;
							x++;
						}
						if (nyertesO){
							System.out.println("Nyertél!");
							System.exit(0);
						}
						int y = 1;
						while(y < nyero && y + i < matrix.length){
							if(matrix[i + y][j] == "O"){
								nyertesO = true;
							}else
								nyertesO = false;
							y++;
						}
						if (nyertesO){
							System.out.println("Nyertél!");
							System.exit(0);
						}
						int z = 1;
						while( z < nyero && i - z >=0 && j - z >= 0 && i + z < matrix.length && j + z < matrix.length){
							if (matrix[i + z][j - z] == "O"|| matrix[i + z][j + z] == "O" ){
								nyertesO = true;
							}else
								nyertesO = false;
							z++;
						}
						if (nyertesO){
							System.out.println("Nyertél!");
							System.exit(0);
						}
					}
				}
			}
			return nyertesO;
		}
		public static boolean nyertesX(String[][] tabla){
			boolean nyertesX = false;
			String[][] matrix = tabla;
			int nyero = 0;
			if (matrix.length <= 5){
				nyero = 3;
			}
			if (matrix.length > 5){
				nyero = 5;
			}

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j] == "X"){
						int x = 1;
						while(x < nyero && x + j < matrix.length){
							if(matrix[i][j + x] == "X"){
								nyertesX = true;
							}else
								nyertesX = false;
							x++;
						}
						if (nyertesX){
							System.out.println("Nyertél!");
							System.exit(0);
						}
						int y = 1;
						while(y < nyero && y + i < matrix.length){
							if(matrix[i + y][j] == "X"){
								nyertesX = true;
							}else
								nyertesX = false;
							y++;
						}
						if (nyertesX){
							System.out.println("Nyertél!");
							System.exit(0);
						}
						int z = 1;
						while( z < nyero && i - z >=0 && j - z >= 0 && i + z < matrix.length && j + z < matrix.length){
							if (matrix[i + z][j - z] == "X"|| matrix[i + z][j + z] == "X" ){
								nyertesX = true;
							}else
								nyertesX = false;
							z++;
						}
						if (nyertesX){
							System.out.println("Nyertél!");
							System.exit(0);
						}
					}
				}
			}
			return nyertesX;
		}
		/**
		 * A main függvény indítja az amőba játékot
		 *
		 * @param args
		 */

		public static void main(String[] args) {


			String jatekosO = nevBekero("Első Játékos, 'O'-val leszel, add meg a neved: ");
			String jatekosX = nevBekero("Második Játékos, 'X'-el leszel, add meg a neved: ");
			int t = palyaValaszto();
			String[][] tabla = palyaRajzolo(t);
			int jatekosSorszam = 1;
			String jatekos = jatekosX;
                  do{
					  if(jatekosSorszam % 2 == 1){
						  jatekos = jatekosO;
					  }else{
						  jatekos = jatekosX;
					  }
					String beirt = lepesBekero(jatekos);
					lepesAtalakito(beirt);
					int sor = lepesSor(lepesAtalakito(beirt));
					int oszlop = lepesOszlop(lepesAtalakito(beirt));
					if (tabla[sor][oszlop]!= " "){
						System.out.println("Hibás lépés!");
						beirt = lepesBekero(jatekos);
						lepesAtalakito(beirt);
						sor = lepesSor(lepesAtalakito(beirt));
						oszlop = lepesOszlop(lepesAtalakito(beirt));
						if( jatekosSorszam % 2 ==1){
						tabla[sor][oszlop] = "O";
						tablaRajzolo(tabla);
						}else{
							tabla[sor][oszlop] = "X";
							tablaRajzolo(tabla);
						}
					}else{
						if( jatekosSorszam % 2 ==1){
							tabla[sor][oszlop] = "O";
							tablaRajzolo(tabla);
						}else{
							tabla[sor][oszlop] = "X";
							tablaRajzolo(tabla);
						}
					}
					jatekosSorszam++;

				}while(!nyertesO(tabla));
			}     
			
		
}
