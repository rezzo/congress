package com.sunlightlabs.android.congress.notifications.finders;

import java.util.List;

import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.TwitterException;
import winterwell.jtwitter.Twitter.Status;
import android.content.Intent;
import android.util.Log;

import com.sunlightlabs.android.congress.notifications.NotificationEntity;
import com.sunlightlabs.android.congress.utils.Utils;

public class TwitterFinder extends NotificationFinder {

	@Override
	public String decodeId(Object result) {
		if (!(result instanceof Status))
			throw new IllegalArgumentException("The result must be of type winterwell.jtwitter.Twitter.Status");
		return String.valueOf(((Status) result).id);
	}

	@Override
	public List<?> callUpdate(NotificationEntity entity) {
		try {
			return new Twitter().getUserTimeline(entity.notificationData);
		} catch (TwitterException exc) {
			Log.w(Utils.TAG, "Could not fetch tweets for " + entity, exc);
			return null;
		}
	}

	@Override
	public Intent notificationIntent(NotificationEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String notificationMessage(NotificationEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String notificationTitle(NotificationEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}