package br.com.antoniodev.leitordeqrcodedeproduto

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.antoniodev.leitordeqrcodedeproduto.databinding.ActivityMainBinding
import br.com.antoniodev.leitordeqrcodedeproduto.model.Produto
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var codeScanner: CodeScanner
    private var produto: Produto? = null

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ granted ->
          if(granted){
                Toast.makeText(this, "Permissão concedida", Toast.LENGTH_SHORT).show()
                //leitor de qrcode
          }else{
              Toast.makeText(this, "Essa permissão é obrigatória para o funcionamento deste app . . .", Toast.LENGTH_SHORT).show()
              //requisitarPermissoes( this )
          }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        requisitarPermissoes(this)
        lerQrCode()

        binding.btScanner.setOnClickListener {
              codeScanner.startPreview()
        }

        binding.btParaScanner.setOnClickListener {
             codeScanner.stopPreview()
        }


        binding.btSalvar.setOnClickListener {
            if (produto != null) {
                Toast.makeText(this, "Produto salvo: ${produto!!.nomeProduto}", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Erro ao tentar salvar o produto.", Toast.LENGTH_SHORT) .show()
            }
        }

    }


    private fun requisitarPermissoes(context: Context) {

        if(ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            //solicitar permissao
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }else{
            //leitor de qrcode
            Toast.makeText(this, "Lendo o qrcode", Toast.LENGTH_SHORT).show()
        }

    }

    private fun lerQrCode(){
          codeScanner = CodeScanner(this@MainActivity, binding.scannerView).apply {
                    camera = CodeScanner.CAMERA_BACK
                    formats = CodeScanner.ALL_FORMATS
                    autoFocusMode = AutoFocusMode.SAFE
                    isAutoFocusEnabled = true
                    isFlashEnabled = false

                    decodeCallback = DecodeCallback { produtoScanner ->
                        runOnUiThread {
                            //binding.tvRespostaScanner.text = produtoScanner.toString()
                            produto = Produto().jsonToProduto( produtoScanner.toString())
                            binding.tvRespostaScanner.text = "IdProduto: ${produto?.idProduto} \nProduto: ${produto?.nomeProduto} \nPreço: ${produto?.preco} "
                        }
                    }


                    errorCallback = ErrorCallback{ erro ->
                        runOnUiThread {
                            binding.tvRespostaScanner.text = erro.message
                        }
                    }

          }

    }
}