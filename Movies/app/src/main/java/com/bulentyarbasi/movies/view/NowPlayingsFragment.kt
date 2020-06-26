package com.bulentyarbasi.movies.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bulentyarbasi.movies.R
import com.bulentyarbasi.movies.service.Retrofit
import com.bulentyarbasi.movies.adapter.Adapter
import com.bulentyarbasi.movies.model.Movie
import com.bulentyarbasi.movies.model.MovieResponse
import com.bulentyarbasi.movies.service.TMDbApi
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NowPlayingsFragment : Fragment() {

    private var movies: List<Movie>? = null
    private var recyclerViewAdapter: Adapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_now_playings.layoutManager = LinearLayoutManager(context)
        if (movies.isNullOrEmpty()) {
            loadData()
        } else {
            recycler_now_playings.adapter = recyclerViewAdapter
            hideLoader()
        }
    }

    private fun loadData() {
        showLoader()
        val service = Retrofit.provideRetrofit().create(TMDbApi::class.java)
        val call = service.getNowPlayings()

        call.enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    movies = response.body()?.results
                    recyclerViewAdapter = Adapter(movies?.toMutableList()!!)
                    recycler_now_playings.adapter = recyclerViewAdapter
                    hideLoader()
                }
            }

        })
    }

    private fun showLoader() {
        progress_circular.visibility = View.VISIBLE
        recycler_now_playings.visibility = View.GONE
    }

    private fun hideLoader() {
        progress_circular.visibility = View.GONE
        recycler_now_playings.visibility = View.VISIBLE

    }

}