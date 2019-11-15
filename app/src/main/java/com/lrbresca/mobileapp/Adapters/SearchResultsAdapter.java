package com.lrbresca.mobileapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lrbresca.mobileapp.Models.Product;
import com.lrbresca.mobileapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.SearchResultsViewHolder> {

    private List<Product> products;
    private OnItemClickListener onItemClickListener;

    public SearchResultsAdapter(List<Product> searchResult, OnItemClickListener ontItemClickListener){
        this.products = searchResult;
        this.onItemClickListener = ontItemClickListener;
    }

    @Override
    public SearchResultsAdapter.SearchResultsViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View searchResultItemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_item_view, parent, false);

        SearchResultsViewHolder searchResultsViewHolder = new SearchResultsViewHolder(searchResultItemView);
        return searchResultsViewHolder;
    }

    @Override
    public void onBindViewHolder(SearchResultsViewHolder searchResultsHolder, int position) {
        searchResultsHolder.bind(products.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class SearchResultsViewHolder extends RecyclerView.ViewHolder {
        public ImageView productImage;
        public TextView productName;
        public TextView productPrice;

        public SearchResultsViewHolder(View v) {
            super(v);
            productImage = v.findViewById(R.id.productImageIV);
            productName = v.findViewById(R.id.productNameTV);
            productPrice = v.findViewById(R.id.priceTV);
        }

        public void bind(final Product product, final OnItemClickListener listener) {
            Picasso.get().load(product.getThumbnail()).placeholder(R.mipmap.ic_launcher).fit().into(productImage);
            productName.setText(product.getTitle());
            productPrice.setText(product.getPrice());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(product);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Product item);
    }

}