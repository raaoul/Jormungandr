package commandPackage;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GIFListener extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String msg = event.getMessage().getContentRaw();
		EmbedBuilder GIF = new EmbedBuilder();
		EmbedBuilder GIFList = new EmbedBuilder();
		GIF.setColor(Color.WHITE);
		GIFList.setColor(Color.WHITE);
		
		/*				=== GIF URLs NOTES ===
		 * 
		 *  USE RAW URLs INSIDE ".SetImage()" PARAMS!
		 *  IF IT'S FROM GIPHY MAKE SURE THE URL IS FROM "media.giphy.com"!
		 *   > SEE "+hello" FOR EXAMPLE!
		 */
		
		if (msg.equalsIgnoreCase("+gif list")) {
			
			//	don't forget to add new field after you add new GIF under this if scope.
			GIFList.setTitle("Here's the list of available GIF!");
			GIFList.addField("Hello there!", "+hello", true);
			GIFList.addField("I'm Pickle Rick!", "+picklerick", true);
			GIFList.addField("That's a penis!", "+penis", true);		
			
			event.getChannel().sendMessage(GIFList.build()).queue();
			
		} else if (msg.equalsIgnoreCase("+hello")) {
			
			//	https://media.giphy.com/media/Nx0rz3jtxtEre/giphy.gif
			GIF.setTitle("Hello There!");
			GIF.setImage("https://media.giphy.com/media/Nx0rz3jtxtEre/giphy.gif");
			event.getChannel().sendMessage(GIF.build()).queue();
			
		} else if (msg.equalsIgnoreCase("+picklerick")) {
			
			//	https://media1.giphy.com/media/9zXWAIcr6jycE/giphy.gif
			GIF.setTitle("I'm Pickle Rick!");
			GIF.setImage("https://media1.giphy.com/media/9zXWAIcr6jycE/giphy.gif");
			event.getChannel().sendMessage(GIF.build()).queue();
			
		} else if (msg.equalsIgnoreCase("+penis")) {
			
			//	https://media.giphy.com/media/EzVPnZABeepdC/giphy.gif
			GIF.setTitle("That's a penis!");
			GIF.setImage("https://media.giphy.com/media/EzVPnZABeepdC/giphy.gif");
			event.getChannel().sendMessage(GIF.build()).queue();
		}
	}
}
	
