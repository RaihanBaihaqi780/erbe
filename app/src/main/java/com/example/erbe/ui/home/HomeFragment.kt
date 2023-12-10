package com.example.erbe.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.erbe.databinding.FragmentHomeBinding
import com.example.erbe.remote.response.Result
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {
    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding
    private val viewModel: HomeViewModel by inject()
    private var list: List<Result> = listOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        init()
        observeData()
        return binding.root
    }
    private fun observeData(){
        with(viewModel){
            observeGames.observe(requireActivity()){
                it.let { data ->
                    list = data.body()?.results ?: listOf()
                    with(binding.gameList){
                        adapter = HomeAdapter(list)
                        Log.d("home", "adapter:$adapter")
                        layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
        }
    }
    private fun init(){
        viewModel.getGame()
    }
}