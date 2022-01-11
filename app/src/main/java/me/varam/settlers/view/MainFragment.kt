package me.varam.settlers.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import me.varam.settlers.R
import me.varam.settlers.databinding.FragmentMainBinding
import me.varam.settlers.model.Game

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

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
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val playersList = binding.mainPlayersList
        playersList.adapter = PlayerListAdapter(
            Game.getPlayerColors()
        ) {
            findNavController().navigate(
                R.id.action_mainFragment_to_playerFragment,
                Bundle().apply {
                    putSerializable(PLAYER_COLOR, it)
                }
            )
        }

        binding.nextTurnButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_incomeFragment)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment MainFragment.
         */
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}