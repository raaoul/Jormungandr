package commandPackage;

import java.awt.Color;
import java.util.ArrayList;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class DiceListener extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] msg = event.getMessage().getContentRaw().split(" ");
		EmbedBuilder dice = new EmbedBuilder();
		dice.setColor(Color.WHITE);
		
		User author = event.getMessage().getAuthor();
		
		if(msg.length == 1 && msg[0].equalsIgnoreCase("+dice")) {
			
			event.getChannel().sendMessage("To roll a dice, type **+dice [# of Dice]**. You can only roll maximum of 5 dice.").queue();
			
		} else if (msg.length == 2 && msg[0].equalsIgnoreCase("+dice")) {
			
			if(msg[1].equals("1")) {
				
				int diceRand = (int)(Math.random() * 6 + 1);
				dice.setTitle(author.getName() + " rolled a dice!");
				dice.setDescription("your dice number is [" + diceRand + "]");
				
				event.getChannel().sendMessage(dice.build()).queue();
				
			} else {
				
				try {
					int diceNum = Integer.parseInt(msg[1]);
					ArrayList<Integer> diceRoll = new ArrayList<>();
					diceRoll.clear();
					
					if (diceNum > 5)
						event.getChannel().sendMessage("You cannot roll more than 5 dice at the same time.").queue();
					else {

						for (int i = 1; i <= diceNum; i++)
							diceRoll.add((int) (Math.random() * 6 + 1));

						dice.setTitle(author.getName() + " rolled " + diceNum + " dice!");
						dice.setDescription("your dice number are " + diceRoll.toString());

						event.getChannel().sendMessage(dice.build()).queue();
					}
				} catch (Exception e) {
					
					event.getChannel().sendMessage("To roll a dice, type **+dice [# of Dice]**. You can only roll maximum of 5 dice.").queue();
				}
			}
		}
	}
}
