package gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GildedRoseTest {

	//documentation: https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/GildedRoseRequirements.txt
	
	@Test
	public void TestSomething() {
		GildedRose app = checkItem("something", 0, 0);
		assertEquals(0, app.items[0].quality);
	}
	
	@Test
	public void QualityNevernegative() {
		GildedRose app = checkItem("something", 0, -1);
		assertEquals(-1, app.items[0].quality);
		//Bug Report : No Negative input for Quality
	}	
	
	@Test
	public void QualityMaxValue() {
		GildedRose app = checkItem("something", 0, 61);
		assertEquals(59, app.items[0].quality);
		// Bug Report : no quality above 50
	}
	
	@Test
	public void TestingNonSpecifiedUnexpiredSellIn() {
		GildedRose app = checkItem("something", 50, 50);
		assertEquals(49, app.items[0].sellIn);
	}
	
	@Test
	public void TestTOBENAMED() {
		GildedRose app = checkItem("something", 50, 50);
		assertEquals(49, app.items[0].quality);
	}
	
	@Test
	public void QualityIncreaseInAgedBrie() {
		GildedRose app = checkItem("Aged Brie", 0, 0);
		assertEquals(2, app.items[0].quality);
	}
	
	@Test
	public void QualityUnexpiredAgedBrie() {
		GildedRose app = checkItem("Aged Brie", 1, 0);
		assertEquals(2, app.items[0].quality);
	}
	
	
	public GildedRose checkItem(String item, Integer sellin, Integer quality) {
		Item[] items = new Item[] { new Item(item, sellin, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		return app;
	}
	
	
}
