package daartme2;

public class Main {

	public static void main(String[] args) {
		String regEx = "mamamia";
		String text = "maman mamé mia ! mm maaah !";
		KmpAlgorithm kmp = new KmpAlgorithm(regEx);
		kmp.generateFunctor();
		kmp.generateCarryOver();
		System.out.println(kmp.getFactor());
		System.out.println(kmp.getCarryOver());
		String regEx2 = "chicha";
		KmpAlgorithm kmp1 = new KmpAlgorithm(regEx2);
		kmp1.generateFunctor();
		kmp1.generateCarryOver();
		System.out.println(kmp1.getFactor());
		System.out.println(kmp1.getCarryOver());
		String regEx3 = "Sargon";
		KmpAlgorithm kmp2 = new KmpAlgorithm(regEx3);
		kmp2.generateFunctor();
		kmp2.generateCarryOver();
		System.out.println(kmp2.getFactor());
		System.out.println(kmp2.getCarryOver());
	}

}
