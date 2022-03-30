package com.example.inf1030_tp1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inf1030_tp1.Adapters.ResultAdapter;
import com.example.inf1030_tp1.Models.Pharmacy;
import com.example.inf1030_tp1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ResultAdapter mResultAdapter;
    private List<Pharmacy> mPharmacyList;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ResultFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResultFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResultFragment newInstance(String param1, String param2) {
        ResultFragment fragment = new ResultFragment();
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
        View mView = inflater.inflate(R.layout.fragment_result, container, false);
        mPharmacyList = new ArrayList<>();
        initRecyclerView(mView);
loadResultSimulate(mView);
//
//                    new Handler().postDelayed(new Runnable() {
//
//                @Override
//                public void run() {
//                    // If this is the last question, ends the game.
//                    // Else, display the next question.
//                    initRecyclerView(mView);
//                    }
//            }, 2_000);

        return mView;
    }

    public void loadResultSimulate(View mView){

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // If this is the last question, ends the game.
                    // Else, display the next question.
                    for(int i = 0; i < 3; i++){
                        mResultAdapter.setPharmacyList(new Pharmacy("Phamaprix "  + i));
                    }
                    mView.findViewById(R.id.progressBar).setVisibility(View.GONE);
                }
            }, 2_000);


       // mView.findViewById(R.id.progressBar).setVisibility(View.GONE);
        //Add order in dataBase

        //After that we put back the static variables at null

    }
    private void initRecyclerView(View mView){
        RecyclerView recyclerView = mView.findViewById(R.id.recycler_view_result);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerItemDecoration);

        mPharmacyList.add(new Pharmacy("Phamaprix"));
        mResultAdapter = new ResultAdapter(getActivity(),mPharmacyList);
        recyclerView.setAdapter(mResultAdapter);
    }

}