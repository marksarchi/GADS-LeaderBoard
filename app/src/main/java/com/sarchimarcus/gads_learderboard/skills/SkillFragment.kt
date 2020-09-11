package com.sarchimarcus.gads_learderboard.skills

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.sarchimarcus.gads_learderboard.R
import com.sarchimarcus.gads_learderboard.databinding.FragmentSkillBinding
import com.sarchimarcus.gads_learderboard.repository.LeaderRepository

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SkillFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SkillFragment : Fragment() {
    private  val repository = LeaderRepository()
    private  val factory = SkillViewModelFactory(repository)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSkillBinding.inflate(inflater)
        val viewModel = ViewModelProvider(this,factory).get(SkillViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        binding.skillRecyclerView.adapter = SkillAdapter()
        return  binding.root

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            SkillFragment()
    }
}
