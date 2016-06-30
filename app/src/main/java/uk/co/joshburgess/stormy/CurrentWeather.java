package uk.co.joshburgess.stormy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by joshburgess on 29/06/2016.
 */
public class CurrentWeather {
    private String mIcon;
    private long mTime;
    private double mTemp;
    private double mHumidity;
    private double mPrecipChance;
    private String mSummary;
    private String mTimeZone;

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        this.mIcon = icon;
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        this.mTime = time;
    }

    public double getTemp() {
        return mTemp;
    }


    public String getFormattedTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        Date dateTime;

        formatter.setTimeZone(TimeZone.getTimeZone(getTimeZone()));

        dateTime = new Date(getTime() * 1000);

        return formatter.format(dateTime);
    }

    public void setTemp(double temp) {
        this.mTemp = temp;
    }

    public double getHumidity() {
        return mHumidity;
    }

    public void setHumidity(double humidity) {
        this.mHumidity = humidity;
    }

    public double getPrecipChance() {
        return mPrecipChance;
    }

    public void setPrecipChance(double precipChance) {
        this.mPrecipChance = precipChance;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        this.mSummary = summary;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }
}
