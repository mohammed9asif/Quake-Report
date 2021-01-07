package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomArrayAdapter  extends ArrayAdapter<EarthQuake> {

    List<EarthQuake> earthQuakes;
    public CustomArrayAdapter(Context context,List<EarthQuake> earthquakes){
        super(context,0,earthquakes);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem==null){
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.data_layout,parent,false);
        }

        EarthQuake data = getItem(position);

        TextView mag = (TextView) listItem.findViewById(R.id.magnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();

        int magnitudeColor = getMagnitudeColor(data.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        mag.setText(getFormatMagnitude(data.getMagnitude()));


        String wholeLocation = data.getCityName();

        TextView near = (TextView) listItem.findViewById(R.id.nearOf);

        String[] nearOf;

        String primaryLocation;

        if(wholeLocation.contains("of")){


             nearOf = wholeLocation.split("of");

            near.setText(nearOf[0]+"of");

            primaryLocation = nearOf[1].trim();



        }
        else{


            near.setText("Near the");

            primaryLocation = wholeLocation;
        }



        TextView city = (TextView) listItem.findViewById(R.id.cityName);

        city.setText(primaryLocation );




        Date dateObject = new Date( data.getDate());

        String dateFormatted =   new SimpleDateFormat("LLL dd, yyyy").format(dateObject);


        TextView date = (TextView) listItem.findViewById(R.id.date);

        date.setText(dateFormatted);


        TextView time = (TextView) listItem.findViewById(R.id.time);

        String timeFormatted = new SimpleDateFormat("h:mm a").format(dateObject);

        time.setText(timeFormatted);




        return listItem;


    }

    public String getFormatMagnitude(double magnitude){

        DecimalFormat formatter = new DecimalFormat("0.0");

        return formatter.format(magnitude);
    }

    public int getMagnitudeColor(double magnitudeColor){

        int magnitudeColorResourceId;
        switch((int)Math.floor(magnitudeColor)){
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

        return ContextCompat.getColor(getContext(),magnitudeColorResourceId);
    }

}
