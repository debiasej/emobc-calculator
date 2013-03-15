/**
* Copyright 2012 Neurowork Consulting S.L.
*
* This file is part of eMobc.
*
* AppLevel.java
* eMobc Android Framework
*
* eMobc is free software: you can redistribute it and/or modify
* it under the terms of the Affero GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* eMobc is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the Affero GNU General Public License
* along with eMobc. If not, see <http://www.gnu.org/licenses/>.
*
*/
package com.emobc.android.levels;

import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.emobc.android.ActivityType;
import com.emobc.android.SearchResult;
import com.emobc.android.activities.AudioActivity;
import com.emobc.android.activities.ButtonsActivity;
import com.emobc.android.activities.CalendarActivity;
import com.emobc.android.activities.CalculatorActivity;
import com.emobc.android.activities.CoverActivity;
import com.emobc.android.activities.CrudReadActivity;
import com.emobc.android.activities.FormActivity;
import com.emobc.android.activities.ImageListActivity;
import com.emobc.android.activities.ImageTextDescriptionActivity;
import com.emobc.android.activities.MapsActivity;
import com.emobc.android.activities.QrActivity;
import com.emobc.android.activities.QuizActivity;
import com.emobc.android.activities.SaleActivity;
import com.emobc.android.activities.SearchActivity;
import com.emobc.android.activities.ShowProfileActivity;
import com.emobc.android.activities.WebActivity;
import com.emobc.android.parse.ParseUtils;

/**
 * Application Level
 * <p>
 * An Application Level is a primary Level in the eMobc Framework.
 * Each application has an <tt>app.xml</tt> file which defines the primary
 * levels. Each of these levels has one or more secondary levels associated.
 * </p>
 * @author Jorge E. Villaverde
 * @author Jonatan Alcocer Luna
 * @see AppLevelData
 * @version 0.1
 * @since 0.1
 */
public class AppLevel {
	private final int number;
	private String id;
	private String title;
	private String fileName;
	private ActivityType activityType;
	private AppLevelData levelData = null;
	private String xib;
	private boolean useProfile = false;

	public static final AppLevel COVER_APP_LEVEL;
	public static final AppLevel PROFILE_APP_LEVEL;
	public static final AppLevel SEARCH_APP_LEVEL;
	
	static{
		COVER_APP_LEVEL = new AppLevel(1);
		COVER_APP_LEVEL.setActivityType(ActivityType.COVER_ACTIVITY);
		COVER_APP_LEVEL.setTitle("Cover App Level");
		
		PROFILE_APP_LEVEL = new AppLevel(2);
		PROFILE_APP_LEVEL.setActivityType(ActivityType.PROFILE_ACTIVITY);
		PROFILE_APP_LEVEL.setTitle("Cover App Level");
		
		SEARCH_APP_LEVEL = new AppLevel(3);
		SEARCH_APP_LEVEL.setActivityType(ActivityType.SEARCH_ACTIVITY);
		SEARCH_APP_LEVEL.setTitle("Search App Level");
	}
	
	
	public AppLevel(int number) {
		super();
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public ActivityType getActivityType() {
		return activityType;
	}
	
	/**
	 * Depending on the 'ActivityType' of AppLevel, returns. Class that corresponds
	 * @return Class<? extends Activity>
	 */
	public Class<? extends Activity> getAcivityClass(){
		switch (activityType) {
		case COVER_ACTIVITY:
			return CoverActivity.class;
		case IMAGE_TEXT_DESCRIPTION_ACTIVITY:
			return ImageTextDescriptionActivity.class;
		case QR_ACTIVITY:
			return QrActivity.class;
		case MAP_ACTIVITY:
			return MapsActivity.class;
		case CALENDAR_ACTIVITY:
			return CalendarActivity.class;
		case QUIZ_ACTIVITY:
			return QuizActivity.class;
		case BUTTONS_ACTIVITY:
			return ButtonsActivity.class;
		case FORM_ACTIVITY:
			return FormActivity.class;
		case AUDIO_ACTIVITY:
			return AudioActivity.class;
		case PROFILE_ACTIVITY:
			return ShowProfileActivity.class;
		case WEB_ACTIVITY:
			return WebActivity.class;
		case SEARCH_ACTIVITY:
			return SearchActivity.class;
		case CRUD_ACTIVITY:
			return CrudReadActivity.class;
		case SALE_ACTIVITY:
			return SaleActivity.class;
		case CALCULATOR_ACTIVITY:
			return CalculatorActivity.class;
		default:
			Log.w("AppLevel: getActiviClass", "Asiging default Activity Class to Activity Type: " + activityType);
			return ImageListActivity.class;
		}
	}

	public AppLevelData getData(Context context) {
		return getData(context, Locale.getDefault());
	}
	
	public AppLevelData getData(Context context, Locale locale) {
		if(levelData == null){
			levelData = ParseUtils.parseLevelData(context, locale, fileName, activityType, useProfile);
		}		
		return levelData;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public List<SearchResult> findWidthText(Context context, String text) {
		return getData(context).findWidthText(text, id);
	}
	
	public List<SearchResult> findWidthText(Context context, Locale locale, String text) {
		return getData(context, locale).findWidthText(text, id);
	}

	public List<SearchResult> getAllImages(Context context, Locale locale) {
		return getData(context, locale).getAllImages(id);
	}

	public List<SearchResult> getAllImages(Context context) {
		return getData(context).getAllImages(id);
	}

	public List<SearchResult> findAllGeoref(Context context, Locale locale) {
		return getData(context, locale).findAllGeoref(id);
	}
	
	public List<SearchResult> findAllGeoref(Context context) {
		return getData(context).findAllGeoref(id);
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		
		if(id != null && id.length() > 0){
			builder.append("Level Id:");
			builder.append(id);
		}else{
			builder.append("Level Nro:");
			builder.append(number);
		}
		if(activityType != null){
			builder.append( ", Type: ");
			builder.append(activityType.toString());
		}	
		return builder.toString();
		
	}

	public String getXib() {
		return xib;
	}

	public void setXib(String xib) {
		this.xib = xib;
	}

	public boolean isUseProfile() {
		return useProfile;
	}

	public void setUseProfile(boolean useProfile) {
		this.useProfile = useProfile;
	}
}
