package me.varam.settlers.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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