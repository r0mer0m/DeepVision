package com.example.deepvision

import android.Manifest.permission.CAMERA
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class captureAndTag : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var captureButton: Button

    val REQUEST_IMAGE_CAPTURE = 1


    private val PERMISSION_REQUEST_CODE: Int = 101

    private var mCurrentPhotoPath: String? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capture_and_tag)



/**        List of labels part */

        val recyclerView = findViewById<ListView>(R.id.label_list)

        // TODO: Change list to dynamic
        val listItems = arrayOfNulls<String>(4)

        listItems[0] = "Kitchen"
        listItems[1] = "Bed room"
        listItems[2] = "Terrace"
        listItems[3] = "Living room"

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        recyclerView.adapter = adapter

/**        Image part */

        imageView = findViewById(R.id.image_view)
        captureButton = findViewById(R.id.btn_capture)
        captureButton.setOnClickListener(View.OnClickListener {
            if (checkPersmission()) takePicture() else requestPermission()
        })

/**         Buttons*/

        val ok_button = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        val remove_button = findViewById<FloatingActionButton>(R.id.floatingActionButton4)

        ok_button.setOnClickListener {
//            TODO: Check for image and label !
//            TODO: Send Image and label
            this.recreate()
//            Toast.makeText(this, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        remove_button.setOnClickListener {
            this.recreate()
//            Toast.makeText(this, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {

                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

//                    takePicture()

                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
                return
            }

            else -> {

            }
        }
    }


    private fun takePicture() {

        val intent: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val file: File = createFile()

        val uri: Uri = FileProvider.getUriForFile(
            this,
            "com.example.android.fileprovider",
            file
        )
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)

    }

//    private fun takePicture() {
//
//        val intent: Intent = Intent(this, labelSelection::class.java)
////        val file: File = createFile()
////
////        val uri: Uri = FileProvider.getUriForFile(
////            this,
////            "com.example.android.fileprovider",
////            file
////        )
//
//        // TODO: Send the picture or find how to wait to send it all together
//        startActivity(intent)
////        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
//        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
//
//    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {

            //To get the File for further usage
            val auxFile = File(mCurrentPhotoPath)


            var bitmap: Bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath)
            imageView.setImageBitmap(bitmap)

        }
    }

    private fun checkPersmission(): Boolean {
        return (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
            android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(READ_EXTERNAL_STORAGE, CAMERA), PERMISSION_REQUEST_CODE)
    }


    @Throws(IOException::class)
    private fun createFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            mCurrentPhotoPath = absolutePath
        }
    }

}

