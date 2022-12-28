package com.example.androidproject.ui.dashboard

import User
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.androidproject.MainActivity
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentDashboardBinding
import com.example.androidproject.entities.Event
import java.util.Date

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // vars for acceptrequest recycleViewer
    private lateinit var accReqRecycleView :RecyclerView
    private lateinit var pendReqRecycleview : RecyclerView
    private var accReqList: ArrayList<Event> = ArrayList<Event>()
    lateinit var temp_hosts : ArrayList<String>
    lateinit var temp_title : ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        temp_hosts = arrayListOf(
            "Lorem",
            "ipsum,",
            "dolor",
            "sit",
            "amet",
            "consectetur",
            "adipiscing",
            "elit",
            "sed",
            "do",
            "eiusmod",
            "tempor",
            "incididunt",
            "ut",
            "labore",
            "et",
            "dolore",
            )

        temp_title = arrayListOf(
            "ipsum,",
            "dolor",
            "sit",
            "amet",
            "consectetur",
            "adipiscing",
            "elit",
            "sed",
            "do",
            "eiusmod",
            "tempor",
            "incididunt",
            "ut",
            "labore",
            "et",
            "dolore",
            "magna",
            )

        for (i in temp_title.indices){
            accReqList.add(Event( Date(),Date(),temp_title[i], User(temp_hosts[i])))
        }

        accReqRecycleView =root.findViewById(R.id.dashboard_recycleviewer_requests_accepted)
        accReqRecycleView.layoutManager  = LinearLayoutManager(null)
        accReqRecycleView.adapter = AcceptedRequestsAdapter(accReqList)

        pendReqRecycleview = root.findViewById(R.id.dashboard_recycleviewer_requests_pending)
        pendReqRecycleview.layoutManager = LinearLayoutManager(null)
        pendReqRecycleview.adapter = PendingRequestsAdapter(accReqList)


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}