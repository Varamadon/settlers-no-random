package me.varam.settlers.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.varam.settlers.R
import me.varam.settlers.model.Game
import me.varam.settlers.model.Player
import me.varam.settlers.model.PlayerColor

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val PLAYER_COLOR = "playerColor"

/**
 * A simple [Fragment] subclass.
 * Use the [AddTileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddTileFragment : Fragment() {
    private lateinit var playerColor: PlayerColor
    private lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            playerColor = it.get(PLAYER_COLOR) as PlayerColor
        }
        player = Game.getPlayerByColor(playerColor)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_tile, container, false)
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