package gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.legacycode.Range;

import junit.framework.TestCase;

public class GildedRoseApprovalTest extends TestCase {

	public void testSomething() throws Exception {
		String[] items = { "something","Aged Brie", "Sulfuras", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert"};
		Integer[] sellins = {0, 1, 5, 6, 10, 50, Integer.MAX_VALUE};
		Integer[] qualities = {-1, 0, 50, 61, 80, Integer.MAX_VALUE};
		CombinationApprovals.verifyAllCombinations(this::checkItem, items, sellins, qualities);
	}
	
	public Item checkItem(String item, Integer sellin, Integer quality) {
		Item[] items = new Item[] { new Item(item, sellin, quality) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		return items[0];
	}
	

	 //Once the sell by date has passed, Quality degrades twice as fast
		//- The Quality of an item is never negative
		//- "Aged Brie" actually increases in Quality the older it gets
		//- The Quality of an item is never more than 50
		//- "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
		//- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
		//Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
		//Quality drops to 0 after the concert
		//an item can never have its Quality increase above 50, 
		//however "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters
	

}