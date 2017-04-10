package com.example.user.finalproject.recipe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2017/4/10.
 */

public class RecipeController {
    private static RecipeController controller;
    private RecipeReceiver recipeReceiver;
    private Context mContext;
    private int featuredNumber;
    private int currentPosition;
    private ArrayList<String> recipeList;
    private Map<String, IRecipeStatus> listenerMap = new HashMap<String, IRecipeStatus>();

    public static RecipeController getInstance(Context mContext){
        if (null==controller){
            controller = new RecipeController(mContext);
        }
        return controller;
    }

    public class RecipeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (listenerMap == null || listenerMap.size()==0) {
                return;
            }
            String action = intent.getAction();
            if(action.equals(RecipeService.currentServiceId)){
                switch (intent.getIntExtra("RecipeServiceStatus",00)){
                    case RecipeService.notifyLoading:
                        onLoading();
                        break;
                    case RecipeService.notifyComplete:
                        onComplete(intent.getIntExtra("FeaturedRecipeNumber",0));
                        Log.d("controller","received completed status");
                        break;
                    case RecipeService.notifyError:
                        onError();
                        break;


                }
            }

        }
        private void onLoading(){
            for(Map.Entry<String, IRecipeStatus> entry : listenerMap.entrySet()){
                entry.getValue().onLoading();
            }
        }
        private void onComplete(int featuredRecipeNumber){
            for(Map.Entry<String, IRecipeStatus> entry : listenerMap.entrySet()){
                entry.getValue().onComplete(featuredRecipeNumber);
            }
        }
        private void onError(){
            for(Map.Entry<String, IRecipeStatus> entry : listenerMap.entrySet()){
                entry.getValue().onError();
            }
        }
        private void onStart(){
            for(Map.Entry<String, IRecipeStatus> entry : listenerMap.entrySet()){
                entry.getValue().onStart();
            }
        }

    }

    public void getFeaturedRecipe(int currentRecipeNumber, int totalRecipeNumber){
        Log.d("currentRecipe",String.valueOf(currentRecipeNumber));
        Intent intent = new Intent(mContext, RecipeService.class);
        intent.putExtra("currentNumber",currentRecipeNumber);
        intent.putExtra("maxNumber",totalRecipeNumber);
        mContext.startService(intent);

    }

    private RecipeController(Context context) {
        mContext = context;
        initRecipeReceiver();
    }

    public void setPlayList(ArrayList<String> recipeList) {
        this.recipeList = recipeList;
        currentPosition = 0;
    }
    public ArrayList<String> getReceipeList(){
        return  recipeList;
    }

    private void initRecipeReceiver() {
        recipeReceiver = new RecipeReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(RecipeService.currentServiceId);
        mContext.registerReceiver(recipeReceiver, filter);


    }
    public void addListener(String name, IRecipeStatus listener){
        if(listenerMap!=null&listenerMap.containsKey(name)){
            listenerMap.remove(name);
            listenerMap.put(name, listener);
        }else{
            listenerMap.put(name, listener);
        }
    }
    public void deleteListener(String name){
        if(listenerMap!=null&listenerMap.containsKey(name)){
            listenerMap.remove(name);
        }else{
            return;
        }
    }
    public void clearListener(){
        if(listenerMap!=null){
            listenerMap.clear();
        }
    }
    public void destroy() {
        Intent stopIntent = new Intent(mContext, RecipeService.class);
        mContext.stopService(stopIntent);
        mContext.unregisterReceiver(recipeReceiver);
        recipeReceiver = null;
    }
    public interface IRecipeStatus {
        public void onLoading();
        public void onComplete(int featuredNumber);
        public void onError();
        public void onStart();

    }

}

