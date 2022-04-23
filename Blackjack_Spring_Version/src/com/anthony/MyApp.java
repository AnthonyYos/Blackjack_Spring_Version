package com.anthony;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anthony.game.Game;

public class MyApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContextConfig.class);
		Game blackjackGame = ctx.getBean("blackjackGame", Game.class);
		blackjackGame.play();
	}

}
