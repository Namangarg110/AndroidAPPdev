package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class quakeAdapter extends ArrayAdapter<quake>
{
    private static final String LOCATION_SEPARATOR = " of ";
    public quakeAdapter(Activity context , ArrayList<quake> earthquakes)
    {
        super(context,0,earthquakes);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listQuakeView = convertView;
        if (listQuakeView==null)
        {
            listQuakeView = LayoutInflater.from(getContext()).inflate(R.layout.quake_list,parent,false);
        }

        //getting current position in the  list
        quake currentQuake = getItem(position);

        //linking all textViews
        TextView magText =(TextView) listQuakeView.findViewById(R.id.mag_text);
        TextView placeText =(TextView) listQuakeView.findViewById(R.id.place_text);
        TextView dateText =(TextView) listQuakeView.findViewById(R.id.date_text);
        TextView timeText = (TextView) listQuakeView.findViewById(R.id.time_text);
        TextView nearText = (TextView) listQuakeView.findViewById(R.id.nearby_text);

        //Converting double to string to set on TextView
        String fMag= formatMagnitude(currentQuake.getMag());
        magText.setText(fMag);

        GradientDrawable magnitudeCircle = (GradientDrawable) magText.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentQuake.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        //get place data and setting text to TextView
        String originalLocation = currentQuake.getPlace();
        String locationOffset;
        String primaryLocation;

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        nearText.setText(locationOffset);
        placeText.setText(primaryLocation);


        long time = currentQuake.getTime();  //Time in Millisecond (UNIX TIME)

        //converting ms time to human readable date
        Date dateObject = new Date(time);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        dateText.setText(dateToDisplay);

        //converting ms time to human readable time
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String timeToDisplay = timeFormatter.format(dateObject);
        timeText.setText(timeToDisplay);

        return listQuakeView;
    }
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
