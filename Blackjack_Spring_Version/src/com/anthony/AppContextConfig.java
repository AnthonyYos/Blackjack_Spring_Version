package com.anthony;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.anthony.game.BlackjackGame;
import com.anthony.game.Game;
import com.anthony.player.BlackjackDealer;
import com.anthony.player.BlackjackPlayer;
import com.anthony.player.Dealer;
import com.anthony.player.Player;

@Configuration
@ComponentScan
@PropertySource("classpath:names.properties")
public class AppContextConfig {

	@Bean
	public Dealer dealer() {
		return new BlackjackDealer();
	}

	@Bean
	public Player player() {
		return new BlackjackPlayer();
	}
	
	@Bean
	public Game blackjackGame() {
		return new BlackjackGame(player(), dealer());
	}
}
