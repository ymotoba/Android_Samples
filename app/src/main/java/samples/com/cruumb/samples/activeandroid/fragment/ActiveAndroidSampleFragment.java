package samples.com.cruumb.samples.activeandroid.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

import java.util.List;
import java.util.Random;

import samples.com.cruumb.samples.R;
import samples.com.cruumb.samples.activeandroid.models.Item;

/**
 * ActiveAndroidのサンプル用fragment
 */
public class ActiveAndroidSampleFragment extends Fragment implements View.OnClickListener {
    /**
     * new instance.
     *
     * @return
     */
    public static ActiveAndroidSampleFragment newInstance() {
        ActiveAndroidSampleFragment fragment = new ActiveAndroidSampleFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * constructor.
     */
    public ActiveAndroidSampleFragment() {
        // Required empty public constructor
    }

    /**
     * onCreate.
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * onCreateView
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_activeandroid_sample, container, false);
        root.findViewById(R.id.insertButton).setOnClickListener((View.OnClickListener) this);
        root.findViewById(R.id.selectButton).setOnClickListener((View.OnClickListener) this);
        root.findViewById(R.id.deleteButton).setOnClickListener((View.OnClickListener) this);
        return root;
    }

    /**
     * onAttach
     *
     * @param activity
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    /**
     * onDetach
     */
    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * onClick
     *
     * @param v
     */
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
        new Delete().from(Item.class).execute();
    }

    /**
     * insert random data.
     */
    private void insertData() {
        Item item = new Item();
        item.name = "Outback Steakhouse" + new Random().nextInt();
        item.save();
    }

    /**
     * select all.
     */
    private void selectData() {
        List<Item> itemList = new Select()
                .from(Item.class)
                .orderBy("Name ASC")
                .execute();
        TextView resultTextView = (TextView) getView().findViewById(R.id.resultTextView);
        String result = "";
        for (int i = 0; i < itemList.size(); i++) {
            result += itemList.get(i).name + "¥n";
        }
        resultTextView.setText(result);
    }
}
