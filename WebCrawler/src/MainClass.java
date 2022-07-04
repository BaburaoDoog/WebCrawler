import java.io.IOException;



public class MainClass {

	public static void main(String[] args) throws IOException {
		Crawler crawler=new Crawler();
		crawler.my_site="ayu.health";
		crawler.getLinks("https://ayu.health");
	}
	public int increment() {
		return count++;

	}

	public int increment1() {
		return count1++;

	}

}
