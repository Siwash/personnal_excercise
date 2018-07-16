package rpf.test;

public class InitClass {
		static {
			System.out.println("static block");
		}
		{
			System.out.println("public block");
		}
		public InitClass() {
			System.out.println("constructor");
		}
		public static void main(String[] args) {
			System.out.println("1");
			new Outclass();
			System.out.println("2");
		}
}
class Outclass{
	static {
		System.out.println("outclass");
	}
	{
		System.out.println("OUT block");
	}
	public Outclass() {
		System.out.println(5555);
	}
}