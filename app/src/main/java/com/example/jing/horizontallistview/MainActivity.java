package com.example.jing.horizontallistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private Filter[] filters = new Filter[8];

    // resource id for imageview
    private int[] imagesIdentifiers = {R.drawable.ballon_s, R.drawable.painting, R.drawable.rc, R.drawable.rgv,
                                        R.drawable.bbwe, R.drawable.bbce, R.drawable.wbbe, R.drawable.wbce};
    // string content for textview
    private String[] filterNames = {"origin", "painting", "RC", "RGV", "black edge", "color edge", "black edge", "color edge"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inflate the recycler view.
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        mRecyclerView.setHasFixedSize(true);// set the size of recycler view fixed.

        // in order to have a horizontal recycler view
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,true);
        // add the layout manager to layout
        mRecyclerView.setLayoutManager(mLayoutManager);

        // set up the filters information.
        filters = getFilters();

        // set up the adapter.
        mAdapter = new FilterAdapter(filters);

        // add filter adapters to recycler view
        mRecyclerView.setAdapter(mAdapter);

        // As the horizontal recycler view is from right to left, so focus on the last item, left of the list
        mRecyclerView.smoothScrollToPosition( filterNames.length - 1);
    }

    private Filter[] getFilters() {
        for (int i = 0; i <  filterNames.length; i++) {
            filters[i] = new Filter();
            filters[i].setFilterImage(getDrawable(imagesIdentifiers[ filterNames.length - 1 - i]));
            filters[i].setFilterName( filterNames[ filterNames.length - 1 - i]);
        }
        return filters;
    }
}
