package br.com.antoniodev.leitordeqrcodedeproduto.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject

@Entity(tableName = "produtos")
data class Produto(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_produto")
    val idProduto: Long?= null,
    @ColumnInfo(name = "nome_produto")
    val nomeProduto: String?= null,
    val preco: Double? = null
){
    fun jsonToProduto(resposta: String): Produto{
        val json = JSONObject(resposta)
        return Produto(
            idProduto = json.getString("idProduto").toLong(),
            nomeProduto = json.getString("produto"),
            preco = json.getDouble("preco"),
        )
    }
}

