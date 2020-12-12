package com.example.madlevel6task2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_movie_item.view.*

class MovieAdapter(var arrayList: ArrayList<Movie>, var context: Context ) : BaseAdapter() {

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = convertView
        if(view == null) {
            view = layoutInflater.inflate(R.layout.card_movie_item, parent,  false)
        }

        //TODO !! weghalen
        val number: TextView = view!!.findViewById(R.id.tvMovieNumber)
        val listItem : Movie = arrayList[position]

        // fill poster and number
        Glide.with(context).load(listItem.poster).into(view.ivMovie)
        number.text = (position+1).toString()

//        val view: View = View.inflate(context, R.layout.card_movie_item, null)

//        Glide.with(context).load(listItem.getImageUrl()).into(view.ivMovie)

        return view
    }

}