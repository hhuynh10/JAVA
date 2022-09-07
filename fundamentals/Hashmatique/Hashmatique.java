import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public static void main (String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Happier" , "I wish you happiness");
        trackList.put("Better man" , "I wish you were a  better man");
        trackList.put("In the star" , "I wish you were dead");
        trackList.put("Traitor" , "I wish you were a traitor");

        String title = trackList.get("In the star");
        System.out.println(title);

        Set<String> lyrics = trackList.keyset();
        for (String lyric : lyrics) {
            System.out.println(lyric);
            System.out.println(trackList.get(lyric));
        }
    }
}