package com.bawonelson.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.bawonelson.tablayout.adapters.TabViewPagerAdapter
import com.bawonelson.tablayout.fragment.FavouritesFragment
import com.bawonelson.tablayout.fragment.HomeFragment
import com.bawonelson.tablayout.fragment.ProfileFragment
import com.bawonelson.tablayout.fragment.SettingsFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // INITIALIZING THE VIEWS
        viewPager = findViewById(R.id.tab_view_pager)
        tabs = findViewById(R.id.tab_layout)

        setUpTab()
    }
    private fun setUpTab(){
        val adapter = TabViewPagerAdapter(supportFragmentManager)

        // ADD FRAGMENTS TO ADAPTER
        adapter.addFragment(HomeFragment(),"Home")
        adapter.addFragment(FavouritesFragment(),"Favourites")
        adapter.addFragment(SettingsFragment(),"Setting")
        adapter.addFragment(ProfileFragment(),"Profile")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        // SET TAB ICONS
        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_favorite_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_settings_24)
        tabs.getTabAt(3)!!.setIcon(R.drawable.ic_baseline_person_24)
    }
}