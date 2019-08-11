package gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GildedRoseTest {

	//documentation: https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/GildedRoseRequirements.txt
	
	@Test
	public void TestSomething() {
		GildedRose app = checkItem("something", 0, 0);
		assertEquals(0, app.items[0].quality);
		assertEquals(-1, app.items[0].sellIn);
	}
	
	
	
	public GildedRose checkItem(String item, Integer sellin, Integer quality) {
		Item[] items = new Item[] { new Item(item, sellin, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		return app;
	}
	
	
}
