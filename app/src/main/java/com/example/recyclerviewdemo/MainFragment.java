package com.example.recyclerviewdemo;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.recyclerviewdemo.adapter.PhotoListAdapter;
import com.example.recyclerviewdemo.adapter.TodoAdapter;
import com.example.recyclerviewdemo.model.Photo;
import com.example.recyclerviewdemo.model.Todo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Todo> todoList;
    ProgressDialog progressDoalog;
    RecyclerView rvContacts;
    List<Photo> photoList;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

//        rvContacts = view.findViewById(R.id.rcTodo);
//        PhotoListAdapter adapter = new PhotoListAdapter(photoList);
//        rvContacts.setAdapter(adapter);
//        rvContacts.setLayoutManager(new LinearLayoutManager(getActivity()));

        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        getPhotoListData(view);

        /*Create handle for the RetrofitInstance interface*/
//        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
//        Call<List<Todo>> call = service.getAllPhotos();
//        call.enqueue(new Callback<List<Todo>>() {
//            @Override
//            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
//                progressDoalog.dismiss();
//                rvContacts = view.findViewById(R.id.rcTodo);
//                TodoAdapter adapter = new TodoAdapter(response.body());
//                rvContacts.setAdapter(adapter);
//                rvContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
//            }
//
//            @Override
//            public void onFailure(Call<List<Todo>> call, Throwable t) {
//                progressDoalog.dismiss();
//                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
//            }
//        });

        return view;
    }

    private void getPhotoListData(View view) {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Photo>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                progressDoalog.dismiss();
                rvContacts = view.findViewById(R.id.rcTodo);
                PhotoListAdapter adapter = new PhotoListAdapter(getActivity(), response.body());
                rvContacts.setAdapter(adapter);
                rvContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
//    private void generateDataList(List<Todo> todoList) {
//        recyclerView = findViewById(R.id.customRecyclerView);
//        adapter = new CustomAdapter(this,photoList);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//    }
}