package daartme2;

public class Main {

	public static void main(String[] args) {
		String regEx = "mami";
		String text = "maman mami hello\n alors mami mama\n not this sentance";
		KmpAlgorithm kmp = new KmpAlgorithm(regEx, text);
		kmp.generateFunctor();
		kmp.generateCarryOver();
		System.out.println(kmp.getFactor());
		System.out.println(kmp.getCarryOver());
		System.out.println(kmp.search());
	}

}
