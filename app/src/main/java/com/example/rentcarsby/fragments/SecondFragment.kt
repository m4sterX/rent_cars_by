package com.example.rentcarsby.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.rentcarsby.R
import com.example.rentcarsby.data_base.entity.CarEntity


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var car: CarEntity? = requireArguments().getParcelable<CarEntity>("car")

        var description: String? = car?.description
        var name: String? = car?.name
        var price: Double? = car?.price
        var prewievImg: Int? = car?.previewImage

        val descrView = view.findViewById<TextView>(R.id.secondFrag_car_name_tv)
        val nameView = view.findViewById<TextView>(R.id.textview_car_name)
        val priceView = view.findViewById<TextView>(R.id.second_frag_price)
        val imgView = view.findViewById<ImageView>(R.id.imageview_preview)

        descrView.text = description
        nameView.text = name
        priceView.text = price.toString()
        if (prewievImg != null) {
            imgView.setImageResource(prewievImg)
        }
    }
}