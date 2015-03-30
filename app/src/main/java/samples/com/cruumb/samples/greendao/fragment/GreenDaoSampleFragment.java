package samples.com.cruumb.samples.greendao.fragment;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import samples.com.cruumb.samples.Const;
import samples.com.cruumb.samples.R;
import samples.com.cruumb.samples.greendao.db.DaoMaster;
import samples.com.cruumb.samples.greendao.db.DaoSession;
import samples.com.cruumb.samples.greendao.db.HogeTable;
import samples.com.cruumb.samples.greendao.db.HogeTableDao;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GreenDaoSampleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GreenDaoSampleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GreenDaoSampleFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GreenDaoSampleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GreenDaoSampleFragment newInstance(/*String param1, String param2*/) {
        GreenDaoSampleFragment fragment = new GreenDaoSampleFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public GreenDaoSampleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_green_dao_sample, container, false);
        root.findViewById(R.id.insertButton).setOnClickListener((View.OnClickListener) this);
        root.findViewById(R.id.selectButton).setOnClickListener((View.OnClickListener) this);
        root.findViewById(R.id.deleteButton).setOnClickListener((View.OnClickListener) this);
        return root;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.insertButton) {
            insertData();
        } else if (id == R.id.selectButton) {
            selectData();
        } else if (id == R.id.deleteButton) {
            deleteData();
        }
    }

    /**
     * delete all.
     */
    private void deleteData() {
        SQLiteDatabase db = new DaoMaster.DevOpenHelper(this.getActivity().getApplicationContext(),
                Const.DB_NAME, null).getWritableDatabase();
        DaoSession daoSession = new DaoMaster(db).newSession();
        HogeTableDao hogeTableDao = daoSession.getHogeTableDao();
        hogeTableDao.deleteAll();
    }
    /**
     * insert random data.
     */
    private void insertData() {
        SQLiteDatabase db = new DaoMaster.DevOpenHelper(this.getActivity().getApplicationContext(),
                Const.DB_NAME, null).getWritableDatabase();
        DaoSession daoSession = new DaoMaster(db).newSession();
        HogeTableDao hogeTableDao = daoSession.getHogeTableDao();

        HogeTable hogeTable = new HogeTable();
        hogeTable.setFuga(new Random().nextLong());
        hogeTable.setHoge("hoge");

        hogeTableDao.insertWithoutSettingPk(hogeTable);
    }

    /**
     * select all.
     */
    private void selectData() {
        SQLiteDatabase db = new DaoMaster.DevOpenHelper(this.getActivity().getApplicationContext(),
                Const.DB_NAME, null).getWritableDatabase();
        DaoSession daoSession = new DaoMaster(db).newSession();
        HogeTableDao hogeTableDao = daoSession.getHogeTableDao();

        List<HogeTable> hogeTableList = hogeTableDao.queryBuilder()
                .orderDesc(HogeTableDao.Properties.Id)
                .list();
//        List<HogeTable> hogeTableList = hogeTableDao.loadAll();
        for (int i = 0; i < hogeTableList.size(); i++) {
            TextView resultTextView = (TextView) getView().findViewById(R.id.resultTextView);
            resultTextView.setText(Long.toString(hogeTableList.get(i).getId()));
        }
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
