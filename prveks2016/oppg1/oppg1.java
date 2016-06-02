interface Q {}

interface QA extends Q {}

class QK implements Q,G {}

class QAB implements QA,G {}

class QAC implements QA {}

class QABC extends QAB {}

interface G {}

class oppg1 {
	public static void main(String[] args) {
		Q[] objekter = new Q[5];

		QABC abc = new QABC();
		QAB ab2 = abc;
		QA a3 = abc;
		G g3 = abc;
		objekter[0] = abc;

		QAC ac = new QAC();
		QA a2 = ac;
		objekter[1] = ac;

		QAB ab1 = new QAB();
		G g2 = ab1;
		QA a1 = ab1;
		objekter[2] = ab1;

		QK k = new QK();
		Q q1 = k;
		objekter[3] = k;

		objekter[4] = null;
	}
}
