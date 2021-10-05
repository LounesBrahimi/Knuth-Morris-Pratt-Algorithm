package daartme2;

import java.util.ArrayList;

public class KmpAlgorithm {

	private String regEx;
	private String text;
	private ArrayList<String> Factor;
	private ArrayList<Integer> CarryOver;
	
	public void generateFunctor() {
		this.Factor = new ArrayList<String>();
		for (int i = 0; i < regEx.length(); i++) {
			this.Factor.add("" + regEx.charAt(i));
		}
	}
	
	public ArrayList<Integer> getCarryOver(){
		return this.CarryOver;
	}
	
	public ArrayList<String> getFirstPart(int indice) {
		ArrayList<String> firstPart = new ArrayList<String>();
		for (int i = 0; i < indice; i++) {
			firstPart.add(this.Factor.get(i));
		}
		return firstPart;
	}
	
	public String getSuffixFromN(String s, int n) {
		int length = s.length();
		String result = s.substring(length-n,length);
		return result;
	}
	
	public String listToString(ArrayList<String> s) {
		String result = "";
		for (int i = 0; i < s.size(); i++) {
			result = result.concat(s.get(i));
		}
		return result;
	}
	
	public boolean isPreffix(String chaine, String suffix) {
		return chaine.startsWith(suffix);
	}
	
	public int getLengthLongestProperSuffixPreffix(ArrayList<String> s) {
		String chaine = listToString(s);
		for (int i = chaine.length()-1; i > 0 ; i--) {
			String suffix = getSuffixFromN(chaine, i);
			if (isPreffix(chaine, suffix)) {
				return suffix.length();
			}
		}
		return 0;
	}
	
	public void generateCarryOver() {
		this.CarryOver = new ArrayList<Integer>();
		this.CarryOver.add(-1);
		for (int i = 1; i < this.regEx.length(); i++) {
			ArrayList<String> firstPart = getFirstPart(i);
			if (firstPart.size() == 1) {
				this.CarryOver.add(0);
			} else {
				int value = getLengthLongestProperSuffixPreffix(firstPart);
				this.CarryOver.add(value);
			}
		}
		
		for (int i = 1; i < this.Factor.size(); i++) {
			if ((this.Factor.get(i).equals(this.Factor.get(0)))
					&& (this.CarryOver.get(i) == 0)) {
				this.CarryOver.set(i, -1);
			}
		}
		
		for (int i = 0; i < this.Factor.size(); i++) {
			if ( (this.CarryOver.get(i) != -1) 
					&&	(this.Factor.get(i).equals(this.Factor.get(this.CarryOver.get(i))))){
				this.CarryOver.set(i, this.CarryOver.get(this.CarryOver.get(i)));
			}
		}
		
		this.CarryOver.add(0);
	}
	
	public ArrayList<String> getFactor(){
		return this.Factor;
	}
	
	public KmpAlgorithm(String regEx) {
		this.regEx = regEx;
	}
}
