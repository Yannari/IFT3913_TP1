package lcsec;

public class Class{

	private String name;
	private int coupling;
	public Class(String name){
		this.name = name;
		this.coupling = 0;
	}

	public String getName() {
		return this.name;
	}

	public void increCoupling() {
		this.coupling+=1;
	}

	public int getCoupling() {
		return this.coupling;
	}
}
