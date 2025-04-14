package br.com.brunoferrari.mobile.trabalho.ui.cronograma;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.brunoferrari.mobile.trabalho.databinding.FragmentConCronogramaBinding;
import br.com.brunoferrari.mobile.trabalho.model.Cronograma;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Cronograma}.
 * TODO: Replace the implementation with code for your data type.
 */
public class CronogramaRecyclerViewAdapter extends RecyclerView.Adapter<CronogramaRecyclerViewAdapter.ViewHolder> {

    private final List<Cronograma> mValues;

    public CronogramaRecyclerViewAdapter(List<Cronograma> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentConCronogramaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getCliente());
        holder.mContentView.setText(mValues.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Cronograma mItem;

        public ViewHolder(FragmentConCronogramaBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}