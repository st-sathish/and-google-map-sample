package com;

import android.app.IntentService;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.ResultReceiver;

import com.extras.Loggr;
import com.google.android.gms.location.LocationResult;
import com.handler.LocationChangedConstants;

public class LocationChangedIntentService extends IntentService {

    Bundle resultData;

    public LocationChangedIntentService() {
        super("LocationChangedIntentService");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startID) {
        super.onStartCommand(intent, flags, startID);
        Loggr.debug("LocationUpdateService Location received");
        return START_REDELIVER_INTENT;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Loggr.debug("onHandleIntent result");
        ResultReceiver receiver = intent.getParcelableExtra(LocationChangedConstants.RECEIVER_TAG);
        if (LocationResult.hasResult(intent)) {
            LocationResult locationResult = LocationResult.extractResult(intent);
            Location location = locationResult.getLastLocation();
            if (location != null) {
                resultData.putParcelable(LocationChangedConstants.LOCATION_TAG, location);
                receiver.send(0, resultData);
                Loggr.debug("Location changed accuracy: " + location.getAccuracy() + " lat: " + location.getLatitude() + " lon: " + location.getLongitude());
            }
        }
    }
}
