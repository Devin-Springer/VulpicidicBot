package vulpecidic.discordbot;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;

public class Main {
	
	private static String token = "";

	public static void main(String[] args) {
		DiscordAPI api = Javacord.getApi(token, true);
		MessageListener myListener = new MessageListener();
		api.registerListener(myListener);
		api.connectBlocking();
	}
}
