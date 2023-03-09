package abdulrahman.ali19.klim.view.home.adapters

import abdulrahman.ali19.klim.data.pojo.DinosaurResponse
import abdulrahman.ali19.klim.databinding.ItemLayoutBinding
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(
    private var items: List<DinosaurResponse>
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newItems: List<DinosaurResponse>) {
        items = newItems
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        lateinit var currentItem: DinosaurResponse

        fun bind(pos: Int) {
            currentItem = items[pos]
            binding.apply {
                title.text = currentItem.name
                desc.text = currentItem.description
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
        HomeViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) = holder.bind(position)
}