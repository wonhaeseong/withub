package com.example.withub.mainFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.daimajia.swipe.SwipeLayout
import com.example.withub.R
import com.example.withub.com.example.withub.MainActivity
import com.example.withub.mainFragments.mainAdapter.ExpandableRVAdapter
import com.example.withub.mainFragments.mainAdapter.FriendRankingData

class RankingAreaFragment : Fragment() {
    lateinit var mainActivity: MainActivity
    lateinit var recyclerView : RecyclerView
    lateinit var expandableAdapter : ExpandableRVAdapter
    val rankingDataList : ArrayList<ArrayList<FriendRankingData>> = arrayListOf(
        arrayListOf(
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3)
        ),
        arrayListOf(
            FriendRankingData("문승재",3),
            FriendRankingData("문승재",3),
            FriendRankingData("문승재",3),
            FriendRankingData("문승재",3),
            FriendRankingData("문승재",3),
            FriendRankingData("문승재",3),
            FriendRankingData("문승재",3),
            FriendRankingData("문승재",3),
            FriendRankingData("문승재",3),
            FriendRankingData("문승재",3)
        ),
        arrayListOf(
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3)
        ),
        arrayListOf(
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3),
            FriendRankingData("원해성",3)
        ))
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.ranking_area_fragment,container,false)
        mainActivity = activity as MainActivity

        val swipeRefreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.ranking_area_swipe_refresh_layout)
        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            Toast.makeText(mainActivity,"업데이트 완료",Toast.LENGTH_SHORT).show()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        expandableAdapter = ExpandableRVAdapter(rankingDataList)
        recyclerView = view.findViewById<RecyclerView>(R.id.ranking_area_recycler_view)
        recyclerView.adapter = expandableAdapter
        recyclerView.setHasFixedSize(true)
    }
}