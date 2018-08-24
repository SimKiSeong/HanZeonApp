package com.example.user.mother;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import android.R.layout;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static String ttTime = null;
    public static String ttTitle = null;
    public static String spinerTime = null;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    public AddFragment() {
        // Required empty public constructor



    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();
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


    private ArrayAdapter timeAdapter;
    private Spinner timeSpinner;




    private static EditText e_title;
    private static EditText eprofes;
    private static EditText eroom;
    public static EditText etime;
    private static TextView tvList;
    private static Button btnInsert;
    private static Button btnDelete;
    // DB에 저장 될 속성을 입력받는다


    // 쿼리 결과 입력



    public String TIME[]=new String[1];




    static DBManager dbManager;

    public void onActivityCreated(Bundle b) {

        super.onActivityCreated(b);



        final TextView tvList = (TextView) getView().findViewById(R.id.tv_list);
        final EditText e_title = (EditText) getView().findViewById(R.id.ttTitle);
        final EditText eprofes = (EditText) getView().findViewById(R.id.ttProfes);
        final EditText eroom = (EditText) getView().findViewById(R.id.ttRoom);
       // final EditText etime = (EditText) getView().findViewById(R.id.ttTime);


        dbManager = new DBManager(getActivity().getApplicationContext(), "Timetable2.db", null, 1);


      // scheduleFragment = new ScheduleFragment();

        Button btnInsert = (Button) getView().findViewById(R.id.insert_btn);

        timeSpinner =(Spinner) getView().findViewById(R.id.timeSpinner);



        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.timeArray, android.R.layout.simple_spinner_item);



        //스피너와 어댑터 연결

       timeSpinner.setAdapter(adapter);



        spinerTime = timeSpinner.getSelectedItem().toString();

        timeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id)
            {
                spinerTime = (String) timeSpinner.getSelectedItem();
                //Toast.makeText(getActivity().getApplicationContext(), parent.getItemAtPosition(position).toString()+"을 선택하셨습니다", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }


        });

        btnInsert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // insert into 테이블명 values (값, 값, 값...);
                ttTitle = e_title.getText().toString();
                ttTime = spinerTime;
                String ttRoom = eroom.getText().toString();
                String ttProfes = eprofes.getText().toString();



                if (!ttTitle.equals("") && ttTitle.length() > 0) {

                    dbManager.insert("insert into TIMETABLE_LIST values(null, '" + ttTitle + "','" + ttTime + "','"+ ttRoom + "','" + ttProfes + "');");


                    Toast.makeText(getActivity(), "성공적으로 추가되었습니다", Toast.LENGTH_SHORT).show();

                    tvList.setText( dbManager.PrintData2() );



                } else

                    Toast.makeText(getActivity(), "과목을 입력해주세요!", Toast.LENGTH_SHORT).show();//Display toast if edittext is empty
                Intent intent = new Intent(getActivity(), AddFragment.class);









            }
        });




        // Delete
        Button btnDelete = (Button) getView().findViewById(R.id.delete_btn);
        btnDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // delete from 테이블명 where 조건;
                String ttTitle = e_title.getText().toString();

                if (!ttTitle.equals("") && ttTitle.length() > 0) {
                    dbManager.delete("delete from TIMETABLE_LIST where ttTitle = '" + ttTitle + "';");

                    Toast.makeText(getActivity(), "삭제되었습니다", Toast.LENGTH_SHORT).show();
                    tvList.setText(dbManager.PrintData2());
                }else
                    Toast.makeText(getActivity(), "삭제할 과목을 입력해주세요!", Toast.LENGTH_SHORT).show();//Display toast if edittext is empty
                Intent intent = new Intent(getActivity(), AddFragment.class);



                //delete를 하면 색칠된것이 풀리도록
            }
        });


        // Select
        Button btnSelect = (Button) getView().findViewById(R.id.select_btn);

        btnSelect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                tvList.setText(dbManager.PrintData2());
            }
        });


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI eveTnt
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

    @Override
    public void onClick(View view) {

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
