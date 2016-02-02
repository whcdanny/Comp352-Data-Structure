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

	private static final double EXPANSION_THRESHOLD = 0.8;
	private static final int EXPANSION_CONSTANT = 10;
	private static final int EXPANSION_FACTOR = 2;
	private int listSize;
	public Position[] array;
	private char expansionRule;

	public NodeList() {
		listSize = 0;
		array = new Position[EXPANSION_CONSTANT];
		expansionRule = 'd';
	}

	public Position first() {
		if (listSize == 0)
			System.err.println("error, your mother is too fat");
		return array[0];
	}

	public Position last() {
		if (listSize == 0)
			System.err.println("error, your mother is too fat");
		return array[listSize - 1];
	}

	public Position prev(Position p) {
		if (p == array[0])
			System.err.println("error, your mother is too fat");
		return array[p.index - 1];
	}

	public Position next(Position p) {
		if (p == array[listSize - 1])
			System.err.println("error, your mother is too fat");
		return array[p.index + 1];
	}

	public int set(Position p, int e) {
		array[p.index] = new Position(e, p.index);
		return p.element();
	}

	public Position addFirst(int e) {
		if ((double) listSize / array.length >= EXPANSION_THRESHOLD)
			expandArray();
		for (int i = (listSize - 1); i >= 0; i--) {
			array[i].index += 1;
			array[i + 1] = array[i];
		}
		array[0] = new Position(e, 0);
		listSize++;
		return array[0];
	}

	public Position addLast(int e) {
		if ((double) listSize / array.length >= EXPANSION_THRESHOLD)
			expandArray();
		array[listSize] = new Position(e, listSize);
		listSize++;
		return array[listSize - 1];
	}

	public Position addBefore(Position p, int e) {
		if ((double) listSize / array.length >= EXPANSION_THRESHOLD)
			expandArray();
		int insertionIndex = p.index;
		for (int i = (listSize - 1); i >= insertionIndex; i--) {
			array[i].index += 1;
			array[i + 1] = array[i];
		}
		array[insertionIndex] = new Position(e, insertionIndex);
		listSize++;
		return array[p.index];
	}

	public Position addAfter(Position p, int e) {
		if ((double) listSize / array.length >= EXPANSION_THRESHOLD)
			expandArray();
		for (int i = (listSize - 1); i > p.index; i--) {
			array[i].index += 1;
			array[i + 1] = array[i];
		}
		array[p.index] = new Position(e, p.index);
		listSize++;
		return array[p.index];
	}

	public int delete(Position p) {
		for (int i = p.index; i < listSize; i++) {
			array[i + 1].index -= 1;
			array[i] = array[i + 1];
		}
		listSize--;
		array[listSize] = null;
		return p.element();
	}

	public void swap(Position p1, Position p2) {
		int temp = p1.element();
		array[p1.index] = new Position(p2.element(), p1.index);
		array[p2.index] = new Position(temp, p2.index);
	}

	public void truncate() {
		Position[] temp = array;
		array = new Position[listSize];
		for (int i = 0; i < listSize; i++) {
			array[i] = temp[i];
		}
	}

	public void SetExpansionRule(char expansionRule) {
		if (expansionRule == 'd' || expansionRule == 'c')
			this.expansionRule = expansionRule;
		else
			System.err.println("Invalid input. Expansion rule was not changed");
	}

	private void expandArray() {
		Position[] temp = array;
		switch (expansionRule) {
			case 'd':
				array = new Position[temp.length * EXPANSION_FACTOR];
				break;
			case 'c':
				array = new Position[temp.length + EXPANSION_CONSTANT];
				break;
			default:
				break;
		}

		for (int i = 0; i < listSize; i++)
			array[i] = temp[i];
	}
}
