package shoppingitems.hoomi.com.shoppingitems;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hoomi.lib.shoppingitem.ShoppingItemService;
import com.hoomi.lib.shoppingitem.domain.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import shoppingitems.hoomi.com.shoppingitems.mvp.MPresenter;
import shoppingitems.hoomi.com.shoppingitems.mvp.MView;
import shoppingitems.hoomi.com.shoppingitems.mvp.ShoppingItemsPresenter;

public class MainActivity extends AppCompatActivity implements MView<List<Product>> {

    @BindView(R.id.shoppingItemsListView)
    ListView itemslistView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.errorMessage)
    TextView errorTextView;
    private MPresenter presenter;
    private ShoppingItemsAdapter shoppingItemsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new ShoppingItemsPresenter(ShoppingItemService.getInstance(), this);
        presenter.getData();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        errorTextView.setVisibility(View.GONE);
        itemslistView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        errorTextView.setVisibility(View.GONE);
        itemslistView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showResults(List<Product> products) {
        if (shoppingItemsAdapter == null) {
            shoppingItemsAdapter = new ShoppingItemsAdapter(this, products);
            itemslistView.setAdapter(shoppingItemsAdapter);
        } else {
            shoppingItemsAdapter.setItems(products);
        }
        if (products != null && products.size() > 0) {
            setTitle(getString(R.string.number_of_items) + products.size());
        } else {
            setTitle(getString(R.string.no_items_found));
            errorTextView.setText(R.string.no_items_found);
        }
    }

    @Override
    public void showError() {
        progressBar.setVisibility(View.GONE);
        itemslistView.setVisibility(View.GONE);
        errorTextView.setVisibility(View.VISIBLE);
        errorTextView.setText(R.string.error_string);
    }

    static class ShoppingItemsAdapter extends BaseAdapter {
        private final LayoutInflater layoutInflater;
        private List<Product> products;
        private final Picasso picasso;

        public ShoppingItemsAdapter(Context context, List<Product> products) {
            this.layoutInflater = LayoutInflater.from(context);
            this.picasso = Picasso.with(context);
            this.products = products;
        }

        @Override
        public int getCount() {
            return products == null ? 0 : products.size();
        }

        @Override
        public Product getItem(int position) {
            return products.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder vh;
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.item_row, parent, false);
                vh = new ViewHolder(convertView);
                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            Product product = getItem(position);
            vh.shoppingItemTitle.setText(product.getTitle());
            picasso.load(product.getImageRef()).fit().centerCrop().into(vh.shoppingItemImageView);

            return convertView;
        }

        public void setItems(List<Product> items) {
            this.products = items;
            notifyDataSetChanged();
        }

        static class ViewHolder {
            @BindView(R.id.itemImageView)
            ImageView shoppingItemImageView;
            @BindView(R.id.itemTitle)
            TextView shoppingItemTitle;

            public ViewHolder(View v) {
                ButterKnife.bind(this, v);
            }
        }
    }
}
