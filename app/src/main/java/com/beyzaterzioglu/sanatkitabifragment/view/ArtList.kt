package com.beyzaterzioglu.sanatkitabifragment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.beyzaterzioglu.sanatkitabifragment.adapter.picAdapter
import com.beyzaterzioglu.sanatkitabifragment.databinding.FragmentArtListBinding
import com.beyzaterzioglu.sanatkitabifragment.model.Pic
import com.beyzaterzioglu.sanatkitabifragment.room_db.PicDao
import com.beyzaterzioglu.sanatkitabifragment.room_db.PicDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class ArtList : Fragment() {

    private lateinit var artAdapter : picAdapter
    private var _binding: FragmentArtListBinding? = null
    private val binding get() = _binding!!
    private val mDisposable = CompositeDisposable()
    private lateinit var picDao : PicDao
    private lateinit var picDatabase : PicDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        picDatabase = Room.databaseBuilder(requireContext(), PicDatabase::class.java, "Pics").build()
        picDao = picDatabase.picDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArtListBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getFromSQL()

    }
    fun getFromSQL() {
        mDisposable.add(picDao.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))
    }

    private fun handleResponse(artList: List<Pic>) {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        artAdapter = picAdapter(artList)
        binding.recyclerView.adapter = artAdapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}