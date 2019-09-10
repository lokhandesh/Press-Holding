package com.santoshlokhande.pressholding.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.santoshlokhande.pressholding.data.Records
import com.santoshlokhande.pressholding.databinding.RecordItemBinding
import kotlin.collections.ArrayList


/**
 * Created by Santosh Lokhande on 07/9/2019
 *
 * This class is used to display item of Matches.
 *
 * @param View
 *
 * Here we used ViewHolder design pattern
 *
 */

class RecordsAdapter(val applicationContext: Context) : RecyclerView.Adapter<RecordsAdapter.MatchesHolder>() {

    private var recordsList: List<Records> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesHolder {

        val inflator = LayoutInflater.from(parent.context)
        val binding = RecordItemBinding.inflate(inflator, parent, false)

        return MatchesHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchesHolder, position: Int) = holder.bind(recordsList[position])

    override fun getItemCount(): Int = recordsList.size

    fun setRecords(list: List<Records>) {
        this.recordsList = list
        notifyDataSetChanged()
    }

    class MatchesHolder(val binding : RecordItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Records) {

            binding.records = item
            binding.executePendingBindings()

        }

    }

}