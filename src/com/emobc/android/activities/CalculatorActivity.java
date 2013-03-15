package com.emobc.android.activities;

import android.content.Intent;
import android.os.Bundle;

import com.emobc.android.ApplicationData;
import com.emobc.android.NextLevel;
import com.emobc.android.activities.generators.ActivityGenerator;
import com.emobc.android.menu.CreateMenus;

//import com.emobc.android.activities.generators.CalculatorActivityGenerator;

/**
 * Defines an activity of type CALCULATOR_ACTIVITY, and 
 * initialize all screen menu and the screen rotations. In its 
 * method onCreate(), call its CalculatorActivityGenerator generator class. 
 * @author Mario de Biase Jiménez
 * @see CalculatorActivityGenerator
 * @version 0.1
 * @since 0.1
 */
public class CalculatorActivity extends CreateMenus{

	/** 
	 * Called when the activity is first created. 
	 **/
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
        //overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        boolean isEntryPoint=false;
        rotateScreen(this);
        
        ApplicationData applicationData = getApplicationData();
		if(applicationData != null){
			Intent intent = getIntent();
			isEntryPoint= (Boolean) intent.getSerializableExtra(ApplicationData.IS_ENTRY_POINT_TAG);
			NextLevel nextLevel = (NextLevel)intent.getSerializableExtra(ApplicationData.NEXT_LEVEL_TAG);
			setCurrentNextLevel(NextLevel.SEARCH_NEXT_LEVEL);
			ActivityGenerator generator = applicationData.getFromNextLevel(this, nextLevel);
			generator.initializeActivity(this);

			setEntryPoint(isEntryPoint);
			createMenus();        
		}else{
			Intent i = new Intent (this, SplashActivity.class);
			startActivity(i);
			finish();
		}
		//createToolBar(isEntryPoint);
    }
	
}//class
