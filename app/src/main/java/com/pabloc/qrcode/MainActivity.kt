package com.pabloc.qrcode

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pabloc.qrcode.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

//    val bluetoothAdapter: BluetoothAdapter? by lazy {
//        BluetoothAdapter.getDefaultAdapter()
//    }


//    private val REQUEST_ENABLE_BT = 100
//    private var bluetoothAdapter: BluetoothAdapter? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        val bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
//        bluetoothAdapter = bluetoothManager.adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_menu)
//
        binding.btnOrder.setOnClickListener {
            val intent = Intent(this, OrderlistActivity::class.java)
            startActivity(intent)
        }
//        binding.btnOpen.setOnClickListener {
//            val intent = Intent(this, Thermometer::class.java)
//            startActivity(intent)
//        }
        binding.btnOpen.setOnClickListener {
            val intent = Intent(this, BlunoActivity::class.java)
            startActivity(intent)
        }
    }
}

//        if( bluetoothAdapter == null) {
//            Toast.makeText(this@MainActivity, "단말기는 블루투스를 지원하지 않습니다.", Toast.LENGTH_SHORT).show()
//            finish()
//            return
//        }
//        else (
//                Toast.makeText(this@MainActivity, "지원.", Toast.LENGTH_SHORT).show()
//        )
//        checkBluetoothDevices()
//        btnScan.setOnClickListener {
//            scanDevice()
//        }
//    }
//
//    fun checkBluetoothDevices() {
//        println(bluetoothAdapter)
//        if(bluetoothAdapter!!.isEnabled) {
//
//            stateBluetooth.text ="Bluetooth is Enabled"
//            // 블루투스 장치 검색 버튼 활성화
//            btnScan.isEnabled = true
//            scanDevice()
//        } else {
//
//            stateBluetooth.text = "Bluetooth is Not Enabled!"
//            var enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
//            println("11111111111")
//            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
//            println("22222222222")
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int,data: Intent?) {
//        if(requestCode == REQUEST_ENABLE_BT) {
//            if(resultCode == Activity.RESULT_OK) {
//                // 활성화 요청에 대해 정상적으로 승인을 받음
//                stateBluetooth.text ="Bluetooth is Enabled"
//                Toast.makeText(this@MainActivity, "블루투스가 활성화 되었습니다.", Toast.LENGTH_SHORT).show()
//            } else {
//                stateBluetooth.text ="Bluetooth is Not Enabled"
//                Toast.makeText(this@MainActivity, "블루투스 활성화 요청이 취소되었거나 예외가 발생하였습니다.", Toast.LENGTH_SHORT).show()
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data)
//    }
//
//    fun scanDevice() {
//        // 페어링되어 있는 디바이스 집합 추출
//        val devices = bluetoothAdapter!!.bondedDevices
//        if (devices.size == 0) {
//            stateBluetooth.text = "연결된 블루투스가 장비가 없습니다."
//        } else {
//            stateBluetooth.text = "페어링 블루투스 장비(${devices.size}개)"
////            val adapter = DeviceAdapter(devices.toList(), ::onIemClick)
////            listDevice.adapter = adapter
//        }
//    }
//    fun onIemClick(device: BluetoothDevice) {
////        startActivity<BluetoothActivity>("device" to device)
//        // toast("${device.name} 선택")
//    }

