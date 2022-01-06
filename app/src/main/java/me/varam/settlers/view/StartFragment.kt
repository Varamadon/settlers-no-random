package me.varam.settlers.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import me.varam.settlers.R
import me.varam.settlers.databinding.FragmentStartBinding
import me.varam.settlers.model.Game
import me.varam.settlers.model.Player
import me.varam.settlers.model.PlayerColor

/**
 * A simple [Fragment] subclass.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareAddedPlayersList()

        prepareStartColorSelector()

        binding.startAddPlayerButton.setOnClickListener {
            val selectedColor = binding.startColorSelector.selectedItem as PlayerColor
            Game.addPlayer(Player(selectedColor))
            findNavController().navigate(
                R.id.action_startFragment_to_addTileFragment,
                Bundle().apply {
                    putSerializable(PLAYER_COLOR, selectedColor)
                }
            )
        }

        binding.startGameButton.setOnClickListener {
            Game.startGame()
            findNavController().navigate(R.id.action_startFragment_to_mainFragment)
        }
    }

    private fun prepareAddedPlayersList() {
        val playersList = binding.startAddedPlayersList
        playersList.adapter = PlayerListAdapter(
            Game.getPlayerColors()
        )
    }

    private fun prepareStartColorSelector() {
        val availablePlayerColors = PlayerColor.values().filter {
            !Game.getPlayerColors().contains(it)
        }
        val startColorSelectorAdapter = ArrayAdapter(
            this.requireContext(),
            android.R.layout.simple_spinner_item,
            availablePlayerColors
        )
        startColorSelectorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.startColorSelector.adapter = startColorSelectorAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment StartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            StartFragment().apply {
            }
    }
}