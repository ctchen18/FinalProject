package com.example.user.finalproject.fragment;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.finalproject.ChangeBackGroundActivity;
import com.example.user.finalproject.R;
import com.example.user.finalproject.recipe.RecipeController;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CenterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CenterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CenterFragment extends Fragment implements RecipeController.IRecipeStatus{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String url = "http://img.sndimg.com/food/image/upload/h_420,w_560,c_fit/v1/img/recipes/89/20/4/uxMwt1VGQ5m2ePyzwHWy_salsa-chicken-black-beans-2312.jpg";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecipeController controller;
    private Handler mHandler = new Handler();
    public CenterFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.food_image)
    ImageView imageView;
    @BindView(R.id.center_recipe_name)
    TextView recipeName;
    @BindView(R.id.center_direction_details)
    TextView directionDetails;
    @BindView(R.id.center_ingredient_details)
    TextView ingredientDetails;
    @BindView(R.id.center_fragment)
    FrameLayout centerFragment;

    @OnClick(R.id.bg_change_btn)
    public void bgChangeCicked(){
        Intent intent = new Intent(getActivity(), ChangeBackGroundActivity.class);
        startActivityForResult(intent,1);
    }
    @OnClick(R.id.next_recipe_btn)
    public void nextButtonClicked(){
        controller.getFeaturedRecipe(0,14);
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CenterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CenterFragment newInstance(String param1, String param2) {
        CenterFragment fragment = new CenterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_center, container, false);
        ButterKnife.bind(this,view);
        Picasso.with(imageView.getContext())
                .load(url)
                .into(imageView);
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "alpha", 1,0,1); //translationY
        animator.setDuration(2000);
        animator.start();

        //starts a controll and then controller to service
        controller = RecipeController.getInstance(getContext());
        controller.addListener("PlayView",this);
        controller.getFeaturedRecipe(0,14);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onComplete(int featuredNumber) {
        Log.d("centerFragment","received  completion message"+String.valueOf(featuredNumber));
        int recipeNumber = featuredNumber;
        String[] urlList = getResources().getStringArray(R.array.urls);
        ImageView foodImage = imageView;

        switch (featuredNumber){

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
            default:
                break;

        }
    }

    @Override
    public void onError() {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent data) {

        if (requestCode == 1) {
            String result=data.getStringExtra("BackgroundColor");
            if(result.contains("Blue")) {
                Log.d("runnable","blue detected");
                mHandler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        centerFragment.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                    }
                }, 3000);


            }

                else if (result.contains("Green"))
                        centerFragment.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                else if (result.contains("Red"))
                        centerFragment.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                else if (result.contains("Orange"))
                        centerFragment.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
//                else if (result.contains("Blue"))
//                        centerFragment.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                }

            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }

    }//onActivityResult
    @Override
    public void onDestroy() {
        controller.destroy();
        super.onDestroy();
    }

}
