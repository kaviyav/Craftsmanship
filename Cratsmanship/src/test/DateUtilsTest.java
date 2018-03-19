package test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import main.Date;
import main.DateUtils;

public class DateUtilsTest {
	Date startDate = new Date(19,03,2018);
	@Test
	public void testDatesInSameMonth(){
		assertEquals(0,DateUtils.getDuration(startDate,new Date(19,3,2018)));
		assertEquals(9,DateUtils.getDuration(startDate,new Date(28,3,2018)));
		assertEquals(12,DateUtils.getDuration(startDate,new Date(31,3,2018)));
		/*assertEquals(39090,DateUtils.getDuration(startDate,new Date(28,3,2125)));
		assertEquals(75614,DateUtils.getDuration(startDate,new Date(28,3,2225)));
		assertEquals(148663,DateUtils.getDuration(startDate,new Date(28,3,2425)));*/
		}
	@Test
	public void testDatesInDifferentMonthSameYear(){
		/*assertEquals(0,DateUtils.getDuration(startDate,new Date(19,3,2018)));
		assertEquals(9,DateUtils.getDuration(startDate,new Date(28,3,2018)));
		assertEquals(12,DateUtils.getDuration(startDate,new Date(31,3,2018)));*/
		assertEquals(40,DateUtils.getDuration(startDate,new Date(28,4,2018)));
		assertEquals(70,DateUtils.getDuration(startDate,new Date(28,5,2018)));
		assertEquals(101,DateUtils.getDuration(startDate,new Date(28,6,2018)));
		assertEquals(131,DateUtils.getDuration(startDate,new Date(28,7,2018)));
		assertEquals(162,DateUtils.getDuration(startDate,new Date(28,8,2018)));
		assertEquals(193,DateUtils.getDuration(startDate,new Date(28,9,2018)));
		assertEquals(223,DateUtils.getDuration(startDate,new Date(28,10,2018)));
		assertEquals(254,DateUtils.getDuration(startDate,new Date(28,11,2018)));
		assertEquals(284,DateUtils.getDuration(startDate,new Date(28,12,2018)));
	}
	
	@Test
	public void testDatesAcrossNonLeapYears(){
		assertEquals(315,DateUtils.getDuration(startDate,new Date(28,1,2019)));
		assertEquals(346,DateUtils.getDuration(startDate,new Date(28,2,2019)));
		assertEquals(374,DateUtils.getDuration(startDate,new Date(28,3,2019)));
	}
	
	@Test
	public void testDatesAcrossYearsDivisibleByFour(){
		assertEquals(740,DateUtils.getDuration(startDate,new Date(28,3,2020)));
		assertEquals(1105,DateUtils.getDuration(startDate,new Date(28,3,2021)));
	}
	@Test
	public void testDateAcrossYearsDivisibleByHundredBut400(){
		assertEquals(75614,DateUtils.getDuration(startDate,new Date(28,3,2225)));
		assertEquals(148663,DateUtils.getDuration(startDate,new Date(28,3,2425)));
	}
	
	@Ignore
	@Test
	public void testZeroDate(){
		assertEquals(0,DateUtils.getDuration(new Date(00,00,0000),new Date(00,00,0000)));
		assertEquals(0,DateUtils.getDuration(new Date(00,00,0000),new Date(03,12,2018)));
		assertEquals(0,DateUtils.getDuration(new Date(03,12,2018),new Date(00,00,0000)));
	}
	@Ignore
	@Test
	public void testEndDateIsGreaterThenStartDate(){
		assertEquals(2,DateUtils.getDuration(new Date(3,12,2018),new Date(5,12,2018)));
		assertEquals(0,DateUtils.getDuration(new Date(5,12,2018),new Date(3,12,2018)));
		assertEquals(0,DateUtils.getDuration(new Date(03,12,2018),new Date(00,00,0000)));
	}
	@Ignore
	@Test
	public void testInvalidDate(){
		assertEquals(0,DateUtils.getDuration(new Date(00,00,0000),new Date(00,00,0000)));
		/*assertEquals(0,DateUtils.getDuration(new Date(00,00,0000),new Date(03,12,2018)));
		assertEquals(0,DateUtils.getDuration(new Date(03,12,2018),new Date(00,00,0000)));*/
	}
	

	
}
