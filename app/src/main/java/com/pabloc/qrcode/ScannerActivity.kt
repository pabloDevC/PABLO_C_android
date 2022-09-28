package com.pabloc.qrcode

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.pabloc.qrcode.base.BaseActivity
import com.pabloc.qrcode.databinding.ActivityScannerBinding

class ScannerActivity : BaseActivity() {
    private lateinit var binding: ActivityScannerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScannerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScanner.setOnClickListener { initScanner() }
        binding.btnOrder.setOnClickListener {
            val intent = Intent(this, PasswordActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initScanner(){
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("QR Code.")
        integrator.setTorchEnabled(true)
        integrator.setBeepEnabled(true) //qr인식시 소리
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                setupQRWithoutContent()
            } else {
                setupQRWithContent(result)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun setupQRWithoutContent() {
        binding.linearLayoutContent.visibility = View.GONE
    }

    private fun setupQRWithContent(result: IntentResult) {

        if (result.contents == "serial1111") {
            binding.linearLayoutContent.visibility = View.VISIBLE
            binding.tvContent.text = "잠금 해제"
            Toast.makeText(this@ScannerActivity, "인증 성공", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, BlunoActivity::class.java)
            startActivity(intent)
        }
        else {
            Toast.makeText(this@ScannerActivity, "인증 실패. 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
        }
    }
}