package org.hema995.workinspector

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import org.hema995.workinspector.databinding.WiActivityWorkInspectorBinding

public class WorkInspectorActivity : AppCompatActivity() {
    private lateinit var binding: WiActivityWorkInspectorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        binding = WiActivityWorkInspectorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            android.R.id.home -> {
                finishAfterTransition()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
}
