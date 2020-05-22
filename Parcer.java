import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class Parcer {

    private static Document getPage() throws IOException {
        String url = "https://ru.wikipedia.org/wiki/%D0%A1%D0%BB%D1%83%D0%B6%D0%B5%D0%B1%D0%BD%D0%B0%D1%8F:%D0%A1%D0%BB%D1%83%D1%87%D0%B0%D0%B9%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0";

        //String url = "https://ru.wikipedia.org/wiki/%D0%A4%D0%B8%D0%BB%D0%BE%D1%81%D0%BE%D1%84%D0%B8%D1%8F";
        Document page = Jsoup.parse(new  URL(url), 10000);
        return page;
       }
    public static void main(String[] args) throws IOException {
        Document page = getPage();
        //css query language

        Elements body = page.select("body");
        /*Elements content = body.select("div[class=mv-body]");*/
        Elements articles = body.select("h1[class=firstHeading]");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(articles.text());
        try(FileWriter writer = new FileWriter("articles.txt", true))
        {
            // запись всей строки
            String text = articles.text();
            writer.write(text+","+" ");
            writer.flush();
        }
        for (Element article : articles){
                String header = article.select("h1[class=firstHeading]").text();
                while (true)
                {
                    String s = header;
                    if (s.equals("Философия"))
                        break;

                String h[] = new String[3];
                h[0] = s;
                /*h[1] = s;
                h[2] = s;*/
                for (int i = 0; i < 4; i++) {
                    System.out.println(h[i]);
                }
                }
                }


                System.out.println(arrayList);
            }

    }

