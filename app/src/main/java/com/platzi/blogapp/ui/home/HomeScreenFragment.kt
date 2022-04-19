package com.platzi.blogapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.firebase.Timestamp
import com.platzi.blogapp.R
import com.platzi.blogapp.data.model.Post
import com.platzi.blogapp.databinding.FragmentHomeScreenBinding
import com.platzi.blogapp.ui.home.adapter.HomeScreenAdapter


class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {

    private lateinit var binding: FragmentHomeScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)

        val postList = listOf(
            Post(
                "https://process.filestackapi.com/cache=expiry:max/resize=width:320/mrFuqDcrT3mXeujn6eEN",
                "Gaston Saillen", Timestamp.now(), "https://pbs.twimg.com/media/EkSsEFkXgAIftCu.jpg"
            ),
            Post(
                "https://process.filestackapi.com/cache=expiry:max/resize=width:320/mrFuqDcrT3mXeujn6eEN",
                "Fabrizio Vitorino Monjaras", Timestamp.now(),
                "https://scontent.faqp2-2.fna.fbcdn.net/v/t39.30808-6/273827573_2535831859884087_4021531654100746642_n.jpg?_nc_cat=102&ccb=1-5&_nc_sid=09cbfe&_nc_eui2=AeEFPhbxZ6f9Hlo6rN2H4zRSD8fiObAAQooPx-I5sABCimNFJ85GDIiT4hcS2xlxmst-qIZxuEZgiY-5RIJXONsO&_nc_ohc=FfTEx5LWDwcAX8-32Ey&_nc_ht=scontent.faqp2-2.fna&oh=00_AT_Oq8X3M7mtozva-RUCdPwnUCB5uUPGNKcaWDsGwN5oQQ&oe=6262FD8D"
            ),
            Post(
                "https://process.filestackapi.com/cache=expiry:max/resize=width:320/mrFuqDcrT3mXeujn6eEN",
                "Gaston Saillen", Timestamp.now(), "https://pbs.twimg.com/media/EkSsEFkXgAIftCu.jpg"
            )
        )

         binding.rvHome.adapter = HomeScreenAdapter(postList)


    }
}