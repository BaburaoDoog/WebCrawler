import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	List<String> titles = new ArrayList<>();
	Set<String> urlVisited = new HashSet<String>();

	public String my_site;

	public int count = 1;
	public int count1 = 2;

	public void getLinks(String startURL) throws IOException {
		Document doc = Jsoup.connect(startURL).get();

		Elements links = doc.select("a[href]");

		if (links.isEmpty()) {
			return;

		}
		int NoOfLinks = doc.select("a[href]").size();

		String title = doc.title();
		titles.add(title);

		System.out.println();
		System.out.println();

		System.out.println("number of links  " + NoOfLinks + "  " + "Page No: " + increment());
		System.out.println("Title : " + title);
		int j = 1;
		Elements Doctors = doc.getElementsByTag("h3");
		
		for (Element link : links) {

			System.out.println("Links " + j++ + " " + link.attr("href"));
			// System.out.println("Text "+link.text());
		}
		if(Doctors.text().startsWith("Dr.")) {
			System.out.println("No of Doctors in this url "+Doctors.size());
		
		int i=1;
		for (Element doctor : Doctors) {
			if(doctor.text().startsWith("Dr.")) {
			System.out.println("Doctors : " + i++ + "  " + doctor.text());
			}
		}
		}else {
			System.out.println("No of Doctors in this url 0");
		}
		links.stream().map((link) -> link.attr("abs:href")).forEachOrdered((this_url) -> {

			boolean add = urlVisited.add(this_url);
			if (add && this_url.contains(my_site)) {
				System.out.println("\n\n\n" + this_url + " Page No:  " + increment1());

				try {
					getLinks(this_url);
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		});

	}

	public int increment() {
		return count++;

	}

	public int increment1() {
		return count1++;

	}
public void print(){
		System.out.println("this is new changes");
}

}
