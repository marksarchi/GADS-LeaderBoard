package com.sarchimarcus.gads_learderboard.learning

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sarchimarcus.gads_learderboard.R
import com.sarchimarcus.gads_learderboard.databinding.FragmentLearningBinding
import com.sarchimarcus.gads_learderboard.repository.LeaderRepository
import kotlinx.android.synthetic.main.fragment_learning.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LearningFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LearningFragment : Fragment() {
    private  val leaderRepository = LeaderRepository()
    private val factory = LearningViewModelFactory(leaderRepository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val binding = FragmentLearningBinding.inflate(inflater)
        val viewModel = ViewModelProvider(this,factory).get(LearningViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        binding.recyclerView.adapter = LearnersAdapter()


        return  binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            LearningFragment()

    }
}
