package com.example.q25toq43.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.q25toq43.databinding.ActivityItemBinding

class ActivityAdapter(private val context: Context, private val activities: ArrayList<Class<*>>,  private val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<ActivityAdapter.ItemViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(activityClass: Class<*>)
    }

    class ItemViewHolder(val binding: ActivityItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ActivityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return activities.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val activity = activities[position]
        holder.binding.textView.text = activity.simpleName // Display the simple name of the activity class
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(activity)
        }
    }
}
