package com.sarchimarcus.gads_learderboard


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.sarchimarcus.gads_learderboard.learning.LearningFragment
import com.sarchimarcus.gads_learderboard.skills.SkillFragment
import com.sarchimarcus.gads_learderboard.submit.SubmitActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2 = findViewById<ViewPager2>(R.id.pager2_container)
        val fragmentList = arrayListOf(
            LearningFragment.newInstance(),
            SkillFragment.newInstance()

        )
        val fragmentAdapter = FragmentAdapter(supportFragmentManager,lifecycle)

        viewPager2.adapter = fragmentAdapter
        var names:Array<String> = arrayOf("Learning Leaders","Skill IQ Leaders")

        TabLayoutMediator(tabLayout,viewPager2){ tab, position ->
           tab.text = names[position]
        }.attach()

        setSupportActionBar(toolbar)

        /*supportActionBar.apply {
            button.setOnClickListener {
                newActivity()
            }
        }*/



    }
  fun newActivity(view: View){
        startActivity(Intent(this, SubmitActivity::class.java))
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    return super.onCreateOptionsMenu(menu)
}

override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return super.onOptionsItemSelected(item)
}
}

