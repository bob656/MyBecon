package kr.co.retailtech.mybecon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.reactivex.disposables.Disposable;
import kr.co.retailtech.mybecon.reception.ReceptionUtil;
import kr.co.retailtech.mybecon.reception.pojo.BeaconInfoManager;
import kr.co.retailtech.mybecon.reception.pojo.BeaconInformation;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MapFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView txtTemp;

    private ReceptionUtil receptionUtil;
    private String TAG = MapFragment.class.getSimpleName();

    private OnFragmentInteractionListener mListener;

    private Disposable disposable;
    private final BeaconInfoManager manager = new BeaconInfoManager();

    public MapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapFragment newInstance(String param1, String param2) {
        MapFragment fragment = new MapFragment();
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
        View v = inflater.inflate(R.layout.fragment_map, container, false);

        receptionUtil = new ReceptionUtil(getActivity(),manager );

        txtTemp = (TextView)v.findViewById(R.id.txtInfo);
        Button btAdd =(Button)v.findViewById(R.id.btAdd);
        btAdd.setOnClickListener(this);


        return v;
    }
    public void updateView(BeaconInformation beaconInformation){
        Log.d(TAG, "Hear2");
        txtTemp.setText(beaconInformation.BeaconValueIndex_Major+":"+beaconInformation.BeaconValueIndex_Minor+":"+beaconInformation.BeaconValueIndex_Name+":"+beaconInformation.BeaconValueIndex_RSSI);
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
        /*
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        */
    }

    @Override
    public void onDetach() {
        super.onDetach();
        disposable.dispose();
        mListener = null;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btAdd:
                txtTemp.setText("버튼을 눌렀습니다.");
                disposable = manager.updateEvent().subscribe(this::updateView);

                receptionUtil.startBeacon();
                break;
        }
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
