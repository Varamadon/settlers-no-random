package me.varam.settlers.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import me.varam.settlers.R
import me.varam.settlers.common.validTokenNumbers
import me.varam.settlers.databinding.FragmentAddTileBinding
import me.varam.settlers.model.*


const val PLAYER_COLOR = "playerColor"

/**
 * A simple [Fragment] subclass.
 * Use the [AddTileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddTileFragment : Fragment() {
    private lateinit var playerColor: PlayerColor
    private lateinit var player: Player

    private lateinit var binding: FragmentAddTileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            playerColor = it.get(PLAYER_COLOR) as PlayerColor
        }

        player = Game.getPlayerByColor(playerColor)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddTileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareResourceSelector()
        prepareTokenSelector()
        preparePlayerLabel()

        binding.addTileAddButton.setOnClickListener {
            val selectedResourceType = binding.addTileResourceSelector.selectedItem as ResourceType
            val selectedToken = binding.addTileTokenSelector.selectedItem as Int

            findNavController().navigate(
                R.id.action_addTileFragment_to_tileAddedFragment,
                Bundle().apply {
                    putSerializable(PLAYER_COLOR, playerColor)
                    putSerializable(RESOURCE_ADDED, selectedResourceType)
                    putInt(TOKEN_ADDED, selectedToken)
                }
            )
        }
    }

    private fun preparePlayerLabel() {
        val playerColorLabel = binding.addTilePlayerColorLabel
        playerColorLabel.setText(playerNameMap[playerColor]!!)
        playerColorLabel.setTextColor(playerColorMap[playerColor]!!)
    }

    private fun prepareTokenSelector() {
        val tokenSelectorAdapter = ArrayAdapter(
            this.requireContext(),
            android.R.layout.simple_spinner_item,
            validTokenNumbers
        )
        tokenSelectorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.addTileTokenSelector.adapter = tokenSelectorAdapter
    }

    private fun prepareResourceSelector() {
        val resourceSelectorAdapter = ArrayAdapter(
            this.requireContext(),
            android.R.layout.simple_spinner_item,
            ResourceType.values()
        )
        resourceSelectorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.addTileResourceSelector.adapter = resourceSelectorAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param playerColor color of the player, that tile is being added to
         * @return A new instance of fragment AddTileFragment.
         */
        @JvmStatic
        fun newInstance(playerColor: PlayerColor) =
            AddTileFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(PLAYER_COLOR, playerColor)
                }
            }
    }
}