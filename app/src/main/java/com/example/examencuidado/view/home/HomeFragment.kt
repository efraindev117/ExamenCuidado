package com.example.examencuidado.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examencuidado.R
import com.example.examencuidado.databinding.FragmentHomeBinding
import com.example.examencuidado.model.data.GitResponseUserItem
import com.example.examencuidado.view.home.adapter.AdapterUser
import com.example.examencuidado.view.home.adapter.OnMyClick
import com.example.examencuidado.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), OnMyClick {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    //ViewModel
    private val mViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Git Users"
        setupAdapter()
    }

    private fun setupAdapter() {
        mViewModel.getDataCallBackGitResponse().observe(viewLifecycleOwner){
            binding.recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@HomeFragment.context)
                adapter = AdapterUser(it,this@HomeFragment)
            }
        }
    }

    override fun myClickGitDetails(git: GitResponseUserItem){
        Toast.makeText(this.context, git.login, Toast.LENGTH_SHORT).show()
        val bundle = Bundle()
        bundle.putParcelable("detailGitUser",git)
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment,bundle)
    }

}
