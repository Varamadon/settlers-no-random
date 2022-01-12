package me.varam.settlers.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import me.varam.settlers.R
import me.varam.settlers.databinding.FragmentPlayerAddedBinding
import me.varam.settlers.model.Game
import me.varam.settlers.model.PlayerColor

/**
 * A simple [Fragment] subclass.
 * Use the [PlayerAddedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlayerAddedFragment : Fragment() {
    private lateinit var playerColor: PlayerColor

    private lateinit var binding: FragmentPlayerAddedBinding

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
        binding = FragmentPlayerAddedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        preparePlayerLabel()
        val player = Game.getPlayerByColor(playerColor)
        val tilesList = binding.playerAddedTilesList
        tilesList.adapter = TileListAdapter(player.getTiles())

        binding.playerAddedDoneButton.setOnClickListener {
            findNavController().navigate(R.id.action_playerAddedFragment_to_startFragment)
        }

        binding.playerAddedRevertButton.setOnClickListener {
            Game.removePlayerByColor(playerColor)
            findNavController().navigate(R.id.action_playerAddedFragment_to_startFragment)
        }
    }

    private fun preparePlayerLabel() {
        val playerColorLabel = binding.playerAddedLabel
        playerColorLabel.setText(playerNameMap[playerColor]!!)
        playerColorLabel.setTextColor(playerColorMap[playerColor]!!)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param playerColor color of the player, that is being added
         * @return A new instance of fragment PlayerAddedFragment.
         */
        @JvmStatic
        fun newInstance(playerColor: PlayerColor) =
            PlayerAddedFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(PLAYER_COLOR, playerColor)
                }
            }
    }
}