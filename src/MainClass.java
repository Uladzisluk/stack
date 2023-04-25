import java.util.ArrayList;
import java.util.Scanner;
import My.Stos;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mode = 3;
		ArrayList<Stos> stos = new ArrayList<Stos>();
		while (mode != 0) {
			System.out.println("If you want to create stack enter \"1\"\nIf you want to exit enter \"0\"");
			System.out.println("\"2\" - Watch a list of stacks\n\"3\" - Delete stack\n\"4\" - Open stack");
			mode = sc.nextInt();
			switch (mode) {
			case 0: break;
			case 1:{
				Clear.clearScreen();
				Stos nowy = new Stos();
				System.out.println("What will the name of your stack?");
				String name = sc.next();
				while (true) {
					int o = 0;
					for (int i = stos.size()-1; i>-1; i--) {
						if (stos.get(i).nazwa.equals(name)) o = 1;
					}
					if (o==1) {
						System.out.println("Please enter another name");
						name = sc.next();
					}else break;
				}
				stos.add(nowy);
				stos.get(stos.size()-1).nazwa=name;
				break;
			}
			case 2:{
				Clear.clearScreen();
				if (stos.size()==0) System.out.println("Stack is free");
				else {
					for (int i = stos.size()-1; i>-1; i--) {
						System.out.println("- "+stos.get(i).nazwa);
					}
				}
				break;
			}
			case 3:{
				Clear.clearScreen();
				int wb = -1;
				System.out.println("Which stack do you want to delete?");
				String wybor = sc.next();
				for (int i = stos.size()-1; i>-1; i--) {
					if (stos.get(i).nazwa.equals(wybor)) wb = i;
				}
				if (wb != -1) stos.remove(wb);
				else System.out.println("There is no stack of this name");
				break;
			}
			case 4:{
				Clear.clearScreen();
				int wb = -1;
				int mode1 = -1;
				System.out.println("Which stack do you want to open?");
				String wybor = sc.next();
				for (int i = stos.size()-1; i>-1; i--) {
					if (stos.get(i).nazwa.equals(wybor)) wb = i;
				}
				if (wb!=-1) {
					Clear.clearScreen();
					System.out.println("1 - inicializate stack\n2 - Push number to stack\n3 - Pop last number from stack\n4 - Is stack full?\n5 - Is stack free?\n6 - Watch numbers in stack");
					mode1 = sc.nextInt();
					switch (mode1) {
					case 1:{
						Clear.clearScreen();
						System.out.println("What is the size of stack?");
						stos.get(wb).init(sc.nextInt());
						break;
					}
					case 2:{
						Clear.clearScreen();
						System.out.println("What number do you want to push?");
						stos.get(wb).push(sc.nextInt());
						break;
					}
					case 3:{
						System.out.println(stos.get(wb).pop());
						break;
					}
					case 4:{
						if (stos.get(wb).isFull()==true) {
							System.out.println("Stack is full");
						}
						else System.out.println("Stack isn't full");
						break;
					}
					case 5:{
						if (stos.get(wb).isFree()==true) {
							System.out.println("Stack is free");
						}
						else System.out.println("Stack isn't free");
						break;
					}
					case 6:{
						Clear.clearScreen();
						for (int i = stos.get(wb).tab.length -1; i>-1; i--) {
							System.out.println(stos.get(wb).tab[i]);
						}
						break;
					}
				}
				}
				else System.out.println("There is no stack of this name");
				break;
			}
			}
		}
		sc.close();
	}
}

class Clear{
	public static void clearScreen() {
		System.out.println(new String(new char[50]).replace("\0", "\r\n"));
	}
}