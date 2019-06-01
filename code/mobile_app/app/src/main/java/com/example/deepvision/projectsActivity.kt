package com.example.deepvision

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter
import android.widget.ListView

import kotlinx.android.synthetic.main.activity_projects.*

private lateinit var listView: ListView


class projectsActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_PROJECT = "com.example.DeepVision.PROJECT"

        fun newIntent(context: Context, id: String): Intent {

            val detailIntent = Intent(context, projectMenuActivity::class.java)


            detailIntent.putExtra(EXTRA_PROJECT, id)

            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        listView = findViewById<ListView>(R.id.projects)

        // TODO: When JSON is available
// 1
//        val recipeList = Recipe.getRecipesFromFile("recipes.json", this)
//// 2
//        val listItems = arrayOfNulls<String>(recipeList.size)
//// 3
//        for (i in 0 until recipeList.size) {
//            val recipe = recipeList[i]
//            listItems[i] = recipe.title
//        }

        // TODO: While JSON is not available...

        val listItems = arrayOfNulls<String>(3)

        listItems[0] = "Identify part of the house"
        listItems[1] = "Identify good coffe grains"
        listItems[2] = "Separate amazing from ordinal Mangos"

// 4
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter


        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            // 1
            val selectedProject = listItems[position]


            // TODO: extract project id from selectedProject
            val id = "42"
            // 2
            val detailIntent = projectsActivity.newIntent(context, id)

            // 3
            startActivity(detailIntent)
        }



//        listView.onItemClickListener{
//            val intent = Intent(this, projectMenuActivity::class.java).apply {
//                //TODO: send the project ID of the clicked project
//                putExtra(EXTRA_PROJECT, "projectID")
//            }
//            startActivity(intent)
//        }
    }

}
