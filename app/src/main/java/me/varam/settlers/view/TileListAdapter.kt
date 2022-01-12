package me.varam.settlers.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.varam.settlers.R
import me.varam.settlers.model.Tile

class TileListAdapter(
    private val tilesList: List<Tile>
) :
    RecyclerView.Adapter<TileListAdapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val resourceLabel: TextView = view.findViewById(R.id.tileResourceLabel)
        val tokenLabel: TextView = view.findViewById(R.id.tileTokenLabel)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.tiles_list_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val tile = tilesList[position]
        viewHolder.resourceLabel.text = tile.resourceType.toString()
        viewHolder.tokenLabel.text = tile.numberToken.toString()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = tilesList.size
}