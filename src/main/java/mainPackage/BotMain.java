package mainPackage;

import commandPackage.DiceListener;
import commandPackage.GIFListener;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class BotMain {

	public static void main(String[] args) throws Exception {
		
		  JDA bot = new JDABuilder("NTg3ODI0MTA4ODU1NjIzNzEw.XQ9YFw.veOIZ0hPAJV0fZR-P-5u9pB7AkE").build();
		  
		  bot.addEventListener(new HelpListener());
		  bot.addEventListener(new GIFListener());
		  bot.addEventListener(new DiceListener());
	}

}
