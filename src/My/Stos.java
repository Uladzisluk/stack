package My;

public class Stos {
		public String nazwa;
		int wierzch, rozmiar;
		public int[] tab;
		public Stos(){
			wierzch = -1;
		}
		public void init(int rozmiar) {
			this.rozmiar = rozmiar;
			tab = new int[rozmiar];
		}
		public void push(int liczba) {
			tab[++wierzch]=liczba;
		}
		public int pop(){
			return tab[wierzch--];
		}
		public boolean isFull() {
			return wierzch==rozmiar-1;
		}
		public boolean isFree() {
			return wierzch==-1;
		}
}
