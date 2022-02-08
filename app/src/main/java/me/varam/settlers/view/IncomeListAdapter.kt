package me.varam.settlers.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.varam.settlers.R
import me.varam.settlers.model.PlayerColor
import me.varam.settlers.model.ResourceType

class IncomeListAdapter(
    private val incomeMap: Map<PlayerColor, Map<ResourceType, Int>>
) :
    RecyclerView.Adapter<IncomeListAdapter.ViewHolder>() {

    private val incomeList = incomeMap.map {
        Pair(
            it.key,
            it.value
        )
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val playerLabel: TextView = view.findViewById(R.id.incomePlayerLabel)
        val brickIncome: TextView = view.findViewById(R.id.brickIncome)
        val woolIncome: TextView = view.findViewById(R.id.woolIncome)
        val lumberIncome: TextView = view.findViewById(R.id.lumberIncome)
        val grainIncome: TextView = view.findViewById(R.id.grainIncome)
        val oreIncome: TextView = view.findViewById(R.id.oreIncome)
        val goldIncome: TextView = view.findViewById(R.id.goldIncome)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.income_list_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        if (position == 0) {
            viewHolder.playerLabel.setText(R.string.player)
            viewHolder.brickIncome.text = "B"
            viewHolder.woolIncome.text = "W"
            viewHolder.lumberIncome.text = "L"
            viewHolder.grainIncome.text = "G"
            viewHolder.oreIncome.text = "O"
            viewHolder.goldIncome.text = "GD"
        } else {
            val listIndex = position - 1
            val incomeData = incomeList[listIndex]
            viewHolder.playerLabel.setText(playerNameMap[incomeData.first]!!)
            viewHolder.playerLabel.setTextColor(playerColorMap[incomeData.first]!!)
            viewHolder.brickIncome.text = incomeData.second[ResourceType.BRICK].toString()
            viewHolder.woolIncome.text = incomeData.second[ResourceType.WOOL].toString()
            viewHolder.lumberIncome.text = incomeData.second[ResourceType.LUMBER].toString()
            viewHolder.grainIncome.text = incomeData.second[ResourceType.GRAIN].toString()
            viewHolder.oreIncome.text = incomeData.second[ResourceType.ORE].toString()
            viewHolder.goldIncome.text = incomeData.second[ResourceType.GOLD].toString()
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = incomeMap.size + 1
}