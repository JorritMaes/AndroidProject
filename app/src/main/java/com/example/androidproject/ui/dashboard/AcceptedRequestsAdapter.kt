package com.example.androidproject.ui.dashboard

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R
import com.example.androidproject.entities.Event
import java.util.*
import kotlin.collections.ArrayList

// Recyclerview usage : https://www.youtube.com/watch?v=UbP8E6I91NA

class AcceptedRequestsAdapter (private  val  requestsList: ArrayList<Event>) :
    RecyclerView.Adapter<AcceptedRequestsAdapter.AcceptedRequestsViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcceptedRequestsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.event_list_item, parent,false)
        return AcceptedRequestsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AcceptedRequestsViewHolder, position: Int) {
        val currentItem = requestsList[position]
        holder.title.text = currentItem.title
        holder.host.text = currentItem.host.username
        var datestring = SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH)
        holder.startDate.text = datestring.format(currentItem.startDate)
        holder.endDate.text = datestring.format(currentItem.endDate)
    }

    override fun getItemCount(): Int {
        return requestsList.size
    }
    class AcceptedRequestsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val host : TextView = itemView.findViewById(R.id.dashboard_accepted_notification_label_host)
        val title : TextView = itemView.findViewById(R.id.dashboard_accepted_notification_event_title)
        val startDate : TextView  = itemView.findViewById(R.id.dashboard_accepted_notification_label_start_date)
        val endDate : TextView  = itemView.findViewById(R.id.dashboard_accepted_notification_label_end_date)

    }
}