package toys.pokemon;

import org.junit.Assert;
import org.junit.Test;

import toys.pokemon.ToyStore.TOY_TYPE;

public class TestPokemonBuyer {
	
	// Below are test examples

	@Test
	public void testExample1() {
		
		PokemonBuyer buyer = new PokemonBuyer();
		buyer.buy(TOY_TYPE.PIKACHU, 1);
		Assert.assertEquals(6d, buyer.calculatePrize(), 0);
		System.out.print(buyer.calculatePrize());
	}
	
	@Test
	public void testExample2() {
		
		PokemonBuyer buyer = new PokemonBuyer();
		buyer.buy(TOY_TYPE.PIKACHU, 2);
		Assert.assertEquals(12d, buyer.calculatePrize(), 0);
		System.out.print(buyer.calculatePrize());
	}
	
	@Test
	public void testExample3() {
		
		PokemonBuyer buyer = new PokemonBuyer();
		buyer.buy(TOY_TYPE.PIKACHU, 1);
		buyer.buy(TOY_TYPE.SQUIRTLE, 1);
		Assert.assertEquals(9.9d, buyer.calculatePrize(), 0);
		System.out.print(buyer.calculatePrize());
	}
	
	@Test
	public void testExample4() {
		
		PokemonBuyer buyer = new PokemonBuyer();
		buyer.buy(TOY_TYPE.PIKACHU, 2);
		buyer.buy(TOY_TYPE.SQUIRTLE, 2);
		Assert.assertEquals(19.8d, buyer.calculatePrize(), 0);
		System.out.print(buyer.calculatePrize());
	}
	
	@Test
	public void testExample5() {
		
		PokemonBuyer buyer = new PokemonBuyer();
		buyer.buy(TOY_TYPE.PIKACHU, 3);
		buyer.buy(TOY_TYPE.SQUIRTLE, 3);
		Assert.assertEquals(29.7d, buyer.calculatePrize(), 0);
		System.out.print(buyer.calculatePrize());
	}
	
	@Test
	public void testExample6() {
		
		PokemonBuyer buyer = new PokemonBuyer();
		buyer.buy(TOY_TYPE.PIKACHU, 2);
		buyer.buy(TOY_TYPE.SQUIRTLE, 1);
		Assert.assertEquals(15.9d, buyer.calculatePrize(), 0);
		System.out.print(buyer.calculatePrize());
	}
	
	
	@Test
	public void testExample7() {
		
		PokemonBuyer buyer = new PokemonBuyer();
		buyer.buy(TOY_TYPE.PIKACHU, 1);
		buyer.buy(TOY_TYPE.SQUIRTLE, 1);
		buyer.buy(TOY_TYPE.CHARMANDER, 1);
		Assert.assertEquals(12.8d, buyer.calculatePrize(), 0);
		System.out.print(buyer.calculatePrize());
	}
	
	
	@Test
	public void testExample8() {
		
		PokemonBuyer buyer = new PokemonBuyer();
		buyer.buy(TOY_TYPE.PIKACHU, 2);
		buyer.buy(TOY_TYPE.SQUIRTLE, 1);
		buyer.buy(TOY_TYPE.CHARMANDER, 1);
		Assert.assertEquals(18.8d, buyer.calculatePrize(), 0);
		System.out.print(buyer.calculatePrize());
	}
	
	
	@Test
	public void testExample9() {
		
		PokemonBuyer buyer = new PokemonBuyer();
		buyer.buy(TOY_TYPE.PIKACHU, 2);
		buyer.buy(TOY_TYPE.SQUIRTLE, 1);
		Assert.assertEquals(15.9d, buyer.calculatePrize(), 0);
		System.out.print(buyer.calculatePrize());
	}
	
	@Test
	public void testExample10() {
		
		PokemonBuyer buyer = new PokemonBuyer();
		buyer.buy(TOY_TYPE.PIKACHU, 3);
		buyer.buy(TOY_TYPE.SQUIRTLE, 2);
		buyer.buy(TOY_TYPE.CHARMANDER, 1);
		double prize = buyer.calculatePrize();
		Assert.assertEquals(28.7, prize, 0);
		System.out.print(buyer.calculatePrize());
	}

	
	@Test
	public void testExample11() {
		
		PokemonBuyer buyer = new PokemonBuyer();
		buyer.buy(TOY_TYPE.PIKACHU, 3);
		buyer.buy(TOY_TYPE.SQUIRTLE, 3);
		buyer.buy(TOY_TYPE.CHARMANDER, 3);
		double prize = buyer.calculatePrize();
		Assert.assertEquals(38.4, prize, 0);
		System.out.print(buyer.calculatePrize());
	}
	
	@Test
	public void testExample12_Negative() {
		PokemonBuyer buyer = new PokemonBuyer();
		buyer.buy(TOY_TYPE.PIKACHU, 0);
		Assert.assertNotNull(buyer.calculatePrize());
	}
	
	
	
}
