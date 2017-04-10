package com.example.user.finalproject.recipe;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

/**
 * Created by user on 2017/4/10.
 */

public class RecipeService extends Service {

    public static final String currentServiceId = "recipe.gsu.edu"; //This is String action id

    public static final int notifyLoading = 12;
    public static final int notifyProgress = 11;
    public static final int initComplete = 22;
    public static final int notifyStartPlay = 33;
    public static final int notifyPause = 44;
    public static final int notifyResume = 55;
    public static final int notifyCache = 66;
    public static final int notifyComplete = 77;
    public static final int notifySeekComplete = 88;
    public static final int notifyPrepared = 99;
    public static final int notifyError = 00;

    private int currentRecipeNumber;
    private int totalRecipeNumber;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Recipe_Service","Service Created");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent==null)
        return super.onStartCommand(intent, flags, startId);
        else{
            currentRecipeNumber=intent.getIntExtra("currentNumber",0);
            totalRecipeNumber=intent.getIntExtra("maxNumber",1);

            try{
                Random rand = new Random();

                int randomNum = rand.nextInt((totalRecipeNumber - 0) + 1);
                notifyCompleted(randomNum);



            }catch (Exception e){

            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    protected void notifyCompleted(int newRecipeNumber) {
        Intent intent = new Intent();
        intent.putExtra("RecipeServiceStatus", notifyComplete);
        intent.putExtra("FeaturedRecipeNumber", newRecipeNumber);
        sendNotify(intent);
    }

    private void sendNotify(Intent intent) {
        intent.setAction(currentServiceId);
        Log.d("Service broadcast ","broadcast sent");
        sendBroadcast(intent);

    }
}
