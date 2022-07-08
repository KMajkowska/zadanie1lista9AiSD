import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		BST tree = new BST();
		main.program(tree);
	}
	
	public void program(BST tree)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Co chcesz zrobiæ? Wpisz prosze odpowiedni numer z wyœwietlanego menu:");
		char odp;
		int choice;
		do {
			menu();
			choice = scan.nextInt();
			switch(choice)
			{
			case 1:
			{
				char tmp;
				do {
					System.out.println("Podaj element do wstawienia");
					float elem = scan.nextFloat();
					tree.insert(elem);
					System.out.println("Chcesz dalej dodawaæ elementy? [t/n]");
					tmp = scan.next().charAt(0);
				}while(tmp == 't');
				break;
			}
			case 2:
			{
				char tmp;
				do {
					System.out.println("Podaj element do usuniêcia");
					float elem = scan.nextFloat();
					tree.delete(elem);
					System.out.println("Chcesz dalej usuwaæ elementy?[t/n]");
					tmp = scan.next().charAt(0);
				}while(tmp == 't');
				break;
			}
			case 3:
			{
				char tmp;
				do {
					System.out.println("Podaj element do sprawdzenia");
					float elem = scan.nextFloat();
					System.out.println(tree.search(elem));
					System.out.println("Chcesz dalej sprawdzaæ elementy?");
					tmp = scan.next().charAt(0);
				}while(tmp == 't');
				break;
			}
			case 4:
			{
				tree.simpleDraw();
				break;
			}
			case 5:
			{
				char tmp;
				do {
					System.out.println("Podaj element, wzglêdem którego bêdziemy szukaæ");
					float elem = scan.nextFloat();
					System.out.println(tree.findGT(elem));
					System.out.println("Chcesz dalej szukaæ?");
					tmp = scan.next().charAt(0);
				}while(tmp == 't');
				break;
			}
			case 6:
			{
				char tmp;
				do {
					System.out.println("Podaj przedzia³, najpierw min, potem max");
					float min = scan.nextFloat();
					float max = scan.nextFloat();
					Float [] array = tree.findInInterval(min, max);
					for(int i=0; i<array.length; i++)
						System.out.print(array[i] + " ");
					System.out.println("Chcesz dalej szukaæ?");
					tmp = scan.next().charAt(0);
				}while(tmp == 't');
				break;
			}
			case 7:
			{
				tree.inorder();
				break;
			}
			case 8:
			{
				tree.preorder();
				break;
			}
			case 9:
			{
				tree.postorder();
				break;
			}
			case 10:
			{
				System.out.println(tree.findMax());
				break;
			}
			case 11:
			{
				System.out.println(tree.findMin());
				break;
			}
			case 12:
			{
				tree.clear();
				break;
			}
			}
			System.out.println("Czy chcesz wykonac jeszcze jakies operacje na drzewie?[t/n]");
			odp = scan.next().charAt(0);
		}while(odp == 't');
	}
	
	public void menu()
	{
		System.out.println("Dostêpne operacje:");
		System.out.println("1.Dodaj element do drzewa (powtórzenie wartoœci nie doda elementu do drzewa)");
		System.out.println("2.Usuñ element z drzewa");
		System.out.println("3.Sprawdz czy element jest w drzewie");
		System.out.println("4.Narysuj drzewo");
		System.out.println("5.Znajdz najmniejszy element wiekszy od podanej przez Ciebie wartosci");
		System.out.println("6.Wyswietl tablice elementow w drzewie z danego przedzia³u");
		System.out.println("7.Wyswietl elementy drzewa w kolejnosci inorder");
		System.out.println("8.Wyswietl elementy drzewa w kolejnosci preorder");
		System.out.println("9.Wyswietl elementy drzewa w kolejnosci postorder");
		System.out.println("10.Wyswietl najwiekszy element w drzewie");
		System.out.println("11.Wyswietl najmniejszy element w drzewie");
		System.out.println("12.Wyczysc drzewo");
	}

}
