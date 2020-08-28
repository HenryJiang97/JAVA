import java.util.*;

class human {
	String name;
	int age;
	boolean sex;

	public human(String name, int age, boolean sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
}

class male extends human {
	public male(String name, int age) {
		super(name, age, true);
	}
}

class Main {
	public static void main(String[] args) {
		human a = new human("Henry", 22, true);

		System.out.println(a.name);
	}
}