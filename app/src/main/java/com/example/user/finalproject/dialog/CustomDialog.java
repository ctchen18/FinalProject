package com.example.user.finalproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.finalproject.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDialog extends Dialog {



    @OnClick(R.id.dialog_return_btn)
    public void returnClicked(){
        listener.onClickListener();
        listener.lastClickedItem(recipeName.getText().toString());
        dismiss();
     }

     @BindView(R.id.dialog_direction_details)
     TextView directionDetails;

    @BindView(R.id.dialog_ingredient_details)
    TextView ingredientDetails;

    @BindView(R.id.dialog_recipe_name)
    TextView recipeName;

    @BindView(R.id.dialog_food_image)
    ImageView foodImage;


    private ICustomDialogEventListener listener;
    private int recipeNumber;

    public interface ICustomDialogEventListener{
        public void onClickListener();
        public void lastClickedItem(String recipeName);
    }
    public void lastClickedItem(){

    }
    public CustomDialog(Context context,ICustomDialogEventListener listener,int recipeNumber) {
        super(context, R.style.dialog);
        this.recipeNumber = recipeNumber;
        this.listener = listener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_custom_dialog);
        ButterKnife.bind(this);
        String urlList[] = getContext().getResources().getStringArray(R.array.urls);

        Log.d("URL",urlList[0]);
        switch (recipeNumber){
            case 0:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_one);
                directionDetails.setText(R.string.direction_one);
                recipeName.setText(R.string.recipe_name_one);
                break;
            case 1:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_two);
                directionDetails.setText(R.string.direction_two);
                recipeName.setText(R.string.recipe_name_two);
                break;
            case 2:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_three);
                directionDetails.setText(R.string.direction_three);
                recipeName.setText(R.string.recipe_name_three);
                break;
            case 3:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_four);
                directionDetails.setText(R.string.direction_four);
                recipeName.setText(R.string.recipe_name_four);
                break;
            case 4:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_five);
                directionDetails.setText(R.string.direction_five);
                recipeName.setText(R.string.recipe_name_five);
                break;
            case 5:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_six);
                directionDetails.setText(R.string.direction_six);
                recipeName.setText(R.string.recipe_name_six);
                break;
            case 6:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_seven);
                directionDetails.setText(R.string.direction_seven);
                recipeName.setText(R.string.recipe_name_seven);
                break;
            case 7:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_eight);
                directionDetails.setText(R.string.direction_eight);
                recipeName.setText(R.string.recipe_name_eight);
                break;
            case 8:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_nine);
                directionDetails.setText(R.string.direction_nine);
                recipeName.setText(R.string.recipe_name_nine);
                break;
            case 9:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_ten);
                directionDetails.setText(R.string.direction_ten);
                recipeName.setText(R.string.recipe_name_ten);
                break;
            case 10:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_eleven);
                directionDetails.setText(R.string.direction_eleven);
                recipeName.setText(R.string.recipe_name_eleven);
                break;
            case 11:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_twelve);
                directionDetails.setText(R.string.direction_twelve);
                recipeName.setText(R.string.recipe_name_twelve);
                break;
            case 12:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_thirdteen);
                directionDetails.setText(R.string.direction_thirdteen);
                recipeName.setText(R.string.recipe_name_thirdteen);
                break;
            case 13:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_fourteen);
                directionDetails.setText(R.string.direction_fourteen);
                recipeName.setText(R.string.recipe_name_fourteen);
                break;
            case 14:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_fifthteen);
                directionDetails.setText(R.string.direction_fifthteen);
                recipeName.setText(R.string.recipe_name_fifthteen);
                break;
            case 15:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_three);
                directionDetails.setText(R.string.direction_three);
                recipeName.setText(R.string.recipe_name_three);
                break;
            default:
                Picasso.with(foodImage.getContext())
                        .load(urlList[recipeNumber])
                        .error(R.drawable.pic1)
                        .into(foodImage);
                ingredientDetails.setText(R.string.ingredient_three);
                directionDetails.setText(R.string.direction_three);
                recipeName.setText(R.string.recipe_name_three);
                break;

        }

    }
}
