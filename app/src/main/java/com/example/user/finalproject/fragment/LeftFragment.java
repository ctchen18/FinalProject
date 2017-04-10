package com.example.user.finalproject.fragment;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.user.finalproject.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LeftFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LeftFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeftFragment extends Fragment implements View.OnTouchListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public LeftFragment() {
        // Required empty public constructor
    }
    GestureDetector mGestureDetector;

    private Integer imgSetNumber;

    private String[] urls;
    @BindView(R.id.img_slot_1)
    ImageView img1;

    @BindView(R.id.img_slot_2)
    ImageView img2;

    @BindView(R.id.img_slot_3)
    ImageView img3;

    @BindView(R.id.img_slot_4)
    ImageView img4;

    @BindView(R.id.img_slot_5)
    ImageView img5;

    @BindView(R.id.img_slot_6)
    ImageView img6;

    @BindView(R.id.grid_layout)
    GridLayout gl;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeftFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeftFragment newInstance(String param1, String param2) {
        LeftFragment fragment = new LeftFragment();
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
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        ButterKnife.bind(this,view);
        urls = getResources().getStringArray(R.array.urls);
        Picasso.with(img1.getContext())
                .load(urls[0].trim())
                .fit()
                .error(R.drawable.pic1)
                .into(img1);
        Picasso.with(img2.getContext())
                .load(urls[1].trim())
                .fit()
                .error(R.drawable.pic1)
                .into(img2);
        Picasso.with(img3.getContext())
                .load(urls[2].trim())
                .fit()
                .error(R.drawable.pic1)
                .into(img3);
        Picasso.with(img4.getContext())
                .load(urls[3].trim())
                .fit()
                .error(R.drawable.pic1)
                .into(img4);
        Picasso.with(img5.getContext())
                .load(urls[4].trim())
                .fit()
                .error(R.drawable.pic1)
                .into(img5);
        Picasso.with(img6.getContext())
                .load(urls[5].trim())
                .fit()
                .error(R.drawable.pic1)
                .into(img6);


        mGestureDetector = new GestureDetector(getActivity(),new simpleGestureListener());
        gl.setOnTouchListener(this);
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
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
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

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent e) {
            return true;
        }
        public void onShowPress(MotionEvent e){

            //return false;
        }
        public void onLongPress(MotionEvent e){

            //return false;
        }
        public boolean onSingleTapUp(MotionEvent e){

            return true;
        }
        public boolean onSingleTapConfirmed(MotionEvent e){

            return true;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if(imgSetNumber==null)
                imgSetNumber=0;

            if(distanceY>0 && imgSetNumber==0) {
                imgSetNumber=1;
                Log.d("distanceY set"+String.valueOf(imgSetNumber),String.valueOf(distanceY));
                showSet2();
            }
            else if(distanceY<0 && imgSetNumber==1) {
                imgSetNumber=0;
                Log.d("distanceY set"+String.valueOf(imgSetNumber),String.valueOf(distanceY));
                showSet1();
            }



            return false;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        public boolean onDoubleTap(MotionEvent e) {
            return super.onDoubleTap(e);
        }
    }
        public void switchImages(){

        }
        public void showSet1(){
            //gl.setVisibility(View.INVISIBLE);
            Picasso.with(img1.getContext())
                    .load(urls[0])
                    .error(R.drawable.pic1)
                    .fit()
                    .into(img1);
            Picasso.with(img2.getContext())
                    .load(urls[1])
                    .error(R.drawable.pic1)
                    .fit()
                    .into(img2);
            Picasso.with(img3.getContext())
                    .load(urls[2])
                    .error(R.drawable.pic1)
                    .fit()
                    .into(img3);
            Picasso.with(img4.getContext())
                    .load(urls[3])
                    .error(R.drawable.pic1)
                    .fit()
                    .into(img4);
            Picasso.with(img5.getContext())
                    .load(urls[4])
                    .error(R.drawable.pic1)
                    .fit()
                    .into(img5);
            Picasso.with(img6.getContext())
                    .load(urls[5])
                    .error(R.drawable.pic1)
                    .fit()
                    .into(img6);
            gl.setPivotY(0);
           // gl.setVisibility(View.VISIBLE);
            PropertyValuesHolder p1=PropertyValuesHolder.ofFloat("ScaleY",0,1);
            ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(gl,p1);
            animator.setDuration(500);
            animator.start();
        }
        public void showSet2(){
            //gl.setVisibility(View.INVISIBLE);
            Picasso.with(img1.getContext())
                    .load(urls[6])
                    .error(R.drawable.pic1)
                    .fit()
                    .into(img1);
            Picasso.with(img2.getContext())
                    .load(urls[7])
                    .error(R.drawable.pic1)
                    .fit()
                    .into(img2);
            Picasso.with(img3.getContext())
                    .load(urls[8])
                    .error(R.drawable.pic1)
                    .fit()
                    .into(img3);
            Picasso.with(img4.getContext())
                    .load(urls[9])
                    .error(R.drawable.pic1)
                    .fit()
                    .into(img4);
            Picasso.with(img5.getContext())
                    .load(urls[10])
                    .error(R.drawable.pic1)
                    .fit()
                    .into(img5);
            Picasso.with(img6.getContext())
                    .load(urls[11])
                    .error(R.drawable.pic1)
                    .fit()
                    .into(img6);
            gl.setPivotY(0);
           // gl.setVisibility(View.VISIBLE);
            PropertyValuesHolder p1=PropertyValuesHolder.ofFloat("ScaleY",0,1);
            ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(gl,p1);
            animator.setDuration(500);
            animator.start();
        }
}
