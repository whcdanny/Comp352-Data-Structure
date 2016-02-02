public class NodeList {

	public class Position {
		
		private int element;
		public int index;
		
		public Position() {
			element = 0;
			index = 0;
		}

		public Position(int element, int index) {
			this.element = element;
			this.index = index;
		}

		public int element() {
			return element;
		}
	}

	private int size;
	private Position[] a;
	private char expansionRule;

	public NodeList() {
		size = 0;
		expansionRule = 'd';
		a = new Position[10];
	}

	public Position first() {
		if (size == 0)
			System.out.println("error, your mother is too fat");
		return a[0];
	}

	public Position last() {
		if (size == 0)
			System.out.println("error, your mother is too fat");
		return a[size - 1];
	}

	public Position prev(Position p) {
		if (p == a[0])
			System.out.println("error, your mother is too fat");
		return a[p.index - 1];
	}

	public Position next(Position p) {
		if (p == a[size - 1])
			System.out.println("error, your mother is too fat");
		return a[p.index + 1];
	}

	public int set(Position p, int e) {
		a[p.index] = new Position(e, p.index);
		return p.element();
	}

	public Position addFirst(int e) {
		if ((double) size / a.length >= 0.8)
			expanda();
		for (int i = (size - 1); i >= 0; i--)
			a[i + 1] = new Position(a[i].element(), i + 1);
		a[0] = new Position(e, 0);
		size++;
		return a[0];
	}

	public Position addLast(int e) {
		if ((double) size / a.length >= 0.8)
			expanda();
		a[size] = new Position(e, size);
		size++;
		return a[size - 1];
	}

	public Position addBefore(Position p, int e) {
		if ((double) size / a.length >= 0.8)
			expanda();
		int index = p.index;
		for (int i = (size - 1); i >= index; i--)
			a[i + 1] = new Position(a[i].element(), i + 1);
			
		a[index] = new Position(e, index);
		size++;
		return a[p.index];
	}

	public Position addAfter(Position p, int e) {
		if ((double) size / a.length >= 0.8)
			expanda();
		for (int i = (size - 1); i > p.index; i--) 
			a[i + 1] = new Position(a[i].element(), i + 1);
		a[p.index + 1] = new Position(e, p.index + 1);
		size++;
		return a[p.index];
	}

	public int delete(Position p) {
		for (int i = p.index; i < (size-1); i++) 
			a[i] = new Position(a[i + 1].element(), i);
		size--;
		a[size] = null;
		return p.element();
	}

	public void swap(Position p1, Position p2) {
		int temp = p1.element();
		a[p1.index] = new Position(p2.element(), p1.index);
		a[p2.index] = new Position(temp, p2.index);
	}

	public void truncate() {
		Position[] temp = a;
		a = new Position[size];
		for (int i = 0; i < size; i++) {
			a[i] = temp[i];
		}
	}

	public void SetExpansionRule(char expansionRule) {
		this.expansionRule = expansionRule;
	}

	private void expanda() {
		Position[] temp = a;
		if(expansionRule == 'd')
			a = new Position[temp.length * 2];
		else
			a = new Position[temp.length + 10];
		for (int i = 0; i < size; i++)
			a[i] = temp[i];
	}
}
