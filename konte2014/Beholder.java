public class Beholder {
	class Node {
		private Object obj;
		private Node neste;

		public Node(Object obj) {
			if (obj == null)
				System.err.println("NULL");

			this.obj = obj;
		}

		public Node hentNeste() {
			return neste;
		}
	}

	public Beholder() {
	}
}
