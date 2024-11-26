package app.market.effectivemobilemock.ui.adapter_delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.market.domain.models.HomeHeaderModel
import app.market.effectivemobilemock.databinding.ItemHomeHeaderBinding

class HomeHeaderAdapter : RecyclerView.Adapter<HomeHeaderAdapter.HomeHeaderViewHolder>() {

    private val mainData: HomeHeaderModel = HomeHeaderModel()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHeaderViewHolder {
        return HomeHeaderViewHolder(
            ItemHomeHeaderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeHeaderViewHolder, position: Int) {
        holder.bind(mainData)
    }

    override fun getItemCount(): Int {
        return 1
    }

    inner class HomeHeaderViewHolder(private val binding: ItemHomeHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: HomeHeaderModel) {


        }
    }
}