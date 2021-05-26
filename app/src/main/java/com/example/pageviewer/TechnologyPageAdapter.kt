package com.example.pageviewer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class TechnologyPageAdapter(
    private val items: MutableList<Technology>,
    private val show: (Int) -> Unit
) : PagerAdapter() {

    override fun getCount() = items.size

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val page = LayoutInflater.from(container.context).inflate(R.layout.page_layout, container, false)
        page.findViewById<TextView>(R.id.tvTitle).text = items[position].title
        page.findViewById<TextView>(R.id.tvDescription).text = items[position].description
        val btn = page.findViewById<ImageButton>(R.id.imgPage)
        btn.setBackgroundResource(items[position].image)
        btn.setOnClickListener {
            show(position)
        }
        container.addView(page)
        return page
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}