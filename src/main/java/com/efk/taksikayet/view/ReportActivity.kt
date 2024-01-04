package com.efk.taksikayet.view

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.efk.taksikayet.R
import com.efk.taksikayet.databinding.ActivityReportBinding
import com.google.android.material.snackbar.Snackbar

class ReportActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityReportBinding
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var permissionLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        registerLauncher()
    }

    fun firstCall(view: View) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                Snackbar.make(view, "Arama yapabilme izni verilsin mi?", Snackbar.LENGTH_INDEFINITE).setAction("İzin Ver") {
                    permissionLauncher.launch(Manifest.permission.CALL_PHONE)
                }.show()
            } else {
                permissionLauncher.launch(Manifest.permission.CALL_PHONE)
            }
        } else {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:153")
            startActivity(intent)
        }
    }

    fun secondCall(view: View) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                Snackbar.make(view, "Arama yapabilme izni verilsin mi?", Snackbar.LENGTH_INDEFINITE).setAction("İzin Ver") {
                    permissionLauncher.launch(Manifest.permission.CALL_PHONE)
                }.show()
            } else {
                permissionLauncher.launch(Manifest.permission.CALL_PHONE)
            }
        } else {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:2121530000")
            startActivity(intent)
        }
    }

    // registerLauncher fonksiyonuna ekleyin
    private fun registerLauncher() {
        // Diğer launcher kayıtlarını buraya ekleyin (selectImage ve registerLauncher gibi)

        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
            if (result) {
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:2121530000")
                startActivity(intent)
            } else {
                Toast.makeText(this@ReportActivity, "Arama yapabilmek için izin vermelisin!", Toast.LENGTH_LONG).show()
            }
        }
    }

}