import java.util.Date;
public class Code {
    
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        String guest = String.format("Hello, %s. Lovely to see you.", name);
        return guest;
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "It is currently: " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if (conversation.indexOf("Alexis") > -1) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        if (conversation.indexOf("Alfred") > -1) {
            return "At your service. As you wish, naturally.";
        }
        return "Right. And with that I shall retire.";
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

