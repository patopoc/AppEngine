package com.example.bg.appengine.modules;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bg.appengine.Component;
import com.example.bg.appengine.utils.DataHandler;
import com.google.gson.Gson;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ModuleContainer.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class ModuleContainer extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    final String TAG = "ModuleContainer";
    public static final String MOD_LAYOUT = "modLayout";
    public static final String MOD_NAME = "modName";

    // TODO: Rename and change types of parameters
    private String modLayout;

    private OnFragmentInteractionListener mListener;


    public ModuleContainer() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Gson gson = new Gson();
        String modName = "";
        if (getArguments() != null) {
            modLayout = getArguments().getString(MOD_LAYOUT);
            modName = getArguments().getString(MOD_NAME);
        }
        DataHandler dataHandler = new DataHandler(getActivity());
        String jsonComponents = (String) dataHandler.getFromAsset("ComponentsData.json", "text");
        ComponentsArray allComps = gson.fromJson(jsonComponents, ComponentsArray.class);
        List<Component> components = allComps.getChildrenOf(modName);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(getResources().getIdentifier(modLayout, "layout"
                , container.getContext().getPackageName()), container, false);
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
