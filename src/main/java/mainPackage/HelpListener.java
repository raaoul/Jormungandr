package mainPackage;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

//		UNUSED FOR NOW!

public class HelpListener extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		if (event.getMessage().getContentRaw().equalsIgnoreCase("+help")) {
			
			EmbedBuilder help = new EmbedBuilder();
			
			help.setColor(Color.WHITE);
			help.setTitle("What can I help?");
			help.addField("Fun GIFs", "Type **+gifs** for more!", false);
			help.addField("Roll a dice", "Type **+dice** to start rolling!", false);
			
			event.getChannel().sendMessage(help.build()).queue();;
		}
	}
}
