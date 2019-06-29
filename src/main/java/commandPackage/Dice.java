package commandPackage;

import java.awt.Color;
import java.util.ArrayList;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.User;

public class Dice extends Command {
	
	public Dice() {
		
		this.name = "dice";
		this.aliases = new String[] {"d", "dc"};
		this.help = "Roll a dice, Type **+dice** to start rolling!";
	}
	
	protected void execute(CommandEvent event) {
		
		String[] msg = event.getMessage().getContentRaw().split(" ");
		EmbedBuilder dice = new EmbedBuilder();
		EmbedBuilder illegal = new EmbedBuilder();
		User author = event.getMessage().getAuthor();
		
		dice.setColor(Color.WHITE);
		illegal.setColor(Color.WHITE);
		illegal.setTitle("Wait " + author.getName() + ", that's illegal");
		illegal.setImage("https://i.kym-cdn.com/entries/icons/mobile/000/028/207/Screen_Shot_2019-01-17_at_4.22.43_PM.jpg");
		
		if(msg.length == 1 && msg[0].equalsIgnoreCase("+dice")) {
			
			event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", to roll a dice, type **+dice [# of Dice]**. You can only roll maximum of 5 dice.").queue();
			
		} else if (msg.length == 2 && msg[0].equalsIgnoreCase("+dice")) {
			
			if(msg[1].equals("1")) {
				
				int diceRand = (int)(Math.random() * 6 + 1);
				dice.setTitle(author.getName() + " rolled a dice!");
				dice.setDescription("Your dice number is [" + diceRand + "]");
				
				event.getChannel().sendMessage(dice.build()).queue();
				
			} else {
				
				try {
					int diceNum = Integer.parseInt(msg[1]);
					int diceTotal = 0;
					ArrayList<Integer> diceRoll = new ArrayList<>();
					diceRoll.clear();
					
					if (diceNum > 5)
						event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", you cannot roll more than 5 dice at the same time.").queue();
					
					else if (diceNum < 1) 
						event.getChannel().sendMessage(illegal.build()).queue();
					
					else {
						
						for (int i = 1; i <= diceNum; i++) 
							diceRoll.add((int) (Math.random() * 6 + 1));
						
						for (int i = 0; i < diceNum; i++)
							diceTotal += diceRoll.get(i);
							

						dice.setTitle(author.getName() + " rolled " + diceNum + " dice!");
						dice.setDescription("Your dice number are " + diceRoll.toString() + "\nTotal number is " + diceTotal);

						event.getChannel().sendMessage(dice.build()).queue();
					}
				} catch (Exception e) {
					
					event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", to roll a dice, type **+dice [# of Dice]**. You can only roll maximum of 5 dice.").queue();
				}
			}
		}
	}
}
