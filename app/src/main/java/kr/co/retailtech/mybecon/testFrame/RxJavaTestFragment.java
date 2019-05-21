package kr.co.retailtech.mybecon.testFrame;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kr.co.retailtech.mybecon.testFrame.TemperatureManager.Temperature;
import kr.co.retailtech.mybecon.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RxJavaTestFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RxJavaTestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RxJavaTestFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private final TemperatureManager manager = new TemperatureManager();
    private Disposable disposable;

    public RxJavaTestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RxJavaTestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RxJavaTestFragment newInstance(String param1, String param2) {
        RxJavaTestFragment fragment = new RxJavaTestFragment();
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

            disposable = manager.updateEvent().subscribe(this::updateView);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_rx_java_test, container, false);
        Button btChangeValue =(Button)v.findViewById(R.id.btChangeValue);
        btChangeValue.setOnClickListener(this);

        Button btGitTest =(Button)v.findViewById(R.id.btGitTest);
        btGitTest.setOnClickListener(this);
        return v;
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            /*
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
                    */
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        disposable.dispose();
        mListener = null;
    }

    private void updateView(Temperature temperature) {
        //Toast.makeText(getView().getContext(),String.format("Current Temperature: %d", temperature.getDegree()),Toast.LENGTH_SHORT).show();
        TextView tvTemp = (TextView)getView().findViewById(R.id.txtTemp);
        tvTemp.setText(String.format("Current Temperature: %d", temperature.getDegree()));
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
    Temperature temperature = new Temperature(20000);

    @Override
    public void onClick(View v) {
        TextView tvTemp = (TextView)getView().findViewById(R.id.txtTemp);

        switch (v.getId()){
            case R.id.btChangeValue:

                int degree = temperature.getDegree() +3000;

                temperature.setCurrentTemperature(degree);
                updateView(temperature);
                break;
            case R.id.btGitTest:
                break;
        }
    }

}
