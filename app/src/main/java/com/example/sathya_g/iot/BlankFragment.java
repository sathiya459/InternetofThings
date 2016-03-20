package com.example.sathya_g.iot;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sathya_g.iot.dummy.DummyContent;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment implements AbsListView.OnItemClickListener  {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    private AbsListView mListView;
    private ListAdapter mAdapter;

    public static BlankFragment newInstance(int sectionNumber) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        ArrayList<String> listString=new ArrayList<>();
        listString.add("devce1");
        listString.add("devce2");
        listString.add("devce3");
        listString.add("devce4");
        args.putStringArrayList(ARG_PARAM1, listString);
        fragment.setArguments(args);
        return fragment;
    }

    public BlankFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*******************************/



        View view = inflater.inflate(R.layout.fragment_item2, container, false);

        Bundle bundle=getArguments();
        ArrayList<String> listString=bundle.getStringArrayList(ARG_PARAM1);
        final ListView locationList=(ListView)view.findViewById(android.R.id.list);
        locationList.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.select_dialog_singlechoice,listString));
locationList.setItemChecked(1, true);
        locationList.setItemChecked(3,true);
        locationList.setItemChecked(4,true);
        Toast.makeText(getActivity(),"running",Toast.LENGTH_SHORT).show();
      /*  mAdapter = new ArrayAdapter<DummyContent.DummyItem>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, DummyContent.ITEMS);


        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

*/        // Set OnItemClickListener so we can be notified on item clicks
        locationList.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        return view;


        /**********************************/
//        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
//        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((AdminHome) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
    public void onDetach() {
        super.onDetach( );

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView=(TextView)parent.getChildAt(position);
        textView.setText("sathya");
       view.setBackgroundColor(Color.RED);
        Toast.makeText(getActivity(),""+position,Toast.LENGTH_SHORT).show();
    }
}


