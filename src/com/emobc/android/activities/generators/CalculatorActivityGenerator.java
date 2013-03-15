package com.emobc.android.activities.generators;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

import com.emobc.android.ActivityType;
import com.emobc.android.NextLevel;
import com.emobc.android.activities.R;
import com.emobc.android.levels.AppLevel;
import com.emobc.android.levels.AppLevelData;
import com.emobc.android.levels.impl.CalculatorLevelDataItem;
import com.emobc.android.menu.CreateMenus;


/**
 * Screen generator, responsible for specific components to initialize the 
 * display type "Calculator". It also creates the menus, rotations, and the format for 
 * the components.
 * @author Mario de Biase Jiménez
 * @version 0.1
 * @since 0.1
 */
public class CalculatorActivityGenerator extends LevelActivityGenerator {
	
	public CalculatorActivityGenerator(AppLevel appLevel, NextLevel nextLevel) {
		super(appLevel, nextLevel);
	}
	
	protected void loadAppLevelData(final Activity activity, final AppLevelData data) {
		final CalculatorLevelDataItem item = (CalculatorLevelDataItem)data.findByNextLevel(nextLevel);
		
		initializeHeader(activity, item); //item is where I have parsed the info
		
		//Create Banner
		CreateMenus c = (CreateMenus)activity;
		c.createBanner();

		final TextView tv = (TextView) activity.findViewById(R.id.textView1);
		final EditText resul = (EditText) activity.findViewById(R.id.editText1);
		Button b = (Button) activity.findViewById(R.id.button1); 

		
		b.setOnClickListener(new View.OnClickListener(){
			
			int n1 = item.getNumber1();
			int n2 = item.getNumber2();
			
			public void onClick(View v){
				String texto = tv.getText().toString();
				texto += " de la operación "+n1+" + "+n2+" es:";
				tv.setText(texto);
				resul.setText(new Integer(n1+n2).toString());
			}
		});		
	}
	
	@Override
	protected int getContentViewResourceId(final Activity activity) {
		if(appLevel.getXib() != null && appLevel.getXib().length() > 0){
			int id = getActivityLayoutIdFromString(activity, appLevel.getXib());
			if(id >0)
				return id;
		}
		return R.layout.calculator_activity;
	}
	
	@Override
	protected ActivityType getActivityGeneratorType() {
		return ActivityType.CALCULATOR_ACTIVITY;
	}

}
