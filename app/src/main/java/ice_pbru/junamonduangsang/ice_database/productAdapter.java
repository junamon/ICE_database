package ice_pbru.junamonduangsang.ice_database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by ice on 11/5/2559.
 */
public class productAdapter extends BaseAdapter {

    private Context context;
    private String[] iconStrins, tiileStrings;

    public productAdapter(Context context, String[] iconStrins, String[] tiileStrings) {
        this.context = context;
        this.iconStrins = iconStrins;
        this.tiileStrings = tiileStrings;
    }

    @Override
    public int getCount() {
        return iconStrins.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.product_listview, viewGroup, false);

        TextView titleTextView = (TextView) view1.findViewById(R.id.editText7);
        titleTextView.setText(tiileStrings[i]);

        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imageView2);
        Picasso.with(context).load(iconStrins[i]).resize(100,140).into(iconImageView);


        return view1;
    }
}
