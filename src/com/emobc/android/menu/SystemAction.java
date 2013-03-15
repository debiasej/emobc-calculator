/**
* Copyright 2012 Neurowork Consulting S.L.
*
* This file is part of eMobc.
*
* SystemAction.java
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
package com.emobc.android.menu;

/**
 * @author Jorge E. Villaverde
 * @since 0.1
 * @version 0.1
 */
public enum SystemAction {
	GO_HOME,
	GO_BACK,
	TTS,       // Text to Speach
	SHARE,     // Share Content
	COPY,      // Copy Content
	EMAIL      // Email Content
	;     

	public static SystemAction parseText(String text) {
		if("home".equals(text))
			return GO_HOME;
		if("back".equals(text))
			return GO_BACK;
		if("tts".equals(text))
			return TTS;
		if("share".equals(text))
			return SHARE;
		if("copy".equals(text))
			return COPY;
		if("email".equals(text))
			return EMAIL;
		return null;
	}     
}
