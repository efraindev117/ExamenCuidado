package com.example.examencuidado.view.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.examencuidado.databinding.FragmentDetailBinding
import com.example.examencuidado.model.data.GitResponseUserItem


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var gitDetailFragment: GitResponseUserItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):View?{
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        requireArguments().let {
            gitDetailFragment = it.getParcelable("detailGitUser")!!
            //los datos estan pasando
            Log.d("detalles de los usuarios", "$gitDetailFragment")
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = gitDetailFragment.login
        binding.ivUserDetail.load(gitDetailFragment.avatar_url) {
            binding.tvNameDetail.text = gitDetailFragment.login

        }
    }
}