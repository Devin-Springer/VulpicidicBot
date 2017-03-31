package vulpecidic.discordbot;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.*;

public class MessageListener implements MessageCreateListener, MessageDeleteListener {

	public void onMessageCreate(DiscordAPI api, Message message) {
		String contentsOfMessage = message.getContent();
		if (message.getAuthor().isBot()) return;				//don't respond to bots
		if (contentsOfMessage.equalsIgnoreCase("!help")) {
			message.reply(ChatCommands.getListOfCommands());
		}
		if (contentsOfMessage.equalsIgnoreCase("!coin")) {
			message.reply(ChatCommands.coinFlipper());
		}
		if ((message).getContent().contains("!roll")) {
			message.reply(ChatCommands.diceRoll(message.getContent()));	
		}
	}

	public void onMessageDelete(DiscordAPI api, Message message) {
		message.reply("You can't hide the truth, " + message.getAuthor());
	}

}
