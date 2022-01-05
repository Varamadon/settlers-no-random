package me.varam.settlers.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.varam.settlers.R
import me.varam.settlers.model.PlayerColor

class PlayerListAdapter(private val playerColorsList: List<PlayerColor>) :
    RecyclerView.Adapter<PlayerListAdapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.listPlayerColorLabel)

        init {
            // Define click listener for the ViewHolder's View.
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val playerColor = playerColorsList[position]
        viewHolder.textView.setText(playerNameMap[playerColor]!!)
        viewHolder.textView.setTextColor(playerColorMap[playerColor]!!)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = playerColorsList.size
}