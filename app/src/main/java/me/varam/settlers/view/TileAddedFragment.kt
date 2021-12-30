package me.varam.settlers.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import me.varam.settlers.R
import me.varam.settlers.databinding.FragmentTileAddedBinding
import me.varam.settlers.model.Game
import me.varam.settlers.model.PlayerColor
import me.varam.settlers.model.ResourceType
import me.varam.settlers.model.Tile

const val RESOURCE_ADDED = "resourceAdded"
const val TOKEN_ADDED = "tokenAdded"

/**
 * A simple [Fragment] subclass.
 * Use the [TileAddedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TileAddedFragment : Fragment() {
    private lateinit var playerColor: PlayerColor
    private lateinit var resourceAdded: ResourceType
    private var tokenAdded: Int = -1

    private lateinit var binding: FragmentTileAddedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            playerColor = it.get(PLAYER_COLOR) as PlayerColor
            resourceAdded = it.get(RESOURCE_ADDED) as ResourceType
            tokenAdded = it.getInt(TOKEN_ADDED)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTileAddedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preparePlayerLabel()
        binding.tileAddedTokenValue.text = tokenAdded.toString()
        binding.tileAddedResourceValue.text = resourceAdded.toString()

        binding.tileAddedRevertButton.setOnClickListener {
            navigateBack()
        }
        binding.tileAddedDoneButton.setOnClickListener {
            doAddTile()
            navigateBack()
        }
        binding.tileAddedOneMoreButton.setOnClickListener {
            doAddTile()
            findNavController().navigate(
                R.id.action_tileAddedFragment_to_addTileFragment
            )
        }
    }

    private fun navigateBack() {
        findNavController().navigate(
            if (Game.isStarted)
                R.id.action_tileAddedFragment_to_playerFragment
            else R.id.action_tileAddedFragment_to_playerAddedFragment
        )
    }

    private fun doAddTile() {
        Game.getPlayerByColor(playerColor).addTile(Tile(resourceAdded, tokenAdded))
    }

    private fun preparePlayerLabel() {
        val playerColorLabel = binding.addedTilePlayerColorLabel
        playerColorLabel.setText(playerNameMap[playerColor]!!)
        playerColorLabel.setTextColor(playerColorMap[playerColor]!!)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param playerColor color of the player, that tile was added to
         * @param resourceAdded resource of the tile, that was added
         * @param tokenAdded token of the tile, that was added
         * @return A new instance of fragment TileAddedFragment.
         */
        @JvmStatic
        fun newInstance(
            playerColor: PlayerColor,
            resourceAdded: ResourceType,
            tokenAdded: Int
        ) =
            TileAddedFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(PLAYER_COLOR, playerColor)
                    putSerializable(RESOURCE_ADDED, resourceAdded)
                    putInt(TOKEN_ADDED, tokenAdded)
                }
            }
    }
}