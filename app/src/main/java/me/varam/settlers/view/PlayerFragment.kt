package me.varam.settlers.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import me.varam.settlers.R
import me.varam.settlers.databinding.FragmentPlayerBinding
import me.varam.settlers.model.Game
import me.varam.settlers.model.PlayerColor

/**
 * A simple [Fragment] subclass.
 * Use the [PlayerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlayerFragment : Fragment() {
    private lateinit var playerColor: PlayerColor

    private lateinit var binding: FragmentPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            playerColor = it.get(PLAYER_COLOR) as PlayerColor
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val player = Game.getPlayerByColor(playerColor)
        val tilesList = binding.playerTilesList
        tilesList.adapter = TileListAdapter(player.getTiles())
        preparePlayerLabel()

        binding.playerAddTileButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_playerFragment_to_addTileFragment,
                Bundle().apply {
                    putSerializable(PLAYER_COLOR, playerColor)
                }
            )
        }

        binding.playerBackButton.setOnClickListener {
            navigateBack()
        }
    }

    private fun navigateBack() {
        findNavController().navigate(
            if (Game.isStarted)
                R.id.action_playerFragment_to_mainFragment
            else R.id.action_playerFragment_to_startFragment
        )
    }

    private fun preparePlayerLabel() {
        val playerColorLabel = binding.playerColorLabel
        playerColorLabel.setText(playerNameMap[playerColor]!!)
        playerColorLabel.setTextColor(playerColorMap[playerColor]!!)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param playerColor color of the player, that is displayed
         * @return A new instance of fragment PlayerFragment.
         */
        @JvmStatic
        fun newInstance(playerColor: PlayerColor) =
            PlayerFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(PLAYER_COLOR, playerColor)
                }
            }
    }
}