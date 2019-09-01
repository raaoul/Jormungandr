package commandPackage;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GIFMain extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String msg = event.getMessage().getContentRaw();
		EmbedBuilder GIF = new EmbedBuilder();
		GIF.setColor(Color.WHITE);
		
		/*				=== GIF URLs NOTES ===
		 * 
		 *  USE RAW URLs INSIDE ".SetImage()" PARAMS!
		 *  IF IT'S FROM GIPHY MAKE SURE THE URL IS FROM "media.giphy.com"!
		 *   > SEE "+hello" FOR EXAMPLE!
		 */
		
		if (msg.equalsIgnoreCase("+hello")) {
			
			//	https://media.giphy.com/media/Nx0rz3jtxtEre/giphy.gif
			GIF.setTitle("Hello There!");
			GIF.setImage("https://media.giphy.com/media/Nx0rz3jtxtEre/giphy.gif");
			System.out.println("+hello GIF triggered.\n   Guild: " + event.getGuild().getName() + " in Channel #" + event.getMessage().getChannel().getName());
			event.getChannel().sendMessage(GIF.build()).queue();
			
		} else if (msg.equalsIgnoreCase("+power")) {
			
			// https://media.giphy.com/media/3o84sq21TxDH6PyYms/giphy.gif
			GIF.setTitle("UNLIMITED POWER!");
			GIF.setImage("https://media.giphy.com/media/3o84sq21TxDH6PyYms/giphy.gif");
			System.out.println("+power GIF triggered.\n   Guild: " + event.getGuild().getName() + " in Channel #" + event.getMessage().getChannel().getName());
			event.getChannel().sendMessage(GIF.build()).queue();
			
		} else if (msg.equalsIgnoreCase("+sad")) {
			
			//	https://media.giphy.com/media/T9HgfTv4di5Ne/giphy.gif
			GIF.setTitle(":(");
			GIF.setImage("https://media.giphy.com/media/T9HgfTv4di5Ne/giphy.gif");
			System.out.println("+sad GIF triggered.\n   Guild: " + event.getGuild().getName() + " in Channel #" + event.getMessage().getChannel().getName());
			event.getChannel().sendMessage(GIF.build()).queue();
		}
	}
}
