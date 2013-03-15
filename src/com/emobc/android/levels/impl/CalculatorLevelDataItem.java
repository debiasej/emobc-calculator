package com.emobc.android.levels.impl;

import com.emobc.android.NextLevel;
import com.emobc.android.levels.AppLevelDataItem;

/**
 * Item that contains data specific to a level of the activityType "CALCULATOR"
 * @author Mario de Biase Jiménez
 * @version 0.1
 * @since 0.1
 */
public class CalculatorLevelDataItem extends AppLevelDataItem{
	
	private int number1;
	private int number2;
	private NextLevel nextLevel;
	
	public void setNumber1(int number) {
		this.number1 = number;
	}
	
	public void setNumber2(int number) {
		this.number2 = number;
	}
	
	public int getNumber1() {
		return number1;
	}
	
	public int getNumber2() {
		return number2;
	}
	
	public void setNextLevel(NextLevel nextLevel) {
		this.nextLevel = nextLevel;
	}
	
	public NextLevel getNextLevel() {
		return nextLevel;
	}

}
