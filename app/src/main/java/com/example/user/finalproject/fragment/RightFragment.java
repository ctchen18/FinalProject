package com.example.user.finalproject.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.finalproject.R;
import com.example.user.finalproject.adapter.ListViewAdapter;
import com.example.user.finalproject.adapter.ViewPagerAdapter;
import com.example.user.finalproject.dialog.CustomDialog;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RightFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RightFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RightFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ArrayList<String> listViewItems = new ArrayList<String>();


    public RightFragment() {
        // Required empty public constructor
    }

//    @BindView(R.id.filter_button)
//    Button filterBtn;
//    @BindView(R.id.list_view)
//    ListView listView;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RightFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RightFragment newInstance(String param1, String param2) {
        RightFragment fragment = new RightFragment();
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
        listViewItems.add(getString(R.string.recipe_name_one));
        listViewItems.add(getString(R.string.recipe_name_two));
        listViewItems.add(getString(R.string.recipe_name_three));
        listViewItems.add(getString(R.string.recipe_name_four));
        listViewItems.add(getString(R.string.recipe_name_five));
        listViewItems.add(getString(R.string.recipe_name_six));
        listViewItems.add(getString(R.string.recipe_name_seven));
        listViewItems.add(getString(R.string.recipe_name_eight));
        listViewItems.add(getString(R.string.recipe_name_nine));
        listViewItems.add(getString(R.string.recipe_name_ten));
        listViewItems.add(getString(R.string.recipe_name_eleven));
        listViewItems.add(getString(R.string.recipe_name_twelve));
        listViewItems.add(getString(R.string.recipe_name_thirdteen));
        listViewItems.add(getString(R.string.recipe_name_fourteen));
        listViewItems.add(getString(R.string.recipe_name_fifthteen));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_right, container, false);
            //ButterKnife.bind(this,view);
            ListView listView = (ListView) view.findViewById(R.id.list_view);
            //listView.addHeaderView(filterBtn);

            ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(), listViewItems);
            listView.setAdapter(listViewAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d("listViewClickAdapter",String.valueOf(position));
                        customDialog(position);
                }
            });
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

    private void customDialog(int recipeNumber) {
        CustomDialog dialog = new CustomDialog(getActivity(), new CustomDialog.ICustomDialogEventListener() {
            @Override
            public void onClickListener() {
                Intent intent = new Intent();
            }

            @Override
            public void lastClickedItem(String recipeName) {
                Log.d("returned",recipeName);
                Toast.makeText(getContext(),"You have returned from "+recipeName,Toast.LENGTH_LONG).show();


            }
        },recipeNumber);
        dialog.show();
    }
}
