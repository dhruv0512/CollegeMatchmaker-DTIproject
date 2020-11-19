package com.example.myapplication.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;

public class SearchFragment extends Fragment {

    private SearchViewModel searchViewModel;
    SearchView searchView;
    ListView listView;
    String[] listItem= {"Indian Institute of Technology - IIT","Indian Institute of Management - IIM","Top B.tech Colleges","Top MBA Colleges",
    "Tob MBBS colleges","All India Institute of Medical Sciences - AIIMS"};
    ArrayAdapter<String> arrayAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        searchView= (SearchView) root.findViewById(R.id.search_bar);
        listView= (ListView) root.findViewById(R.id.list_items);
        arrayAdapter= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,android.R.id.text1,listItem);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(getActivity(),"You click"+parent.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SearchFragment.this.arrayAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                SearchFragment.this.arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });



        searchViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}