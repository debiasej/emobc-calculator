/**
* Copyright 2012 Neurowork Consulting S.L.
*
* This file is part of eMobc.
*
* CanvasActivity.java
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
package com.emobc.android.activities;

import android.os.Bundle;

import com.emobc.android.activities.generators.CanvasActivityGenerator;

/**
 * Defines an activity of type CALENDAR_ACTIVITY, and 
 * initialize all screen menu and the screen rotations. In its 
 * method onCreate(), call its CalendarActivityGenerator generator class. 
 * 
 * @see CanvasActivityGenerator
 * @version 0.1
 * @since 0.1
 */

public class CanvasActivity extends EMobcActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
    }

    
}
