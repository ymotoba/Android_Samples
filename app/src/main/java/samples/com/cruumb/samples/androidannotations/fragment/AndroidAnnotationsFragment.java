package samples.com.cruumb.samples.androidannotations.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import samples.com.cruumb.samples.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AndroidAnnotationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@EFragment(R.layout.fragment_android_annotations)
public class AndroidAnnotationsFragment extends Fragment {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AndroidAnnotationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AndroidAnnotationsFragment newInstance() {
        AndroidAnnotationsFragment fragment = new AndroidAnnotationsFragment_();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public AndroidAnnotationsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View rootView = inflater.inflate(R.layout.fragment_android_annotations, container, false);
//        return rootView;
//    }

    @Click(R.id.sampleButton)
    void onClickSampleButton(View v) {
        System.out.println("onClickSampleButton");
        Toast.makeText(getActivity().getApplicationContext(), "onClickSampleButton", Toast.LENGTH_SHORT).show();
    }
}
