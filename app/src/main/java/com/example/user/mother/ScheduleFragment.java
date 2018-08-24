package com.example.user.mother;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScheduleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private String refTime;
    private String refTitle;
    private String refspinerTime;

    public ScheduleFragment() {
        // Required empty public constructor
        refTime = AddFragment.ttTime;
        refTitle= AddFragment.ttTitle;
        refspinerTime=AddFragment.spinerTime;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScheduleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScheduleFragment newInstance(String param1, String param2) {
        ScheduleFragment fragment = new ScheduleFragment();
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
//시간표 각 칸
    public AutoResizeTextView Mon[] = new AutoResizeTextView[10];
    public AutoResizeTextView Tue[] =new AutoResizeTextView[10];
    public  AutoResizeTextView Wed[] =new AutoResizeTextView[10];
    public AutoResizeTextView Thur[] =new AutoResizeTextView[10];
    public AutoResizeTextView Fri[] =new AutoResizeTextView[10];

    static DBManager dbManager;

    private String p3Str;
    private  String p3Array[];




 //   public SchduelActivity schedule = new SchduelActivity();




    public void onActivityCreated(Bundle b) {

        super.onActivityCreated(b);

        dbManager = new DBManager(getActivity().getApplicationContext(), "Timetable2.db", null, 1);

        Mon[0]=(AutoResizeTextView)getView().findViewById(R.id.Mon1);
        Mon[1]=(AutoResizeTextView)getView().findViewById(R.id.Mon2);
        Mon[2]=(AutoResizeTextView)getView().findViewById(R.id.Mon3);
        Mon[3]=(AutoResizeTextView)getView().findViewById(R.id.Mon4);
        Mon[4]=(AutoResizeTextView)getView().findViewById(R.id.Mon5);
        Mon[5]=(AutoResizeTextView)getView().findViewById(R.id.Mon6);
        Mon[6]=(AutoResizeTextView)getView().findViewById(R.id.Mon7);
        Mon[7]=(AutoResizeTextView)getView().findViewById(R.id.Mon8);
        Mon[8]=(AutoResizeTextView)getView().findViewById(R.id.Mon9);
        Mon[9]=(AutoResizeTextView)getView().findViewById(R.id.Mon10);




        Tue[0]=(AutoResizeTextView)getView().findViewById(R.id.Tue1);
        Tue[1]=(AutoResizeTextView)getView().findViewById(R.id.Tue2);
        Tue[2]=(AutoResizeTextView)getView().findViewById(R.id.Tue3);
        Tue[3]=(AutoResizeTextView)getView().findViewById(R.id.Tue4);
        Tue[4]=(AutoResizeTextView)getView().findViewById(R.id.Tue5);
        Tue[5]=(AutoResizeTextView)getView().findViewById(R.id.Tue6);
        Tue[6]=(AutoResizeTextView)getView().findViewById(R.id.Tue7);
        Tue[7]=(AutoResizeTextView)getView().findViewById(R.id.Tue8);
        Tue[8]=(AutoResizeTextView)getView().findViewById(R.id.Tue9);
        Tue[9]=(AutoResizeTextView)getView().findViewById(R.id.Tue10);


        Wed[0]=(AutoResizeTextView)getView().findViewById(R.id. Wed1);
        Wed[1]=(AutoResizeTextView)getView().findViewById(R.id. Wed2);
        Wed[2]=(AutoResizeTextView)getView().findViewById(R.id. Wed3);
        Wed[3]=(AutoResizeTextView)getView().findViewById(R.id. Wed4);
        Wed[4]=(AutoResizeTextView)getView().findViewById(R.id. Wed5);
        Wed[5]=(AutoResizeTextView)getView().findViewById(R.id. Wed6);
        Wed[6]=(AutoResizeTextView)getView().findViewById(R.id. Wed7);
        Wed[7]=(AutoResizeTextView)getView().findViewById(R.id. Wed8);
        Wed[8]=(AutoResizeTextView)getView().findViewById(R.id. Wed9);
        Wed[9]=(AutoResizeTextView)getView().findViewById(R.id. Wed10);


        Thur[0]=(AutoResizeTextView)getView().findViewById(R.id.Thur1);
        Thur[1]=(AutoResizeTextView)getView().findViewById(R.id.Thur2);
        Thur[2]=(AutoResizeTextView)getView().findViewById(R.id.Thur3);
        Thur[3]=(AutoResizeTextView)getView().findViewById(R.id.Thur4);
        Thur[4]=(AutoResizeTextView)getView().findViewById(R.id.Thur5);
        Thur[5]=(AutoResizeTextView)getView().findViewById(R.id.Thur6);
        Thur[6]=(AutoResizeTextView)getView().findViewById(R.id.Thur7);
        Thur[7]=(AutoResizeTextView)getView().findViewById(R.id.Thur8);
        Thur[8]=(AutoResizeTextView)getView().findViewById(R.id.Thur9);
        Thur[9]=(AutoResizeTextView)getView().findViewById(R.id.Thur10);


        Fri[0]=(AutoResizeTextView)getView().findViewById(R.id.Fri1);
        Fri[1]=(AutoResizeTextView)getView().findViewById(R.id.Fri2);
        Fri[2]=(AutoResizeTextView)getView().findViewById(R.id.Fri3);
        Fri[3]=(AutoResizeTextView)getView().findViewById(R.id.Fri4);
        Fri[4]=(AutoResizeTextView)getView().findViewById(R.id.Fri5);
        Fri[5]=(AutoResizeTextView)getView().findViewById(R.id.Fri6);
        Fri[6]=(AutoResizeTextView)getView().findViewById(R.id.Fri7);
        Fri[7]=(AutoResizeTextView)getView().findViewById(R.id.Fri8);
        Fri[8]=(AutoResizeTextView)getView().findViewById(R.id.Fri9);
        Fri[9]=(AutoResizeTextView)getView().findViewById(R.id.Fri10);

        //Mon[4].setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        p3Str = dbManager.PrintData3();
        p3Array=p3Str.split(",");



    setting();




    }




    //색칠하는 함수
   public  void setting() {

       for (int j = 0; j < p3Array.length; j++) {

           for (int i = 0; i < 10; i++) {

               if (p3Array[j].equals("Mon" + Integer.valueOf(i+1))) {
                   Mon[i].setText(p3Array[j+1]);
                   Mon[i].setBackgroundColor(getResources().getColor(R.color.colorPrimary));//색칠
               }

               if (p3Array[j].equals("Tue" + Integer.valueOf(i+1))) {
                   Tue[i].setText(p3Array[j+1]);
                   Tue[i].setBackgroundColor(getResources().getColor(R.color.colorPrimary));//색칠
               }

               if (p3Array[j].equals("Wed" + Integer.valueOf(i+1))) {
                   Wed[i].setText(p3Array[j+1]);
                   Wed[i].setBackgroundColor(getResources().getColor(R.color.colorPrimary));//색칠
               }

               if (p3Array[j].equals("Thur" + Integer.valueOf(i+1))) {
                   Thur[i].setText(p3Array[j+1]);
                   Thur[i].setBackgroundColor(getResources().getColor(R.color.colorPrimary));//색칠
               }

               if (p3Array[j].equals("Fri" + Integer.valueOf(i+1))) {
                   Fri[i].setText(p3Array[j+1]);
                   Fri[i].setBackgroundColor(getResources().getColor(R.color.colorPrimary));//색칠11
               }



           }

           j++;
       }


   }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
}
